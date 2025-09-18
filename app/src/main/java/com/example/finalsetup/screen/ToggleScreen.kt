package com.example.finalsetup.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalsetup.R

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun ToggleScreen() {
    val list = remember {
        mutableStateListOf(
            ToggleData("Toggle 1", false),
            ToggleData("Toggle 2", false),
            ToggleData("Toggle 3", false),
            ToggleData("Toggle 4", false),
            ToggleData("Toggle 5", false),
        )
    }
    BoxWithConstraints(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val maxHeight = this.maxHeight
        var toggles by remember { mutableStateOf(List(5) { false }) }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                list.size
            ) { it ->
                Composable(
                    value = list[it].title, isSelected = list[it].isSelected, onSelected = {
                        list[it] = list[it].copy(
                            isSelected = !list[it].isSelected
                        )
                    })
            }
        }
    }
}

@Composable
fun Composable(
    value: String, isSelected: Boolean, onSelected: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(value, modifier = Modifier.weight(1f))
        Image(
            painterResource(
                if (isSelected) R.drawable.toggle_on else R.drawable.toggle_off
            ), contentDescription = null, Modifier
                .size(50.dp)
                .clickable(
                    onClick = onSelected
                )
        )
    }
}

data class ToggleData(
    var title: String, var isSelected: Boolean
)