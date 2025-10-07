package com.example.finalsetup.screen

import android.widget.Toast
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.finalsetup.viewModel.MainViewModel
import kotlin.jvm.Throws

@Composable
fun ChatScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val _error by viewModel._errro.collectAsState()
    val messages by viewModel.messages.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            reverseLayout = true
        ) {

            if (isLoading) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Row(
                            modifier = Modifier
                                .background(Color(0xFFECECEC), RoundedCornerShape(12.dp))
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TypingIndicator()
                        }
                    }
                }
            }

            items(messages.reversed()) { message ->
                ChatBubble(message = message, _error)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = viewModel.currentPrompt,
                onValueChange = { viewModel.currentPrompt = it },
                modifier = Modifier
                    .height(52.dp)
                    .weight(1f),
                placeholder = { Text("Type a message...") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(
                onClick = {
                    if (viewModel.currentPrompt.isEmpty()) {
                        Toast.makeText(
                            context,
                            "Please enter a message",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.sendMessage()
                    }
                },
                modifier = Modifier.height(52.dp)
            ) {
                Text("Send")
            }
        }
    }
}

@Composable
fun ChatBubble(message: ChatMessage, _error: String) {
    val alignment = if (message.isUser) Alignment.BottomEnd else Alignment.BottomStart
    val bubbleColor = if (message.isUser) Color(0xFFDCF8C6) else Color(0xFFECECEC)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        contentAlignment = alignment
    ) {
        if (message.text.isEmpty()) {
            Text(
                text = _error,
                modifier = Modifier
                    .background(bubbleColor, shape = RoundedCornerShape(12.dp))
                    .padding(12.dp),
                color = Color.Black
            )
        } else {
            Text(
                text = message.text,
                modifier = Modifier
                    .background(bubbleColor, shape = RoundedCornerShape(12.dp))
                    .padding(12.dp),
                color = Color.Black
            )
        }
    }
}

@Composable
fun TypingIndicator() {
    val transition = rememberInfiniteTransition(label = "typing")

    Row(modifier = Modifier.padding(8.dp)) {
        repeat(5) { index ->
            val color by transition.animateColor(
                initialValue = Color.Black,
                targetValue = Color.Gray,
                animationSpec = infiniteRepeatable(
                    tween(600, delayMillis = index * 200, easing = LinearEasing),
                    RepeatMode.Reverse
                ),
                label = "dotColor$index"
            )

            Box(
                modifier = Modifier
                    .size(12.dp)
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

data class ChatMessage(
    val text: String,
    val isUser: Boolean
)
