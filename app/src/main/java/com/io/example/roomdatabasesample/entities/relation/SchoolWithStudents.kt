package com.io.example.roomdatabasesample.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.io.example.roomdatabasesample.entities.School
import com.io.example.roomdatabasesample.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",//it representing School's schoolName
        entityColumn = "schoolName"//it representing Student's schoolName
    )
    val students: List<Student>
)

