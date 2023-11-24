package com.leoleo2.netflixsample

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import android.widget.Toast

class AppLaunchHelper(private val context: Context) {

    /**
     * example
     * https://www.netflix.com/watch/81002655
     */
    fun launchNetflixApp(watchId: String) {
        kotlin.runCatching {
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.netflix.com/watch/$watchId")
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }.let {
                context.startActivity(it)
            }
        }.onFailure {
            when (it) {
                is ActivityNotFoundException -> {
                    val message = it.localizedMessage ?: "launch app error."
                    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}