package com.adarsh.lottieanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

class SecondActivity : AppCompatActivity() {

    private lateinit var owl: OwlModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        owl = OwlModelClass(owlimg)
        total.text=(owlimg.duration.toString())

        CoroutineScope(Dispatchers.Main).launch {
          async  {
                owlimg.progress = 17f
                owlimg.speed= 0.5f
                owlimg.setMinAndMaxFrame(5, 100)
                owlimg.playAnimation()
                val dur=owlimg.duration
                Log.d("BaseActivity", " PlayAnimation started and ended.")
               delay(dur)
            }.await()
            async {
                owlimg.progress = 127f
                owlimg.speed = 0.5f
                owlimg.setMinAndMaxFrame(127, 209)
                val dur=owlimg.duration
                owlimg.playAnimation()
                Log.d("BaseActivity", " ReadingAnimation started and ended.")
                delay(dur)
            }.await()
        }
    }


}
