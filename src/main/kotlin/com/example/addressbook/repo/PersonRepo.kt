package com.example.addressbook.repo

import com.example.addressbook.Person
import com.example.addressbook.PersonId
import com.example.addressbook.storages.PersonInMemoryStorage
import com.example.addressbook.storages.PersonStorage


object PersonRepo {
    fun addPerson(storage: PersonStorage, person: Person): Person = storage.addPerson(person)

    fun updatePerson(storage: PersonStorage, person: Person): Person = storage.updatePerson(person)

    fun fetchPerson(storage: PersonStorage, personId: PersonId): Person = storage.fetchPerson(personId)

    fun removePerson(storage: PersonStorage, personId: PersonId): Person = storage.removePerson(personId)

    fun listPersons(storage: PersonStorage, ): List<Person> = storage.listPersons()
}