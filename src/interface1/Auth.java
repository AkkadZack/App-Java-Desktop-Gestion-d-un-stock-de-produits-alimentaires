package interface1;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import admin.Admin;
import chef.Chef;
import interface2.I2;
import principale.Connexion;
import principale.Utilisateur;

public class Auth extends JFrame implements ActionListener {

	
	 private JPanel pan1=new JPanel();
	    private JLabel Username=new JLabel("Username :");
	    private JLabel Password=new JLabel("Password :");
	    private JTextField UsernameText=new JTextField();
	    private JPasswordField PasswordText=new JPasswordField();
	    private JButton SUBMIT=new JButton("SUBMIT");
	    private static JLabel lab=new JLabel();
	    private static JLabel lab2=new JLabel();
	public Auth() {
		 Image icon=new ImageIcon(this.getClass().getResource("/warehouse.jpg")).getImage();
			lab.setIcon(new ImageIcon(icon));
			Image icon1=new ImageIcon(this.getClass().getResource("/admin2.png")).getImage();
			lab2.setIcon(new ImageIcon(icon1));
				this.setSize(700,400);
				this.setTitle("LOGIN");
				pan1.setBackground(Color.white);
		     this.setContentPane(pan1);
		     pan1.setLayout(null);
		     pan1.add(Username);
		     Username.setBounds(400, 120, 100, 25);
		     pan1.add(Password);
		     Password.setBounds(400, 200, 100, 25);
		     pan1.add(UsernameText);
		     UsernameText.setBounds(400, 160, 150, 25);
		     UsernameText.setColumns(20);
		     pan1.add(PasswordText);
		     PasswordText.setBounds(400, 240, 150, 25);
		     PasswordText.setColumns(20);
		     pan1.add(SUBMIT);
		     SUBMIT.setBounds(422, 300, 100, 25);
		     SUBMIT.addActionListener(this);
	         pan1.add(lab);
	         lab.setBounds(25, 25, 300, 300);
	         pan1.add(lab2);
	         lab2.setBounds(420, 10, 100,100);
	         lab2.setBackground(new Color(200,200,200));
		     this.setLocationRelativeTo(null);
		     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     this.setVisible(true);
		     this.setResizable(false);
	}


	public static void main(String[] args) {
	Auth i=new Auth();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int count=0;
		int role=0;
		if(e.getSource()==SUBMIT) {
Utilisateur u=new Utilisateur();
			try {
				
				if(u.isExistByAuth(UsernameText.getText(),PasswordText.getText()) == true )
				{
				
					if(u.getRoleByAuth(UsernameText.getText(),PasswordText.getText())==1)
					{this.dispose();
						Admin interfaceadmin=new Admin();}
					else if(u.getRoleByAuth(UsernameText.getText(),PasswordText.getText())==2)
					{this.dispose();
						
						Chef interfaceChef=new Chef(u.getIdByAuth(UsernameText.getText(),PasswordText.getText()));}
				
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Username or password is incorrect");
				}
				
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,e1);			}
		}
			
		}
		
	}



