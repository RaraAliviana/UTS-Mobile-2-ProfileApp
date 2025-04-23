package trpl.nim234311050.utsprofileapp.data

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    suspend fun login(email: String, password: String): User?

    @Query("SELECT * FROM User WHERE email = :email")
    suspend fun getUser(email: String): User?

    @Update
    suspend fun update(user: User)

}
