package com.io.example.roomdatabasesample.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.io.example.roomdatabasesample.entities.Director
import com.io.example.roomdatabasesample.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",//it representing School's schoolName
        entityColumn = "schoolName"//it representing Director's schoolName
    )
    val director: Director
)
