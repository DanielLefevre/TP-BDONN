
public class Main
{
	public static void main(String[] args)
	{
		ConnexionJDBC maConnexion = new ConnexionJDBC();
		System.out.println(maConnexion.isConnected());
	}
}

