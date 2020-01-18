package pt.ipbeja.ip.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private String dbName;
    private Connection connection;
    private Statement statement;

    /**
     * This method is for establishing a database connection.
     *
     * @param dataBaseName name of the database
     */
    public DBConnection(String dataBaseName) {
        this.dbName = dataBaseName;
    }

    /**
     * This method is for connecting to the database
     *
     * @return if the connection was successful or unsuccessful
     */
    public boolean connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.dbName, "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * This method is for disconnect to the database
     *
     * @return if the disconnect was successful or unsuccessful
     */
    public boolean close() {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.err.println("Exception on close --" + e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Executes a SQL query and returns the result as a ResultSet
     * (http://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)
     *
     * @param query and SQL  query
     * @return the result of the query or null if no results
     */
    public ResultSet execute(final String query) {
        ResultSet result = null;
        if (this.connection != null) {
            try {
                this.statement = this.connection.createStatement();
                result = statement.executeQuery(query);
            } catch (Exception e) {
                System.err.println("Exception on execute --" + e.getClass().getName() + ": " + e.getMessage());
            }
        }
        return result;
    }

    /**
     * Executes a SQL query and returns the result as a List of Rows
     *
     * @param query and SQL  query
     * @return the result of the query or empty if no results
     */
    public List<row> select(final String query) {
        List<row> resultsList = new ArrayList<>();
        ResultSet result = this.execute(query);
        try {
            while (result.next()) {
                // creates empty Row object
                row row = new row();
                int nColumns = result.getMetaData().getColumnCount();
                for (int i = 1; i <= nColumns; i++) {
                    String element = result.getString(i);
                    // adds element to the row
                    row.add(element);
                }
                resultsList.add(row);
            }
        } catch (Exception e) {
            System.err.println("Exception on executeQuery --" + e.getClass().getName() + ": " + e.getMessage());
        } finally {
            return resultsList;
        }
    }

    /**
     *this method is for insert data
     * @param query and SQL  query
     * @return a query to execute
     */
    public boolean insert(String query) {
        return update(query);
    }

    /**
     *this method is for delete data
     * @param query and SQL  query
     * @return a query to execute
     */
    public boolean delete(String query) {
        return update(query);
    }

    /**
     *this method is for update the database
     * @param query and SQL  query
     * @return if the query are successful or not
     */
    private boolean update(String query) {
        try{
            this.statement = this.connection.createStatement();
            this.statement.executeUpdate(query);
        } catch (Exception e) {
            System.err.println("Exception on executeQuery --" +
                    e.getClass().getName() + ": " + e.getMessage());
            return false;
        }

        return true;
    }



}

