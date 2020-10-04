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

public class Bibliotheque extends JFrame
{//déclarer les variables

	private JPanel JPconteneur = new JPanel();
	private JPanel JPwest = new JPanel();
	private JPanel JPcentre = new JPanel();
	private JPanel JPSynopsisAvisNote = new JPanel();
	private JPanel JPSynopsis = new JPanel();
	private JPanel JPAvis = new JPanel();
	private JPanel JPrecherche = new JPanel();
	private JPanel JPrecherche_titre = new JPanel();
	private JPanel JPrecherche_button = new JPanel();
	private JPanel JPlist = new JPanel();
	private JPanel JPfiche = new JPanel();
	private JPanel JPimage = new JPanel();
	private JPanel JPficheTitreDetail = new JPanel();
	private JPanel JPficheTitre = new JPanel();
	private JPanel JPficheDetail = new JPanel();
		
	private JButton bt_effacer_recherche = new JButton("Effacer les criteres");
	private JButton bt_recherche = new JButton("Recherche");
	private JButton bt_supprimer = new JButton("Supprimer cette fiche");
	private JButton bt_nouvelle_fiche = new JButton("Creer une nouvelle fiche");
	private JButton bt_maj_fiche = new JButton("Modifier cette fiche");
	
	private JLabel lbl_titre_recherche = new JLabel("Titre");
	private JLabel lbl_titre_fiche = new JLabel("");
	private JLabel lbl_date_sortie_fiche = new JLabel("Date de sortie:");
	private JLabel lbl_realisateur_fiche = new JLabel("Realisateur:");
	private JLabel lbl_genre1_fiche = new JLabel("Genre 1:");
	private JLabel lbl_genre2_fiche = new JLabel("Genre 2:");
	private JLabel lbl_acteur_fiche = new JLabel("Acteur:");
	private JLabel lbl_note_personnel_fiche = new JLabel("Note personnel: ");
	private JLabel lbl_dds_fiche = new JLabel("");
	private JLabel lbl_real_fiche = new JLabel("");
	private JLabel lbl_g1_fiche = new JLabel("");
	private JLabel lbl_g2_fiche = new JLabel("");
	private JLabel lbl_act_fiche = new JLabel("");
	private JLabel lbl_np_fiche = new JLabel("/20");
	private JLabel image_fiche = new JLabel(new ImageIcon("C:/Users/AN/Desktop/eclipse-workspace/ICS4U_ProjetExam/image.png"));
	
	public static DefaultListModel<String> listModel = new DefaultListModel();
	private JList jlist_film = new JList(listModel);
	
	private ImageIcon icon = new ImageIcon();
	
	private JTextField txt_titre = new JTextField(10); 
	
    private JTextArea JTAsynopsis = new JTextArea (11, 46);
    private JTextArea JTAavis_personnel = new JTextArea (9, 38);
    
	private JScrollPane synopsisScrollable2 = new JScrollPane(JTAsynopsis);
	private JScrollPane avisScrollable3 = new JScrollPane(JTAavis_personnel);
	private JScrollPane listScroller = new JScrollPane(jlist_film);
	
    public Bibliotheque() 
    {//ajouter les objets à la fenêtre, ajouter les layouts de chaque fenêtre, declarer les handlers et listeners
    super("Bibliotheque");
    this.setSize(900,1000);
	this.setContentPane(JPconteneur);

		JPconteneur.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		jlist_film.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlist_film.setLayoutOrientation(JList.VERTICAL);
		jlist_film.setVisibleRowCount(0);
		
		listScroller.setPreferredSize(new Dimension(250,360));
		
    	JPconteneur.setLayout(new BorderLayout());
    	JPwest.setLayout(new GridLayout(2,0));
    	JPcentre.setLayout(new GridLayout(2,0));
    	JPfiche.setLayout(new GridLayout(0,2));
    	JPSynopsisAvisNote.setLayout(new GridLayout(2,0));
    	JPSynopsis.setLayout(new FlowLayout());
    	JPAvis.setLayout(new FlowLayout());
    	JPrecherche.setLayout(new GridLayout(2,0));
    	JPrecherche_titre.setLayout(new FlowLayout());
    	JPrecherche_button.setLayout(new FlowLayout());
    	JPimage.setLayout(new FlowLayout());
    	JPficheTitreDetail.setLayout(new BorderLayout());
    	JPficheTitre.setLayout(new FlowLayout());
    	JPficheDetail.setLayout(new GridLayout(5,0));
    	
    	JPconteneur.add(JPwest, BorderLayout.WEST);
    	JPconteneur.add(JPcentre, BorderLayout.CENTER);
    	JPcentre.add(JPfiche);
    	JPcentre.add(JPSynopsisAvisNote);
    	JPwest.add(JPrecherche);
    	JPwest.add(JPrecherche_button);
    	JPwest.add(JPlist);
    	JPfiche.add(JPimage);
    	JPfiche.add(JPficheTitreDetail);
    	JPficheTitreDetail.add(JPficheTitre, BorderLayout.NORTH);
    	JPficheTitreDetail.add(JPficheDetail, BorderLayout.CENTER);
    	JPSynopsisAvisNote.add(JPSynopsis);
    	JPSynopsisAvisNote.add(JPAvis);
    	
    	JPrecherche.setBorder(new TitledBorder ("Recherche"));
        JPfiche.setBorder(new TitledBorder ("Fiche detailee"));
    	JPlist.setBorder(new TitledBorder("Liste des films"));
    	JPSynopsis.setBorder(new TitledBorder("Synopsis"));
    	JPAvis.setBorder(new TitledBorder("Avis Personnel"));
    	
    	listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    	listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	synopsisScrollable2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    	synopsisScrollable2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	avisScrollable3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    	avisScrollable3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	
    	JPrecherche.add(JPrecherche_titre);
    	JPrecherche.add(JPrecherche_button);
    	JPrecherche_titre.add(lbl_titre_recherche);
    	JPrecherche_titre.add(txt_titre);
    	JPrecherche_button.add(bt_effacer_recherche);
    	JPrecherche_button.add(bt_recherche);
    	JPlist.add(listScroller);
    	
    	JPficheTitre.add(lbl_titre_fiche);
    	JPficheDetail.add(lbl_date_sortie_fiche);
    	JPficheDetail.add(lbl_dds_fiche);
    	JPficheDetail.add(lbl_realisateur_fiche);
    	JPficheDetail.add(lbl_real_fiche);
    	JPficheDetail.add(lbl_genre1_fiche);
    	JPficheDetail.add(lbl_g1_fiche);
    	JPficheDetail.add(lbl_genre2_fiche);
    	JPficheDetail.add(lbl_g2_fiche);
    	JPficheDetail.add(lbl_acteur_fiche);
    	JPficheDetail.add(lbl_act_fiche);
    	
    	JPimage.add(image_fiche);
    	
    	JPSynopsis.add(synopsisScrollable2);
    	JPAvis.add(avisScrollable3);
    	JPAvis.add(lbl_note_personnel_fiche);
    	JPAvis.add(lbl_np_fiche);
    	JPAvis.add(bt_supprimer);
    	JPAvis.add(bt_nouvelle_fiche);
    	JPAvis.add(bt_maj_fiche);
    	
    	 BoutonHandler handler = new BoutonHandler();
    	 listSelectionListener listener = new listSelectionListener();
    	 
    	 bt_effacer_recherche.addActionListener(handler);
    	 bt_recherche.addActionListener(handler);
    	 bt_supprimer.addActionListener(handler);
    	 bt_nouvelle_fiche.addActionListener(handler);
    	 bt_maj_fiche.addActionListener(handler);
    	 jlist_film.addListSelectionListener(listener);
    	
    }//methode Film
    
    private class BoutonHandler implements ActionListener
	{//les actions implementer lorsqu'on selectionne un bouton 
		public void actionPerformed (ActionEvent e)
		{//programmer les boutons dans la fenêtre compagnie
			JButton BoutonClique = (JButton) e.getSource();
			String labelBoutonClique = BoutonClique.getText();
			
			if(labelBoutonClique == "Recherche") 
			{//rechercher le film en question dans le arraylist et afficher les options dans le jlist	
				
					if(listModel.size() != 0) 
					{//s'il y a des elements dans le listModel, effacer tous
					listModel.clear();
					}
					String titre = txt_titre.getText();
	 				for(int i = 0; i< Main.list.size(); i++) 
	 				{
	 					if (titre.equals(Main.list.get(i).getTitre())) 
	 					{
	 						listModel.addElement(Main.list.get(i).getTitre());
	 					}//fin du if
	 				}//fin de la boucle for			
 			}//fin du if 
			
			if(labelBoutonClique == "Effacer les criteres") 
			{//effacer les criteres dans le textfield
				txt_titre.setText("");
			}//fin du if
			
			if(labelBoutonClique == "Supprimer cette fiche") 
			{//supprimer la fiche du arraylist
				String nom = lbl_titre_fiche.getText();
				for (int i = 0; i< Main.list.size(); i++) 
				{
					if (nom.equals(Main.list.get(i).getTitre())) 
					{
						Main.list.remove(i);
					}//fin du if
				}//fin du for
				Enregistrer.openFile();
				Enregistrer.addRecords();
				Enregistrer.closeFile();
			}//fin du if
			
			if (labelBoutonClique == "Modifier cette fiche") 
			{//modifier une fiche dans le arraylist
				
				try {
						String nom = lbl_titre_fiche.getText();
						Film Fmodifier = null;
						for (int i = 0; i< Main.list.size(); i++) {
							if (nom.equals(Main.list.get(i).getTitre())) {
								 Fmodifier = Main.list.get(i);
							}//fin du if
						}//fin du for
						Main.modifier(Fmodifier);
				}//fin du try
				catch(NullPointerException npException) {
					System.err.println("Vous n'avez pas selectionne une fiche");
				}//fin du catch
			}//fin du if
			
			if(labelBoutonClique == "Creer une nouvelle fiche") {
				Main.creer();
			}//fin du if
		}//fin de methode actionPerformed
	}//fin de la classe BoutonHandler
    
    private class listSelectionListener implements ListSelectionListener 
    {
    	 public void valueChanged(ListSelectionEvent e) {
    	try {
		 			if(e.getValueIsAdjusting() == false) {
		 				int index = jlist_film.getSelectedIndex();
		 				String nom = listModel.get(index);
					
					Film f = null; 
					for (int i = 0; i< Main.list.size(); i++) {
						if (nom.equals( Main.list.get(i).getTitre())) {
							 f = Main.list.get(i);
						}//fin du if
					}//fin du for
					
					lbl_titre_fiche.setText(f.getTitre());
					lbl_dds_fiche.setText(f.getDate_de_sortie());
					lbl_real_fiche.setText(f.getRealisateur());
					lbl_g1_fiche.setText(f.getGenre1());
					lbl_g2_fiche.setText(f.getGenre2());
					lbl_act_fiche.setText(f.getActeur());
					JTAsynopsis.setText(f.getSynopsis());
					JTAavis_personnel.setText(f.getAvis());
					lbl_np_fiche.setText(f.getNote());
		 				
		 			}//fin du if
    		 }//fin du try
    		 catch(ArrayIndexOutOfBoundsException AIOOBException) {
    		 }//fin du catch
    	 }//fin de la methode valueChanged
    	 
    }//fin de la classe listSelectionListener
    
}//fin de la classe Bibliotheque