package pl.ppistudio.algoritmvisualiser.sorting_strategies

import kotlinx.coroutines.flow.Flow
import pl.ppistudio.algoritmvisualiser.data_models.SortingItem

abstract class SortingStrategy {
    open lateinit var flow: Flow<List<SortingItem>>
    open lateinit var name: String
    lateinit var initialList: List<SortingItem>

    fun clearItemsEdition(list: List<SortingItem>) {
        list.forEach() {
            it.isBeingEdited = false
        }
    }

    fun markEdition(list: MutableList<SortingItem>, i: Int, j: Int) {
        list[i].isBeingEdited = true
        list[j].isBeingEdited = true
    }
}