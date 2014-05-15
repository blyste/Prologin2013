import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		ArrayList<Candidat> listeCandidat = new ArrayList<Candidat>()  ;
		listeCandidat.add(new Candidat("Leo", 128, 9, 15));
		listeCandidat.add(new Candidat("Sebastien", 32, 9, 19));
		listeCandidat.add(new Candidat("Romain", 128, 9, 23));
		listeCandidat.add(new Candidat("Erwan", 128, 9, 27));
		listeCandidat.add(new Candidat("Kenji", 32, 9, 31));
		listeCandidat.add(new Candidat("Rémi", 64, 9, 35));
		listeCandidat.add(new Candidat("Maximilien", 64, 9, 39));
		listeCandidat.add(new Candidat("Lucas", 128, 9, 43));
		listeCandidat.add(new Candidat("Théotime", 4, 9, 47));
		listeCandidat.add(new Candidat("Anthony", 128, 9, 51));
		listeCandidat.add(new Candidat("Corentin", 32, 9, 55));
		listeCandidat.add(new Candidat("Marc", 4, 9, 59));
		listeCandidat.add(new Candidat("Quentin", 128, 10, 3));
		listeCandidat.add(new Candidat("Romain", 128, 10, 7));
		
		listeCandidat.add(new Candidat("Fabrice", 32, 10, 11));
		listeCandidat.add(new Candidat("Raphael", 32, 10, 15));
		listeCandidat.add(new Candidat("Jean", 128, 10, 19));
		listeCandidat.add(new Candidat("Sacha", 64, 10, 23));
		listeCandidat.add(new Candidat("Estelle", 64, 10, 27));
		listeCandidat.add(new Candidat("Arthur", 16, 10, 31));
		listeCandidat.add(new Candidat("Sydney", 32, 10, 35));
		listeCandidat.add(new Candidat("Yannis",128, 10, 39));
		listeCandidat.add(new Candidat("Louis", 128, 10, 43));
		listeCandidat.add(new Candidat("Matthieu", 64, 10, 47));
		listeCandidat.add(new Candidat("Cedric", 32, 10, 51));
		listeCandidat.add(new Candidat("Timothe", 16, 10, 55));
		listeCandidat.add(new Candidat("Charline", 128, 10, 59));
		listeCandidat.add(new Candidat("Renaud", 64, 11, 3));
		listeCandidat.add(new Candidat("Quentin", 64, 11, 7));
		listeCandidat.add(new Candidat("Clement", 16, 11, 11));
		listeCandidat.add(new Candidat("Lanca", 128, 11, 15));
		listeCandidat.add(new Candidat("Stéphane", 128, 11, 19));
		listeCandidat.add(new Candidat("Lelio", 128, 11 ,23));
		listeCandidat.add(new Candidat("Colin", 32, 11, 27));
		listeCandidat.add(new Candidat("Jordan", 64, 11 , 31));
		listeCandidat.add(new Candidat("Denis", 32, 11, 35));
		listeCandidat.add(new Candidat("Ophir", 32, 11, 39));
		listeCandidat.add(new Candidat("Mendes", 32, 11, 43));
		listeCandidat.add(new Candidat("Thibault", 16, 11, 47));
		listeCandidat.add(new Candidat("Corentin", 128, 11, 51));
		
		/* A Quelle Heure la mort disparaît si elle ne dort pas */
		
		for (Candidat candidat : listeCandidat) {
			i = i + candidat.getDeserveToDie();
			if (i>128){
				System.out.println("La mort disparaît à " + candidat.getDeadTimeHour() + "h " + candidat.getDeadTimeMinute() +"min très exactement");
				break;
			}
		}
		
		/* Qui est encore vivant à 12H si la mort dort*/
		i = 0;
		int time = 0;
		int nombreSurvivant = 0;
		ArrayList<Candidat> listeSurvivant = new ArrayList<Candidat>();
		for (Candidat candidat : listeCandidat) {
			if (candidat.getDeadTimeHour()*60 +candidat.getDeadTimeMinute()< time){
				listeSurvivant.add(candidat);
				nombreSurvivant = nombreSurvivant +1;
			}
			else if (i + candidat.getDeserveToDie()<=128 ) {
				i = i + candidat.getDeserveToDie();
				time = candidat.getDeadTimeHour() * 60 + candidat.getDeadTimeMinute();
			}
			else {
				time = time +15 ;
				i=0;
				listeSurvivant.add(candidat);
				nombreSurvivant = nombreSurvivant +1;
			}
		}
		
		for(Candidat candidat : listeSurvivant) {
			System.out.println(candidat.getName());
		}
		
		System.out.println("Il y a " + nombreSurvivant + " survivants !");
	}
}
