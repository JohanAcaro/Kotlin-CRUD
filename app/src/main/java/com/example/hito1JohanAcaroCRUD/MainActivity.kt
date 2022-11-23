package com.example.hito1JohanAcaroCRUD

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hito1JohanAcaroCRUD.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var etUser: EditText = binding.etUser
        var etPasswd: EditText = binding.etPasswd

        val btnLogin: Button = binding.btnLogin
        btnLogin.setOnClickListener() {
            println(etUser.text.toString())
            if(etUser.text.toString()=="" || etPasswd.text.toString()=="")
                Toast.makeText(this, "Es necesario que pongas un usuario y una contraseña", Toast.LENGTH_SHORT).show()
            else{
                val intent = Intent(this, Tramites::class.java)
                startActivity(intent)
            }

        }
    }
}