package com.laksamana.kalkulago.UIKalk
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laksamana.kalkulago.ui.theme.Black500
import com.laksamana.kalkulago.ui.theme.Black200
import com.laksamana.kalkulago.ui.theme.DarkWhite
@Composable
fun UIKalkulator( //TODO: MENDEKLARASIKAN FUNGSI CALCULATORUI DAN MEMANGGIL VIEW MODEL
    viewModel: VMKalkulator,
){
    val expression = viewModel.expression
    val buttonSpacing = 8.dp


    Log.d("MainActivity", "onCreate: ${viewModel.expression.value}") //TODO: MEMANGGIL SYSTEMUICONTROLLER DARI MAIN ACTIVITY, UNTUK MENETAPKAN WARNA BACKGROUND
    Box( //TODO: BOX BACKGROUND WARNA ABU-ABU KEHITAMAN
        modifier = Modifier
            .fillMaxSize()
            .background(com.laksamana.kalkulago.ui.theme.Black500)
    ) {

        Column( //TODO: SETTING KOLOM TOMBOL-TOMBOL
            modifier = Modifier
                .fillMaxWidth() //TODO: LEBAR KOLOM TOMBOL DIMAKSIMALKAN
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing), //TODO: UNTUK SPACING ANTARA TOMBOL
        ) {
            LazyRow( //TODO: ROW UNTUK BAGIAN ATAS (YANG MENUNJUKKAN ANGKA INPUT DAN HASIL) YANG DAPAT DISCROLL HORIZONTAL
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth(),
                reverseLayout = true
            ) {
                item {
                    Text( //TODO: TEKS BAGIAN ATAS (YANG MENUNJUKKAN INPUT DAN HASIL)
                        text = expression.value,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp, horizontal = 8.dp),
                        fontWeight = FontWeight.Light,
                        fontSize = 48.sp,
                        color = Color.White,
                        maxLines = 1
                    )
                }
            }
            Row( //TODO: BARIS TOMBOL TERATAS
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                TombolKalkDel( //TODO: TOMBOL UNTUK MENGKOSONGKAN KALKULATOR /CLEAR
                    symbol = "AC",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.clear()
                        }
                )

                TombolKalkOp( //TODO: TOMBOL UNTUK KURUNG BUKA
                    symbol = "(",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("(")
                        }
                )
                TombolKalkOp( //TODO: TOMBOL UNTUK KURUNG TUTUP
                    symbol = ")",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append(")")
                        }
                )

                TombolKalkOp( //TODO: TOMBOL UNTUK PEMBAGIAN
                    symbol = "÷",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("÷")
                        }
                )
            }
            Row( //TODO: BARIS UNTUK TOMBOL 7,8,9 DAN PERKALIAN
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                TombolKalk( //TODO: TOMBOL 7
                    symbol = "7",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("7")
                        }
                )
                TombolKalk( //TODO: TOMBOL 8
                    symbol = "8",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("8")
                        }
                )
                TombolKalk( //TODO: TOMBOL 9
                    symbol = "9",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("9")
                        }
                )
                TombolKalkOp( //TODO: TOMBOL UNTUK PERKALIAN
                    symbol = "×",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("×")
                        }
                )
            }
            Row( //TODO: BARIS UNTUK TOMBOL 4,5,6 DAN PENGURANGAN
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                TombolKalk( //TODO: TOMBOL 4
                    symbol = "4",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("4")
                        }
                )
                TombolKalk( //TODO: TOMBOL 5
                    symbol = "5",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("5")
                        }
                )
                TombolKalk( //TODO: TOMBOL 6
                    symbol = "6",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("6")
                        }
                )
                TombolKalkOp( //TODO: TOMBOL PENGURANGAN
                    symbol = "-",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("-")
                        }
                )
            }
            Row( //TODO: BARIS UNTUK TOMBOL 1,2,3 DAN PENAMBAHAN
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                TombolKalk( //TODO: TOMBOL 1
                    symbol = "1",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("1")
                        }
                )
                TombolKalk( //TODO: TOMBOL 2
                    symbol = "2",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)

                        .clickable {
                            viewModel.append("2")
                        }
                )
                TombolKalk( //TODO: TOMBOL 3
                    symbol = "3",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("3")
                        }
                )
                TombolKalkOp( //TODO: TOMBOL PENAMBAHAN
                    symbol = "+",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("+")
                        }
                )
            }
            Row( //BARIS TOMBOL TERBAWAH
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp,end = 16.dp,bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                TombolKalk( //TODO: TOMBOL 0
                    symbol = "0",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("0")
                        }
                )
                TombolKalk( //TODO: TOMBOL KOMA
                    symbol = ".",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append(".")
                        }
                )
                TombolKalkDel( //TODO: TOMBOL DELETE
                    symbol = "Del",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.delete()
                        }
                )
                TombolKalkOp( //TODO: TOMBOL EVALUASI/ HASIL PERHITUNGAN
                    symbol = "=",
                    color = Black200,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.evaluate()
                        }
                )
            }
        }
    }
}
