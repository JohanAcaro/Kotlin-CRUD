package com.example.hito1JohanAcaroCRUD

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ProductoAdapter(private val context: Context, private var listado:ArrayList<Producto>):
    RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_producto,parent,false))
    }

    override fun onBindViewHolder(holder: ProductoAdapter.ViewHolder, position: Int) {
        holder.onBind(listado[position])
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(producto: Producto){
            itemView.findViewById<TextView>(R.id.tv_Id).text=producto.id.toString()
            itemView.findViewById<TextView>(R.id.tv_Nombre).text=producto.nombre
            itemView.findViewById<TextView>(R.id.tv_Unidades).text=producto.unidades.toString()
            itemView.findViewById<TextView>(R.id.tv_Precio).text=producto.precio
        }

    }

}