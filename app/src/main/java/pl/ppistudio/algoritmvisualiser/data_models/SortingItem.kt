package pl.ppistudio.algoritmvisualiser.data_models

data class SortingItem(var value: Int, var isBeingEdited: Boolean) : Comparable<SortingItem> {
    override fun compareTo(other: SortingItem): Int {
        return when {
            this.value < other.value -> -1
            this.value > other.value -> 1
            else -> 0
        }
    }
}