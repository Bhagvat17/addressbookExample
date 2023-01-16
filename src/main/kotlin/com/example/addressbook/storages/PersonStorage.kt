package com.example.addressbook.storages

import com.example.addressbook.Person
import com.example.addressbook.PersonId
import java.lang.Exception

interface PersonStorage {
    fun addPerson(person: Person): Person

    fun updatePerson(person: Person): Person

    fun fetchPerson(personId: PersonId): Person

    fun removePerson(personId: PersonId): Person

    fun listPersons(): List<Person>
}