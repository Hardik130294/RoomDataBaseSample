package com.io.example.roomdatabasesample.entities.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.io.example.roomdatabasesample.entities.Student
import com.io.example.roomdatabasesample.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
)