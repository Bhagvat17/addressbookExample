package com.example.addressbook

import com.example.addressbook.commands.AddPersonCommand
import com.example.addressbook.commands.FetchPersonCommand
import com.example.addressbook.commands.UpdatePersonCommand
import com.example.addressbook.storages.PersonInMemoryStorage
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `create person`(): Unit {
        val storage = PersonInMemoryStorage()

        val personCreateRequest = getPersonCreateRequest()
        val commandAddPerson = AddPersonCommand(storage, personCreateRequest)
        val personResponse = commandAddPerson.execute()

        Assertions.assertEquals("BhagvatSinh", personResponse.firstName)
        Assertions.assertEquals("Jadeja", personResponse.lastName)
        Assertions.assertTrue(personResponse.addresses.size == 1)
        val phoneNumber = personResponse.phoneNumbers.first()
        Assertions.assertEquals("99999999",phoneNumber.phone)
        Assertions.assertTrue(personResponse.emails.size == 0)
        Assertions.assertTrue(personResponse.groups.size == 0)

        val address = personResponse.addresses.first()

        Assertions.assertEquals("B-308", address.addressLine1)
        Assertions.assertEquals("Some complex", address.addressLine2)
        Assertions.assertEquals("Vadodara", address.city)
        Assertions.assertEquals("Gujarat", address.state)
        Assertions.assertEquals("385421", address.zipcode)
    }

    @Test
    fun `update person`(): Unit {
        val storage = PersonInMemoryStorage()

        val personCreateRequest = getPersonCreateRequest()
        val commandAddPerson = AddPersonCommand(storage, personCreateRequest)
        val personResponse = commandAddPerson.execute()

        val personUpdateRequest = getPersonUpdateRequest(personResponse.id)
        val cmdUpdatePerson = UpdatePersonCommand(storage, personUpdateRequest)
        val updatedPersonResponse = cmdUpdatePerson.execute()

        Assertions.assertEquals("BhagvatSinh_UPDATED", updatedPersonResponse.firstName)
        Assertions.assertEquals("Jadeja_UPDATED", updatedPersonResponse.lastName)
        Assertions.assertTrue(updatedPersonResponse.phoneNumbers.size==2)
        Assertions.assertTrue(updatedPersonResponse.addresses.size == 1)
        Assertions.assertTrue(updatedPersonResponse.emails.size == 1)
        Assertions.assertTrue(updatedPersonResponse.groups.size == 2)

        val phoneNumber = updatedPersonResponse.phoneNumbers.first()
        Assertions.assertEquals("99999999",phoneNumber.phone)


        val address = updatedPersonResponse.addresses.first()

        Assertions.assertEquals("B-308_UPDATED", address.addressLine1)
        Assertions.assertEquals("Some complex_UPDATED", address.addressLine2)
        Assertions.assertEquals("Vadodara_UPDATED", address.city)
        Assertions.assertEquals("Gujarat_UPDATED", address.state)
        Assertions.assertEquals("385421_UPDATED", address.zipcode)

        val cmdFetchPerson = FetchPersonCommand(storage, updatedPersonResponse.id)
        val fetchedPerson = cmdFetchPerson.execute()

        Assertions.assertEquals("BhagvatSinh_UPDATED", fetchedPerson.firstName)
        Assertions.assertEquals("Jadeja_UPDATED", fetchedPerson.lastName)
        Assertions.assertEquals(1, fetchedPerson.addresses.size)

        val fetchedAddress = fetchedPerson.addresses.first()

        Assertions.assertEquals("B-308_UPDATED", fetchedAddress.addressLine1)
        Assertions.assertEquals("Some complex_UPDATED", fetchedAddress.addressLine2)
        Assertions.assertEquals("Vadodara_UPDATED", fetchedAddress.city)
        Assertions.assertEquals("Gujarat_UPDATED", fetchedAddress.state)
        Assertions.assertEquals("385421_UPDATED", fetchedAddress.zipcode)
    }


    @Test
    fun `fetch person`(): Unit {
        val storage = PersonInMemoryStorage()

        val personCreateRequest = getPersonCreateRequest()
        val commandAddPerson = AddPersonCommand(storage, personCreateRequest)
        val personResponse = commandAddPerson.execute()

        val cmdFetchPerson = FetchPersonCommand(storage, personResponse.id)
        val fetchedPerson = cmdFetchPerson.execute()

        Assertions.assertEquals("BhagvatSinh", fetchedPerson.firstName)
        Assertions.assertEquals("Jadeja", fetchedPerson.lastName)
        Assertions.assertEquals(1, fetchedPerson.addresses.size)

        val address = fetchedPerson.addresses.first()

        Assertions.assertEquals("B-308", address.addressLine1)
        Assertions.assertEquals("Some complex", address.addressLine2)
        Assertions.assertEquals("Vadodara", address.city)
        Assertions.assertEquals("Gujarat", address.state)
        Assertions.assertEquals("385421", address.zipcode)
    }
}