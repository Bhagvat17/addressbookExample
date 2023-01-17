import com.example.addressbook.PhoneNumberId
import com.example.addressbook.requests.PhoneNumberType

data class PhoneNumberResponses(
    val id: PhoneNumberId,
    val type: PhoneNumberType,
    val phone: String,
)