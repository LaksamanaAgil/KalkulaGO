package com.laksamana.kalkulago


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.laksamana.kalkulago.ui.theme.KalkulaGOTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.laksamana.kalkulago.ui.theme.Black200
import com.laksamana.kalkulago.UIKalk.VMKalkulator
import com.laksamana.kalkulago.UIKalk.UIKalkulator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KalkulaGOTheme { //TODO: MEMANGGIL FUNGSI KalkulaGOTheme dari file Theme.kt
                val viewModel = VMKalkulator() //TODO: Menetapkan VMKalkulator.kt sebagai ViewModel
                val systemUiController = rememberSystemUiController() //TODO: MEMANGGIL SYSTEMUICONTROLLER DARI DEPENDECIES GOOGLE ACCOMPANIST
                SideEffect {
                    systemUiController.setSystemBarsColor( //TODO: MENETAPKAN BACKGROUND COLOR
                        color = Black200,
                        darkIcons = false
                    )

                }

                UIKalkulator( //TODO: Membinding File UI UIKalkulator dengan ViewModel VMKalkulator
                    viewModel = viewModel,
                )
            }
        }
    }
}