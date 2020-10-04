public class Pizza {
	private int nombre;
	private String type;
	private int garn;
	private double prix;
	
	public Pizza(String type, int nombre, int garn) {
		this.garn = garn;
		this.type = type;
		this.nombre = nombre; 		 
	}//fin du constructeur Pizza
	
	public double getPrix() {
		if (type == "petit"){
			prix = 6.79*nombre + 1.20*garn*nombre; 
		}//fin du if
		if (type == "moyen"){
			prix = 8.79*nombre + 1.40*garn*nombre;
		}//fin du if
		if (type == "large"){
			prix = 9.49*nombre + 1.60*garn*nombre;
		}//fin du if
		if (type == "exlarge"){
			prix = 10.29*nombre + 1.80*garn*nombre;
		}//fin du if
		if (type == "fete"){
			prix = 15.99*nombre + 2.30*garn*nombre;
		}//fin du if
		return prix;
	}//fin du getPrix

	@Override
	public String toString() {
		return String.format("%d%s%s%s%d%s$%,.2f\n", nombre, " Pizza(s) de taille ", type, " avec ", garn, " garniture(s) - Cout: ", prix);
	}//fin du toString
	
}//fin de la classe Pizza