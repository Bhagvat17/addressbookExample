import com.example.addressbook.PersonId
import com.example.addressbook.PhoneNumberId

object PersonPhoneNumberMappingStorage{
    private val phoneNumbersByPersonId: MutableMap<PersonId, MutableList<PhoneNumberId>> = mutableMapOf()

    fun getPhoneNumberIdsByPersonId(personId: PersonId): List<PhoneNumberId> =phoneNumbersByPersonId[personId]?.toList() ?: emptyList()

    fun mapPersonWithPhoneNumber(personId: PersonId, phoneNumberId: PhoneNumberId): Unit {
        if (personId in phoneNumbersByPersonId) {
            phoneNumbersByPersonId[personId]!!.add(phoneNumberId)
        } else {
            phoneNumbersByPersonId[personId] = mutableListOf(phoneNumberId)
        }

    }

    fun unmapPersonWithPhoneNumber(personId: PersonId, phoneNumberId: PhoneNumberId): Unit {
        phoneNumbersByPersonId[personId]!!.remove(phoneNumberId)
    }

    fun unmapPersonWithAllPhoneNumber(personId: PersonId): List<PhoneNumberId> {
        val phoneNumberIds =  phoneNumbersByPersonId[personId]?.toList()
        phoneNumbersByPersonId[personId]?.clear()
        return phoneNumberIds ?: emptyList()
    }
}