package com.example.addressbook.storages

import com.example.addressbook.Group
import com.example.addressbook.GroupId
import java.lang.Exception

object GroupStorage {
    private val groups: MutableMap<GroupId, Group> = mutableMapOf()

    fun addGroup(address: Group): Group {
        groups[address.id] = address
        return address
    }

    fun updateGroup(address: Group): Group {
        return if (address.id in groups) {
            groups[address.id] = address
            groups[address.id]!!
        } else {
            throw Exception("Group not found with id: ${address.id}")
        }
    }

    fun fetchGroup(addressId: GroupId): Group = groups[addressId]!!

    fun removeGroup(addressId: GroupId): Group {
        return if (addressId in groups) {
            groups.remove(addressId)!!
        } else {
            throw Exception("Group not found with id: $addressId")
        }
    }

    fun listGroupes(): List<Group> = groups.values.toList()
}