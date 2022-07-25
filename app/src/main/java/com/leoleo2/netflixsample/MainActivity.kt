package com.leoleo2.netflixsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appLaunchHelper = AppLaunchHelper(this)

        findViewById<Button>(R.id.buttonLaunchNetflix).setOnClickListener {
            appLaunchHelper.launchNetflixApp(NetflixMovieData.MICHEL_JORDAN_LAST_DANCE_EPISODE1.watchId)
        }
    }
}