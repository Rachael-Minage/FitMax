package com.example.fitmax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitmax.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        validateSignUp()
        onclickListeners()
    }

     fun onclickListeners() {
         binding.tvAlready.setOnClickListener {
             val intent = Intent(this, LoginActivity::class.java)
             startActivity(intent)
         }

         binding.btnSignUp.setOnClickListener {
             validateSignUp()
             val intent = Intent(this, LoginActivity::class.java)
             startActivity(intent)
         }

    }

    fun validateSignUp() {
            var firstName = binding.etFirstName.text.toString()
            var lastName = binding.etLastName.text.toString()
            var email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()
            var confirmPassword = binding.etConfirm.text.toString()
            var phoneNumber = binding.etPhone.text.toString()
            var error = false



          if (firstName.isBlank()) {
              error = true
              binding.tilFistName.error = "Enter First Name"
          }
          if (lastName.isBlank()) {
              error = true
              binding.tilLastName.error = "Enter Last Name"
          }
          if (email.isBlank()) {
              error = true
              binding.tilEmail.error = "Enter Email"
          }
          if (phoneNumber.isBlank()) {
              error = true
              binding.tilPhone.error = "Enter Phone Number"
          }
          if (password.isBlank()) {
              error = true
              binding.tilPassword.error = "Enter Your Password"
          }
          if (confirmPassword.isBlank()) {
              error = true
              binding.tilConfirm.error = "confirm your password "
          }
          if (password != confirmPassword) {
              error = true
              binding.tilConfirm.error = "passwords must match"
          }
    }
}
