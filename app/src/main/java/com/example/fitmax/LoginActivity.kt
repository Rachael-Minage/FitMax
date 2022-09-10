package com.example.fitmax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitmax.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
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

        }

    }
}
