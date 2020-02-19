import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://127.0.0.1:3306/java13_0219?useSSL=false&characterEncoding=utf8";
        Connection connection = (Connection) DriverManager.getConnection(
                url,"root",""
        );
        Statement statement = connection.createStatement();
        //String sql = "insert into users (id,name) values(1,'陈沛鑫')";
        //String sql = "update users set name = '高博' where id = 1";
        //statement.executeUpdate(sql);
        String sql = "select * from users";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString("name");
            System.out.println(id+","+name);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
