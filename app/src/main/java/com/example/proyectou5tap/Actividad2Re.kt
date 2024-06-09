package com.example.proyectou5tap

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity

class Actividad2Re : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2_re)
    }

    fun registroClientes(view: View) {
        val n = findViewById<EditText>(R.id.txtNombre)
        val ap = findViewById<EditText>(R.id.txtApellido)
        val c = findViewById<EditText>(R.id.txtEmail)
        val p = findViewById<EditText>(R.id.txtContraseña)

        val nombre = n.text.toString()
        val apellido = ap.text.toString()
        val correo = c.text.toString()
        val password = p.text.toString()

        if (nombre.isNotEmpty() && apellido.isNotEmpty() && correo.isNotEmpty() && password.isNotEmpty()) {
            val tam = password.length
            val may = password.count { it.isUpperCase() }
            val num = password.count { it.isDigit() }

            val passValida = tam >= 8 && may >= 1 && num >= 1

            if (passValida) {
                val cliente = Clientes(nombre, apellido, correo, password)
                arraySingelton.arrayClientes.add(cliente)
                val context = this
                val alertDialog = AlertDialog.Builder(context).setMessage("Registro Exitoso")
                    .setPositiveButton("Aceptar") { dialog, _ ->
                        dialog.dismiss()
                    }.create()
                alertDialog.show() // Muestra el cuadro de diálogo
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
            val alertDialog =
                AlertDialog.Builder(context).setMessage("Por favor, complete todos los campos")
                    .setPositiveButton("Aceptar") { dialog, _ ->
                        dialog.dismiss()
                    }.create()
            alertDialog.show() // Muestra el cuadro de diálogo
        }
    }


}