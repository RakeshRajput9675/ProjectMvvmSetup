package com.example.finalsetup.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.finalsetup.viewModel.MainViewModel

@SuppressLint("ContextCastToActivity", "InvalidColorHexValue", "StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(
    viewModel: MainViewModel = hiltViewModel(),
    modifier: Modifier
) {


//    val name = viewModel.uiData.value.name
//    val age = viewModel.uiData.value.age
//    val hobbies = viewModel.uiData.value.hobbies

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val maxHeight = this.maxHeight

//        i have to collect the data from the viewmodel by using the collectAsState in the ui
        val data = viewModel.uiData.collectAsState().value
        viewModel.updateName("Rakesh Kumar")

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(data.name)
        }
    }
}


