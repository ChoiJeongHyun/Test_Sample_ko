package kr.co.example.codingtest_kakaocme.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class Utils {

    companion object {

        fun hideKeyboard(
            context: Context,
            view: View?
        ) {
            if (view != null) {
                val imm: InputMethodManager
                imm =
                    context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }

    }
}