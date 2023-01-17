import com.example.addressbook.EmailId
import com.example.addressbook.PersonId

object PersonEmailMappingStorage{
    private val emailsByPersonId: MutableMap<PersonId, MutableList<EmailId>> = mutableMapOf()

    fun getEmailIdsByPersonId(personId: PersonId): List<EmailId> =emailsByPersonId[personId]?.toList() ?: emptyList()

    fun mapPersonWithEmail(personId: PersonId, emailId: EmailId): Unit {
        if (personId in emailsByPersonId) {
            emailsByPersonId[personId]!!.add(emailId)
        } else {
            emailsByPersonId[personId] = mutableListOf(emailId)
        }

    }

    fun unmapPersonWithEmail(personId: PersonId, emailId: EmailId): Unit {
        emailsByPersonId[personId]!!.remove(emailId)
    }

    fun unmapPersonWithAllEmail(personId: PersonId): List<EmailId> {
        val emailIds =  emailsByPersonId[personId]?.toList()
        emailsByPersonId[personId]?.clear()
        return emailIds ?: emptyList()
    }
}