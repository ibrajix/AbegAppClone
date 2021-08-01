package com.ibrajix.abegclone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ibrajix.abegclone.R
import com.ibrajix.abegclone.databinding.FragmentCliquesBinding
import com.ibrajix.abegclone.utils.viewBinding

class CliquesFragment : Fragment() {

    lateinit var navController: NavController
    private val binding by viewBinding(FragmentCliquesBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cliques, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initViews()
    }

    private fun initViews(){
        handleClicks()
    }

    private fun handleClicks(){

        //on click dashboard
        binding.icMenu.setOnClickListener {
            activity?.supportFragmentManager.let {
                DashboardBottomSheetFragment.newInstance(Bundle()).apply {
                    if (it != null) {
                        show(it, tag)
                    }
                }
            }
        }

        //on click message
        binding.icComment.setOnClickListener {
            //navigate to message fragment
            val action = CliquesFragmentDirections.actionCliquesFragmentToMessagesFragment()
            navController.navigate(action)

        }

    }

}