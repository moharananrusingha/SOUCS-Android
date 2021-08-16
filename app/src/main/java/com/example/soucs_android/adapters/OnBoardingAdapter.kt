package com.example.soucs_android.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.soucs_android.OnBoardingFragment1
import com.example.soucs_android.OnBoardingFragment2
import com.example.soucs_android.OnBoardingFragment3
import com.example.soucs_android.OnBoardingFragment4

class OnBoardingAdapter(fm: FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> OnBoardingFragment1()
            1 -> OnBoardingFragment2()
            2 -> OnBoardingFragment3()
            else -> OnBoardingFragment4()
        }
    }
}