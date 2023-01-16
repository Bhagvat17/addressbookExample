package com.example.addressbook.repo

import com.example.addressbook.Address
import com.example.addressbook.AddressId
import com.example.addressbook.storages.AddressStorage


object AddressRepo {
    fun addAddress(address: Address): Address = AddressStorage.addAddress(address)

    fun updateAddress(address: Address): Address = AddressStorage.updateAddress(address)

    fun fetchAddress(addressId: AddressId): Address = AddressStorage.fetchAddress(addressId)

    fun removeAddress(addressId: AddressId): Address = AddressStorage.removeAddress(addressId)

    fun listAddresses(): List<Address> = AddressStorage.listAddresses()

}