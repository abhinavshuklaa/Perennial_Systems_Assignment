package com.example.perennialsystem_assignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.perennialsystem_assignment.model.EmployeeUIModel
import com.example.perennialsystem_assignment.model.Data
import com.example.perennialsystem_assignment.model.Model
import com.example.perennialsystem_assignment.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeViewModel : ViewModel(), Callback<Model> {
    private val repository = Repository(this)
    private val mutableLiveData = MutableLiveData<EmployeeUIModel>()

    val liveData: LiveData<EmployeeUIModel> = mutableLiveData

    override fun onResponse(call: Call<Model>, response: Response<Model>) {
        response.body()?.let {
            mutableLiveData.value = EmployeeUIModel.Success(it.data as List<Data>)

        }


    }

    override fun onFailure(call: Call<Model>, t: Throwable) {
        mutableLiveData.value = EmployeeUIModel.Failure(t.message.toString())


    }

    fun apiCall() {
        repository.getEmployeesList()
    }

}