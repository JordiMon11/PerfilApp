package com.example.perfilapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val nombre = intent.getStringExtra("EXTRA_NOMBRE").orEmpty()
        val email = intent.getStringExtra("EXTRA_EMAIL").orEmpty()
        val bio = intent.getStringExtra("EXTRA_BIO").orEmpty()
        val imagenUrl = intent.getStringExtra("EXTRA_IMAGEN").orEmpty()

        findViewById<TextView>(R.id.tvNombre).text = nombre
        findViewById<TextView>(R.id.tvEmail).text = email
        findViewById<TextView>(R.id.tvBio).text = bio

        val ivPerfil = findViewById<ImageView>(R.id.ivPerfil)
        if (imagenUrl.isNotEmpty()) {
            ivPerfil.load(imagenUrl) {
                crossfade(true)
                placeholder(android.R.drawable.ic_menu_gallery)
                error(android.R.drawable.ic_delete)
                transformations(CircleCropTransformation())
            }
        }
    }
}