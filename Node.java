
public class Node<T> {
	Player player; //the node's data is the player obj
	Node<T> link;
	
	//default Constructor!!!
	public Node() {
		this.link = null;
		this.player = null;
	}
	//param constructor !!! (I don't think this is needed)
	public Node(Player somePlayer, Node<T> someNode) {
		this.player = somePlayer;
		this.link = someNode;
	}
	
	//Set the link for a node to another node
	public void setLink(Node<T> someNode) {
		this.link = someNode;
	}
	//Set the player for a node -- don't think this is used.
	public void setplayer(Player somePlayer) {
		this.player = somePlayer;
	}
	
	//get the next node from whatever node calls this method
	public Node<T> getLink() {
		return this.link;
	}
	//return the player obj for a particular node calling this method
	public Player getPlayer() {
		return this.player;
	}
}
