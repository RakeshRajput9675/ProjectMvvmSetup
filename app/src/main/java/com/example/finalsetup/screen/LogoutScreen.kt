package com.example.finalsetup.screen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.navigation.NavController
import com.example.finalsetup.NavRoute
import com.example.finalsetup.helper.SharedPreference
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedBoxWithConstraintsScope", "CoroutineCreationDuringComposition")
@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun LogoutScreen(navController: NavController) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        val coroutineScope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ElevatedButton(
                onClick = {
                    onLogout(
                        context = context,
                        navController = navController,
                        coroutineScope = coroutineScope
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = ButtonDefaults.elevatedShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.scrim,
                    contentColor = MaterialTheme.colorScheme.onError
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 2.dp,
                    pressedElevation = 4.dp,
                    hoveredElevation = 6.dp,
                    focusedElevation = 8.dp
                ),
                contentPadding = ButtonDefaults.TextButtonContentPadding
            ) {
                Text(
                    "Logout",
                    modifier = Modifier,
                    style = MaterialTheme.typography.titleLarge,
                )
            }

            Spacer(Modifier.height(30.dp))

            FcmTokenScreen()

            Spacer(Modifier.height(30.dp))
            Button(
                onClick = {
                    navController.navigate(NavRoute.ChatScreen.route)
                },
                modifier = Modifier.fillMaxWidth().height(52.dp)
                ) {
                Text("Click to Search")
            }




        }

    }
}


@Composable
fun FcmTokenScreen() {
    var token by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task->
            if (task.isSuccessful){
                token = task.result

            }

        }
    }
    Log.e("TAG", "FcmTokenScreen: $token")
    Text(if (token.isNotEmpty()) "FCM Token: $token" else "Fetching")
}

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
fun onLogout(
    context: Context,
    navController: NavController,
    coroutineScope: CoroutineScope
) {
    coroutineScope.launch {
        try {
            val credentialManager = CredentialManager.create(context)
            val request = ClearCredentialStateRequest()
            credentialManager.clearCredentialState(request)
            SharedPreference.get(context).accessToken = ""
            Toast.makeText(context, "Logout Successfully!", Toast.LENGTH_SHORT).show()
            Log.d("Logout", "Google credentials cleared")
        } catch (e: Exception) {
            Log.e("Logout", "Error clearing credentials", e)
        }
    }
    navController.navigate(NavRoute.LoginUsingGoogle.route) {
        popUpTo(NavRoute.LogoutScreen.route) { inclusive = true }
    }
}


//
//val model = Firebase.ai(backend = GenerativeBackend.googleAI())
//    .generativeModel("gemini-2.5-flash")
//
//
//val prompt = "Write a story about a magic backpack."
//
//var generatedText by remember { mutableStateOf("") }
//coroutineScope.launch {
//    try {
//        val response = model.generateContent(prompt)
//        generatedText = response.text.toString()
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }
//}
//Box(
//modifier = Modifier.fillMaxSize(),
//
//contentAlignment = Alignment.Center
//) {
//
//    if (generatedText.isEmpty()) {
//        Column {
//            CircularProgressIndicator()
//            Text("Generating")
//        }
//    } else {
//        Text(text = generatedText)
//    }
//}