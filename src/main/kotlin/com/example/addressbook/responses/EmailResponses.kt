package com.example.addressbook.responses

import com.example.addressbook.requests.EmailId
import com.example.addressbook.requests.EmailType

data class EmailResponses(
    val id: EmailId,
    val type: EmailType,
    val email: String,
)