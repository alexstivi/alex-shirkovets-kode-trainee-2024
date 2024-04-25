package com.example.alex_shirkovets_kode_trainee_2024.presentation.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/*
color = MaterialTheme.colorScheme.onSurface,
fontSize = 24.sp,
fontFamily = InterFontFamily,
fontWeight = FontWeight.Bold,
fontStyle = FontStyle.Normal,
lineHeight = 28.sp,
*/



@Preview(showBackground = true)
@Composable
fun Tub() {

    val tubName = "Name"
    val tubTextStyle = TextStyle(
        background = MaterialTheme.colorScheme.background,
        color = MaterialTheme.colorScheme.onSurface,
       /* fontStyle = ,
        fontSize = ,
        fontFamily = ,
        fontWeight =*/
    )

    Box(modifier = Modifier
        .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
        Text(text = tubName,
            style = tubTextStyle
        )
    }
}
