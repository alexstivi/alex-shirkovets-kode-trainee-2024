package com.example.alex_shirkovets_kode_trainee_2024.presentation.screens

import android.os.Build
import android.telephony.PhoneNumberUtils
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.alex_shirkovets_kode_trainee_2024.R
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.models.Employee
import com.example.alex_shirkovets_kode_trainee_2024.presentation.models.EmployeeSampleData.employeeSample
import com.example.alex_shirkovets_kode_trainee_2024.presentation.theme.ui.InterFontFamily
import java.time.LocalDate
import java.time.Period
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EmployeeFullInfoScreen(employee: Employee
) {


    Column {

        Spacer(
            modifier = Modifier
                .height(72.dp)
                .background(MaterialTheme.colorScheme.onTertiary)
                .fillMaxWidth()
        )
        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onTertiary),
                contentAlignment = Alignment.Center
            ) {

                AsyncImage(
                    model = employee.avatarUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(104.dp)
                        .clip(CircleShape)

                )
            }
            Spacer(
                modifier = Modifier
                    .height(24.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onTertiary)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onTertiary),
                contentAlignment = Alignment.Center
            ) {

                Row {

                    Text(
                        text = employee.firstName + " " + employee.lastName,
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 24.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Normal,
                            lineHeight = 28.sp,
                        )
                    )

                    Text(
                        text = employee.userTag.lowercase(),
                        modifier = Modifier.padding(all = 4.dp),
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.onErrorContainer,
                            fontSize = 17.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.W400,
                            fontStyle = FontStyle.Normal,
                            lineHeight = 16.sp
                        )
                    )

                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onTertiary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = employee.position,
                    modifier = Modifier.padding(all = 12.dp),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 13.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.W400,
                        fontStyle = FontStyle.Normal,
                        lineHeight = 16.sp
                    )
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                val birthDate = LocalDate.parse(employee.birthday)
                val currentDate = LocalDate.now()

                val period = Period.between(birthDate, currentDate)



                Box(
                    modifier = Modifier.weight(0.4f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.vector),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                    )
                }

                Text(
                    text = birthDate.dayOfMonth.toString()
                            + " " + birthDate.month.toString().lowercase()
                            + " " + birthDate.year.toString(),
                    modifier = Modifier
                        .weight(4f)
                        .padding(vertical = 12.dp, horizontal = 12.dp),
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 16.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.W500,
                        fontStyle = FontStyle.Normal,
                        lineHeight = 20.sp
                    )
                )

                Text(
                    text = period.years.toString() + " years",
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 12.dp),
                    textAlign = TextAlign.Right,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.W500,
                        fontStyle = FontStyle.Normal,
                        lineHeight = 20.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {

                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.phone_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .padding()
                    )
                }

                Text(
                    text = PhoneNumberUtils.formatNumber(
                        employee.phone,
                        Locale.getDefault().country
                    ),
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 16.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.W500,
                        fontStyle = FontStyle.Normal,
                        lineHeight = 20.sp
                    ),
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)

                )
            }
            Button(onClick = { TODO() }) {
                Text(text = "BACK")

            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmployeeFullInfoScreen(employeeSample)
}