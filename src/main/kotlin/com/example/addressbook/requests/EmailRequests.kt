package com.example.addressbook.requests

import java.util.*

typealias EmailId = UUID
enum class EmailType {
    Home,
    Office
}

data class EmailRequest(
    val type: EmailType,
    val email: String,

    )