package in.strikes;

import in.strikes.model.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.createUSer();

        //studentRepository.updateUser();

        //studentRepository.deleteUser();
    }

}


