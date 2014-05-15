public class Candidat {

	private String name ;
	private int deserveToDie ;
	private int deadTimeHour ;
	private int deadTimeMinute ;
	
	public Candidat(String name, int deserveToDie, int deadTimeHour, int deadTimeMinute){
		this.name = name ;
		this.deserveToDie = deserveToDie;
		this.deadTimeHour = deadTimeHour ;
		this.deadTimeMinute = deadTimeMinute ;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDeserveToDie() {
		return this.deserveToDie;
	}
	
	public int getDeadTimeHour() {
		return this.deadTimeHour;
	}
	
	public int getDeadTimeMinute() {
		return this.deadTimeMinute;
	}

	public int minutesStillAlive(int heure, int minute) {
		int timeStillAlive = ( (this.getDeadTimeHour() - heure) * 60 + this.getDeadTimeMinute() - minute );
		
		if (timeStillAlive <= 0) {
			return -1;
		}
		else
			return timeStillAlive ;
	}
}