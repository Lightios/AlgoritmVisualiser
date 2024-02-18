package pl.ppistudio.algoritmvisualiser.sorting_strategies

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class SelectionSort() : SortingStrategy() {
    override var name = "SelectionSort"

    override var flow = flow {
        val list = initialList.toMutableList()
        for (i in list.indices) {
            clearItemsEdition(list)

            var minIndex = i
            for (j in i + 1 until list.size) {
                if (list[j] < list[minIndex]) {
                    minIndex = j
                }
            }

            markEdition(list, i, minIndex)
            emit(list.toList())

            val temp = list[i]
            list[i] = list[minIndex]
            list[minIndex] = temp

            delay(1000L)
        }
    }
}