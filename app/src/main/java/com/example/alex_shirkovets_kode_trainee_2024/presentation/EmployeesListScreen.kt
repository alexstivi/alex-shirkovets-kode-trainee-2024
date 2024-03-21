package com.example.alex_shirkovets_kode_trainee_2024.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.alex_shirkovets_kode_trainee_2024.data.Employee


@Composable
fun EmployeesList(
    list: List<Employee>,
    modifier: Modifier
) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {

        itemsIndexed(list) { _, employee ->
            EmployeesShortInfo(employee, modifier)
        }
    }
}
@Composable
fun EmployeesShortInfo(
    employee: Employee,
    modifier: Modifier) {

    Row {

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

        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                employee.firstName?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(all = 4.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                employee.lastName?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(all = 4.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                employee.userTag?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(all = 4.dp),
                        color = MaterialTheme.colorScheme.onSecondary,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }

            employee.position?.let {
                Text(
                    text = it,
                    modifier = Modifier.padding(all = 4.dp),
                    color = MaterialTheme.colorScheme.onTertiary,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

        }
    }
}



