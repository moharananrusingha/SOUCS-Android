package com.example.soucs_android

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.soucs_android.adapters.OnBoardingAdapter

class OnBoardingActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager_on_boarding)
        viewPager.adapter = OnBoardingAdapter(this)

    }
}