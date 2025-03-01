package datastr;


public class MyNode <Ttype> {
	private Ttype element;
	private MyNode<Ttype> next = null;
	
	public Ttype getElement() {
		return element;
	}
	public MyNode<Ttype> getNext() {
		return next;
	}
	
	public void setElement(Ttype inputElement) {
		if(inputElement != null)
		{
			element = inputElement;
		}
		else
		{
			element = (Ttype) new Object();
		}
	}
	public void setNext(MyNode<Ttype> inputNext) {
		next = inputNext;
	}
	
	public MyNode(Ttype element) {
		setElement(element);
	}

	public String toString() {
		return element + "";
	}
}
