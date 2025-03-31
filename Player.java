package dragonsZombiesGoldHunt;

public class Player {
	private String name;
	private double energija=100;
	private Oružje[] oružje;
	public Player(String name, Oružje... weapon) {
		
		this.name = name;
		oružje=new Oružje[weapon.length];
		int i=0;
		for(Oružje w:weapon) {
			oružje[i++]=w;
		}
	}
	public Oružje[] getOružje() {
		return oružje;
	}
	public double getEnergija() {
		return energija;
	}
	public void setEnergija(double energija) {
		this.energija = energija;
	}
	public String getName() {
		return name;
	}
      
	
	
	
	

}
