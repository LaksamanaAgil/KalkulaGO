package com.laksamana.kalkulago.UIKalk
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laksamana.kalkulago.ui.theme.Cyan
import com.laksamana.kalkulago.ui.theme.DarkWhite
import com.laksamana.kalkulago.ui.theme.Red
@Composable
fun TombolKalkDel( //TODO: Function TombolKalk untuk tombol AC/Clear All dan Delete
    symbol: String,  //TODO: Atribut-atribut TombolKalkDel
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    textStyle: TextStyle = TextStyle(),
) {
    Box( //TODO: Box/Kotak Tombol
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .then(modifier)
    ) {
        Text( //TODO: Text untuk simbol Button/tombol
            text = symbol,
            style = textStyle,
            fontSize = 32.sp,
            color = Red,
        )
    }
}