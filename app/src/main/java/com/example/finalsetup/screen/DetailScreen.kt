package com.example.finalsetup.screen

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abi.simplecountrypicker.DialogCountryPicker
import com.example.finalsetup.R
import kotlinx.coroutines.launch

@SuppressLint("InvalidColorHexValue")
@Composable
fun DetailScreen(modifier: Modifier) {
        BoxWithConstraints(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            val maxHeight = this.maxHeight
            val maxWidth = this.maxWidth
            val scrollState = rememberScrollState()
            val launch = rememberCoroutineScope()
            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img1),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .height(250.dp),
                        contentScale = ContentScale.Crop
                    )

                    Box(
                        modifier = Modifier
                            .height(25.dp)
                            .background(
                                color = Color.Blue,
                                RoundedCornerShape(topStart = 8.dp, bottomEnd = 8.dp)
                            )
                            .padding(horizontal = 5.dp), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Save upto 20%", color = Color.White, textAlign = TextAlign.Center
                        )
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

                    Row(
                        modifier = Modifier
                            .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
                            .align(Alignment.BottomEnd),
                        horizontalArrangement = Arrangement.SpaceBetween,
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
                        Spacer(Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .height(28.dp)
                                .background(color = Color(0xff99000000))
                                .padding(horizontal = 5.dp, vertical = 5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            ComposableIcon(
                                id = R.drawable.download, text = "Brochure", modifier = Modifier
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomText(
                        text = "Cleo County",
                        modifier = Modifier,
                        color = Color(0xff121212),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1
                    )
                    CustomImage(id = R.drawable.tick, modifier = Modifier.size(24.dp))
                    CustomText(
                        text = "₹ 2.3cr - 3.4cr",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.End,
                        color = Color(0xff3209D2),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1

                    )
                }
                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CustomText(
                            text = "Flat JJ Colony, Sector 63, Noida, U.P.",
                            modifier = Modifier,
                            color = Color(0xff393C47),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_regular)),
                            textAlign = TextAlign.Start,
                            maxLines = 1
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CustomText(
                                text = "1075 acres",
                                modifier = Modifier,
                                color = Color(0xff292929),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.m_regular)),
                                textAlign = TextAlign.Start,
                                maxLines = 1
                            )
                            CustomImage(
                                id = R.drawable.ellipse, modifier = Modifier.size(5.dp)
                            )
                            CustomText(
                                text = "Fully/ Semi Furnished",
                                modifier = Modifier,
                                color = Color(0xff292929),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.m_regular)),
                                textAlign = TextAlign.Start,
                                maxLines = 1
                            )
                        }
                    }
                    CustomImage(
                        id = R.drawable.map,
                        modifier = Modifier
                            .width(58.dp)
                            .height(45.dp),
                        contentScale = ContentScale.Crop
                    )

                }
                Spacer(Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xfff2efff))
                        .padding(horizontal = 16.dp, vertical = 11.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Column {
                        CustomImage(
                            id = R.drawable.profile,
                            modifier = Modifier
                                .size(42.dp)
                                .clip(RoundedCornerShape(50)),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CustomText(
                                text = "Saroj Sharma",
                                modifier = Modifier.weight(1f),
                                color = Color(0xff121212),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                                textAlign = TextAlign.Start,
                                maxLines = 1
                            )
                            CustomText(
                                text = "Updated",
                                modifier = Modifier,
                                color = Color(0xff616161),
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.m_medium)),
                                textAlign = TextAlign.Start,
                                maxLines = 1
                            )
                        }
                        Spacer(Modifier.height(3.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CustomText(
                                text = "Builder",
                                modifier = Modifier,
                                color = Color(0xff80000000),
                                fontSize = 11.sp,
                                fontFamily = FontFamily(Font(R.font.m_regular)),
                                maxLines = 1
                            )
                            VerticalDivider(
                                Modifier
                                    .height(10.dp)
                                    .width(0.5.dp)
                                    .background(color = Color(0xff80000000))
                            )

                            CustomText(
                                text = "45485855344",
                                modifier = Modifier,
                                color = Color(0xFF800000),
                                fontSize = 11.sp,
                                fontFamily = FontFamily(Font(R.font.m_regular)),
                                maxLines = 1
                            )
                            Spacer(Modifier.weight(1f))
                            CustomText(
                                text = "3w ago",
                                modifier = Modifier,
                                color = Color(0xff121212),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.m_medium)),
                                maxLines = 1
                            )

                        }
                        Spacer(Modifier.height(12.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                CustomText(
                                    text = "Posted On",
                                    modifier = Modifier,
                                    color = Color(0xff800000),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.m_medium)),
                                    maxLines = 1
                                )
                                CustomText(
                                    text = "26 November 2024",
                                    modifier = Modifier,
                                    color = Color(0xff80000000),
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.m_medium)),
                                    maxLines = 1
                                )
                            }
                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)

                            ) {
                                CustomImage(
                                    id = R.drawable.message,
                                    modifier = Modifier,
                                )
                                CustomImage(
                                    id = R.drawable.view_phone,
                                    modifier = Modifier,
                                )
                                CustomImage(
                                    id = R.drawable.call,
                                    modifier = Modifier,
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                    }

                }
                Spacer(Modifier.height(20.dp))
                val tabs = listOf(
                    "About",
                    "Around this Property",
                    "Features",
                    "Amenities",
                    "About",
                    "Around this Property",
                    "Features",
                    "Amenities"
                )

                var selectedTabIndex by remember { mutableIntStateOf(0) }

                val density = LocalDensity.current
                ScrollableTabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = Color.White,
                    contentColor = Color.Blue,
                    edgePadding = 0.dp, // removes start/end padding
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(
                            Modifier
                                .tabIndicatorOffset(tabPositions[selectedTabIndex])
                                .width(tabPositions[selectedTabIndex].contentWidth), // underline matches text
                            height = 2.dp,
                            color = Color(0xFF3209D2)
                        )
                    },
                    divider = {
                        HorizontalDivider(thickness = 2.dp, color = Color(0xFFE0E0E0))
                    },
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = {
                                launch.launch {
                                    selectedTabIndex = index

                                    when (index) {
                                        0 -> {

                                        }

                                        1 -> {
                                            val offsetPx = with(density) { 1000.dp.toPx() }
                                            scrollState.scrollTo(offsetPx.toInt())
                                        }

                                        2 -> {
                                            val offsetPx = with(density) { 3000.dp.toPx() }
                                            scrollState.scrollTo(offsetPx.toInt())
                                        }

                                        3 -> {
                                            val offsetPx = with(density) { 5000.dp.toPx() }
                                            scrollState.scrollTo(offsetPx.toInt())
                                        }

                                        4 -> {
                                            val offsetPx = with(density) { 9000.dp.toPx() }
                                            scrollState.scrollTo(offsetPx.toInt())
                                        }
                                    }
                                }
                            },

                            selectedContentColor = Color.Black,
                            unselectedContentColor = Color(0xFF4D4D4D)
                        ) {
                            Text(
                                text = title,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                            )
                        }
                    }
                }
                Spacer(Modifier.height(25.dp))
                CustomText(
                    text = "About The Property",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(8.dp))
                CustomText(
                    text = "Lorem ipsum dolor sit amet, consetetuer adipiscing\u2028elit. Aenean commodo ligula eget dolor. Aenloean \u2028massa. Cum sociis natoque penatibus et magkanis \u2028dis parturient montes, nascetur ridiculus muiskts. \u2028Donec quam felis, ultricies nec, pellentesque sit.",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xffB2000000),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_regular)),
                    maxLines = 10
                )
                Spacer(Modifier.height(30.dp))

                CustomText(
                    text = "All Phases of this project",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )

                Spacer(Modifier.height(10.dp))
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(10) {
                        ColumnComposable(Modifier.width(maxWidth - 32.dp))
                    }

                }
                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Around This Property",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(12.dp))

                data class AroundThisProperty(
                    var id: Int, var text: String
                )

                val AroundThisPropertylist = listOf(
                    AroundThisProperty(R.drawable.furnishing, "Furnishing\nlorem ipsum"),
                    AroundThisProperty(R.drawable.parking, "Car Parking\nlorem ipsum"),
                    AroundThisProperty(R.drawable.kitchen, "Kitchen\nlorem ipsum"),
                    AroundThisProperty(R.drawable.hdtv, "HDTV, Disney, Netflix\nlorem ipsum")
                )
                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    content = {
                        items(AroundThisPropertylist.size) { index ->
                            ImageWithTextComposable(
                                id = R.drawable.zym,
                                text = "Hello World",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { },
                                imageModifier = Modifier.size(30.dp)
                            )

                        }
                    })

                Spacer(Modifier.height(20.dp))
                CustomText(
                    text = "Features",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )

                data class Features(
                    var id: Int, var text: String
                )

                val Featureslist = listOf(
                    Features(R.drawable.wifi, "Wifi\nlorem ipsum"),
                    Features(R.drawable.air_conditioning, "Air conditioning\nlorem ipsum"),
                    Features(R.drawable.tv, "TV\nlorem ipsum"),
                    Features(R.drawable.microwave, "Microwave\nlorem ipsum"),
                    Features(R.drawable.zym, "Gym\nlorem ipsum"),
                    Features(R.drawable.heating, "Heating\nlorem ipsum"),
                    Features(R.drawable.washing_machine, "Washing machine\nlorem ipsum"),
                    Features(R.drawable.pool, "Pool\nlorem ipsum"),

                    )
                Spacer(Modifier.height(12.dp))

                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    content = {
                        items(Featureslist.size) { index ->
                            ImageWithTextComposable(
                                modifier = Modifier,
                                id = Featureslist[index].id,
                                text = Featureslist[index].text
                            )
                        }
                    })
                Spacer(Modifier.height(35.dp))
                ButtonYellowBackground(
                    modifier = Modifier.padding(16.dp), txt = "Show Interest", onClick = {})
                Spacer(Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    CustomText(
                        text = "Calculate EMI",
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .border(
                                width = 1.dp,
                                color = Color(0xff562EFF),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(horizontal = 35.dp, vertical = 16.dp),
                        color = Color(0xff562EFF),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        maxLines = 1
                    )
                    CustomText(
                        text = "Apply for loan",
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color(0xffE9F0FF), RoundedCornerShape(10.dp))
                            .padding(horizontal = 35.dp, vertical = 16.dp),
                        color = Color(0xff562EFF),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        maxLines = 1
                    )

                }
                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Calculate EMI",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )

                Spacer(Modifier.height(10.dp))
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(20) {
                        ImageWithTextComposableInColumn(id = R.drawable.tennis, "Tennis")
                    }
                }
                Spacer(Modifier.height(20.dp))
                data class TwoTextItem(
                    val first: String, val second: String
                )

                val itemList = listOf(
                    TwoTextItem("Project Status", "Under construction"),
                    TwoTextItem("Launched Date", "12/02/25"),
                    TwoTextItem("Possession Date", "12/02/25"),
                    TwoTextItem("Total Area", "7 acres"),
                    TwoTextItem("Total Buildings", "5")
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            color = Color(0xffF7F4E4), RoundedCornerShape(12.dp)
                        )
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    CustomText(
                        text = "More Info",
                        modifier = Modifier,
                        color = Color(0xffCC000000),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.ma_bold)),
                        maxLines = 1
                    )
                    itemList.forEach {
                        RowWithTwoTextSemiBold(it.first, it.second)
                    }

                }


                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Other Details",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(12.dp))
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(5) {
                        CustomText(
                            text = "Corner Property",
                            modifier = Modifier,
                            color = Color(0xff000000),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.m_regular)),
                            maxLines = 1

                        )

                    }
                }
                Spacer(Modifier.height(12.dp))
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .border(
                            width = 1.dp, color = Color(0xff33000000), RoundedCornerShape(16.dp)
                        )
                        .padding(15.dp), verticalArrangement = Arrangement.spacedBy(13.dp)
                ) {
                    Row {
                        CustomText(
                            text = "Rera Verified",
                            modifier = Modifier,
                            color = Color(0xffB2000000),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),

                            maxLines = 1
                        )

                        CustomText(
                            text = "Rera Number-189037",
                            modifier = Modifier.weight(1f),
                            color = Color(0xff000000),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            textAlign = TextAlign.End,
                            maxLines = 1
                        )
                    }
                    HorizontalDivider(
                        Modifier
                            .fillMaxWidth()
                            .background(color = Color(0xff1A000000))
                    )
                    Row {
                        CustomText(
                            text = "Rera Verified",
                            modifier = Modifier,
                            color = Color(0xffB2000000),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),

                            maxLines = 1
                        )

                        CustomText(
                            text = "View",
                            modifier = Modifier.weight(1f),
                            color = Color(0xff3D0ADC),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                            textAlign = TextAlign.End,
                            maxLines = 1
                        )
                    }
                    HorizontalDivider(
                        Modifier
                            .fillMaxWidth()
                            .background(color = Color(0xff1A000000))
                    )
                    Row {
                        CustomText(
                            text = "Property Availability",
                            modifier = Modifier,
                            color = Color(0xffB2000000),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),

                            maxLines = 1
                        )

                        CustomText(
                            text = "Ready to move",
                            modifier = Modifier.weight(1f),
                            color = Color(0xff000000),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            textAlign = TextAlign.End,
                            maxLines = 1
                        )
                    }
                }

                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Project Units",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(10.dp))
                val items = listOf("2 BHK", "3 BHK", "Shops")
                var selectedIndex by remember { mutableStateOf(0) }
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items.forEachIndexed { index, text ->
                        val isSelected = index == selectedIndex
                        val borderColor = if (isSelected) Color(0xff3D0ADC) else Color.Transparent
                        val textColor = if (isSelected) Color(0xff3D0ADC) else Color.Black

                        CustomText(
                            text = text,
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(6.dp))
                                .border(
                                    width = 1.dp,
                                    color = borderColor,
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .background(Color(0xffE9F0FF), RoundedCornerShape(6.dp))
                                .clickable { selectedIndex = index } // change selection
                                .padding(horizontal = 25.dp, vertical = 10.dp),
                            color = textColor,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            textAlign = TextAlign.Center,
                            maxLines = 1)
                    }
                }


                Spacer(Modifier.height(20.dp))
                val sqfitUnits = listOf(
                    "480 SQ.FT",
                    "720 SQ.FT",
                    "960 SQ.FT",
                    "1200 SQ.FT",
                    "1500 SQ.FT",
                    "1800 SQ.FT",
                    "2000 SQ.FT",
                    "2500 SQ.FT"
                )
                var selectedTabIndexofSq by remember { mutableStateOf(0) }

                ScrollableTabRow(
                    selectedTabIndex = selectedTabIndexofSq,
                    containerColor = Color.White,
                    contentColor = Color.Blue,
                    edgePadding = 0.dp, // removes start/end padding
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier
                                .tabIndicatorOffset(tabPositions[selectedTabIndexofSq])
                                .width(tabPositions[selectedTabIndexofSq].contentWidth), // underline matches text
                            color = Color(0xFF3209D2), height = 2.dp
                        )
                    },
                    divider = {
                        Divider(color = Color(0xFFE0E0E0), thickness = 2.dp)
                    },
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    sqfitUnits.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndexofSq == index,
                            onClick = { selectedTabIndexofSq = index },
                            selectedContentColor = Color.Black,
                            unselectedContentColor = Color(0xFF4D4D4D)
                        ) {
                            Text(
                                text = title,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                            )
                        }
                    }
                }
                Spacer(Modifier.height(20.dp))

                CustomText(
                    text = "Per Unit Details",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(10.dp))

                CustomImage(
                    id = R.drawable.img1,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(280.dp)
                        .border(width = 3.dp, color = Color(0xffE6E9F3), RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        CustomText(
                            text = "Carpet Area",
                            modifier = Modifier,
                            color = Color(0xff292929),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_regular)),
                            maxLines = 1
                        )
                        CustomText(
                            text = "480 SQ.FT",
                            modifier = Modifier,
                            color = Color(0xff000000),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),

                            maxLines = 1
                        )

                    }
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        CustomText(
                            text = "Carpet Area",
                            modifier = Modifier,
                            color = Color(0xff292929),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_regular)),
                            maxLines = 1
                        )
                        CustomText(
                            text = "₹ 50L",
                            modifier = Modifier,
                            color = Color(0xff000000),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),

                            maxLines = 1
                        )

                    }
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomText(
                            text = "Carpet Area",
                            modifier = Modifier,
                            color = Color(0xff292929),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_regular)),
                            maxLines = 1
                        )
                        CustomText(
                            text = "₹ 6,730",
                            modifier = Modifier,
                            color = Color(0xff000000),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),

                            maxLines = 1
                        )

                    }
                }

                Spacer(Modifier.height(30.dp))

                CustomText(
                    text = "Promotions (Offers)",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomText(
                        text = "Save50(50% discount)",
                        modifier = Modifier,
                        color = Color(0xffCC000000),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                        maxLines = 1
                    )
                    CustomText(
                        text = "Valid till 25th sep 2025",
                        modifier = Modifier,
                        color = Color(0xffCC000000),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                        maxLines = 1
                    )
                }

                CustomText(
                    text = "Lorem ipsum dolorsit amet, Lorem ipsum dametLorem ipsum dolorsit ametLorem ipsum Lorem ipsum dolorsit amet, Lorem ipsum dolorsit ametLorem ipsum dolorsit ametLorem ipsum.",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    color = Color(0xff000000),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_regular)),
                    maxLines = 10
                )
                Spacer(Modifier.height(20.dp))

                CustomText(
                    text = "Property Insights",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    CustomImage(
                        id = R.drawable.map,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(103.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Row(
                        modifier = Modifier
                            .paint(
                                painter = painterResource(id = R.drawable.view_on_map_),
                                contentScale = ContentScale.Crop
                            )
                            .padding(horizontal = 25.dp, vertical = 8.dp)
                            .align(Alignment.Center),

                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        CustomText(
                            text = "View on Map",
                            modifier = Modifier,
                            color = Color.White,
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.ma_medium)),
                            maxLines = 1
                        )
                        CustomImage(
                            id = R.drawable.arrow_1,
                            modifier = Modifier,
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomText(
                            text = "Max Hospital",
                            modifier = Modifier,
                            color = Color(0xff6D6E71),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            maxLines = 1
                        )
                        Spacer(
                            Modifier.height(
                                12.dp
                            )
                        )
                        TextWithImage2(id = R.drawable.location, text = "1.5 Km")

                    }
                    VerticalDivider(
                        Modifier
                            .height(33.dp)
                            .background(color = Color(0xff6D6E71))
                    )
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomText(
                            text = "Railway Station",
                            modifier = Modifier,
                            color = Color(0xff6D6E71),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            maxLines = 1
                        )
                        Spacer(
                            Modifier.height(
                                12.dp
                            )
                        )
                        TextWithImage2(id = R.drawable.location, text = "1.5 Km")

                    }
                    VerticalDivider(
                        Modifier
                            .height(33.dp)
                            .background(color = Color(0xff6D6E71))
                    )
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomText(
                            text = "Max Hospital",
                            modifier = Modifier,
                            color = Color(0xff6D6E71),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            maxLines = 1
                        )
                        Spacer(
                            Modifier.height(
                                12.dp
                            )
                        )
                        TextWithImage2(id = R.drawable.location, text = "1.5 Km")

                    }

                }
                Spacer(Modifier.height(30.dp))
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            color = Color(0xffF7F4E4), RoundedCornerShape(12.dp)
                        )
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    CustomText(
                        text = "Pricing and Offers",
                        modifier = Modifier,
                        color = Color(0xffCC000000),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.ma_bold)),
                        maxLines = 1
                    )
                    itemList.forEach {
                        RowWithTwoTextSemiBold(it.first, it.second)
                    }

                }

                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Let’s take a tour of the property",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )


                val item1 = listOf(
                    GalleryItem("Exterior(1)", R.drawable.img1),
                    GalleryItem("Hall (3)", R.drawable.img1),
                    GalleryItem("Living Room (2)", R.drawable.img1),
                    GalleryItem("Exterior(2)", R.drawable.img1, isVideo = true),
                    GalleryItem("Surrounding(2)", R.drawable.img1),
                    GalleryItem("Interior (3)", R.drawable.img1)
                )
                Spacer(Modifier.height(15.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(item1.size) { item ->
                        GalleryCard(item1[item])
                    }
                }

                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Walkthrough link",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(8.dp))
                CustomText(
                    text = "https://in/buy/projects/page/31685-avant-hillway-by-avant-group-in-goregaon-east?fltcnt=7cfeb4f2-f356-43df-b5d7-8473eb5cbf6b",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff562EFF),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_regular)),
                    maxLines = 10,
                    textDecoration = TextDecoration.Underline
                )
                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Properties in this project",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(20.dp))

                var selected by remember { mutableStateOf(0) }

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .border(1.dp, color = Color(0xFFFFE427), shape = RoundedCornerShape(10.dp))
                        .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (selected == 0) Color(0xFFFBDD22) else Color.Transparent)
                            .clickable { selected = 0 }
                            .padding(15.dp),
                        text = "Buy",
                        fontSize = 16.sp,
                        color = Color(0xFF562EFF),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.m_medium))
                    )

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (selected == 1) Color(0xFFFBDD22) else Color.Transparent)
                            .clickable { selected = 1 }
                            .padding(15.dp),
                        text = "Rent",
                        fontSize = 16.sp,
                        color = Color(0xFF562EFF),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.m_medium))
                    )
                }
                Spacer(Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items.forEachIndexed { index, text ->
                        val isSelected = index == selectedIndex
                        val borderColor = if (isSelected) Color(0xff3D0ADC) else Color.Transparent
                        val textColor = if (isSelected) Color(0xff3D0ADC) else Color.Black

                        CustomText(
                            text = text,
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(6.dp))
                                .border(
                                    width = 1.dp,
                                    color = borderColor,
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .background(Color(0xffE9F0FF), RoundedCornerShape(6.dp))
                                .clickable { selectedIndex = index } // change selection
                                .padding(horizontal = 25.dp, vertical = 10.dp),
                            color = textColor,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            textAlign = TextAlign.Center,
                            maxLines = 1)
                    }
                }

                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(20) {
                        BHKComposable(modifier = Modifier.weight(1f))
                    }

                }
                Spacer(Modifier.height(40.dp))

                CustomText(
                    text = "Price Trends/Insights",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )

                Spacer(Modifier.height(10.dp))

                CustomText(
                    text = "Property Rates in Delhi",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.m_medium)),
                    maxLines = 1
                )

                CustomText(
                    text = "50 of 74 localities in Delhi",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff99000000),
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.m_medium)),
                    maxLines = 1
                )
                Spacer(Modifier.height(15.dp))

                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(2) {
                        PriceTrendsComposable()
                    }

                }

                Spacer(Modifier.height(40.dp))

                CustomText(
                    text = "Locality Delhi/Insights",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )

                Spacer(Modifier.height(10.dp))

                CustomText(
                    text = "Localities in Pune",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.m_medium)),
                    maxLines = 1
                )

                CustomText(
                    text = "Showing 30 of 1335 | Localities in Pune",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff99000000),
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.m_medium)),
                    maxLines = 1
                )
                Spacer(Modifier.height(15.dp))
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(2) {
                        PriceTrendsComposable(showLocality = true)
                    }

                }

                Spacer(Modifier.height(30.dp))

                CustomText(
                    text = "Location",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(10.dp))

                CustomImage(
                    id = R.drawable.map,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(15.dp))
                VerticalDivider(
                    Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Color(0xff80000000))
                )


                Spacer(Modifier.height(15.dp))

                CustomText(
                    text = "Travel Time",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1
                )
                Spacer(Modifier.height(10.dp))

                Column(
                    Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(color = Color.White, RoundedCornerShape(5.dp))
                        .border(width = 0.5.dp, color = Color(0xff616161), RoundedCornerShape(5.dp))
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CustomImage(
                            id = R.drawable.location,
                            modifier = Modifier
                                .width(15.dp)
                                .height(20.dp),
                            contentScale = ContentScale.Crop
                        )
                        CustomText(
                            text = "Choose Starting\n Point",
                            modifier = Modifier,
                            color = Color(0xff80121212),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                            maxLines = 2,
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Left dashed line
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.dp)
                                .background(Color.Transparent)
                                .drawBehind {
                                    drawLine(
                                        color = Color.Gray,
                                        start = Offset(0f, size.height / 2),
                                        end = Offset(size.width, size.height / 2),
                                        strokeWidth = size.height,
                                        pathEffect = PathEffect.dashPathEffect(
                                            floatArrayOf(20f, 10f),
                                            0f
                                        )
                                    )
                                }
                        )

                        // Icon in circle
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .size(40.dp)
                                .background(Color(0xFFEAF0FF), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.car),
                                contentDescription = "Car",
                                tint = Color.Black,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        // Right dashed line
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.dp)
                                .background(Color.Transparent)
                                .drawBehind {
                                    drawLine(
                                        color = Color.Gray,
                                        start = Offset(0f, size.height / 2),
                                        end = Offset(size.width, size.height / 2),
                                        strokeWidth = size.height,
                                        pathEffect = PathEffect.dashPathEffect(
                                            floatArrayOf(20f, 10f),
                                            0f
                                        )
                                    )
                                }
                        )
                    }


                    Spacer(Modifier.height(10.dp))
                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Spacer(Modifier.weight(1f))
                        CustomImage(
                            id = R.drawable.img1,
                            modifier = Modifier
                                .clip(RoundedCornerShape(1.dp))
                                .size(28.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier,
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CustomText(
                                text = "Clue County",
                                modifier = Modifier,
                                color = Color(0xff121212),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                                maxLines = 2,
                            )
                            CustomText(
                                text = "Sector 63,\nNoida, U.P. 201301",
                                modifier = Modifier,
                                color = Color(0xff393C47),
                                fontSize = 8.sp,
                                fontFamily = FontFamily(Font(R.font.m_medium)),
                                maxLines = 2,
                            )
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))

                CustomText(
                    text = "Show Travel Time",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(5.dp)
                        )
                        .background(color = Color.White, RoundedCornerShape(5.dp))
                        .border(width = 0.5.dp, Color(0xff616161), RoundedCornerShape(5.dp))
                        .padding(vertical = 10.dp),
                    color = Color(0xff393C47),
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.m_medium)),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                )
                Spacer(Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(5.dp)
                        )
                        .background(color = Color.White, RoundedCornerShape(5.dp))
                        .border(width = 0.5.dp, Color(0xffD9D9D9), RoundedCornerShape(5.dp))
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        CustomImage(
                            id = R.drawable.location,
                            modifier = Modifier
                                .size(14.dp),
                            contentScale = ContentScale.Fit
                        )
                        CustomText(
                            text = "Bangalore Airport Taxi - Instacar, Residency Road, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka, India",
                            modifier = Modifier.weight(1f),
                            color = Color(0xff393C47),
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.m_regular)),
                            maxLines = 5,
                        )
                        CustomImage(
                            id = R.drawable.cross,
                            modifier = Modifier
                                .size(14.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                    Spacer(Modifier.height(15.dp))

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 25.dp)
                            .fillMaxWidth(),

                        verticalAlignment = Alignment.CenterVertically,

                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        TravelComposable(
                            modifier = Modifier.weight(1f)
                        )

                        TravelComposable(
                            modifier = Modifier.weight(1f)

                        )

                    }

                }

                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Contact Info",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.m_bold)),
                    maxLines = 2,
                )
                Spacer(Modifier.height(18.dp))
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight)
                        .clip(RoundedCornerShape(16.dp))
                        .border(
                            width = 1.dp, color = Color(0xff33000000), RoundedCornerShape(16.dp)
                        )
                        .padding(15.dp), verticalArrangement = Arrangement.spacedBy(13.dp)
                ) {
                    items(5) { it ->
                        InfoComposabl()
                        if (it != 4) {
                            Spacer(Modifier.height(12.dp))
                            HorizontalDivider(
                                Modifier
                                    .fillMaxWidth()
                                    .background(color = Color(0xff1A000000))
                            )
                        }
                    }
                }
                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Contact Builder",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.m_bold)),
                    maxLines = 2,
                )

                var name by remember { mutableStateOf("") }
                var email by remember { mutableStateOf("") }
                var number by remember { mutableStateOf("") }


                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            width = 1.dp, color = Color(0xff1A3D0ADC), RoundedCornerShape(12.dp)
                        )
                        .padding(bottom = 20.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                color = Color(0xff3209D2), RoundedCornerShape(12.dp)
                            )
                            .padding(14.dp)
                    ) {
                        CustomImage(
                            id = R.drawable.img1,
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .size(75.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column {
                            CustomText(
                                text = "Mr. Anil Sharma",
                                modifier = Modifier.padding(start = 16.dp),
                                color = Color.White,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.m_medium)),
                                maxLines = 1,
                            )
                            Spacer(Modifier.height(8.dp))

                            CustomText(
                                text = "Builder | Since 2024 | 18903745",
                                modifier = Modifier.padding(start = 16.dp),
                                color = Color.White,
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.m_regular)),
                                maxLines = 1,
                            )
                            Spacer(Modifier.height(10.dp))

                            CustomText(
                                text = "12 Yrs Exp.",
                                modifier = Modifier.padding(start = 16.dp),
                                color = Color.White,
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.m_regular)),
                                maxLines = 1,
                            )


                        }

                    }

                    Spacer(Modifier.height(20.dp))

                    TextField(
                        value = name,
                        onValueChange = {
                            name = it
                        },
                        modifier = Modifier
                            .padding(14.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(color = Color.White, RoundedCornerShape(8.dp))
                            .border(1.dp, Color(0xff26000000), RoundedCornerShape(8.dp))
                            .padding(horizontal = 10.dp),
                        placeholder = {
                            CustomText(
                                text = "Your name",
                                modifier = Modifier,
                                color = Color(0xff99000000),
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.m_light)),
                                maxLines = 1,
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            errorContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent
                        )
                    )
                    TextField(
                        value = email,
                        onValueChange = {
                            email = it
                        },
                        modifier = Modifier
                            .padding(14.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(color = Color.White, RoundedCornerShape(8.dp))
                            .border(1.dp, Color(0xff26000000), RoundedCornerShape(8.dp))
                            .padding(horizontal = 10.dp),
                        placeholder = {
                            CustomText(
                                text = "Email",
                                modifier = Modifier,
                                color = Color(0xff99000000),
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.m_light)),
                                maxLines = 1,
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            errorContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent
                        )
                    )
                    val context = LocalContext.current
                    var countryCode by remember { mutableStateOf(getUserCountry(context)) }
                    Row(
                        modifier = Modifier
                            .padding(14.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(color = Color.White, RoundedCornerShape(8.dp))
                            .border(1.dp, Color(0xff26000000), RoundedCornerShape(8.dp))
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        DialogCountryPicker(
                            pickedCountry = { countryCode = it.countryCode },
                            countryCodeTextColorAndIconColor = Color.Black,
                            trailingIconComposable = {},
                            isCircleShapeFlag = true,
                            isCountryFlagVisible = false,
                        )
                        VerticalDivider(
                            Modifier
                                .height(26.dp)
                                .background(Color(0xff33000000))
                        )
                        TextField(
                            value = number,
                            onValueChange = {
                                number = it
                            },
                            modifier = Modifier.weight(1f),
                            placeholder = {
                                CustomText(
                                    text = "Mobile number",
                                    modifier = Modifier,
                                    color = Color(0xff99000000),
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.m_light)),
                                    maxLines = 1,
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                errorContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Transparent
                            )
                        )

                    }

                    CustomText(
                        text = "Are you a real estate agent?",
                        modifier = Modifier.padding(start = 16.dp),
                        color = Color(0xff99000000),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        maxLines = 1,
                    )
                    Spacer(Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.padding(start = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CustomText(
                            text = "No",
                            modifier = Modifier
                                .clip(RoundedCornerShape(3.dp))
                                .background(Color.White, RoundedCornerShape(3.dp))
                                .border(width = 1.dp, Color(0xff26000000), RoundedCornerShape(3.dp))
                                .padding(horizontal = 10.dp, vertical = 5.dp),
                            color = Color(0xff3209D2),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            maxLines = 1,
                        )

                        CustomText(
                            text = "Yes",
                            modifier = Modifier
                                .clip(RoundedCornerShape(3.dp))
                                .background(Color(0xffE9F0FF), RoundedCornerShape(3.dp))
                                .padding(horizontal = 10.dp, vertical = 5.dp),
                            color = Color(0xff3209D2),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            maxLines = 1,
                        )
                    }

                    Spacer(Modifier.height(20.dp))

                    var isChecked by remember { mutableStateOf(false) }
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),

                        ) {

                        TermsAndConditionsRow(
                            checked = isChecked,
                            onCheckedChange = {
                                isChecked = !isChecked
                            },
                            onTermsClick = {},
                            onPrivacyClick = {}
                        )
                    }
                    Spacer(Modifier.height(20.dp))
                    CustomText(
                        text = "Request A Call Back",
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                Color(0xff3209D2), RoundedCornerShape(8.dp)
                            )
                            .padding(vertical = 14.dp),
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                    )


                }

                Spacer(Modifier.height(20.dp))
                CustomText(
                    text = "About Buildero",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.m_bold)),
                    maxLines = 2,
                )
                Spacer(Modifier.height(20.dp))

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            width = 0.5.dp, color = Color(0xff616161), RoundedCornerShape(12.dp)
                        )
                        .padding(14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CustomImage(
                            id = R.drawable.img1,
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .size(75.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            CustomText(
                                text = "Mr. Anil Sharma",
                                modifier = Modifier,
                                color = Color(0xff000000),
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.m_medium)),
                                maxLines = 1,
                            )
                            Spacer(Modifier.height(8.dp))

                            CustomText(
                                text = "Builder | Since 2024",
                                modifier = Modifier,
                                color = Color(0xff99000000),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.m_regular)),
                                maxLines = 1,
                            )
                            Spacer(Modifier.height(10.dp))

                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                CustomText(
                                    text = "Total Projects",
                                    modifier = Modifier,
                                    color = Color(0xff99000000),
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.m_medium)),
                                    maxLines = 1,
                                )
                                Spacer(Modifier.weight(1f))

                                CustomText(
                                    text = "12",
                                    modifier = Modifier,
                                    color = Color(0xff000000),
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                                    maxLines = 1,
                                )

                            }


                        }


                    }
                    Spacer(Modifier.height(10.dp))
                    CustomText(
                        text = "Lorem ipsum dolorsit amet, Lorem ipsum dametLorem ipsum dolorsit ametLorem ipsum Lorem ipsum dolorsit amet Lorem ipsum.",
                        modifier = Modifier,
                        color = Color(0xff000000),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular)),
                        maxLines = 10,
                    )


                }

                Spacer(Modifier.height(13.dp))

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomText(
                        text = "More Projects by this Owner",
                        modifier = Modifier,
                        color = Color(0xffCC000000),
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1,
                    )
                    CustomText(
                        text = "View all",
                        modifier = Modifier,
                        color = Color(0xff3209D2),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular)),
                        maxLines = 1,
                    )
                }
                Spacer(Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(20) {
                        MoreProjexts()
                    }

                }
                Spacer(Modifier.height(35.dp))

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomText(
                        text = "More Properties in Noida",
                        modifier = Modifier,
                        color = Color(0xffCC000000),
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1,
                    )
                    CustomText(
                        text = "See all",
                        modifier = Modifier,
                        color = Color(0xff3209D2),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular)),
                        maxLines = 1,
                    )
                }
                Spacer(Modifier.height(10.dp))
                CustomText(
                    text = "Properties related to what you just viewed",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff393C47),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_medium)),
                    maxLines = 1,
                )
                Spacer(Modifier.height(8.dp))
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(20) {
                        MoreProperties()
                    }

                }
                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Compare Projects",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1,
                )
                val propertyData = listOf(
                    mapOf(
                        "Name" to "Cleo County",
                        "Location" to "Sector-52",
                        "Price" to "1.85 Cr",
                        "RERA Verified" to "Yes",
                        "Age" to "05",
                        "Avg Price" to "45Lac-1.8Cr",
                        "Phases" to "Multi",
                        "Amenities" to "Pool/Court",
                        "Unit" to "2BHK - 3BHK"
                    ),
                    mapOf(
                        "Name" to "Gaur City",
                        "Location" to "Sector-62",
                        "Price" to "1.36 Cr",
                        "RERA Verified" to "No",
                        "Age" to "02",
                        "Avg Price" to "45Lac-1.8Cr",
                        "Phases" to "Single",
                        "Amenities" to "Tennis Court",
                        "Unit" to "2BHK"
                    ),
                    mapOf(
                        "Name" to "Gaur City",
                        "Location" to "Sector-62",
                        "Price" to "1.36 Cr",
                        "RERA Verified" to "No",
                        "Age" to "02",
                        "Avg Price" to "45Lac-1.8Cr",
                        "Phases" to "Single",
                        "Amenities" to "Tennis Court",
                        "Unit" to "2BHK"
                    ),
                    mapOf(
                        "Name" to "Gaur City",
                        "Location" to "Sector-62",
                        "Price" to "1.36 Cr",
                        "RERA Verified" to "No",
                        "Age" to "02",
                        "Avg Price" to "45Lac-1.8Cr",
                        "Phases" to "Single",
                        "Amenities" to "Tennis Court",
                        "Unit" to "2BHK"
                    ),
                    mapOf(
                        "Name" to "Gaur City",
                        "Location" to "Sector-62",
                        "Price" to "1.36 Cr",
                        "RERA Verified" to "No",
                        "Age" to "02",
                        "Avg Price" to "45Lac-1.8Cr",
                        "Phases" to "Single",
                        "Amenities" to "Tennis Court",
                        "Unit" to "2BHK"
                    )
                )

                val images = listOf(
                    R.drawable.img1, // Replace with actual drawable
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img1,
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    PropertyComparisonTable(propertyData, images)
                }


                CustomText(
                    text = "FAQs",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1,
                )
                Spacer(Modifier.height(10.dp))
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(20) {
                        Faqs()
                    }

                }

                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Quick Links",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1,
                )
                Spacer(Modifier.height(15.dp))

                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(9.dp),
                    horizontalArrangement = Arrangement.spacedBy(9.dp),
                    content = {
                        items(6) { index ->
                            Column(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFE9F0FF)) // Light blue background
                                    .clickable { }
                                    .padding(top = 15.dp, bottom = 25.dp, start = 8.dp, end = 8.dp),
                                verticalArrangement = Arrangement.spacedBy(9.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                CustomImage(
                                    id = R.drawable.zym,
                                    modifier = Modifier.size(35.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                CustomText(
                                    text = "New Launches",
                                    color = Color(0xFF373636),
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.m_medium)),
                                    maxLines = 1
                                )
                            }

                        }
                    }
                )

                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Disclaimer",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1,
                )
                Spacer(Modifier.height(10.dp))
                CustomText(
                    text = "Lorem ipsum dolor sit amet, est consectetur adipiscing elit. Etiam lorem turpis molestie, dictum est as, mattis tell us. Sed dignissim, metus nec fringilla accumsan, risus sember sollicitudin lacus, ut interdum tellus elit sed risus. Maecenas eget condimentum velita.",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White)
                        .border(
                            width = 1.dp, Color(0xffE2E2E2), RoundedCornerShape(12.dp)
                        ) // Light blue background
                        .clickable { }
                        .padding(top = 12.dp, bottom = 25.dp, start = 12.dp, end = 12.dp),
                    color = Color(0xff99000000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.m_regular)),
                    maxLines = Int.MAX_VALUE,
                )
                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "RERA Details",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1,
                )


                Spacer(Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White)
                        .border(
                            width = 1.dp, Color(0xffE2E2E2), RoundedCornerShape(12.dp)
                        ) // Light blue background
                        .clickable { }
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    InfoComposabl()


                }
                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "RERA Certificate",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1,
                )
                RoundedCornerShape(15.dp)
                CustomImage(
                    id = R.drawable.certificate,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .width(130.dp)
                        .height(100.dp)
                        .border(1.dp, Color(0xff666D6E71), RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(30.dp))
                CustomText(
                    text = "Activity On This Property",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xffCC000000),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.ma_bold)),
                    maxLines = 1,
                )
                Spacer(Modifier.height(12.dp))


                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(9.dp),
                    horizontalArrangement = Arrangement.spacedBy(9.dp),
                    content = {
                        items(3) { index ->
                            StatsCard()

                        }
                    }
                )
                Spacer(Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomText(
                        text = "Rating & Reviews",
                        modifier = Modifier,
                        color = Color(0xffCC000000),
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1,
                    )
                    CustomText(
                        text = "View all",
                        modifier = Modifier,
                        color = Color(0xff3209D2),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular)),
                        maxLines = 1,
                    )
                }

                Spacer(Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(8.dp)
                        )
                        .background(Color(0xffF1EDFC), RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 7.dp)
                ) {
                    CustomText(
                        text = "Write Your Review",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(6.dp)
                            )
                            .background(Color(0xff6666FF), RoundedCornerShape(6.dp))
                            .padding(vertical = 14.dp),
                        color = Color.White,
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.ma_medium)),
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                    )

                }
                Spacer(Modifier.height(30.dp))

                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 20.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        CustomImage(
                            id = R.drawable.img1,
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .size(38.dp),
                            contentScale = ContentScale.Crop
                        )
                        CustomText(
                            text = "Sandeep S.",
                            modifier = Modifier.weight(1f),
                            color = Color(0xff393C47),
                            fontSize = 11.sp,
                            fontFamily = FontFamily(Font(R.font.m_regular)),
                            textAlign = TextAlign.Left,
                            maxLines = 1,
                        )
                        CustomText(
                            text = "2 months ago",
                            modifier = Modifier,
                            color = Color(0xff393C47),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_regular)),
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                        )

                    }
                    Spacer(Modifier.height(10.dp))
                    CustomText(
                        text = "Lorem Ipsum is simply dummy text of the printing.Lorem Ipsum is simply dummy text of the printing.",
                        modifier = Modifier,
                        color = Color(0xff393C47),
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular)),
                        maxLines = Int.MAX_VALUE,
                    )
                    Spacer(Modifier.height(10.dp))
                    var rating: Float = 5.0f
                    var helpfulCount by remember { mutableStateOf(0) }
                    var notHelpfulCount by remember { mutableStateOf(0) }
                    RatingAndHelpfulSection(
                        rating,
                        helpfulCount,
                        notHelpfulCount
                    )
                    Spacer(Modifier.height(14.dp))

                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = maxHeight),
                        horizontalArrangement = Arrangement.spacedBy(7.dp)
                    ) {

                        items(5) {
                            CustomImage(
                                id = R.drawable.img1,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .size(100.dp),
                                contentScale = ContentScale.Crop
                            )
                        }

                    }
                }
                Spacer(Modifier.height(12.dp))

                HorizontalDivider(
                    Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xff1a393C47))
                )

                Spacer(Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomText(
                        text = "Tour This Society",
                        modifier = Modifier,
                        color = Color(0xffCC000000),
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1,
                    )
                    CustomText(
                        text = "See all",
                        modifier = Modifier,
                        color = Color(0xff3209D2),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular)),
                        maxLines = 1,
                    )
                }
                Spacer(Modifier.height(5.dp))
                CustomText(
                    text = "Images & Videos",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff393C47),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_medium)),
                    maxLines = 1,
                )
                Spacer(Modifier.height(10.dp))
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(20) {
                        CustomImage(
                            id = R.drawable.img1,
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .width(240.dp)
                                .height(180.dp),
                            contentScale = ContentScale.Crop
                        )
                    }

                }
                Spacer(Modifier.height(25.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomText(
                        text = "Similar Properties",
                        modifier = Modifier,
                        color = Color(0xffCC000000),
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1,
                    )
                    CustomText(
                        text = "See all",
                        modifier = Modifier,
                        color = Color(0xff3209D2),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular)),
                        maxLines = 1,
                    )
                }
                Spacer(Modifier.height(10.dp))
                CustomText(
                    text = "Properties related to what you just viewed",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xff393C47),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_medium)),
                    maxLines = 1,
                )
                Spacer(Modifier.height(8.dp))
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(max = maxHeight),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(20) {
                        MoreProperties()
                    }
                }
                Spacer(Modifier.height(30.dp))
                Row(
                    Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    CustomText(
                        text = "Contact",
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xffE9F0FF), RoundedCornerShape(10.dp))
                            .padding(vertical = 15.dp),
                        color = Color(0xff562EFF),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                    )
                    CustomText(
                        text = "Contact",
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xffFBDD22), RoundedCornerShape(10.dp))
                            .padding(vertical = 15.dp),
                        color = Color(0xff562EFF),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                    )

                }
                Spacer(Modifier.height(30.dp))


            }
        }
}

@Composable
fun PropertyComparisonTable(
    properties: List<Map<String, String>>,
    propertyImages: List<Int>
) {
    val attributes = listOf(
        "Image",
        "Name",
        "Location",
        "Price",
        "RERA Verified",
        "Age",
        "Avg Price",
        "Phases",
        "Amenities",
        "Unit"
    )

    val imageHeight = 150.dp // same as property image height


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
            .border(
                width = 1.dp,
                Color(0xff33000000), RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
            )
            .horizontalScroll(rememberScrollState()) // scrolls the entire row
    ) {
        // Left column (fixed-width)
        Column(
            modifier = Modifier
                .background(Color.White)
                .width(120.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFF6A5AE0))
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                CustomText(
                    text = "Properties",
                    modifier = Modifier,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.m_medium)),
                    maxLines = 1,
                )
            }

            attributes.forEachIndexed { index, label ->
                Box(
                    modifier = Modifier
                        .border(1.dp, Color.LightGray)
                        .fillMaxWidth()
                        .then(
                            if (index == 0) Modifier
                                .height(imageHeight)
                                .padding(top = 12.dp, start = 15.dp)
                            else Modifier.padding(8.dp)
                        ),
                ) {
                    CustomText(
                        text = label,
                        modifier = Modifier,
                        color = Color(0xff000000),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        maxLines = 1,
                    )
                }
            }
        }

        properties.forEachIndexed { index, property ->
            Column(
                modifier = Modifier.width(140.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF6A5AE0))
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {

                    CustomText(
                        text = "Property ${index + 1}",
                        modifier = Modifier,
                        color = Color(0xffFFFFFF),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        maxLines = 1,
                    )
                }

                // Image row
                Box(
                    modifier = Modifier
                        .border(1.dp, Color.LightGray)
                        .height(imageHeight)
                        .fillMaxWidth()
                ) {

                    CustomImage(
                        id = propertyImages[index],
                        modifier = Modifier
                            .padding(vertical = 15.dp, horizontal = 10.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .size(150.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                // Other attributes
                attributes.drop(1).forEach { key ->
                    Box(
                        modifier = Modifier
                            .border(1.dp, Color.LightGray)
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {

                        CustomText(
                            text = property[key] ?: "",
                            modifier = Modifier,
                            color = Color(0xffCC000000),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            maxLines = 1,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RatingAndHelpfulSection(
    rating: Float = 5.0f,
    initialHelpfulCount: Int = 0,
    initialNotHelpfulCount: Int = 0
) {
    var helpfulCount by remember { mutableStateOf(initialHelpfulCount) }
    var notHelpfulCount by remember { mutableStateOf(initialNotHelpfulCount) }
    var userSelection by remember { mutableStateOf<String?>(null) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(5) {
                CustomImage(
                    id = R.drawable.star,
                    modifier = Modifier.size(16.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            CustomText(
                text = String.format("%.1f", rating),
                color = Color(0xff393C47),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.m_regular)),
                maxLines = 1
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            CustomText(
                text = "Helpful?",
                color = Color(0xff393C47),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.m_medium)),
                maxLines = 1
            )
            Spacer(modifier = Modifier.width(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    when (userSelection) {
                        null -> {
                            helpfulCount++
                            userSelection = "like"
                        }
                        "like" -> {
                            helpfulCount--
                            userSelection = null
                        }
                        "dislike" -> {
                            notHelpfulCount--
                            helpfulCount++
                            userSelection = "like"
                        }
                    }
                }
            ) {
                CustomImage(
                    id = R.drawable.like,
                    modifier = Modifier.size(18.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(4.dp))
                CustomText(
                    text = helpfulCount.toString(),
                    color = Color(0xff393C47),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_regular)),
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    when (userSelection) {
                        null -> {
                            notHelpfulCount++
                            userSelection = "dislike"
                        }
                        "dislike" -> {
                            notHelpfulCount--
                            userSelection = null
                        }
                        "like" -> {
                            helpfulCount--
                            notHelpfulCount++
                            userSelection = "dislike"
                        }
                    }
                }
            ) {
                CustomImage(
                    id = R.drawable.dislike,
                    modifier = Modifier.size(18.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(4.dp))
                CustomText(
                    text = notHelpfulCount.toString(),
                    color = Color(0xff393C47),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_regular)),
                    maxLines = 1
                )
            }
        }
    }
}
@Composable
fun StatsCard(
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White)
            .border(1.25.dp, Color(0xFF1A000000), RoundedCornerShape(5.dp)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CustomImage(
                id = R.drawable.eye,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .size(40.dp)
                    .background(Color(0xff562EFF))
                    .padding(5.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(Modifier.height(16.dp))
            CustomText(
                text = "250",
                modifier = Modifier,
                color = Color(0xff393C47),
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                maxLines = 1,
            )
            Spacer(Modifier.height(8.dp))
            CustomText(
                text = "Views",
                modifier = Modifier,
                color = Color(0xff393C47),
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                maxLines = 1,
            )
        }
        CustomImage(
            id = R.drawable.background,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .align(Alignment.BottomEnd),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Faqs() {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(
                width = 1.dp, Color(0xffE2E2E2), RoundedCornerShape(8.dp)
            )
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            CustomText(
                text = "1. Lorem ipsum dolor sit amet.",
                modifier = Modifier,
                color = Color(0xff000000),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.m_medium)),
                maxLines = 1,
            )
            CustomImage(
                id = if (expanded) {
                    R.drawable.up
                } else {
                    R.drawable.down
                },
                modifier = Modifier
                    .size(18.dp)
                    .clickable(onClick = {
                        expanded = !expanded
                    }),
                contentScale = ContentScale.Crop
            )

        }
        if (expanded) {
            Spacer(Modifier.height(15.dp))

            CustomText(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eu turpis molestie, dictum est a, mattis tell us. Sed dignissim, metus nec fringilla accumsan, risus sem sollicitudin lacus, ut interdum tellus elit sed risus. Maecenas eget condimentum velita.",
                modifier = Modifier,
                color = Color(0xffCC000000),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.m_regular)),
                maxLines = 10,
            )
        }


    }
}

@Composable
fun MoreProperties() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White) // Ensures divider contrast
            .border(0.5.dp, Color(0xFF616161), RoundedCornerShape(12.dp))
            .padding(10.dp),
    ) {
        // --- Top Section ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            CustomImage(
                id = R.drawable.img1,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(84.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Row {
                    CustomText(
                        text = "Fully Furnished",
                        color = Color(0xff121212),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1
                    )
                    Spacer(Modifier.width(30.dp))
                    CustomText(
                        text = "₹ 50 Lakh",
                        color = Color(0xff3209D2),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1
                    )
                }
                Spacer(Modifier.height(5.dp))
                CustomText(
                    text = "2 BHk Flat JJ Colony, Sector 63,\nNoida, U.P. 201301",
                    color = Color(0xff393C47),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_regular)),
                    maxLines = 3
                )
            }
        }

        // --- Divider ---
        Spacer(Modifier.height(10.dp))
        Divider(
            color = Color.Red,
            thickness = 2.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))

        // --- Bottom Section ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CustomImage(
                id = R.drawable.img1,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .size(42.dp),
                contentScale = ContentScale.Crop
            )
            CustomText(
                text = "Saroj Sharma",
                color = Color(0xff121212),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                maxLines = 3
            )
            Spacer(Modifier.width(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                CustomImage(
                    id = R.drawable.message,
                    modifier = Modifier,
                    contentScale = ContentScale.Crop,
                )
                CustomImage(
                    id = R.drawable.view_phone,
                    modifier = Modifier,
                    contentScale = ContentScale.Crop,
                )
                CustomImage(
                    id = R.drawable.call, contentScale = ContentScale.Crop,
                    modifier = Modifier
                )
            }
        }
    }
}


@Composable
fun MoreProjexts() {

    Column(
        modifier = Modifier
            .border(0.5.dp, Color(0xFF616161), RoundedCornerShape(12.dp)),
    ) {


        Row(
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(84.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        1.dp,
                        Color(0x33000000),
                        shape = RoundedCornerShape(10.dp)
                    ),
                painter = painterResource(R.drawable.img1),
                contentDescription = "",
                contentScale = ContentScale.Crop,


                )
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "Fully Furnished",
                    color = Color(0xFF121212),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.m_bold))
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "2 BHk Flat JJ Colony, Sector 63 Noida,\n U.P. 201301",
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        color = Color(0xFF393C47),
                        fontFamily = FontFamily(Font(R.font.m_regular))
                    )

                }
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "₹ 50 Lakh - 1.3cr",
                    fontSize = 14.sp,
                    color = Color(0xFF3209D2),
                    fontFamily = FontFamily(Font(R.font.m_bold))
                )


            }

        }


    }
}

@Composable
fun TermsAndConditionsRow(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box(
            modifier = Modifier.size(20.dp), // Smaller hitbox
            contentAlignment = Alignment.Center
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange,
                modifier = Modifier.size(18.dp),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Gray
                )
            )
        }


        Text(
            buildAnnotatedString {
                append("I Agree To The ")
                pushStringAnnotation(tag = "TERMS", annotation = "terms")
                withStyle(style = SpanStyle(color = Color(0xFF007BFF), fontSize = 10.sp)) {
                    append("Terms & Conditions")
                }
                pop()
                append(" And ")
                pushStringAnnotation(tag = "PRIVACY", annotation = "privacy")
                withStyle(style = SpanStyle(color = Color(0xFF007BFF), fontSize = 10.sp)) {
                    append("Privacy Policy")
                }
                pop()
            },
            modifier = Modifier.clickable { /* Optional global click */ },
            fontSize = 12.sp,
            color = Color.Black
        )
    }
}


@Composable
fun InfoComposable() {
    Row(modifier = Modifier.fillMaxWidth()) {
        CustomText(
            text = "Rera Verified",
            modifier = Modifier,
            color = Color(0xffB2000000),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.m_medium)),

            maxLines = 1
        )

        CustomText(
            text = "Rera Number-189037",
            modifier = Modifier.weight(1f),
            color = Color(0xff000000),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.m_medium)),
            textAlign = TextAlign.End,
            maxLines = 1
        )
    }
    HorizontalDivider(
        Modifier
            .fillMaxWidth()
            .background(color = Color(0xff1A000000))
    )
}

@Composable
private fun InfoComposabl() {
    Row(modifier = Modifier.fillMaxWidth()) {
        CustomText(
            text = "Rera Verified",
            modifier = Modifier,
            color = Color(0xffB2000000),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.m_medium)),

            maxLines = 1
        )

        CustomText(
            text = "Rera Number-189037",
            modifier = Modifier.weight(1f),
            color = Color(0xff000000),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.m_medium)),
            textAlign = TextAlign.End,
            maxLines = 1
        )
    }
}

@Composable
fun TravelComposable(modifier: Modifier) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(11.dp))
            .background(Color(0xff0d000000), RoundedCornerShape(11.dp))
            .padding(horizontal = 14.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        CustomImage(
            id = R.drawable.parking,
            modifier = Modifier.size(14.dp),
            contentScale = ContentScale.Fit
        )
        CustomText(
            text = "1 hour 1 min (30.3 km)",
            modifier = Modifier,
            color = Color(0xff393C47),
            fontSize = 8.sp,
            fontFamily = FontFamily(Font(R.font.m_regular)),
            maxLines = 1,
        )

    }
}

@Composable
fun PriceTrendsComposable(showLocality: Boolean? = false) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = Color(0xffE9F0FF)),
        color = Color.White,
        shadowElevation = 0.2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CustomImage(
                    id = R.drawable.img1,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop

                )
                Column(modifier = Modifier.weight(1f)) {
                    CustomText(
                        text = "Sector 15 Dwarka",
                        modifier = Modifier,
                        color = Color(0xff000000),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        maxLines = 1
                    )
                    Spacer(Modifier.height(10.dp))
                    CustomText(
                        text = "Delhi South West",
                        modifier = Modifier,
                        color = Color(0xff99000000),
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        maxLines = 1
                    )
                    Spacer(Modifier.height(5.dp))

                    CustomText(
                        text = "AFFORDABLE",
                        modifier = Modifier
                            .background(
                                color = Color(0xffE9F0FF),
                                RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        color = Color(0xff3209D2),
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.m_medium)),
                        maxLines = 1
                    )


                }

                val text = if (showLocality == true) {
                    "₹9,800/\n Sq.ft\n Avg. Rate"
                } else {
                    "₹6,300/ \nSq.ft"
                }
                CustomText(
                    text = text,
                    modifier = if (showLocality == false) {
                        Modifier.padding(end = 40.dp)
                    } else {
                        Modifier.padding(end = 0.dp)
                    },
                    color = Color(0xff000000),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_black)),
                    textAlign = if (showLocality == true) {
                        TextAlign.End
                    } else {
                        TextAlign.Start
                    },
                    maxLines = 5
                )
            }
            Spacer(Modifier.height(25.dp))
            Row(modifier = Modifier.fillMaxWidth()) {

                Column {
                    if (showLocality == false) {
                        CustomText(
                            text = "Rental Yield",
                            modifier = Modifier,
                            color = Color(0xff000000),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            maxLines = 1
                        )
                        Spacer(Modifier.height(10.dp))
                        CustomText(
                            text = "3%",
                            modifier = Modifier,
                            color = Color(0xff000000),
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.m_bold)),
                            maxLines = 1
                        )
                    } else {
                        Row(
                            modifier = Modifier
                                .background(
                                    color = Color(0xffE9F0FF),
                                    RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Image(
                                painterResource(R.drawable.rating_img),
                                contentDescription = null,
                                Modifier.size(14.dp),
                                contentScale = ContentScale.Crop
                            )
                            CustomText(
                                text = "5.0",
                                modifier = Modifier,
                                color = Color(0xff3209D2),
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.m_medium)),
                                maxLines = 1
                            )

                        }
                        Spacer(Modifier.height(10.dp))
                        CustomText(
                            text = "1K+ Reviews",
                            modifier = Modifier,
                            color = Color(0xff99000000),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.m_medium)),
                            maxLines = 1
                        )


                    }

                }
                Spacer(Modifier.weight(1f))
                CustomImage(
                    id = R.drawable.chart,
                    modifier = Modifier
                        .width(120.dp)
                        .height(65.dp),
                    contentScale = ContentScale.Crop
                )
            }


        }
    }

}

@SuppressLint("InvalidColorHexValue")
@Composable
private fun BHKComposable(modifier: Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box {
            CustomImage(
                id = R.drawable.img1,
                modifier = Modifier
                    .width(160.dp)
                    .height(180.dp)
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(
                        RoundedCornerShape(8.dp)
                    ),
                contentScale = ContentScale.Crop
            )
            CustomText(
                text = "Posted 3 days ago",
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp)
                    .background(
                        color = Color(0xffE9F0FF),
                        RoundedCornerShape(6.dp)
                    )
                    .align(Alignment.TopStart)
                    .padding(horizontal = 14.dp, vertical = 5.dp),
                color = Color(0xffB2292929),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.m_medium)),
                textAlign = TextAlign.Center,
                maxLines = 1,
            )
        }
        Spacer(Modifier.height(10.dp))
        CustomText(
            text = "2 BHK Flat",
            modifier = Modifier,
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.m_semi_bold)),
            maxLines = 1
        )
        Spacer(Modifier.height(5.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomText(
                text = "1951 sqft",
                modifier = Modifier,
                color = Color(0xff99000000),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.m_medium)),
                maxLines = 1
            )
            VerticalDivider(
                Modifier
                    .height(14.dp)
                    .background(Color(0xff4D393C47))
            )
            CustomText(
                text = "East Facing",
                modifier = Modifier,
                color = Color(0xff99000000),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.m_medium)),
                maxLines = 1
            )

        }
        Spacer(Modifier.height(8.dp))

        CustomText(
            text = "₹ 1.85 Cr",
            modifier = Modifier,
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.m_semi_bold)),
            maxLines = 1
        )

        CustomText(
            text = "by Sneha Kapoor",
            modifier = Modifier,
            color = Color(0xff99000000),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.m_medium)),
            maxLines = 1
        )
        Spacer(Modifier.height(12.dp))

        ButtonYellowBackground(
            modifier = Modifier.width(160.dp),
            txt = "Contact",
            onClick = { }
        )


    }
}

@Composable
fun GalleryCard(item: GalleryItem) {
    Box(
        modifier = Modifier
            .aspectRatio(1f) // makes square items
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(145.dp)
                .height(125.dp)
        )

        // Video icon overlay
        if (item.isVideo) {
            Icon(
                painter = painterResource(R.drawable.forward),
                contentDescription = "Play Video",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.Center)
            )
        }

        // Label at bottom
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0x80000000)) // semi-transparent black
                .align(Alignment.BottomCenter)
                .padding(4.dp)
        ) {
            Text(
                text = item.title,
                color = Color.White,
                fontSize = 12.sp,
                maxLines = 1,
                fontFamily = FontFamily(Font(R.font.m_regular)),
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}

data class GalleryItem(
    val title: String,
    val imageRes: Int,
    val isVideo: Boolean = false
)

@Composable
private fun TextWithImage2(id: Int, text: String) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        CustomImage(
            id = id,
            modifier = Modifier.size(13.dp),
            contentScale = ContentScale.Fit
        )
        CustomText(
            text = text,
            modifier = Modifier,
            color = Color(0xff000000),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.m_medium)),

            maxLines = 1

        )
    }
}

@Composable
fun RowWithTwoTextSemiBold(param: String = "", value: String = "") {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = param,
            fontSize = 12.sp,
            color = Color(0xFF6D6E71),
            fontFamily = FontFamily(Font(R.font.m_medium))
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = value,
            fontSize = 12.sp,
            color = Color(0xFF000000).copy(alpha = 0.8f),
            fontFamily = FontFamily(Font(R.font.m_semi_bold)),

            )


    }
}

@Composable
fun ImageWithTextComposableInColumn(id: Int, text: String) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomImage(
            id = id,
            modifier = Modifier
                .size(54.dp)
                .background(color = Color(0xffE9F0FF), RoundedCornerShape(6.dp)),
            contentScale = ContentScale.Fit
        )
        CustomText(
            text = text,
            modifier = Modifier,
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.m_medium)),
            maxLines = 2

        )
    }
}


@Composable
fun ButtonYellowBackground(
    modifier: Modifier = Modifier, txt: String = "", onClick: () -> Unit = {}
) {


    Text(
        modifier = modifier
            .fillMaxWidth()

            .background(Color(0xFFFBDD22), shape = RoundedCornerShape(5.dp))
            .clip(RoundedCornerShape(5.dp))
            .clickable {
                onClick()

            }
            .padding(15.dp),
        text = txt,
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.m_medium)),
        color = Color(0xFF3209D2),
    )
}


@Composable
fun ImageWithTextComposable(
    id: Int,
    text: String,
    modifier: Modifier = Modifier,          // parent modifier
    imageModifier: Modifier = Modifier      // child image modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        CustomImage(
            id = id,
            modifier = imageModifier           // use passed modifier
        )
        CustomText(
            text = text,
            modifier = Modifier.weight(1f),   // optional child modifier for Text
            color = Color(0xff393C47),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.m_regular)),
            maxLines = 2,
        )
    }
}

@SuppressLint("InvalidColorHexValue")
@Composable
fun ColumnComposable(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = Color(0xff616161), shape = RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(10.dp)
    ) {
        CustomText(
            text = "Cleo County Phase 1",
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xff121212),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.m_bold)),
            maxLines = 1
        )
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = "5 Buildings",
                modifier = Modifier,
                color = Color(0xff393C47),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.m_regular)),
                maxLines = 1
            )
            VerticalDivider(
                Modifier
                    .height(17.dp)
                    .background(color = Color(0xff4D393C47))
            )
            CustomText(
                text = "230 Units",
                modifier = Modifier,
                color = Color(0xff393C47),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.m_regular)),
                maxLines = 1
            )
            VerticalDivider(
                Modifier
                    .height(17.dp)
                    .background(color = Color(0xff4D393C47))
            )
            CustomText(
                text = "1, 2, 3 BHK",
                modifier = Modifier,
                color = Color(0xff393C47),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.m_regular)),
                maxLines = 1
            )
            VerticalDivider(
                Modifier
                    .height(17.dp)
                    .background(color = Color(0xff4D393C47))
            )
            CustomText(
                text = "45Lac - 1.8Cr",
                modifier = Modifier,
                color = Color(0xff393C47),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.m_regular)),
                maxLines = 1
            )
        }
        Spacer(Modifier.height(12.dp))
        HorizontalDivider(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color(0xff1A000000))
        )
        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            CustomText(
                text = "RERA",
                modifier = Modifier,
                color = Color(0xff393C47),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.m_regular)),
                maxLines = 1
            )
            CustomImage(
                id = R.drawable.crl,
                modifier = Modifier.size(4.dp),
            )

            CustomText(
                text = "K635800000697",
                modifier = Modifier,
                color = Color(0xff393C47),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.m_regular)),
                maxLines = 1
            )
            Spacer(Modifier.weight(1f))
            CustomText(
                text = "view certificate",
                modifier = Modifier
                    .background(
                        color = Color(0xffE9F0FF), RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                color = Color(0xff562EFF),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.m_medium)),
                maxLines = 1
            )

        }
        Spacer(Modifier.height(8.dp))
        HorizontalDivider(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color(0xff1A000000))
        )
        Spacer(Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            val text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff393C47),
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular))
                    )
                ) {
                    append("Price Range\n ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff562EFF),
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular))
                    )
                ) {
                    append("60Lac -2.30Cr")
                }
            }
            Text(text = text)

            VerticalDivider(
                Modifier
                    .height(17.dp)
                    .background(color = Color(0xff4D393C47))
            )
            val text1 = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff393C47),
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular))
                    )
                ) {
                    append("Launch Date\n ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff393C47),
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.m_regular))
                    )
                ) {
                    append("20/06/2025")
                }
            }
            CustomText(
                text = "Launch Date\n" + "20/06/2025",
                modifier = Modifier,
                color = Color(0xff393C47),
                fontSize = 10.sp,
                fontFamily = FontFamily(
                    Font(R.font.m_regular),

                    ),
                maxLines = 2
            )
            VerticalDivider(
                Modifier
                    .height(17.dp)
                    .background(color = Color(0xff4D393C47))
            )

            CustomText(
                text = "Exp. Possession\n" + "20/06/2025",
                modifier = Modifier,
                color = Color(0xff393C47),
                fontSize = 10.sp,
                fontFamily = FontFamily(
                    Font(R.font.m_regular),

                    ),
                maxLines = 2
            )


        }


    }

}

@Composable
fun CustomImage(id: Int, modifier: Modifier, contentScale: ContentScale? = null) {
    Image(
        painterResource(id),
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale ?: ContentScale.Fit
    )

}

@Composable
fun CustomText(
    text: String? = null,
    modifier: Modifier = Modifier,
    color: Color,
    fontSize: TextUnit,
    fontFamily: FontFamily,
    textAlign: TextAlign? = null,
    maxLines: Int? = null,
    textDecoration: TextDecoration? = TextDecoration.None,
) {
    Text(
        text = text ?: "",
        style = TextStyle(
            color = color,
            fontFamily = fontFamily,
            fontSize = fontSize,
            textDecoration = textDecoration
        ),
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
}


@Composable
fun ComposableIcon(id: Int, text: String, modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(
            painterResource(id), contentDescription = null, modifier = Modifier.size(16.dp)
        )
        Text(text, color = Color.White)
    }
}
