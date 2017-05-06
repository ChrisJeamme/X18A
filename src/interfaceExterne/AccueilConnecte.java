package interfaceExterne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AccueilConnecte {
		static JButton monCompte;		
		static JButton deconnexion;
		static JButton event;
		static JButton creerEvent;
		static JButton operations;
		
	public static void main(String[] args) {
		
		//Création de la Frame
		JFrame frame = new JFrame("Deal With It");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);
		frame.setPreferredSize(new Dimension(720, 1280));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0)); //pour inserer un panel au centre avec 20 pixels de margin H et V
 
		//Debut entete
		JPanel panel1 = new JPanel(new BorderLayout(0,0)); //panel principal à inserer 10 pour espacer entre WEST et CENTER, 20 pour espacer entre CENTER et SOUTH
		panel1.setPreferredSize(new Dimension(720,200));// taille preferee du panel principal
		frame.add(panel1);
 
		/****creation des éléments****/
 
		JLabel lblMenu = new JLabel();
		lblMenu.setOpaque(true);
		lblMenu.setBackground(new Color(0,128,255));		
		
		JLabel lblTitre = new JLabel();
		lblTitre.setOpaque(true);
		lblTitre.setBackground(new Color(0,128,255));
		lblTitre.setText("Deal With It");
		lblTitre.setLocation(100,0);
		
		monCompte = new JButton("Mon compte");
		monCompte.setSize(new Dimension(150,30));
		monCompte.setLocation(0, 85);
		
		deconnexion = new JButton("Déconnexion");
		deconnexion.setSize(new Dimension(150,30));
		deconnexion.setLocation(170, 85);
		
		lblMenu.add(monCompte);
		lblMenu.add(deconnexion);
		
		JPanel panel1b = new JPanel(new GridLayout(1,1));//panelWest à l'ouest du borderlayout. c'est une grille d'une colonne avec 4 lignes pour les labels
		panel1b.add(lblTitre);
		panel1b.add(lblMenu);
		panel1.add(panel1b,BorderLayout.CENTER);//ajout du panelWest au panel principal
		
		// Fin entete
		
		//Debut accueil
		JPanel panel2 = new JPanel(new BorderLayout(10,10)); //panel principal à inserer 10 pour espacer entre WEST et CENTER, 20 pour espacer entre CENTER et SOUTH
		panel2.setPreferredSize(new Dimension(720,360));// taille preferee du panel principal
		frame.add(panel2);

		/****creation des éléments****/
		
		event = new JButton("Mes évenements");
		event.setOpaque(true);
		event.setBackground(new Color(180,252,103));
		
		creerEvent = new JButton("Créer un évenement");
		creerEvent.setOpaque(true);
		creerEvent.setBackground(new Color(132,225,33));
		
		operations = new JButton("Mes opérations");
		operations.setOpaque(true);
		operations.setBackground(new Color(105,197,6));		

		JPanel panel2b = new JPanel(new GridLayout(1,1));//panelWest à l'ouest du borderlayout. c'est une grille d'une colonne avec 4 lignes pour les labels
		panel2b.add(event, BorderLayout.EAST);
		panel2b.add(creerEvent, BorderLayout.CENTER);
		panel2b.add(operations, BorderLayout.WEST);
		
		panel2.add(panel2b,BorderLayout.CENTER);//ajout du panelWest au panel principal
		
		
		//Numéro 3
		JPanel panel3 = new JPanel(new BorderLayout(10,10)); //panel principal à inserer 10 pour espacer entre WEST et CENTER, 20 pour espacer entre CENTER et SOUTH
		panel3.setPreferredSize(new Dimension(720,720));// taille preferee du panel principal
		frame.add(panel3);

		/****creation des éléments****/
			
		final JLabel creerEvenement = new JLabel();
		creerEvenement.setOpaque(true);
		creerEvenement.setBackground(new Color(132,225,33));
				
		final JPanel creerEventb = new JPanel(new GridLayout(1,1));//panelWest à l'ouest du borderlayout. c'est une grille d'une colonne avec 4 lignes pour les labels
		creerEventb.add(creerEvenement);
		panel3.add(creerEventb,BorderLayout.CENTER);//ajout du panelWest au panel principal
		
		final JLabel mesOperations = new JLabel();
		mesOperations.setOpaque(true);
		mesOperations.setBackground(new Color(105,197,6));
				
		final JPanel mesOperationsb = new JPanel(new GridLayout(1,1));//panelWest à l'ouest du borderlayout. c'est une grille d'une colonne avec 4 lignes pour les labels
		mesOperationsb.add(mesOperations);
		panel3.add(mesOperationsb,BorderLayout.CENTER);//ajout du panelWest au panel principal
		
		final JLabel mesEvent = new JLabel();
		mesEvent.setOpaque(true);
		mesEvent.setBackground(new Color(180,252,103));
				
		final JPanel mesEventb = new JPanel(new GridLayout(1,1));//panelWest à l'ouest du borderlayout. c'est une grille d'une colonne avec 4 lignes pour les labels
		mesEventb.add(mesEvent);
		panel3.add(mesEventb,BorderLayout.CENTER);//ajout du panelWest au panel principal
		
		event.addMouseListener(new MouseAdapter ()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				creerEventb.setVisible(false);
				creerEvenement.setVisible(false);
				mesOperationsb.setVisible(false);
				mesOperations.setVisible(false);
				mesEventb.setVisible(true);
				mesEvent.setVisible(true);
			}
		});
		
		creerEvent.addMouseListener(new MouseAdapter ()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				creerEventb.setVisible(true);
				creerEvenement.setVisible(true);
				mesOperationsb.setVisible(false);
				mesOperations.setVisible(false);
				mesEventb.setVisible(false);
				mesEvent.setVisible(false);
			}
		});
		
		operations.addMouseListener(new MouseAdapter ()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				creerEventb.setVisible(false);
				creerEvenement.setVisible(false);
				mesOperationsb.setVisible(true);
				mesOperations.setVisible(true);
				mesEventb.setVisible(false);
				mesEvent.setVisible(false);
			}
		});
		
		frame.pack();//java propose la meilleure taille en fonction des elements
		frame.setVisible(true);
	}
}
