package com.example.addressbook.requests

import java.util.*

typealias PhoneNumberId = UUID
enum class PhoneNumberType {
    Home,
    Office
}

data class PhoneNumberRequest(
    val type: PhoneNumberType,
    val phone: String,
    )