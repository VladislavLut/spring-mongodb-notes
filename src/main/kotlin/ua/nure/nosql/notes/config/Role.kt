package ua.nure.nosql.notes.config

enum class Role {
    USER;

    val authority get() = ROLE + name

    companion object {
        const val ROLE = "ROLE_"
    }
}