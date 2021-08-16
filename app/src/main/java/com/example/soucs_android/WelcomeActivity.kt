package com.example.soucs_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }
    fun onPlayButtonClick(view: View){
        /*PreferenceManager.getDefaultSharedPreferences(this).apply {
            if (!getBoolean(MyOnBoardingFragment.COMPLETED_ONBOARDING_PREF_NAME, false)) {
                startActivity(Intent(this@WelcomeActivity, OnBoardingActivity::class.java))
            }
        }*/
        startActivity(Intent(this@WelcomeActivity, InclusionTilesActivity::class.java))
        //startActivity(Intent(this@WelcomeActivity, OnBoardingActivity::class.java))
    }
}