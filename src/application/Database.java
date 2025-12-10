package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static final Logger logger = Logger.getLogger(Database.class.getName());
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/finalExam";
    private static final String DB_USER = Dotenv.get("DB_USER", "");
    private static final String DB_PASSWORD = Dotenv.get("DB_PASSWORD", "");

    private Database() {

    }

    // Establish Database Connection
    public static Connection getDBConnection() throws SQLException {
        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        }

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        }

        return connection;
    }

    // Save Applicant to Database
    public static boolean saveApplicant(Applicant app) {
        String sql = "INSERT INTO applicant " +
                "(fullName, address, phone, email, education, gender, " +
                " startDate, position, salary, legal, relative, relativeExplanation) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = getDBConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, app.getFullName());            
            ps.setString(2, app.getAddress());              
            ps.setString(3, app.getPhone());                  
            ps.setString(4, app.getEmail());               
            ps.setString(5, app.getEducation());          
            ps.setString(6, app.getGender());             
            ps.setString(7, app.getStartDate());          
            ps.setString(8, app.getPosition());           
            ps.setString(9, app.getSalary());                 
            ps.setString(10, app.getLegal());              
            ps.setString(11, app.getRelative());           
            ps.setString(12, app.getRelativeExplanation()); 

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Failed to save applicant: " + ex.getMessage(), ex);
            return false;
        }
    }
}