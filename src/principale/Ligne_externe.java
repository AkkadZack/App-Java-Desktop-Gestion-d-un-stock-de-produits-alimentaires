package principale;

import java.sql.SQLException;
import java.sql.Statement;

public class Ligne_externe {
private int ID_LIGNE_EX;
private int ID_CMD_EX;
private int ID_ARTICLE;
private int QT_PRODUIT;
private int ID_FOURNISSEUR;
private Connexion con=new Connexion();
public Ligne_externe(int iD_LIGNE_EX, int iD_CMD_EX, int iD_ARTICLE, int qT_PRODUIT, int iD_FOURNISSEUR) {
	
	ID_LIGNE_EX = iD_LIGNE_EX;
	ID_CMD_EX = iD_CMD_EX;
	ID_ARTICLE = iD_ARTICLE;
	QT_PRODUIT = qT_PRODUIT;
	ID_FOURNISSEUR = iD_FOURNISSEUR;
	
}
public Ligne_externe() {
try {
	con.connecter();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public int getID_LIGNE_EX() {
	return ID_LIGNE_EX;
}
public void setID_LIGNE_EX(int iD_LIGNE_EX) {
	ID_LIGNE_EX = iD_LIGNE_EX;
}
public int getID_CMD_EX() {
	return ID_CMD_EX;
}
public void setID_CMD_EX(int iD_CMD_EX) {
	ID_CMD_EX = iD_CMD_EX;
}
public int getID_ARTICLE() {
	return ID_ARTICLE;
}
public void setID_ARTICLE(int iD_ARTICLE) {
	ID_ARTICLE = iD_ARTICLE;
}

public int getQT_PRODUIT() {
	return QT_PRODUIT;
}
public void setQT_PRODUIT(int qT_PRODUIT) {
	QT_PRODUIT = qT_PRODUIT;
}
public int getID_FOURNISSEUR() {
	return ID_FOURNISSEUR;
}
public void setID_FOURNISSEUR(int iD_FOURNISSEUR) {
	ID_FOURNISSEUR = iD_FOURNISSEUR;
}
public void setLigneCmd(int ID_CMD,int ID_ARTICLE,int QTE,int fournisseur) {
	
		try{
		
		Statement state = con.connecter().createStatement();
	int rs = state.executeUpdate("insert into java.ligne_externe(ID_CMD_EX,ID_ARTICLE,QT_PRODUIT,ID_FOURNISSEUR) VALUES ('"+ID_CMD+"','"+ID_ARTICLE+"','"+QTE+"','"+fournisseur+"')");
	con.deconnecter();
		}
		catch(Exception e) {
			System.out.println(e.getMessage()+" DB");

		}
		
	
}
}
