package trpl.nim234311050.utsprofileapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val email: String,
    val name: String,
    val password: String,
    val phone: String,
    val address: String
)
