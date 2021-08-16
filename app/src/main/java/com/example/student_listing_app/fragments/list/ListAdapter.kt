package com.example.student_listing_app.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.student_listing_app.R
import com.example.student_listing_app.model.Student
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var studentList =  emptyList<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false))
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.name_txt.text = currentItem.name
        holder.itemView.course_txt.text = currentItem.course
        holder.itemView.rollno_txt.text = currentItem.rollNo.toString()


    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }

    fun setData(student:List<Student>){
        this.studentList = student
        notifyDataSetChanged()
    }
}