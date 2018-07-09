public class DoublyLinkedList<T> {
	private int size;
	private Node<T> head;
	private Node<T> tail;	
	
	private static class Node<T>{
		private T value;
		private Node<T> left;
		private Node<T> right;
		
		private Node(T value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public DoublyLinkedList(T value) {
		Node<T> newNode =  new Node<T>(value);
		this.head = newNode;
		this.tail = this.head;
		this.size = 1;
	}
	
	public DoublyLinkedList<T> insertHead(T value){
		if(this.head == null ) {			
			this.head = new Node<T>(value);
			this.tail = head;
		} else {
			Node<T> temp = this.head;			
			this.head.left = new Node<T>(value);
			this.head = this.head.left;
			temp.left = this.head;
			this.head.right = temp;
			if( this.tail.left == null) this.tail.left = this.head.right;
		}		
		
		this.size += 1;
		return this;
	}
	
	public DoublyLinkedList<T> insertTail(T value){
		if(this.tail == null ) {
			this.tail = new Node<T>(value);
			this.head = this.tail;
			return this;
		} else {		
			Node<T> temp = this.tail;
			temp.right = new Node<T>(value);
			this.tail = temp.right;
			this.tail.left = temp; 
		}
		
		this.size += 1;
		return this;
	}
	
	public DoublyLinkedList<T> removeHead(){
		if(this.head != null ) {
			if(this.head.right == null) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.right;
				this.head.left = null;
			}
			
			this.size -= 1;			
		}
		
		return this;
	}
	
	public DoublyLinkedList<T> removeTail(){
		if(this.tail != null ) {
			if(this.tail.left == null) {
				this.head = null;
				this.tail = null;
			} else {
				this.tail = this.tail.left;
				this.tail.right = null;
			}
			
			this.size -= 1;			
		}
		
		return this;
	}
	
	public DoublyLinkedList<T> removeAt(T value){
		if(this.head != null) {
			if(this.head.value.equals(value)) {
				return this.removeHead();
			} else if( this.tail.value.equals(value) ){
				return this.removeTail();
			} else {
				Node<T> temp = this.head;
				
				while( !(temp.right == null || temp.value.equals(value)) ) {
					temp = temp.right;
				}
								
				if(temp.value.equals(value)) {
					Node<T> left = temp.left;
					Node<T> right = temp.right;
					left.right = right;
					right.left = left;
					temp = null;
					this.size -= 1;
				} 
			}	
			
		}
		
		return this;
	}	
	
	public void print() {
		Node<T> temp = this.head;
		
		if(temp != null) {
			if(temp.left == null) System.out.print("null  <->  ");
			
			while(temp != null) {
				System.out.print(temp.value + "  <->  ");
				temp = temp.right;
			}
		}
		
		System.out.print("null \n");
	}
	
	public void printReverse() {
		Node<T> temp = this.tail;
		
		if(temp != null) {
			if(temp.right == null) System.out.print("null  <->  ");
			
			while(temp != null) {
				System.out.print(temp.value + "  <->  ");
				temp = temp.left;
			}
		}
		
		System.out.print("null \n");
	}
	
	public Integer size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
}
