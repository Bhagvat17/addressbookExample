package com.example.addressbook.requests


enum class AddressType {
    Home,
    Office
}

data class AddressRequest(
    val type: AddressType,
    val addressLine1: String,
    val addressLine2: String,
    val city: String,
    val state: String,
    val zipcode: String
)

