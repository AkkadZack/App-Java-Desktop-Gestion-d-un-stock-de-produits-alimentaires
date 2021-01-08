package interface2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import principale.Utilisateur;
// fenetre vide
public class I2 extends JFrame{
	Utilisateur u=new Utilisateur();
   String[] t= {"ID","NOM","TEL","PRENOM","CNI"};
	JTable table=new JTable(u.getAllUsersTab(),t);
	public I2(){
		getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(table, BorderLayout.CENTER);
 
        pack();
		this.setSize(500,500);
		this.setVisible(true);
	}

public static void main(String[] args) throws ClassNotFoundException, SQLException {
	I2 i=new I2();

}
	

}
