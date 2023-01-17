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
    val phoneNumbers: List<PhoneNumberRequest>,
    val addresses: List<AddressRequest>,
    val emails: List<EmailRequest>
)

data class UpdatePersonRequest(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val phoneNumbers: List<PhoneNumberRequest>,
    val addresses: List<AddressRequest>,
    val emails: List<EmailRequest>
)

data class RemovePersonRequest(
    val id: UUID
)

data class FetchPersonRequest(
    val id: UUID
)

class ListPersonsRequest()