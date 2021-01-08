package chef;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import interface1.Auth;
import principale.Cmd_externe;
import principale.Connexion;
import principale.Fournisseur;
import principale.Ligne_externe;
import principale.Produit;
import principale.Utilisateur;

public class Chef extends JFrame implements ActionListener,MouseListener {
	int idChef;

	int ligneTable=-1;
    JLabel l=new JLabel(new ImageIcon("images/haut.png"));
    JPanel pan=new JPanel();
    JButton deconnecter=new JButton("se déconnecter");
    JLabel admin=new JLabel(new ImageIcon("images/admin1.png"));
    JPanel menu=new JPanel();
    Border emptyBorder = BorderFactory.createEmptyBorder();

    JButton commandeIcon=new JButton(new ImageIcon("images/commande.png"));
    JButton stockIcon=new JButton(new ImageIcon("images/stock.png"));
    JButton profilIcon=new JButton(new ImageIcon("images/chef.png"));
    JLabel marge=new JLabel("                ");
    JLabel marge1=new JLabel("                ");
    JLabel marge2=new JLabel("          ");
    JLabel marge3=new JLabel("                ");

/*l'interface de gestion d'utilisateur*/
    JPanel UsrContainer=new JPanel();
    //labels
    JLabel lTitle=new JLabel("Commander");
    JLabel lProduit =new JLabel("Produits");
    JLabel lFourniseur =new JLabel("Fourniseur");
    JLabel lQuantite=new JLabel("Quantité");
  //comboBoxoB
    Produit p=new Produit();
    Fournisseur f=new Fournisseur();
    Utilisateur u=new Utilisateur();
    JLabel bnjr;

    Cmd_externe cmdEx=new Cmd_externe();
    Ligne_externe LEx=new Ligne_externe();
	JComboBox boxProduit;
    JComboBox boxFournisseur=new JComboBox(f.getNameProviderTab());
   JTextField textQuantite=new JTextField();
    JComboBox boxProduit1;
    JComboBox boxFournisseur1=new JComboBox(f.getNameProviderTab());
    JTextField textQuantite1=new JTextField();
    JComboBox boxProduit2;
    JComboBox boxFournisseur2=new JComboBox(f.getNameProviderTab());
    JTextField textQuantite2=new JTextField();
    JComboBox boxProduit3;
    JComboBox boxFournisseur3=new JComboBox(f.getNameProviderTab());
    JTextField textQuantite3=new JTextField();
    JComboBox boxProduit4;
    JComboBox boxFournisseur4=new JComboBox(f.getNameProviderTab());
    JTextField textQuantite4=new JTextField();
    JButton add1=new JButton(new ImageIcon("images/add.png"));
    JButton add2=new JButton(new ImageIcon("images/add.png"));
    JButton add3=new JButton(new ImageIcon("images/add.png"));
    JButton add4=new JButton(new ImageIcon("images/add.png"));
    JButton commanderButton=new JButton("Commander");
    JButton modifierProfilButton=new JButton("modifier");
    static boolean ligne2=false;
    static boolean ligne3=false;
    static boolean ligne4=false;
    static boolean ligne5=false;
    //container de tableau de commande effectue
    JPanel stockpanel=new JPanel();
    JLabel titre=new JLabel ("Les commandes récemment effectuées :");
    JPanel stockjtablepanel=new JPanel();
     //composants de profil
    JLabel containerProfil=new JLabel();
    JLabel titreProfil=new JLabel ("Paramètres généraux du compte :");
    JLabel lNom=new JLabel("Nom :");
    JLabel lPrenom=new JLabel("Prénom :");
    JLabel lLogin=new JLabel("Login :");
    JLabel lAncienneMtd=new JLabel("Mot de passe actuel  :");
    JLabel lNouveauMtd1=new JLabel("Nouveau mot de passe :");
    JLabel lNouveauMtd2=new JLabel("Nouveau mot de passe(à nouveau) :");
    
    JTextField tNom=new JTextField();
    JTextField tPrenom=new JTextField();
    JTextField tLogin=new JTextField();
    JPasswordField tAncienneMtd=new JPasswordField();
    JPasswordField tNouveauMtd1=new JPasswordField();
    JPasswordField tNouveauMtd2=new JPasswordField();

  /*interface */
	public Chef(int idChef) throws IOException {
		
		this.idChef=idChef;
		boxProduit=new JComboBox(p.getNameProductTab(u.getIDRayonByIDChef(this.idChef)));
		boxProduit1=new JComboBox(p.getNameProductTab(u.getIDRayonByIDChef(this.idChef)));
		boxProduit2=new JComboBox(p.getNameProductTab(u.getIDRayonByIDChef(this.idChef)));
		boxProduit3=new JComboBox(p.getNameProductTab(u.getIDRayonByIDChef(this.idChef)));
		boxProduit4=new JComboBox(p.getNameProductTab(u.getIDRayonByIDChef(this.idChef)));
		bnjr=new JLabel("Bienvenue Mr "+u.getNomById(this.idChef));
    l.setBounds(0,0,1000,150);
    this.add(l);
     pan.setBounds(0,150,1000,30);
     pan.setBackground(Color.yellow);
     deconnecter.setBounds(835,150,150,30);
     this.add(deconnecter);
     deconnecter.setBackground(Color.yellow);
     deconnecter.setBorder(emptyBorder);
     deconnecter.addActionListener(this);
     this.add(pan);
     pan.add(admin);
     admin.setSize(30,30);
     bnjr.setBounds(0,160,200,10);
     this.add(bnjr);
     pan.add(bnjr);
     menu.setBounds(0,180,1000,90);
     menu.setBackground(new Color(169,245,234));
     this.add(menu);
    

     commandeIcon.addActionListener(this);
     stockIcon.addActionListener(new stockIconListener());
     menu.add(marge);
     commandeIcon.setBackground(new Color(169,245,234));
     menu.add(commandeIcon);
     commandeIcon.setBorder(emptyBorder);
     menu.add(marge1);
   
     stockIcon.setBackground(new Color(169,245,234));
     menu.add(stockIcon);
     stockIcon.setBorder(emptyBorder);
     menu.add(marge3);
     
     profilIcon.addActionListener(this);
    
     profilIcon.setBackground(new Color(169,245,234));
     menu.add(profilIcon);
     profilIcon.setBorder(emptyBorder);
     
     Font font1 = new Font("SansSerif", Font.BOLD, 20);
     lTitle.setBounds(450,280,200,30);
    lTitle.setFont(font1);
    lTitle.setForeground(new Color(201,220,100));
     this.add(lTitle);
     lProduit.setBounds(100,310,100,30);
     this.add(lProduit);
     lFourniseur.setBounds(450,310,100,30);
     this.add(lFourniseur);
     lQuantite.setBounds(750,310,100,30);
     this.add(lQuantite);
     boxProduit.setBounds(30,350,200,30);
     this.add(boxProduit);
     boxFournisseur.setBounds(380,350,200,30);
     this.add(boxFournisseur);
     textQuantite.setBounds(680,350,200,30);
     this.add(textQuantite);
    add1.setBounds(900,400,50,30);
    this.add(add1);
    add1.addActionListener(this);
    boxProduit1.setBounds(30,400,200,30);
    this.add(boxProduit1);
   
    boxProduit1.setVisible(false);
    boxFournisseur1.setBounds(380,400,200,30);
    this.add(boxFournisseur1);
    boxFournisseur1.setVisible(false);
    textQuantite1.setBounds(680,400,200,30);
    this.add(textQuantite1);
    textQuantite1.setVisible(false);
    add2.setBounds(900,450,50,30);
    this.add(add2);
    add2.addActionListener(this);
    add2.setVisible(false);
    boxProduit2.setBounds(30,450,200,30);
    this.add(boxProduit2);
    boxProduit2.setVisible(false);
    boxFournisseur2.setBounds(380,450,200,30);
    this.add(boxFournisseur2);
    boxFournisseur2.setVisible(false);
    textQuantite2.setBounds(680,450,200,30);
    this.add(textQuantite2);
    textQuantite2.setVisible(false);
    add3.setBounds(900,500,50,30);
    this.add(add3);
    add3.addActionListener(this);
    add3.setVisible(false);
    boxProduit3.setBounds(30,500,200,30);
    this.add(boxProduit3);
    boxProduit3.setVisible(false);
    boxFournisseur3.setBounds(380,500,200,30);
    this.add(boxFournisseur3);
    boxFournisseur3.setVisible(false);
    textQuantite3.setBounds(680,500,200,30);
    this.add(textQuantite3);
    textQuantite3.setVisible(false);
    add4.setBounds(900,550,50,30);
    add4.addActionListener(this);
    this.add(add4);
    add4.setVisible(false);
    boxProduit4.setBounds(30,550,200,30);
    this.add(boxProduit4);
    boxProduit4.setVisible(false);
    boxFournisseur4.setBounds(380,550,200,30);
    this.add(boxFournisseur4);
    boxFournisseur4.setVisible(false);
    textQuantite4.setBounds(680,550,200,30);
    this.add(textQuantite4);
    textQuantite4.setVisible(false);
    commanderButton.setBounds(400,600,150,30);
    this.add(commanderButton);
    commanderButton.setBackground(Color.green);
    commanderButton.addActionListener(this);
    //container
   // CommandeTableContainer.setBounds(r);
    this.add(stockpanel);
    stockpanel.setVisible(false);
    stockpanel.setLayout(null);
    stockpanel.setBounds(30,300,900,500);
    stockpanel.setBackground(new Color(50, 115, 220));
    stockpanel.add(stockjtablepanel);
    stockjtablepanel.setBackground(new Color(50, 115, 220));
    stockpanel.add(titre);
    titre.setBounds(200,5,800, 25);
    
    Font font2 = new Font("SansSerif", Font.BOLD, 20);
   titre.setFont(font2);
   titre.setForeground(new Color(201,220,100));
    this.add(lTitle);
    
    stockjtablepanel.setBounds(50,50,800,300);
    //interface de profil
 
    titreProfil.setBounds(300,280,800, 25);
    
    titreProfil.setFont(font2);
   titreProfil.setForeground(new Color(201,220,100));
   this.add(titreProfil);
  
    lNom.setBounds(350,320,100,20);
    this.add(lNom);
    lPrenom.setBounds(350,370,100,20);
    this.add(lPrenom);
    lLogin.setBounds(350,420,100,20);
    this.add(lLogin);
    lAncienneMtd.setBounds(350,470,150,20);
    this.add(lAncienneMtd);
    lNouveauMtd1.setBounds(350,520,150,20);
    this.add(lNouveauMtd1);
    lNouveauMtd2.setBounds(350,570,250,20);
    this.add(lNouveauMtd2);
    
    tNom.setBounds(650,320,150,25);
    this.add(tNom);
    tNom.addActionListener(this);
    tPrenom.setBounds(650,370,150,25);
    this.add(tPrenom);
    tPrenom.addActionListener(this);
    tLogin.setBounds(650,420,150,25);
    this.add(tLogin);
    tLogin.addActionListener(this);
    tAncienneMtd.setBounds(650,470,150,25);
    this.add(tAncienneMtd);
    tAncienneMtd.addActionListener(this);
    tNouveauMtd1.setBounds(650,520,150,25);
    this.add(tNouveauMtd1);
    tNouveauMtd1.addActionListener(this);
    tNouveauMtd2.setBounds(650,570,150,25);
    this.add(tNouveauMtd2);
    tNouveauMtd2.addActionListener(this);
    modifierProfilButton.setBounds(450,620,150,30);
    this.add(modifierProfilButton);
    modifierProfilButton.setBackground(Color.green);
    modifierProfilButton.addActionListener(this);
    
    profilVisible(false);
 
this.getContentPane().setBackground(new Color(50, 115, 220));
	  this.setLayout(null);
		this.setSize(1000,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,750);
		this.setResizable(false);
	}


	public static void main(String[] args) throws IOException {
          Chef i=new Chef(0);
	}
	public  void userVisible(boolean t) {
		UsrContainer.setVisible(t);
	  lTitle.setVisible(t);
	    lProduit.setVisible(t);
	    lFourniseur.setVisible(t);
	 lQuantite.setVisible(t);
	 boxProduit.setVisible(t);boxProduit1.setVisible(false);boxProduit2.setVisible(false);boxProduit3.setVisible(false);boxProduit4.setVisible(false);
	 boxFournisseur.setVisible(t);boxFournisseur1.setVisible(false);boxFournisseur2.setVisible(false);boxFournisseur3.setVisible(false);boxFournisseur4.setVisible(false);
	 textQuantite.setVisible(t);textQuantite1.setVisible(false);textQuantite2.setVisible(false);textQuantite3.setVisible(false);textQuantite4.setVisible(false);
	 commanderButton.setVisible(t);
	 add1.setVisible(t);add2.setVisible(false);add3.setVisible(false);add4.setVisible(false);
		    

	}
	public  void profilVisible(boolean t) {
		titreProfil.setVisible(t);
		 containerProfil.setVisible(t);
		   titreProfil.setVisible(t);
		    lNom.setVisible(t);
		     lPrenom.setVisible(t);
		    lLogin.setVisible(t);
		    lAncienneMtd.setVisible(t);
		   lNouveauMtd1.setVisible(t);
		    lNouveauMtd2.setVisible(t);

			    tNom.setVisible(t);
			     tPrenom.setVisible(t);
			    tLogin.setVisible(t);
			    tAncienneMtd.setVisible(t);
			   tNouveauMtd1.setVisible(t);
	
			   tNouveauMtd2.setVisible(t);
			    modifierProfilButton.setVisible(t);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add1) {
			boxProduit1.setVisible(true);
		    boxFournisseur1.setVisible(true);
		   textQuantite1.setVisible(true);
		   add2.setVisible(true);
		   ligne2=true;
		}
		if(e.getSource()==add2) {
			boxProduit2.setVisible(true);
		    boxFournisseur2.setVisible(true);
		   textQuantite2.setVisible(true);
		   add3.setVisible(true);
		   ligne3=true;
		}
		if(e.getSource()==add3) {
			boxProduit3.setVisible(true);
		    boxFournisseur3.setVisible(true);
		   textQuantite3.setVisible(true);
		   add4.setVisible(true);
		   ligne4=true;
		}
		if(e.getSource()==add4) {
			boxProduit4.setVisible(true);
		    boxFournisseur4.setVisible(true);
		   textQuantite4.setVisible(true);
		   ligne5=true;
		  
		}
		if(e.getSource()==commanderButton) {
			cmdEx.setCmd(this.idChef);
        	LEx.setLigneCmd(cmdEx.getMaxId(),boxProduit.getSelectedIndex(),Integer.parseInt(textQuantite.getText()), boxFournisseur.getSelectedIndex());
        	
	      if(ligne2==true) {
	        	LEx.setLigneCmd(cmdEx.getMaxId(),boxProduit1.getSelectedIndex(),Integer.parseInt(textQuantite1.getText()), boxFournisseur1.getSelectedIndex());
	        	ligne2=false;
	        }
	        if(ligne3==true) {
	        	LEx.setLigneCmd(cmdEx.getMaxId(),boxProduit2.getSelectedIndex(),Integer.parseInt(textQuantite2.getText()), boxFournisseur2.getSelectedIndex());
	       ligne3=false;
	        }
	        if(ligne4==true) {
	        	LEx.setLigneCmd(cmdEx.getMaxId(),boxProduit3.getSelectedIndex(),Integer.parseInt(textQuantite3.getText()), boxFournisseur3.getSelectedIndex());
	       ligne4=false;
	        }
	        if(ligne5==true) {
	        	LEx.setLigneCmd(cmdEx.getMaxId(),boxProduit4.getSelectedIndex(),Integer.parseInt(textQuantite4.getText()), boxFournisseur4.getSelectedIndex());
	        ligne5=false;
	        }
	        JOptionPane.showMessageDialog(null," votre commande est en cours de traitement");
		}
		 if(e.getSource()==deconnecter) {
				
	            Auth a=new Auth();
					this.dispose();
				 }
		 if(e.getSource()==commandeIcon) {
			 this.userVisible(true);
			 stockpanel.setVisible(false);
			 profilVisible(false);
		 }
		 if(e.getSource()==profilIcon) {
			 profilVisible(true);
			 userVisible(false);
			 stockpanel.setVisible(false);
			
			 tNom.setText(u.getNomById(idChef));
			  tPrenom.setText(u.getPrenomById(idChef));
			 tLogin.setText(u.getLoginById(idChef));

			     }
		 if(e.getSource()==this.modifierProfilButton) {
		 try {
		     if(tAncienneMtd.getText().equals(u.getMdpById(this.idChef)) && this.tNouveauMtd1.getText().equals(this.tNouveauMtd2.getText())) {
		    
		    	 u.updateChef(tNom.getText(),tPrenom.getText(),this.idChef,tLogin.getText(),tNouveauMtd1.getText());
		    	 JOptionPane.showMessageDialog(null,"vous avez modifer vos informations avec succées");
		     }
		     else if(!this.tNouveauMtd1.getText().equals(this.tNouveauMtd2.getText()))
		    	 JOptionPane.showMessageDialog(null,"les mots de passe ne sont pas identiques");
		     else JOptionPane.showMessageDialog(null,"retapez votre ancienne mot de passe"); 
		 }
		
		    	catch(Exception g) {
		    		g.printStackTrace();
		    	}
		 }
			 
		 }
			
		
		
		
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public class stockIconListener implements ActionListener
	{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			userVisible(false);
			 profilVisible(false);
			Connexion c=new Connexion();
			Cmd_externe x=new Cmd_externe();
			String[] tabe2= {"Produit","Quantité","Fournisseur","Date_CMD"};
		    
			stockpanel.setVisible(true);

			String [] columnsstock= {"ID command","Nom chef","Date","Etat"};
			String [][] TabStock=new String[x.getcountexcommand(idChef)][4];
			
			
			try {
				int i=0;
				Statement state = c.connecter().createStatement();
				ResultSet result = state.executeQuery("SELECT x.ID_CMD_EX,c.NOM_USR,x.DATE_CMD_EX,x.ETAT from java.cmd_externe x,java.utilisateur c where x.ID_CHEF=c.ID_USR and x.ID_CHEF="+idChef+" order by x.ID_CMD_EX DESC");
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
}
