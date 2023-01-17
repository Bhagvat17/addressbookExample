package com.example.addressbook

import com.example.addressbook.requests.*
import java.util.UUID

typealias PersonId = UUID

data class Person(
    val id: PersonId,
    val firstName: String,
    val lastName: String
)

typealias AddressId = UUID

data class Address(
    val id: AddressId,
    val type: AddressType,
    val addressLine1: String,
    val addressLine2: String,
    val city: String,
    val state: String,
    val zipcode: String
)

typealias EmailId = UUID
data class Email(
    val id: EmailId,
    val type: EmailType,
    val email: String,

    )

typealias PhoneNumberId = UUID
data class PhoneNumber(
    val id: PhoneNumberId,
    val type: PhoneNumberType,
    val phone: String,
    )