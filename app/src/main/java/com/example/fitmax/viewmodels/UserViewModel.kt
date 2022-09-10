package com.example.fitmax.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitmax.models.LoginRequest
import com.example.fitmax.models.LoginResponse
import com.example.fitmax.models.RegisterResponse
import com.example.fitmax.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val userRepository = UserRepository()
    val logInLiveData = MutableLiveData<LoginResponse>()
    val registerLiveData = MutableLiveData<RegisterResponse>()
    val loginError = MutableLiveData<String>()
    val registerError = MutableLiveData<String>()


    fun login(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                logInLiveData.postValue((response.body()))
            }
            else{
                loginError.postValue(response.errorBody()?.string())
            }
        }
        }
    }
