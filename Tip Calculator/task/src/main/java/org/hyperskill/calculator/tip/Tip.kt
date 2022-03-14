package org.hyperskill.calculator.tip

class Tip(
    var bill: Double,
    var tipPercentage: Int,
    var text: String
) {
    fun getTip(): Double {
        val mTip = bill * tipPercentage / 100
        return mTip
    }
}