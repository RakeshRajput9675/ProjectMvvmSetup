package com.example.finalsetup.screen

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.finalsetup.R
import com.example.finalsetup.viewModel.MainViewModel

@Composable
fun PagingListScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val articles = viewModel.getBreakingNews().collectAsLazyPagingItems()
    val refreshState = rememberPullToRefreshState()
    var isRefreshing by remember { mutableStateOf(false) }

    PullToRefreshBox(
        modifier = Modifier.fillMaxSize(),
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            articles.refresh()
            isRefreshing = false
        },
        state = refreshState,
        contentAlignment = Alignment.TopCenter,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(count = articles.itemCount) { index ->
                val article = articles[index]
                if (article != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(
                                    "detail/${
                                        Uri.encode(article.title)
                                    }/${
                                        Uri.encode(article.urlToImage)
                                    }/${
                                        Uri.encode(article.description)
                                    }"
                                )


                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(article.urlToImage)
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.img1),
                            error = painterResource(R.drawable.img2),
                            contentDescription = null,
                            modifier = Modifier
                                .size(65.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Column {
                            Text(
                                text = article.title,
                                style = TextStyle(color = Color.Black)
                            )
                            Text(
                                text = article.description,
                                style = TextStyle(color = Color.Gray)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                }
            }

            // Handle loading states
            when (articles.loadState.refresh) {
                is LoadState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .fillParentMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("Loading articles...")
                            CircularProgressIndicator(color = Color.Black)
                        }
                    }
                }
                else -> Unit
            }

            when (articles.loadState.append) {
                is LoadState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("Loading more...")
                            CircularProgressIndicator(color = Color.Black)
                        }
                    }
                }
                else -> Unit
            }
        }
    }
}
