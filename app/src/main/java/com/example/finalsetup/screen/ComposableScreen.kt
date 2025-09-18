package com.example.finalsetup.screen

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
private fun ComposableScreen() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val maxHeight = this.maxHeight

    }
}

@Composable
fun CMP(
    modifier:Modifier
){
    Row {

    }
}
