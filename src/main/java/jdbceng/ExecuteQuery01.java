package jdbceng;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.Step:Registration to the Driver
        Class.forName("org.postgresql.Driver");

        //2.Step:Create connection with database
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Rçasya2134");

        //3.Step:Create statement
        Statement st=con.createStatement();

        //1.Example : Select the country names whose region id's are 1
        String sql1="SELECT country_name FROM countries where region_id=1";
        //If you use execute() method, you will get true or false as return .But i want to see the records
        boolean result1=st.execute(sql1);
        System.out.println("result1 = " + result1);

        //To see records we have another method which is "executeQuery()"

        ResultSet resultSet1=st.executeQuery(sql1);

        while (resultSet1.next()){
            System.out.println(resultSet1.getString("country_name"));
        }

        //2.Example :Select the country_id and country_name whose region_id's are greater than 2
        String sql2="SELECT country_id, country_name FROM countries WHERE region_id >2";
        ResultSet resultSet2=st.executeQuery(sql2);
         while(resultSet2.next()){
             System.out.println(resultSet2.getString(1)+ "--"+ resultSet2.getString(2));
         }

         //3.Example: Select the company whose number_of_employees is the lowest from companies table
        String sql3="SELECT company FROM companies WHERE number_of_employees =(SELECT MIN(number_of_employees) FROM companies)";
         ResultSet resultSet3=st.executeQuery(sql3);
         while(resultSet3.next()){
             System.out.println(resultSet3.getString("company"));
         }
        //4.Example: Select all rows  whose number_of_employees is the lowest from companies table
        String sql4="SELECT * FROM companies WHERE number_of_employees =(SELECT MIN(number_of_employees) FROM companies)";
         ResultSet resultSet4=st.executeQuery(sql4);
         while(resultSet4.next()){
             System.out.println(resultSet4.getInt(1)+ ">>"+resultSet4.getString(2)+">>"+resultSet4.getInt(3));

         }

         con.close();
         st.close();



    }
}
