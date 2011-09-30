package TP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionJDBC
{
    private static final String DRIVER            = "org.postgresql.Driver";
    private static final String EN_TETE_MYSQL     = "jdbc:postgresql://";
    private static final String SLASH             = "/";

    private static String       SERVEUR_BD        = "dim.ec-nantes.fr";
    private static String       NOM_BD            = "marchandise_11";

    private static String       UTILISATEUR_BD    = "ei3info";
    private static String       MDP_BD            = "ei3info";

    private static String       CONNECTION_STRING = EN_TETE_MYSQL + SERVEUR_BD
                                                          + SLASH + NOM_BD;

    private Connection          connection;
    private boolean             isConnected;
    private Statement           statement;

    /**
     * Constructor. This constructor connects to the base.
     */
    public ConnectionJDBC()
    {
        this.connect();
    }

    /**
     * Getter.
     * @return true if connected, false otherwise
     */
    public boolean isConnected()
    {
        return this.isConnected;
    }

    /**
	 * 
	 */
    public void connect()
    {
        if (!this.isConnected)
        {
            try
            {
                // Loading driver
                Class.forName(DRIVER);

                // Connection creation
                this.connection = DriverManager.getConnection(
                        CONNECTION_STRING, UTILISATEUR_BD, MDP_BD);

                this.statement = this.createStatement();

                this.isConnected = true;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void close()
    {
        try
        {
            this.statement.close();
            this.connection.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
            this.isConnected = false;
        }
    }

    public Statement createStatement()
    {
        try
        {
            return this.connection.createStatement();
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void closeStatement()
    {
        try
        {
            this.statement.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ResultSet query(String query)
    {
        try
        {
            return this.statement.executeQuery(query);
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void queryOther(String query)
    {
        try
        {
            this.statement.executeUpdate(query);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
