package com.example.segundoapp

import java.io.Serializable
import kotlin.random.Random

class Constructor : Serializable {
    var numCotizacion:Int=0
    var descripcion:String =""
    var porPagInicial:Float= 0.0f
    var precio :Float = 0.0f;
    var plazos :Int = 0;

    constructor() {
        this.numCotizacion = 0;
        this.descripcion = "";
        this.porPagInicial = 0.0f;
        this.precio=0.0f
        this.plazos = 0;
    }
    public fun calcularPagoInicial():Float {
        var pagoInicial:Float=0.0f
        pagoInicial = precio * (this.porPagInicial)/100
        return pagoInicial
    }
    public fun calcularTotalFin():Float{
        return this.precio-this.calcularPagoInicial()
    }
    public fun calcularPagoMensual():Float{
        return this.calcularTotalFin()/this.plazos
    }
    public fun generaFolio() :Int {
        return Random(333).nextInt()%1001
    }
}