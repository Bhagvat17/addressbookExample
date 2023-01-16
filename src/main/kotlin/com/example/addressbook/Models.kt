package com.example.addressbook

import com.example.addressbook.requests.AddressType
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
