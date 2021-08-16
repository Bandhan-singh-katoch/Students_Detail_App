package com.example.student_listing_app.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.student_listing_app.R
import com.example.student_listing_app.model.Student
import com.example.student_listing_app.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mStudentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        view.addButton.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {

        val name = addStudentName.text.toString()
        val course = addCourseName.text.toString()
        val rollNo = addRollNo.text

        // if all details are not empty then run this block
        if(inputCheck(name,course,rollNo)){
            //create Student object
            val student =  Student(0,name,course,Integer.parseInt(rollNo.toString()) )
            // Adding data to database
            mStudentViewModel.addStudent(student)
            Toast.makeText(requireContext(),"Successfully added",Toast.LENGTH_LONG).show()
            //navigate back to StudentList after adding data into database
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else{
            Toast.makeText(requireContext(),"Fill all details",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name:String, course:String, rollNo: Editable):Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(course) && rollNo.isEmpty())
    }

}
