package com.ibrajix.abegclone.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ibrajix.abegclone.R
import com.ibrajix.abegclone.databinding.LytDashboardBottomSheetBinding
import com.ibrajix.abegclone.utils.viewBinding

class DashboardBottomSheetFragment : BottomSheetDialogFragment() {

    private val binding by viewBinding(LytDashboardBottomSheetBinding::bind)
    private var mListener: ItemClickListener? = null
    private var bottomSheet: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lyt_dashboard_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomSheet = dialog?.findViewById(R.id.lyt_container)

        view.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {

                view.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val dialog = dialog as BottomSheetDialog
                val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
                val behavior = BottomSheetBehavior.from(bottomSheet!!)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED

                val newHeight = activity?.window?.decorView?.measuredHeight
                val viewGroupLayoutParams = bottomSheet.layoutParams
                viewGroupLayoutParams.height = newHeight ?: 0
                bottomSheet.layoutParams = viewGroupLayoutParams
            }
        })

        bottomSheet = view

        setUpViews()

    }

    private fun setUpViews() {

        // We can have cross button on the top right corner for providing elemnet to dismiss the bottom sheet
        //iv_close.setOnClickListener { dismissAllowingStateLoss() }
        //respond to click

        binding.icClose.setOnClickListener {
            dismissAllowingStateLoss()
        }

        binding.lytSearch .setOnClickListener {
            //go to search/explore frament
        }

        binding.lytCliques.setOnClickListener {
            //go to cliques fragment
        }

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ItemClickListener) {
            mListener = context
        } else {
            throw RuntimeException(
                "$context must implement ItemClickListener"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface ItemClickListener {
        fun onItemClick(item: String)

    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle): DashboardBottomSheetFragment {
            val fragment = DashboardBottomSheetFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}