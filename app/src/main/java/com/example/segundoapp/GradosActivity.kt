package com.example.segundoapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GradosActivity : AppCompatActivity() {
    private lateinit var lblResultado : TextView
    private lateinit var txtGrados : EditText
    private lateinit var rdbFareneheitACelcius : RadioButton
    private lateinit var rdbCelciusAFarenheit : RadioButton
    private lateinit var btnCalcular : Button
    private lateinit var btnLimpiar : Button
    private lateinit var btnCerrar : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grados)

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
        txtGrados = findViewById(R.id.txtGrados) as EditText
        rdbCelciusAFarenheit = findViewById(R.id.rdbCelsiusAFahrenheit) as RadioButton
        rdbFareneheitACelcius = findViewById(R.id.rdbFahrenheitACelsius) as RadioButton
        btnCalcular = findViewById(R.id.btnCalcular) as Button
        btnLimpiar = findViewById(R.id.btnLimpiar) as Button
        btnCerrar = findViewById(R.id.btnCerrar) as Button
    }
    private fun eventosClic(){
        btnCalcular.setOnClickListener({
            var gradosText = txtGrados.text.toString()
            if(gradosText.isEmpty()) {
                Toast.makeText(this,"Informacion incompleta", Toast.LENGTH_SHORT).show()
            } else {
                val grados: Float = gradosText.toFloat()
                if (rdbCelciusAFarenheit.isChecked) {
                    val fahrenheit = (grados * 9 / 5) + 32
                    lblResultado.text = fahrenheit.toString()
                } else if (rdbFareneheitACelcius.isChecked) {
                    val celsius = (grados - 32) * 5 / 9
                    lblResultado.text = celsius.toString()
                }
            }



        })

        btnLimpiar.setOnClickListener({
            val a = "El resultado se mostrara aqui"
            lblResultado.setText(a)
            txtGrados.setText("")
        })

        btnCerrar.setOnClickListener({
            finish()
        })
    }
}