package dragonsZombiesGoldHunt;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Spilja[] caves=new Spilja[20];
		int[] sus= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<20;++i) {
			int a=0;
			boolean passed=false;
			int b=0,c=0,d=0;
			caves[i]=new Spilja(i);
			if(i==0) {
				
					a=1 + (int)(Math.random() * ((19 - 1) + 1));
				
				
				do {
					b=1 + (int)(Math.random() * ((19 - 1) + 1));
				}while(b==a);
				do {
					c=1 + (int)(Math.random() * ((19 - 1) + 1));
				}while(c==a||c==b);
				do {
					d=1 + (int)(Math.random() * ((19 - 1) + 1));
				}while(d==a||d==b||d==c);
				
			}
			else {
				int[] pom= {-1,-1,-1,-1};
				int l=0;
				for(int j=i-1;j>=0;--j) {
					for(int k=0;k<3;++k) {
						if((int)caves[j].getSusjedne().elementAt(k)==i) {
					
							pom[l]=j;
						++l;
						break;}
					}
				}
				if(l>0) {
					a=pom[0];
				
				if(l>1) 
					b=pom[1];
					else {
						 int[] moze=stvoriPolje(caves,i,sus);
						int mm=-1;
						do {
							
						mm=0+ (int)(Math.random() * ((moze.length-1 - 0) + 1));
						b=moze[mm];
						}while(b==a||sus[b]==4);
						do {
							c=0+ (int)(Math.random() * ((moze.length-1 - 0) + 1));
							c=moze[mm];
						}while(c==a||c==b||sus[c]==4);
						do {
							d=0+ (int)(Math.random() * ((moze.length-1 - 0) + 1));
							d=moze[mm];
						}while(d==a||d==b||d==c||sus[d]==4);
						passed=true;
					}
						
					
				if(l>2 ) 
					c=pom[2];
					
				else if(!passed){
					int[] moze=stvoriPolje(caves,i,sus);
					int mm=-1;
				
					do {
						c=0+ (int)(Math.random() * ((moze.length-1 - 0) + 1));
						c=moze[mm];
					}while(c==a||c==b||sus[c]==4);
					do {
						d=0+ (int)(Math.random() * ((moze.length-1 - 0) + 1));
						d=moze[mm];
					}while(d==a||d==b||d==c||sus[d]==4);
					passed=true;
				}
				if(l>3)  d=pom[3];
					else if(!passed){
						int[] moze=stvoriPolje(caves,i,sus);
						int mm=-1;
					
						do {
							d=0+ (int)(Math.random() * ((moze.length-1 - 0) + 1));
							d=moze[mm];
						}while(d==a||d==b||d==c||sus[d]==4);
						passed=true;
					}
				}		else {
					 int[] moze=stvoriPolje(caves,i,sus);
					int mm=-1;
					mm=0+ (int)(Math.random() * ((moze.length-1 - 0) + 1));
					a=moze[mm];
					do {
						
					mm=0+ (int)(Math.random() * ((moze.length-1 - 0) + 1));
					b=moze[mm];
					}while(b==a||sus[b]==4);
					do {
						c=0+ (int)(Math.random() * ((moze.length-1 - 0) + 1));
						c=moze[mm];
					}while(c==a||c==b||sus[c]==4);
					do {
						d=0+ (int)(Math.random() * ((moze.length-1 - 0) + 1));
						d=moze[mm];
					}while(d==a||d==b||d==c||sus[d]==4);
				}
				
			}
			
			
		caves[i].spoji(a, b, c, d);
		if(sus[a]<4) ++sus[a];
		if(sus[b]<4) ++sus[b];
		if(sus[c]<4) ++sus[c];
		if(sus[d]<4) ++sus[d];
		if(sus[i]<4) sus[i]=4;
		
		
	}
		int[] sadrze= {0,0,0,0,0,0,0};
		for(int i=0;i<7;++i) {
			do {
				sadrze[i]=1 + (int)(Math.random() * ((19 - 1) + 1));
			}while(!different(i,sadrze));
		}
		Dragon d1=new Dragon();
		Dragon d2=new Dragon();
		Monster z1=new Zombie();
		Ghoul g1=new Ghoul();
		Ghoul g2=new SelfHealingGhoul();
		Zombie g3=new SelfHealingGhoul();
		Zombie z2=new Zombie();
		Monster[] monsters=new Monster[] {d1,d2,z1,g1,g2,g3,z2};
		for(int i=0;i<7;++i) {
			caves[sadrze[i]].addMonster(monsters[i]);
		}
		caves[1 + (int)(Math.random() * ((19 - 1) + 1))].setIma(true);
		
		Player niko=new Player("Niko",new Sačmarica(),new Mač());
		System.out.println(niko.getName()+" welcome to game!");
		Spilja tren=caves[0];
		int oTren=0;
		
		
		while(true) {
			System.out.println("Choose: I for info,W for weapon change,A for attack,M N for moving in other cave");
			Monster mTren=tren.getMonster();
			if(mTren!=null && mTren.getEnergija()>0) {
				mTren.attack();
				niko.setEnergija(niko.getEnergija()-mTren.getDamage());
				if(niko.getEnergija()<=0) {
					System.out.println("You are dead");
					break;
				}
				
				
			}
			if(tren.contains()) {
				System.out.println("You have found the treasure");
				break;
			}
	
			
			String action=sc.nextLine().trim();
			switch(action) {
			case("I"):
				System.out.println(tren.toString());
			System.out.println("Sounds from other caves: ");
			    for(int i=0;i<4;++i) {
			    	int j=(Integer)tren.getSusjedne().elementAt(i);
			    	Monster pom=caves[j].getMonster();
			    	if(pom!=null) pom.makeSound();
			    	
			    	
			    }
			    tren.setVisited(true);
				
				break;
			case("W"):
				if(niko.getOružje().length==oTren+1) oTren=0;
				else ++oTren;
			System.out.println("Your new weapon is "+niko.getOružje()[oTren].getNaziv());
		
			tren.setVisited(true);
				break;
			case("A"):
				if(mTren!=null) {
					System.out.println("You are attacking "+mTren.getNaziv()+" with "+niko.getOružje()[oTren].getNaziv());
					
					
					if(niko.getOružje()[oTren] instanceof Sačmarica) {
						Sačmarica s=(Sačmarica)niko.getOružje()[oTren];
						if(s.getPatron()<=0) System.out.println("You can't shoot,you need to change the weapon");
						else {
							mTren.setEnergija(mTren.getEnergija()-niko.getOružje()[oTren].getŠteta());
							System.out.println(mTren.getNaziv()+" energija:"+mTren.getEnergija());
							if(mTren.getEnergija()<=0) System.out.println("This monster is dead");
							s.setPatron(s.getPatron()-1);
							System.out.println("You have this much patrons:" +s.getPatron());
						}
						
					}
					else {
						mTren.setEnergija(mTren.getEnergija()-niko.getOružje()[oTren].getŠteta());
						System.out.println(mTren.getNaziv()+" energija:"+mTren.getEnergija());
						if(mTren.getEnergija()<=0) System.out.println("This monster is dead");
					}
				
					
				}
			tren.setVisited(true);
				break;
			default:
				tren.setVisited(true);
				String[] array=action.split(" ");
				int next=Integer.parseInt(array[1]);
				int i;
				for(i=0;i<4;++i) {
					if((int)tren.getSusjedne().elementAt(i)==next) {
						tren=caves[next];
						System.out.println("You have moved to cave "+ next);
						
						break;
					}
				}
				if(i==4) System.out.println("That cave is not here "+ next);
				break;
			}
		}
		
		
	
		

	}
	public static boolean different(int i,int[] sadrze) {
		for(int j=i-1;j>=0;--j) {
			if(sadrze[j]==sadrze[i]) return false;
		}
		return true;
	}
	public static int[] stvoriPolje(Spilja[] caves,int i,int[] sus) {
	   MyListA my=new MyListA();
	   for(int z=caves.length-1;z>i;--z) {
		   if(sus[z]<4) my.addLast(Integer.valueOf(z));
	   }
	   int[] moze=new int[my.size()];
	   
	   for(int k=0;k<my.size();++k)
		   moze[k++]=(Integer)my.elementAt(k);
		return moze;
		
	}


}
