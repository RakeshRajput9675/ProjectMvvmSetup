package com.example.finalsetup.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalsetup.R
import kotlinx.coroutines.launch

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoanScreen() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        var count by remember { mutableIntStateOf(0) }

        val state = rememberPagerState(initialPage = 0, pageCount = { finalList[count].list1.size })
        val maxHeight = this.maxHeight


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, RoundedCornerShape(30.dp))
                .padding(bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.cross),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 20.dp, end = 20.dp)
                    .align(Alignment.End)
            )

            Spacer(Modifier.height(10.dp))
            val rememcoro = rememberCoroutineScope()
            Column {
                Row(
                    modifier = Modifier
                        .padding(13.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    finalList.forEachIndexed { index, it ->
                        Text(
                            text = it.value ?: "",
                            fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                            fontSize = 16.sp,
                            color = if (count == index) Color.Blue else Color(0xff4D4D4D),
                            textDecoration = if (count == index) TextDecoration.Underline else null,
                            modifier = Modifier.clickable(
                                indication = null, // removes ripple effect
                                interactionSource = remember { MutableInteractionSource() } // avoids default press animation
                            ) {
                                rememcoro.launch {
                                    count = index
                                    state.animateScrollToPage(0, pageOffsetFraction = 0f)
                                }
                            }
                        )
                    }
                }
                HorizontalPager(
                    state = state

                ) {
                    val lsit = finalList[count].list1.get(it)
                    Box(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = lsit ?: R.drawable.watch),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .height(250.dp),
                            contentScale = ContentScale.Crop
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {


                            if (state.currentPage != 0) {
                                Image(
                                    painter = painterResource(R.drawable.forward),
                                    contentDescription = null,
                                    modifier = Modifier.clickable {
                                        rememcoro.launch {
                                            state.animateScrollToPage(
                                                page = state.currentPage - 1,
                                                pageOffsetFraction = 0f
                                            )
                                        }
                                    }
                                )
                            } else {
                                Spacer(Modifier.weight(1f))
                            }
                            if (state.currentPage != finalList.size - 1) {
                                Image(
                                    painter = painterResource(R.drawable.forward),
                                    contentDescription = null,
                                    modifier = Modifier.clickable {
                                        rememcoro.launch {
                                            state.animateScrollToPage(
                                                page = state.currentPage + 1,
                                                pageOffsetFraction = 0f
                                            )
                                        }
                                    }
                                )
                            }
                        }
                    }
                }

                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            "Reception",
                            style = TextStyle(
                                fontSize = 10.sp,
                                color = Color(0xff4D4D4D),
                                fontFamily = FontFamily(Font(R.font.m_regular))
                            )
                        )
                        Text(
                            "30*20", style = TextStyle(
                                fontSize = 16.sp,
                                color = Color(0xff4D4D4D),
                                fontFamily = FontFamily(Font(R.font.m_semi_bold))
                            )
                        )
                    }
                    Text(
                        text = "${state.currentPage + 1}/${finalList.size}", style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xff4D4D4D),
                            fontFamily = FontFamily(Font(R.font.m_semi_bold))
                        )
                    )

                }

            }
        }


    }


}

val finalList = listOf(
    SubList(
        "BedRoom",
        listOf(R.drawable.watch, R.drawable.img1, R.drawable.watch)
    ),
    SubList(
        "WashRoom",
        listOf(R.drawable.img1, R.drawable.watch, R.drawable.img1)
    ),
    SubList(
        "Chicken",
        listOf(R.drawable.watch, R.drawable.img1, R.drawable.watch)
    ),
)


data class SubList(
    val value: String? = "",
    val list1: List<Int?>,
)

