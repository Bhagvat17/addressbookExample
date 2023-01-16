package com.example.addressbook

import com.example.addressbook.requests.*

fun getPersonCreateRequest(
    firstName: String = "BhagvatSinh",
    lastName: String = "Jadeja",
    phones: List<Phone> = listOf(
        Phone(PhoneType.Home, "99999999"),
        Phone(PhoneType.Office, "888888888")
    ),
    addresses: List<AddressRequest> = listOf(
        AddressRequest(
            type = AddressType.Home,
            addressLine1 = "B-308",
            addressLine2 = "Some complex",
            city = "Vadodara",
            state = "Gujarat",
            zipcode = "385421"
        )
    )
) =
    AddPersonRequest(
        firstName = firstName,
        lastName = lastName,
        phones = phones,
        addresses = addresses
    )

fun getPersonUpdateRequest(
    id: PersonId,
    firstName: String = "BhagvatSinh_UPDATED",
    lastName: String = "Jadeja_UPDATED",
    phones: List<Phone> = listOf(
        Phone(PhoneType.Home, "99999999_UPDATED"),
        Phone(PhoneType.Office, "888888888_UPDATED")
    ),
    addresses: List<AddressRequest> = listOf(
        AddressRequest(
            type = AddressType.Home,
            addressLine1 = "B-308_UPDATED",
            addressLine2 = "Some complex_UPDATED",
            city = "Vadodara_UPDATED",
            state = "Gujarat_UPDATED",
            zipcode = "385421_UPDATED"
        )
    )
) =
    UpdatePersonRequest(
        id = id,
        firstName = firstName,
        lastName = lastName,
        phones = phones,
        addresses = addresses
    )