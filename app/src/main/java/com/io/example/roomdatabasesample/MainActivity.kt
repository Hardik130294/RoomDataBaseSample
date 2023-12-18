package com.io.example.roomdatabasesample

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.io.example.roomdatabasesample.databinding.ActivityMainBinding
import com.io.example.roomdatabasesample.entities.Director
import com.io.example.roomdatabasesample.entities.School
import com.io.example.roomdatabasesample.entities.Student
import com.io.example.roomdatabasesample.entities.Subject
import com.io.example.roomdatabasesample.entities.relation.SchoolAndDirector
import com.io.example.roomdatabasesample.entities.relation.StudentSubjectCrossRef
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: ActivityMainBinding

//    private lateinit var database: SchoolDatabase

//    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*
//        Snackbar.make(binding.root, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()

        //code here
        database = SchoolDatabase.getInstance(applicationContext)
//        database = Room.databaseBuilder(
//            applicationContext,
//            SchoolDatabase::class.java,
//            "schoolDB"
//        ).build()
        GlobalScope.launch {
            database.schoolDao.insertStudent(Student("Radha",6,"S.m.d.m.s"))
            database.schoolDao.insertStudent(Student("Lalita",6,"Valukad School"))
            database.schoolDao.insertStudent(Student("Vishakha",6,"Sanosara School"))
            database.schoolDao.insertStudent(Student("Chitra",6,"Surat School"))

            database.schoolDao.insertDirector(Director("Ram Raghav","S.m.d.m.s"))
            database.schoolDao.insertDirector(Director("Shyam Yadav","Valukad School"))
            database.schoolDao.insertDirector(Director("Balram Yadav","Sanosara School"))
            database.schoolDao.insertDirector(Director("Barat Raghav","Surat School"))

            database.schoolDao.insertSchool(School("S.m.d.m.s"))
            database.schoolDao.insertSchool(School("Valukad School"))
            database.schoolDao.insertSchool(School("Sanosara School"))
            database.schoolDao.insertSchool(School("Surat School"))

            database.schoolDao.insertSubject(Subject("Hindi"))
            database.schoolDao.insertSubject(Subject("Gujarati"))
            database.schoolDao.insertSubject(Subject("English"))
            database.schoolDao.insertSubject(Subject("Marathi"))
            database.schoolDao.insertSubject(Subject("Math"))
            database.schoolDao.insertSubject(Subject("Science"))
            database.schoolDao.insertSubject(Subject("Sanskrit"))
            database.schoolDao.insertSubject(Subject("History"))

            //one to many
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Radha","Hindi"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Radha","Gujarati"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Radha","English"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Radha","Marathi"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Radha","Math"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Radha","Science"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Radha","Sanskrit"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Radha","History"))

            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Lalita","Hindi"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Lalita","Gujarati"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Lalita","English"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Lalita","Math"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Lalita","Sanskrit"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Lalita","History"))


            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Vishakha","Hindi"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Vishakha","English"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Vishakha","Marathi"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Vishakha","Math"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Vishakha","History"))


            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Chitra","Gujarati"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Chitra","English"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Chitra","Marathi"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Chitra","Math"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Chitra","Science"))
            database.schoolDao.insertStudentSubjectCrossRef(StudentSubjectCrossRef("Chitra","Sanskrit"))

            var sad : List<SchoolAndDirector> = database.schoolDao.getSchoolAndDirectorWithSchoolName("Sanosara School")
            Log.i(TAG, "onCreate: ${sad.size}")
            for (s :SchoolAndDirector in sad)
            {
                Log.i(TAG, "onCreate: DirectorName : ${s.director.directorName}, Director SchoolName : ${s.director.schoolName}, SchoolName : ${s.school.schoolName}")
            }
        }*/

        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director("Mike Litoris", "Jake Wharton School"),
            Director("Jack Goff", "Kotlin School"),
            Director("Chris P. Chicken", "JetBrains School")
        )
        val schools = listOf(
            School("Jake Wharton School"),
            School("Kotlin School"),
            School("JetBrains School")
        )
        val subjects = listOf(
            Subject("Dating for programmers"),
            Subject("Avoiding depression"),
            Subject("Bug Fix Meditation"),
            Subject("Logcat for Newbies"),
            Subject("How to use Google")
        )
        val students = listOf(
            Student("Beff Jezos", 2, "Kotlin School"),
            Student("Mark Suckerberg", 5, "Jake Wharton School"),
            Student("Gill Bates", 8, "Kotlin School"),
            Student("Donny Jepp", 1, "Kotlin School"),
            Student("Hom Tanks", 2, "JetBrains School")
        )
        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Beff Jezos", "Dating for programmers"),
            StudentSubjectCrossRef("Beff Jezos", "Avoiding depression"),
            StudentSubjectCrossRef("Beff Jezos", "Bug Fix Meditation"),
            StudentSubjectCrossRef("Beff Jezos", "Logcat for Newbies"),
            StudentSubjectCrossRef("Mark Suckerberg", "Dating for programmers"),
            StudentSubjectCrossRef("Gill Bates", "How to use Google"),
            StudentSubjectCrossRef("Donny Jepp", "Logcat for Newbies"),
            StudentSubjectCrossRef("Hom Tanks", "Avoiding depression"),
            StudentSubjectCrossRef("Hom Tanks", "Dating for programmers")
        )
        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector = dao.getSchoolAndDirectorWithSchoolName("Kotlin School")

            val schoolWithStudents = dao.getSchoolWithStudents("Kotlin School")

            val studentsOfSubject = dao.getStudentsOfSubject("How to use Google")

            val subjectsOfStudent = dao.getSubjectsOfStudent("Beff Jezos")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}