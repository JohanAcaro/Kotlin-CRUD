package com.example.hito1JohanAcaroCRUD.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.widget.Button
import android.widget.Toast
import com.example.hito1JohanAcaroCRUD.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var boton_enviar: Button = binding.btnEnviar
        var nombreIncidencia = binding.etNombreIncidencia
        var inidencia = binding.etIncidencia

        boton_enviar.setOnClickListener(){

            if(nombreIncidencia.text.toString().isNotEmpty() && inidencia.text.toString().isNotEmpty()){
                try {
                    Toast.makeText(this.context, "Incidencia enviada", Toast.LENGTH_SHORT).show()
                }
                catch (e:Exception){
                    Toast.makeText(this.context, "Error al enviar la incidencia", Toast.LENGTH_SHORT).show()

                }
                nombreIncidencia.setText("")
                inidencia.setText("")
            }else{
                Toast.makeText(this.context, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
