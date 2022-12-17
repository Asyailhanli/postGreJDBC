import java.sql.Connection;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {

        //1. Adım: Driver'a kaydol
        //2. Adım: Database'e bağlan
        Connection connection=JdbcUtils.connectToDataBase("localhost","techproed","postgres","Rçasya2134");

        //3.Adim:Statement olustur
        Statement statement=JdbcUtils.createStatement();

        //4.Adim: Query calistir
      //JdbcUtils.execute("CREATE TABLE students (name VARCHAR (20), id int , address VARCHAR(80))");
        JdbcUtils.createTable("ABC","classes VARCHAR(20)","teacher_name VARCHAR(20)","id INT");

        //5.Adim:Baglanti ve Statement'i kapat
        JdbcUtils.closeConnectionAndStatement();




    }
}
