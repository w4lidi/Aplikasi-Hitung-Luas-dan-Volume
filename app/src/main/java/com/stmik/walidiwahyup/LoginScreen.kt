package com.stmik.walidiwahyup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.stmik.walidiwahyup.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {

    private lateinit var login : ActivityLoginScreenBinding

    private val username = "w4lidi"
    private val pass = "walidi"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        login = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(login.root)

        login.buttonLogin.setOnClickListener {
            val inputUserName = login.editTextUsername.text.toString()
            val inputPassword = login.editTextPassword.text.toString()
            val log = login.textLog
            if (inputPassword.isEmpty() && inputUserName.isEmpty()){
                log.setTextColor(ContextCompat.getColor(this, R.color.error))
                log.text = "silahkan isi Username & Password"
            }
            else if (inputPassword.isEmpty() && inputUserName.isNotEmpty()){
                log.setTextColor(ContextCompat.getColor(this, R.color.error))
                log.text = "Passwor is missing"
            }else if (inputPassword.isNotEmpty() && inputUserName.isEmpty()){
                log.setTextColor(ContextCompat.getColor(this, R.color.error))
                log.text = "Username is missing"
            }else{
                log.text = ""
                if ((inputUserName == username) && (inputPassword == pass)){
                    log.setTextColor(ContextCompat.getColor(this, R.color.success))
                    log.text = "Selamat ... \n Anda berhasil login."
                    val foot = Intent(this, MainActivity::class.java)
                    startActivity(foot)
                }else{
                    log.setTextColor(ContextCompat.getColor(this, R.color.error))
                    log.text = "Try again... \n Login Failed."
                }
            }
        }

    }
}