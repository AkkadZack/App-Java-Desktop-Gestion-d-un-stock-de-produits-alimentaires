package principale;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Cmd_externe {
	private int ID_CMD_EX;
	private int ID_CHEF;
	private Date DATE_LIVRAISON;
	private Date DATE_CMD_EX;
	private Connexion con=new Connexion();
	public int getID_CMD_EX() {
		return ID_CMD_EX;
	}
	public Cmd_externe(int iD_CMD_EX, int iD_CHEF, Date dATE_LIVRAISON, Date dATE_CMD_EX) {
	
		ID_CMD_EX = iD_CMD_EX;
		ID_CHEF = iD_CHEF;
		DATE_LIVRAISON = dATE_LIVRAISON;
		DATE_CMD_EX = dATE_CMD_EX;

	}
	public Cmd_externe() {

	}
	public void setID_CMD_EX(int iD_CMD_EX) {
		ID_CMD_EX = iD_CMD_EX;
	}
	public int getID_CHEF() {
		return ID_CHEF;
	}
	public void setID_CHEF(int iD_CHEF) {
		ID_CHEF = iD_CHEF;
	}

	public Date getDATE_LIVRAISON() {
		return DATE_LIVRAISON;
	}
	public void setDATE_LIVRAISON(Date dATE_LIVRAISON) {
		DATE_LIVRAISON = dATE_LIVRAISON;
	}
	public Date getDATE_CMD_EX() {
		return DATE_CMD_EX;
	}
	public void setDATE_CMD_EX(Date dATE_CMD_EX) {
		DATE_CMD_EX = dATE_CMD_EX;
	}
	public void setCmd(int chef) {
		String format = "yy/MM/dd H:mm:ss";

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
		java.util.Date date = new java.util.Date();
		

		
			try{
			
			Statement state = con.connecter().createStatement();
		int rs = state.executeUpdate("insert into java.cmd_externe(ID_CHEF,DATE_CMD_EX,ETAT) VALUES ('"+chef+"','"+formater.format( date )+"','EN COURS')");
		con.deconnecter();
			}
			catch(Exception e) {
				System.out.println(e.getMessage()+" DB");

			}
			
		
	}
	public int getMaxId() {
	int max=0;
		try {
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT MAX(ID_CMD_EX) FROM java.cmd_externe");
		while(result.next()) {
		max=result.getInt(1);
		
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return max;
	}
/*	public int getMaxId() throws ClassNotFoundException, SQLException {
		
		int a=0;
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT count(*) from chef");
		while(result.next()) {
			 a=result.getInt(1);
		}
		return a;
	}*/

	/// methodes commandes ex
	public int getcountexcommand() {
			int x=0;
			try {
			Connexion con=new Connexion();
			con.connecter();
			Statement state = con.connecter().createStatement();
			ResultSet result = state.executeQuery("SELECT count(*) from java.cmd_externe x,java.utilisateur c where x.ID_CHEF=c.ID_USR");
			while(result.next()) {
			x=result.getInt(1);
			}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return x;
		}
	public int getcountexcommand(int id) {
		int x=0;
		try {
		Connexion con=new Connexion();
		con.connecter();
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT count(*) from java.cmd_externe x,java.utilisateur c where x.ID_CHEF=c.ID_USR and x.ID_chef="+id+"");
		while(result.next()) {
		x=result.getInt(1);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return x;
	}
		public void deleteCommandeExById(int id) {
			Connexion c=new Connexion();
			try{
			c.connecter();
			Statement state = c.connecter().createStatement();
		    state.executeUpdate("delete from java.cmd_externe where ID_CMD_EX ="+id+"");
		c.deconnecter();
			}
			catch(Exception e) {
				System.out.println(e.getMessage()+" DB");

			}
		}
		public void UpdateQuantity(int x,int idligne,int QT)
		{
			Connexion c=new Connexion();
			Statement state=null;
			try{
			c.connecter();
			 state = c.connecter().createStatement();
		     state.executeUpdate("update cmd_externe x,ligne_externe c set c.QT_PRODUIT='"+QT+"'  where x.ID_CMD_EX='"+x+"' AND c.ID_LIGNE_EX='"+idligne+"'  ");
			}
			catch(Exception e) {
				System.out.println(e.getMessage()+" DB");

			}
		}
		public int getRows(int x) {
			int count=-1;
			try {

			
			
			Statement state = con.connecter().createStatement();
			
			ResultSet result = state.executeQuery("SELECT count(ID_CMD_EX) FROM java.ligne_externe where ID_CMD_EX="+x+" ");
			while(result.next()) {
				count=result.getInt(1);
			}
			
				}
			catch(Exception e) {
				
			}
			return count;
			
		}
		public String getETATbyid(int x4)
		{
			String arg=null;
			try {

				Statement state = con.connecter().createStatement();
				ResultSet result = state.executeQuery("SELECT ETAT FROM java.cmd_externe where ID_CMD_EX="+x4+" ");
				while(result.next()) {
					arg=result.getString(1);
				}
				
					}
				catch(Exception e) {
					e.printStackTrace();
				}
			return arg;
			
		}


}
