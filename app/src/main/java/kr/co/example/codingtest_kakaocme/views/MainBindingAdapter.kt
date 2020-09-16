package kr.co.example.codingtest_kakaocme.views

import android.graphics.Color
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.nostra13.universalimageloader.core.ImageLoader

@BindingAdapter(value = ["isClickBackgroundColor"])
fun setClickerBackgroundColor(textView: TextView, text: String) {
    if (textView.text == text) textView.setBackgroundColor(Color.GRAY) else textView.setBackgroundColor(
        Color.WHITE
    )
}

@BindingAdapter(value = ["imageUrl"])
fun loadImage(imageView: ImageView, url: String) {
    ImageLoader.getInstance().displayImage(url, imageView)
}

@BindingAdapter(value = ["viewModel"])
fun keyBoardSearch(editText: EditText, vm: MainViewModel){
    editText.setOnEditorActionListener(object: TextView.OnEditorActionListener{
        override fun onEditorAction(textView: TextView, actionId : Int, keyEvent: KeyEvent?): Boolean {
            when(actionId){
                EditorInfo.IME_ACTION_SEARCH -> {
                    vm.search(editText.text.toString())
                    return true
                }
            }
            return false
        }
    })
}



