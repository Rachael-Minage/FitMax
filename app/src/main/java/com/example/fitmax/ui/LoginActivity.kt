package com.example.fitmax.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SharedMemory
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.fitmax.databinding.ActivityLoginBinding
import com.example.fitmax.models.LoginRequest
import com.example.fitmax.models.LoginResponse
import com.example.fitmax.viewmodels.UserViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        sharedPreferences = getSharedPreferences("FITMAX_PREFS", MODE_PRIVATE)
        setContentView(binding.root)
        loginListeners()

    }
    fun loginListeners(){
        binding.tvDont.setOnClickListener {
            val intent=Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            validateLogin()
            val intent=Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
}

    override fun onResume() {
        super.onResume()
        userViewModel.logInLiveData.observe(this, Observer{ loginResponse->
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
            persistLoginDetails(loginResponse!!)
            startActivity(Intent(baseContext,HomeActivity::class.java))
        })
    }

    private fun validateLogin() {
        var email = binding.etLoginEmail.text.toString()
        var password = binding.etLoginPassword.text.toString()
        var error = false

        if (email.isBlank()) {
            error = true
            binding.tilLoginEmail.error = "Enter Email"
        }
        if (password.isBlank()) {
            error = true
            binding.tilLogiPassword.error = "Enter Password"
        }
        if (!error){
            binding.pbLogin.visibility = View.VISIBLE
            var loginRequest = LoginRequest(email,password)
            userViewModel.login(loginRequest)

        }
    }
    fun persistLoginDetails(loginResponse: LoginResponse){
        val editor = sharedPreferences.edit()
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()


    }
}
