package com.example.addressbook.repo

import com.example.addressbook.PersonId
import com.example.addressbook.PhoneNumberId
import com.example.addressbook.storages.PhoneNumberStorage


object PersonPhoneNumberRepo {
    fun removeAllPhoneNumberByPersonId(personId: PersonId): Unit  {
        val phoneNumberIds = PersonPhoneNumberMappingStorage.unmapPersonWithAllPhoneNumber(personId)
        phoneNumberIds.forEach {
            PhoneNumberStorage.removePhoneNumber(it)
        }
    }

    fun mapPersonWithPhoneNumber(personId: PersonId, phoneNumberId: PhoneNumberId): Unit {
        PersonPhoneNumberMappingStorage.mapPersonWithPhoneNumber(personId, phoneNumberId)
    }

    fun getAllPhoneNumberIdsByPersonId(personId: PersonId): List<PhoneNumberId> =
        PersonPhoneNumberMappingStorage.getPhoneNumberIdsByPersonId(personId)
}