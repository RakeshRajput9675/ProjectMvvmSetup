package com.example.finalsetup.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalsetup.model.LoginRequest
import com.example.finalsetup.model.LoginResopnce
import com.example.finalsetup.repository.AuthRepository
import com.example.finalsetup.repository.EmpResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject // <-- Correct import

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    var loginDetail: LoginResopnce.Data? = null
    private val _loginResponse = MutableLiveData<EmpResource<LoginResopnce>>()
    val loginResponse: LiveData<EmpResource<LoginResopnce>>
        get() = _loginResponse

    fun hitLoginApi(request: LoginRequest) {
        viewModelScope.launch {
            _loginResponse.value = EmpResource.Loading
            _loginResponse.value = repository.login(request)
        }
    }
}
