import java.sql.*;

public class Main {
    public static final String url="jdbc:mysql://127.0.0.1:3306/test?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT&user=root&password=123";
    public static Connection connection;
    public static Statement statement;

    public static void main(String[] args) {
        // 驱动程序名
        String driver="com.mysql.cj.jdbc.Driver";
        // url指向要访问的数据库名
        String url="jdbc:mysql://localhost:3306/test";
        // MySql配置时的用户名
        String user="root";
        // MySql配置时的密码
        String password="123";

        // 加载驱动程序、链接数据库
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,user,password);
            connection.setAutoCommit(false);
            statement=connection.createStatement();

            new Test().test();

            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
