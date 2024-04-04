package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
        studentMap.put(student.getName(),student);
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
        teacherMap.put(teacher.getName(),teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
            if(teacherStudentMapping.containsKey(teacher)){
                List<String>studentList = teacherStudentMapping.get(teacher);
                studentList.add(student);
                teacherStudentMapping.put(teacher,studentList);
            }
            else{
                List<String>stringList = new ArrayList<>();
                stringList.add(student);
                teacherStudentMapping.put(teacher,stringList);
            }
            Teacher teacher1  = teacherMap.get(teacher);
            teacher1.setNumberOfStudents(teacher1.getNumberOfStudents()+1);
        }
    }

    public Student findStudent(String student){
        // your code goes here
        if(studentMap.containsKey(student)){
            return studentMap.get(student);
        }
        return null;
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
        if(teacherMap.containsKey(teacher)){
            return teacherMap.get(teacher);
        }
        return null;
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
        List<String>studentList = new ArrayList<>();
        if(teacherStudentMapping.containsKey(teacher)){
            studentList.addAll(teacherStudentMapping.get(teacher));
        }
        return studentList;
    }

    public List<String> findAllStudents(){
        // your code goes here
        List<String>studentList = new ArrayList<>();
        for(var e:studentMap.entrySet()){
            studentList.add(e.getKey());
        }
        return  studentList;
    }

    public void deleteTeacher(String teacher){
        // your code goes here
        for(String name :teacherStudentMapping.get(teacher)){
            studentMap.remove(name);
        }
        teacherMap.remove(teacher);
        teacherStudentMapping.remove(teacher);
    }

    public void deleteAllTeachers(){
        // your code goes here
        for(String name:teacherMap.keySet()){
            deleteTeacher(name);
            teacherMap.remove(name);
        }
    }
}