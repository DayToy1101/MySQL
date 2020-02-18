import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class BlogSystem {
    private static User currentUser;
    private static Connection connection;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/java13_20200214?useSSL=false",
                    "root",
                    "");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while(running){

            System.out.print("博客系统》");
            int select = scanner.nextInt();
            switch(select){
                case 1:registerUser();break;
                case 2:loginUser();break;
                default:running=false;
            }
        }
    }

    private static void loginUser() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要注册的用户名：");
        String username = scanner.nextLine();
        Statement statement = connection.createStatement();
        String sql = String.format("select id from users where username = '%s'",
                username);
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int id = resultSet.getInt(1);
        currentUser=new User(id,username);
        resultSet.close();
        statement.close();
        System.out.println("欢迎回来！");
        System.out.println(username);
        System.out.println(id);
    }

    private static void registerUser() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要注册的用户名：");
        String username = scanner.nextLine();
        Statement statement = connection.createStatement();
        String sql = String.format("insert into users(username) values ('%s')",username);
        try{
            statement.executeUpdate(sql);
            System.out.println("用户注册成功！");
        }catch(SQLException e){
            System.out.println("该用户名已被占用");
        }
        statement.close();
    }
}
