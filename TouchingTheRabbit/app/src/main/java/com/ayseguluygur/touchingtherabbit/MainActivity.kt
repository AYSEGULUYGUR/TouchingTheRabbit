package com.ayseguluygur.touchingtherabbit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*
import kotlin.collections.ArrayList
import android.view.View as View

class MainActivity : AppCompatActivity() {
    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Image
        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)
        imageArray.add(imageView16)

        hideImages()

        //CountDown Timer
        object  : CountDownTimer(20500,1000) {
            override fun onFinish() {

                timeText.text = "Time :0"

                handler.removeCallbacks(runnable)

                for(image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                //Alert
                var alert = AlertDialog.Builder(this@MainActivity)

                alert.setTitle("Oyun Bitti")
                alert.setMessage("Yeniden Oyna")
                alert.setPositiveButton("Evet") {dialog, which ->
                    //Restart
                    val intent = intent
                    finish()
                    startAvtivity(intent)

                }

                alert.setNegativeButton("Hayır") {dialog, whicg ->
                    Toast.makeText(this@MainActivity, "Oyun Bitti", Toast.LENGTH_LONG).show()
                }

                alert.show()

            }
            override fun onTick(millisUntilFinished: Long) {
                timeText.text = "Time :" + millisUntilFinisher/ 1000
            }

        }.start()
    }

    fun hideImages(){

        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(15)
                imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }

        handler.post { runnable }

    }

    fun increaseScore(view: View){
        score = score + 1
        scoreText.text = "Score: $score"
    }
}