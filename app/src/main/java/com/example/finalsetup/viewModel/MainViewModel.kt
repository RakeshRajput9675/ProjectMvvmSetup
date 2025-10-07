package com.example.finalsetup.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalsetup.model.ComprehensiveResopnce
import com.example.finalsetup.model.LoginRequest
import com.example.finalsetup.model.LoginResopnce
import com.example.finalsetup.model.ProductRequest
import com.example.finalsetup.repository.AuthRepository
import com.example.finalsetup.repository.EmpResource
import com.example.finalsetup.screen.ChatMessage
import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    var loginDetail: LoginResopnce.Data? = null
    var comprehensiceDetail = mutableStateOf<ComprehensiveResopnce.Data?>(null)
    private val _loginResponse = MutableLiveData<EmpResource<LoginResopnce>>()
    val loginResponse: LiveData<EmpResource<LoginResopnce>>
        get() = _loginResponse

    fun hitLoginApi(request: LoginRequest) {
        viewModelScope.launch {
            _loginResponse.value = EmpResource.Loading
            _loginResponse.value = repository.login(request)
        }
    }

    private val _comprehensive = MutableLiveData<EmpResource<ComprehensiveResopnce>>()
    val comprehensive: LiveData<EmpResource<ComprehensiveResopnce>>
        get() = _comprehensive

    fun comprehensivehitApi(token: String, request: ProductRequest) {
        viewModelScope.launch {
            _comprehensive.value = EmpResource.Loading
            _comprehensive.value = repository.comprehensive(token, request)
        }
    }

    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages

    private val _isLoading = MutableStateFlow(false)
     val _errro = MutableStateFlow("")
    val isLoading: StateFlow<Boolean> = _isLoading

    var currentPrompt by mutableStateOf("")

    private val model = Firebase.ai(backend = GenerativeBackend.googleAI())
        .generativeModel("gemini-2.5-pro")

    fun sendMessage() {
        if (currentPrompt.isBlank()) return

        val userMessage = ChatMessage(currentPrompt, isUser = true)
        _messages.value = _messages.value + userMessage

        val prompt = currentPrompt
        currentPrompt = ""
        _isLoading.value = true

        viewModelScope.launch {
            try {
                val response = model.generateContent(prompt)
                val aiMessage = ChatMessage(response.text ?: "No response", isUser = false)
                _messages.value = _messages.value + aiMessage
            } catch (e: Exception) {
                val errorMessage = ChatMessage("Error: ${e.localizedMessage}", isUser = false)
                _errro.value = errorMessage.toString()
            } finally {
                _isLoading.value = false
            }
        }
    }

    private val _uiData = MutableStateFlow(
        UiData(name = "Rakesh", age = 25, hobbies = listOf("Coding", "Music"))
    )
    val uiData: StateFlow<UiData> = _uiData

    fun updateName(newName: String) {
        _uiData.value = _uiData.value.copy(name = newName)
    }
}

data class UiData(
    val name: String,
    val age: Int,
    val hobbies: List<String>
)
