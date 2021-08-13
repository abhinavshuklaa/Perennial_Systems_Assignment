package com.example.perennialsystem_assignment.network

import com.example.perennialsystem_assignment.model.Model
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api/v1/employees")
    fun getEmployeesList():Call<Model>
}