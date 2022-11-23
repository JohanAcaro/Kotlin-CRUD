package com.example.hito1JohanAcaroCRUD.ui.dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.hito1JohanAcaroCRUD.DataHelper
import com.example.hito1JohanAcaroCRUD.ProductoAdapter
import com.example.hito1JohanAcaroCRUD.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        val root: View = binding.root
        var recycler: RecyclerView =binding.rvProductos


        var boton_refrescar: TextView = binding.btnRefresh

        val dh = DataHelper(this)
        println(dh)

        var listado=dh.getAllProducts()

        recycler.layoutManager=LinearLayoutManager(this.context)
        recycler.adapter=ProductoAdapter(this.context!!,listado)

        boton_refrescar.setOnClickListener(){
            listado=dh.getAllProducts()

            recycler.layoutManager=LinearLayoutManager(this.context)
            recycler.adapter=ProductoAdapter(this.context!!,listado)
            Toast.makeText(this.context, "Lista actualizada", Toast.LENGTH_SHORT).show()

        }



        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}