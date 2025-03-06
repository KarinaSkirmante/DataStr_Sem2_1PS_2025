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
	
	public void add(Ttype element) throws Exception {
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
		else
		{
			throw new Exception("Saraksts ir pilns un tajā nevar pievienot elementu");
		}
	}
	
	//position - sakās no 1
	public void add(Ttype element, int position) throws Exception {
		if(isFull()) {
			throw new Exception("Saraksts ir pilns, tāpēc nevar pievienot elementu");
		}
		
		if(position <= 0 || position > counter+1)
		{
			throw new Exception("Padotā pozīcija nav pareiza");
		}
		
		
		if(position == 1) {//ja grib pievienot pašā priekšā
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			newNode.setNext(firstNode);
			firstNode = newNode;
			counter++;
			
		}
		else if(position == counter+1) {//ja grib pievienot kā pēdējo 
			add(element);			
		}
		else
		{
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			
			//veiks lēcienu līdz vēlamajai pozīcijai -1
			MyNode<Ttype> currentNode = firstNode;
			
			for(int i = 1; i < position-1; i++) {
				currentNode = currentNode.getNext();
			}
			//dabūjuam nakamo mezglu, kas ir saistītts
			MyNode<Ttype> currentNodeNext = currentNode.getNext();
			currentNode.setNext(newNode);
			newNode.setNext(currentNodeNext);
			counter++;
		}
	}
	//dzdešanas funkcijas definīcja, kura ka input param ir pozīcija
	public void remove(int position) throws Exception{
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukšs, tāpēc neko nevarēs dzēst");
		}
		
		if(position < 1 || position > counter)
		{
			throw new Exception("Padotā pozīcija nav pareiza");
		}
		
		if(position == 1)//pirmais tiks dzēsts
		{
			firstNode = firstNode.getNext();
			counter--;
			System.gc();
		}
		else if(position == counter)//pēdejais tiks dzēsts
		{
			MyNode<Ttype> currentNode = firstNode;
			for(int i  = 1; i <= position -2; i++)
			{
				currentNode = currentNode.getNext();
			}
			lastNode = currentNode;
			lastNode.setNext(null);//aiz sī mezgla vairs nav citu mezglu
			counter--;
			System.gc();
			
		}
		else//tiks dzēsts elements pa vidu
		{
			MyNode<Ttype> currentNode = firstNode;
			for(int i  = 1; i <= position -2; i++)
			{
				currentNode = currentNode.getNext();
			}
			
			MyNode<Ttype> curentNodeNextNext = currentNode.getNext().getNext();
			currentNode.setNext(curentNodeNextNext);
			counter--;
			System.gc();
			
		}
		
		
	}
	//TODO uztaisīt get funkcitju pašiem
	public Ttype get(int position) throws Exception {
		//parbaude par isEmpty
		if(isEmpty())
		{
			throw new Exception("Saraksts ir tukšs, tāpēc nevar piekļūt elementiem");
		}
		
		if(position < 1 || position > counter)
		{
			throw new Exception("Padotā pozīcija nav pareiza");
		}
		
		MyNode<Ttype> currentNode = firstNode;
		
		for(int i = 1; i <= position -1; i++) {
			currentNode = currentNode.getNext();
		}
		
		return currentNode.getElement();
		
		
	}

	public boolean search(Ttype element) throws Exception {
		//parbaude par isEmpty
		if(isEmpty())
		{
			throw new Exception("Saraksts ir tukšs, tāpēc nevar meklēt elementus");
		}
		
		MyNode<Ttype> currentNode = firstNode;
		
		while(currentNode != null) {
			
			if(currentNode.getElement().equals(element))
			{
				return true;
			}

			currentNode = currentNode.getNext();
		}
		
		return false;
		
		
	}
	
	//TODO izveidot MakeEmpty funkciju un to notestēt
	//TODO nokopēt student klasi un nostēste visas darbības ar Studentiem
	
	
	
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
