package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_TITLE = "cafeTitleResId"
private const val ARG_DESC = "cafeDescResId"

class CafeDetailFragment : Fragment() {

    private var titleResId: Int? = null
    private var descResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            titleResId = it.getInt(ARG_TITLE)
            descResId = it.getInt(ARG_DESC)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleView = view.findViewById<TextView>(R.id.cafe_detail_title)
        val descView = view.findViewById<TextView>(R.id.cafe_detail_desc)

        titleResId?.let { titleView.text = getString(it) }
        descResId?.let { descView.text = getString(it) }
    }

    companion object {
        fun newInstance(titleResId: Int, descResId: Int) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TITLE, titleResId)
                    putInt(ARG_DESC, descResId)
                }
            }
    }
}
