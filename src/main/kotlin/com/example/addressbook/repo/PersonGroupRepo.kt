package com.example.addressbook.repo

import com.example.addressbook.GroupId
import com.example.addressbook.PersonId
import com.example.addressbook.storages.GroupStorage
import com.example.addressbook.storages.PersonGroupMappingStorage


object PersonGroupRepo {
    fun removeAllGroupByPersonId(personId: PersonId): Unit  {
        val groupIds = PersonGroupMappingStorage.unmapPersonWithAllGroup(personId)
        groupIds.forEach {
            GroupStorage.removeGroup(it)
        }
    }

    fun mapPersonWithGroup(personId: PersonId, groupId: GroupId): Unit {
        PersonGroupMappingStorage.mapPersonWithGroup(personId, groupId)
    }

    fun getAllGroupIdsByPersonId(personId: PersonId): List<GroupId> =
        PersonGroupMappingStorage.getGroupIdsByPersonId(personId)
}