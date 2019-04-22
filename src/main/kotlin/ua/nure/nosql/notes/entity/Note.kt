package ua.nure.nosql.notes.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

data class Note(@Id var id: ObjectId, var title: String, var text: String, var userId: ObjectId
)