package com.example.alex_shirkovets_kode_trainee_2024.Presentaion


import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow

import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.alex_shirkovets_kode_trainee_2024.Presentaion.Models.DepartmentsNamesMapSampleData.depNamesMapSample
import com.example.alex_shirkovets_kode_trainee_2024.Presentaion.Models.DepartmentsNamesSampleData.depNamesSample
import com.example.alex_shirkovets_kode_trainee_2024.Presentaion.Models.EmployeeInfo
import com.example.alex_shirkovets_kode_trainee_2024.Presentaion.Models.EmployeesNamesSampleData
import com.example.alex_shirkovets_kode_trainee_2024.Presentaion.theme.Alexshirkovetskodetrainee2024Theme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            Alexshirkovetskodetrainee2024Theme {

                SetStatusBarColor(color = MaterialTheme.colorScheme.background)
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
fun StartScreen() {
    Column {
        TopAppBar()
        EmployeesList(EmployeesNamesSampleData.employees )
    }
}

@Composable
fun SetStatusBarColor(color: Color) {

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color)
    }
}
@Composable
fun SearchBar() {
    var input by rememberSaveable { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {

        TextField(
            value = input,
            onValueChange = { newText ->
                input = newText.trimStart { it == '0' }
            },
            label = { Text("Введите имя, тэг, почту...") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Localized description") },
            trailingIcon = { Icon(Icons.Filled.Menu, contentDescription = "Localized description") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            )
        )
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
        Spacer(modifier = Modifier.height(40.dp))
        SearchBar()
        DepartmentNameTab()
    }
}


@Composable
fun mappedList (list: List<String>, map: Map<String, String>) : List<String> {
    val myMutable = mutableListOf("Все")
    for (names in list) {
        val key: String? = map[names]
        if (key != null) {
            myMutable.add(key)
        }
    }
    return myMutable
}

@Composable
fun DepartmentNameTab() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabNames = depNamesSample //TODO add actual received deps names
    val tabsMap = depNamesMapSample
    val tabs = mappedList(tabNames, tabsMap)


    Column {
        ScrollableTabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = tabIndex == index,
                    selectedContentColor = MaterialTheme.colorScheme.onSurface,
                    unselectedContentColor = MaterialTheme.colorScheme.onSecondary,
                    onClick = { tabIndex = index },
                )
            }
        }
        /*
        when (tabIndex) {
            0 -> HomeScreen()
            1 -> AboutScreen()
            2 -> SettingsScreen()
            3 -> MoreScreen()
            4 -> SomethingScreen()
            5 -> EverythingScreen()
        }
    }
*/
    }
}
@Composable
fun EmployeesShortInfo(employee: EmployeeInfo) {
    Row() {

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

        //Spacer(modifier = Modifier.width(8.dp))

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
                    style = MaterialTheme.typography.labelSmall
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