package com.example.mascaras

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity

class   MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*
     Validacion de contraseña e usuario no vacio
      */
    fun validacion(view: View) {
        val us = findViewById<EditText>(R.id.txtUser)
        val pass = findViewById<EditText>(R.id.txtPass)

        val usr = us.text.toString()
        val ps = pass.text.toString()

        val bandera: Boolean

        if (usr.isNotEmpty() && ps.isNotEmpty()) {
            var tam = 0
            var may = 0
            var num = 0
            for (caracter in ps) {
                if (caracter.isUpperCase()) {
                    may++
                }
                if (caracter.isDigit()) {
                    num++
                }
                tam++
            }

            if (may > 0 && num > 0 && tam >= 8) {
                //aqui mandar a llamar

                val elementos = arraySingelton.arrayClientes
                var encontrado = false

                for (cliente in elementos) {
                    if (cliente.email == usr && cliente.contraseña == ps) {
                        encontrado = true
                        break // Sal del bucle si se encuentra una coincidencia
                    }
                }

                if (encontrado) {


                    //Llamar a producto
                    val intent = Intent(this, Productos::class.java)
                    startActivity(intent)


                } else {
                    val context = this
                    val alertDialog = AlertDialog.Builder(context).setMessage("Sesión Fallida")
                        .setPositiveButton("Aceptar") { dialog, _ ->
                            // Acción a realizar cuando se presiona el botón "Aceptar" en el cuadro de diálogo.
                            dialog.dismiss()
                        }.create()
                    alertDialog.show() // Muestra el cuadro de diálogo
                }


            } else {
                val context = this
                val alertDialog = AlertDialog.Builder(context).setMessage("Contraseña inválida")
                    .setPositiveButton("Aceptar") { dialog, _ ->
                        dialog.dismiss()
                    }.create()
                alertDialog.show() // Muestra el cuadro de diálogo
            }

        } else {
            val context = this
            val alertDialog = AlertDialog.Builder(context).setMessage("Llene todos los datos")
                .setPositiveButton("Aceptar") { dialog, _ ->
                    dialog.dismiss()
                }.create()
            alertDialog.show() // Muestra el cuadro de diálogo
        }
    }

    fun reg(view: View) {
        val intent = Intent(this, Actividad2Re::class.java)
        startActivity(intent)
    }

}

