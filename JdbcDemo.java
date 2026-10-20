import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {

        // 1. Load the driver (the translator)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Connect to MySQL
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college",
            "root",
            "root"
        );

        // 3. Insert one student
        PreparedStatement ps = con.prepareStatement(
            "insert into student values(?,?,?)"
        );
        ps.setInt(1, 103);
        ps.setString(2, "Neha");
        ps.setString(3, "ECE");
        ps.executeUpdate();
        System.out.println("Record Inserted");

        // 4. Read all students
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from student");

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("name") + " " +
                rs.getString("branch")
            );
        }

        // 5. Close
        con.close();
    }
}