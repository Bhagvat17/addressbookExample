package com.example.addressbook.storages

import com.example.addressbook.Person
import com.example.addressbook.PersonId
import com.example.addressbook.tables.Persons
import com.example.addressbook.tables.Persons.firstName
import com.example.addressbook.tables.Persons.lastName
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class PersonDatabaseStorage: PersonStorage {
    override fun addPerson(person: Person): Person {
            transaction {
                Persons.insert{
                    it[this.id] = person.id
                    it[this.firstName] = person.firstName
                    it[this.lastName] = person.lastName
                }
            }
            return person
        }

    override fun updatePerson(person: Person): Person {
        TODO("Not yet implemented")
    }

    override fun fetchPerson(personId: PersonId): Person {
        TODO("Not yet implemented")
    }

    override fun removePerson(personId: PersonId): Person {
        TODO("Not yet implemented")
    }

    override fun listPersons(): List<Person> {
        TODO("Not yet implemented")
    }
}