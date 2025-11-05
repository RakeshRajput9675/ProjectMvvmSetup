package com.example.finalsetup.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.finalsetup.NavRoute
import com.example.finalsetup.R

@Composable
fun DetailPage(
    title: String,
    urlToImage: String,
    description: String,
    navController: NavHostController
) {

    val scrollState = rememberScrollState()

    // Now render the details
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(10.dp)
            .verticalScroll(scrollState)
            .clickable {
                navController.popBackStack(NavRoute.PagingListScreen.route, inclusive = false)
            }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                Icons.Default.ArrowBackIos, contentDescription = "fvd",
                modifier = Modifier.clickable {
                    navController.navigate(NavRoute.PagingListScreen.route)
                }
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(Modifier.height(10.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(urlToImage)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.img1),
            error = painterResource(R.drawable.img2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(10.dp))
        Text(
            title, style = TextStyle(
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight
            )
        )
        Spacer(Modifier.height(8.dp))
        Text(description)
    }
}
