import java.util.*;

public class Game {
	// Keeps track of user and cpu scores
	public int usrScore = 0;
	public int cpuScore = 0;
	
	// Chooses winner of one round
	public void chooseWinner(String usr, String cpu){
		if (usr.equals(cpu)) {
			System.out.println("TIE!");
			return;
		}
		
		if (usr.equals("rock")){
			if (cpu.equals("paper")){
				System.out.println("CPU Wins!");
				cpuScore++;
			}
			else { 
				System.out.println("YOU Win!");
				usrScore++;
			}
		}
		else if (usr.equals("paper")){
			if (cpu.equals("scissors")){
				System.out.println("CPU Wins!");
				cpuScore++;
			}
			else { 
				System.out.println("YOU Win!");
				usrScore++;
			}
		}
		else if (usr.equals("scissors")){
			if (cpu.equals("rock")){
				System.out.println("CPU Wins!");
				cpuScore++;
			}
			else { 
				System.out.println("YOU Win!");
				usrScore++;
			}
		}
		else {
			System.out.println("invalid argument");
		}
		
		return;
	}
	
	// Prints cpu and user scores
	public void printScore() {
		System.out.println("----- SCORE -----");
		System.out.println("YOU: " + this.usrScore);
		System.out.println("CPU: " + this.cpuScore);
		System.out.println("---------------");
	}
	
	// Chooses final winner - whichever won more rounds
	public void finalWinner(){
		if (this.usrScore > this.cpuScore) 
			System.out.println("YOU are the final winner!!");
		else if (this.usrScore == this.cpuScore)
			System.out.println("Tie Game!");
		else System.out.println("CPU is the final winner!!");
		
		System.out.println("---------------");
	}
	
	public static void main(String[] args) {
		String [] options = {"rock", "paper", "scissors"};
		
		// Print instructions
		System.out.println("Welcome to Rock, Paper, Scissors!");
		System.out.println("Please enter 'START' to begin.");
		System.out.print(">> ");
		
		// Get user input 
		Scanner reader = new Scanner(System.in);
		String s = reader.next();
		
		// Play game 
		if (s.equals("START")){
			// Creates a instance of a Game 
			// Use to keep track of scores and choose winner
			Game game = new Game();
			
			// Instructions
			System.out.println("-------------");
			System.out.println("INSTRUCTIONS: ");
			System.out.println("Enter 'rock', 'paper', or 'scissors'");
			
			do {
				System.out.println("===============");
				
				
				String usrChoice;
				String cpuChoice;
				Random randInt = new Random();
				
				System.out.print(">> ");
				
				// Get user input 
				usrChoice = reader.next();
				
				// CPU chooses next move randomly from options array 
				cpuChoice = options[randInt.nextInt(2)];
				
				System.out.println("CPU chose: " + cpuChoice);
				
				game.chooseWinner(usrChoice, cpuChoice);
				
				game.printScore();
				
				// Ask if use wants to continue playing
				System.out.print("Continue? [y/n]: ");
				s = reader.next();
				
				// Keep asking until user enters valid input
				while (!(s.equals("y") || s.equals("n"))){
					System.out.println("Invalid entry.");
					System.out.print("Continue? [y/n]: ");
					s = reader.next();
				}
				
				
			} while (s.equals("y"));
			
			game.printScore();
			game.finalWinner();
	
		}
		else {
			System.out.println("Thank you!");
		}

		System.out.println("Goodbye.");
		
		reader.close();		
	}

}
