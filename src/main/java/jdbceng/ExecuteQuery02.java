package jdbceng;

import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Rçasya2134");
        Statement st=con.createStatement();

        //1.Example: Find the company and number_of_employees whose number_of_employees is the second highest from the companies table
        //1.way: by using OFFSET and LIMIT
        String sql1="SELECT company,number_of_employees FROM companies ORDER BY number_of_employees DESC OFFSET 1 LIMIT 1";
        ResultSet resultSet1= st.executeQuery(sql1);

        while(resultSet1.next()){

            System.out.println(resultSet1.getString(1)+">>"+resultSet1.getInt(2));
        }
        System.out.println("********");
        //2.WAY:BY using Subquery

        String sql2="SELECT company,number_of_employees \n" +
                "FROM companies\n" +
                "WHERE number_of_employees =(SELECT MAX(number_of_employees) \n" +
                "\t\t\t\t\t\t\tFROM companies\n" +
                "                            WHERE number_of_employees <(SELECT MAX(number_of_employees) \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tFROM companies))\n";
        ResultSet resultSet2=st.executeQuery(sql2);
        while(resultSet2.next()){
            System.out.println(resultSet2.getString("company")+ ">>"+ resultSet2.getInt("number_of_employees"));
        }

        //2.Example:Find the company names and number of employees whose number of employees is less than the average number of employees
        String sql3="SELECT company,number_of_employees\n" +
                "FROM companies\n" +
                "WHERE  number_of_employees  <(SELECT AVG(number_of_employees) FROM companies)\n" +
                "\n";
        ResultSet resultSet3=st.executeQuery(sql3);

        while(resultSet3.next()){
            System.out.println(resultSet3.getString("company")+"--"+resultSet3.getInt("number_of_employees"));
        }







    }
}
