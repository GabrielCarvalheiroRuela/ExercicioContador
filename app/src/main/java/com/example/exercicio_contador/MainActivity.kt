package com.example.exercicio_contador

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.annotation.SuppressLint
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var contador = 0
        val textViewContador: TextView = findViewById(R.id.contadorView)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonRemove = findViewById<Button>(R.id.buttonRemove)

        textViewContador.text = "$contador"

        fun is_positivo(): Boolean {
            return contador >= 0
        }

        fun atualiza(){
            textViewContador.text = "$contador"
        }

        buttonAdd.setOnClickListener {
            if(is_positivo()) {
                contador++
                atualiza()
            }
        }

        buttonRemove.setOnClickListener {
            if(is_positivo()){
                if (contador == 0) contador++
                contador--
                atualiza()
            }
        }

    }
}