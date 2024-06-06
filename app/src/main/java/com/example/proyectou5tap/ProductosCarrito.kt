package com.example.carrito

import java.io.Serializable

data class ProductosCarrito(
    val imagen: Int,
    val nombre: String,
    val detalle: String,
    val precio: Double
) : Serializable