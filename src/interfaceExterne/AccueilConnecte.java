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
		frame.setPreferredSize(new Dimension(740, 1280));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
 
		//Debut entete
		JPanel haut = new JPanel(new BorderLayout(0,0));
		haut.setPreferredSize(new Dimension(720,200));
		frame.add(haut);
 
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
		
		deconnexion = new JButton("Deconnexion");
		deconnexion.setSize(new Dimension(150,30));
		deconnexion.setLocation(170, 85);
		
		lblMenu.add(monCompte);
		lblMenu.add(deconnexion);
		
		JPanel entete = new JPanel(new GridLayout(1,1));
		entete.add(lblTitre);
		entete.add(lblMenu);
		haut.add(entete,BorderLayout.CENTER);
		
		// Fin entete
		
		//Debut accueil
		JPanel centre = new JPanel(new BorderLayout(10,10));
		centre.setPreferredSize(new Dimension(720,360));
		frame.add(centre);

		/****creation des éléments****/
		
		event = new JButton("Mes Evenements");
		event.setOpaque(true);
		event.setBackground(new Color(180,252,103));
		
		creerEvent = new JButton("Creer un Evenement");
		creerEvent.setOpaque(true);
		creerEvent.setBackground(new Color(132,225,33));
		
		operations = new JButton("Mes Operations");
		operations.setOpaque(true);
		operations.setBackground(new Color(105,197,6));		

		JPanel boutonMenu = new JPanel(new GridLayout(1,1));
		boutonMenu.add(event, BorderLayout.EAST);
		boutonMenu.add(creerEvent, BorderLayout.CENTER);
		boutonMenu.add(operations, BorderLayout.WEST);
		
		centre.add(boutonMenu,BorderLayout.CENTER);
		
		
		//Numéro 3
		JPanel panel3 = new JPanel(new BorderLayout(10,10));
		panel3.setPreferredSize(new Dimension(720,720));
		frame.add(panel3);

		/****creation des éléments****/
		final JLabel mesEvent = new JLabel("Mes évènements");
		mesEvent.setBackground(new Color(180,252,103));	
		mesEvent.setOpaque(true);
		mesEvent.setVisible(false);
		
		final JLabel creerEvenement = new JLabel("Créer évènements");
		creerEvenement.setBackground(new Color(132,225,33));
		creerEvenement.setOpaque(true);
		creerEvenement.setVisible(false);
		
		final JLabel mesOperations = new JLabel("Mes opérations");
		mesOperations.setBackground(new Color(105,197,6));
		mesOperations.setOpaque(true);
		mesOperations.setVisible(false);
				
		panel3.add(mesEvent, BorderLayout.CENTER);
		panel3.add(creerEvenement, BorderLayout.CENTER);
		panel3.add(mesOperations, BorderLayout.CENTER);
		
		event.addMouseListener(new MouseAdapter ()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				mesEvent.setVisible(true);
				creerEvenement.setVisible(false);
				mesOperations.setVisible(false);
			}
		});
		
		creerEvent.addMouseListener(new MouseAdapter ()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				mesEvent.setVisible(false);
				creerEvenement.setVisible(true);
				mesOperations.setVisible(false);
			}
		});
		
		operations.addMouseListener(new MouseAdapter ()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				mesEvent.setVisible(false);
				creerEvenement.setVisible(false);
				mesOperations.setVisible(true);
			}
		});
		
		frame.pack();
		frame.setVisible(true);
	}
}
