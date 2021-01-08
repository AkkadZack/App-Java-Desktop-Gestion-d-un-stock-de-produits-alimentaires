package principale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class Utilisateur {
	private int ID_USR;
	private String CNI_USR;
	private String NOM_USR;
	private String PRENOM_USR;	
	private String TEL_USR;
	private String LOGIN_USR;
	private String MDP_USR;
	private int ROLE_USR;
	private int ID_RAYON;
	private Connexion con=new Connexion();
	
 
	public Utilisateur(int iD_USR, String cNI_USR, String nOM_USR, String pRENOM_USR, String tEL_USR, int rOLE_USR,int ID_RAYON,String login,String mdp) {
	
		ID_USR = iD_USR;
		CNI_USR = cNI_USR;
		NOM_USR = nOM_USR;
		PRENOM_USR = pRENOM_USR;
		TEL_USR = tEL_USR;
		ROLE_USR = rOLE_USR;
		this.ID_RAYON=ID_RAYON;
		this.LOGIN_USR=login;
		this.MDP_USR=mdp;
	}
	

	public Utilisateur() {
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
	
	public int getROLE_USR() {
		return ROLE_USR;
	}


	public void setROLE_USR(int rOLE_USR) {
		ROLE_USR = rOLE_USR;
	}


	public int getID_USR() {
		return ID_USR;
	}
	public void setID_USR(int iD_USR) {
		ID_USR = iD_USR;
	}
	public String getCNI_USR() {
		return CNI_USR;
	}
	public void setCNI_USR(String cNI_USR) {
		CNI_USR = cNI_USR;
	}
	public String getNOM_USR() {
		return NOM_USR;
	}
	public void setNOM_USR(String nOM_USR) {
		NOM_USR = nOM_USR;
	}
	public String getPRENOM_USR() {
		return PRENOM_USR;
	}
	public void setPRENOM_USR(String pRENOM_USR) {
		PRENOM_USR = pRENOM_USR;
	}
	public String getTEL_USR() {
		return TEL_USR;
	}
	public void setTEL_USR(String tEL_USR) {
		TEL_USR = tEL_USR;
	}
	public int getID_RAYON() {
		return ID_RAYON;
	}
	public void setID_RAYON(int iD_RAYON) {
		ID_RAYON = iD_RAYON;
	}
	public int countUser() throws ClassNotFoundException, SQLException {
		
		con.connecter();
		int a=0;
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT count(*) from java.utilisateur");
		while(result.next()) {
			 a=result.getInt(1);
		}
		
		return a;
	}
	public String[] getNomDB() throws ClassNotFoundException, SQLException {
		
		
		String [] re=new String[countUser()];
		int a=0;
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT NOM_USR FROM java.utilisateur");
		while(result.next())  {
		re[a]=result.getString(1);
		a++;
		
		}
		con.deconnecter();
		return re;
	}
	public String getNomById(int id) {
		String nom ="";
		try {
	
		
		
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT NOM_USR FROM java.utilisateur where ID_USR="+id+" ");
		while(result.next()) {
		nom=result.getString(1);
		}
		
		}
		catch(Exception e) {
			
		}
		return nom;
		
	}
	public String getPrenomById(int id) {
		String prenom ="";
		try {
	
		
		
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT PRENOM_USR FROM java.utilisateur where ID_USR="+id+" ");
		while(result.next()) {
		prenom=result.getString(1);
		}
		con.deconnecter();
		}
		catch(Exception e) {
			
		}
		return prenom;
		
	}
	public String getTelById(int id) {
		String tel ="";
		try {
	
		
		
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT TEL_USR FROM java.utilisateur where ID_USR="+id+" ");
		tel=result.getString(1);
		con.deconnecter();
		}
		catch(Exception e) {
			
		}
		return tel;
		
	}
	public String getLoginById(int id) {
		String login ="";
		try {
	
		
		
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT LOGIN_USR FROM java.utilisateur where ID_USR="+id+" ");
		while(result.next()) {
		login=result.getString(1);
		}
		con.deconnecter();
		}
		catch(Exception e) {
			
		}
		return login;
		
	}
	public String getMdpById(int id) {
		String login ="";
		try {
	
		
		
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT MDP_USR FROM java.utilisateur where ID_USR="+id+" ");
		while(result.next()) {
		login=result.getString(1);
		}
		con.deconnecter();
		}
		catch(Exception e) {
			
		}
		return login;
		
	}
	public String getCniById(int id) {
		String cni ="";
		try {
	
		
		
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT CNI_USR FROM java.utilisateur where ID_USR="+id+" ");
		cni=result.getString(1);
		con.deconnecter();
		}
		catch(Exception e) {
			
		}
		return cni;
		
	}
	public String[] getLogins() throws ClassNotFoundException, SQLException {
		String [] re=new String[countUser()];
		int a=0;
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT LOGIN_USR FROM java.utilisateur");
		while(result.next())  {
		re[a]=result.getString(1);
		a++;
		
		}
		return re;
	}
	public String[] getMdps() throws ClassNotFoundException, SQLException {
		String [] re=new String[countUser()];
		int a=0;
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT MDP_USR FROM java.utilisateur");
		while(result.next())  {
		re[a]=result.getString(1);
		a++;
		
		}
		return re;
	}
	public ArrayList<Utilisateur> getallusers() throws ArrayIndexOutOfBoundsException {
		
		ArrayList<Utilisateur> liste=new ArrayList<>();
		try {

		
		
		Statement state = con.connecter().createStatement();
		ResultSet result = state.executeQuery("SELECT * FROM java.utilisateur u,java.rayon r where ROLE_USR='2' and r.ID_RAYON=u.ID_RAYON ");
		while(result.next()) {
			liste.add(new Utilisateur(result.getInt("ID_USR"),result.getString("CNI_USR"),result.getString("NOM_USR")
			
					,result.getString("PRENOM_USR"),result.getString("TEL_USR"),result.getInt("ROLE_USR"),result.getInt("ID_RAYON"),result.getString("LOGIN_USR"),result.getString("MDP_USR")));
			
		}
		
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return liste;
	}
public String [][] getAllUsersTab(){
	Utilisateur u=new Utilisateur();
	Rayon r=new Rayon();
	String [][] tab=new String[u.getallusers().size()][8];
	try {
	ArrayList<Utilisateur> liste=u.getallusers();
	
	for(int i=0;i<u.getallusers().size();i++) {
		{			
				tab[i][0]=Integer.toString(liste.get(i).getID_USR()) ;
				tab[i][1]=liste.get(i).getNOM_USR();
				tab[i][2]=liste.get(i).getTEL_USR();
				tab[i][3]=liste.get(i).getPRENOM_USR();
				tab[i][4]=liste.get(i).getCNI_USR();
				tab[i][5]=r.getNameByIdDB(liste.get(i).getID_RAYON());	
				tab[i][6]=liste.get(i).getLOGIN_USR();
				tab[i][7]=liste.get(i).getMDP_USR();
			}
	}
	}
	catch(Exception e) {
		
	}
	return tab;
}
public String getLOGIN_USR() {
	return LOGIN_USR;
}


public void setLOGIN_USR(String lOGIN_USR) {
	LOGIN_USR = lOGIN_USR;
}


public String getMDP_USR() {
	return MDP_USR;
}


public void setMDP_USR(String mDP_USR) {
	MDP_USR = mDP_USR;
}


public void setAll(String nom,String prenom,String cni,String tel,String login,String mdp,int rayon) throws ArrayIndexOutOfBoundsException {

	try{
	
	Statement state = con.connecter().createStatement();
int rs = state.executeUpdate("insert into java.utilisateur(NOM_USR,PRENOM_USR,CNI_USR,TEL_USR,ROLE_USR,LOGIN_USR,MDP_USR,ID_RAYON) VALUES ('"+nom+"','"+prenom+"','"+cni+"','"+tel+"',2,'"+login+"','"+mdp+"',"+rayon+")");
con.deconnecter();
	}
	catch(Exception e) {
		System.out.println(e.getMessage()+" DB");

	}
	
}
public void deleteById(int id) {
	Connexion c=new Connexion();
	try{
	c.connecter();
	Statement state = c.connecter().createStatement();
int rs = state.executeUpdate("delete from java.utilisateur where ID_USR="+id+"");
c.deconnecter();
	}
	catch(Exception e) {
		System.out.println(e.getMessage()+" DB");

	}
}
public boolean isExistById(int id) {
	int count=-1;
	try {

	
	
	Statement state = con.connecter().createStatement();
	ResultSet result = state.executeQuery("SELECT count(*) FROM java.utilisateur where ID_USR="+id+" ");
	count=result.getInt(1);
	con.deconnecter();
	}
	catch(Exception e) {
		
	}
	if(count==1) return true;
	else return false;
}
public boolean isExistByAuth(String login,String pass) {
	int count=-1;
	try {

	
	
	Statement state = con.connecter().createStatement();
	
	ResultSet result = state.executeQuery("SELECT count(*) FROM java.utilisateur where LOGIN_USR='"+login+"' and MDP_USR='"+pass+"' ");
	while(result.next()) {
		count=result.getInt(1);
	}
	
		}
	catch(Exception e) {
		
	}
	if(count==1) return true;
	else return false;
}
public int getRoleByAuth(String login,String pass) {
	int role=-1;
	try {

	
	
	Statement state = con.connecter().createStatement();
	
	ResultSet result = state.executeQuery("SELECT * FROM java.utilisateur where LOGIN_USR='"+login+"' and MDP_USR='"+pass+"' ");
	while(result.next()) {
		role=result.getInt("ROLE_USR");
	}
	
	con.deconnecter();
	}
	catch(Exception e) {
		
	}
	return role;
}
public int getIDRayonByIDChef(int idChef) {
	int id=-1;
	try {

	
	
	Statement state = con.connecter().createStatement();
	
	ResultSet result = state.executeQuery("SELECT * FROM java.utilisateur where ID_USR="+idChef+"");
	while(result.next()) {
		id=result.getInt("ID_RAYON");
	}
	
	con.deconnecter();
	}
	catch(Exception e) {
		
	}
	return id;
}
public int getIdByAuth(String login,String pass) {
	int id=-1;
	try {

	
	
	Statement state = con.connecter().createStatement();
	
	ResultSet result = state.executeQuery("SELECT * FROM java.utilisateur where LOGIN_USR='"+login+"' and MDP_USR='"+pass+"' ");
	while(result.next()) {
		id=result.getInt("ID_USR");
	}
	
	con.deconnecter();
	}
	catch(Exception e) {
		
	}
	return id;
}
public void updateAll(String nom,String prenom,String cni,String tel,int id,String login,String mdp) throws ArrayIndexOutOfBoundsException, ClassNotFoundException, SQLException {

	Statement state=null;
	try{
	
	 state = con.connecter().createStatement();
int rs = state.executeUpdate("update java.utilisateur set NOM_USR='"+nom+"', PRENOM_USR='"+prenom+"', CNI_USR='"+cni+"', TEL_USR='"+tel+"',LOGIN_USR='"+login+"',MDP_USR='"+mdp+"' where ID_USR="+id+"");

	}
	catch(Exception e) {
		System.out.println(e.getMessage()+" DB");

	}

	
}
public void updateChef(String nom,String prenom,int id,String login,String mdp) throws ArrayIndexOutOfBoundsException, ClassNotFoundException, SQLException {

	Statement state=null;
	try{
	
	 state = con.connecter().createStatement();
int rs = state.executeUpdate("update java.utilisateur set NOM_USR='"+nom+"', PRENOM_USR='"+prenom+"',LOGIN_USR='"+login+"',MDP_USR='"+mdp+"' where ID_USR="+id+"");

	}
	catch(Exception e) {
		System.out.println(e.getMessage()+" DB");

	}

	
}
}
