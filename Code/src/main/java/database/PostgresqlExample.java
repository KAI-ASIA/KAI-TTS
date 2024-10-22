package database;

import java.sql.*;

public class PostgresqlExample {

    // Thông tin kết nối cơ sở dữ liệu
    private static final String URL = "jdbc:postgresql://14.225.254.212:5432/KAI";
    private static final String USER = "for_test"; // Thay bằng tên người dùng
    private static final String PASSWORD = "for_test@2024"; // Thay bằng mật khẩu

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Tải driver PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Kết nối tới cơ sở dữ liệu
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Kiểm tra kết nối thành công
            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }

            // Tạo một câu lệnh SQL
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS customer_type (id BIGSERIAL, code VARCHAR(20), name VARCHAR(100))";
            statement.executeUpdate(sql);
            System.out.println("Table 'customer_type' created successfully!");

            String sqlInsert = "INSERT INTO customer_type value (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, "VIP");
            preparedStatement.setString(2, "KH vip");
            int res = preparedStatement.executeUpdate();
            System.out.println("insert user successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } finally {
            // Đóng kết nối sau khi sử dụng
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
