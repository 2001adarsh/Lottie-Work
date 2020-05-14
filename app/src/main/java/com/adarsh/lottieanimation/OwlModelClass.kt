package com.adarsh.lottieanimation

import android.util.Log
import com.airbnb.lottie.LottieAnimationView
import kotlin.math.min

class OwlModelClass (var owlView: LottieAnimationView ) {

    companion object{
        const val TRACKING_START =140.0f
        const val TRACKING_END = 209.0f
        const val TOTAL_FRAMES = 239.0f
    }

    init {
        owlView.setAnimation("owllookingasset.json")
        begin()
    }

    fun begin(){
        owlView.speed= 0.75f
        owlView.setMinAndMaxFrame(15, 39)
        owlView.loop(true)
        owlView.playAnimation()
    }

    fun reading() {
        owlView.cancelAnimation()
        //owlimg.progress = 127f
        //owlView.speed = 0.5f
        owlView.setMinAndMaxFrame(127, 209)
        //val dur=owlimg.duration
        owlView.playAnimation()
        //   total.text = (owlimg.duration.toString())
      //  val dur = ((owlView.speed)*(owlView.maxFrame - owlView.minFrame ) * 1000).toLong()
       // Log.d("BaseActivity", " PlayAnimation started and ended."+ dur)
        //return dur
    }

    fun pause(){
        owlView.pauseAnimation()
    }

    fun preTracking(){
        owlView.loop(false)
        owlView.speed= 0.6f
        owlView.setMinAndMaxFrame(73, 127)
        owlView.playAnimation()
    }
    fun reversePreTracking(){
        owlView.loop(false)
        owlView.speed= -0.6f
        owlView.setMinAndMaxFrame(73, 127)
        owlView.playAnimation()
    }

    fun focusChange(){
        owlView.loop(false)
        owlView.speed = 0.5f
        owlView.setMinAndMaxFrame(208, 239)
        owlView.playAnimation()
    }

    fun setEyesPosition(fl: Float) {
        owlView.loop(false)
        val progress = position(fl, 0f, 1f, TRACKING_START/ TOTAL_FRAMES, TRACKING_END/ TOTAL_FRAMES ) - 0.1f
        owlView.setMinAndMaxFrame(140, 209)
        owlView.speed = 0.25f
        owlView.progress = progress
        Log.d("Progress-> " , progress.toString())
    }

    fun position(progress:Float, start:Float, stop:Float, minframe:Float, maxframe:Float ): Float{
        return (minframe + (maxframe - minframe) * progress)
    }

    fun closeEyes(){
        owlView.loop(false)
        owlView.speed = 0.5f
        owlView.setMinAndMaxFrame(20,28)
        owlView.progress = 0.75f
    }
}