
public class Tree<T extends Comparable <T>> {
	private static class Node<T extends Comparable <T>>{
		public T value;
		public Node <T>left;
		public Node <T>right;
		public Node(T value, Node <T>left, Node <T> right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		public Node(T value){
			this(value, null, null);
		}
		
		public int size(){
			if(left == null && right == null){
				return 1;
			}
			else if(left == null && right != null){
				return 1 + right.size();
			}
			else if(right == null && left != null){
				return 1 + left.size();
			}
			else{
				return left.size() + right.size() + 1;
			}
		}
		
	}

	private Node root;
	private int size(Node<T> cur){
		if(cur == null){
			return 0;
		}
		else{
			return 1 + size(cur.left) + size(cur.right);
		}
	}
	public int size(){
		return size(root);
	}
	private Node<T> insert(Node<T> curr, T v){
		if(curr == null){
			curr = new Node(v); //create new node to store v
		}
		else{
			if(v.compareTo((T)curr.value) > 0){
				curr.right = insert(curr.right, v);
			}
			else{
				curr.left = insert(curr.left, v);
			}
		}
		return curr;
	}
	
	public void insert(T v){
		root = insert(root,v);
	}
	
	public static void main(String[] args){
		Tree t = new Tree();
		System.out.println(t.size());
		t.insert("Pancake");
		System.out.println(t.size());
		t.insert("Waffle");
		System.out.println(t.size());
	}
}

