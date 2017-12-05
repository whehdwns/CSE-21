import java.util.Scanner;

public class Scorer {
	
	private static int visitorScore;
	private static int homeScore;
	private static int inning;	// the inning about to be played
	private static int batter;	// the team about to bat (1 if visitors, 2 if home team)
	// Examples:
	//	If the visitors are about to bat in the third inning,
	//		inning will contain 3 and batter will contain 1.
	//	If the home team is about to bat in the seventh inning,
	//		inning will contain 7 and batter will contain 2.
	
	// *** You supply the body of this method, to initialize the static variables
	// *** to values that represent the start of a game.
	public static void initialize ( ) {
			// Your code goes here.	
	
	}

	// Read the scores for each half of each inning until the end of the game.
	// The scanner returns first the visiting team's score in the first half
	// of the first inning, then the home team's score in the second half of 
	// the first inning, then the visiting team's score in the first half of 
	// second inning, and so on. If the game is over, no more values remain 
	// to be returned from the scanner.
	// The return value is 1 if the visiting team wins the game and 2 if the 
	// home team wins. 
	// *** You supply the body of the while loop.
	public static void readScores (Scanner scores) {
		while (!gameIsOver ( )) {
			// Your code goes here.
		}
	}
	
	// Determine if the game is over, that is, either we've played
	// at least nine complete innings and the score isn't tied,
	// or eight-and-a-half innings and the home team is ahead.
	// batter contains 1 if the visitors are about to bat (and thus
	// we've completed both halves of the inning), and contains 2 
	// if the home team is about to bat (and thus we've completed
	// only the first half of the inning).
	// *** You provide test values for this method,
	// *** and you replace the body of this method with code that does not use
	// *** the && and || operators in task 3.
	public static boolean gameIsOver ( ) {
		// Your code goes here.
		return (inning > 9 && batter == 1 && visitorScore != homeScore)
				|| (inning == 9 && batter == 2 && visitorScore < homeScore);
	}
	
	// The game is over. Return a string that describes the outcome.
	// *** You replace the strings of underscores. 
	public static String result ( ) {
		if (visitorScore > homeScore) {
			return "The visiting team won " 
					+ visitorScore + " to " + homeScore
					+ " in " + "____" + " innings.";
		} 
		if (batter == 1) {
			return "The home team won " 
					+ homeScore + " to " + visitorScore
					+ " in " + "____" + " innings.";
		} 
		if (batter == 2) {
			return "The home team won " 
					+ homeScore + " to " + visitorScore
					+ " in " + "____" + " innings.";
		}
		return "";
	}

	// *** You provide snippets of code to help you test your work in the 
	// *** methods above.  The snippet for initialize() is included below.
	// *** Comment out the snippet when you are convinced that it works 
	// *** properly, so that it won't be run every time you call main.
	
	// *** You provide the body of this method. 
	// *** It calls initialize, then calls readScores, then calls result
	// *** and prints the result of the game.
	public static void main (String [ ] args) {

		initialize();
		// TEST INITIALIZE
		// System.out.println("Initialize called. VisitorScore: " + visitorScore + ", homeScore: " + homeScore + ", inning: " + inning + ", batter: " + batter);

		
	}
}