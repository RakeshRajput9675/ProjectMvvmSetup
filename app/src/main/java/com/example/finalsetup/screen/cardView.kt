package com.example.finalsetup.screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalsetup.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun cardView() {
    Box(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp).shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(16.dp),
                    ambientColor = Color.Blue,
                ),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Image
                Image(
                    painter = painterResource(R.drawable.watch),
                    contentDescription = "house",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    // Title + Verified Icon
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Cleo Country",
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Default,
                            color = Color(0xFF000000)
                        )

                        val isVerified = false
                        if (isVerified) {
                            Spacer(modifier = Modifier.width(6.dp))
                            Image(
                                painter = painterResource(R.drawable.watch),
                                contentDescription = "blue tick"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Location with Icon
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.watch),
                            contentDescription = "location"
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Noida Sector 52, Noida",
                            fontSize = 10.sp,
                            color = Color(0xFF3209D2)
                        )
                    }
                }
            }
        }
    }
}
