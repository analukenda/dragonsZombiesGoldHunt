package dragonsZombiesGoldHunt;

public abstract class Monster {
	private String naziv;
	private double damage;
	private double energija;
	private String sound;
	public Monster(String naziv, double damage, double energija,String sound) {
		
		this.naziv = naziv;
		this.damage = damage;
		this.energija = energija;
		this.sound=sound;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getDamage() {
		return damage;
	}
	public void setDamage(double damage) {
		this.damage = damage;
	}
	public double getEnergija() {
		return energija;
	}
	public void setEnergija(double energija) {
		this.energija = energija;
	}
	public void makeSound() {
		System.out.println(sound);
		
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
public void attack() {
	System.out.println(naziv+" vas napada,damage: "+damage);
}


}
