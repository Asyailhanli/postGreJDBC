import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {

        //1.Adim:Driver'a kaydol
       Class.forName("org.postgresql.Driver");

       //2.Adim:DataBase'e baglan
       Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Rçasya2134");

       //3.Adim:Statement olustur
       Statement st = con.createStatement();

       //4.Adim:Query calistir

        /*
         Execute() method'u DDL(create,drop,alter table) ve DQL(select) icin kullanilabilir.
         1)Eger execute() method'u DDL icin kullanilirsa 'false' return yapar
         2)Eger execute() method'u DQL icin kullanilirsa ResultSet alindiginda 'true' aksi halde ' false' verir
         */

       // 1.Örnek: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.

        boolean sql1=st.execute("CREATE TABLE workers(worker_id VARCHAR(20),worker_name VARCHAR(20),worker_salary INT)");
        System.out.println("sql1 = " + sql1);//false return eder cunku data cagirmiyoruz

        //2.Ornek:Table'a worker_address sutunu ekleyerek alter yapin
        String sql2="ALTER TABLE workers ADD worker_address VARCHAR(80)";
        boolean sqlb=st.execute(sql2);
        System.out.println("sqlb = " + sqlb);


        //3.Ornek:workers table'ini silin
        String sql3="DROP TABLE workers";
        boolean sql3b=st.execute(sql3);
        System.out.println("sql3b = " + sql3b);

        //5.Adim:Baglanti ve Statement'i kapat
        con.close();
        st.close();




    }
}
