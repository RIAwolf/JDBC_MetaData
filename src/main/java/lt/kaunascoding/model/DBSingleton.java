package lt.kaunascoding.model;

import java.sql.*;

public class DBSingleton {

    public static final String DB_HOST_NAME = "192.168.100.100";
    public static final String DB_PORT = "3306";

    public static final String DB_NAME = "mysql";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";



    private static  DBSingleton instance = null;

    public static DBSingleton getInstance() {
        if(instance == null){
            instance = new DBSingleton();
        }
        return instance;
    }
    Connection connection=null;
    private DBSingleton(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection("jdbc:mysql://"+DB_HOST_NAME+":"+DB_PORT+"/"+DB_NAME, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printQueryResult(String query){
        Statement st = null;

        try {
            st=connection.createStatement();
            ResultSet resultSet= st.executeQuery(query);
            ResultSetMetaData metaData =resultSet.getMetaData();
            while(resultSet.next()) {
                String eilute = "";
                for (int j = 1; j <= metaData.getColumnCount(); j++) {
                    eilute += resultSet.getString(j)+" ";

                }
                System.out.println(eilute);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
