package com.example.addressbook.repo

import com.example.addressbook.PhoneNumber
import com.example.addressbook.PhoneNumberId
import com.example.addressbook.storages.PhoneNumberStorage


object PhoneNumberRepo {
    fun addPhoneNumber(phoneNumber: PhoneNumber): PhoneNumber = PhoneNumberStorage.addPhoneNumber(phoneNumber)

    fun updatePhoneNumber(phoneNumber: PhoneNumber): PhoneNumber = PhoneNumberStorage.updatePhoneNumber(phoneNumber)

    fun fetchPhoneNumber(phoneNumberId: PhoneNumberId): PhoneNumber = PhoneNumberStorage.fetchPhoneNumber(phoneNumberId)

    fun removePhoneNumber(phoneNumberId: PhoneNumberId): PhoneNumber = PhoneNumberStorage.removePhoneNumber(phoneNumberId)

    fun listPhoneNumbers(): List<PhoneNumber> = PhoneNumberStorage.listPhoneNumbers()
}