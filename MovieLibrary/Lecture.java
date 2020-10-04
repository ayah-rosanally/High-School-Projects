import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lecture 
{//déclarer les variables
	private static ObjectInputStream input;
			
	
	public static void openFile()
	{//ouvrir le dossier
		try
		{	
			
				input = new ObjectInputStream(Files.newInputStream(Paths.get("bibliotheque.txt")));
			
		}//fin du try
		catch(IOException ioException)
		{
			System.err.println("Erreur a ouvrir le fichier.");
			System.exit(1);
		}//fin du catch
	}//fin de la methode openFiles1
	
	public static void readRecords()
	{//lire les objets
		
		try
		{
			while(true)
			{
				Film f = (Film) input.readObject();
				Main.list.add(f);
			}//fin du while
		}//fin du try
		catch(NullPointerException nullPointerException)
		{
			System.err.print("Aucun objet dans cette fiche");
		}//fin du catch
		catch (EOFException endOfFileException)
		{
			System.out.printf("%nFin des enregistrements%n");
		}//fin du catch
		catch(ClassNotFoundException classNotFoundException)
		{
			System.err.println("Objet invalide");
		}//fin du catch
		catch (IOException ioException)
		{
			System.err.println("Erreur de lecture a partir du fichier");
		}//fin du catch
	}//fin de la methode readRecords
	
	public static void closeFile()
	{//fermer le dossier
		try
		{
			if(input!=null)
				input.close();
		}//fin du try
		catch (IOException ioException)
		{
			System.err.println("Erreur a fermer le ficher.");
			System.exit(1);
		}//fin du catch
	}//fin de la methode closeFile
	
}//fin de la classe Lecture
