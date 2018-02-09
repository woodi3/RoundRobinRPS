
import java.util.Scanner;
import java.util.Random;

public class Driver {
	 public static void main(String[] args)
	    {            
		 //initialize some stuff, scanner, random, and the gameList
	        @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
	        Random r = new Random();
	        PlayerLinkedList<Player> gameList = new PlayerLinkedList<Player>(); 
	        
	        
	        System.out.println("Welcome to the Rock PAper Scissors Tournament!");
	        System.out.println("How many contestants do we have?");
	        
	        //set the # of players
	        int numPlayers = scan.nextInt();
	        
	        //add the players to the list
	        for(int i = 0; i<numPlayers; i++) {
	        		Player playerObj = new Player("Player "+i);
	        		gameList.insertAtEnd(playerObj);
	        }
	        
	        System.out.println("FIGHT!!!!");
	        
	        //Outer game loop
	        //This loop controls the rounds
	        for(int i = 0; i<numPlayers; i++) {
	        		Node<Player> a = gameList.get(i);//get the player who's round it is
	        		Node<Player> tmp = a;//temp variable to help move links in the inner loop
	        		System.out.println("========="+a.getPlayer().getName()+"==============");
	        		
	        		
	        		int gamesPlayed = 0;//games played shouldn't be more than numPlayers-1 for each player
	        		while(gamesPlayed < numPlayers-1) {
	        			
	        			Node<Player> b = tmp.getLink();//move to the next player
	        			
	        			//if this next player is the current player then continue to the next player
	        			if(a.getPlayer().getName().toLowerCase().equals(b.getPlayer().getName().toLowerCase())) {
	        				tmp = b;
	        				continue;
	        			}
	        			//if the current player has played the next player twice continue to the next player
	        			if(a.getPlayer().checkPlayed(b.getPlayer())) {
	        				continue;
	        			}
	        			//If you make it this far in the loop then the players haven't played each other twice yet
	        			//Add them to each other's 'played' list
	        			a.getPlayer().getPlayed().add(b.getPlayer().getName());
	        			b.getPlayer().getPlayed().add(a.getPlayer().getName());
	        			
	        			//generate 2 random numbers to set the hand
	        			int randNum = r.nextInt(3);
	        			int anotherRandNum = r.nextInt(3);
	        			a.getPlayer().setHand(randNum);
	        			b.getPlayer().setHand(anotherRandNum);
	        			
	        			//Print out the hand
	        			System.out.println(a.getPlayer().getName()+" uses "+a.getPlayer().getHand());
	        			System.out.println(b.getPlayer().getName()+" uses "+b.getPlayer().getHand());
	        			
	        			//'compareHand' function compares the hand
	        			System.out.println(compareHand(a.getPlayer(), b.getPlayer()));
	        			//set the tmp node to b so that in the next loop we go to the next player
	        			tmp = b;
	        			//increment games played
	        			gamesPlayed++;
	        		}
	        }
	        
	        //game is over print out stats
	        System.out.println("The tourney is over, here are the results!");
	        for(int i = 0; i<numPlayers; i++) {
	        		System.out.println(gameList.get(i).getPlayer().toString());
	        }
	    }
	
	 /*
	  * compareHand(player, player) function takes in 2 players
	  * and compares their current hands.
	  * Depending on their current hand, someone wins/losses or there's a tie and
	  * this function will return that result.
	  */
	 public static String compareHand(Player a, Player b) {
		 String result = "";
		 //===== LETS HANDLE THE TIES ======
		 if(a.getHand().toLowerCase().equals("rock") && 
				 b.getHand().toLowerCase().equals("rock")) {
			 //tie for a & b
			 a.addTie();
			 b.addTie();
			 result= "TIE!";
		 }
		 if(a.getHand().toLowerCase().equals("paper") && 
				 b.getHand().toLowerCase().equals("paper")) {
			 //tie for a & b
			 a.addTie();
			 b.addTie();
			 result= "TIE!";
		 }
		 if(a.getHand().toLowerCase().equals("scissors") && 
				 b.getHand().toLowerCase().equals("scissors")) {
			 //tie for a & b
			 a.addTie();
			 b.addTie();
			 result = "TIE!";
		 }
		 //======= LETS HANDLE IF PLAYER A USES ROCK =======
		 if(a.getHand().toLowerCase().equals("rock") && 
				 b.getHand().toLowerCase().equals("paper")) {
			 // a loses b wins
			 a.addLoss();
			 b.addWin();
			 result= b.getName()+" WINS!";
		 }
		 if(a.getHand().toLowerCase().equals("rock") && 
				 b.getHand().toLowerCase().equals("scissors")) {
			 // a wins b losses
			 a.addWin();
			 b.addLoss();
			 result= a.getName()+" WINS!";
		 }
		//======= LETS HANDLE IF PLAYER A USES PAPER =======
		 if(a.getHand().toLowerCase().equals("paper") && 
				 b.getHand().toLowerCase().equals("rock")) {
			 // a wins b losses
			 a.addWin();
			 b.addLoss();
			 result= a.getName()+" WINS!";
		 }
		 if(a.getHand().toLowerCase().equals("paper") && 
				 b.getHand().toLowerCase().equals("scissors")) {
			 // a losses b wins
			 a.addLoss();
			 b.addWin();
			 result= b.getName()+" WINS!";
		 }
		//======= LETS HANDLE IF PLAYER A USES SCISSORS =======
		 if(a.getHand().toLowerCase().equals("scissors") && 
				 b.getHand().toLowerCase().equals("paper")) {
			 // a wins b losses
			 a.addWin();
			 b.addLoss();
			 result= a.getName()+" WINS!";
		 }
		 if(a.getHand().toLowerCase().equals("scissors") && 
				 b.getHand().toLowerCase().equals("rock")) {
			 // a losses b wins
			 a.addLoss();
			 b.addWin();
			 result= b.getName()+" WINS!";
		 }
		 return result;
	 }
}
