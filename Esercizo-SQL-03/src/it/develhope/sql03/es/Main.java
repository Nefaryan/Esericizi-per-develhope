package it.develhope.sql03.es;

import java.sql.*;
import java.util.Arrays;

public class Main {

    final static String DB_URL = "jdbc:mysql://localhost:3306/newdb";
    final static String USER = "developer";
    final static String PASSWORD = "Dev1";
    //String for research surname in DB
    static final String selectQuery = "SELECT ALL last_name FROM newdb.students";

    public static void main(String[] args) {
         try{
             //Connection to database
             Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
             Statement state = connection.createStatement();
             ResultSet rs = state.executeQuery(selectQuery);

             while(rs.next()){

                //print the names on screen while executing the query
                 String surname = rs.getString("last_name");
                 System.out.println("Surname: "+ surname);
                 //assign the surnames to an ArrayList called surnames
                 String[] surnameArray = new String[]{surname};
                 //once the query is completed, print all the surnames
                 System.out.println(Arrays.toString(surnameArray));

             }


         }catch (SQLException e){
             e.printStackTrace();
         }
    }


}
