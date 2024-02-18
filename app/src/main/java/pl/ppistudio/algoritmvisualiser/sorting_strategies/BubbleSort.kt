package pl.ppistudio.algoritmvisualiser.sorting_strategies

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class BubbleSort() : SortingStrategy() {
    override var name = "BubbleSort"

    override var flow = flow {
        val list = initialList.toMutableList()
        var swap = true

        while (swap) {
            swap = false
            for (i in 0 until list.size - 1) {
                clearItemsEdition(list)
                emit(list.toList())

                if (list[i] > list[i + 1]) {
                    markEdition(list, i, i + 1)
                    val temp = list[i]
                    list[i] = list[i + 1]
                    list[i + 1] = temp
                    swap = true
                    delay(1000L)
                }
            }
        }
    }
}