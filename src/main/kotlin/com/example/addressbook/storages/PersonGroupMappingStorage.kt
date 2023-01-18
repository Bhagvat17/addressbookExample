package com.example.addressbook.storages

import com.example.addressbook.GroupId
import com.example.addressbook.PersonId

object PersonGroupMappingStorage {
    private val groupsByPersonId: MutableMap<PersonId, MutableList<GroupId>> = mutableMapOf()

    fun getGroupIdsByPersonId(personId: PersonId): List<GroupId> = groupsByPersonId[personId]?.toList() ?: emptyList()

    fun mapPersonWithGroup(personId: PersonId, addressId: GroupId): Unit {
        if (personId in groupsByPersonId) {
            groupsByPersonId[personId]!!.add(addressId)
        } else {
            groupsByPersonId[personId] = mutableListOf(addressId)
        }

    }

    fun unmapPersonWithGroup(personId: PersonId, addressId: GroupId): Unit {
        groupsByPersonId[personId]!!.remove(addressId)
    }

    fun unmapPersonWithAllGroup(personId: PersonId): List<GroupId> {
        val addressIds =  groupsByPersonId[personId]?.toList()
        groupsByPersonId[personId]?.clear()
        return addressIds ?: emptyList()
    }
}