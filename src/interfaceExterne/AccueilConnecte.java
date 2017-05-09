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
			
		JFrame frame = new JFrame();
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);
		frame.setPreferredSize(new Dimension(900, 750));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
							
		//Debut entete
		JPanel panel1 = new JPanel(new BorderLayout(0,0));
		panel1.setPreferredSize(new Dimension(880,200));
		frame.add(panel1);
			
		/****creation des éléments****/
		JLabel lblMenu = new JLabel();
		lblMenu.setOpaque(true);
		lblMenu.setBackground(new Color(0,128,255));		
		lblMenu.setLocation(500,0);
							
		JLabel lblTitre = new JLabel();
		lblTitre.setOpaque(true);
		lblTitre.setBackground(new Color(0,128,255));
		lblTitre.setText("Deal With It");
		lblTitre.setLocation(500,0);
							
		monCompte = new JButton("Mon compte");
		monCompte.setSize(new Dimension(150,30));
		monCompte.setLocation(0, 85);
					
		deconnexion = new JButton("Déconnexion");
		deconnexion.setSize(new Dimension(150,30));
		deconnexion.setLocation(170, 85);
					
		lblMenu.add(monCompte);
		lblMenu.add(deconnexion);
							
		JPanel panel1b = new JPanel(new GridLayout(1,1));
		panel1b.add(lblTitre);
		panel1b.add(lblMenu);
		panel1.add(panel1b,BorderLayout.CENTER);
					
		// Fin entete
			
		//Definition des boutons	
			
		event = new JButton("event");
		event.setOpaque(true);
		event.setBackground(new Color(180,252,103));
					
		creerEvent = new JButton("creerEvent");
		creerEvent.setOpaque(true);
		creerEvent.setBackground(new Color(132,225,33));
					
		operations = new JButton("operations");
		operations.setOpaque(true);
		operations.setBackground(new Color(105,197,6));
					
		//Debut accueil
		JPanel panel2 = new JPanel(new BorderLayout(10,10));
		panel2.setPreferredSize(new Dimension(880,250));
		frame.add(panel2);

		/****creation des éléments****/
		JPanel panel2b = new JPanel(new GridLayout(1,1));
		panel2b.add(event, BorderLayout.EAST);
		panel2b.add(creerEvent, BorderLayout.CENTER);
		panel2b.add(operations, BorderLayout.WEST);
		panel2.add(panel2b,BorderLayout.CENTER);
					
		final JLabel mesEvent = new JLabel("event");
		mesEvent.setOpaque(true);
		mesEvent.setBackground(new Color(180,252,103));
		mesEvent.setPreferredSize(new Dimension(880, 264));
					
		final JLabel creerEvenement = new JLabel("creerEvent");
		creerEvenement.setOpaque(true);
		creerEvenement.setBackground(new Color(132,225,33));
		creerEvenement.setPreferredSize(new Dimension(880, 264));
					
		final JLabel mesOperations = new JLabel("operations");
		mesOperations.setOpaque(true);
		mesOperations.setBackground(new Color(105,197,6));
		mesOperations.setPreferredSize(new Dimension(880, 264));
					
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(880,264));
		panel3.add(mesEvent,BorderLayout.CENTER);
		panel3.add(creerEvenement,BorderLayout.CENTER);
		panel3.add(mesOperations,BorderLayout.CENTER);
					
		frame.add(panel3);
				
		mesEvent.setVisible(false);
		creerEvenement.setVisible(false);
		mesOperations.setVisible(false);
		
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
