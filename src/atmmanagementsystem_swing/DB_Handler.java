/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmmanagementsystem_swing;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_Handler {
    private static final String JDBC_URL = "jdbc:oracle:thin:@127.0.0.1:1521/xe";    
    private static final String USERNAME = "system";
    private static final String PASSWORD = "system";


public static void createAccount(String accountHolder, String accountType, String phoneNumber, String accountNo, String address,
                                 String dob, String email, String gender, String citizenship, String pin, boolean termsAndCondition) {
    SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    
    try {
        // Parse the date string using the input format
        Date dateOfBirth = inputFormat.parse(dob);

        // Format the parsed date into the desired output format
        String formattedDOB = outputFormat.format(dateOfBirth);

        // Establish database connection
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

        // Define SQL statement for account creation
        String sql = "INSERT INTO accounts (account_holder, account_type, phone_number, account_no, address, email, gender, citizenship, pin, terms_and_condition, dob) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'))";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, accountHolder);
            preparedStatement.setString(2, accountType);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, accountNo);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, gender);
            preparedStatement.setString(8, citizenship);
            preparedStatement.setString(9, pin);
            preparedStatement.setBoolean(10, termsAndCondition);
            preparedStatement.setString(11, formattedDOB);

            // Execute the SQL statement to insert account data
            preparedStatement.executeUpdate();

            // Show success message
            JOptionPane.showMessageDialog(null, "Account created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (ParseException e) {
        // Handle parsing error
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Invalid date of birth format.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException | HeadlessException | ClassNotFoundException e) {
        // Handle database and other errors
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to create account. Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    
    
    
       // Method to fetch PIN from the database
    public static String fetchPinFromDatabase(String accountNumber) {
        String encryptedPin = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Prepare SQL statement to fetch PIN
            String sql = "SELECT PIN FROM ACCOUNTS WHERE ACCOUNT_NO = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountNumber);
            rs = stmt.executeQuery();

            // Check if account number exists
            if (rs.next()) {
                // Fetch encrypted PIN from result set
                encryptedPin = rs.getString("PIN");
            } else {
                JOptionPane.showMessageDialog(null, "Account number not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Failed to create account. Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database error:Connection Not closed:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return encryptedPin;
    }

    
    
    

    public static boolean updatePinInDatabase(String accountNumber, String newEncryptedPin) {
        boolean success = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection to the database
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Prepare SQL statement to update PIN
            String updatePinSql = "UPDATE ACCOUNTS SET PIN = ? WHERE ACCOUNT_NO = ?";
            pstmt = conn.prepareStatement(updatePinSql);
            pstmt.setString(1, newEncryptedPin);
            pstmt.setString(2, accountNumber);

            // Execute the update statement
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                success = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Oracle JDBC Driver not found.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close resources in finally block
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database error: Connection not closed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return success;
    }

    
    

    
    
 public static ResultSet getAllTransactions(String accountNo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
             Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String sql = "SELECT transaction_date, description, withdrawal, deposit, available_balance " +
                         "FROM transactions " +
                         "WHERE account_no = ?" +
                         "ORDER BY transaction_date DESC";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountNo);

            rs = stmt.executeQuery();
            return rs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex; // Propagate the SQLException to the caller
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
 
 
 
 
public static void saveTransaction(String accountNo, double amount, String description) {
    // Define SQL statement for inserting a new transaction
    String insertSql = "INSERT INTO transactions (account_no, transaction_date, description, deposit, withdrawal, available_balance) " +
                       "VALUES (?, CURRENT_TIMESTAMP, ?, ?, ?, ?)";

    // Determine deposit or withdrawal amount based on description
    double depositAmount = 0.0;
    double withdrawalAmount = 0.0;

    if (description.equalsIgnoreCase("Deposit")) {
        depositAmount = amount;
    } else if (description.equalsIgnoreCase("Withdrawl") || description.equalsIgnoreCase("FastCash")) {
        withdrawalAmount = amount;
    } else {
        // Invalid transaction description
        JOptionPane.showMessageDialog(null, "Invalid transaction description.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit method if the description is invalid
    }

    try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(insertSql)) {

        // Set parameters for the prepared statement
        stmt.setString(1, accountNo);
        stmt.setString(2, description);
        stmt.setDouble(3, depositAmount);
        stmt.setDouble(4, withdrawalAmount);
        stmt.setDouble(5, getCurrentBalance(accountNo));

        // Execute the SQL statement to insert the new transaction
        stmt.executeUpdate();

        // Show a success message dialog
        JOptionPane.showMessageDialog(null, "Transaction recorded successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException ex) {
        // Show an error message dialog and log the exception
        JOptionPane.showMessageDialog(null, "Error recording transaction: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace(); // Log the exception for debugging
    }
}




public static boolean updateBalanceAfterWithdrawal(String accountNo, double amountToWithdraw) {
   if(amountToWithdraw>getCurrentBalance(accountNo)){
       JOptionPane.showMessageDialog(null, "Insufficient Balance");
       return false;
   }
    boolean success = false;
    Connection conn = null;
    PreparedStatement stmt = null;
    
    try {
        // Load Oracle JDBC driver (optional if already done elsewhere in your application)
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Establish database connection
        conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

        // Prepare SQL statement to update balance
        String updateSql = "UPDATE balance SET amount = amount - ? WHERE account_no = ?";
        stmt = conn.prepareStatement(updateSql);

        // Set parameters for the prepared statement
        stmt.setDouble(1, amountToWithdraw);
        stmt.setString(2, accountNo);

        // Execute the update statement
        int rowsAffected = stmt.executeUpdate();

        // Check if update was successful
        if (rowsAffected > 0) {
             success = true;
            
                   
        } else {
            JOptionPane.showMessageDialog(null, "Failed to withdraw amount from balance.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Oracle JDBC driver not found: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace(); // Print stack trace for debugging
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error updating balance: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace(); // Print stack trace for debugging
    } finally {
        // Close resources in the finally block to release them
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log or handle the exception as needed
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log or handle the exception as needed
            }
        }
        
    }
    return success;
}


  

    public static boolean updateBalanceAfterDeposit(String accountNumber, double amount) {
        boolean success = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection to the database
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Check if the account exists in the BALANCE table
            String checkBalanceSql = "SELECT AMOUNT FROM BALANCE WHERE ACCOUNT_NO = ?";
            pstmt = conn.prepareStatement(checkBalanceSql);
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Account exists in BALANCE table, update the existing amount
                double currentBalance = rs.getDouble("AMOUNT");
                double updatedBalance = currentBalance + amount;

                String updateBalanceSql = "UPDATE BALANCE SET AMOUNT = ? WHERE ACCOUNT_NO = ?";
                pstmt = conn.prepareStatement(updateBalanceSql);
                pstmt.setDouble(1, updatedBalance);
                pstmt.setString(2, accountNumber);

                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {
                    success = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update balance. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Account does not exist in BALANCE table, insert a new record
                String insertBalanceSql = "INSERT INTO BALANCE (ACCOUNT_NO, AMOUNT) VALUES (?, ?)";
                pstmt = conn.prepareStatement(insertBalanceSql);
                pstmt.setString(1, accountNumber);
                pstmt.setDouble(2, amount);

                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    success = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to insert new balance. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Oracle JDBC Driver not found.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database error: Connection not closed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return success;
    }
    

    // Validate account existence
    public static boolean validateAccount(String accountNumber) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Load Oracle JDBC driver
            try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE account_no = ?")) {
                stmt.setString(1, accountNumber);
                try (ResultSet rs = stmt.executeQuery()) {
                    return rs.next(); // Account found if ResultSet has a next row
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            showErrorDialog("Error validating account: " + ex.getMessage());
            return false;
        }
    }

    
    
    
    
    
    // Get account holder name
    public static String getAccountHolder(String accountNumber) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Load Oracle JDBC driver
            try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("SELECT account_holder FROM accounts WHERE account_no = ?")) {
                stmt.setString(1, accountNumber);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("account_holder");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            showErrorDialog("Error retrieving account holder: " + ex.getMessage());
        }
        return null;
    }

    // Get current balance of the account
    public static double getCurrentBalance(String accountNumber) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Load Oracle JDBC driver
            try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("SELECT amount FROM balance WHERE account_no = ?")) {
                stmt.setString(1, accountNumber);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getDouble("amount");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            showErrorDialog("Error retrieving current balance: " + ex.getMessage());
        }
        return 0.0; // Default balance if not found or error occurs
    }

    
    
    
    
   // Record transaction
public static void recordTransaction(String accountNumber, double amount, String description) {
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver"); // Load Oracle JDBC driver
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                 "INSERT INTO transactions (account_no, transaction_date, description, withdrawal, deposit, available_balance) " +
                 "VALUES (?, CURRENT_TIMESTAMP, ?, ?, ?, ?)"
             )) {
            stmt.setString(1, accountNumber);
            stmt.setString(2, description);

            if (description.equalsIgnoreCase("Transfer Sent")) {
                // Set withdrawal amount as transfer amount
                stmt.setDouble(3, Math.max(amount, 0));
                stmt.setDouble(4, 0); // Set deposit amount to 0
            } else if (description.equalsIgnoreCase("Transfer Received")) {
                // Set deposit amount as transfer amount
                stmt.setDouble(3, 0); // Set withdrawal amount to 0
                stmt.setDouble(4, Math.max(amount, 0));
            } else {
                JOptionPane.showMessageDialog(null, "Transfer Description Problem");
            }

            stmt.setDouble(5, getCurrentBalance(accountNumber)); // Set available balance
            stmt.executeUpdate();
        }
    } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace();
        showErrorDialog("Error recording transaction: " + ex.getMessage());
    }
}


    // Helper method to display error message dialog
    private static void showErrorDialog(String message) {
        javax.swing.JOptionPane.showMessageDialog(null, message, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    
    
    


public static AccountInfoData getAccountInfo(String accountNumber) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    AccountInfoData accountInfo = null;

    try {
        conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        String query = "SELECT * FROM accounts WHERE account_no = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, accountNumber);
        rs = stmt.executeQuery();

        if (rs.next()) {
            // Retrieve fields from ResultSet
            String accountNo = rs.getString("account_no");
            String holderName = rs.getString("account_holder");
            String accountType = rs.getString("account_type");
            String address = rs.getString("address");
            String email = rs.getString("email");
            String phoneNumber = rs.getString("phone_number");
            String citizenship = rs.getString("citizenship");
            String gender = rs.getString("gender");

            // Retrieve date of birth as java.sql.Timestamp
            java.sql.Timestamp dobTimestamp = rs.getTimestamp("dob");
            String dobString = (dobTimestamp != null) ? dobTimestamp.toString() : null;

            accountInfo = new AccountInfoData(accountNo, holderName, accountType,
                                               phoneNumber, address, email,
                                               citizenship, dobString, gender);
        } else {
            // Display error message if account is not found
            JOptionPane.showMessageDialog(null, "Account not found for account number: " + accountNumber,
                                          "Account Not Found", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving account information: " + e.getMessage(),
                                      "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    return accountInfo;
}

    
}


