package com.example.addressbook.commands

import com.example.addressbook.Address
import com.example.addressbook.Person
import com.example.addressbook.PersonId
import com.example.addressbook.repo.AddressRepo
import com.example.addressbook.repo.PersonAddressRepo
import com.example.addressbook.repo.PersonRepo
import com.example.addressbook.requests.AddPersonRequest
import com.example.addressbook.requests.AddressRequest
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

class AddPersonCommand(
    private val storage: PersonStorage,
    private val request: AddPersonRequest
): Command {
    override fun execute(): PersonResponse {
        val person = request.toPerson()
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
            addresses = addressesResponse
        )
    }
}

class UpdatePersonCommand(
    private val storage: PersonStorage,
    private val request: UpdatePersonRequest
) : Command {
    override fun execute(): PersonResponse {
        val person = request.toPerson()

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
        val addressIds = PersonAddressRepo.getAllAddressIdsByPersonId(person.id)
        val addresses = addressIds.map {
            AddressRepo.fetchAddress(it).toAddressResponse()
        }
        return PersonResponse(
            id = person.id,
            firstName = person.firstName,
            lastName = person.lastName,
            addresses = addresses
        )
    }
}



