package com.adarsh.lottieanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private lateinit var owl: OwlModelClass
    private var PasswordToggle = false

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
                owl.preTracking()
            }
        }

        inputEmail.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(p0: Editable?) {
             }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                owl.setEyesPosition(getTextWidth(inputEmail) / inputEmail.width)
                Log.d("ONTEXTCHANGED",getTextWidth(inputEmail).toString() +  " -> "+inputEmail.width.toString() +  (getTextWidth(inputEmail) / inputEmail.width))
            }

        })

        inputPassword.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
               // owl.focusChange()
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(inputLayout.isPasswordVisibilityToggleEnabled){
                 //  owl.reversePreTracking()
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val text = inputPassword.text.toString()
                if(!PasswordToggle && (!text.isEmpty())){
                    owl.closeEyes()
                } else {
                    owl.setEyesPosition(getTextWidth(inputPassword) / inputPassword.width)
                }
            }
        })


        inputLayout.setEndIconOnClickListener {
            val editText = inputLayout.editText
            val oldSelection = editText?.selectionEnd
            val hidePassword = editText?.transformationMethod !is PasswordTransformationMethod
            inputPassword.transformationMethod = PasswordTransformationMethod.getInstance().takeIf { hidePassword }
            if (oldSelection!! >= 0) {
                inputPassword.setSelection(oldSelection)
            }
                PasswordToggle = PasswordToggle!=true
        }

        //This no longer needed
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

