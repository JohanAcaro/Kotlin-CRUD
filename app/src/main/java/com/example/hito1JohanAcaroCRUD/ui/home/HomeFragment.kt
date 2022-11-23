package com.example.hito1JohanAcaroCRUD.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hito1JohanAcaroCRUD.DataHelper
import com.example.hito1JohanAcaroCRUD.Producto
import com.example.hito1JohanAcaroCRUD.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {



    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root
        var id: EditText = binding.etId
        var nombre: EditText = binding.etNombre
        var unidades: EditText = binding.etUnidades
        var precio: EditText = binding.etPrecio

        val boton_add: Button = binding.btnAdd

        val dh=DataHelper(this)
        println(dh)


        boton_add.setOnClickListener(){
            var i = Integer.parseInt(id.text.toString())
            var n=nombre.text.toString()
            var u=Integer.parseInt(unidades.text.toString())
            var p=precio.text.toString()


            var listado=dh.getAllProducts()
            var existe=false
            for (list in listado){
                if (list.id==i){
                    Toast.makeText(this.context, "El id ya existe", Toast.LENGTH_SHORT).show()
                    existe=true
                    id.setText("")
                }
            }
            try {
                if (!existe){
                    dh.addProducto(Producto(i,n,u,p))
                    Toast.makeText(this.context, "Producto agregado", Toast.LENGTH_SHORT).show()
                    id.setText("")
                    nombre.setText("")
                    unidades.setText("")
                    precio.setText("")
                }
            }
            catch (e:Exception){
                Toast.makeText(this.context, "Error al agregar", Toast.LENGTH_SHORT).show()
            }




        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }






}