package com.example.finalsetup.screen

import android.annotation.SuppressLint
import android.content.Context
import android.telephony.TelephonyManager
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abi.simplecountrypicker.DialogCountryPicker
import com.example.finalsetup.R
import java.util.Locale

@SuppressLint("InvalidColorHexValue")
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ContactToSeller() {
    BoxWithConstraints(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        this.maxHeight
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxSize()

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(R.drawable.forward),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(24.dp)
                )
                Text(
                    "Contact to Seller", style = TextStyle(
                        fontSize = 18.sp,
                        color = Color(0xff003A4E),
                        fontWeight = FontWeight.SemiBold
                    ), modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(1f)
                )
            }
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                Box(
                    modifier = Modifier
                ) {
                    Text(
                        "Delivery - 20 Apr - 25 Apr",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .background(color = Color(0xffEAEEF0))
                            .padding(top = 16.dp),
                        textAlign = TextAlign.Center
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp, top = 48.dp)
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(4.dp))
                            .border(1.dp, Color(0xffD0D0D0), RoundedCornerShape(4.dp))
                            .padding(16.dp)
                    ) {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Image(
                                painter = painterResource(id = R.drawable.watch),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(185.dp)
                                    .clip(
                                        RoundedCornerShape(2.dp)
                                    ),
                                contentScale = ContentScale.Crop

                            )
                            Row(
                                modifier = Modifier
                                    .background(
                                        color = Color(0xffBFFFFFFF), RoundedCornerShape(2.dp)
                                    )
                                    .padding(horizontal = 6.dp, vertical = 3.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(3.dp)

                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.security),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    "Private Seller", style = TextStyle(
                                        fontSize = 18.sp,
                                        color = Color(0xff003A4E),
                                        fontWeight = FontWeight.SemiBold
                                    )
                                )
                            }

                        }
                        Spacer(Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                "Rolex Sky-Dweller", style = TextStyle(
                                    fontSize = 12.sp,
                                    color = Color(0xff003A4E),
                                    fontWeight = FontWeight.SemiBold

                                ), modifier = Modifier.weight(1f)
                            )
                            Icon(
                                painter = painterResource(R.drawable.forward),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)

                            )
                            Text(
                                "FR", style = TextStyle(
                                    fontSize = 12.sp,
                                    color = Color(0xff003A4E),
                                    fontWeight = FontWeight.SemiBold
                                )
                            )

                        }

                        Spacer(Modifier.height(2.dp))
                        Text(
                            "IC0026/03", style = TextStyle(
                                fontSize = 10.sp,
                                color = Color(0xff7F9CA6),
                                fontWeight = FontWeight.Medium

                            )
                        )
                    }
                }




                Spacer(Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .background(color = Color.White, RoundedCornerShape(4.dp))
                        .border(
                            width = 1.dp,
                            color = Color(0xffD0D0D0),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(10.dp)

                ) {
                    Text(
                        "Seller Details", style = TextStyle(
                            fontSize = 14.sp,
                            color = Color(0xff546D76),
                            fontWeight = FontWeight.Medium

                        )
                    )
                    Spacer(Modifier.height(6.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            "John Doe", style = TextStyle(
                                fontSize = 14.sp,
                                color = Color(0xff0E1C21),
                                fontWeight = FontWeight.SemiBold
                            )
                        )

                        Icon(
                            painter = painterResource(R.drawable.baseline_circle_24),
                            contentDescription = null,
                            modifier = Modifier.size(8.dp)
                        )

                        Icon(
                            painter = painterResource(R.drawable.forward),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)

                        )
                        Text(
                            "FR", style = TextStyle(
                                fontSize = 12.sp,
                                color = Color(0xff003A4E),
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }

                    Spacer(Modifier.height(18.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                "Since", style = TextStyle(
                                    fontSize = 14.sp,
                                    color = Color(0xff7F9CA6),
                                    fontWeight = FontWeight(400)
                                )
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                "2020", style = TextStyle(
                                    fontSize = 14.sp,
                                    color = Color(0xff0E1C21),
                                    fontWeight = FontWeight.Medium
                                )
                            )

                        }

                        VerticalDivider(
                            Modifier
                                .width(1.dp)
                                .height(28.dp)
                                .background(Color(0xffEAEEF0))
                        )

                        Column {
                            Text(
                                "Since", style = TextStyle(
                                    fontSize = 14.sp,
                                    color = Color(0xff7F9CA6),
                                    fontWeight = FontWeight(400)
                                )
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                "2020", style = TextStyle(
                                    fontSize = 14.sp,
                                    color = Color(0xff0E1C21),
                                    fontWeight = FontWeight.Medium
                                )
                            )

                        }

                        VerticalDivider(
                            Modifier
                                .width(1.dp)
                                .height(28.dp)
                                .background(Color(0xffEAEEF0))
                        )

                        Column {
                            Text(
                                "Since", style = TextStyle(
                                    fontSize = 14.sp,
                                    color = Color(0xff7F9CA6),
                                    fontWeight = FontWeight(400)
                                )
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                "2020", style = TextStyle(
                                    fontSize = 14.sp,
                                    color = Color(0xff0E1C21),
                                    fontWeight = FontWeight.Medium
                                )
                            )

                        }


                    }


                }



                Spacer(Modifier.height(25.dp))

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Color(0xFF7F9CA6).copy(alpha = 0.1f)
                        )
                        .padding(20.dp)
                ) {
                    Text(
                        "Confirm your contact Info and write the\n" + "message to reach out the seller",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xff7F9CA6),
                            fontWeight = FontWeight.Medium
                        )
                    )

                    Spacer(Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        TextComposable("First Name", modifier = Modifier.weight(1f))
                        TextComposable("Last Name", modifier = Modifier.weight(1f))
                    }

                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        var firstName by remember { mutableStateOf("") }
                        var lastName by remember { mutableStateOf("") }

                        BoxComposable(
                            text = "Jacks",
                            modifier = Modifier.weight(1f),
                            value = firstName,
                            onValueChange = { firstName = it })
                        BoxComposable(
                            text = "Johnson",
                            modifier = Modifier.weight(1f),
                            value = lastName,
                            onValueChange = { lastName = it })
                    }

                    Spacer(Modifier.height(20.dp))
                    TextComposable("Email Address", modifier = Modifier)
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        var email by remember { mutableStateOf("") }

                        BoxComposable(
                            text = "rakesh@gmail.com",
                            modifier = Modifier.weight(1f),
                            value = email,
                            onValueChange = { email = it })

                    }

                    Spacer(Modifier.height(20.dp))
                    TextComposable("Phone Number", modifier = Modifier)
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        val context = LocalContext.current
                        var phoneNumber by remember { mutableStateOf("") }
                        var countryCode by remember { mutableStateOf(getUserCountry(context = context)) }

                        DialogCountryPicker(

                            pickedCountry = { countryCode = it.countryCode },
                            countryCodeTextColorAndIconColor = Color.Black,
                            trailingIconComposable = {},

                            isCircleShapeFlag = false,
                            isCountryFlagVisible = false,
                        )

                        BoxComposable(
                            text = "1234567890",
                            modifier = Modifier,
                            value = phoneNumber,
                            onValueChange = { phoneNumber = it }
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun BoxComposable(
    text: String, modifier: Modifier, value: String, onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value, onValueChange = onValueChange, placeholder = {
            Text(text)
        }, modifier = modifier
            .clip(RoundedCornerShape(8.dp)) // clips content & background
            .background(Color.White)        // background inside clip
            .border(
                width = 1.dp, color = Color(0xFF7F9CA6), shape = RoundedCornerShape(8.dp)
            ), singleLine = true
    )

}

@Composable
private fun TextComposable(string: String, modifier: Modifier) {
    Text(
        string, style = TextStyle(
            fontSize = 14.sp, color = Color(0xff35494F), fontWeight = FontWeight(400)
        ), modifier = modifier, textAlign = TextAlign.Start


    )
}

fun getUserCountry(context: Context): String {
    val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

    // SIM-based country code
    val simCountry = tm.simCountryIso
    if (!simCountry.isNullOrEmpty()) {
        return simCountry.uppercase()
    }

    // Network-based country code
    val networkCountry = tm.networkCountryIso
    if (!networkCountry.isNullOrEmpty()) {
        return networkCountry.uppercase()
    }

    // Fallback to device locale
    return Locale.getDefault().country.uppercase()
}