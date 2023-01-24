package com.example.addressbook.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.Table.Dual.autoGenerate
import org.jetbrains.exposed.sql.Table.Dual.uuid
import org.jetbrains.exposed.sql.Table.Dual.varchar

object Persons : Table() {
    val id = uuid("contact_id").autoGenerate()
    val firstName = varchar("first_name", length = 100)
    val lastName = varchar("last_name", length = 100)

    override val primaryKey = PrimaryKey(id, name = "PK_Contact_ID")
}