package com.example.addressbook.storages

import com.example.addressbook.Person
import com.example.addressbook.PersonId
import java.lang.Exception


class PersonInMemoryStorage: PersonStorage {
    private val persons: MutableMap<PersonId, Person> = mutableMapOf()

    override fun addPerson(person: Person): Person {
        persons[person.id] = person
        return person
    }

    override fun updatePerson(person: Person): Person {
        return if (person.id in persons) {
            persons[person.id] = person
            persons[person.id]!!
        } else {
            throw Exception("Person not found with id: ${person.id}")
        }
    }

    override fun fetchPerson(personId: PersonId): Person = persons[personId]!!

    override fun removePerson(personId: PersonId): Person = persons.remove(personId)!!

    override fun listPersons(): List<Person> = persons.values.toList() as List<Person>
}