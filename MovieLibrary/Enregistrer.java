import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Enregistrer  
{//déclarer les variables
	
	private static ObjectOutputStream output;
	
	public static void openFile()
	{//ouvrir le dossier
		try
		{
			
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("bibliotheque.txt")));
		}//fin du try
		catch(IOException ioException)
		{
			System.err.println("Erreur a ouvrir le fichier.");
			System.exit(1);
		}//fin du catch
	}//fin de la methode openFiles2
	
	public static void addRecords()
	{//enregistrer les objets
			try 
			{//serialization de l'objet employe
				for(int i = 0; i<Main.list.size();i++) 
				{
					output.writeObject(Main.list.get(i));
				}//fin du for
			}//fin du try
			
			catch(IOException ioException) 
			{
				System.err.println("Erreur a ecrire dans le fichier. fin du programme");
			}//fin du catch
	}//fin de la methode addRecords
	
	public static void closeFile() 
	{//fermer le dossier
		try
		{
			if(output!=null)
				output.close();
		}//fin du try
		
		catch (IOException ioException)
		{
			System.err.println("Erreur a fermer le ficher.");
			System.exit(1);
		}//fin du catch
		
	}//fin de la methode closeFile2
	
}//fin de la classe Enregistrer