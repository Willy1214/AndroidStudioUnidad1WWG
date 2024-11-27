package com.example.segundoapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IMCActivity : AppCompatActivity() {
    private lateinit var lblResultado : TextView
    private lateinit var txtAltura : EditText
    private lateinit var txtPeso : EditText
    private lateinit var btnCalcular : Button
    private lateinit var btnLimpiar : Button
    private lateinit var btnCerrar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcactivity)
        iniciarComponentes()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun iniciarComponentes(){
        lblResultado = findViewById(R.id.lblResultado) as TextView
        txtAltura = findViewById(R.id.txtALtura) as EditText
        txtPeso = findViewById(R.id.txtPeso) as EditText
        btnCalcular = findViewById(R.id.btnCalcular) as Button
        btnLimpiar = findViewById(R.id.btnLimpiar) as Button
        btnCerrar = findViewById(R.id.btnCerrar) as Button
    }
    private fun eventosClic(){
        btnCalcular.setOnClickListener({
            val pesoStr = txtPeso.text.toString()
            val alturaStr = txtAltura.text.toString()

            if(pesoStr == "" || alturaStr == "") {
                Toast.makeText(this,"Informacion incompleta",Toast.LENGTH_SHORT).show()
            }
            else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()
                val resultado = peso / (altura * altura)
                lblResultado.text = ("EL IMC es: %.2f".format(resultado))
            }


        })

        btnLimpiar.setOnClickListener({
            val a = "El resultado se mostrara aqui"
            lblResultado.text = a
        })

        btnCerrar.setOnClickListener({
            finish()
        })
    }
}