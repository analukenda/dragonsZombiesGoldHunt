package dragonsZombiesGoldHunt;

public class MyListElementA {
	private Object content;
	private MyListElementA next;
	public MyListElementA(Object obj) {
		content=obj;
		next=null;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public MyListElementA getNext() {
		return next;
	}
	public void setNext(MyListElementA next) {
		this.next = next;
	}
	
		
	

}
