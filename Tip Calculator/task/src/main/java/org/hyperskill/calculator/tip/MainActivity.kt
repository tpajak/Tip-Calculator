package org.hyperskill.calculator.tip

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import android.text.Editable
import java.math.BigInteger


import android.text.TextWatcher


class MainActivity : AppCompatActivity() {
    private lateinit var tipTextView: TextView
    val tip: Tip = Tip(0.0, 0, "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tipTextView = findViewById(R.id.text_view)
        val inputEditText: EditText = findViewById(R.id.edit_text)
        val sliderSlider: Slider = findViewById(R.id.slider)


        inputEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (!inputEditText.text.isEmpty()) {
                    tip.bill = inputEditText.text.toString().toDouble()
                    tip.text = inputEditText.text.toString()
                    updateTextView()
                } else {
                    tip.bill = 0.0
                    tipTextView.text = ""
                }

//                tipTextView.text = inputEditText.text
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        sliderSlider.addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->
//            if (value)
            tip.tipPercentage = value.toInt()
            updateTextView()
//            tipTextView.text = "Slider : ${sliderSlider.value.toString()}"
        })


    }

    fun updateTextView() {
        var mTip = tip.getTip()
        if (tip.bill != 0.0) {
//            tipTextView.text = "Bill value: ${tip.text}, tip percentage: ${tip.tipPercentage}%"
            tipTextView.text = "Tip amount: %.2f".format(mTip)
        } else {
            tipTextView.text = ""
        }
    }


}

fun toNaturalNumber(value: Double): String {
    return value.toString().dropLast(2)
}
