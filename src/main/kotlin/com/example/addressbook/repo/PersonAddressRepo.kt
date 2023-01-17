package com.example.addressbook.repo

import com.example.addressbook.AddressId
import com.example.addressbook.PersonId
import com.example.addressbook.storages.AddressStorage
import com.example.addressbook.storages.PersonAddressMappingStorage

object PersonAddressRepo {
    fun removeAllAddressByPersonId(personId: PersonId): Unit  {
        val addressIds = PersonAddressMappingStorage.unmapPersonWithAllAddress(personId)
        addressIds.forEach {
            AddressStorage.removeAddress(it)
        }
    }

    fun mapPersonWithAddress(personId: PersonId, addressId: AddressId): Unit {
        PersonAddressMappingStorage.mapPersonWithAddress(personId, addressId)
    }

    fun getAllAddressIdsByPersonId(personId: PersonId): List<AddressId> =
        PersonAddressMappingStorage.getAddressIdsByPersonId(personId)
}