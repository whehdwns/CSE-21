import java.util.Scanner;

public class ScorerArr {
	
	private static int[] visitorScores;	//Holds all the visitor scores in the array
	private static int[] homeScores; //Holds all the visitor scores in the array
	private static int inning;	// the inning about to be played
	private static int batter;	// the team about to bat (1 if visitors, 2 if home team)
	// Examples:
	//	If the visitors are about to bat in the third inning,
	//		inning will contain 3 and batter will contain 1.
	//	If the home team is about to bat in the seventh inning,
	//		inning will contain 7 and batter will contain 2.
		
	// the number of innings in a regulation game (after which only tie scores continue)
	// in MLB, this is 9.  A smaller number will make manual testing easier.
	public static final int REGULATION_NUM_INNINGS = 9;
	
	// assume game can never go over this number of innings (used when allocating arrays)
	public static final int MAX_BOX_SCORE_LENGTH = 20;
	
	// value in a boxScore: an indicator that a half-inning hasn't been played yet
	// this need to be distinguishable from a baseball score
	private static final int SENTINEL = -999;
	
	// *** You supply the body of this method, to initialize the static variables
	// *** to values that represent the start of a game.
	// *** Note that you will need to create both arrays and initialize each entry with SENTINEL value
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
			//System.out.println("in Read Scores");
			// Your code goes here.	
		}
	}
	
	// Calculates the total score in the array teamBoxScore 
	// It ignores all the entries with the value SENTINEL
	public static int gameScore(int[] teamBoxScore) {
		int output = 0;
		for (int v : teamBoxScore) {
			if (v != SENTINEL) {
				output += v;
			}
		}
		return output;
	}
	
	// Determine if the game is over, that is, either we've played
	// at least nine complete innings and the score isn't tied,
	// or eight-and-a-half innings and the home team is ahead.
	// batter contains 1 if the visitors are about to bat (and thus
	// we've completed both halves of the inning), and contains 2 
	// if the home team is about to bat (and thus we've completed
	// only the first half of the inning).

	public static boolean gameIsOver ( ) {
		// Generic expression based on REGULATION_NUM_INNINGS so shorter games can be tested
		return (inning > REGULATION_NUM_INNINGS && batter == 1 && gameScore(visitorScores) != gameScore(homeScores))
		|| (inning == REGULATION_NUM_INNINGS && batter == 2 && gameScore(visitorScores) < gameScore(homeScores));
	}
	
	// Print out the Boxscore for each valid half inning in the teamBoxScore array
	public static void printBoxScore(int[] teamBoxScore) {
		// Your code goes here.	

	}
	
	// The game is over. Return a string that describes the outcome.
	// *** You replace the strings of underscores. 
	public static String result ( ) {
		// Your code goes here for calling printBoxScore 
		// It should be called for both visitor and home

		if (gameScore(visitorScores) > gameScore(homeScores)) {
			return "The visiting team won " 
					+ gameScore(visitorScores) + " to " + gameScore(homeScores)
					+ " in " + "__________" + " innings.";
		} 
		if (batter == 1) {
			return "The home team won " 
					+ gameScore(homeScores) + " to " + gameScore(visitorScores)
					+ " in " + "__________" + " innings.";
		} 
		if (batter == 2) {
			return "The home team won " 
					+ gameScore(homeScores) + " to " + gameScore(visitorScores)
					+ " in " + "__________" + " innings.";
		}
		return "";
	}

	
	// *** Main calls initialize, then calls readScores, then calls result
	// *** and prints the result of the game. It has been filled in for you similar to Lab 2
	public static void main (String [ ] args) {

		// main has been filled in in case your solution for lab 2 is overly complicated
		initialize ( );
		readScores (new Scanner (System.in));
		System.out.println (result ( ));
		
		// This can be uncommented to test whether your arrays have been set correctly
		/*for (int v : visitorScores)
			System.out.print(v + " ");
		System.out.println();
		for (int v : homeScores)
			System.out.print(v + " ");
		System.out.println();  */
		

	}
}