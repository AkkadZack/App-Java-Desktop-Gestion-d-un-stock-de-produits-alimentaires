package principale;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	public Connection connecter() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connexion= DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
	return connexion;	

	}
	public void deconnecter() throws ClassNotFoundException, SQLException {
		connecter().close();
	}
}
