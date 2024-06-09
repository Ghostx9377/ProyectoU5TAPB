package com.example.proyectou5tap

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class DetZapato6 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.det_zapa6)
    }

    fun regM6(view : View){
        val intent = Intent(this,Productos::class.java)
        startActivity(intent)
    }

}