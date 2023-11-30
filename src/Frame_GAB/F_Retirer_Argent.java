package Frame_GAB;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

public class F_Retirer_Argent {

	private JFrame frame;
	private JTextField txtArgentRetirer;
	JLabel lblNumCompte;
	
	Code c = new Code();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_Retirer_Argent window = new F_Retirer_Argent();
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
	public F_Retirer_Argent() {
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
		
		JPanel panelContent_1 = new JPanel();
		panelContent_1.setLayout(null);
		panelContent_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelContent_1.setBounds(10, 11, 320, 157);
		panelContent.add(panelContent_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Solde :");
		lblNewLabel_1_1_1.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1.setFont(new Font("Cambria Math", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(10, 29, 51, 18);
		panelContent_1.add(lblNewLabel_1_1_1);
		
		JLabel lblSolde = new JLabel("");
		lblSolde.setForeground(new Color(102, 102, 255));
		lblSolde.setFont(new Font("Cambria Math", Font.PLAIN, 12));
		lblSolde.setBounds(58, 29, 126, 18);
		panelContent_1.add(lblSolde);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Argent retirer :");
		lblNewLabel_1_1_1_1.setForeground(new Color(102, 102, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Cambria Math", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 68, 84, 18);
		panelContent_1.add(lblNewLabel_1_1_1_1);
		
		txtArgentRetirer = new JTextField();
		txtArgentRetirer.setBounds(98, 67, 126, 20);
		panelContent_1.add(txtArgentRetirer);
		txtArgentRetirer.setColumns(10);
		c.acceptNumberInTextField(txtArgentRetirer);
		
		JButton btnValider = new JButton("Retirer");
		btnValider.setBackground(SystemColor.menu);
		btnValider.setBounds(119, 123, 89, 23);
		panelContent_1.add(btnValider);
		
		JLabel lblTitre = new JLabel("Retrait");
		lblTitre.setForeground(new Color(102, 102, 255));
		lblTitre.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblTitre.setBounds(200, 14, 106, 23);
		frame.getContentPane().add(lblTitre);
		
		lblNumCompte = new JLabel("");
		lblNumCompte.setForeground(new Color(102, 102, 255));
		lblNumCompte.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNumCompte.setBounds(10, 97, 68, 18);
		panelGauche.add(lblNumCompte);
		
		
		
		JLabel lblAr = new JLabel("Ar");
		lblAr.setForeground(new Color(102, 102, 255));
		lblAr.setFont(new Font("Cambria Math", Font.PLAIN, 12));
		lblAr.setBounds(184, 31, 126, 18);
		panelContent_1.add(lblAr);
		
		c.enLigne(id, lblNom, lblPrenom, lblCompte, lblSolde, lblNumCompte);
		
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
		
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idClient = Integer.parseInt(lblNumCompte.getText());
				int montant = Integer.parseInt(txtArgentRetirer.getText());
				int solde = Integer.parseInt(lblSolde.getText());
				c.retirerArgent(idClient, montant, solde, frame);
			}
		});
		
		
	
	}
	
}
