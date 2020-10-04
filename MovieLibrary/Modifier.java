import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Modifier extends JFrame
{//déclarer les variables
	
	private Film film;
	
	private JPanel JPconteneur2 = new JPanel();
	private JPanel JPcentre = new JPanel();
	private JPanel JPhaut = new JPanel();
	private JPanel JPbas = new JPanel();
	private JPanel JPsud = new JPanel();
	private JPanel JPimage = new JPanel();
	private JPanel JPdetail = new JPanel();
	
	private JTextField JTFtitre = new JTextField(10);
	private JTextField JTFdds = new JTextField(10);
	private JTextField JTFrealisateur = new JTextField(10);
	private JTextField JTFgenre1 = new JTextField(10);
	private JTextField JTFgenre2 = new JTextField(10);
	private JTextField JTFacteur = new JTextField(10);
	private JTextArea JTAsynopsis = new JTextArea(8,65);
	private JTextArea JTAavis = new JTextArea(8,65);
	private JTextField JTFnote = new JTextField(3);

    private static final String[] nombre = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9","10","11","12","13","14","15","16","17","18","19","20"};
    
	private ImageIcon icon = new ImageIcon();
	private JLabel JLimage = new JLabel(new ImageIcon("C:/Ayah/image3.png"));

	JComboBox<String> JCBnote = new JComboBox<String>(nombre);
	
	private JLabel JLtitre = new JLabel ("Titre: ");
	private JLabel JLdds = new JLabel ("Date de sortie: ");
	private JLabel JLrealisateur = new JLabel ("Realisateur: ");
	private JLabel JLgenre1 = new JLabel ("Genre 1: ");
	private JLabel JLgenre2 = new JLabel ("Genre 2: ");
	private JLabel JLacteur = new JLabel ("Acteur: ");
	private JLabel JLsynopsis = new JLabel ("Synopsis: ");
	private JLabel JLavis = new JLabel ("Avis personnel: ");
	private JLabel JLnotePersonnel = new JLabel ("Note personnel: ");
	private JLabel JLnote = new JLabel ("/20");
	
	private JButton JBenregistrer = new JButton("Enregistrer et fermer");

	public Modifier(Film film)
	{//ajouter les objets à la fenêtre, ajouter les layouts de chaque fenêtre, declarer les handlers et listeners
		super("Modifier");
		this.setSize(800,900);
		this.setContentPane(JPconteneur2);
		this.film = film;
		
		JPconteneur2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JPconteneur2.setLayout(new BorderLayout());
		JPcentre.setLayout(new GridLayout(2,0));
		JPhaut.setLayout(new GridLayout(0,2));
		JPbas.setLayout(new FlowLayout());
		JPdetail.setLayout(new GridLayout(7,0));
		JPimage.setLayout(new FlowLayout());
		JPsud.setLayout(new FlowLayout());
		
		JTFtitre.setText(film.getTitre());
		JTFdds.setText(film.getDate_de_sortie());
		JTFrealisateur.setText(film.getRealisateur());
		JTFgenre1.setText(film.getGenre1());
		JTFgenre2.setText(film.getGenre2());
		JTFacteur.setText(film.getActeur());
		JTAsynopsis.setText(film.getSynopsis());
		JTAavis.setText(film.getAvis());
		JTFnote.setText(film.getNote());
		
		JPconteneur2.add(JPcentre, BorderLayout.CENTER);
		JPconteneur2.add(JPsud, BorderLayout.SOUTH);
		JPcentre.add(JPhaut);
		JPcentre.add(JPbas);
		JPhaut.add(JPimage);
		JPhaut.add(JPdetail);
		JPdetail.add(JLtitre);
		JPdetail.add(JTFtitre);
		JPdetail.add(JLdds);
		JPdetail.add(JTFdds);
		JPdetail.add(JLrealisateur);
		JPdetail.add(JTFrealisateur);
		JPdetail.add(JLgenre1);
		JPdetail.add(JTFgenre1);
		JPdetail.add(JLgenre2);
		JPdetail.add(JTFgenre2);
		JPdetail.add(JLacteur);
		JPdetail.add(JTFacteur);
		
		JPimage.add(JLimage);
		
		JPbas.add(JLsynopsis);
		JPbas.add(JTAsynopsis);
		JPbas.add(JLavis);
		JPbas.add(JTAavis);
		JPbas.add(JLnotePersonnel);
		JPbas.add(JTFnote);
		JPbas.add(JLnote);
		
		JPsud.add(JBenregistrer);
		
   	 BoutonHandler handler = new BoutonHandler();
   	 
   	 JBenregistrer.addActionListener(handler);
		
	}//fin du constructeur Modifier
	
	private class BoutonHandler implements ActionListener
	{//les actions implementer lorsqu'on selectionne un bouton 
		public void actionPerformed (ActionEvent e)
		{
			JButton BoutonClique = (JButton) e.getSource();
			String labelBoutonClique = BoutonClique.getText();
			
			if (labelBoutonClique == "Enregistrer et fermer")
			{//enregistrer et fermer 
				Film f = new Film(JTFtitre.getText(), JTFdds.getText(), JTFrealisateur.getText(), JTFgenre1.getText(), JTFgenre2.getText(), 
						JTFacteur.getText(), JTAsynopsis.getText(), JTAavis.getText(), JTFnote.getText());
				Main.list.remove(film);
				Main.list.add(f);

				Enregistrer.openFile();
				Enregistrer.addRecords();
				Enregistrer.closeFile();
				setVisible(false);
			}//fin du if
		}//fin de la method actionPerfomed
		
	}//fin de la classe boutonhandler
	
}//fin de la classe modifier