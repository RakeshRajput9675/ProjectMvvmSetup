package com.example.finalsetup.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalsetup.R


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SearchProperty() {

    BoxWithConstraints(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        val maxHeight = this.maxHeight
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .heightIn(max = maxHeight)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(185.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xff0D000000), RoundedCornerShape(8.dp))
                ) {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(maxHeight),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(10) {
                            CustomImage(
                                id = R.drawable.img1,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                                    .width(280.dp)
                                    .height(160.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 8.dp)
                            .align(Alignment.TopStart),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .height(25.dp)
                                .background(
                                    color = Color(0xff99000000),
                                    RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 5.dp), contentAlignment = Alignment.Center
                        ) {
                            Row(
                                modifier = Modifier.padding(6.dp),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                CustomImage(
                                    id = R.drawable.security,
                                    modifier = Modifier
                                        .size(12.dp),
                                    contentScale = ContentScale.Crop
                                )
                                CustomText(
                                    text = "RERA",
                                    modifier = Modifier,
                                    color = Color.White,
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.m_medium)),
                                    maxLines = 1,
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .height(25.dp)
                                .background(
                                    color = Color(0xff99000000),
                                    RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 5.dp), contentAlignment = Alignment.Center
                        ) {
                            Row(
                                modifier = Modifier.padding(6.dp),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                CustomImage(
                                    id = R.drawable.security,
                                    modifier = Modifier
                                        .size(12.dp),
                                    contentScale = ContentScale.Crop
                                )
                                CustomText(
                                    text = "Zero Brokerage",
                                    modifier = Modifier,
                                    color = Color.White,
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.m_medium)),
                                    maxLines = 1,
                                )
                            }
                        }

                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 12.dp, end = 12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.like),
                            contentDescription = null,
                            modifier = Modifier
                                .background(color = Color.White, RoundedCornerShape(50))
                                .padding(4.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.share),
                            contentDescription = null,
                            modifier = Modifier
                                .background(color = Color.White, RoundedCornerShape(50))
                                .padding(4.dp)
                        )

                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                            .align(Alignment.BottomStart),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row {
                                Text(
                                    "1/12",
                                    modifier = Modifier
                                        .height(28.dp)
                                        .background(color = Color(0xff99000000))
                                        .padding(horizontal = 5.dp, vertical = 5.dp),
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(Modifier.width(8.dp))
                                Row(
                                    modifier = Modifier
                                        .height(28.dp)
                                        .background(color = Color(0xff99000000))
                                        .padding(horizontal = 5.dp, vertical = 5.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ComposableIcon(
                                        id = R.drawable.picture, text = "11", modifier = Modifier
                                    )
                                    ComposableIcon(
                                        id = R.drawable.video, text = "11", modifier = Modifier
                                    )
                                    ComposableIcon(
                                        id = R.drawable.d3, text = "3D", modifier = Modifier
                                    )
                                }
                            }

                        }
                        CustomText(
                            text = "Zero Brokerage",
                            modifier = Modifier.padding(bottom = 8.dp),
                            color = Color.White,
                            fontSize = 11.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            maxLines = 1,
                        )
                    }


                }


            }

        }

    }

}