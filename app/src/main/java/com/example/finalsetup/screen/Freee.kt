package com.example.finalsetup.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalsetup.R

@Preview
@Composable
private fun Freee() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        val maxHeight = this.maxHeight
        val maxWidth = this.maxWidth
        MoreProperties()
    }
}
@Composable
fun MoreProperties1() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(0.5.dp, Color(0xFF616161), RoundedCornerShape(12.dp))
            .padding(10.dp),
    ) {
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
            Column(modifier = Modifier) {

                Row {
                    CustomText(
                        text = "Fully Furnished",
                        modifier = Modifier,
                        color = Color(0xff121212),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1,
                    )
                    Spacer(
                        Modifier.width(30.dp)

                    )
                    CustomText(
                        text = "₹ 50 Lakh",
                        modifier = Modifier,
                        color = Color(0xff3209D2),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.m_bold)),
                        maxLines = 1,
                    )
                }
                Spacer(
                    Modifier.height(5.dp)
                )
                CustomText(
                    text = "2 BHk Flat JJ Colony, Sector 63,\n" +
                            "Noida, U.P. 201301",
                    modifier = Modifier,
                    color = Color(0xff393C47),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.m_regular)),
                    maxLines = 3,
                )
            }


        }
        Spacer(
            Modifier.height(10.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Red)
        )


        Spacer(
            Modifier.height(10.dp)
        )
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
                modifier = Modifier,
                color = Color(0xff121212),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.m_semi_bold)),
                maxLines = 3,
            )
            Spacer(Modifier.width(10.dp))
            Row(
                modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(10.dp)

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