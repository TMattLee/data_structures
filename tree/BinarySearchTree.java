public class BinarySearchTree {
	private Node node;
	private Integer size;
	
	private class Node {
		private int value;
		private Node left;
		private Node right;
		
		private Node(Integer value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public BinarySearchTree() {
		this.node = null;
		this.size = 0;
	}
	
	public BinarySearchTree(Integer value) {
		this.node = new Node(value);
		this.size = 1;
	}	
	
	public void insertNode(Integer value) {
		this.node = insert(this.node, value);
	}
	
	private Node insert(Node node, Integer value) {
		if(node == null) {
			this.size += 1;
			return new Node(value);
		}
		
		if(value > node.value) {
			node.right = insert(node.right, value);
		} else if (value< node.value){
			node.left = insert(node.left, value);
		}

		return node;
	}
	
	public void bulkInsert(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			this.insertNode(nums[i]);
		}
	}
	
	public void printPreOrder() {
		this.preOrder(this.node);
		System.out.print("\n");
	}
	
	public void printInOrder() {
		this.inOrder(this.node);
		System.out.print("\n");
	}
	
	public void printPostOrder() {
		this.postOrder(this.node);
		System.out.print("\n");
	}
	
	private void preOrder(Node node) {
		System.out.print(node.value + " ");
		if(node.left != null) preOrder(node.left);
		if(node.right != null) preOrder(node.right);
	}
	
	private void inOrder(Node node) {			
		if(node.left != null) inOrder(node.left);
		System.out.print(node.value + " ");
		if(node.right != null) inOrder(node.right);
	}
	
	private void postOrder(Node node) {			
		if(node.left != null) postOrder(node.left);
		if(node.right != null) postOrder(node.right);
		System.out.print(node.value + " ");
	}

}
