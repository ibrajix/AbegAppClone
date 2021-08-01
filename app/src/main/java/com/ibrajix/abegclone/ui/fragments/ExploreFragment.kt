package com.ibrajix.abegclone.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ibrajix.abegclone.R
import com.ibrajix.abegclone.databinding.FragmentExploreBinding
import com.ibrajix.abegclone.utils.viewBinding

class ExploreFragment : Fragment() {


    private val binding by viewBinding(FragmentExploreBinding::bind)

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        initView()
        handleClicks()
    }

    private fun initView(){


        binding.lytAll.setOnClickListener {

            //change the background
            binding.lytAll.setBackgroundResource(R.drawable.lyt_with_stroke_filled)
            binding.txtAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

            //others
            binding.lytMerch.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtMerch.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

            binding.lytBadges.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtBadges.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

            binding.lytFood.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtFood.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

        }
        binding.lytMerch.setOnClickListener {

            //change the background
            binding.lytMerch.setBackgroundResource(R.drawable.lyt_with_stroke_filled)
            binding.txtMerch.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

            //others
            binding.lytAll.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

            binding.lytBadges.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtBadges.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

            binding.lytFood.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtFood.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

        }

        binding.lytBadges.setOnClickListener {

            //change the background
            binding.lytBadges.setBackgroundResource(R.drawable.lyt_with_stroke_filled)
            binding.txtBadges.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

            //others
            binding.lytAll.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

            binding.lytMerch.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtMerch.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

            binding.lytFood.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtFood.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

        }

        binding.lytFood.setOnClickListener {

            //change the background
            binding.lytFood.setBackgroundResource(R.drawable.lyt_with_stroke_filled)
            binding.txtFood.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

            //others
            binding.lytMerch.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtMerch.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

            binding.lytBadges.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtBadges.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

            binding.lytAll.setBackgroundResource(R.drawable.lyt_with_stroke)
            binding.txtAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

        }

    }

    private fun handleClicks(){

        //on click dashboard menu
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
            val action = ExploreFragmentDirections.actionExploreFragmentToMessagesFragment()
            navController.navigate(action)

        }

    }

}