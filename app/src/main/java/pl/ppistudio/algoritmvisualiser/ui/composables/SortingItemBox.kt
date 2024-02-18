package pl.ppistudio.algoritmvisualiser.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pl.ppistudio.algoritmvisualiser.data_models.SortingItem

@Composable
fun SortingItemBox(item: SortingItem) {
    Box(
        modifier = Modifier
        .height(item.value.dp * 10)
        .width(30.dp)
        .padding(2.dp)
        .background(if (item.isBeingEdited) Color.Magenta else Color.Blue)
    )

}