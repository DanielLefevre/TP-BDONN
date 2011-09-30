import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionJDBC {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String EN_TETE_MYSQL = "jdbc:postgresql://";
	private static final String SLASH = "/";

	private static String SERVEUR_BD = "dim.ec-nantes.fr";
	private static String NOM_BD = "marchandise_11";

	private static String UTILISATEUR_BD = "ei3info";
	private static String MDP_BD = "ei3info";

	private static String CONNECTION_STRING = EN_TETE_MYSQL + SERVEUR_BD
			+ SLASH + NOM_BD;

	private Connection connection;
	private boolean isConnected;

	// private ResultSet resultSet;
	/*Je fais une modif qui embête tout le monde*/

	public ConnexionJDBC:):):)() {
		// Connection
		connecter();
	}

	public boolean isConnected!!!!() {
		return isConnected;
	}

	public void connecter() {
		if (!this.isConnected) {
			try {
				// Loading driver
				Class.forName(DRIVER);

				// Connection creation
				this.connection = DriverManager.getConnection(
						CONNECTION_STRING, UTILISATEUR_BD, MDP_BD);

				this.isConnected = true;
			} catch (Exception erreur) {
				System.err.println(erreur.getMessage());
			}
		}

	}

}
