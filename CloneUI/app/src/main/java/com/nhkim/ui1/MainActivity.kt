package com.nhkim.ui1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstHouse = findViewById<ConstraintLayout>(R.id.first_house)
        val secondHouse = findViewById<ConstraintLayout>(R.id.second_house)
        val thirdHouse = findViewById<ConstraintLayout>(R.id.third_house)

        val btnLikeHouse = findViewById<ConstraintLayout>(R.id.btn_like_house)

        val heartViews = listOf(
            findViewById<ImageView>(R.id.empty_heart1),
            findViewById<ImageView>(R.id.empty_heart2),
            findViewById<ImageView>(R.id.empty_heart3)
        )

        heartViews.forEach { heartView ->
            heartView.tag = false
            heartView.setOnClickListener {
                val isClicked = heartView.tag as Boolean
                if(!isClicked){
                    heartView.setImageResource(R.drawable.full_heart)
                    heartView.tag = true
                }
                else{
                    heartView.setImageResource(R.drawable.empty_heart)
                    heartView.tag = false
                }
                Log.d("1번째 집",heartViews[0].tag.toString())
                Log.d("2번째 집",heartViews[1].tag.toString())
                Log.d("3번째 집",heartViews[2].tag.toString())
            }
        }

        firstHouse.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:01011111111")
            startActivity(intent)
        }

        secondHouse.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:01022222222")
            startActivity(intent)
        }

        thirdHouse.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:01033333333")
            startActivity(intent)
        }

        btnLikeHouse.setOnClickListener {
            val sendList = mutableListOf<String>()

            heartViews.forEach { hearView ->
                sendList.add((hearView.tag as Boolean).toString())
            }

            // sendList에는 [true, false, false]같은 배열이 들어있음
            val intent = Intent(this, LikeHomeActivity::class.java)
            intent.putStringArrayListExtra("sendList", ArrayList(sendList))
            startActivity(intent)
        }
    }

}