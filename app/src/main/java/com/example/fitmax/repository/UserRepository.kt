package com.example.fitmax.repository

import com.example.fitmax.models.LoginRequest
import com.example.fitmax.models.LoginResponse
import com.example.fitmax.models.RegisterRequest
import com.example.fitmax.models.RegisterResponse
import com.example.fitmax.retrofit.ApiClient
import com.example.fitmax.retrofit.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiClient = ApiClient.buldApiClient(ApiInterface::class.java)
    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse>
    = withContext(Dispatchers.IO){
        val response = apiClient.registerUser(registerRequest)
        return@withContext response
    }

    suspend fun loginUser(loginRequest:LoginRequest): Response<LoginResponse>
            = withContext(Dispatchers.IO){
        val response = apiClient.loginUser(loginRequest)
        return@withContext response
    }


}