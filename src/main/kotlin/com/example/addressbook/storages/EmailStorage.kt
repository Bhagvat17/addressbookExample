package com.example.addressbook.storages

import com.example.addressbook.Email
import com.example.addressbook.EmailId


object EmailStorage {
        private val emails: MutableMap<EmailId, Email> = mutableMapOf()

    fun addEmail(email: Email): Email {
        emails[email.id] = email
        return email
    }

    fun updateEmail(email: Email): Email {
        return if (email.id in emails) {
            emails[email.id] = email
            emails[email.id]!!
        } else {
            throw Exception("Address not found with id: ${email.id}")
        }
    }

    fun fetchEmail(emailId: EmailId): Email = emails[emailId]!!

    fun removeEmail(emailId: EmailId): Email = emails.remove(emailId)!!

    fun listEmails(): List<Email> = emails.values.toList()
}