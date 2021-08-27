package com.test.application.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.test.application.MyApplication
import com.test.application.R
import com.test.application.R.layout
import com.test.application.databinding.FragmentFirstBinding
import com.test.application.ui.factory.FirstFragmentModelFactory


class FirstFragment : Fragment()
{

    lateinit var binding: FragmentFirstBinding

    private val viewModel: FirstFragmentViewModel by viewModels { FirstFragmentModelFactory(requireActivity().application as MyApplication) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, layout.fragment_first, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    companion object
    {
        private const val TAG = "FirstFragment"
    }
}