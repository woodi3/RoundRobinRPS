import java.util.LinkedList;

public class Player {
	String name;
	int wins;
	int losses;
	int ties;
	String hand;
	LinkedList<String> played; 
	//using the generic linked list (not circular) to keep track of players played.
	
	//Constructor!!! only gotta set a name
	public Player(String newName) {
		this.name = newName;
		this.wins = 0;
		this.losses = 0;
		this.ties = 0;
		this.hand = "";
		this.played = new LinkedList<String>();
	}
	
	/*
	 * You could make a setName method, but not needed
	 */
	public String getName() {
		return this.name;
	}
	//Code the type of hand to a number
	public void setHand(int id) {
		//id represents the hand in 0 - rock, 1 - paper, 2 - scissors
		switch(id) {
			case 0: {
				this.hand = "rock";
				break;
			}
			case 1: {
				this.hand = "paper";
				break;
			}
			case 2: {
				this.hand = "scissors";
				break;
			}
			default: {
				System.out.println("Weird error with the hands");
				break;
			}
		}
	}
	//Return the hand
	public String getHand() {
		return this.hand;
	}
	//Return the list of players played for this player
	public LinkedList<String> getPlayed() {
		return this.played;
	}
	//Check if the player has played this player twice
	//Return true if the player has.
	public boolean checkPlayed(Player playedPlayer) {
		int count = 0;
		for(int i = 0; i<this.played.size(); i++){
			if(this.played.get(i).toLowerCase().equals(playedPlayer.getName().toLowerCase())) {
				count++;
			}
		}
		if(count == 2) {
			return true;
		}
		return false;
	}
	
	//Increment their stats
	public void addWin() {
		this.wins++;
	}
	public void addLoss() {
		this.losses++;
	}
	public void addTie() {
		this.ties++;
	}
	public int getWins() {
		return this.wins;
	}
	public int getLosses() {
		return this.losses;
	}
	public int getTies() {
		return this.ties;
	}
	//Print out player info with stats
	public String toString() {
		return this.getName()+" Wins "+
					this.getWins()+" Ties "+ this.getTies()+ " Losses "+
					this.getLosses();
	}
}
