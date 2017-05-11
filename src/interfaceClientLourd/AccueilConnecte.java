package interfaceClientLourd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import donnees.Depense;
import donnees.Evenement;
import donnees.Utilisateur;
import gestionReseauClientLourd.InteractionServeurStatic;


/**
 * Contient la page d'accueil en étant connecté
 *
 */
public class AccueilConnecte
{		
		static JButton deconnexion;
		static JButton event;
		static JButton creerEvent;
		static JButton operations;
		private static JTextField nomEv, budgetEv;
		private static JLabel lblnomEv, lblbudgetEv;
		
	public static void lancerInterface()
	{			
		//On récupère la frame static
		JFrame frame = LancerInterface.frame;
		
		//Debut entete
		JPanel panel1 = new JPanel(new BorderLayout(0,0));
		panel1.setPreferredSize(new Dimension(880,200));
		frame.add(panel1);
			
		/****creation des elements****/
		JLabel lblMenu = new JLabel();
		lblMenu.setOpaque(true);
		lblMenu.setBackground(new Color(0,128,255));		
		lblMenu.setLocation(500,0);
							
		JLabel lblTitre = new JLabel();
		lblTitre.setOpaque(true);
		lblTitre.setBackground(new Color(0,128,255));
		lblTitre.setText("Deal With It                       Vous êtes connecté, "+AccueilNonConnecte.user.getPseudo());
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setVerticalAlignment(SwingConstants.CENTER);
							
		deconnexion = new JButton("Deconnexion");
		deconnexion.setSize(new Dimension(150,30));
		deconnexion.setLocation(170, 85);

		lblMenu.add(deconnexion);
							
		JPanel panel1b = new JPanel(new GridLayout(1,1));
		panel1b.add(lblTitre);
		panel1b.add(lblMenu);
		panel1.add(panel1b,BorderLayout.CENTER);
					
		// Fin entete
			
		//Definition des boutons	
			
		event = new JButton("Mes Evenements");
		event.setOpaque(true);
		event.setBackground(new Color(180,252,103));
					
		creerEvent = new JButton("Creer un Evenement");
		creerEvent.setOpaque(true);
		creerEvent.setBackground(new Color(132,225,33));
					
		operations = new JButton("Mes Operations");
		operations.setOpaque(true);
		operations.setBackground(new Color(105,197,6));
					
		//Debut accueil
		JPanel panel2 = new JPanel(new BorderLayout(10,10));
		panel2.setPreferredSize(new Dimension(880,250));
		frame.add(panel2);

		/****creation des elements****/
		JPanel panel2b = new JPanel(new GridLayout(1,1));
		panel2b.add(event, BorderLayout.EAST);
		panel2b.add(creerEvent, BorderLayout.CENTER);
		panel2b.add(operations, BorderLayout.WEST);
		panel2.add(panel2b,BorderLayout.CENTER);
					
		final JPanel mesEvent = new JPanel();
		mesEvent.setPreferredSize(new Dimension(880, 264));
		mesEvent.setOpaque(true);
		mesEvent.setBackground(new Color(180,252,103));
		
		/*Chargement des evenements*/
		
		String[] entetes = {"Nom de l'evenement", "Budget"};
 
        MesEvenements mesEvenements = new MesEvenements();
		ArrayList<Evenement> listeEvent = new ArrayList<>();
		listeEvent = mesEvenements.chargerEvenements();
		String donnees[][] = new String [listeEvent.size()][listeEvent.size()];
				
		int i=0;
		for(Evenement e : listeEvent)
		{
			String budget = Integer.toString(e.getBudget());
			donnees[i][0] = e.getNomEvenement();
	        donnees[i][1] = budget;
	        i++;
		}
		
		JTable tableau = new JTable(donnees, entetes);
        tableau.getColumnModel().getColumn(0).setPreferredWidth(300);
        tableau.getColumnModel().getColumn(1).setPreferredWidth(300);
        tableau.getTableHeader().setBackground(new Color(200,200,200));
        tableau.setBackground(new Color(150,150,150));
				
        mesEvent.add(tableau.getTableHeader(), BorderLayout.NORTH);
        mesEvent.add(tableau, BorderLayout.CENTER);
        /*Fin du chargement des evenements*/
        
        /*Creation des evenements*/
		
		final JPanel creerEvenement = new JPanel();
		creerEvenement.setOpaque(true);
		creerEvenement.setBackground(new Color(132,225,33));
		creerEvenement.setPreferredSize(new Dimension(880, 264));
	    nomEv = new JTextField();
	    nomEv.setPreferredSize(new Dimension(100, 25));
	    lblnomEv = new JLabel("Nom de l'evenement :");
	    creerEvenement.add(lblnomEv);
	    creerEvenement.add(nomEv);
	   
	    budgetEv = new JTextField();
	    budgetEv.setPreferredSize(new Dimension(100, 25));
	    lblbudgetEv = new JLabel("Budget :");
	    creerEvenement.add(lblbudgetEv);
	    creerEvenement.add(budgetEv);
	    
	    JButton validation = new JButton("Valider");
	    
	    validation.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent arg0)
	      {
	        String nomE = nomEv.getText();
	        String budgetE = budgetEv.getText();
	        Evenement ev = new Evenement(nomE, Integer.parseInt(budgetE));
	        InteractionServeurStatic.currentInteractionServeur.ajoutEvenement(ev);
	      }
     
	    });
	    
	    creerEvenement.add(lblbudgetEv);
	    creerEvenement.add(budgetEv);
	    creerEvenement.add(validation);
	    
	    /**************************************************************************************/
		
		/*Fin de creations des evenements*/
		
		final JPanel mesOperations = new JPanel();
		mesOperations.setPreferredSize(new Dimension(880, 264));
		mesOperations.setOpaque(true);
		mesOperations.setBackground(new Color(105,197,6));
		
		/*Chargement des operations*/
		
		String[] entetes2 = {"Date", "Description", "Montant"};
 
        MesOperations mesOps = new MesOperations();
		ArrayList<Depense> listeOps = new ArrayList<>();
		listeOps = mesOps.chargerOperations();
		String donnees2[][] = new String [listeOps.size()][listeOps.size()];
				
		int j=0;
		for(Depense d : listeOps)
		{
			String montant = Integer.toString(d.getMontant());
			donnees2[j][0] = d.getDate();
	        donnees2[j][1] = d.getDescription();
	        donnees2[j][2] = montant;
	        j++;
		}
		
		JTable tableau2 = new JTable(donnees2, entetes2);
		tableau2.getColumnModel().getColumn(0).setPreferredWidth(200);
        tableau2.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableau2.getColumnModel().getColumn(2).setPreferredWidth(200);
        tableau2.getTableHeader().setBackground(new Color(200,200,200));
        tableau2.setBackground(new Color(150,150,150));
				
        mesOperations.add(tableau2.getTableHeader(), BorderLayout.NORTH);
        mesOperations.add(tableau2, BorderLayout.CENTER);
        /*Fin du chargement des evenements*/
		
        JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(880,264));
		panel3.add(mesEvent,BorderLayout.CENTER);
		panel3.add(creerEvenement,BorderLayout.CENTER);
		panel3.add(mesOperations,BorderLayout.CENTER);
        frame.add(panel3);
		
		//mesEvent.setVisible(false);
		creerEvenement.setVisible(false);
		mesOperations.setVisible(false);
		
		event.addMouseListener(new MouseAdapter ()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				mesEvent.setVisible(true);
				creerEvenement.setVisible(false);
				mesOperations.setVisible(false);
			}
		});
		
		creerEvent.addMouseListener(new MouseAdapter ()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				mesEvent.setVisible(false);
				creerEvenement.setVisible(true);
				mesOperations.setVisible(false);
			}
		});
					
		operations.addMouseListener(new MouseAdapter ()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				mesEvent.setVisible(false);
				creerEvenement.setVisible(false);
				mesOperations.setVisible(true);
			}
		});
		
		deconnexion.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent arg0)
			  {
				 //On reset l'utilisateur 
				 AccueilNonConnecte.user = new Utilisateur();
				
				 System.out.println("Déconnecté");
				 AccueilConnecte.lancerInterface();
			  }         
		}); 
					
		frame.pack();
		frame.setVisible(true);
	}
}
