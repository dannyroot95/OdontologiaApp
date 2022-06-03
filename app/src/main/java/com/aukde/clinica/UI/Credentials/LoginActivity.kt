package com.aukde.clinica.UI.Credentials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            startActivity(Intent(this,MenuActivity::class.java))
        }
        binding.txtRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

    }


}