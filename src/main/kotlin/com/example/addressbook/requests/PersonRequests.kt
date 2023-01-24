package com.example.addressbook.requests

import java.util.UUID

data class AddPersonRequest(
    val firstName: String,
    val lastName: String,
    val phoneNumbers: List<PhoneNumberRequest>,
    val addresses: List<AddressRequest>,
    val emails: List<EmailRequest>,
    val groups: List<GroupRequest>
)

data class UpdatePersonRequest(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val phoneNumbers: List<PhoneNumberRequest>,
    val addresses: List<AddressRequest>,
    val emails: List<EmailRequest>,
    val groups: List<GroupRequest>
)

data class RemovePersonRequest(
    val id: UUID,
    val firstName: String,
    val lastName: String
)

data class FetchPersonRequest(
    val id: UUID
)

class ListPersonRequest()