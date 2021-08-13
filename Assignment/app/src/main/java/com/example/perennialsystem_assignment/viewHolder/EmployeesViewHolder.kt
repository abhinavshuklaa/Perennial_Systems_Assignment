package com.example.perennialsystem_assignment.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.perennialsystem_assignment.model.Data
import kotlinx.android.synthetic.main.list_item_layout.view.*

class EmployeesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setDataToModel(data: Data) {
        view.apply {
            tvId.text = "ID : ${data.id.toString()}"
            tvName.text = "Name : ${data.employeeName.toString()}"
            tvAge.text = "Age : ${data.employeeAge.toString()}"
            tvSalary.text = "Salary : ${data.employeeSalary.toString()}"
        }

    }
}