package ua.nure.nosql.notes.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

data class User (@Id var id: ObjectId, var userName: String, var password: String)