package dragonsZombiesGoldHunt;

public class SelfHealingGhoul extends Ghoul {
	private final static double maxE=25;
	public SelfHealingGhoul() {
		this.setNaziv("Self healing ghoul");
		this.setDamage(25);
		this.setEnergija(maxE);
		this.setSound("Ča ti je, niš mi ni!");
	}
     @Override
     public void setEnergija(double energija) {
    	 super.setEnergija(energija);
    	 heal(this.getEnergija());
    	 
     }
     
     public void heal(double energija) {
    	 if (energija<maxE) super.setEnergija(energija+5);
     }
}
