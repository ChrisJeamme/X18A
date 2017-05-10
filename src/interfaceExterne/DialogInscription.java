package interfaceExterne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class DialogInscription extends JDialog {
  private DialogInscriptionInfo zInfo = new DialogInscriptionInfo();
  private boolean sendData;
  private JLabel nomLabel, prenomLabel, emailLabel, pseudoLabel, mdpLabel;
  private JTextField nom, prenom, email, pseudo, mdp;

  public DialogInscription(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(550, 270);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.initComponent();
  }

  public DialogInscriptionInfo showZDialog(){
    this.sendData = false;
    this.setVisible(true);      
    return this.zInfo;      
  }

  private void initComponent(){

    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);
    panNom.setPreferredSize(new Dimension(220, 60));
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(100, 25));
    panNom.setBorder(BorderFactory.createTitledBorder("Nom"));
    nomLabel = new JLabel("Nom :");
    panNom.add(nomLabel);
    panNom.add(nom);

    JPanel panPrenom = new JPanel();
    panPrenom.setBackground(Color.white);
    panPrenom.setPreferredSize(new Dimension(220, 60));
    prenom = new JTextField();
    prenom.setPreferredSize(new Dimension(100, 25));
    panPrenom.setBorder(BorderFactory.createTitledBorder("Prenom"));
    prenomLabel = new JLabel("Prenom :");
    panPrenom.add(prenomLabel);
    panPrenom.add(prenom);
    
    JPanel panEmail = new JPanel();
    panEmail.setBackground(Color.white);
    panEmail.setPreferredSize(new Dimension(440, 60));
    email = new JTextField();
    email.setPreferredSize(new Dimension(200, 25));
    panEmail.setBorder(BorderFactory.createTitledBorder("E-mail"));
    emailLabel = new JLabel("E-mail :");
    panEmail.add(emailLabel);
    panEmail.add(email);
    
    JPanel panPseudo = new JPanel();
    panPseudo.setBackground(Color.white);
    panPseudo.setPreferredSize(new Dimension(220, 60));
    pseudo = new JTextField();
    pseudo.setPreferredSize(new Dimension(100, 25));
    panPseudo.setBorder(BorderFactory.createTitledBorder("Pseudo"));
    pseudoLabel = new JLabel("Pseudo :");
    panPseudo.add(pseudoLabel);
    panPseudo.add(pseudo);
    
    JPanel panMdp = new JPanel();
    panMdp.setBackground(Color.white);
    panMdp.setPreferredSize(new Dimension(240, 60));
    mdp = new JTextField();
    mdp.setPreferredSize(new Dimension(100, 25));
    panMdp.setBorder(BorderFactory.createTitledBorder("Mot de passe"));
    mdpLabel = new JLabel("Mot de passe :");
    panMdp.add(mdpLabel);
    panMdp.add(mdp);

    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panNom);
    content.add(panPrenom);
    content.add(panEmail);
    content.add(panPseudo);
    content.add(panMdp);

    JPanel control = new JPanel();
    JButton okBouton = new JButton("OK");
    
    okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {        
        zInfo = new DialogInscriptionInfo(nom.getText(), prenom.getText(), email.getText(), pseudo.getText() ,mdp.getText());
        setVisible(false);
      }    
    });

    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });

    control.add(okBouton);
    control.add(cancelBouton);

    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
}