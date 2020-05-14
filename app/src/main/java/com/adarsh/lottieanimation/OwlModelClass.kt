package com.adarsh.lottieanimation

import android.util.Log
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.delay

class OwlModelClass (var owlView: LottieAnimationView ) {

    companion object{
        const val TRACKING_START =0.0f
        const val TRACKING_END = 239.0f
        const val TOTAL_FRAMES = 239.0f

        const val NEUTRAL = 0
        const val READING =1
        const val CLOSING = 2
        const val OPENING = 3

        const val FORWARD = 1.0f
        const val REVERSE = -1.0f

        const val OPEN_TO_CLOSE_EYES = 17
        const val CLOSE_TO_OPEN_EYES = 28

        const val NORMAL_TO_READING = 77

        const val LOOKING_DOWN_START = 77
        const val COMPLETE_DOWN = 107
        const val READING_START = 140
        const val READING_STOP = 200

        const val READING_TO_NEUTRAL = 201

    }

    private var currentStatus = NEUTRAL
    private var playingDirection = FORWARD

    private val ChangeOfState = mapOf(
        NORMAL_TO_READING to arrayOf(77,90),
        READING_START to arrayOf()

    )

    init {

        owlView.setAnimation("owllookingasset.json")
        begin()
    }

    fun begin():Long{

        // owlimg.progress = (17f / 239f)
        owlView.speed= 0.5f
        owlView.setMinAndMaxFrame(17, 27)
        owlView.playAnimation()
        //val dur=owlimg.duration
        val dur = ((owlView.speed)*(owlView.maxFrame - owlView.minFrame ) * 500).toLong()
        Log.d("BaseActivity", " PlayAnimation started and ended."+ dur)
        return dur
    }

    fun reading(): Long {

        //owlimg.progress = 127f
        owlView.speed = 0.5f
        owlView.setMinAndMaxFrame(127, 209)
        //val dur=owlimg.duration
        owlView.playAnimation()
        //   total.text = (owlimg.duration.toString())
        val dur = ((owlView.speed)*(owlView.maxFrame - owlView.minFrame ) * 1000).toLong()
        Log.d("BaseActivity", " PlayAnimation started and ended."+ dur)
        return dur
    }

    fun pause(){
        owlView.pauseAnimation()
    }

    fun setNeutralState(){

    }
}