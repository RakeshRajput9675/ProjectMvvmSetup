package com.example.finalsetup.screen

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import coil.compose.AsyncImage
import com.example.finalsetup.base.CustomLoader
import com.example.finalsetup.helper.SharedPreference
import com.example.finalsetup.model.ProductRequest
import com.example.finalsetup.repository.EmpResource
import com.example.finalsetup.viewModel.MainViewModel

@SuppressLint("ContextCastToActivity", "InvalidColorHexValue", "StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(
    viewModel: MainViewModel = hiltViewModel()
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


