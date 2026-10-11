package in.strikes.model;

import java.sql.*;

public class StudentRepository {

    String url = "jdbc:mysql://Localhost:3306/student_db";
    String username = "root";
    String password = "root";

    public void createStudent(Student student) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            //System.out.println("Database connected successfully");

            Statement statement = connection.createStatement();

            //String sql = "Insert INTO students(name , email , age)" +
                   // "VALUES('Shreya' , 'shreya123@gmail.com' , 28)";

            String sql = """
                    INSERT INTO students(name , email , age)
                    VALUES('%s' , '%s' , '%d')
                    """.formatted(student.getName() ,
                    student.getEmail() , student.getAge()); // from java 15,16

            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Create operation successfully");
            } else {
                System.out.println("Creation failed");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void updateStudent() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            //System.out.println("Database connected successfully");

            Statement statement = connection.createStatement();
            String sql = "UPDATE students SET age = 30" +  //faces the space problem
                    "WHERE id = 1";
            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Updated operation successfully");
            } else {
                System.out.println("Updation failed");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void deleteStudent() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            //System.out.println("Database connected successfully");

            Statement statement = connection.createStatement();
            String sql = "DELETE from students WHERE id = 3";
            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Deleted operation successfully");
            } else {
                System.out.println("Deletion failed");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void getStudentById() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT id , name , email , age" +
                    " FROM students where id = 4";

            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Student student = mapRow(resultSet);
            System.out.println(student);
            connection.close();
        } catch (Exception e) {
            System.out.println("Database connection failed");
            e.printStackTrace();

    }
}
    public void completeCRUD(){
        try{
            Connection connection = DriverManager.getConnection(url , username , password);
            Statement statement = connection.createStatement();
            String sql ="SELECT id , name , email ,age"
                    + "FROM students where id = 4";
            boolean result = statement.execute(sql); // returns boolean value
            if(result){
                ResultSet resultSet = statement.getResultSet();
            }
            else{
                int rowAffected = statement.getUpdateCount();
            }

            connection.close();
        }
        catch(SQLException e){
            System.out.println("Database Connection FAILED");
            e.printStackTrace();
        }
    }
    private Student mapRow(ResultSet resultset) throws SQLException {
        Student student = new Student();

        student.setId(resultset.getLong("id"));
        student.setName(resultset.getString("name"));
        student.setEmail(resultset.getString("email"));
        student.setAge(resultset.getInt("age"));
        return student;
    }
}
