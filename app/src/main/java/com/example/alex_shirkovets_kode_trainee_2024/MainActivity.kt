package com.example.alex_shirkovets_kode_trainee_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alex_shirkovets_kode_trainee_2024.ui.theme.Alexshirkovetskodetrainee2024Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Alexshirkovetskodetrainee2024Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StartScreen()
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun StartScreen() {
    Column {

        Spacer(modifier = Modifier.padding(all=20.dp))
        TopAppBar()
        Greeting("Android")
    }
}

@Composable
fun ContentTab(names: List<DepartmentName>) {
    LazyRow {
        items(names) {name ->
            DepartmentNameTab(name)
        }
    }
}

@Composable
fun TopAppBar() {
    Column {
        Text("TOP")
        Text("MIDDLE")
        ContentTab(DepartmentsNamesSampleData.depNamesSample)
    }
}

data class DepartmentName(val name: String)

@Composable
fun DepartmentNameTab(tab: DepartmentName) {
    Text(text = tab.name, Modifier
        //.clickable(onClick = onClick)
        .padding(horizontal = 12.dp, vertical = 8.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Alexshirkovetskodetrainee2024Theme {
        StartScreen()
    }
}