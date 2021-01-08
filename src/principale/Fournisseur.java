package principale;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Fournisseur {
private int ID_FOURNISSEUR;
private String NOM_FOUNISSEUR;
private String TEL_FOURNISSEUR;
private String ADRESSE_FOURNISSEUR;
private Connexion con=new Connexion();

public Fournisseur(int iD_FOURNISSEUR, String nOM_FOUNISSEUR, String tEL_FOURNISSEUR, String aDRESSE_FOURNISSEUR) {
	
	ID_FOURNISSEUR = iD_FOURNISSEUR;
	NOM_FOUNISSEUR = nOM_FOUNISSEUR;
	TEL_FOURNISSEUR = tEL_FOURNISSEUR;
	ADRESSE_FOURNISSEUR = aDRESSE_FOURNISSEUR;
}
public Fournisseur() {

}
public int getID_FOURNISSEUR() {
	return ID_FOURNISSEUR;
}
public void setID_FOURNISSEUR(int iD_FOURNISSEUR) {
	ID_FOURNISSEUR = iD_FOURNISSEUR;
}
public String getNOM_FOUNISSEUR() {
	return NOM_FOUNISSEUR;
}
public void setNOM_FOUNISSEUR(String nOM_FOUNISSEUR) {
	NOM_FOUNISSEUR = nOM_FOUNISSEUR;
}
public String getTEL_FOURNISSEUR() {
	return TEL_FOURNISSEUR;
}
public void setTEL_FOURNISSEUR(String tEL_FOURNISSEUR) {
	TEL_FOURNISSEUR = tEL_FOURNISSEUR;
}
public String getADRESSE_FOURNISSEUR() {
	return ADRESSE_FOURNISSEUR;
}
public void setADRESSE_FOURNISSEUR(String aDRESSE_FOURNISSEUR) {
	ADRESSE_FOURNISSEUR = aDRESSE_FOURNISSEUR;
}

public ArrayList<Fournisseur> getallProvider() throws ArrayIndexOutOfBoundsException {
	
	ArrayList<Fournisseur> liste=new ArrayList<>();
	try {
	
	con.connecter();
	
	Statement state = con.connecter().createStatement();
	ResultSet result = state.executeQuery("SELECT * FROM java.fournisseur ");
	while(result.next()) {
		liste.add(new Fournisseur(result.getInt("ID_Fournisseur"),result.getString("NOM_FOURNISSEUR"),result.getString("TEL_FOURNISSEUR"),result.getString("ADRESSE_FOURNISSEUR")));
		
				
		
	}
	
	
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return liste;
}

public String [] getNameProviderTab(){
	Fournisseur f=new Fournisseur();
	String [] tab=new String[f.getallProvider().size()+1];
	tab[0]="--choisir le fournisseur--";
	try {
	ArrayList<Fournisseur> liste=f.getallProvider();
	
	for(int i=1;i<f.getallProvider().size()+1;i++) {
		{			
				
				tab[i]=liste.get(i-1).getNOM_FOUNISSEUR();
			
							
			}
	}
	}
	catch(Exception e) {
		
	}
	return tab;
}
public int getIDByNameFournisseur(String s)
{
	int i=0;
	Connexion con=new Connexion();
		try {	
			con.connecter();
			Statement state = con.connecter().createStatement();
			ResultSet result = state.executeQuery("SELECT ID_FOURNISSEUR FROM java.fournisseur WHERE NOM_FOURNISSEUR='"+s+"'");
			while(result.next()) {
				i=Integer.parseInt(result.getString(1));
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return i;
}
}
