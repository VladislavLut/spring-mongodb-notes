package ua.nure.nosql.notes.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import javax.annotation.Generated

data class User (@Id @JsonIgnore var id: ObjectId?, var userName: String, var password: String)