package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void  addStudent(Student student){

        studentRepository.saveStudent(student);
       // return "New student added succesfully";
    }

    public void addTeacher(Teacher teacher){

        studentRepository.saveTeacher(teacher);
        //return "New teacher added successfully";
    }

    public void createStudentTeacherPair(String student, String teacher){
        studentRepository.saveStudentTeacherPair(student, teacher);
       // return "New student-teacher pair added successfully";
    }

    public Student findStudent(String studentName){
      //  Student student =studentRepository.findStudent(studentName);
        return studentRepository.findStudent(studentName);
    }

    public Teacher findTeacher(String teacherName){
       // Teacher teacher = studentRepository.findTeacher(teacherName);
        return studentRepository.findTeacher(teacherName);
    }

    public List<String> findStudentsFromTeacher(String teacher){
       // List<String>list=studentRepository.findStudentsFromTeacher()
        return studentRepository.findStudentsFromTeacher(teacher);
    }

    public List<String> findAllStudents(){
      //  List<String> list=studentRepository.findAllStudents();
        return studentRepository.findAllStudents();

    }

    public void deleteTeacher(String teacher){

        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers(){

        studentRepository.deleteAllTeachers();
    }
}