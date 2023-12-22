package com.nhkim.ui1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class LikeHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like_home)

        val houseViews = listOf(
            findViewById<ConstraintLayout>(R.id.first_house),
            findViewById<ConstraintLayout>(R.id.second_house),
            findViewById<ConstraintLayout>(R.id.third_house)
        )

        val sendList = intent.getStringArrayListExtra("sendList") ?: arrayListOf()


        if (sendList.isNotEmpty()) {
            sendList.forEachIndexed { index, liked ->
                if (index < houseViews.size) {
                    houseViews[index].visibility = if(liked.toBoolean()) View.VISIBLE else View.GONE
                }
            }
        }

    }
}