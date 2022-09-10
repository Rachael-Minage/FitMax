package com.example.fitmax.retrofit

import com.example.fitmax.models.LoginRequest
import com.example.fitmax.models.LoginResponse
import com.example.fitmax.models.RegisterRequest
import com.example.fitmax.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest):Call<RegisterResponse>
    @POST("/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest):Call<LoginResponse>
}