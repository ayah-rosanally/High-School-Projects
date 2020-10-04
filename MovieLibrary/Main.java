import java.util.ArrayList;

import javax.swing.JFrame;

public class Main 
{//déclarer les variables
	public static ArrayList <Film> list = new ArrayList<Film>();

	public static void main(String[] args) 
	{////afficher la fenêtre pour afficher la list
		Lecture.openFile();
		Lecture.readRecords();
		Lecture.closeFile();

		Bibliotheque biblio = new Bibliotheque();
		biblio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		biblio.setResizable(true);
		biblio.setLocationRelativeTo(null);
		biblio.setVisible(true);	
	}//fin du main
	
	public static void modifier(Film film) {
		Modifier modifier = new Modifier(film);
		modifier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modifier.setResizable(true);
		modifier.setLocationRelativeTo(null);
		modifier.setVisible(true);
	}//fin de la methode modifier
	
	public static void creer() {
		Creer creer = new Creer();
		creer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		creer.setResizable(true);
		creer.setLocationRelativeTo(null);
		creer.setVisible(true);
	}//fin de la methode creer

}//fin de la classe Main