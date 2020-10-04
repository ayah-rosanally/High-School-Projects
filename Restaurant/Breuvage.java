public class Breuvage {
	private String type; 
	private int nombre;
	private double prix;

	public Breuvage(String type, int nombre) {
		this.type = type;
		this.nombre = nombre;
	}//fin du construteur Breuvage
	
	public double getPrix() {
		if (type == "pop"){
			prix = 1.10*nombre;
		}//fin du if
		if (type == "eau"){
			prix = 1.00*nombre;
		}//fin du if
		if (type == "jus"){
			prix = 1.35*nombre;
		}//fin du if
		return prix;
	}//fin du getPrix

	@Override
	public String toString() {
		return String.format("%d %s%s$%,.2f\n", nombre,  type, " - Cout: ", prix);
	}//fin du toString
	
}//fin de la classe Breuvage