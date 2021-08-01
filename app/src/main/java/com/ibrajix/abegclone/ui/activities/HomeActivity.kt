package com.ibrajix.abegclone.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.ibrajix.abegclone.R
import com.ibrajix.abegclone.databinding.ActivityHomeBinding
import com.ibrajix.abegclone.ui.fragments.DashboardBottomSheetFragment
import com.ibrajix.abegclone.utils.Utility.transparentStatusBar
import com.ibrajix.abegclone.utils.Utility.viewBinding


class HomeActivity : AppCompatActivity(), DashboardBottomSheetFragment.ItemClickListener {

    private val binding by viewBinding(ActivityHomeBinding::inflate)
    lateinit var navController: NavController
    private var backPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        transparentStatusBar()
        setContentView(binding.root)

        initView()

    }

    private fun initView(){


        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHost.navController

        binding.bottomNavigation.setupWithNavController(navController)

        binding.bottomNavigation.setOnItemReselectedListener {
            //do something when selected twice
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(
                item,
                Navigation.findNavController(this, R.id.nav_host_fragment)
            )
        }

        binding.bottomNavigation.itemIconTintList = null


    }



    override fun onBackPressed() {

        val navControl = findNavController(R.id.nav_host_fragment)

        // Check if the current destination is actually the start sestination (Home screen)
        if (navControl.graph.startDestination == navController.currentDestination?.id)
        {
            val exitIntent = Intent(Intent.ACTION_MAIN)
            exitIntent.addCategory(Intent.CATEGORY_HOME)
            exitIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(exitIntent)

        }
        else {
            super.onBackPressed()
        }


    }

    override fun onItemClick(item: String) {
        //respond to item clicks
    }

}