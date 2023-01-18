//
//import com.example.addressbook.Person
//import com.example.addressbook.commands.AddPersonCommand
//import com.example.addressbook.commands.Command
//import com.example.addressbook.requests.AddPersonRequest
//import com.example.addressbook.requests.PhoneNumberRequest
//import com.example.addressbook.requests.PhoneNumberType
//import com.example.addressbook.storages.PersonInMemoryStorage
//import com.example.addressbook.storages.PersonStorage
//
//class AddressBook(){
//    fun executeCommand(command: Command): Any{
//        return command.execute()
//    }
//}
//
//fun main(){
//    val obj = AddressBook()
//
//    val bhagvat = obj.executeCommand(AddPersonCommand(PersonInMemoryStorage().addPerson(),AddPersonRequest)
//    )
//}