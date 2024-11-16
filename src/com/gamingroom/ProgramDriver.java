package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// obtain reference to the singleton instance
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some test data
    for (int i = 1; i <= 4; i++) {
      Game game = service.addGame("Game #" + i);
      System.out.println(game);

      for (int j = 1; j <= 4; j++) {
        Team team = game.addTeam("Team #" + j);
        System.out.println(team);

        for (int k = 1; k <= 4; k++) {
          Player player = team.addPlayer("Player #" + k);
          System.out.println(player);
        }
      }
    }
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
