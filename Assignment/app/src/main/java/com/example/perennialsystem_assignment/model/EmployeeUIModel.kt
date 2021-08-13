package com.example.perennialsystem_assignment.model

sealed class EmployeeUIModel {
    data class Success(val modelList: List<Data>) : EmployeeUIModel()
    data class Failure(val error: String) : EmployeeUIModel()
}