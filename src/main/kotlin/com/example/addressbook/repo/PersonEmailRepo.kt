package com.example.addressbook.repo

import com.example.addressbook.EmailId
import com.example.addressbook.PersonId
import com.example.addressbook.storages.EmailStorage


object PersonEmailRepo {
    fun removeAllEmailByPersonId(personId: PersonId): Unit  {
        val emailIds = PersonEmailMappingStorage.unmapPersonWithAllEmail(personId)
        emailIds.forEach {
            EmailStorage.removeEmail(it)
        }
    }

    fun mapPersonWithEmail(personId: PersonId, emailId: EmailId): Unit {
        PersonEmailMappingStorage.mapPersonWithEmail(personId, emailId)
    }

    fun getAllEmailIdsByPersonId(personId: PersonId): List<EmailId> =
        PersonEmailMappingStorage.getEmailIdsByPersonId(personId)
}