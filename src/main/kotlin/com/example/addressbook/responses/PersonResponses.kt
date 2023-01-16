package com.example.addressbook.responses

import com.example.addressbook.PersonId
import com.example.addressbook.requests.Phone

data class PersonResponse(
    val id: PersonId,
    val firstName: String,
    val lastName: String,
//    val phones: List<Phone>,
    val addresses: List<AddressResponses>
)