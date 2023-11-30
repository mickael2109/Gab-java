package Frame_GAB;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.DefaultComboBoxModel;

public class F_creer_compte {

	private JFrame frame;

	JLabel lblTitre;
	private JTextField txtEmail;
	private JPasswordField mdp1;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAdresse;
	private JTextField txtCin;
	private JPasswordField mdp2;
	String path = null;
	File f = null;
	
	Code c = new Code();
	private JTextField txtAge;
	private JTextField txtPhone;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_creer_compte window = new F_creer_compte();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public F_creer_compte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setTitle("GAB");
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 515, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		/*
		 * 
		 *  BASE FRAME
		 * 
		 */
		JPanel panelGauche = new JPanel();
		panelGauche.setBackground(new Color(102, 102, 255));
		panelGauche.setBounds(0, 0, 6, 417);
		frame.getContentPane().add(panelGauche);
		panelGauche.setLayout(null);
		
		JPanel panelDroite = new JPanel();
		panelDroite.setLayout(null);
		panelDroite.setBackground(new Color(102, 102, 255));
		panelDroite.setBounds(503, 0, 6, 417);
		frame.getContentPane().add(panelDroite);
		
		JPanel panelBas = new JPanel();
		panelBas.setLayout(null);
		panelBas.setBackground(new Color(102, 102, 255));
		panelBas.setBounds(0, 410, 509, 7);
		frame.getContentPane().add(panelBas);
		
		
		
		/*
		 *  CONTENT
		 */
		JLabel lblNewLabel = new JLabel("Bienvenue  Mr / Mme / Mlle");
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(102, 102, 255));
		lblNewLabel.setBounds(16, 95, 247, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(44, 130, 419, 271);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("");
		txtEmail.setBounds(74, 165, 131, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(102, 102, 255));
		lblEmail.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblEmail.setBounds(10, 165, 71, 20);
		panel_1.add(lblEmail);
		
		JLabel lblMotDePassee = new JLabel("N.B : MDP (Mot de Passe)");
		lblMotDePassee.setForeground(new Color(204, 51, 51));
		lblMotDePassee.setFont(new Font("Lucida Console", Font.BOLD | Font.ITALIC, 10));
		lblMotDePassee.setBounds(10, 196, 195, 20);
		panel_1.add(lblMotDePassee);
		
		mdp1 = new JPasswordField();
		mdp1.setBounds(293, 159, 116, 20);
		panel_1.add(mdp1);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_4.setBackground(new Color(102, 102, 255));
		panel_4.setBounds(0, 0, 509, 84);
		frame.getContentPane().add(panel_4);
		
		lblTitre = new JLabel("GAB");
		lblTitre.setBounds(213, 11, 122, 47);
		panel_4.add(lblTitre);
		lblTitre.setForeground(SystemColor.text);
		lblTitre.setFont(new Font("Constantia", Font.BOLD, 25));
		
		JButton btnValider = new JButton("Cr\u00E9er");
		btnValider.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnValider.setForeground(SystemColor.windowBorder);
		btnValider.setBackground(SystemColor.menu);
		btnValider.setBounds(102, 237, 109, 23);
		panel_1.add(btnValider);
		
		JLabel lblVeuillezSauthentifier = new JLabel("Cr\u00E9er un compte");
		lblVeuillezSauthentifier.setBounds(153, 7, 124, 30);
		panel_1.add(lblVeuillezSauthentifier);
		lblVeuillezSauthentifier.setForeground(new Color(102, 102, 255));
		lblVeuillezSauthentifier.setFont(new Font("Cambria Math", Font.BOLD, 12));
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(SystemColor.windowBorder);
		btnAnnuler.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnAnnuler.setBackground(SystemColor.menu);
		btnAnnuler.setBounds(221, 237, 109, 23);
		panel_1.add(btnAnnuler);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(new Color(102, 102, 255));
		lblNom.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblNom.setBounds(10, 37, 71, 20);
		panel_1.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setToolTipText("");
		txtNom.setColumns(10);
		txtNom.setBounds(75, 37, 131, 20);
		panel_1.add(txtNom);
		
		txtPrenom = new JTextField();
		txtPrenom.setToolTipText("");
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(75, 68, 131, 20);
		panel_1.add(txtPrenom);
		
		txtAdresse = new JTextField();
		txtAdresse.setToolTipText("");
		txtAdresse.setColumns(10);
		txtAdresse.setBounds(75, 97, 131, 20);
		panel_1.add(txtAdresse);
		
		txtCin = new JTextField();
		txtCin.setText("0");
		txtCin.setToolTipText("");
		txtCin.setColumns(10);
		txtCin.setBounds(75, 131, 131, 20);
		panel_1.add(txtCin);
		c.acceptNumberInTextField(txtCin);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setForeground(new Color(102, 102, 255));
		lblPrnom.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblPrnom.setBounds(10, 71, 71, 20);
		panel_1.add(lblPrnom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setForeground(new Color(102, 102, 255));
		lblAdresse.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblAdresse.setBounds(10, 100, 71, 20);
		panel_1.add(lblAdresse);
		
		JLabel lblCin = new JLabel("CIN");
		lblCin.setForeground(new Color(102, 102, 255));
		lblCin.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblCin.setBounds(10, 134, 71, 20);
		panel_1.add(lblCin);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(102, 102, 255));
		lblAge.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblAge.setBounds(237, 40, 71, 20);
		panel_1.add(lblAge);
		
		JLabel lblBanque = new JLabel("Banque");
		lblBanque.setForeground(new Color(102, 102, 255));
		lblBanque.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblBanque.setBounds(237, 71, 71, 20);
		panel_1.add(lblBanque);
		
		JLabel lblLienPhoto = new JLabel("Lien photo");
		lblLienPhoto.setForeground(new Color(102, 102, 255));
		lblLienPhoto.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblLienPhoto.setBounds(237, 97, 93, 20);
		panel_1.add(lblLienPhoto);
		
		JLabel lblMdp = new JLabel("Mdp");
		lblMdp.setForeground(new Color(102, 102, 255));
		lblMdp.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblMdp.setBounds(237, 162, 71, 20);
		panel_1.add(lblMdp);
		
		JLabel lblCMdp = new JLabel("C. Mdp");
		lblCMdp.setForeground(new Color(102, 102, 255));
		lblCMdp.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblCMdp.setBounds(237, 196, 71, 20);
		panel_1.add(lblCMdp);
		
		mdp2 = new JPasswordField();
		mdp2.setBounds(295, 193, 114, 20);
		panel_1.add(mdp2);
		
		JButton btnParcourir = new JButton("Parcourir");
		btnParcourir.setBackground(SystemColor.control);
		btnParcourir.setBounds(320, 96, 89, 23);
		panel_1.add(btnParcourir);
		
		JComboBox txtBanque = new JComboBox();
		txtBanque.setModel(new DefaultComboBoxModel(new String[] {"BOA", "BNI", "BFV"}));
		txtBanque.setBounds(293, 68, 116, 20);
		panel_1.add(txtBanque);
		
		txtAge = new JTextField();
		txtAge.setText("0");
		txtAge.setToolTipText("");
		txtAge.setColumns(10);
		txtAge.setBounds(293, 37, 116, 20);
		panel_1.add(txtAge);
		c.acceptNumberInTextField(txtAge);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(102, 102, 255));
		lblPhone.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblPhone.setBounds(237, 128, 58, 20);
		panel_1.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setText("0");
		txtPhone.setToolTipText("");
		txtPhone.setColumns(10);
		txtPhone.setBounds(293, 131, 116, 20);
		panel_1.add(txtPhone);
		c.acceptNumberInTextField(txtPhone);
		
		JLabel lblLien = new JLabel("");
		lblLien.setForeground(SystemColor.menu);
		lblLien.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblLien.setBounds(258, 95, 124, 30);
		frame.getContentPane().add(lblLien);
		
		
		/* 
		 *  ACTION BTN
		 */
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Accueil f = new Accueil();
			}
		});
		
		

		btnParcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fch = new JFileChooser();
				FileNameExtensionFilter fnx = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
				fch.addChoosableFileFilter(fnx);
				int load = fch.showOpenDialog(null);
				if(load==fch.APPROVE_OPTION) {
					f = fch.getSelectedFile();
					path = f.getAbsolutePath();
					lblLien.setText(path);
				}
			}
		});
		
		

		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.creerCompte(frame, txtNom, txtPrenom, txtAge, txtAdresse, txtCin, txtEmail, txtPhone, txtBanque, mdp1, mdp2, lblLien);
			}
		});
	}
}
