package com.example.addressbook.commands

import PhoneNumberResponses
import com.example.addressbook.Address
import com.example.addressbook.Person
import com.example.addressbook.PersonId
import com.example.addressbook.PhoneNumber
import com.example.addressbook.repo.*
import com.example.addressbook.requests.AddPersonRequest
import com.example.addressbook.requests.AddressRequest
import com.example.addressbook.requests.PhoneNumberRequest
import com.example.addressbook.requests.UpdatePersonRequest
import com.example.addressbook.responses.AddressResponses
import com.example.addressbook.responses.PersonResponse
import com.example.addressbook.storages.PersonStorage
import java.util.*

fun AddPersonRequest.toPerson() =
    Person(
        id = UUID.randomUUID(),
        firstName = this@toPerson.firstName,
        lastName = this@toPerson.lastName
    )


fun UpdatePersonRequest.toPerson() =
    Person(
        id = this@toPerson.id,
        firstName = this@toPerson.firstName,
        lastName = this@toPerson.lastName
    )

fun AddressRequest.toAddress() =
    Address(
        id = UUID.randomUUID(),
        type = this@toAddress.type,
        addressLine1 = this@toAddress.addressLine1,
        addressLine2 = this@toAddress.addressLine2,
        city = this@toAddress.city,
        state = this@toAddress.state,
        zipcode = this@toAddress.zipcode
    )

fun Address.toAddressResponse() =
    AddressResponses(
        id = this@toAddressResponse.id,
        type = this@toAddressResponse.type,
        addressLine1 = this@toAddressResponse.addressLine1,
        addressLine2 = this@toAddressResponse.addressLine2,
        city = this@toAddressResponse.city,
        state = this@toAddressResponse.state,
        zipcode = this@toAddressResponse.zipcode
    )

fun PhoneNumberRequest.toPhoneNumber() =
    PhoneNumber(
        id = UUID.randomUUID(),
        type = this@toPhoneNumber.type,
        phone = this@toPhoneNumber.phone,
    )

fun PhoneNumber.toPhoneNumberResponse() =
    PhoneNumberResponses(
        id = this@toPhoneNumberResponse.id,
        type = this@toPhoneNumberResponse.type,
        phone= this@toPhoneNumberResponse.phone,
    )

class AddPersonCommand(
    private val storage: PersonStorage,
    private val request: AddPersonRequest
): Command {
    override fun execute(): PersonResponse {
        val person = request.toPerson()
        val phoneNumbersResponse = request.phoneNumbers.map { phoneNumberRequest ->
            val phoneNumber = phoneNumberRequest.toPhoneNumber()
            PersonPhoneNumberRepo.mapPersonWithPhoneNumber(person.id, phoneNumber.id)
            PhoneNumberRepo.addPhoneNumber(phoneNumber).toPhoneNumberResponse()
        }
        val addressesResponse = request.addresses.map { addressRequest ->
            val address = addressRequest.toAddress()
            PersonAddressRepo.mapPersonWithAddress(person.id, address.id)
            AddressRepo.addAddress(address).toAddressResponse()
        }

        val personDetail = PersonRepo.addPerson(storage, person)

        return PersonResponse(
            id = personDetail.id,
            firstName = personDetail.firstName,
            lastName = personDetail.lastName,
            phoneNumbers = phoneNumbersResponse,
            addresses = addressesResponse,
        )
    }
}

class UpdatePersonCommand(
    private val storage: PersonStorage,
    private val request: UpdatePersonRequest
) : Command {
    override fun execute(): PersonResponse {
        val person = request.toPerson()

        PersonPhoneNumberRepo.removeAllPhoneNumberByPersonId(person.id)
        val phoneNumberIdsTobeRemoved = PersonPhoneNumberRepo.getAllPhoneNumberIdsByPersonId(person.id)
        phoneNumberIdsTobeRemoved.forEach {
            PhoneNumberRepo.removePhoneNumber(it)
        }

        val phoneNumbersResponse = request.phoneNumbers.map { phoneNumberRequest ->
            val phoneNumber = phoneNumberRequest.toPhoneNumber()
            PersonPhoneNumberRepo.mapPersonWithPhoneNumber(person.id, phoneNumber.id)
            PhoneNumberRepo.addPhoneNumber(phoneNumber).toPhoneNumberResponse()
        }

        PersonAddressRepo.removeAllAddressByPersonId(person.id)
        val addressIdsTobeRemoved = PersonAddressRepo.getAllAddressIdsByPersonId(person.id)
        addressIdsTobeRemoved.forEach {
            AddressRepo.removeAddress(it)
        }


        val addressesResponse = request.addresses.map { addressRequest ->
            val address = addressRequest.toAddress()
            PersonAddressRepo.mapPersonWithAddress(person.id, address.id)
            AddressRepo.addAddress(address).toAddressResponse()
        }


        val personDetail = PersonRepo.updatePerson(storage, person)
        return PersonResponse(
            id = personDetail.id,
            firstName = personDetail.firstName,
            lastName = personDetail.lastName,
            phoneNumbers = phoneNumbersResponse,
            addresses = addressesResponse
        )
    }
}

class FetchPersonCommand(
    private val storage: PersonStorage,
    private val personId: PersonId
) : Command {
    override fun execute(): PersonResponse {
        val person = PersonRepo.fetchPerson(storage, personId)
        val phoneNumberIds = PersonPhoneNumberRepo.getAllPhoneNumberIdsByPersonId(person.id)
        val addressIds = PersonAddressRepo.getAllAddressIdsByPersonId(person.id)

        val phoneNumbers = phoneNumberIds.map {
            PhoneNumberRepo.fetchPhoneNumber(it).toPhoneNumberResponse()
        }

        val addresses = addressIds.map {
            AddressRepo.fetchAddress(it).toAddressResponse()
        }

        return PersonResponse(
            id = person.id,
            firstName = person.firstName,
            lastName = person.lastName,
            phoneNumbers= phoneNumbers,
            addresses = addresses
        )
    }
}



