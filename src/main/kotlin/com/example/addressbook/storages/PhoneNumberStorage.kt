package com.example.addressbook.storages


import com.example.addressbook.PhoneNumber
import com.example.addressbook.requests.PhoneNumberId
import java.lang.Exception

object PhoneNumberStorage {
        private val phoneNumbers: MutableMap<PhoneNumberId, PhoneNumber> = mutableMapOf()

    fun addPhoneNumber(phoneNumber: PhoneNumber): PhoneNumber {
        phoneNumbers[phoneNumber.id] = phoneNumber
        return phoneNumber
    }

    fun updatePhoneNumber(phoneNumber: PhoneNumber): PhoneNumber {
        return if (phoneNumber.id in phoneNumbers) {
            phoneNumbers[phoneNumber.id] = phoneNumber
            phoneNumbers[phoneNumber.id]!!
        } else {
            throw Exception("Address not found with id: ${phoneNumber.id}")
        }
    }

    fun fetchPhoneNumber(phoneNumberId: PhoneNumberId): PhoneNumber = phoneNumbers[phoneNumberId]!!

    fun removePhoneNumber(phoneNumberId: PhoneNumberId): PhoneNumber = phoneNumbers.remove(phoneNumberId)!!

    fun listPhoneNumbers(): List<PhoneNumber> = phoneNumbers.values.toList()
}