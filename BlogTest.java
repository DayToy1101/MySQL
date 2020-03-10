import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class Blog {
    private static int globalUserId = -1;
    private static String globalUsername = null;
    private static final String url ="jdbc:mysql://127.0.0.1:3306/java_0221?useSSL=false";
    private static final String name = "root";
    private static final String word = "";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Scanner scanner = new Scanner(System.in);
        while(true){
            menu();
            int select = scanner.nextInt();
            scanner.nextLine();//把行换走
            switch(select){
                case 1:register();break;
                case 2:login();break;
                case 3:publish();break;
            }
        }
    }

    private static void login() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        MysqlDataSource mysqldataSource = new MysqlDataSource();
        mysqldataSource.setServerName("127.0.0.1");
        mysqldataSource.setPort(3306);
        mysqldataSource.setUser("root");
        mysqldataSource.setPassword("");
        mysqldataSource.setDatabaseName("java_0221");
        mysqldataSource.setUseSSL(false);
        mysqldataSource.setCharacterEncoding("utf8");
        DataSource dataSource = mysqldataSource;
        try(Connection connection = dataSource.getConnection()){
        /*try (Connection connection = DriverManager.getConnection(url, name, word);) {
            /*try(Statement statement = connection.createStatement();){
                String sql = String.format("select id,username from users where username = '%s'and password = '%s'",username,password);
                System.out.println(sql);
                try(ResultSet resultSet = statement.executeQuery(sql)){
                    if(resultSet.next()==false){
                        System.out.println("登录失败");
                    }else{
                        int id = resultSet.getInt("id");
                        String usernameInTable = resultSet.getString("username");
                        System.out.println("登录成功"+id+","+usernameInTable);

                    }
                }*/
            String sql = "select id,username from users where username = ? and password = ?";
            try (PreparedStatement statement =connection.prepareStatement(sql)){
                //类似于ResultSet
                //适用于各种各样的类型
                //占位符下标从1开始
                statement.setString(1,username);
                statement.setString(2,password);
                try(ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next() == false) {
                        System.out.println("登录失败");
                    } else {
                        int id = resultSet.getInt("id");
                        String usernameInTable = resultSet.getString("username");
                        globalUserId=id;
                        globalUsername = usernameInTable;
                        System.out.println("登录成功" + id + "," + usernameInTable);
                    }
                }
            }
        }
    }

    private static void menu() {
        System.out.println("====================");
        System.out.println("===1、用户注册======");
        System.out.println("===2、用户登录======");
        System.out.println("===3、发表文章======");
        System.out.println("===4、文章列表页====");
        System.out.println("===5、文章详情页====");
        System.out.println("====================");
    }
    private static void publish() throws SQLException {
        if (globalUserId == -1) {
            System.out.println("请先登录！");
            return;
        }
        //需要用户输入标题和正文
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String content = scanner.nextLine();
        MysqlDataSource mysqldataSource = new MysqlDataSource();
        mysqldataSource.setServerName("127.0.0.1");
        mysqldataSource.setPort(3306);
        mysqldataSource.setUser("root");
        mysqldataSource.setPassword("");
        mysqldataSource.setDatabaseName("java_0221");
        mysqldataSource.setUseSSL(false);
        mysqldataSource.setCharacterEncoding("utf8");
        DataSource dataSource = mysqldataSource;
        String sql = "insert into articles(author_id,title,content) values(?,?,?)";
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, globalUserId);
                statement.setString(2, title);
                statement.setString(3, content);

                statement.executeUpdate();
            }
        }
    }

    private static void register() throws SQLException {
        //需要用户输入用户名和密码
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        //利用JDBC进行SQL运行
        //之前的方法
        /*Connection connection= DriverManager.getConnection(url,name,word);
        Statement statement = connection.createStatement();
        String sql = String.format("insert into users (username,password) values ('%s','%s')");
        System.out.println(sql);
        statement.executeUpdate(sql);
        statement.close();
        connection.close();*/
        //稍有变形
        try(Connection connection= DriverManager.getConnection(url,name,word);){
            try(Statement statement = connection.createStatement();){
                String sql = String.format("insert into users (username,password) values ('%s','%s')",username,password);
                System.out.println(sql);
                statement.executeUpdate(sql);
            }
        }
        System.out.println("用户注册成功！");
    }
}
