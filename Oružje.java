package dragonsZombiesGoldHunt;

public abstract class Oružje {
private	String naziv;
private	double šteta;
public Oružje(String naziv, double šteta) {
	
	this.naziv = naziv;
	this.šteta = šteta;
}
public double getŠteta() {
	return šteta;
}
public String getNaziv() {
	return naziv;
}



}
