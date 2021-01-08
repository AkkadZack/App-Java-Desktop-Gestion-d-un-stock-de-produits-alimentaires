package principale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Rayon {
private int ID_RAYON;
private int CAPACITE;
private String NOM_RAYON;
private Connexion con=new Connexion();
public int getID_RAYON() {
	return ID_RAYON;
}
public void setID_RAYON(int iD_RAYON) {
	ID_RAYON = iD_RAYON;
}
public int getCAPACITE() {
	return CAPACITE;
}
public void setCAPACITE(int cAPACITE) {
	CAPACITE = cAPACITE;
}
public String getNOM_RAYON() {
	return NOM_RAYON;
}
public void setNOM_RAYON(String nOM_RAYON) {
	NOM_RAYON = nOM_RAYON;
}
public Rayon(int iD_RAYON, int cAPACITE, String nOM_RAYON) {
	super();
	ID_RAYON = iD_RAYON;
	CAPACITE = cAPACITE;
	NOM_RAYON = nOM_RAYON;
}
public Rayon() {

}
public String getNameByIdDB(int id) {
	String res="";
	try {

		
		
	Statement state = con.connecter().createStatement();
	
	ResultSet result = state.executeQuery("SELECT * FROM java.rayon where ID_RAYON='"+id+"' ");
	while(result.next()) {
		res=result.getString("NOM_RAYON");
	}
	
	con.deconnecter();
	}
	catch(Exception e) {
		
	}
	return res;
}
public String[] getAllRayons() {
	String [] re=new String[11];
	re[0]="--choisir le rayon--";
try {
		
		int a=1;
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT NOM_RAYON FROM java.rayon");
		while(result.next())  {
		re[a]=result.getString(1);
		a++;
		
		}
}
catch(Exception e) {
	e.getMessage();
}
		return re;
	}
}

