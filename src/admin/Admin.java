package admin;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.sun.xml.internal.ws.api.server.Container;

import interface1.Auth;
import javafx.scene.control.PasswordField;
import principale.Cmd_externe;
import principale.Connexion;
import principale.Fournisseur;
import principale.Produit;
import principale.Rayon;
import principale.Utilisateur;

public class Admin extends JFrame implements ActionListener,MouseListener {
	int ligneTable=-1;
	JButton b=new JButton("chefs",new ImageIcon("images/add.png"));
    JLabel l=new JLabel(new ImageIcon("images/haut.png"));
    JPanel pan=new JPanel();
    JButton deconnecter=new JButton("se déconnecter");
    JLabel admin=new JLabel(new ImageIcon("images/admin1.png"));
    JLabel bnjr=new JLabel("Bienvenue Mr le directeur");
    JPanel menu=new JPanel();
    Border emptyBorder = BorderFactory.createEmptyBorder();
    
    JButton usrIcon=new JButton(new ImageIcon("images/usr.png"));
    JButton commandeIcon=new JButton(new ImageIcon("images/commande.png"));
    JButton stockIcon=new JButton(new ImageIcon("images/stock.png"));
    JButton profilIcon=new JButton(new ImageIcon("images/chef.png"));
    JLabel marge=new JLabel("                ");
    JLabel marge1=new JLabel("                ");
    JLabel marge3=new JLabel("                ");
    JLabel marge2=new JLabel("          ");
    JLabel erreur=new JLabel("Les information sont incorrect");
/*l'interface de gestion d'utilisateur*/
    JPanel UsrContainer=new JPanel();
    //table des users
	Utilisateur u=new Utilisateur();
	Rayon r=new Rayon();
	   String[] t= {"ID","NOM","TEL","PRENOM","CNI","Rayon"};
		JTable table;
     JPanel containerTable=new JPanel();
    //formulaire
    JPanel containerForm=new JPanel();
    JLabel lNom=new JLabel("Nom:");
    JLabel lPrenom=new JLabel("Prenom:");
    JLabel lRayon=new JLabel("Rayon:");
    JLabel lCni=new JLabel("CNI:");
    JLabel lTel=new JLabel("Tel:");
    JLabel lLogin=new JLabel("Login:");
    JLabel lMdp1=new JLabel("Mot de passe:");
    JLabel lMdp2=new JLabel("Retapez Mot de passe:");
   JTextField tNom=new JTextField();
   JTextField tPrenom=new JTextField();
   JTextField tCni=new JTextField();
   JTextField tTel=new JTextField();
   JTextField tLogin=new JTextField();
   JComboBox comboRayon=new JComboBox(r.getAllRayons());
	JPasswordField tMdp1=new 	JPasswordField();
	JPasswordField tMdp2=new 	JPasswordField();
   JButton modifier=new JButton(new ImageIcon("images/modifier.png"));
   JButton supprimer=new JButton(new ImageIcon("images/delete.png"));
   JButton ajouter=new JButton("Ajouter");
   JButton update=new JButton("modifier");
  /*interface affichage  */
// Interface commandes
   JPanel commandepanel=new JPanel();
   JLabel Latcom=new JLabel("le N° de dérnier commande :");
   JLabel Latcom1=new JLabel("test");
   JButton validate=new JButton("Valider");
   JButton Modify=new JButton("Modifier");
   JTextField comandevoulu=new JTextField("Enterez le N° de la commande");
   JButton View=new JButton("Chercher");
   JButton refuserButton=new JButton("Refuser");
   JLabel Quantity=new JLabel("Quantité :");
   JTextField QuantityField=new JTextField("");
   JPanel CommandeTableContainer=new JPanel();
   JButton Ok=new JButton("OK");
   JButton Delete=new JButton("Supprimer");
   String [] tabe1;
   String [][] tabe2;
   JTable Tableau;
   // interface stock
   JPanel stockpanel=new JPanel();
   JLabel titre=new JLabel ("Les commandes récemment effectuées :");
   JPanel stockjtablepanel=new JPanel();
   //composant de profil
   JLabel containerProfil=new JLabel();
   JLabel titreProfil=new JLabel ("Paramètres généraux du compte :");
   JLabel pNom=new JLabel("Nom :");
   JLabel pPrenom=new JLabel("Prénom :");
   JLabel pLogin=new JLabel("Login :");
   JLabel pAncienneMtd=new JLabel("Mot de passe actuel  :");
   JLabel pNouveauMtd1=new JLabel("Nouveau mot de passe :");
   JLabel pNouveauMtd2=new JLabel("Nouveau mot de passe(à nouveau) :");
   
   JTextField tpNom=new JTextField();
   JTextField tpPrenom=new JTextField();
   JTextField tpLogin=new JTextField();
   JPasswordField tpAncienneMtd=new JPasswordField();
   JPasswordField tpNouveauMtd1=new JPasswordField();
   JPasswordField tpNouveauMtd2=new JPasswordField();
   JButton modifierProfilButton=new JButton("modifier");

   
   
   
   
   
   
	public Admin() throws IOException {
    l.setBounds(0,0,1000,150);
    this.add(l);
     pan.setBounds(0,150,1000,30);
     pan.setBackground(Color.yellow);
     deconnecter.setBounds(835,150,150,30);
     this.add(deconnecter);
     deconnecter.setBackground(Color.yellow);
     deconnecter.setBorder(emptyBorder);
     this.add(pan);
     pan.add(admin);
     admin.setSize(30,30);
     bnjr.setBounds(0,160,200,10);
     this.add(bnjr);
     pan.add(bnjr);
     menu.setBounds(0,180,1000,90);
     menu.setBackground(new Color(169,245,234));
     this.add(menu);
     comandevoulu.addMouseListener(this);
   
     usrIcon.setBackground(new Color(169,245,234));
     menu.add(usrIcon);
     usrIcon.setBorder(emptyBorder);
     usrIcon.setBounds(100,100,500,100);
     usrIcon.addActionListener(this);
     commandeIcon.addActionListener(new CommandeIconBtn());
     stockIcon.addActionListener(this);
     menu.add(marge);
     commandeIcon.setBackground(new Color(169,245,234));
     menu.add(commandeIcon);
     commandeIcon.setBorder(emptyBorder);
     menu.add(marge1);
     stockIcon.setBackground(new Color(169,245,234));
     menu.add(stockIcon);
     stockIcon.addActionListener(new stockIconListener());
     stockIcon.setBorder(emptyBorder);
     menu.add(marge3);
     
     profilIcon.addActionListener(this);
    
     profilIcon.setBackground(new Color(169,245,234));
     menu.add(profilIcon);
     profilIcon.setBorder(emptyBorder);
    //table des users
    containerTable.setBounds(30,300,500,500);
     containerTable.setVisible(false);
     UsrContainer.setVisible(false);
     containerTable.setBackground(new Color(50, 115, 220));
     this.add(containerTable);
     table=new JTable(u.getAllUsersTab(),t);
    containerTable.add(table.getTableHeader(), BorderLayout.NORTH);
    containerTable.add(table, BorderLayout.CENTER);
    table.addMouseListener(this);
     lNom.setBounds(550,280,150,30);
     lNom.setVisible(false);
this.add(lNom);
lPrenom.setBounds(550,330,150,30);
lPrenom.setVisible(false);
this.add(lPrenom);
lCni.setBounds(550,380,150,30);
lCni.setVisible(false);
this.add(lCni);
lTel.setBounds(550,430,150,30);
lTel.setVisible(false);
this.add(lTel);

lRayon.setBounds(550,480,150,30);
lRayon.setVisible(false);
this.add(lRayon);
lLogin.setBounds(550,530,150,30);
lLogin.setVisible(false);
this.add(lLogin);
lMdp1.setBounds(550,580,150,30);
lMdp1.setVisible(false);
this.add(lMdp1);
lMdp2.setBounds(550,630,150,30);
lMdp2.setVisible(false);
this.add(lMdp2);

tNom.setBounds(700,280,150,25);
tNom.setVisible(false);
tNom.addActionListener(this);
this.add(tNom);
tPrenom.setBounds(700,330,150,25);
tPrenom.setVisible(false);
tPrenom.addActionListener(this);
this.add(tPrenom);
tCni.setBounds(700,380,150,25);
tCni.setVisible(false);
tCni.addActionListener(this);
this.add(tCni);
tTel.addActionListener(this);
tTel.setVisible(false);
tTel.setBounds(700,430,150,25);
this.add(tTel);
comboRayon.setBounds(700,480,150,25);
this.add(comboRayon);
comboRayon.addActionListener(this);
comboRayon.setVisible(false);
comboRayon.addActionListener(this);
tLogin.addActionListener(this);
tLogin.setVisible(false);
tLogin.setBounds(700,530,150,25);
this.add(tLogin);

tMdp1.addActionListener(this);
tMdp1.setVisible(false);
tMdp1.setBounds(700,580,150,25);
this.add(tMdp1);
tMdp2.addActionListener(this);
tMdp2.setVisible(false);
tMdp2.setBounds(700,630,150,25);
this.add(tMdp2);


ajouter.setBounds(580,670,150,25);
ajouter.setVisible(false);
ajouter.setBackground(Color.green);
ajouter.setBorder(emptyBorder);
ajouter.addActionListener(this);
erreur.setBounds(750,660,200,20);
erreur.setOpaque(true);
erreur.setBackground(Color.red);
erreur.setVisible(false);
this.add(erreur);
update.setBounds(580,670,150,25);
update.setBackground(Color.green);
update.setBorder(emptyBorder);
update.addActionListener(this);
update.setVisible(false);
this.add(ajouter);
this.add(update);
    containerTable.add(modifier);
    containerTable.add(marge2);
    containerTable.add(supprimer);
    modifier.setBorder(emptyBorder);
    modifier.setBackground(new Color(50, 115, 220));
    supprimer.setBackground(new Color(50, 115, 220));
    supprimer.setBorder(emptyBorder);
    supprimer.addActionListener(this);
    modifier.addActionListener(this);
    deconnecter.addActionListener(this);
    
    //new
    this.add(commandepanel);
    commandepanel.setLayout(null);
    commandepanel.setBounds(30,300,900,500);
    commandepanel.setBackground(new Color(50, 115, 220));
    commandepanel.add(Latcom);
    Latcom.setBounds(100, 30,250, 25);
    commandepanel.add(Latcom1);
    Latcom1.setBounds(300, 30, 30, 25);
    commandepanel.add(comandevoulu);
    comandevoulu.setBounds(350,30,200,25);
    comandevoulu.addActionListener(this);
    commandepanel.add(View);
    View.setBounds(550,30,100,24);
    View.addActionListener(this);
    commandepanel.add(CommandeTableContainer);
    CommandeTableContainer.setBounds(10,70,700,250);
    CommandeTableContainer.setBackground(new Color(50, 115, 220));
   
    commandepanel.add(validate);
    validate.setBounds(500,320,80,25);
    validate.addActionListener(new ValidateCommandActionListener());
    commandepanel.add(Modify);
    Modify.setBounds(100,320,80,25);
    Modify.addActionListener(new ModifyCommandActionListener());
    commandepanel.add(refuserButton);
    refuserButton.setBounds(580,320,80,25);
    Delete.setBounds(180,320,100,25);
    commandepanel.add(Delete);
    Delete.addActionListener(this);
    commandepanel.add(Quantity);
    Quantity.setBounds(750, 150, 70, 25);
    Quantity.setVisible(false);
    commandepanel.add(QuantityField);
    QuantityField.setVisible(false);
    QuantityField.setBounds(750, 180, 70, 25);
    QuantityField.addActionListener(this);
    commandepanel.add(Ok);
    Ok.setVisible(false);
    Ok.setBounds(750, 210, 70, 25);
    Ok.addActionListener(this);
    commandepanel.setVisible(false);
    Modify.setVisible(false);
    Delete.setVisible(false);
    refuserButton.setVisible(false);
    refuserButton.addActionListener(new RefuseCommandActionListener());
    validate.setVisible(false);
    //stock 
    this.add(stockpanel);
    stockpanel.setVisible(false);
    stockpanel.setLayout(null);
    stockpanel.setBounds(30,300,900,900);
    stockpanel.setBackground(new Color(50, 115, 220));
    stockpanel.add(stockjtablepanel);
    stockjtablepanel.setBackground(new Color(50, 115, 220));
    stockpanel.add(titre);
    titre.setBounds(300, 10, 300, 25);
    stockjtablepanel.setBounds(50,50,800,800);
    
  titre.setBounds(200,5,800, 25);
    
    Font font2 = new Font("SansSerif", Font.BOLD, 20);
   titre.setFont(font2);
   titre.setForeground(new Color(201,220,100));
 //profil

   titreProfil.setBounds(300,280,800, 25);
   
   titreProfil.setFont(font2);
  titreProfil.setForeground(new Color(201,220,100));
  this.add(titreProfil);
 
   pNom.setBounds(350,320,100,20);
   this.add(pNom);
   pPrenom.setBounds(350,370,100,20);
   this.add(pPrenom);
   pLogin.setBounds(350,420,100,20);
   this.add(pLogin);
   pAncienneMtd.setBounds(350,470,150,20);
   this.add(pAncienneMtd);
   pNouveauMtd1.setBounds(350,520,150,20);
   this.add(pNouveauMtd1);
   pNouveauMtd2.setBounds(350,570,250,20);
   this.add(pNouveauMtd2);
   
   tpNom.setBounds(650,320,150,25);
   this.add(tpNom);
   tpNom.addActionListener(this);
   tpPrenom.setBounds(650,370,150,25);
   this.add(tpPrenom);
   tpPrenom.addActionListener(this);
   tpLogin.setBounds(650,420,150,25);
   this.add(tpLogin);
   tpLogin.addActionListener(this);
   tpAncienneMtd.setBounds(650,470,150,25);
   this.add(tpAncienneMtd);
   tpAncienneMtd.addActionListener(this);
   tpNouveauMtd1.setBounds(650,520,150,25);
   this.add(tpNouveauMtd1);
   tpNouveauMtd1.addActionListener(this);
   tpNouveauMtd2.setBounds(650,570,150,25);
   this.add(tpNouveauMtd2);
   tpNouveauMtd2.addActionListener(this);
   modifierProfilButton.setBounds(450,620,150,30);
   this.add(modifierProfilButton);
   modifierProfilButton.setBackground(Color.green);
   modifierProfilButton.addActionListener(this);
   
   profilVisible(false);
    
    stockjtablepanel.setBounds(50,50,800,350);
this.getContentPane().setBackground(new Color(50, 115, 220));
	  this.setLayout(null);
		this.setSize(1000,750);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public static void main(String[] args) throws IOException {
          Admin i=new Admin();
	}
	public  void userVisible(boolean t) {
		UsrContainer.setVisible(t);
		containerTable.setVisible(t);
		tNom.setVisible(t);tPrenom.setVisible(t);tTel.setVisible(t);tCni.setVisible(t);tLogin.setVisible(t);tMdp1.setVisible(t);tMdp2.setVisible(t);comboRayon.setVisible(t);
		lNom.setVisible(t);lPrenom.setVisible(t);lTel.setVisible(t);lCni.setVisible(t);lLogin.setVisible(t);lMdp1.setVisible(t);lMdp2.setVisible(t);lRayon.setVisible(t);
		ajouter.setVisible(t);
	}
	public  void profilVisible(boolean t) {
		 containerProfil.setVisible(t);
		   titreProfil.setVisible(t);
		    pNom.setVisible(t);
		     pPrenom.setVisible(t);
		    pLogin.setVisible(t);
		    pAncienneMtd.setVisible(t);
		   pNouveauMtd1.setVisible(t);
		    pNouveauMtd2.setVisible(t);

			    tpNom.setVisible(t);
			     tpPrenom.setVisible(t);
			    tpLogin.setVisible(t);
			    tpAncienneMtd.setVisible(t);
			   tpNouveauMtd1.setVisible(t);
	
			   tpNouveauMtd2.setVisible(t);
			    modifierProfilButton.setVisible(t);
	}

	public void Tableau() {
		Connexion c=new Connexion();
		Cmd_externe x=new Cmd_externe();
		String[] tabe2= {"Produit","Quantité","Fournisseur","Date_CMD"};
	    String x1=comandevoulu.getText();
		try {
			int i=0;
			Statement state = c.connecter().createStatement();
			String[][] tabe1=new String[x.getRows(Integer.parseInt(comandevoulu.getText()+""))][4];
			ResultSet result = state.executeQuery("select p.NOM_PRODUIT,l.QT_PRODUIT,f.NOM_FOURNISSEUR,c.DATE_CMD_EX from java.produit p,java.ligne_externe l,java.fournisseur f,java.cmd_externe c where c.ID_CMD_EX=l.ID_CMD_EX and c.ID_CMD_EX='"+x1+"' and p.ID_ARTICLE=l.ID_ARTICLE and l.ID_FOURNISSEUR=f.ID_FOURNISSEUR");
			while(result.next())
			{
		                tabe1[i][0] =result.getString(1);
		                tabe1[i][1] =result.getString(2);
		                tabe1[i][2] =result.getString(3);
		                tabe1[i][3] =result.getString(4);
						i++;
			}
			Tableau=new JTable(tabe1,tabe2);
			Tableau.setBackground(new Color(50, 115, 220));
			Tableau.setForeground(Color.WHITE);
			Tableau.getColumnModel().getColumn(0).setPreferredWidth(150);
			CommandeTableContainer.setLayout(new BorderLayout());
			CommandeTableContainer.add(Tableau.getTableHeader(), BorderLayout.NORTH);
			CommandeTableContainer.add(Tableau, BorderLayout.CENTER);
			CommandeTableContainer.setBackground(new Color(169,245,234));
			Tableau.setFillsViewportHeight(true);
			Tableau.addMouseListener(this);
		}
		catch(Exception e1) {
			System.out.println(e1.getMessage());
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==usrIcon) {
			userVisible(true);
			commandepanel.setVisible(false);
			stockpanel.setVisible(false);
			 profilVisible(false);

		}
		if(e.getSource()==ajouter) {
			if(tMdp1.getText().equals(tMdp2.getText())) {
			
		u.setAll(tNom.getText().toString(),tPrenom.getText().toString(),tCni.getText().toString(),tTel.getText().toString(),tLogin.getText().toString(),tMdp1.getText().toString(),comboRayon.getSelectedIndex());
		try {
			this.dispose();
			Admin a=new Admin();
			a.userVisible(true);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			else {
				
				JOptionPane.showMessageDialog(null,"les mots de passe ne sont pas identiques");
						

			}
		}
		else if(e.getSource()==supprimer && ligneTable!=-1) {
			u.deleteById(ligneTable);
			try {
				this.dispose();
			Admin a=new Admin();
			a.userVisible(true);}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		
		}   
		else if(e.getSource()==modifier && ligneTable!=-1) {
			ajouter.setVisible(false);
			update.setVisible(true);
			tNom.setText(u.getAllUsersTab()[table.getSelectedRow()][1]);
			tPrenom.setText(u.getAllUsersTab()[table.getSelectedRow()][3]);
			tCni.setText(u.getAllUsersTab()[table.getSelectedRow()][4]);
			tTel.setText(u.getAllUsersTab()[table.getSelectedRow()][2]);
			tLogin.setText(u.getAllUsersTab()[table.getSelectedRow()][6]);
		
		}
			 if(e.getSource()==update) {
				try {
					u.updateAll(tNom.getText(), tPrenom.getText(), tCni.getText(), tTel.getText(),Integer.parseInt(u.getAllUsersTab()[table.getSelectedRow()][0]),tLogin.getText(),tMdp1.getText());
					Admin a;
					try {
						this.dispose();
						a = new Admin();
						a.userVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} catch (ArrayIndexOutOfBoundsException | NumberFormatException | ClassNotFoundException
						| SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
			 if(e.getSource()==deconnecter) {
				
            Auth a=new Auth();
				this.dispose();
			 }
			 if(e.getSource()==View) {
				 Tableau();
				 Cmd_externe x=new Cmd_externe();
				 CommandeTableContainer.add(Tableau);
				 Tableau.addMouseListener(this);
				 Modify.setVisible(true);
				    Delete.setVisible(true);
				    refuserButton.setVisible(true);
				    validate.setVisible(true);
				    if(x.getETATbyid(Integer.parseInt(comandevoulu.getText())).equals("VALIDEE"))
					{
						validate.setVisible(false);
						Delete.setVisible(false);
						Modify.setVisible(false);
						refuserButton.setVisible(false);
					}
					else if(x.getETATbyid(Integer.parseInt(comandevoulu.getText())).equals("EN COURS"))
					{
						validate.setVisible(true);
						Delete.setVisible(true);
						Modify.setVisible(true);
						refuserButton.setVisible(true);

					}
					else if(x.getETATbyid(Integer.parseInt(comandevoulu.getText())).equals("REFUSEE"))
					{
						validate.setVisible(false);
						Delete.setVisible(false);
						Modify.setVisible(false);
						refuserButton.setVisible(false);
					}
				 
			 }
			 if(e.getSource()==Ok) {
					Connexion con2=new Connexion();
					Fournisseur f=new Fournisseur();
					Produit p=new Produit();
					int del1=Integer.parseInt(comandevoulu.getText());
					int idfour=f.getIDByNameFournisseur(Tableau.getValueAt(Tableau.getSelectedRow(), 2).toString());
					int idpro=p.getIDByNameProduit(Tableau.getValueAt(Tableau.getSelectedRow(), 0).toString());
					int QTvoulu=Integer.parseInt(QuantityField.getText());
					try {
						con2.connecter();
						Statement state5=con2.connecter().createStatement();
						state5.executeUpdate("UPDATE java.ligne_externe SET QT_PRODUIT ="+QTvoulu+" WHERE ID_ARTICLE="+idpro+" AND ID_FOURNISSEUR="+idfour+" AND ID_CMD_EX="+del1+"");
					}
					catch(Exception e1) { e1.printStackTrace();
						
					}
					View.doClick();
					Quantity.setText(" ");
				}
			 if(e.getSource()==Delete)
			 {
				 Connexion con1=new Connexion();
					Fournisseur f=new Fournisseur();
					Produit p=new Produit();
					int del1=Integer.parseInt(comandevoulu.getText());
					int idfour=f.getIDByNameFournisseur(Tableau.getValueAt(Tableau.getSelectedRow(), 2).toString());
					int idpro=p.getIDByNameProduit(Tableau.getValueAt(Tableau.getSelectedRow(), 0).toString());
					try {
						con1.connecter();
						Statement state4=con1.connecter().createStatement();
						state4.executeUpdate("DELETE FROM java.ligne_externe WHERE ID_CMD_EX="+del1+" AND ID_ARTICLE="+idpro+" AND ID_FOURNISSEUR="+idfour+"  ");
					}
					catch(Exception e4)
					{ e4.printStackTrace();}
					View.doClick();
					}
			 if(e.getSource()==profilIcon) {
				 profilVisible(true);
					userVisible(false);
					commandepanel.setVisible(false);
					stockpanel.setVisible(false);
				
				 tpNom.setText(u.getNomById(1));
				  tpPrenom.setText(u.getPrenomById(1));
				 tpLogin.setText(u.getLoginById(1));

				     }
			 if(e.getSource()==this.modifierProfilButton) {
				 try {
				     if(tpAncienneMtd.getText().equals(u.getMdpById(1)) && this.tpNouveauMtd1.getText().equals(this.tpNouveauMtd2.getText())) {
				    
				    	 u.updateChef(tpNom.getText(),tpPrenom.getText(),1,tpLogin.getText(),tpNouveauMtd1.getText());
				    	 JOptionPane.showMessageDialog(null,"vous avez modifer vos informations avec succées");
				     }
				     else if(!this.tpNouveauMtd1.getText().equals(this.tpNouveauMtd2.getText()))
				    	 JOptionPane.showMessageDialog(null,"les mots de passe ne sont pas identiques");
				     else JOptionPane.showMessageDialog(null,"retapez votre ancienne mot de passe"); 
				 }
				
				    	catch(Exception g) {
				    		g.printStackTrace();
				    	}
				 }

		
	}
	
	///
	// methodes

	public class CommandeIconBtn implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				comandevoulu.setText("Enterez le N° de la commande");
				userVisible(false);
				commandepanel.setVisible(true);
				 profilVisible(false);

				Connexion c=new Connexion();
				try {
					c.connecter();
					String nbcmdex = null;
					Statement state = c.connecter().createStatement();
					ResultSet result = state.executeQuery("SELECT MAX(ID_CMD_EX) from java.cmd_externe");
					while(result.next()) {
						 nbcmdex=result.getString(1);
					}
					Latcom1.setText(nbcmdex);
					result.close();
					state.close();
					c.deconnecter();
				}
				catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		}
			

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==table) {
	
			ligneTable=Integer.parseInt(u.getAllUsersTab()[table.getSelectedRow()][0]);
		}
		if(e.getSource()==Tableau) {
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if(e.getSource()==comandevoulu) {
			comandevoulu.setText("");
			comandevoulu.requestFocus();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	// methode de stock icon
	public class stockIconListener implements ActionListener {
      
		@Override
		public void actionPerformed(ActionEvent arg0) {
			userVisible(false);
			commandepanel.setVisible(false);
			stockpanel.setVisible(true);
			 profilVisible(false);

            Cmd_externe x=new Cmd_externe();
			Connexion c=new Connexion();
			String [] columnsstock= {"ID command","Nom chef","Date","Etat"};
			String [][] TabStock=new String[x.getcountexcommand()][4];
			
			
			try {
				int i=0;
				Statement state = c.connecter().createStatement();
				ResultSet result = state.executeQuery("SELECT x.ID_CMD_EX,c.NOM_USR,x.DATE_CMD_EX,x.ETAT from java.cmd_externe x,java.utilisateur c where x.ID_CHEF=c.ID_USR order by x.ID_CMD_EX DESC");
				while(result.next())
				{
					TabStock[i][0] =result.getString(1);
					TabStock[i][1] =result.getString(2);
					TabStock[i][2] =result.getString(3);
					TabStock[i][3] =result.getString(4);
							i++;
				}
				JTable Tableau1=new JTable(TabStock,columnsstock);
				Tableau1.setBackground(new Color(50, 115, 220));
				Tableau1.setForeground(Color.WHITE);
				stockjtablepanel.setLayout(new BorderLayout());
				stockjtablepanel.add(Tableau1.getTableHeader(), BorderLayout.NORTH);
				stockjtablepanel.add(Tableau1, BorderLayout.CENTER);
				Tableau1.setFillsViewportHeight(true);
			}
			catch(Exception e1) {
				System.out.println(e1.getMessage());
			}	
		}
		
	}
	public class ModifyCommandActionListener   implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			QuantityField.setVisible(true);
			Quantity.setVisible(true);
			Ok.setVisible(true);
		}
		
	}
	public class RefuseCommandActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int x3=Integer.parseInt(comandevoulu.getText());
			Connexion con=new Connexion();
			try {
				con.connecter();
				Statement state3=con.connecter().createStatement();
				state3.executeUpdate("UPDATE java.cmd_externe SET ETAT='REFUSEE' where ID_CMD_EX='"+x3+"'");
			}
			catch(Exception e3) {e3.printStackTrace();}	
			View.doClick();
		}		
		
	}
	public class ValidateCommandActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int x3=Integer.parseInt(comandevoulu.getText());
			Connexion con=new Connexion();
			try {
				con.connecter();
				Statement state3=con.connecter().createStatement();
				state3.executeUpdate("UPDATE java.cmd_externe SET ETAT='VALIDEE' where ID_CMD_EX='"+x3+"'");
			}
			catch(Exception e3) {e3.printStackTrace();}	
			View.doClick();
		}		
		
	}
	
}
