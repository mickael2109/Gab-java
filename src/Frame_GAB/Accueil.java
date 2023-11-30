package Frame_GAB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;


import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class Accueil {

	private JFrame frmGab;
	JLabel lblTitre;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	
	Code c = new Code();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
					window.frmGab.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Accueil() {
		initialize();
		this.random(lblTitre);
		
		JPanel panelGauche = new JPanel();
		panelGauche.setLayout(null);
		panelGauche.setBackground(new Color(102, 102, 255));
		panelGauche.setBounds(0, -49, 6, 417);
		frmGab.getContentPane().add(panelGauche);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 396, 509, 21);
		frmGab.getContentPane().add(panel);
		panel.setBackground(new Color(102, 102, 255));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGab = new JFrame();
		frmGab.getContentPane().setBackground(SystemColor.menu);
		frmGab.setTitle("GAB");
		frmGab.setType(Type.UTILITY);
		frmGab.setResizable(false);
		frmGab.setBounds(100, 100, 515, 441);
		frmGab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGab.getContentPane().setLayout(null);
		frmGab.setVisible(true);
		frmGab.setLocationRelativeTo(null);
		
		/*
		 * 
		 *  BASE FRAME
		 * 
		 */
		JPanel panelGauche = new JPanel();
		panelGauche.setBackground(new Color(102, 102, 255));
		panelGauche.setBounds(0, 0, 6, 417);
		frmGab.getContentPane().add(panelGauche);
		panelGauche.setLayout(null);
		
		JPanel panelDroite = new JPanel();
		panelDroite.setLayout(null);
		panelDroite.setBackground(new Color(102, 102, 255));
		panelDroite.setBounds(503, 0, 6, 417);
		frmGab.getContentPane().add(panelDroite);
		
		JPanel panelBas = new JPanel();
		panelBas.setLayout(null);
		panelBas.setBackground(new Color(102, 102, 255));
		panelBas.setBounds(0, 410, 509, 7);
		frmGab.getContentPane().add(panelBas);
		
		
		
		/*
		 *  CONTENT
		 */
		JLabel lblNewLabel = new JLabel("Bienvenue  Mr / Mme / Mlle");
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(102, 102, 255));
		lblNewLabel.setBounds(16, 95, 247, 35);
		frmGab.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(45, 158, 409, 199);
		frmGab.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(129, 53, 258, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(102, 102, 255));
		lblEmail.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblEmail.setBounds(27, 48, 71, 30);
		panel_1.add(lblEmail);
		
		JLabel lblMotDePassee = new JLabel("Mot de passe");
		lblMotDePassee.setForeground(new Color(102, 102, 255));
		lblMotDePassee.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblMotDePassee.setBounds(10, 84, 109, 30);
		panel_1.add(lblMotDePassee);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 89, 259, 20);
		panel_1.add(passwordField);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_4.setBackground(new Color(102, 102, 255));
		panel_4.setBounds(0, 0, 509, 84);
		frmGab.getContentPane().add(panel_4);
		
		lblTitre = new JLabel("GAB");
		lblTitre.setBounds(213, 11, 122, 47);
		panel_4.add(lblTitre);
		lblTitre.setForeground(SystemColor.text);
		lblTitre.setFont(new Font("Constantia", Font.BOLD, 25));
		
		JButton btnValider = new JButton("Connexion");
		btnValider.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnValider.setForeground(SystemColor.windowBorder);
		btnValider.setBackground(SystemColor.menu);
		btnValider.setBounds(153, 135, 143, 23);
		panel_1.add(btnValider);
		
		JLabel lblVeuillezSauthentifier = new JLabel("Authentification");
		lblVeuillezSauthentifier.setBounds(153, 7, 124, 30);
		panel_1.add(lblVeuillezSauthentifier);
		lblVeuillezSauthentifier.setForeground(new Color(102, 102, 255));
		lblVeuillezSauthentifier.setFont(new Font("Cambria Math", Font.BOLD, 12));
		
		JButton btnCrerCompte = new JButton("Cr\u00E9er compte");
		btnCrerCompte.setForeground(SystemColor.windowBorder);
		btnCrerCompte.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnCrerCompte.setBackground(SystemColor.menu);
		btnCrerCompte.setBounds(153, 165, 143, 23);
		panel_1.add(btnCrerCompte);
		
		

		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.login(frmGab, txtEmail, passwordField);
			}
		});
		

		btnCrerCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGab.dispose();
				F_creer_compte f = new F_creer_compte();
			}
		});
	}
	
	public void random(JLabel lbl) {
		Random rond = new Random();
		int rond_d1 = rond.nextInt(3);
		//System.out.println(rond_d1);
	}
}
