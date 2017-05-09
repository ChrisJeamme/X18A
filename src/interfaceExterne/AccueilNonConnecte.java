package interfaceExterne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class AccueilNonConnecte {
		static JButton connexion;		
		static JButton inscription;
		
	public static void main(String[] args) {
		
		//Création de la Frame
		JFrame frame = new JFrame("Deal With It");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);
		frame.setPreferredSize(new Dimension(900, 750));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0)); //pour inserer un panel au centre avec 20 pixels de margin H et V
 
		//Debut entete
		JPanel panel1 = new JPanel(new BorderLayout(0,0)); //panel principal à inserer 10 pour espacer entre WEST et CENTER, 20 pour espacer entre CENTER et SOUTH
		panel1.setPreferredSize(new Dimension(880,250));// taille preferee du panel principal
		frame.add(panel1);
 
		/****creation des éléments****/
 
		JLabel lblMenu = new JLabel();
		lblMenu.setOpaque(true);
		lblMenu.setBackground(new Color(0,128,255));		
		
		JLabel lblTitre = new JLabel();
		lblTitre.setOpaque(true);
		lblTitre.setBackground(new Color(0,128,255));
		lblTitre.setText("Deal With It");
		lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitre.setLocation(100,0);
		
		connexion = new JButton("Connexion");
		connexion.setSize(new Dimension(150,30));
		connexion.setLocation(0, 85);
		
		inscription = new JButton("Inscription");
		inscription.setSize(new Dimension(150,30));
		inscription.setLocation(170, 85);
		
		lblMenu.add(connexion);
		lblMenu.add(inscription);
		
		JPanel panel1b = new JPanel(new GridLayout(1,1));//panelWest à l'ouest du borderlayout. c'est une grille d'une colonne avec 4 lignes pour les labels
		panel1b.add(lblTitre);
		panel1b.add(lblMenu);
		panel1.add(panel1b,BorderLayout.CENTER);//ajout du panelWest au panel principal
		
		// Fin entete
		
		//Debut accueil
		JPanel panel2 = new JPanel(new BorderLayout(10,10)); //panel principal à inserer 10 pour espacer entre WEST et CENTER, 20 pour espacer entre CENTER et SOUTH
		panel2.setPreferredSize(new Dimension(880,500));// taille preferee du panel principal
		frame.add(panel2);

		/****creation des éléments****/
		
		JLabel labelMain = new JLabel();
		labelMain.setOpaque(true);
		labelMain.setBackground(new Color(105,197,6));
		labelMain.setText("Presentation");	
		labelMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelMain.setVerticalAlignment(SwingConstants.CENTER);
		
		connexion.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		        DialogConnexion zd = new DialogConnexion(null, "Connexion", true);
		        DialogConnexionInfo zInfo = zd.showZDialog(); 
		        JOptionPane jop = new JOptionPane();
		        jop.showMessageDialog(null, zInfo.toString(), "Connexion", JOptionPane.INFORMATION_MESSAGE);
		      }         
		    }); 
		
		JPanel panel2b = new JPanel(new GridLayout(1,1));//panelWest à l'ouest du borderlayout. c'est une grille d'une colonne avec 4 lignes pour les labels
		panel2b.add(labelMain);
		panel2.add(panel2b,BorderLayout.CENTER);//ajout du panelWest au panel principal		
		
		frame.pack();//java propose la meilleure taille en fonction des elements
		frame.setVisible(true);
	}
}
