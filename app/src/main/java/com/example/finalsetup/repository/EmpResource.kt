package com.example.finalsetup.repository

sealed class EmpResource<out T> {
    data object Idle : EmpResource<Nothing>()

    data class Success<out T>(val value: T) : EmpResource<T>()

    data class Failure(
       val throwable: Throwable?
    ) : EmpResource<Nothing>()

    object Loading : EmpResource<Nothing>()

}
