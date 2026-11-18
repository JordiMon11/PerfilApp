package com.example.perfilapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etBio = findViewById<EditText>(R.id.etBio)
        val etImagenUrl = findViewById<EditText>(R.id.etImagenUrl)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val bio = etBio.text.toString().trim()
            val imagenUrl = etImagenUrl.text.toString().trim()

            if (nombre.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Omple el nom i el correu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("EXTRA_NOMBRE", nombre)
                putExtra("EXTRA_EMAIL", email)
                putExtra("EXTRA_BIO", bio)
                putExtra("EXTRA_IMAGEN", imagenUrl)
            }
            startActivity(intent)
        }
    }
}