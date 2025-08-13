package com.example.finalsetup.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import com.example.finalsetup.base.CustomLoader
import com.example.finalsetup.helper.SharedPreference
import com.example.finalsetup.model.LoginRequest
import com.example.finalsetup.repository.EmpResource
import com.example.finalsetup.viewModel.MainViewModel

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val lifeCycleOwner = LocalLifecycleOwner.current


    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(text = "Email")
            },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Password")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))

        Button(
            onClick = {


                viewModel.hitLoginApi(
                    request = LoginRequest(
                        deviceToken = "sdfghj",//for notification
                        deviceType = "1", // check in api response
                        email = email,
                        password = password
                    )
                )

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")

        }

    }

    LaunchedEffect(Unit) {
        viewModel.loginResponse.observe(lifeCycleOwner) { it1 ->
            when (it1) {
                is EmpResource.Failure -> {
                    Log.d("TAG", "observer: fail ")
                    Toast.makeText(context, it1.throwable?.message, Toast.LENGTH_SHORT).show()
                    CustomLoader.hideLoader()
                }

                is EmpResource.Success -> {
                    Toast.makeText(context, it1.value.message, Toast.LENGTH_SHORT).show()
                    Log.d("TAG", "observer: success")
                    it1.value.data?.let {
                        if (it != null) {
                            viewModel.loginDetail = it
                            SharedPreference.get(context).accessToken = "Bearer " + it.accessToken
                            navController.navigate("home")
                        }
                    }

                }

                else -> {}
            }
        }
    }

}


