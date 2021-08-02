package com.ibrajix.abegclone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.ibrajix.abegclone.R
import com.ibrajix.abegclone.databinding.FragmentProfileBinding
import com.ibrajix.abegclone.ui.adapters.TabAdapter
import com.ibrajix.abegclone.utils.viewBinding

class ProfileFragment : Fragment() {

    private val binding by viewBinding(FragmentProfileBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews(){
        setUpViewPager()
        handleClicks()
    }


    private fun handleClicks(){

    }

    private fun setUpViewPager(){

        val fragmentList = arrayListOf(
            BadgesFragment(),
            TransactionsFragment(),
        )

        val adapter = TabAdapter(
            fragmentList,
            childFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

            when (position) {

                0 -> {
                    tab.text = requireContext().getString(R.string.badges)
                }
                1 -> {
                    tab.text = requireContext().getString(R.string.transactions)
                }

            }

        }.attach()


    }
}