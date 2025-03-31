package dragonsZombiesGoldHunt;

public class Spilja implements Gold{
	private int redniBroj;
	private boolean visited=false;
	private Monster monster=null;
	private MyListA susjedne=new MyListA();
	private boolean ima=false;
	@Override
	public String toString() {
		String s=redniBroj+". spilja,posjećena:"+visited+"susjedne:" +susjedne.elementAt(0)+","+susjedne.elementAt(1)+","
		+susjedne.elementAt(2)+","+susjedne.elementAt(3)+",čudovište:";
		if(monster==null) s+="nema ga";
		else s+=monster.getNaziv();
		return s;
		
	}
	
		
		
		
	
	public void addMonster(Monster m) {
		if(monster==null)
		monster=m;
	}
	public Spilja(int redniBroj) {
		
		this.redniBroj=redniBroj;
		
	
		
	
	

}
	
	public void spoji(int a,int b,int c,int d) {
		susjedne.addLast(Integer.valueOf(a));
		susjedne.addLast(Integer.valueOf(b));
		susjedne.addLast(Integer.valueOf(c));
		susjedne.addLast(Integer.valueOf(d));
		
	}
	@Override
	public boolean contains() {
		return ima;
	}





	public MyListA getSusjedne() {
		return susjedne;
	}





	public Monster getMonster() {
		return monster;
	}





	public void setIma(boolean ima) {
		this.ima = ima;
	}





	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
}