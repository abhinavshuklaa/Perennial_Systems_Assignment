package com.example.perennialsystem_assignment.repository

import com.example.perennialsystem_assignment.model.Model
import com.example.perennialsystem_assignment.network.ApiService
import com.example.perennialsystem_assignment.network.Network
import retrofit2.Callback

class Repository(private val callback: Callback<Model>) {
    fun getEmployeesList() {
        val apiClient = Network.getNetworkInstance().create(ApiService::class.java)
        val call = apiClient.getEmployeesList()
        call.enqueue(callback)
    }
}