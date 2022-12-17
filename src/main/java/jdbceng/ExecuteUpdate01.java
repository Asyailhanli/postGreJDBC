package jdbceng;

import java.sql.*;

public class ExecuteUpdate01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Rçasya2134");
        Statement st=con.createStatement();

        //1.Example:Update the number of employees to 16000 if the number of employees is less than the average number of employees
        String sql1="UPDATE companies\n" +
                "SET number_of_employees =16000\n" +
                "WHERE number_of_employees<((SELECT AVG(number_of_employees)\n" +
                "\t\t\t\t\t\t\tFROM companies))";
        int numOfRecordsUpdated=st.executeUpdate(sql1);
        System.out.println("numOfRecordsUpdated = " + numOfRecordsUpdated);//2

        String sql2="SELECT*FROM companies";
        ResultSet resultset1=st.executeQuery(sql2);

        while(resultset1.next()){
            System.out.println(resultset1.getInt(1)+"--"+ resultset1.getString(2)+"--"+ resultset1.getInt(3));
        }

        con.close();
        st.close();


    }
}
