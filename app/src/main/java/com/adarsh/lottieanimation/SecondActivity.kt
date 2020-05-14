package com.adarsh.lottieanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private lateinit var owl: OwlModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       owl = OwlModelClass(owlimg)
        inputEmail.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                owl.preTracking()
            }
        }

        inputPassword.setOnFocusChangeListener{_, hasFocus ->
            if(hasFocus){
                owl.focusChange()
            }
        }

        inputEmail.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //    owl.preTracking()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                owl.setEyesPosition(getTextWidth(inputEmail) / inputEmail.width)
                Log.d("ONTEXTCHANGED",getTextWidth(inputEmail).toString() +  " -> "+inputEmail.width.toString() +  (getTextWidth(inputEmail) / inputEmail.width))
            }

        })


        /*
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
        */
    }
    private fun getTextWidth(editText: TextInputEditText): Float {
        return editText.paint.measureText(editText.text.toString())
    }

}
