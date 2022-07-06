package it.develhope.sql02.es;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;

        // Crating a table student in newdb
        try {

            String DB_URL = "jdbc:mysql://localhost:3306/newdb";
            String USER = "developer";
            String password = "Dev1";

            conn = DriverManager.getConnection(DB_URL, USER, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
              String sql = "CREATE TABLE students " + "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT, "+
                           "last_name VARCHAR(30), "+ "first_name VARCHAR(30),"+ "PRIMARY KEY (student_id)) ";
                Statement state = conn.createStatement();
                state.executeUpdate(sql);
                System.out.println("Creating table in a dtabase");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        //Popolate database students
        try {
            String DB_URL = "jdbc:mysql://localhost:3306/newdb";
            String USER = "developer";
            String password = "Dev1";

            conn = DriverManager.getConnection(DB_URL, USER, password);

            Statement state = conn.createStatement();
            String sql = "INSERT INTO `newdb`.`students`  (`last_name`, `first_name`) VALUES ('Bubbarello', 'Mariolone')";
            state.executeUpdate(sql);
            System.out.println("Creating student");
            String sql1 = "INSERT INTO `newdb`.`students` (`last_name`, `first_name`) VALUES ('Bianchi', 'Francesco')";
            state.executeUpdate(sql1);
            System.out.println("Creating student");
            String sql2 = "INSERT INTO `newdb`.`students` (`last_name`, `first_name`) VALUES ('Verdi', 'Marco')";
            state.executeUpdate(sql2);
            System.out.println("Creating student");
            String sql3 = "INSERT INTO `newdb`.`students` (`last_name`, `first_name`) VALUES ('Rossi', 'Valentina')";
            state.executeUpdate(sql3);
            System.out.println("Creating student");



        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

