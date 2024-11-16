package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		// obtain local reference to the singleton instance
		GameService service = GameService.getInstance();
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
      Game currentGame = service.getGame(i);

			System.out.println(currentGame);

      for (int j = 1; j <= 4; j++) {
        Team team = currentGame.addTeam("Team #" + j);
        System.out.println(team);

        for (int k = 1; k <= 4; k++) {
          Player player = team.addPlayer("Player #" + k);
          System.out.println(player);
        }
      }
		}
	}
}
