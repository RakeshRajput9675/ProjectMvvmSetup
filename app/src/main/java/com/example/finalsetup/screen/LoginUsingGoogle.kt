package com.example.finalsetup.screen


import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException
import androidx.navigation.NavController
import com.example.finalsetup.NavRoute
import com.example.finalsetup.helper.SharedPreference
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedBoxWithConstraintsScope")
@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun LoginUsingGoogle(navController: NavController) {
    val context = LocalContext.current
    val credentialManager = CredentialManager.create(context)
    val coroutineScope = rememberCoroutineScope()

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    Login(
                        context1 = context,
                        credentialManager1 = credentialManager,
                        coroutineScope1 = coroutineScope,
                        navController = navController
                    )
                }, modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("Sign in with Google")
            }
            Spacer(Modifier.height(20.dp))
            Button(
                onClick = {

                }, modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("Sign in with Facebook")
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
fun Login(
    context1: Context,
    credentialManager1: CredentialManager,
    coroutineScope1: CoroutineScope,
    navController: NavController,
) {
    val context = context1
    val activityContext = context
    val credentialManager = credentialManager1
    val coroutineScope = coroutineScope1
    val googleIdOption: GetGoogleIdOption =
        GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(false)
            .setServerClientId("677658941684-lfqtnnpkob6iqqo80ov2ak5ssss3fm33.apps.googleusercontent.com")
            .build()
    val request: GetCredentialRequest =
        GetCredentialRequest.Builder().addCredentialOption(googleIdOption).build()
    coroutineScope.launch {
        try {
            val result = credentialManager.getCredential(
                request = request,
                context = activityContext,
            )
            Log.d("Login", "Google Sign-In successful: $result")
            handleSignIn(result, navController, context1)
        } catch (e: GetCredentialException) {
            Log.e("Login", "Google Sign-In failed", e)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
fun handleSignIn(result: GetCredentialResponse, navController: NavController, context1: Context) {
    // Handle the successfully returned credential.
    val credential = result.credential
    Log.i("TAG", "handleSignIn:$credential ")
    when (credential) {

        is CustomCredential -> {
            if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                try {
                    val googleIdTokenCredential =
                        GoogleIdTokenCredential.createFrom(credential.data)
                    // Extract details
                    val idToken = googleIdTokenCredential.idToken
                    val data = googleIdTokenCredential.data
                    Log.i("Data", "User data : $data ")
                    SharedPreference.get(context1).saveId = idToken

                    // Send googleIdTokenCredential to your server for validation and authentication
                    navController.navigate(NavRoute.LogoutScreen.route) {
                        popUpTo(NavRoute.LoginUsingGoogle.route) { inclusive = true }
                    }
                    Toast.makeText(context1, "Login Successfully!", Toast.LENGTH_SHORT).show()

                } catch (e: GoogleIdTokenParsingException) {
                    Log.e("TAG", "Received an invalid google id token response", e)
                }
            } else {
                // Catch any unrecognized custom credential type here.
                Log.e("TAG", "Unexpected type of credential")
            }
        }

        else -> {
            // Catch any unrecognized credential type here.
            Log.e("TAG", "Unexpected type of credential")
        }
    }
}
