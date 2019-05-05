package ua.nure.nosql.notes.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed

data class Note(
        @Id @JsonIgnore @Indexed(direction = IndexDirection.ASCENDING)
        var id: ObjectId = ObjectId.get(),
        var title: String = "",
        var text: String = "",
        @Indexed(direction = IndexDirection.ASCENDING)
        var userId: ObjectId = ObjectId.get()
)