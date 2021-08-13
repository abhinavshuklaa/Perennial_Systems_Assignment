package com.example.perennialsystem_assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.perennialsystem_assignment.viewHolder.EmployeesViewHolder
import com.example.perennialsystem_assignment.R
import com.example.perennialsystem_assignment.model.Data

class EmployeesAdapter(private var modelList: List<Data>) :
    RecyclerView.Adapter<EmployeesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return EmployeesViewHolder(view)


    }

    override fun onBindViewHolder(holder: EmployeesViewHolder, position: Int) {
        val dataModel = modelList[position]
        holder.setDataToModel(dataModel)

    }


    override fun getItemCount(): Int {
        return modelList.size
    }
    fun updatedList(dataModelList: List<Data>){
        modelList =dataModelList
        notifyDataSetChanged()

    }


}