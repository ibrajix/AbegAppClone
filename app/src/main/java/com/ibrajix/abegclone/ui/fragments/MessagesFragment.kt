package com.ibrajix.abegclone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ibrajix.abegclone.R
import com.ibrajix.abegclone.databinding.FragmentMessagesBinding
import com.ibrajix.abegclone.utils.viewBinding

class MessagesFragment : Fragment() {

    private val binding by viewBinding(FragmentMessagesBinding::bind)

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initView()
    }

    private fun initView(){

        handleClicks()

    }

    private fun handleClicks(){

        //on click back
        binding.icBack.setOnClickListener {
            navController.popBackStack()
        }

    }

}