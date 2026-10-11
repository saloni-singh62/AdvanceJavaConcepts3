package in.strikes;

import in.strikes.model.Student;
import in.strikes.model.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.createStudent(new Student("Shikha" , "shikha34@gmail.com" , 22));

        //studentRepository.updateStudent();

        //studentRepository.deleteStudent();

        //studentRepository.getStudentById();
    }

}


