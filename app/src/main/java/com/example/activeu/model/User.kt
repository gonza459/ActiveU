package com.example.activeu.model

import java.util.Date

enum class Gender {
    MALE, FEMALE
}

class User(firstName: String, lastName: String, dateOfBirth: Date, weight: Float, sex: Gender) {
    var fullName = "$firstName $lastName"
}