package com.adarsh.lottieanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.*
import java.time.Duration
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

class SecondActivity : AppCompatActivity() {

    private lateinit var owl: OwlModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


       owl = OwlModelClass(owlimg)

        CoroutineScope(Dispatchers.Main).launch {
          async  {
              val dur = owl.begin()
              delay(dur)
          }.await()

            async {
                val dur = owl.reading()
                delay(dur)
            }.await()

        }
    }


}
