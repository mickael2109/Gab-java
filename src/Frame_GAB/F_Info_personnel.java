package Frame_GAB;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class F_Info_personnel {

	private JFrame frame;
	private JPasswordField txtPass1;
	private JPasswordField txtPass2;
	JLabel lblNumCompte;
	
	Code c = new Code();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_Info_personnel window = new F_Info_personnel();
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
	public F_Info_personnel() {
		//initialize(0);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(int id) {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setTitle("GAB");
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 569, 397);
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
		panelGauche.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelGauche.setBackground(new Color(102, 102, 255));
		panelGauche.setBounds(0, 0, 190, 371);
		frame.getContentPane().add(panelGauche);
		panelGauche.setLayout(null);
		
		JButton btnConsulterSolde = new JButton("Consulter solde");
		btnConsulterSolde.setBounds(10, 113, 170, 23);
		panelGauche.add(btnConsulterSolde);
		btnConsulterSolde.setForeground(Color.WHITE);
		btnConsulterSolde.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnConsulterSolde.setBackground(new Color(102, 102, 255));
		
		JButton btnDposerArgent = new JButton("D\u00E9poser Argent");
		btnDposerArgent.setBounds(10, 157, 167, 23);
		panelGauche.add(btnDposerArgent);
		btnDposerArgent.setForeground(Color.WHITE);
		btnDposerArgent.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnDposerArgent.setBackground(new Color(102, 102, 255));
		
		JButton btnRetirerArgent = new JButton("Retirer Argent");
		btnRetirerArgent.setBounds(10, 200, 167, 23);
		panelGauche.add(btnRetirerArgent);
		btnRetirerArgent.setForeground(Color.WHITE);
		btnRetirerArgent.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnRetirerArgent.setBackground(new Color(102, 102, 255));
		
		JButton btnInfoPersonnel = new JButton("Info Personnel");
		btnInfoPersonnel.setBounds(10, 282, 167, 23);
		panelGauche.add(btnInfoPersonnel);
		btnInfoPersonnel.setForeground(Color.WHITE);
		btnInfoPersonnel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnInfoPersonnel.setBackground(new Color(102, 102, 255));
		
		JButton btnVirerArgent = new JButton("Virement");
		btnVirerArgent.setForeground(Color.WHITE);
		btnVirerArgent.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnVirerArgent.setBackground(new Color(102, 102, 255));
		btnVirerArgent.setBounds(10, 241, 167, 23);
		panelGauche.add(btnVirerArgent);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 11, 170, 23);
		panelGauche.add(lblNom);
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Cambria Math", Font.BOLD, 14));
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(10, 39, 170, 18);
		panelGauche.add(lblPrenom);
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Cambria Math", Font.BOLD, 12));
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(33, 339, 117, 23);
		panelGauche.add(btnQuitter);
		btnQuitter.setForeground(Color.WHITE);
		btnQuitter.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnQuitter.setBackground(new Color(102, 102, 255));
		
		JLabel lblNewLabel_1_1 = new JLabel("Compte :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 68, 68, 18);
		panelGauche.add(lblNewLabel_1_1);
		
		JLabel lblCompte = new JLabel("");
		lblCompte.setForeground(Color.WHITE);
		lblCompte.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblCompte.setBounds(75, 68, 88, 18);
		panelGauche.add(lblCompte);
		
		JLabel lblLogo = new JLabel("BOA - BNI - BFV");
		lblLogo.setFont(new Font("Cambria Math", Font.BOLD, 16));
		lblLogo.setForeground(new Color(102, 102, 255));
		lblLogo.setBounds(405, 4, 148, 38);
		frame.getContentPane().add(lblLogo);
		
		JPanel panelGauche_1 = new JPanel();
		panelGauche_1.setLayout(null);
		panelGauche_1.setBackground(new Color(102, 102, 255));
		panelGauche_1.setBounds(550, 0, 15, 371);
		frame.getContentPane().add(panelGauche_1);
		
		JPanel panelContent = new JPanel();
		panelContent.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelContent.setBounds(200, 53, 340, 304);
		frame.getContentPane().add(panelContent);
		panelContent.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nom :");
		lblNewLabel_1_1_1.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(10, 11, 56, 18);
		panelContent.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Pr\u00E9nom : ");
		lblNewLabel_1_1_1_1.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 34, 69, 18);
		panelContent.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Age : ");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(10, 58, 69, 18);
		panelContent.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Email :");
		lblNewLabel_1_1_1_1_2.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1_1_2.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_2.setBounds(10, 83, 69, 18);
		panelContent.add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("n\u00B0 phone :");
		lblNewLabel_1_1_1_1_3.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1_1_3.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_3.setBounds(10, 109, 69, 18);
		panelContent.add(lblNewLabel_1_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1_4 = new JLabel("Adresse :");
		lblNewLabel_1_1_1_1_4.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1_1_4.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_4.setBounds(10, 137, 69, 18);
		panelContent.add(lblNewLabel_1_1_1_1_4);
		
		JLabel lblNewLabel_1_1_1_1_5 = new JLabel("n\u00B0 CIN :");
		lblNewLabel_1_1_1_1_5.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1_1_5.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_5.setBounds(10, 163, 69, 18);
		panelContent.add(lblNewLabel_1_1_1_1_5);
		
		JLabel infoNom = new JLabel("");
		infoNom.setForeground(new Color(102, 102, 255));
		infoNom.setFont(new Font("Cambria Math", Font.BOLD, 12));
		infoNom.setBounds(53, 11, 164, 18);
		panelContent.add(infoNom);
		
		JLabel infoPrenom = new JLabel("");
		infoPrenom.setForeground(new Color(102, 102, 255));
		infoPrenom.setFont(new Font("Cambria Math", Font.BOLD, 12));
		infoPrenom.setBounds(76, 34, 141, 18);
		panelContent.add(infoPrenom);
		
		JLabel infoAge = new JLabel("");
		infoAge.setForeground(new Color(102, 102, 255));
		infoAge.setFont(new Font("Cambria Math", Font.BOLD, 12));
		infoAge.setBounds(53, 60, 164, 18);
		panelContent.add(infoAge);
		
		JLabel infoEmail = new JLabel("");
		infoEmail.setForeground(new Color(102, 102, 255));
		infoEmail.setFont(new Font("Cambria Math", Font.BOLD, 12));
		infoEmail.setBounds(63, 83, 154, 18);
		panelContent.add(infoEmail);
		
		JLabel infoPhone = new JLabel("");
		infoPhone.setForeground(new Color(102, 102, 255));
		infoPhone.setFont(new Font("Cambria Math", Font.BOLD, 12));
		infoPhone.setBounds(83, 109, 134, 18);
		panelContent.add(infoPhone);
		
		JLabel infoAdresse = new JLabel("");
		infoAdresse.setForeground(new Color(102, 102, 255));
		infoAdresse.setFont(new Font("Cambria Math", Font.BOLD, 12));
		infoAdresse.setBounds(76, 137, 141, 18);
		panelContent.add(infoAdresse);
		
		JLabel infoCin = new JLabel("");
		infoCin.setForeground(new Color(102, 102, 255));
		infoCin.setFont(new Font("Cambria Math", Font.BOLD, 12));
		infoCin.setBounds(63, 163, 154, 18);
		panelContent.add(infoCin);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Modifier Mot de passe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 186, 320, 107);
		panelContent.add(panel);
		panel.setLayout(null);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(SystemColor.controlHighlight);
		btnModifier.setBounds(127, 77, 88, 23);
		panel.add(btnModifier);
		
		JLabel lblNewLabel_1_1_1_1_6 = new JLabel("Mot de passe :");
		lblNewLabel_1_1_1_1_6.setBounds(9, 23, 88, 18);
		panel.add(lblNewLabel_1_1_1_1_6);
		lblNewLabel_1_1_1_1_6.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1_1_6.setFont(new Font("Cambria Math", Font.BOLD, 12));
		
		JLabel lblNewLabel_1_1_1_1_6_1 = new JLabel("Confirmer Mdp :");
		lblNewLabel_1_1_1_1_6_1.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1_1_6_1.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_6_1.setBounds(9, 48, 112, 18);
		panel.add(lblNewLabel_1_1_1_1_6_1);
		
		txtPass1 = new JPasswordField();
		txtPass1.setBounds(116, 22, 179, 20);
		panel.add(txtPass1);
		
		txtPass2 = new JPasswordField();
		txtPass2.setBounds(116, 47, 179, 20);
		panel.add(txtPass2);
		
		JLabel lblTitre = new JLabel("Information Personnel");
		lblTitre.setForeground(new Color(102, 102, 255));
		lblTitre.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lblTitre.setBounds(200, 14, 228, 23);
		frame.getContentPane().add(lblTitre);
		
		lblNumCompte = new JLabel("");
		lblNumCompte.setForeground(new Color(102, 102, 255));
		lblNumCompte.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNumCompte.setBounds(10, 97, 68, 18);
		panelGauche.add(lblNumCompte);
		
		c.information(id, infoNom, infoPrenom, infoAge, infoEmail, infoPhone, infoAdresse, infoCin, lblNom, lblPrenom, lblCompte, lblNumCompte);
		
		/*
		 *  ACTION BTN
		 */

		btnConsulterSolde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(lblNumCompte.getText());
				frame.dispose();
				F_Consulter_Solde f = new F_Consulter_Solde();
				f.initialize(i);
			}
		});
		
		btnDposerArgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(lblNumCompte.getText());
				frame.dispose();
				F_Deposer_Argent f = new F_Deposer_Argent();
				f.initialize(i);
			}
		});
		
		btnRetirerArgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(lblNumCompte.getText());
				frame.dispose();
				F_Retirer_Argent f = new F_Retirer_Argent();
				f.initialize(i);
			}
		});
		
		btnInfoPersonnel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(lblNumCompte.getText());
				frame.dispose();
				F_Info_personnel f = new F_Info_personnel();
				f.initialize(i);
			}
		});
		

		btnVirerArgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(lblNumCompte.getText());
				frame.dispose();
				F_Virement_Argent f = new F_Virement_Argent();
				f.initialize(i);
			}
		});
		
		
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i = lblNumCompte.getText();
				c.modifierMdp(i, txtPass1, txtPass2);
			}
		});
	}
}
