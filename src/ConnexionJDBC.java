import java.sql.*;

public class ConnexionJDBC {

	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String EN_TETE_MYSQL = "jdbc:postgresql://";
	private static final String SLASH = "/";
	
	//Information pour retrouver les fichier web.xml où il y a les infos de connexion
	
	
	private static String SERVEUR_BD = "dim.ec-nantes.fr";
	private static String NOM_BD = "marchandise_11";
	private static String UTILISATEUR_BD = "ei3info";
	private static String MDP_BD = "ei3info";	
	private static String CHAINE_CONNEXION = EN_TETE_MYSQL + SERVEUR_BD + SLASH + NOM_BD;	
	
	private Connection _connexion;
	
	private Boolean _estConnexionOuverte;
		
	private ResultSet _rs;
	
	
	public ConnexionJDBC() {
    	 _estConnexionOuverte = Boolean.FALSE;
    	
    	//Connexion
    	connecter();
	}	

    //Méthodes public
    public void connecter() {	
		if(Boolean.FALSE.equals(_estConnexionOuverte)){
	    	try{
				//Chargement du Driver
		    	Class.forName(DRIVER).newInstance();
		    
	    	   	//Création de la connexion
		    	_connexion = DriverManager.getConnection(CHAINE_CONNEXION, UTILISATEUR_BD, MDP_BD);
	    	}
	    	catch(Exception e){
	    		System.err.println(e.getMessage());
	    	}
	    	
	    	_estConnexionOuverte = Boolean.TRUE;
		}

    }
          
}
