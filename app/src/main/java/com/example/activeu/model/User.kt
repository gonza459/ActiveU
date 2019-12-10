package com.example.activeu.model

enum class Gender {
    MALE, FEMALE
}

class User(firstName: String, lastName: String, age: Int, weight: Float, sex: Gender) {
    var fullName = "$firstName $lastName"
}