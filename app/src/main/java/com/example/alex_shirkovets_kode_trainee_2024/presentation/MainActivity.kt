package com.example.alex_shirkovets_kode_trainee_2024.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.alex_shirkovets_kode_trainee_2024.presentation.theme.ui.Alexshirkovetskodetrainee2024Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

            Alexshirkovetskodetrainee2024Theme {
                KoderApp()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun EmployeeInfoPreview() {
    Alexshirkovetskodetrainee2024Theme {
        KoderApp()
    }
}
