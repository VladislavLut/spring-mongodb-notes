package ua.nure.nosql.notes.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed

data class User(
        @Id @JsonIgnore @Indexed(direction = IndexDirection.ASCENDING)
        var id: ObjectId = ObjectId.get(),
        @Indexed(direction = IndexDirection.ASCENDING)
        var userName: String = "",
      @JsonIgnore
        var password: String = ""
)