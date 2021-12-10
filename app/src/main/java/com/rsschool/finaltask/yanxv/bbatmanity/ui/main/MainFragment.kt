package com.rsschool.finaltask.yanxv.bbatmanity.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.rsschool.finaltask.yanxv.bbatmanity.R
import com.rsschool.finaltask.yanxv.bbatmanity.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        setListener()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setListener() {
        binding.openMap.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_mainFragment_to_mapsActivity)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                onOpenSettings()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun onOpenSettings() {
        Navigation.findNavController(binding.root).navigate(R.id.action_mainFragment_to_settingsFragment)
    }
}