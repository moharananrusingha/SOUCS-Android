package com.example.soucs_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs

class ResultFragment : Fragment() {

    private val args: ResultFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_result,container,false)
        val titleView = view.findViewById<TextView>(R.id.result_title)
        when(args.grade){
            0 -> titleView.text = getText(R.string.inclusion_farmer)
            1 -> titleView.text = getText(R.string.inclusion_rookie)
            2 -> titleView.text = getText(R.string.inclusion_champion)
            3 -> titleView.text = getText(R.string.inclusion_captain)
            4 -> titleView.text = getText(R.string.inclusion_pro)
        }
        return view
    }
}