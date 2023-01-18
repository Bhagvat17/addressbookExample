package com.example.addressbook.responses

import PhoneNumberResponses
import com.example.addressbook.PersonId

data class PersonResponse(
    val id: PersonId,
    val firstName: String,
    val lastName: String,
    val phoneNumbers: List<PhoneNumberResponses>,
    val addresses: List<AddressResponses>,
    val emails: List<EmailResponses>,
    val groups: List<GroupResponses>
)