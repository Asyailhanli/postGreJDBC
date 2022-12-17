package jdbceng;

import java.sql.*;


public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.Step:Registration to the Driver
        Class.forName("org.postgresql.Driver");

        //2.Step:Create connection with database
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Rçasya2134");

        //3.Step:Create statement
        Statement st=con.createStatement();

        //4.Step:Execute  the query
        /*
          execute() method can be used in DDL(table creation,drop table, alter table) and DQL(select table)
          1)If you use execute() method in DDL you will get false everytime because will not call data
          2)If you use execute() method in DQL you will gel  false and true
            When you use execute() method in DQL , If you get ResultSet Object as return you will get true
            otherwise you will get false
         */

        //1.Example: Create a workers table with the columns workerd_id,worker_name,worker_salary
        //CREATE TABLE workers( worker_id VARCHAR (10),worker_name VARCHAR (50),worker_salary INT);
        //SELECT*FROM workers;
        String sql1="CREATE TABLE workers( worker_id VARCHAR (10),worker_name VARCHAR (50),worker_salary INT)";
        boolean sqlResult=st.execute(sql1);
        System.out.println(sqlResult);//false

        //2.Example : Alter the table by adding worker_addree column into the workers table
        //ALTER TABLE workers ADD COLUMN worker_address VARCHAR (80);
        String sql2="ALTER TABLE workers ADD COLUMN worker_address VARCHAR (80)";
        st.execute(sql2);

        //3.Example : Drop the  table
        //DROP TABLE workers;
        String sql3="DROP TABLE workers";
        st.execute(sql3);

        //5.Step: Close the connection and statement
        con.close();
        st.close();



    }
}
