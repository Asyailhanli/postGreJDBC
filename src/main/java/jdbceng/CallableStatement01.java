package jdbceng;

import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Rçasya2134");
        Statement st=con.createStatement();

        //1.Example : Create a function which uses 2 parameters and return the sum of the parameters
        //1.Step : Type code to create function
        String sql1="CREATE OR REPLACE FUNCTION additionF(x NUMERIC, y NUMERIC ) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN RETURN x+y ; END $$" ;

        //2.Step: Execute the function
        st.execute(sql1);

        //3.Step:Call the function
        CallableStatement cst1=con.prepareCall("{? = call additionF(?,?) }");

        //4.Step :Use registerOutParameter() method for  result for container, use set() method for parameters
        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,2);
        cst1.setInt(3,5);

        //5.Step : Use execute() method to get result for the specific values
        cst1.execute();

        //6.Step: To see the results on console use "sout"
        System.out.println(cst1.getObject(1));

        //Create function which calculates the volume of cone

        String sql2="CREATE OR REPLACE FUNCTION volumeOf(r NUMERIC, h NUMERIC ) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN RETURN 3.14*r*r*h/3 ; END $$" ;

        //2.Step: Execute the function
        st.execute(sql2);

        //3.Step:Call the function
        CallableStatement cst2=con.prepareCall("{? = call volumeOf(?,?) }");

        //4.Step :Use registerOutParameter() method for  result for container, use set() method for parameters
        cst2.registerOutParameter(1,Types.NUMERIC);
        cst2.setInt(2,1);
        cst2.setInt(3,2);

        //5.Step : Use execute() method to get result for the specific values
        cst2.execute();

        //6.Step: To see the results on console use "sout"
        System.out.printf("%.2" ,cst2.getObject(1));

        con.close();
        st.close();
        cst1.close();
        cst2.close();

    }
}
