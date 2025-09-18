package com.example.finalsetup.screen

import android.app.Activity
import android.content.Context
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
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
        horizontalAlignment = Alignment.CenterHorizontally
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
                        deviceToken = "asdv",
                        deviceType = "1",
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



    ObserveApiResponse(liveData = viewModel.loginResponse) { loginData ->

        viewModel.loginDetail = loginData.data
        SharedPreference.get(context).accessToken = "Bearer " + loginData.data?.accessToken
        navController.navigate("home")
    }

}


@Composable
fun <T> ObserveApiResponse(
    liveData: LiveData<EmpResource<T>>,
    context: Context = LocalContext.current,
    onSuccess: (T) -> Unit
) {
    val lifeCycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(liveData) {
        liveData.observe(lifeCycleOwner) { resource ->
            when (resource) {
                is EmpResource.Failure -> {
                    Log.d("TAG", "observer: fail ${resource.throwable?.message}")
                    Toast.makeText(
                        context,
                        resource.throwable?.message ?: "Something went wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                    CustomLoader.hideLoader()
                }

                is EmpResource.Success -> {
                    Log.d("TAG", "observer: success")
                    // No BaseResponse here — just handle success directly
                    CustomLoader.hideLoader()
                    onSuccess(resource.value)
                }

                is EmpResource.Loading -> {
                    CustomLoader.showLoader(context as Activity?)
                }

                else -> {}
            }
        }
    }
}

