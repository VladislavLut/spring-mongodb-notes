package ua.nure.nosql.notes.entity

import org.springframework.data.annotation.Id

data class User (@Id var id: String, var name: String, var password: String)