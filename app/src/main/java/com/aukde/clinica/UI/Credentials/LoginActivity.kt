package com.aukde.clinica.UI.Credentials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aukde.clinica.Domain.Auth.AuthProvider
import com.aukde.clinica.R
import com.aukde.clinica.UI.Menu.MenuActivity
import com.aukde.clinica.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnButton.setOnClickListener {

            val dni = binding.edDni.text.toString()
            val password = binding.edPassword.text.toString()

      if(dni.isNotEmpty() && password.isNotEmpty()){
          AuthProvider().login(this,dni,password)

            }else{
                Toast.makeText(this,"Complete los campos",Toast.LENGTH_SHORT).show()
            }

        }
        binding.txtRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

    }


}