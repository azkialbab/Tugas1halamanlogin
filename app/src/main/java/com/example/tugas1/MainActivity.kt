package com.example.tugas1

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Mengatur padding pada view utama berdasarkan insets sistem
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi View untuk login form
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        // Mengatur teks "New Member? Register" dengan warna yang berbeda
        val text = "New Member? Register"
        val spannableString = SpannableString(text)

        // Warna hitam untuk "New Member?"
        spannableString.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0, 11, // Start dan End index dari "New Member?"
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Warna biru untuk "Register"
        spannableString.setSpan(
            ForegroundColorSpan(Color.BLUE),
            12, text.length, // Start dan End index dari "Register"
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvRegister.text = spannableString

        // Event listener untuk tombol login
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username == "admin" && password == "admin") {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

        // Event listener untuk teks register
        tvRegister.setOnClickListener {
            Toast.makeText(this, "Redirect to Register Page", Toast.LENGTH_SHORT).show()
        }
    }
}
