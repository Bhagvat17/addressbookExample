package com.example.addressbook.repo

import com.example.addressbook.Person
import com.example.addressbook.PersonId
import com.example.addressbook.storages.PersonDatabaseStorage
import com.example.addressbook.storages.PersonInMemoryStorage
import com.example.addressbook.storages.PersonStorage


object PersonRepo {
    fun addPerson(storage: PersonDatabaseStorage, person: Person): Person = storage.addPerson(person)

    fun updatePerson(storage: PersonInMemoryStorage, person: Person): Person = storage.updatePerson(person)

    fun fetchPerson(storage: PersonInMemoryStorage, personId: PersonId): Person = storage.fetchPerson(personId)

    fun removePerson(storage: PersonInMemoryStorage, personId: PersonId): Person = storage.removePerson(personId)

    fun listPersons(storage: PersonInMemoryStorage, ): List<Person> = storage.listPersons()
}