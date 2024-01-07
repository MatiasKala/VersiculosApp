package com.example.versiculosapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.versiculosapp.databinding.FragmentHomeBinding
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.versiculosapp.factory.HomeViewModelFactory
import com.example.versiculosapp.models.Versiculo
import com.google.gson.Gson

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private var urlApi: String = "https://versiculos-app-back.onrender.com/api/versiculos"

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var queue: RequestQueue
    private lateinit var versiculoDestacado: Versiculo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        queue = Volley.newRequestQueue(this.context)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val req  = JsonObjectRequest (
            Request.Method.GET,urlApi+"/destacado",null,
            { response ->
                println("Llamada correcta")
                println(response.toString())
                val dataObject = response.getJSONObject("data")
                versiculoDestacado = Gson().fromJson(dataObject.toString(), Versiculo::class.java)
                println(versiculoDestacado.toString())

                // Valor que deseas pasar al ViewModel
                val versiculo= versiculoDestacado.content
                val versiculoCita= versiculoDestacado.reference
                val versiculoDestacadoTextView: TextView = binding.versiculoDestacado
                val textView: TextView = binding.tituloHome
                val versiculoDestacadoCitaTextView: TextView = binding.versiculoDestacadoCita

                val homeViewModel: HomeViewModel by viewModels {
                    HomeViewModelFactory(versiculo, versiculoCita)
                }

                homeViewModel.text.observe(viewLifecycleOwner) {
                    textView.text = it
                    versiculoDestacadoTextView.text = versiculo
                    versiculoDestacadoCitaTextView.text = versiculoCita
                }

            },
            {
                println(it)
            }
        )
        queue.add(req)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}