package pl.ppistudio.algoritmvisualiser.sorting_strategies

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class InsertionSort() : SortingStrategy() {
    override var name = "InsertionSort"

    override var flow = flow {
        val list = initialList.toMutableList()
        for (i in 1 until list.size) {
            val key = list[i]
            var j = i - 1
            while (j >= 0 && list[j] > key) {
                emit(list.toList()) // emit a copy of the list
                list[j + 1] = list[j]
                j--
                delay(1000L) // delay for visualization
            }
            list[j + 1] = key
        }
    }
}