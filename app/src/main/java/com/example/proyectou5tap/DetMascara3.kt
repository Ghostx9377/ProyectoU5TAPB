package com.example.mascaras

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class DetMascara3 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.masc3)
    }

    fun regM3(view : View){
        val intent = Intent(this,Productos::class.java)
        startActivity(intent)
    }

}