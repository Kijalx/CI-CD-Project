package Connection;
import java.sql.*;

class MysqlCon {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/workers?characterEncoding=utf8", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idName\n" +"FROM `workers`.`data`;");

            while (rs.next()) {
                System.out.println(rs.getString(1));

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
