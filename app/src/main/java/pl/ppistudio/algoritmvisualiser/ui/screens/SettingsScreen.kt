package pl.ppistudio.algoritmvisualiser.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import pl.ppistudio.algoritmvisualiser.sorting_strategies.BubbleSort
import pl.ppistudio.algoritmvisualiser.sorting_strategies.InsertionSort
import pl.ppistudio.algoritmvisualiser.sorting_strategies.SelectionSort
import pl.ppistudio.algoritmvisualiser.sorting_strategies.SortingStrategy

@Composable
fun SettingsScreen(
    onSetRandomNumbers: () -> Unit,
    setSortingStrategy: (SortingStrategy) -> Unit
){
    val sortingStrategies = listOf(BubbleSort(), SelectionSort(), InsertionSort())
    var showMenu by remember { mutableStateOf(false) }

    Column(

    ) {

        Button(onClick = {onSetRandomNumbers()}) {
            Text(text = "Randomize")
        }


        Button(onClick = {showMenu = !showMenu}) {
            Text(text = "Change sorting strategy")
        }

        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false }
        ) {
            sortingStrategies.forEach { strategy ->
                DropdownMenuItem(
                    text = { Text(text = strategy.name) },
                    onClick = {
                        showMenu = false
                        setSortingStrategy(strategy)
                    }
                )
            }
        }
    }

}