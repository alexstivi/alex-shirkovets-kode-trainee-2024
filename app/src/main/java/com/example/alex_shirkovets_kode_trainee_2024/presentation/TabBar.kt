package com.example.alex_shirkovets_kode_trainee_2024.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.GetTabSortedListUseCase
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.models.EmployeesSampleData.employees
import com.example.alex_shirkovets_kode_trainee_2024.presentation.models.DepartmentsNamesMapSampleData.depNamesMapSample
import com.example.alex_shirkovets_kode_trainee_2024.presentation.models.DepartmentsNamesSampleData.depNamesSample


@Composable
fun DepartmentNameTab() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabNames = depNamesSample
    val tabsMap = depNamesMapSample
    val tabs = getMappedListUseCase.execute(list = tabNames, map = tabsMap)
    val actualList = employees
    val tabSortedList = getTabSortedListUseCase.execute("android", actualList)

    Surface(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier
                .fillMaxWidth(),
            edgePadding = 16.dp,
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = tabIndex == index,
                    selectedContentColor = MaterialTheme.colorScheme.onSurface,
                    unselectedContentColor = MaterialTheme.colorScheme.onSecondary,
                    onClick = {
                        tabIndex = index
                    }
                )
            }
        }
    }
}
