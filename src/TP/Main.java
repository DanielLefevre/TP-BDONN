package TP;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        ConnectionJDBC myConnection = new ConnectionJDBC();
        System.out.println("The connection is open : "
                + myConnection.isConnected());

        Main.query(myConnection);

    }

    public static void query(ConnectionJDBC myConnection) throws SQLException
    {
        ResultSet resultSet = myConnection
                .query("SELECT * FROM typemarchandise");

        while (resultSet.next())
        {
            System.out.println(resultSet.getString(1) + " "
                    + resultSet.getString(2));
        }

        myConnection.queryOther("DELETE ALL");

        myConnection.close();
    }
}
