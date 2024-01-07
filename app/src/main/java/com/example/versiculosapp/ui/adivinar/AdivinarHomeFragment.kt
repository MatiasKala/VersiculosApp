package com.example.versiculosapp.ui.adivinar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.versiculosapp.databinding.FragmentAdivinarHomeBinding
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.versiculosapp.databinding.FragmentAdivinarBinding
import com.example.versiculosapp.databinding.FragmentHomeBinding

class AdivinarHomeFragment : Fragment() {

    private var _binding: FragmentAdivinarHomeBinding? = null
    private var urlApi: String = "https://versiculos-app-back.onrender.com/api/versiculos"

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var queue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        queue = Volley.newRequestQueue(this.context)


    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val adivinarViewModel =
            ViewModelProvider(this).get(AdivinarHomeViewModel::class.java)

        _binding = FragmentAdivinarHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val versiculoView: TextView = binding.tituloAdivinar

        adivinarViewModel.text.observe(viewLifecycleOwner) {
            versiculoView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}