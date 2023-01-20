package com.example.listeners

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.listeners.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var contador1 = false
    var contador2 = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.editText1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                intercambiar()
                binding.textView2.setText("editText1")
            }
        })
        binding.editText2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                intercambiar()
                binding.textView2.setText("editText2")}

        })
        var text1=""
        var text2=""
        binding.button.setOnClickListener(){
            text1=binding.editText1.text.toString()
            text2=binding.editText2.text.toString()
            text1=text1+text2
            binding.editText1.setText(text1)
            binding.editText2.setText("")
            intercambiar()
        }
    }

    fun intercambiar (){
        if(binding.editText1.length()>0){
            contador2 = true
            if (contador1) {
                binding.button.visibility = View.VISIBLE
            }
        }
        else { contador2 = false
            binding.button.visibility = View.INVISIBLE
        }
        if(binding.editText2.length()>0){
            contador1 = true
            if (contador2) {
                binding.button.visibility = View.VISIBLE
            }
        }
        else { contador1 = false
            binding.button.visibility = View.INVISIBLE}

    }

}
