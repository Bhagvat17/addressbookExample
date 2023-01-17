package com.example.addressbook.repo

import com.example.addressbook.Email
import com.example.addressbook.EmailId
import com.example.addressbook.storages.EmailStorage

object EmailRepo {
    fun addEmail(email: Email): Email = EmailStorage.addEmail(email)

    fun updateEmail(email: Email): Email = EmailStorage.updateEmail(email)

    fun fetchEmail(emailId: EmailId): Email = EmailStorage.fetchEmail(emailId)

    fun removeEmail(emailId: EmailId): Email = EmailStorage.removeEmail(emailId)

    fun listEmails(): List<Email> = EmailStorage.listEmails()
}