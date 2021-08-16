package com.example.student_listing_app.fragments.update

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
import androidx.navigation.fragment.navArgs
import com.example.student_listing_app.R
import com.example.student_listing_app.model.Student
import com.example.student_listing_app.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mStudentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        view.updateStudentName.setText(args.currentStudent.name)
        view.updateCourseName.setText(args.currentStudent.course)
        view.updateRollNo.setText(args.currentStudent.rollNo.toString())

        view.updateButton.setOnClickListener {
            updateItem()
        }

        return view
    }

    fun updateItem(){
        val name = updateStudentName.text.toString()
        val course = updateCourseName.text.toString()
        val rollno = Integer.parseInt(updateRollNo.text.toString())

        if(inputCheck(name,course,updateRollNo.text)){
            //Student object
            val updatedStudent = Student(args.currentStudent.id,name,course,rollno)
            //Update current Student
            mStudentViewModel.updateStudent(updatedStudent)
            //Toast msg after successfull updation
            Toast.makeText(requireContext(),"Updated successfully",Toast.LENGTH_SHORT).show()
            //go back to list fragment after updation
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }else{
            Toast.makeText(requireContext(),"Fill all details",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(name:String, course:String, rollNo: Editable):Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(course) && rollNo.isEmpty())
    }

}