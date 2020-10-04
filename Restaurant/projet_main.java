import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class projet_main {
	//ArrayList
		public static ArrayList <Pizza> listPizza = new ArrayList<Pizza>(); 
		public static ArrayList <Breuvage> listBreuvage = new ArrayList<Breuvage>(); 
		private static JLabel prixTotal = new JLabel();
		
    public static void main(String[] args)
    {
    	Restaurant resto = new Restaurant();
         resto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         resto.setSize(670, 500);
         resto.setLocationRelativeTo(null);
         resto.setVisible(true);    
    }//fin de la classe main
    
    public static void Afficher() 
    {//methode pour afficher la facture
    	JTextArea payment = new JTextArea(30,40);
    	JScrollPane scroll = new JScrollPane(payment);
    	JFrame Payer = new JFrame();
    	Payer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Payer.setLocationRelativeTo(null);
    	Payer.setSize(500, 600);
    	Payer.setLayout(new FlowLayout());
    	Payer.setResizable(true);
    	Payer.setVisible(true);
        
    	scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		double paymentPizza = 0, paymentBreuvage = 0;
		String text = "Commande" + "\n";
		
		if(listPizza.size() != 0) {//ajouter les couts pour chaque pizza
			for (int i = 0; i<listPizza.size(); i++) {
				paymentPizza += listPizza.get(i).getPrix();
				text += listPizza.get(i).toString() + "\n";
			}//fin de la boucle for
		}//fin du if
		else {
			text += "Il n'y a aucune commande de pizza\n";
		}//fin du else
		
		if (listBreuvage.size() != 0) {//ajouter les couts pour chaque boissons
			for(int i = 0; i<listBreuvage.size(); i++) {
				paymentBreuvage += listBreuvage.get(i).getPrix();
				text += listBreuvage.get(i).toString() + "\n";
			}//fin de la boucle for
		}//fin du if
		else {
			text += "Il n'y a aucune commande de boisson\n";
		}//fin du else
		
		//calculer le prix total
		double total = (paymentPizza+paymentBreuvage)*(0.13) + (paymentPizza+paymentBreuvage);
		text += "\n" +"+Tax(13%)";
		
		//afficher le prix total
		prixTotal.setText(String.format("%s: $%,.2f", "Total: ", total));
		//ajouter les composantes a la fenetre payer
		payment.append(text);
		Payer.add(scroll);
		Payer.add(prixTotal);
		Payer.add(Restaurant.Fermer);
    }//fin de la methode Afficher 
    
}//fin de la classe projet_main