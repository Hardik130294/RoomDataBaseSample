package com.io.example.roomdatabasesample.entities.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.io.example.roomdatabasesample.entities.Student
import com.io.example.roomdatabasesample.entities.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)
