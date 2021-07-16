package com.fabiolsc.calculadoradeimc


import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main)
//        alturaInput?.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
//            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                cacularButton.performClick()
//                return@OnEditorActionListener true
//            }
//            false
//        })
        setListeners()
    }
    
    fun setListeners(){

        cacularButton.setOnClickListener{
            calculaIMC(pesoInput.text.toString(), alturaInput.text.toString())

        }
//        alturaInput?.doAfterTextChanged { text ->
//            Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
//
//        }
//        pesoInput?.doOnTextChanged{text, _, _, _ ->
//            tituloTextView.text = text
//        }
    }


    fun calculaIMC(peso: String, altura: String){
        val peso = peso.toDoubleOrNull()
        val altura = altura.toDoubleOrNull()
        if (peso != null && altura != null){
            val imc = peso / (altura * altura)
            if (imc >= 20 && imc<= 24){
                resumoTextView.setText("Seu IMC é:")
                valorIMCTextView.setText("%.2f".format(imc))
                statusIMCTextView.setText("")

            }else if (imc >= 25 && imc<= 29){
                resumoTextView.setText("Seu IMC é:")
                valorIMCTextView.setText("%.2f".format(imc))
                statusIMCTextView.setText("")



            }else if (imc >= 30 && imc<= 35){
                resumoTextView.setText("Seu IMC é:")
                valorIMCTextView.setText("%.2f".format(imc))
                statusIMCTextView.setText("")



            }else if (imc > 35){
                resumoTextView.setText("Seu IMC é:")
                valorIMCTextView.setText("0.2f".format(imc))
                statusIMCTextView.setText("")



            }
        }


    }
}