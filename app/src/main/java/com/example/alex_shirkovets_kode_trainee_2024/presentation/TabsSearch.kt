package com.example.alex_shirkovets_kode_trainee_2024.presentation
/*
package com.example.alex_shirkovets_kode_trainee_2024.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alex_shirkovets_kode_trainee_2024.data.Employee
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.GetFilteredListUseCase
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.GetMappedListUseCase
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.GetTabSortedListUseCase
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.LoadActualListUseCase
import com.example.alex_shirkovets_kode_trainee_2024.presentation.models.DepartmentsNamesMapSampleData
import com.example.alex_shirkovets_kode_trainee_2024.presentation.models.DepartmentsNamesSampleData
import com.example.alex_shirkovets_kode_trainee_2024.presentation.theme.ui.InterFontFamily
import com.google.accompanist.systemuicontroller.rememberSystemUiController


val loadActualListUseCase = LoadActualListUseCase()
val getMappedListUseCase = GetMappedListUseCase()
val getFilteredListUseCase = GetFilteredListUseCase()


//val actualList = loadActualListUseCase.execute()
val tabNames = DepartmentsNamesSampleData.depNamesSample //TODO add actual received deps names
val tabsMap = DepartmentsNamesMapSampleData.depNamesMapSample

@Composable
fun StartScreen() {

    val tabs = getMappedListUseCase.execute(list = tabNames, map = tabsMap)

    Column {
        TopAppBar()
        EmployeeslistPresentation(tabs = tabs)

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
fun TopAppBar() {
    Column {
        Spacer(modifier = Modifier.height(44.dp))
    }
}

@Composable
fun EmployeeslistPresentation(tabs: List<String>) {
    var tabIndex by rememberSaveable { mutableIntStateOf(0) }
    val selectedTab = tabNames[tabIndex]
    val actualList = listOf<Employee>()
    val getTabFilteredListUseCase = GetTabSortedListUseCase().execute(selectedTab, valactualList)
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val filteredList = getFilteredListUseCase.execute(textState.value.text, actualList)
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        //shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Column {
            Row {
                TextField(
                    modifier = Modifier.clip(
                        RoundedCornerShape(22.dp)
                    ),
                    //modifier = Modifier
                    //    .fillMaxWidth(),
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.onTertiary,
                        fontSize = 15.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.W500,
                        fontStyle = FontStyle.Normal,
                    ),
                    label = { Text("Введите имя, тэг, ник...") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Localized description"
                        )
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }


                    )
                )
                TextButton(onClick = { }) {
                    Text(
                        text = "Oтмена",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 11.dp)
                    )
                }
            }

            ScrollableTabRow(
                selectedTabIndex = tabIndex,
                edgePadding = 16.dp,
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selected = tabIndex == index,
                        selectedContentColor = MaterialTheme.colorScheme.onSurface,
                        unselectedContentColor = MaterialTheme.colorScheme.onSecondary,
                        onClick = { tabIndex = index }
                    )
                }
            }

            EmployeesList(
                names = when {
                    tabIndex == 0 -> filteredList
                    else -> getTabFilteredListUseCase
                }
            )
        }
    }
}

*/
