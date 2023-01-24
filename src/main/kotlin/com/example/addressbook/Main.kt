
import com.example.addressbook.Address
import com.example.addressbook.Person
import com.example.addressbook.commands.*
import com.example.addressbook.repo.PersonRepo
import com.example.addressbook.requests.*
import com.example.addressbook.responses.PersonResponse
import com.example.addressbook.storages.PersonDatabaseStorage
import com.example.addressbook.storages.PersonInMemoryStorage
import com.example.addressbook.storages.PersonStorage
import com.example.addressbook.tables.Persons
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction


fun main(){

    val url = "jdbc:mysql://localhost:3306/addressBookDB"
    val driver = "com.mysql.cj.jdbc.Driver"
    val username = "bhagvat"
    val password = "Bhagvat17@"
    Database.connect(url, driver, username, password)

    transaction {
        SchemaUtils.create(Persons)
    }

    val req =AddPersonRequest("Bhagvatsinh","jadeja",
        phoneNumbers = listOf(
            PhoneNumberRequest(
                type = PhoneNumberType.Home,
                "12312312"
            )
        ),
        addresses = listOf(
            AddressRequest(
                type = AddressType.Home,
                addressLine1 = "B-308",
                addressLine2 = "Some complex",
                city = "Vadodara",
                state = "Gujarat",
                zipcode = "385421"
            )
        ),
        emails =listOf(
        ),
        groups = listOf()
    )
    val bhagvat =AddPersonCommand(PersonDatabaseStorage(), req).execute()
//    println(bhagvat)
//    val list = ListPersonCommand(PersonInMemoryStorage()).execute()
//    println(list)
}


