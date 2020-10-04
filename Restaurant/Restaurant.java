import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restaurant extends JFrame{
	//JPanel
	private static JPanel conteneur =  new JPanel();//JPanel principal
	
	//les différentes sections
	private static JPanel contMenu = new JPanel(), contPizza = new JPanel(), contBreuvage = new JPanel(), Payer = new JPanel();
	
	//JLabel
	private final static JLabel labelMenu = new JLabel("<html>Menu <br/><br/> Pizza <br/> Petit: 6,79$ <br/> Moyen: 8,79$ <br/>"
		+ " Large: 9,49$ <br/> Extra: 10,29$ <br/> Fete: 15,99$ <br/><br/> Garniture <br/> Petit: 1,20$ <br/>"
		+ "	Moyen: 1,40$ <br/> Large: 1,60$ <br/> Extra: 1,80$ <br/> Fete: 2,30$ <br/><br/> Breuvage"
		+ " <br/> Pop: 1,10$ <br/> Jus: 1,35$ <br/> Eau: 1,00$ <html>");
	private final static JLabel emptyspace = new JLabel ("<html><br/><html>");
	private final static JLabel labPizza = new JLabel("Nombre de Pizza");
	private final static JLabel labGarniture = new JLabel("Nombre de Garniture");
    private final static JLabel labBreuvage = new JLabel("Breuvage");
    private final static JLabel taille = new JLabel("Taille");
	
    //JCheckBox
    private static JRadioButton radioPetit = new JRadioButton("Petit");
    private static JRadioButton radioMoyen = new JRadioButton("Moyen"); 
    private static JRadioButton radioLarge = new JRadioButton("Large"); 
    private static JRadioButton radioExlarge = new JRadioButton("Extra Large"); 
    private static JRadioButton radioFete = new JRadioButton("Fête"); 
    private static JRadioButton radiopop = new JRadioButton("Pop");
    private static JRadioButton radioeau = new JRadioButton("Eau");
    private static JRadioButton radiojus = new JRadioButton("Jus");
  
    //Tableau
     private static final String[] nombre = {"0", "1", "2", "3", "4", "5"};

    //JComboBox  
    private final JComboBox<String> PizzapetitJCB = new JComboBox<String> (nombre);
    private final JComboBox<String> PizzamoyenJCB= new JComboBox<String> (nombre);
    private final JComboBox<String> PizzalargeJCB = new JComboBox<String> (nombre);
    private final JComboBox<String> PizzaexlargeJCB = new JComboBox<String> (nombre);
    private final JComboBox<String> PizzafeteJCB = new JComboBox<String> (nombre);
  
    private final JComboBox<String> GarnpetitJCB = new JComboBox<String> (nombre);
    private final JComboBox<String> GarnmoyenJCB= new JComboBox<String> (nombre);
    private final JComboBox<String> GarnlargeJCB = new JComboBox<String> (nombre);
    private final JComboBox<String> GarnexlargeJCB = new JComboBox<String> (nombre);
    private final JComboBox<String> GarnfeteJCB = new JComboBox<String> (nombre);
   
    private final JComboBox<String> popJCB = new JComboBox<String> (nombre);
    private final JComboBox<String> eauJCB = new JComboBox<String> (nombre);
    private final JComboBox<String> jusJCB =new JComboBox<String> (nombre);
    
    //Bouton
    private static JButton ajouter = new JButton("Ajouter");
    private static JButton quitter = new JButton("Quitter");
    private static JButton payer = new JButton("Payer");
	public static JButton Fermer = new JButton("Fermer");
    
	public Restaurant() 
	{
		super("Restaurant");	
		this.setContentPane(conteneur);
		this.setSize(670,500);
		
		//initialiser les bordures des JPanel
		conteneur.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		contPizza.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		contBreuvage.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		
		//initialiser le type de layout pour chaque JPanel
		conteneur.setLayout(new BorderLayout());
		contMenu.setLayout(new FlowLayout());
		contPizza.setLayout(new GridLayout(6,3));
		contBreuvage.setLayout(new GridLayout(4, 0));
		Payer.setLayout(new FlowLayout());
		
		//ajouter un handler a tout les bouttons
        BoutonHandler handler2 = new BoutonHandler();
        ajouter.addActionListener(handler2);
        payer.addActionListener(handler2);
        quitter.addActionListener(handler2);
        Fermer.addActionListener(handler2);
        
        //ajouter des titres au JPanel
        contMenu.setBorder(new TitledBorder ("Menu"));
        contPizza.setBorder(new TitledBorder ("Pizza"));
        contBreuvage.setBorder(new TitledBorder (""));
        
        //ajouter les JPanels au JPanel principal
		conteneur.add(contMenu, BorderLayout.WEST);
		conteneur.add(contPizza, BorderLayout.CENTER);
		conteneur.add(contBreuvage, BorderLayout.EAST);
		conteneur.add(Payer, BorderLayout.SOUTH);
		
		//ajouter le menu
		contMenu.add(labelMenu);
		
		//ajouter les differentes composantes au JPanel du pizza
		contPizza.add(taille);
		contPizza.add(labPizza);
		contPizza.add(labGarniture);
		contPizza.add(radioPetit);
		contPizza.add(PizzapetitJCB);
		contPizza.add(GarnpetitJCB);
		contPizza.add(radioMoyen);
		contPizza.add(PizzamoyenJCB);
		contPizza.add(GarnmoyenJCB);
		contPizza.add(radioLarge);
		contPizza.add(PizzalargeJCB);
		contPizza.add(GarnlargeJCB);
		contPizza.add(radioExlarge);
		contPizza.add(PizzaexlargeJCB);
		contPizza.add(GarnexlargeJCB);
		contPizza.add(radioFete);
		contPizza.add(PizzafeteJCB);
		contPizza.add(GarnfeteJCB);
		
		//ajouter les differentes composantes au JPanel des boissons
		contBreuvage.add(labBreuvage);
		contBreuvage.add(emptyspace);
		contBreuvage.add(radiopop);
		contBreuvage.add(popJCB);
		contBreuvage.add(radioeau);
		contBreuvage.add(eauJCB);
		contBreuvage.add(radiojus);
		contBreuvage.add(jusJCB);
		
		//ajouter les boutons au JPanel Payer
		Payer.add(ajouter);
		Payer.add(payer);
		Payer.add(quitter);
	}//fin de la class Restaurant
	
	private class BoutonHandler implements ActionListener
	{//les actions implementer lorsqu'on selectionne un bouton 
		public void actionPerformed (ActionEvent e)
		{
			JButton BoutonClique = (JButton) e.getSource();
			String labelBoutonClique = BoutonClique.getText();
			
			if(labelBoutonClique == "Ajouter"){//ajouter les donnees lorsqu'on selectionne le bouton Ajouter
								
						if (radioPetit.isSelected())
						{
							Pizza petit = new Pizza("petit", PizzapetitJCB.getSelectedIndex(), GarnpetitJCB.getSelectedIndex());
							projet_main.listPizza.add(petit);
							PizzapetitJCB.setSelectedIndex(0);
							GarnpetitJCB.setSelectedIndex(0);
							radioPetit.setSelected(false);
						}//fin du if
						if (radioMoyen.isSelected())
						{
							Pizza moyen = new Pizza("moyen", PizzamoyenJCB.getSelectedIndex(), GarnmoyenJCB.getSelectedIndex());
							projet_main.listPizza.add(moyen);
							PizzamoyenJCB.setSelectedIndex(0);
							GarnmoyenJCB.setSelectedIndex(0);
							radioMoyen.setSelected(false);
						}//fin du if
						if (radioLarge.isSelected())
						{
							Pizza large = new Pizza("large", PizzalargeJCB.getSelectedIndex(), GarnlargeJCB.getSelectedIndex());
							projet_main.listPizza.add(large);
							PizzalargeJCB.setSelectedIndex(0);
							GarnlargeJCB.setSelectedIndex(0);
							radioLarge.setSelected(false);
						}//fin du if
						if (radioExlarge.isSelected())
						{
							Pizza exlarge = new Pizza("exlarge", PizzaexlargeJCB.getSelectedIndex(), GarnexlargeJCB.getSelectedIndex());
							projet_main.listPizza.add(exlarge);
							PizzaexlargeJCB.setSelectedIndex(0);
							GarnexlargeJCB.setSelectedIndex(0);
							radioExlarge.setSelected(false);
						}//fin du if
						if (radioFete.isSelected())
						{
							Pizza fete = new Pizza("fete", PizzafeteJCB.getSelectedIndex(), GarnfeteJCB.getSelectedIndex());
							projet_main.listPizza.add(fete);
							PizzafeteJCB.setSelectedIndex(0);
							GarnfeteJCB.setSelectedIndex(0);
							radioFete.setSelected(false);
						}//fin du if
						if (radiopop.isSelected())
						{
							Breuvage pop = new Breuvage("pop", popJCB.getSelectedIndex());
							projet_main.listBreuvage.add(pop);
							popJCB.setSelectedIndex(0);
							radiopop.setSelected(false);
						}//fin du if
						if (radioeau.isSelected())
						{
							Breuvage eau = new Breuvage("eau", eauJCB.getSelectedIndex());
							projet_main.listBreuvage.add(eau);
							eauJCB.setSelectedIndex(0);
							radioeau.setSelected(false);
						}//fin du if
						if (radiojus.isSelected())
						{
							Breuvage jus = new Breuvage("jus", jusJCB.getSelectedIndex());
							projet_main.listBreuvage.add(jus);
							jusJCB.setSelectedIndex(0);
							radiojus.setSelected(false);
						}//fin du if												
			}//fin de l'instruction if Ajouter
			
			else if(labelBoutonClique == "Quitter")
			{//quitter la fenetre de commande
					System.exit(0);
			}//fin de la 1ère l'instruction else if
			
			else if(labelBoutonClique == "Payer")
			{//afficher la fenetre de la facture
				projet_main.Afficher();				
				
			}//fin de la 2ème classe else if
		
			if (labelBoutonClique == "Fermer") 
			{//quitter la fenetre de la facture
				System.exit(0);
			}//fin du if
		}//fin de la methode actionPerformed
		
	}//fin de la classe BoutonHandler  
	
}//fin de la classe principale Restaurant