package com.ibrajix.abegclone.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ibrajix.abegclone.R
import com.ibrajix.abegclone.databinding.FragmentDialerBinding
import com.ibrajix.abegclone.utils.viewBinding


class DialerFragment : Fragment(), View.OnClickListener {

    private val binding by viewBinding(FragmentDialerBinding::bind)
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        if (view.tag != null && "number_button" == view.tag) {
            binding.passwordField.append((view as TextView).text)
            return
        }
        when (view.id) {
            R.id.t9_key_clear -> {
                // handle clear button
                binding.passwordField.text = null
            }
            R.id.t9_key_backspace -> {
                // handle backspace button
                // delete one character
                val editable: Editable = binding.passwordField.text
                val charCount = editable.length
                if (charCount > 0) {
                    editable.delete(charCount - 1, charCount)
                }
            }
        }

        initViews()
    }

    private fun initViews(){

        startAnimation()

        handleClicks()

        setDialerViews()

    }

    private fun startAnimation(){

        YoYo.with(Techniques.FlipInX)
            .duration(3000)
            .repeat(3)
            .playOn(binding.imgLogo)

    }


    private fun handleClicks(){

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
            val action = DialerFragmentDirections.actionDialerFragmentToMessagesFragment()
            navController.navigate(action)

        }

        //on click dialer
        // handle number button click
        // handle number button click

    }

    override fun onClick(v: View?) {

        // handle number button click
        if (v?.tag != null && "number_button" == v.tag) {
            binding.passwordField.append((v as TextView).text)
            return
        }
        when (v?.id) {
            R.id.t9_key_clear -> {
                // handle clear button
                binding.passwordField.text = null
            }
            R.id.t9_key_backspace -> {
                // handle backspace button
                // delete one character
                val editable = binding.passwordField.text
                val charCount = editable.length
                if (charCount > 0) {
                    editable.delete(charCount - 1, charCount)
                }
            }
        }

    }


    private fun setDialerViews(){

        binding.t9Key0.setOnClickListener(this)
        binding.t9Key1.setOnClickListener(this)
        binding.t9Key2.setOnClickListener(this)
        binding.t9Key3.setOnClickListener(this)
        binding.t9Key4.setOnClickListener(this)
        binding.t9Key5.setOnClickListener(this)
        binding.t9Key6.setOnClickListener(this)
        binding.t9Key7.setOnClickListener(this)
        binding.t9Key8.setOnClickListener(this)
        binding.t9Key9.setOnClickListener(this)
        binding.t9KeyClear.setOnClickListener(this)
        binding.t9KeyBackspace.setOnClickListener(this)

    }

}