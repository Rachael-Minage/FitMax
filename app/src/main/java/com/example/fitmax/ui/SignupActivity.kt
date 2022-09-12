package com.example.fitmax.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.fitmax.databinding.ActivitySignupBinding
import com.example.fitmax.models.RegisterRequest
import com.example.fitmax.viewmodels.UserViewModel

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        validateSignUp()
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
              error=true
              binding.tilFistName.error = "Enter First Name"
          }
          if (lastName.isBlank()) {
              error=true
              binding.tilLastName.error = "Enter Last Name"
          }
          if (email.isBlank()) {
              error=true
              binding.tilEmail.error = "Enter Email"
          }
          if (phoneNumber.isBlank()) {
              error=true
              binding.tilPhone.error = "Enter Phone Number"
          }
          if (password.isBlank()) {
              error=true
              binding.tilPassword.error = "Enter Your Password"
          }
          if (confirmPassword.isBlank()) {
              error=true
              binding.tilConfirm.error = "confirm your password "
          }
          if (password != confirmPassword) {
              error=true
              binding.tilConfirm.error = "passwords must match"
          }
        if (!error){
            var registerRequest = RegisterRequest(firstName, lastName, phoneNumber, email, password)
            userViewModel.register(registerRequest)
        }
    }
    override fun onResume() {
        super.onResume()
        userViewModel.logInLiveData.observe(this, Observer{ registerResponse->
            Toast.makeText(baseContext,registerResponse?.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,LoginActivity::class.java))
        })
        userViewModel.registerError.observe(this, Observer{ errorMsg ->
            Toast.makeText(baseContext, errorMsg, Toast.LENGTH_SHORT).show()
        })
    }

    }

