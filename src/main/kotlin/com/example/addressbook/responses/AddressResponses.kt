package com.example.addressbook.responses

import com.example.addressbook.AddressId
import com.example.addressbook.requests.AddressType

data class AddressResponses(
    val id: AddressId,
    val type: AddressType,
    val addressLine1: String,
    val addressLine2: String,
    val city: String,
    val state: String,
    val zipcode: String
)