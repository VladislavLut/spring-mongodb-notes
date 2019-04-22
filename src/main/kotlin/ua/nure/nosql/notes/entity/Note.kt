package ua.nure.nosql.notes.entity

import org.springframework.data.annotation.Id

data class Note(@Id var id: String, var title: String, var text: String, var userId: String)