package com.example.addressbook.storages

import com.example.addressbook.AddressId
import com.example.addressbook.PersonId

object PersonAddressMappingStorage {
    private val addressesByPersonId: MutableMap<PersonId, MutableList<AddressId>> = mutableMapOf()

    fun getAddressIdsByPersonId(personId: PersonId): List<AddressId> = addressesByPersonId[personId]?.toList() ?: emptyList()

    fun mapPersonWithAddress(personId: PersonId, addressId: AddressId): Unit {
        if (personId in addressesByPersonId) {
            addressesByPersonId[personId]!!.add(addressId)
        } else {
            addressesByPersonId[personId] = mutableListOf(addressId)
        }

    }

    fun unmapPersonWithAddress(personId: PersonId, addressId: AddressId): Unit {
        addressesByPersonId[personId]!!.remove(addressId)
    }

    fun unmapPersonWithAllAddress(personId: PersonId): List<AddressId> {
        val addressIds =  addressesByPersonId[personId]?.toList()
        addressesByPersonId[personId]?.clear()
        return addressIds ?: emptyList()
    }
}