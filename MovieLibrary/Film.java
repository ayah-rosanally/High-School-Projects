import java.io.Serializable;

import javax.swing.ImageIcon;

public class Film implements Serializable
{//déclarer les variables
	private String titre; 
	private String date_de_sortie;
	private String realisateur;
	private String genre1;
	private String genre2;
	private String acteur;
	private String synopsis;
	private String avis;
	private String note;
	//private String image;
	
	public Film(String titre, String date_de_sortie, String realisateur, String genre1, String genre2,
			String acteur, String synopsis, String avis, String note)
	{
		this.titre = titre;
		this.date_de_sortie = date_de_sortie;
		this.realisateur = realisateur;
		this.genre1 = genre1;
		this.genre2 = genre2;
		this.acteur = acteur;
		this.synopsis = synopsis;
		this.avis = avis;
		this.note = note;
		
	}//fin du constructeur

	public String getTitre() {
		return titre;
	}//fin du getTitre

	public void setTitre(String titre) {
		this.titre = titre;
	}//fin du setTitre

	public String getDate_de_sortie() {
		return date_de_sortie;
	}//fin du getDate_de_sortie

	public void setDate_de_sortie(String date_de_sortie) {
		this.date_de_sortie = date_de_sortie;
	}//fin du setDate_de_sortie

	public String getRealisateur() {
		return realisateur;
	}//fin du getRealisateur

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}//fin du setRealisateur

	public String getGenre1() {
		return genre1;
	}//fin du getGenre1

	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}//fin du setGenre1

	public String getGenre2() {
		return genre2;
	}//fin du getGenre2

	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}//fin du setGenre2

	public String getActeur() {
		return acteur;
	}//fin du getActeur

	public void setActeur(String acteur) {
		this.acteur = acteur;
	}//fin du setActeur

	public String getSynopsis() {
		return synopsis;
	}//fin du getSynopsis

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}//fin du setSynopsis

	public String getAvis() {
		return avis;
	}//fin du getAvis

	public void setAvis(String avis) {
		this.avis = avis;
	}//fin du setAvis

	public String getNote() {
		return note;
	}//fin du getNote

	public void setNote(String note) {
		this.note = note;
	}//fin du setNote
	
}//classe Film