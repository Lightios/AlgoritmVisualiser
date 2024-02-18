package pl.ppistudio.algoritmvisualiser.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import pl.ppistudio.algoritmvisualiser.data_models.SortingItem
import pl.ppistudio.algoritmvisualiser.sorting_strategies.BubbleSort
import pl.ppistudio.algoritmvisualiser.sorting_strategies.InsertionSort
import pl.ppistudio.algoritmvisualiser.sorting_strategies.SelectionSort
import pl.ppistudio.algoritmvisualiser.ui.composables.SortingItemBox
import pl.ppistudio.algoritmvisualiser.view_models.SortingViewModel

@Composable
fun SortingScreen(
    onNavigate: () -> Unit,
    items: List<SortingItem>,
    sortTrigger: Boolean,
    toggleSort: () -> Unit,
    flow: Flow<List<SortingItem>>,
    setItems: (List<SortingItem>) -> Unit,
    finishSorting: () -> Unit
) {
//    val viewModel: SortingViewModel = viewModel()
//    val items = viewModel.items
//    val sortTrigger = viewModel.sortTrigger

    // Define the sorting strategies
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            items.forEach { item ->
                SortingItemBox(item)
            }
        }
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(onClick = {
                toggleSort()
            }) {
                Text(text = "Sort")
            }

            Button(onClick = { onNavigate() }) {
                Text(text = "Settings")
            }
        }
    }

    LaunchedEffect(key1 = sortTrigger) {
        if (sortTrigger) {
//            viewModel.sortingStrategy.initialList = items

            flow.collect {
                setItems(it)
            }

            finishSorting()
            scope.launch {
                Toast.makeText(context, "Sorting is finished", Toast.LENGTH_SHORT).show()
            }
        }
    }
}