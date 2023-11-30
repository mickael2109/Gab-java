package Frame_GAB;

import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Code {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int sommeArgent;
	String compteBanque;
	
	Menu listClient = new Menu();
	

	public Code() {
		this.Connexion();
	}
	
	
	public void Connexion() {
		try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_gab_ihm?useUnicode=true&userJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");   
        }
		 catch(ClassNotFoundException ex)
		 {
			 
		 }
	     catch(Exception e){
	        System.out.println(e);
	    }
	}
	
	
	
	public void login(JFrame frame, JTextField txtEmail, JPasswordField passwordField) {
		int id=0;
		String email = txtEmail.getText();
		String mdp = passwordField.getText();
		
		try {
			pst = con.prepareStatement("select * from client where emailCl=? and mdpCompteCl=?");
			pst.setString(1, email);
			pst.setString(2, mdp);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				pst = con.prepareStatement("select * from client where emailCl=?");
				pst.setString(1, email);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					id = rs.getInt("idCl");
				}
				
				frame.dispose();
				F_Consulter_Solde f = new F_Consulter_Solde();
				f.initialize(id);
				
			}else {
				JOptionPane.showMessageDialog(null, "Email ou Mot de Passe incorrecte, veuillez réssayer");
				txtEmail.setText("");
				passwordField.setText("");
				txtEmail.getCursor();
			}

				
		}catch (SQLException e1) {
			e1.printStackTrace();
			
		}catch(Exception e1){
	        System.out.println(e1);
	    } 
	}

	
	public void creerCompte(JFrame frame, JTextField txtNom, JTextField txtPrenom, JTextField txtAge, JTextField txtAdresse, JTextField txtCin, JTextField txtEmail, JTextField txtPhone, JComboBox banqueCl, JPasswordField mdp1, JPasswordField mdp2, JLabel lienPhoto) {
		int id=0;
		String nom = txtNom.getText();
		String prenom = txtPrenom.getText();
		int age = Integer.parseInt(txtAge.getText());
		String adresse = txtAdresse.getText();
		int cin = Integer.parseInt(txtCin.getText());
		String email = txtEmail.getText();
		int phone = Integer.parseInt(txtPhone.getText());
		String photo = lienPhoto.getText();
		String pass1 = mdp1.getText();
		String pass2 = mdp2.getText();
		
		int i = banqueCl.getSelectedIndex();
		String banqueClient = (String)banqueCl.getItemAt(i);
		
	
		if(nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || email.isEmpty() || pass1.isEmpty() || pass2.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuillez remplir les champs svp!", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}else if(age < 18) {
			JOptionPane.showMessageDialog(null, "Vous devez être +18ans pour avoir un compte bancaire", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}else if(!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "Veuillez bien comfirmer votre mot de passe", "ERREUR", JOptionPane.ERROR_MESSAGE);
			mdp1.setText("");
			mdp2.setText("");
		}else {
			try {
				/*
				 *  VERIFIE SI L'EMAIL EXISTE DEJA
				 */
				pst = con.prepareStatement("select * from client where emailCl=?");
				pst.setString(1, email);
				
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {	
					JOptionPane.showMessageDialog(null, "Cette compte email existe déjà, veuillez réssayer!", "ERREUR", JOptionPane.ERROR_MESSAGE);
					txtEmail.setText("");		
					
				}else {
					/*
					 *  INSERER LE NOUVEAU CLIENT
					 */
					pst = con.prepareStatement("insert into client (`nomCl`, `prenomCl`, `ageCl`, `emailCl`, `telCl`, `adresseCl`, `photoCl`, `cinCl`, `mdpCompteCl`, `banqueCl`) VALUES (?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, nom);
					pst.setString(2, prenom);
					pst.setInt(3, age);
					pst.setString(4, email);
					pst.setInt(5, phone);
					pst.setString(6, adresse);
					pst.setString(7, photo);
					pst.setInt(8, cin);
					pst.setString(9, pass1);
					pst.setString(10, banqueClient);
					
					pst.executeUpdate();
					
					
					/*
					 *  INSERER SON COMPTE BANCAIRE
					 */
					pst = con.prepareStatement("select * from client where emailCl=?");
					pst.setString(1, email);
					rs = pst.executeQuery();
					int idCl = 0;
					while(rs.next()) {
						idCl = rs.getInt("idCl");
					}
					
					pst = con.prepareStatement("insert into comptebancaire (`sommeArgent`, `pk_client`) VALUES (?,?)");
					pst.setInt(1, 500);
					pst.setInt(2, idCl);
					
					pst.executeUpdate();
					
					
					/*
					 * EFFACER LES VALEURS DANS TEXTFIELD
					 */
					txtNom.setText("");
					txtPrenom.setText("");
					txtAdresse.setText("");
					txtAge.setText("");
					txtCin.setText("");
					txtPhone.setText("");
					lienPhoto.setText("");
					mdp1.setText("");
					mdp2.setText("");
					
					JOptionPane.showMessageDialog(null, "Félicitation, votre compte est bien ajouté!!! \n Votre solde est de 500 Ar");
					frame.dispose();
					Accueil f = new Accueil();				
				}
					
			}catch (SQLException e1) {
				e1.printStackTrace();
				
			}catch(Exception e1){
		        System.out.println(e1);
		    } 
		}
	}
	
	
	
	@SuppressWarnings("resource")
	public void enLigne(int id, JLabel lblNom, JLabel lblPrenom, JLabel compteClient, JLabel lblSolde, JLabel numCompte) {
		String nom = null , prenom = null, adresse, email = null;
		int age, numCin, telCl, pk_Banque = 0;
		int sommeArgent = 0;
		String compteBanque = "";
		
		String idString = Integer.toString(id);
		
		try {
			pst = con.prepareStatement("select * from client where idCl=?");
			pst.setString(1, idString);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt("idCl");
				nom = rs.getString("nomCl");
				prenom = rs.getString("prenomCl");
				adresse = rs.getString("adresseCl");
				email = rs.getString("emailCl");
				age = rs.getInt("ageCl");
				numCin = rs.getInt("cinCl");
				telCl = rs.getInt("telCl");
				compteBanque = rs.getString("banqueCl");
				
				this.selectCompteBanque(id);
			}
			lblNom.setText(nom);
			lblPrenom.setText(prenom);
			lblSolde.setText(this.sommeArgent+"");
			numCompte.setText(id+"");
			compteClient.setText(compteBanque);
			

				
		}catch (SQLException e1) {
			e1.printStackTrace();
			
		}catch(Exception e1){
	        System.out.println(e1);
	    } 
	}

	
	

	public void information(int id, JLabel lblNom, JLabel lblPrenom, JLabel lblAge, JLabel lblEmail, JLabel lblPhone, JLabel lblAdresse, JLabel lblCin, JLabel nom2, JLabel prenom2, JLabel banqueCl, JLabel numCompte) {
		String nom = null , prenom = null, adresse=null, email = null, phone = null, cin = null, age = null, banque=null;
		
		String idString = Integer.toString(id);
		
		try {
			pst = con.prepareStatement("select * from client where idCl=?");
			pst.setString(1, idString);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				id      = rs.getInt("idCl");
				nom     = rs.getString("nomCl");
				prenom  = rs.getString("prenomCl");
				adresse = rs.getString("adresseCl");
				email   = rs.getString("emailCl");
				age     = rs.getString("ageCl");
				cin     = rs.getString("cinCl");
				phone   = rs.getString("telCl");
				banque  = rs.getString("banqueCl");
			}
			lblNom.setText(nom);
			lblPrenom.setText(prenom);
			lblAge.setText(age+" ans");
			lblEmail.setText(email);
			lblPhone.setText(phone);
			lblAdresse.setText(adresse);
			lblCin.setText(cin);
			banqueCl.setText(banque);
			
			nom2.setText(nom);
			prenom2.setText(prenom);
			numCompte.setText(id+"");
				
		}catch (SQLException e1) {
			e1.printStackTrace();
			
		}catch(Exception e1){
	        System.out.println(e1);
	    } 
	}
	
	
	public void infoVirement(int id, JLabel lblNom, JLabel lblPrenom, JLabel numCompte, JLabel lblSolde, JLabel lblCompteBancaire, JLabel lblCompte) {
		String nom = null , prenom = null, adresse=null, email = null, phone = null, cin = null, age = null, banque=null;
		
		String idString = Integer.toString(id);
		
		try {
			pst = con.prepareStatement("select * from client where idCl=?");
			pst.setString(1, idString);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				id      = rs.getInt("idCl");
				nom     = rs.getString("nomCl");
				prenom  = rs.getString("prenomCl");
				banque  = rs.getString("banqueCl");
				
				compteBanque = rs.getString("banqueCl");
				
				this.selectCompteBanque(id);
			}
			lblNom.setText(nom);
			lblPrenom.setText(prenom);
			numCompte.setText(id+"");
			lblCompte.setText(banque);
			lblSolde.setText(this.sommeArgent+"");
			lblCompteBancaire.setText(banque);
				
		}catch (SQLException e1) {
			e1.printStackTrace();
			
		}catch(Exception e1){
	        System.out.println(e1);
	    } 
	}

	
	
	public int selectCompteBanque(int idString) {
		try {
			pst = con.prepareStatement("select * from comptebancaire where pk_client=?");
			pst.setInt(1, idString);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				sommeArgent = rs.getInt("sommeArgent");		
			}
			
			this.sommeArgent = sommeArgent;
			
		}catch (SQLException e1) {
			e1.printStackTrace();
			
		}catch(Exception e1){
	        System.out.println(e1);
	    }
		return this.sommeArgent; 
	}

	
	public void modifierMdp(String idClient, JPasswordField pass1, JPasswordField pass2) {
		String mdp1 = pass1.getText();
		String mdp2 = pass2.getText();
		
		try {
			if(mdp1.equals(mdp2)) {
				pst = con.prepareStatement("update client set mdpCompteCl=? where idCl=?");
				pst.setString(1, mdp1);		
				pst.setString(2, idClient);			
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Votre mot de passe a été bien modifié!!!");
				
				pass1.setText("");
				pass2.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "Veuillez bien confirmer votre mot de passe!", "ERREUR", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void retirerArgent(int idClient, int montant, int solde, JFrame frame) {
		int m = montant;
		if(solde > montant) {
			try {
				montant = solde - montant;
				pst = con.prepareStatement("update comptebancaire set sommeArgent=? where pk_client=?");
				pst.setInt(1, montant);
				pst.setInt(2, idClient);
				
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Vous avez retiré "+montant+" Ar dans votre compte");
				
				frame.dispose();
				F_Consulter_Solde f = new F_Consulter_Solde();
				f.initialize(idClient);
				
				pst = con.prepareStatement("select * from client where idCl=?");
				pst.setInt(1, idClient);
				ResultSet rs = pst.executeQuery();
				
				String nom=null;
				String prenom=null;
				String banqueCl=null;
				while(rs.next()) {
					nom = rs.getString("nomCl");
					prenom = rs.getString("prenomCl");
					banqueCl = rs.getString("banqueCl");
				}
				
				Document doc = new Document();
				try {
					PdfWriter.getInstance(doc, new FileOutputStream("C:\\ticket_retrait.pdf"));
					doc.open();
					
					doc.add(new Paragraph("TICKET DEPOT GAB"));
					doc.add(new Paragraph(""));
					doc.add(new Paragraph(""));
					doc.add(new Paragraph("------------------------------------"));
					doc.add(new Paragraph("Nom : "+nom));
					doc.add(new Paragraph("Prénom : "+prenom));
					doc.add(new Paragraph("Banque : "+banqueCl));
					doc.add(new Paragraph(""));
					doc.add(new Paragraph("Solde Précèdent : "+solde+" Ar"));
					doc.add(new Paragraph("Argent retiré : "+m+" Ar"));
					doc.add(new Paragraph("Solde actuel : "+montant+" Ar"));
					doc.add(new Paragraph("------------------------------------"));
					doc.add(new Paragraph(""));
					doc.add(new Paragraph("Merci à vous!!!"));
					
					doc.close();
					JOptionPane.showMessageDialog(null, "Votre fichier ticket est placé dans E:\\ticket_depot.pdf (ticket_retrait.pdf)");
					Desktop.getDesktop().open(new File("C:\\ticket_retrait.pdf"));
					
				}catch(FileNotFoundException e){
					
				}catch(DocumentException e) {
					e.printStackTrace();
				}catch(MalformedURLException e) {
					
				}
				
				
				
			}catch (SQLException e1) {
				e1.printStackTrace();
				
			}catch(Exception e1){
		        System.out.println(e1);
		    }
		}else {
			JOptionPane.showMessageDialog(null, "Solde insuffisant, veuillez ressayer!", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	
	public void deposerArgent(int idClient, int montant, int solde, JFrame frame) {
		int m = montant;
		try {
			montant = solde + montant;
			pst = con.prepareStatement("update comptebancaire set sommeArgent=? where pk_client=?");
			pst.setInt(1, montant);
			pst.setInt(2, idClient);
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Vous avez déposé "+m+" Ar dans votre compte");
			
			
			pst = con.prepareStatement("select * from client where idCl=?");
			pst.setInt(1, idClient);
			ResultSet rs = pst.executeQuery();
			
			String nom=null;
			String prenom=null;
			String banqueCl=null;
			while(rs.next()) {
				nom = rs.getString("nomCl");
				prenom = rs.getString("prenomCl");
				banqueCl = rs.getString("banqueCl");
			}
			
			Document doc = new Document();
			try {
				PdfWriter.getInstance(doc, new FileOutputStream("C:\\ticket_depot.pdf"));
				doc.open();
				
				doc.add(new Paragraph("TICKET DEPOT GAB"));
				doc.add(new Paragraph(""));
				doc.add(new Paragraph(""));
				doc.add(new Paragraph("------------------------------------"));
				doc.add(new Paragraph("Nom : "+nom));
				doc.add(new Paragraph("Prénom : "+prenom));
				doc.add(new Paragraph("Banque : "+banqueCl));
				doc.add(new Paragraph(""));
				doc.add(new Paragraph("Solde Précèdent : "+solde+" Ar"));
				doc.add(new Paragraph("Argent déposé : "+m+" Ar"));
				doc.add(new Paragraph("Solde actuel : "+montant+" Ar"));
				doc.add(new Paragraph("------------------------------------"));
				doc.add(new Paragraph(""));
				doc.add(new Paragraph("Merci à vous!!!"));
				
				doc.close();
				JOptionPane.showMessageDialog(null, "Votre fichier ticket est placé dans le dossier document (ticket_depot.pdf)");
				Desktop.getDesktop().open(new File("C:\\ticket_depot.pdf"));
				
				
				
			}catch(FileNotFoundException e){
				
			}catch(DocumentException e) {
				e.printStackTrace();
			}catch(MalformedURLException e) {
				
			}
			
			
			frame.dispose();
			F_Consulter_Solde f = new F_Consulter_Solde();
			f.initialize(idClient);
			
		}catch (SQLException e1) {
			e1.printStackTrace();
			
		}catch(Exception e1){
	        System.out.println(e1);
	    }
	}

	
	public void menuListClient(int id, JLabel lblBanque, ArrayList<Menu> m, JSpinner spinner) {
		try {
			String b = lblBanque.getText();
			
			pst = con.prepareStatement("select * from client where banqueCl=? and idCl!=?");
			pst.setString(1, b);
			pst.setInt(2, id);
			rs = pst.executeQuery();

			listClient.deleteList(m);
			while(rs.next()) {
				listClient.addList(new Menu(rs.getInt(1), rs.getString(5)), m);
			}
		       
			spinner.setModel(new SpinnerListModel(m));
			
		}catch(SQLException e){
			 e.printStackTrace();
		}
	}
	
	
	public void virerArgent(String emailCl, int montant, JTextField txt, JLabel nomEnvoyeur, JLabel prenomEnvoyeur) {
		try {
			String nomEnv = nomEnvoyeur.getText();
			String prenomEnv = prenomEnvoyeur.getText();
			int idClientVire=0;
			int soldeClientVire=0;
			String nomCl=null, prenomCl=null;
			pst = con.prepareStatement("select * from client where emailCl=?");
			pst.setString(1, emailCl);
			rs = pst.executeQuery();

			while(rs.next()) {
				idClientVire = rs.getInt("idCl");
				nomCl = rs.getString("nomCl");
				prenomCl = rs.getString("prenomCl"); 
			}
			
			this.selectCompteBanque(idClientVire);
			soldeClientVire = this.sommeArgent + montant;
			
			pst = con.prepareStatement("update comptebancaire set sommeArgent=? where pk_client=?");
			pst.setInt(1, soldeClientVire);
			pst.setInt(2, idClientVire);
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Vous avez viré "+montant+" Ar à "+emailCl);
			
			txt.setText("");
			
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream("C:\\ticket_virement.pdf"));
			doc.open();
			
			doc.add(new Paragraph("TICKET VIREMENT D'ARGENT AU GAB"));
			doc.add(new Paragraph(""));
			doc.add(new Paragraph(""));
			doc.add(new Paragraph("-----------------------------------------------------------"));
			doc.add(new Paragraph("Valeur : "+montant+" Ar"));
			doc.add(new Paragraph("A : Mr/Mme/Mlle "+nomCl+" "+prenomCl));
			doc.add(new Paragraph("De : Mr/Mme/Mlle "+nomEnv+" "+prenomEnv));
			doc.add(new Paragraph("-----------------------------------------------------------"));
			doc.add(new Paragraph(""));
			doc.add(new Paragraph("Merci à vous!!!"));
			
			doc.close();
			JOptionPane.showMessageDialog(null, "Votre fichier ticket est placé dans C:\\ticket_virement.pdf (ticket_virement.pdf)");
			Desktop.getDesktop().open(new File("C:\\ticket_virement.pdf"));
				
			
		}catch(SQLException e){
			 e.printStackTrace();
		}catch(FileNotFoundException e){
			
		}catch(DocumentException e) {
			e.printStackTrace();
		}catch(MalformedURLException e) {
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void acceptNumberInTextField(JTextField tf) {
		tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if((input < '0'  || input >'9')  && input != '\b') {
					e.consume();
					JOptionPane.showMessageDialog(null, "Seul les chiffres peuvent être accepter", "ERREUR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}


	public void menuListBanque(String nomTable, JSpinner spinner) {
		try {
			pst = con.prepareStatement("select * from banque");
			rs = pst.executeQuery();
			
			while(rs.next()) {
				spinner.setModel(new SpinnerListModel(new String[] {"BOA", "BNI", "BFV"}));		
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
