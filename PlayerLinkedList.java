
public class PlayerLinkedList<T> {
	
	Node<T> start;
	Node<T> end;
	int size;
	
	//constructor!!!!
	public PlayerLinkedList() {
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	/*
	 * get(int) function takes in the position that the node exists that you're trying to get.
	 * Return that node when you find it.
	 */
	public Node<T> get(int pos) {
		//start at the beginning of list
		Node<T> initial = this.start;
		Node<T> result = new Node<T>();//create a default node
		
		//loop thru the list
		for(int i = 0; i< this.size; i++) {
			if(i == pos) {//if this is the spot set the result to this node
				result = initial;
				break;
			}
			initial = initial.getLink();//if you haven't reached the desired position keep going down the chain
			/*
			 * Lets say you were trying to get pos 3 & the list looked like A,B,C,D,E
			 * Then the loop starts at node A.
			 * After first iteration, initial.getLink() will return B
			 * the next Iteration will return C then i = 3 which equals pos 3, so you set result to Node C
			 * and break out the loop then return C.
			 */
		}
		return result;
	}
	/* Function to insert element at end */
	/* insertAtEnd takes in a Player object and appends that
	 * player to the end of the list. Since this is a circular linked
	 * list we have to set the link between the end node and the start node
	 * 
	 * */
    public void insertAtEnd(Player player)
    {
    		//create a new node to add to list
        Node<T> newNode = new Node<T>(player,null);
        
        //initially set a link to the starting node
        newNode.setLink(this.start);
        
        //if the start node doesn't exist, make the new node the start
        if(this.start == null)
        {            
            this.start = newNode;//make new node start
            newNode.setLink(this.start); //set the link to itself
            this.end = this.start; //set end link to start           
        }
        else
        {
        		//start wasn't null, so there are other nodes
        		//in the list
        	
            this.end.setLink(newNode);//set a link from the end
            /*
             * ex. if 1 & 2 where in the list and we want to add 3 to the end
             * then the list would look like 1->2->3 ... 3->1
             */
            this.end = newNode;  //make the new node the end node           
        }
        this.size++; //increase the size of the list by 1
 
    }
	
}

