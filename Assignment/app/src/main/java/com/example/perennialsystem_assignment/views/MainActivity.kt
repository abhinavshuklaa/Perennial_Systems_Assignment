package com.example.perennialsystem_assignment.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perennialsystem_assignment.model.EmployeeUIModel
import com.example.perennialsystem_assignment.adapter.EmployeesAdapter
import com.example.perennialsystem_assignment.R
import com.example.perennialsystem_assignment.model.Data
import com.example.perennialsystem_assignment.viewModel.EmployeeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var employeeViewModel: EmployeeViewModel
    private lateinit var employeeAdapter: EmployeesAdapter
    private val dataModelList = emptyList<Data>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        employeeViewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)
        setRecyclerAdapter()
        observableLiveData()
        employeeViewModel.apiCall()
    }

    private fun observableLiveData() {
        employeeViewModel.liveData.observe(this, {
            when (it) {
                is EmployeeUIModel.Success -> {
                    employeeAdapter.updatedList(it.modelList)
                }
                is EmployeeUIModel.Failure -> {
                    Toast.makeText(this, "Error Message : ${it.error}", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    private fun setRecyclerAdapter() {
        employeeAdapter = EmployeesAdapter(dataModelList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            this.layoutManager = layoutManager
            adapter = employeeAdapter

        }
    }
}