package com.example.addressbook.storages

import com.example.addressbook.Address
import com.example.addressbook.AddressId
import java.lang.Exception

object AddressStorage {
    private val addresses: MutableMap<AddressId, Address> = mutableMapOf()

    fun addAddress(address: Address): Address {
        addresses[address.id] = address
        return address
    }

    fun updateAddress(address: Address): Address {
        return if (address.id in addresses) {
            addresses[address.id] = address
            addresses[address.id]!!
        } else {
            throw Exception("Address not found with id: ${address.id}")
        }
    }

    fun fetchAddress(addressId: AddressId): Address = addresses[addressId]!!

    fun removeAddress(addressId: AddressId): Address {
        return if (addressId in addresses) {
            addresses.remove(addressId)!!
        } else {
            throw Exception("Address not found with id: $addressId")
        }
    }

    fun listAddresses(): List<Address> = addresses.values.toList()
}