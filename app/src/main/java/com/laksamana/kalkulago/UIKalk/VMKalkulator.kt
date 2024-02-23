package com.laksamana.kalkulago.UIKalk
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.laksamana.kalkulago.Data.evaluate
class VMKalkulator {
    val expression = mutableStateOf("")
    fun clear() { //TODO: Function untuk clear/ mengkosongkan field perhitungan
        expression.value = ""
    }

    fun append(char: String) { //TODO: Function untuk operasi penambahan/pengurangan
        Log.d("append", "$char Expression Value:${expression.value}")
        if (char in "0123456789") { //TODO: If case jika karakter yang dimasukkan adalah angka
            expression.value += char
        }else if(char in "+-×÷") { //TODO: else if untuk karakter yang berupa operator
            if (expression.value.isNotEmpty()) { //TODO: Jika input sebelumnya operator, maka diubah sesuai input operator baru
                val lastChar = expression.value.last()
                if (lastChar in "+-×÷") {
                    expression.value = expression.value.dropLast(1)
                }
            }
            expression.value += char
        }else if(char == ".") {//TODO: Else if karakter yang dimasukkan tanda petik (untuk desimal)
            if (expression.value.isNotEmpty()) {
                val lastChar = expression.value.last()
                if (lastChar!='.') {
                    //TODO: Jika input sebelum tanda petik adalah sebuah operator, maka secara otomatis menambahkan 0 dibelakang tanda petik ( menjadi 0.)
                    if (lastChar in "+-×÷") {
                        expression.value += "0"
                    }
                    expression.value += char
                }
            }

        }else if(char =="("){ //TODO: Else if jikakarakter yang dimasukkan adalah kurung buka
            if (expression.value.isNotEmpty()) {
                val lastChar = expression.value.last()
                // TODO: JIKA MASUKAN SEBELUMNYA MERUPAKAN MASUKAN SELAIN PERHITUNGAN(MISALNYA MASUKAN ANGKA), MASUKAN SEBELUMNYA DAN MASUKAN DIDALAM KURUNG AKAN DIKALI
                if (lastChar !in "+-×÷") {
                    expression.value += "×"
                }
            }
            expression.value += char
        }else if(char ==")"){
            expression.value += char
        }
    }

    fun delete() { //todo: FUNGSI PENGHAPUSAN SATU DIGIT
        if (expression.value.isNotEmpty()) {
            expression.value = expression.value.dropLast(1)
        }
    }

    fun evaluate() { //TODO: FUNGSI EVALUASI /SAMA-DENGAN
        expression.value = try {
            val result = evaluate(expression.value)
            result.toString()
        } catch (e: Exception) { //TODO: JIKA OUTPUT TIDAK BENAR/ERROR
            "Error"
        }
    }
}