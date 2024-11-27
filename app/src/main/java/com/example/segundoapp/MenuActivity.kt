package com.example.segundoapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    private lateinit var crvMonedas : CardView
    private lateinit var crvSaludar : CardView
    private lateinit var crvIMC : CardView
    private lateinit var crvGrados : CardView
    private lateinit var crvCotizacion : CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        iniciarComponentes()
        eventosClick()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun iniciarComponentes(){
        crvMonedas = findViewById(R.id.crvMonedas) as CardView
        crvSaludar = findViewById(R.id.crvSaludar) as CardView
        crvIMC = findViewById(R.id.crvImc) as CardView
        crvGrados = findViewById(R.id.crvGrados) as CardView
        crvCotizacion = findViewById(R.id.crvCotizacion) as CardView
    }

    private fun eventosClick(){
        crvSaludar.setOnClickListener({
            var intent = Intent(this,SaludarActivity::class.java)
            startActivity(intent)
        })
        crvMonedas.setOnClickListener({
            var intent = Intent(this,MonedasActivity::class.java)
            startActivity(intent)
        })
        crvIMC.setOnClickListener({
            var intent = Intent(this,IMCActivity::class.java)
            startActivity(intent)
        })
        crvGrados.setOnClickListener({
            var intent = Intent(this,GradosActivity::class.java)
            startActivity(intent)
        })
        crvCotizacion.setOnClickListener({
            var intent = Intent(this,ClienteActivity::class.java)
            startActivity(intent)
        })
    }
}