package com.example.addressbook.repo

import com.example.addressbook.Group
import com.example.addressbook.GroupId
import com.example.addressbook.storages.GroupStorage


object GroupRepo {
    fun addGroup(group: Group): Group = GroupStorage.addGroup(group)

    fun updateGroup(group: Group): Group = GroupStorage.updateGroup(group)

    fun fetchGroup(groupId: GroupId): Group = GroupStorage.fetchGroup(groupId)

    fun removeGroup(groupId: GroupId): Group = GroupStorage.removeGroup(groupId)

    fun listGroupes(): List<Group> = GroupStorage.listGroupes()
}