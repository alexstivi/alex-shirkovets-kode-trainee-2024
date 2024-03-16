package com.example.alex_shirkovets_kode_trainee_2024.Presentaion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.alex_shirkovets_kode_trainee_2024.Presentaion.Models.DepartmentName
import com.example.alex_shirkovets_kode_trainee_2024.Presentaion.Models.DepartmentsNamesSampleData
import com.example.alex_shirkovets_kode_trainee_2024.Presentaion.Models.EmployeeInfo
import com.example.alex_shirkovets_kode_trainee_2024.Presentaion.Models.EmployeesNamesSampleData
import com.example.alex_shirkovets_kode_trainee_2024.Presentaion.theme.Alexshirkovetskodetrainee2024Theme

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
        Spacer(modifier = Modifier.padding(all = 20.dp))
        TopAppBar()
        Greeting("Designers")
        EmployeesList(EmployeesNamesSampleData.employees )
    }
}

@Composable
fun NavigationalBar(names: List<DepartmentName>) {
    LazyRow {
        items(names) { name ->
            DepartmentNameTab(name)
        }
    }
}

@Composable
fun EmployeesList(names: List<EmployeeInfo>) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(names) { name ->
            EmployeesShortInfo(name)
        }
    }
}

@Composable
fun TopAppBar() {
    Column {
        Text("TOP")
        Text("ПОИСК")
        NavigationalBar(DepartmentsNamesSampleData.depNamesSample)
    }
}
@Composable
fun DepartmentNameTab(tab: DepartmentName) {
    Text(
        text = tab.name, Modifier
            //.clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    )

}
@Composable
fun EmployeesShortInfo(employee: EmployeeInfo) {
    Row(modifier = Modifier.padding(all = 8.dp)) {


        AsyncImage(
            model = employee.avatarUrl,
            contentDescription = null,
            modifier = Modifier
                // Set image size to 40 dp
                .size(72.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                Text(
                    text = employee.firstName,
                    modifier = Modifier.padding(all = 4.dp),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = employee.lastName,
                    modifier = Modifier.padding(all = 4.dp),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = employee.userTag,
                    modifier = Modifier.padding(all = 4.dp),
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Text(
                text = employee.position,
                modifier = Modifier.padding(all = 4.dp),
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.headlineMedium
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Alexshirkovetskodetrainee2024Theme {
        StartScreen()
    }
}