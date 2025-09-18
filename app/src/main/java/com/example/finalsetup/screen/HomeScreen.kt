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

@SuppressLint("ContextCastToActivity", "InvalidColorHexValue")
@Composable
fun HomeScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val token = SharedPreference.get(context).accessToken

    // API call when screen loads
    LaunchedEffect(Unit) {
        viewModel.comprehensivehitApi(
            "Bearer $token", ProductRequest("1")
        )
    }

    // Observer for API result
    Observer(
        context = context as Activity,
        lifeCycleOwner = LocalLifecycleOwner.current,
        viewModel = viewModel
    )

    val detail = viewModel.comprehensiceDetail.value

    // Map UI labels to API fields
    val displayList = listOf(
        "Listing Code" to (detail?.id ?: ""),
        "Brand" to (detail?.brandName?.brandName ?: ""),
        "Model" to (detail?.modelNumber ?: ""),
        "Reference number" to (detail?.referneceNumber ?: ""),
        "Movement" to (detail?.movementTypeId ?: ""),
        "Case material" to (detail?.caseMaterial ?: ""),
        "Bracelet material" to (detail?.braceletMaterial ?: ""),
        "Year of production" to (detail?.yearOfProduction ?: ""),
        "Condition" to (detail?.productConditions ?: ""),
        "Gender" to (detail?.gender ?: ""),
        "Caliber/movement" to (detail?.caliberMovement ?: ""),
        "Number of jewels" to (detail?.numberOfJewels ?: ""),
        "Case diameter" to (detail?.caseDiameterMax ?: ""),
        "Water resistance" to (detail?.waterResistance ?: ""),
        "Bezel material" to (detail?.caseMaterial ?: ""),
        "Dial" to (detail?.caseDiameterMin ?: ""),
        "Dial numerals" to (detail?.dialNumber ?: ""),
        "Bracelet color" to (detail?.braceletColor ?: ""),
        "Clasp" to (detail?.typeOfClasp ?: ""),
        "Clasp material" to (detail?.claspMaterial ?: "")
    )

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        val maxHeight = this.maxHeight
        Column {
            // Header
            Row(
                modifier = Modifier.padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Comprehensive Details", style = TextStyle(
                        fontSize = 18.sp,
                        color = Color(0xff003A4E),
                        fontWeight = FontWeight.SemiBold
                    ), modifier = Modifier.padding(start = 10.dp)
                )
            }

            Box(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .weight(1f)
            ) {
                AsyncImage(
                    model = detail?.productImages?.get(0)?.imagePath,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                )

                // List of details
                LazyColumn(
                    modifier = Modifier
                        .padding(top = maxHeight * 0.25f, start = 20.dp, end = 20.dp)
                        .fillMaxSize()
                        .background(
                            Color.White, RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                        )
                        .padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(displayList.size) { index ->
                        val (label, value) = displayList[index]
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                label, modifier = Modifier.weight(1f), style = TextStyle(
                                    fontSize = 14.sp,
                                    color = Color(0xff35494F),
                                    fontWeight = FontWeight.Normal
                                )
                            )
                            Text(
                                value.toString(),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.End,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    color = Color(0xff0E1C21),
                                    fontWeight = FontWeight.Medium
                                ),
                                maxLines = 1
                            )
                        }
                        HorizontalDivider(
                            Modifier, DividerDefaults.Thickness, color = Color(0xFF337F9CA6).copy(alpha = 0.20f)
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun Observer(
    context: Activity,
    lifeCycleOwner: LifecycleOwner,
    viewModel: MainViewModel
) {
    viewModel.comprehensive.observe(lifeCycleOwner) { it1 ->
        when (it1) {
            is EmpResource.Failure -> {
                Log.d("TAG", "observer: fail ")
                Toast.makeText(context, it1.throwable?.message, Toast.LENGTH_SHORT).show()
                CustomLoader.hideLoader()
            }
            is EmpResource.Success -> {
                Toast.makeText(context, it1.value.message, Toast.LENGTH_SHORT).show()
                Log.d("TAG", "observer: success")
                it1.value.data?.let {
                    viewModel.comprehensiceDetail.value = it
                }
            }

            else -> {}
        }
    }
}
