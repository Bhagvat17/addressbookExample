package com.example.addressbook.requests

import java.util.UUID

enum class PhoneType {
    Home,
    Office
}

data class Phone(
    val type: PhoneType,
    val number: String
)

data class AddPersonRequest(
    val firstName: String,
    val lastName: String,
    val phones: List<Phone>,
    val addresses: List<AddressRequest>
)

data class UpdatePersonRequest(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val phones: List<Phone>,
    val addresses: List<AddressRequest>
)

data class RemovePersonRequest(
    val id: UUID
)

data class FetchPersonRequest(
    val id: UUID
)

class ListPersonsRequest()