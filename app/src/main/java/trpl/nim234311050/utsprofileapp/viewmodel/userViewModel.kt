package trpl.nim234311050.utsprofileapp.viewmodel

import android.app.Application
import androidx.compose.runtime.*
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import trpl.nim234311050.utsprofileapp.data.User
import trpl.nim234311050.utsprofileapp.data.UserDatabase

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = UserDatabase.getDatabase(application).userDao()

    var currentUser by mutableStateOf<User?>(null)
        private set

    fun register(user: User) = viewModelScope.launch {
        userDao.insert(user)
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        currentUser = userDao.login(email, password)
    }

    fun update(user: User) = viewModelScope.launch {
        userDao.update(user)
        currentUser = user
    }

    fun logout() {
        currentUser = null
    }
}
