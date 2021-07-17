package com.fabiolsc.calculadoradeimc


import android.graphics.Color
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Retirar barra de menu e deixar em tela cheia ---------------------------------------------
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        //Subimit pelo ultimo EditText -------------------------------------------------------------
        setContentView(R.layout.activity_main)
        alturaInput?.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                cacularButton.performClick()
                return@OnEditorActionListener true
            }
            false
        })

        //Subimit pelo botão calcular --------------------------------------------------------------
        setListeners()
    }
    
    fun setListeners(){
        // Ao clicar no botão enviar os dados e calcula o IMC --------------------------------------
        cacularButton.setOnClickListener{
            calculaIMC(pesoInput.text.toString(), alturaInput.text.toString())
        }

    }


    fun calculaIMC(peso: String, altura: String){

        //Ocultar teclado o enviar dados -----------------------------------------------------------
        val imm: InputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive()) imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

       //Calcular IMC ------------------------------------------------------------------------------
        val peso = peso.toDoubleOrNull()
        val altura = altura.toDoubleOrNull()
        if (peso != null && altura != null){

            val imc = peso / (altura * altura)

            if (imc < 20) {
                resumoTextView.setText("Seu IMC é:")
                valorIMCTextView.setText("%.2f".format(imc))
                statusIMCTextView.setText("Você está abaixo do peso!")

            }else if (imc >= 20 && imc<= 24){
                resumoTextView.setText("Seu IMC é:")
                valorIMCTextView.setText("%.2f".format(imc))
                statusIMCTextView.setText("Seu peso está normal!")

                valorIMCTextView.setTextColor(Color.GREEN)
                statusIMCTextView.setTextColor(Color.GREEN)

            }else if (imc >= 25 && imc<= 29){
                resumoTextView.setText("Seu IMC é:")
                valorIMCTextView.setText("%.2f".format(imc))
                statusIMCTextView.setText("Você está acima do peso!")

                valorIMCTextView.setTextColor(Color.MAGENTA)
                statusIMCTextView.setTextColor(Color.MAGENTA)



            }else if (imc >= 30 && imc<= 35){
                resumoTextView.setText("Seu IMC é:")
                valorIMCTextView.setText("%.2f".format(imc))
                statusIMCTextView.setText("Você encontra-se com obesidade!")

                valorIMCTextView.setTextColor(Color.YELLOW)
                statusIMCTextView.setTextColor(Color.YELLOW)



            }else if (imc > 35){
                resumoTextView.setText("Seu IMC é:")
                valorIMCTextView.setText("%.2f".format(imc))
                statusIMCTextView.setText("Você encontra-se com super obesidade!")

                valorIMCTextView.setTextColor(Color.RED)
                statusIMCTextView.setTextColor(Color.RED)



            }
        }


    }
}