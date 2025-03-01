package datastr;

public class MyLinkedList<Ttype> {
	private MyNode firstNode = null;//netaisu ne get, ne set. tas nav nepieciešams, jo leitotājam nevajag pie šiem piekļut
	private MyNode lastNode = null;//netaisu ne get, ne set. tas nav nepieciešams, jo leitotājam nevajag pie šiem piekļut
	private int counter = 0;
	
	//neveidošu beazrgumenta konstruktoru, jo tas ir jau no Object klases pieejams
	
	
	public boolean isFull()//saraksts būs pilns, ja RAM atmiņā nebūs vietas 
	{
		try
		{
			MyNode<Integer> newNode = new MyNode<Integer>(4);
			return false;
			
		}
		catch (OutOfMemoryError e) {
			return true;
		}
	}
	
	
	public boolean isEmpty() {
		return (counter == 0);
	}

	public int howManyElements() {
		return counter;
	}
	
	public void add(Ttype element) {
		if(!isFull()) {
			
			if(isEmpty()) {
				MyNode<Ttype> newNode = new MyNode<Ttype>(element);
				firstNode = newNode;
				lastNode = newNode;
				counter++;
			}
			else
			{
				MyNode<Ttype> newNode = new MyNode<Ttype>(element);
				lastNode.setNext(newNode);
				lastNode = newNode;
				counter++;
				
			}
			
			
		}
	}
	
	public void print() throws Exception
	{
		//pārbaudi uz isEmpty
		if(isEmpty())
		{
			Exception myException = new Exception("Saraksts ir tukšs, tāpēc nevar veikt printēšanu");
			throw myException;
		}
		
		MyNode<Ttype> currentNode = firstNode;
		
		while(currentNode != null) {
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	
	
}
