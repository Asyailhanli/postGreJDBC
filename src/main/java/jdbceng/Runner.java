package jdbceng;

import java.sql.Connection;
import java.sql.Statement;

public class Runner {

    public static void main(String[] args) {
        //1.Step:Registration to the Driver
        //2.Step:Create connection with database
        JdbcUtils.connectToDatabase("localhost","postgres","postgres","Rçasya2134");

        //3.Step:Create statement
        JdbcUtils.createStatement();

        //4.Step:Execute  the query
        JdbcUtils.execute("CREATE TABLE workers( worker_id VARCHAR (10),worker_name VARCHAR (50),worker_salary INT)");


        //5.Step: Close the connection and statement
       JdbcUtils.closedConnectionAndStatement();


    }
}
