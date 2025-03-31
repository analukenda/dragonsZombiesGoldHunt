package dragonsZombiesGoldHunt;

public class MyListA {
      private MyListElementA head;
      private MyListElementA last;
      

	public MyListElementA getHead() {
		return head;
	}

	public void setHead(MyListElementA head) {
		this.head = head;
	}

	public MyListA() {
		head=null;
		
		
	}
	public int addLast(Object obj) {
		MyListElementA e=new MyListElementA(obj);
		if(head==null) {
			head=e;
			
		}
		else {
			
			last.setNext(e);
			
		}
		last=e;
		return size()-1;
		
		
		
		
		
		
		
		
	}
	public void removeAt(int index) {
		
		MyListElementA e=head;
		
		if(index<size()){
			
		
	    if(index==0) {
	    	if(e!=null) {
	    		head=e.getNext();
	    		e.setNext(null);
	    		
	    	}
	    }
	    else {
	    	for(int i=0;i<index-1;++i) e=e.getNext();
	    	MyListElementA pom=e.getNext();
	    	e.setNext(pom.getNext());
	    	pom.setNext(null);
	    }
	    
	    
		}
	    
		
	}
	public Object elementAt(int index) {
		MyListElementA e=head;
		int i=0;
		while(i<=index && i<size()) {
			if(i==index ) return e.getContent();
			++i;
			e=e.getNext();
			}
		return null;
		
		
	}
	public int size() {
		int size=0;
		for(MyListElementA i=head;i!=null;i=i.getNext()) ++size;
		return size;
			
		
		
	}
      
}
