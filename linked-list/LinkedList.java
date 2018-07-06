public class LinkedList<T> {
	
	private Node<T> node;		
	private int size;	
	private static class Node<T> {		
		public Node<T> next;
		public T value;
		public Node(T value) {
			this.value = value;
			this.next = null;
		}		
	}
	
	public LinkedList() {		
		this.node = null;
		this.size = 0;
	}
	
	public LinkedList(T value) {		
		this.size = 1;
		this.node = new Node<T>(value);		
	}
	
	public LinkedList<T> insertTail(T value) {		
		if( this.node == null) {
			this.node = new Node<T>(value);
			this.size += 1;
			return this;
		}
		
		Node<T> temp = this.node;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = new Node<T>(value);		
		this.size += 1;
		return this;
	}	
	
	public LinkedList<T> insertHead(T value) {
		Node<T> temp = new Node<T>(value);
		temp.next = this.node;
		this.node = temp;
		this.size += 1;
		return this;
	}
	
	public LinkedList<T> removeHead() {
		if (this.node == null) return this;
		
		if( this.node.next != null) {
			this.node = this.node.next;
			this.size -= 1;
			return this;	
		}
		
		this.size = 0;
		this.node = null;
		return this;
	}	
	
	public LinkedList<T> removeTail() {
		if( this.node == null) return this;
		
		if(this.node.next != null) {
			Node<T> temp = this.node;
			while(temp.next != null && temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
			this.size -= 1;
			return this;		
		}
		
		this.size = 0;
		this.node = null;
		return this;
	}
	
	public LinkedList<T> insertAfter(T stop, T value){
		if(this.node == null) return this;
		
		Node<T> temp = this.node;
		
		while( temp.next != null && !temp.value.equals(stop) ) {
			temp = temp.next;
		}

		if( temp.next != null) {
			Node<T> split = temp.next;			
			temp.next = new Node<T>(value);
			temp.next.next = split;
			this.size += 1;
		} else {
			if(temp.value.equals(stop)) temp.next = new Node<T>(value);
			this.size += 1;
		}

		return this;
	}
	
	public LinkedList<T> insertBefore(T stop, T value){
		if(this.node == null) return  this;
		
		if(this.size == 1) {
			if(this.node.value == stop) this.insertHead(value);
			return this;
		}
		
		Node<T> temp = this.node;
		
		while(temp.next != null && !temp.next.value.equals(stop)) {
			temp = temp.next;
		}
		
		if(temp.next != null) {
			Node<T> split = temp.next;
			temp.next = new Node<T>(value);
			temp.next.next = split;
			this.size += 1;
		}
		
		return this;
	}
	
	
	public LinkedList<T> removeAt(T value) {
		if(this.node == null) return this;
		
		if(this.node.value.equals(value)) {
			this.node = this.node.next;
			this.size -= 1;
			return this;
		}
		
		Node<T> temp = this.node;
		
		while( temp.next != null && temp.next.next != null && !temp.next.value.equals(value) ) {
			temp = temp.next;
		}
		
		if(temp.next != null && temp.next.value.equals(value) ) {
			temp.next = temp.next.next;
			this.size -= 1;
		}		
		
		return this;
	}
	
	public void print() {
		if(this.node == null) {
			System.out.println("null");
			return;
		}
		
		Node<T> temp = this.node;
		
		while(temp != null ) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
			if(temp == null) System.out.println("null");
		}
		
	}

	
	public int size() {
		return this.size;
	}
	
	
}


