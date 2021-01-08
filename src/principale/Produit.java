package principale;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Produit {
	private int ID_ARTICLE;
	private String MARQUE;
	private String NOM_PRODUIT;
	private double PRIX_VENTE;
	private int QTE_DEPOT;
	private int QTE_RAYON;
	private Connexion con=new Connexion();
	public int getID_ARTICLE() {
		return ID_ARTICLE;
	}
	public Produit(int iD_ARTICLE, String mARQUE, String nOM_PRODUIT, double pRIX_VENTE, int qTE_DEPOT, int qTE_RAYON) {
	
		ID_ARTICLE = iD_ARTICLE;
		MARQUE = mARQUE;
		NOM_PRODUIT = nOM_PRODUIT;
		PRIX_VENTE = pRIX_VENTE;
		QTE_DEPOT = qTE_DEPOT;
		QTE_RAYON = qTE_RAYON;
	}
	public Produit() {

	}
	public void setID_ARTICLE(int iD_ARTICLE) {
		ID_ARTICLE = iD_ARTICLE;
	}
	public String getMARQUE() {
		return MARQUE;
	}
	public void setMARQUE(String mARQUE) {
		MARQUE = mARQUE;
	}
	public String getNOM_PRODUIT() {
		return NOM_PRODUIT;
	}
	public void setNOM_PRODUIT(String nOM_PRODUIT) {
		NOM_PRODUIT = nOM_PRODUIT;
	}

	public double getPRIX_VENTE() {
		return PRIX_VENTE;
	}
	public void setPRIX_VENTE(double pRIX_VENTE) {
		PRIX_VENTE = pRIX_VENTE;
	}
	public int getQTE_DEPOT() {
		return QTE_DEPOT;
	}
	public void setQTE_DEPOT(int qTE_DEPOT) {
		QTE_DEPOT = qTE_DEPOT;
	}
	public int getQTE_RAYON() {
		return QTE_RAYON;
	}
	public void setQTE_RAYON(int qTE_RAYON) {
		QTE_RAYON = qTE_RAYON;
	}
	public ArrayList<Produit> getallProduct(int idRayon) throws ArrayIndexOutOfBoundsException {
		
		ArrayList<Produit> liste=new ArrayList<>();
		try {
		
		
		
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT * FROM java.produit where ID_RAYON="+idRayon+" ");
		while(result.next()) {
			liste.add(new Produit(result.getInt("ID_ARTICLE"),result.getString("MARQUE"),result.getString("NOM_PRODUIT")
			
					,result.getFloat("PRIX_VENTE"),result.getInt("QTE_DEPOT"),result.getInt("QTE_RAYON")));
			
		}
	
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return liste;
	}
	
	public String [] getNameProductTab(int idRayon){
		Produit u=new Produit();
		String [] tab=new String[u.getallProduct(idRayon).size()+1];
		tab[0]="--choisir le produit--";
		try {
		ArrayList<Produit> liste=u.getallProduct(idRayon);
		
		for(int i=1;i<u.getallProduct(idRayon).size()+1;i++) {
			{			
					
					tab[i]=liste.get(i-1).getNOM_PRODUIT();
				
								
				}
		}
		}
		catch(Exception e) {
			
		}
		return tab;
	}
	public int getIDByNameProduit(String s)
	{
		int i=0;
		Connexion con=new Connexion();
			try {	
				con.connecter();
				Statement state = con.connecter().createStatement();
				ResultSet result = state.executeQuery("SELECT ID_ARTICLE FROM java.produit WHERE NOM_PRODUIT='"+s+"'");
				while(result.next()) {
					i=Integer.parseInt(result.getString(1));
				}
			}
			catch(Exception e) {e.printStackTrace();}
			return i;
	}

}
