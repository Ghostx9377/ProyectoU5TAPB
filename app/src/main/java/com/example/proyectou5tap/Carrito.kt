package com.example.mascaras

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carrito.CustomAdapter
import com.example.carrito.OnItemClickListener
import com.example.carrito.ProductosCarrito
import com.example.mascaras.ArrayCarritoSingleton.produts

class Carrito : AppCompatActivity(), OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.carro_layout)

        recyclerView = findViewById(R.id.recyclerView)

        //Carrito1
        val obj1 = intent.getSerializableExtra("mascara1") as? ProductosCarrito

        if (obj1 != null) {
            produts.add(obj1)
        }

        //Carrito2
        val obj2 = intent.getSerializableExtra("mascara2") as? ProductosCarrito

        if (obj2 != null) {
            produts.add(obj2)
        }

        //Carrito 3
        val obj3 = intent.getSerializableExtra("mascara3") as? ProductosCarrito

        if (obj3 != null) {
            produts.add(obj3)
        }

        //Carrito 4
        val obj4 = intent.getSerializableExtra("mascara4") as? ProductosCarrito

        if (obj4 != null) {
            produts.add(obj4)
        }

        //Carrito 5
        val obj5 = intent.getSerializableExtra("mascara5") as? ProductosCarrito

        if (obj5 != null) {
            produts.add(obj5)
        }

        //Carrito 6
        val obj6 = intent.getSerializableExtra("mascara6") as? ProductosCarrito

        if (obj6 != null) {
            produts.add(obj6)
        }

        adapter = CustomAdapter(produts)
        adapter.setOnItemClickListener(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        calcularTotal()
    }

    override fun onItemDeleteClick(position: Int) {
        if (produts.isNotEmpty()) {
            if (position >= 0 && position < produts.size) {
                produts.removeAt(position)
                adapter.notifyItemRemoved(position) // Utiliza la variable global
                calcularTotal()
            }
        }
    }


    fun calcularTotal() {
        val txtTotal: TextView = findViewById(R.id.txtTotal)
        var total = 0.0
        for (elemento in produts) {
            total += elemento.precio.toDouble()
        }
        txtTotal.text = "Total: $" + String.format("%.2f", total)
    }

    fun reg(view : View){
        val intent = Intent(this,Productos::class.java)
        startActivity(intent)
    }
}

