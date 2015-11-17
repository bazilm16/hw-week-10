
public class LinkedList <T> {
	public class Node{
		public T value;
		public Node next;
		private Node first;
		public Node(T value, Node next){ 
			this.value = value; this.next = next;
			}
		public Node(T value){
			this(value, null);
			//this.value = null;
		}
		
		public void add(T elem){
			Node newNode = new Node(elem);
			if(first == null){
				first = newNode;
			}
			if(next == null){
				next = newNode;
			}
			else{
				next.add(elem);
			}
		}
		
		public int size(){
			if(next == null){
				return 1;
			}
			else{
				int sizeOfList = next.size();
				return 1 + sizeOfList;
			}
		}
		
	}

		
	}

