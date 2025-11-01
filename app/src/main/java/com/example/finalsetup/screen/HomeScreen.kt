package com.example.finalsetup.screen

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.finalsetup.PaymentActivity
import java.text.SimpleDateFormat
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
) {
    val state = rememberDateRangePickerState()
    var enabled by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var range by remember { mutableStateOf("") }
    var selectedImageUri = remember { mutableStateOf<Uri?>(null) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
//---->    choose photo from gallery
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia()
        ) { uri ->
            selectedImageUri.value = uri
        }
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {

            val painter = rememberAsyncImagePainter(selectedImageUri.value)
            Image(
                painter = painter,
                contentDescription = "Background",
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Green)
                    .clickable {
                        launcher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    },
                contentScale = androidx.compose.ui.layout.ContentScale.FillBounds
            )

        Button(onClick = {
            context.startActivity(Intent(context, PaymentActivity::class.java))
        }) {
            Text("Open Payment")

        }
            Button(onClick = {
                enabled = !enabled
            }) {
                Text("Pick Date")

            }

            var expanded by remember { mutableStateOf(false) }
            val items = listOf("Option 1", "Option 2", "Option 3")
            var selected by remember { mutableStateOf(items.first()) }
            Spacer(modifier = Modifier.height(16.dp))
                ReusableDropdownMenu(
                    label = "",
                    items = items,
                    selectedItem = selected,
                    onItemSelected = { selected = it },
                    modifier = Modifier.fillMaxWidth()
                )


        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(range)

        Spacer(Modifier.height(16.dp))

    }
    if (enabled) {
        ModalBottomSheet(onDismissRequest = { enabled = false }) {
            DateRangePicker(
                state = state,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                title = {
                    Text(
                        "Select a date range",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                headline = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Box(Modifier.weight(0.2f), contentAlignment = Alignment.TopEnd) {
                            Icon(
                                imageVector = Icons.Default.Done,
                                contentDescription = "Okk",
                                modifier = Modifier.clickable {
                                    range = getFormattedDate(
                                        state.selectedStartDateMillis ?: 0L
                                    ) + "\n" + getFormattedDate(
                                        state.selectedEndDateMillis ?: 0L
                                    )
                                    enabled = false
                                })
                        }
                    }
                },
                dateFormatter = remember { DatePickerDefaults.dateFormatter() },
                showModeToggle = true,
                colors = DatePickerDefaults.colors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                    weekdayContentColor = Color.Black,
                    subheadContentColor = Color.Black,
                    yearContentColor = Color.Cyan,

                    )
            )
        }
        }
    }


@SuppressLint("SimpleDateFormat")
fun getFormattedDate(timeInMillis: Long): String {
    val calender = Calendar.getInstance()
    calender.timeInMillis = timeInMillis
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    return dateFormat.format(calender.timeInMillis)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReusableDropdownMenu(
    label: String,
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = modifier.menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}
