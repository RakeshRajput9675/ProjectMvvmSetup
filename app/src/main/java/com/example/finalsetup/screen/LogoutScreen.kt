package com.example.finalsetup.screen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.navigation.NavController
import com.example.finalsetup.NavRoute
import com.example.finalsetup.helper.SharedPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedBoxWithConstraintsScope")
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
        }
    }
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
            SharedPreference.get(context).removeId()
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
