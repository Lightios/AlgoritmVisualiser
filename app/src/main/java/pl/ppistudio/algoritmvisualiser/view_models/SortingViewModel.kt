package pl.ppistudio.algoritmvisualiser.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import pl.ppistudio.algoritmvisualiser.data_models.SortingItem
import pl.ppistudio.algoritmvisualiser.sorting_strategies.BubbleSort
import pl.ppistudio.algoritmvisualiser.sorting_strategies.SortingStrategy
import kotlin.random.Random

class SortingViewModel : ViewModel() {
    var items by mutableStateOf(List(10) { SortingItem(Random.nextInt(1, 60), false) })
    var sortTrigger by mutableStateOf(false)

    var sortingStrategy: SortingStrategy = BubbleSort()

    fun toggleSort() {
        sortTrigger = !sortTrigger
    }

    fun setRandomNumbers() {
        items = List(10) { SortingItem(Random.nextInt(1, 60), false) }
        sortingStrategy.initialList = items
    }

    fun setSortingStrategy(strategy: SortingStrategy) {
        sortingStrategy = strategy
        sortingStrategy.initialList = items
    }


}