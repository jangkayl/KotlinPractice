package utils

import android.widget.EditText

fun EditText.isEmpty(): Boolean {
    return this.text.isBlank()
}