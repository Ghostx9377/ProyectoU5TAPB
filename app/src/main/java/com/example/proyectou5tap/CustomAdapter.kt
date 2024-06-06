package com.example.carrito

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mascaras.R

interface OnItemClickListener {
    fun onItemDeleteClick(position: Int)
}

class CustomAdapter(val products: ArrayList<ProductosCarrito>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemNombre: TextView
        var itemDetalles: TextView
        var itemPrecio: TextView
        var btnEliminar: ImageButton

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemNombre = itemView.findViewById(R.id.item_nombre)
            itemDetalles = itemView.findViewById(R.id.item_detalles)
            itemPrecio = itemView.findViewById(R.id.item_precio)
            btnEliminar = itemView.findViewById(R.id.item_eliminar)

            btnEliminar.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener?.onItemDeleteClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val elements = products[i]
        viewHolder.itemImage.setImageResource(elements.imagen)
        viewHolder.itemNombre.text = elements.nombre
        viewHolder.itemDetalles.text = elements.detalle
        viewHolder.itemPrecio.text = "$" + elements.precio.toString()
    }
}

