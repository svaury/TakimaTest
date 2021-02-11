package com.example.katatakima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        convertButton.setOnClickListener { calculateResult()  }
    }

   fun calculateResult(){
       if(!editText.text.toString().isEmpty()) {
           val result = Utils.calculateResult(editText.text.toString())
           if(result == -1){
                Toast.makeText(this, "Le format n'est pas bon.",Toast.LENGTH_LONG).show()
           }else{

               resultTextView.text = ""+result
           }
       }
    }
}