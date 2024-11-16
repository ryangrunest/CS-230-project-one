package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

  /*
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;

  /*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1;

	/*
		Description of Singleton:

		A singleton design pattern allows the creation of only one instance of an object in memory. 
		The class itself provides a getter that returns the single instance of the object.
		To do this, the constructor of the object needs to be private. There is also a private variable
		- in this case singleGameService - that is set to the single instantiation of the class.
		We then have a defined public getInstance method, that returns that private variable. 
	*/ 

	// Add missing pieces to turn this class a singleton
	private static GameService singleGameService = new GameService();

	private GameService() {}

	public static GameService getInstance() {
		return singleGameService;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {
		// a local game instance
		Game game = null;
    // initializing the iterator
    Iterator<Game> iterator = games.iterator();

    // Use iterator to look for existing game with same name
		// if found, set local game variable to game value
    while (iterator.hasNext() && game == null) {
      Game i = iterator.next();

      if (i.getName() == name) {
        game = i;
      }
    }

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

    /*
		 * Iterator Pattern:
		 * 
     * If there is a game that matches the 
		 * argument passed - either id or name, then set the local game variable to that game.
		 * If there was never a game found with the passed argument, 
     * then the local game variable is still null, and therefore the returned value would be null. 
		 * 
    */

		// a local game instance
		Game game = null;
    // instantiate iterator
    Iterator<Game> iterator = games.iterator();

    // Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
    while (iterator.hasNext() && game == null) {
      Game i = iterator.next();

      if (i.getId() == id) {
        game = i;
      }
    }

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {
    /*
		 * Iterator Pattern:
		 * 
     * If there is a game that matches the 
		 * argument passed - either id or name, then set the local game variable to that game.
		 * If there was never a game found with the passed argument, 
     * then the local game variable is still null, and therefore the returned value would be null. 
		 * 
    */

		// a local game instance
		Game game = null;
    // instantiate iterator
    Iterator<Game> iterator = games.iterator();

    // Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
    while (iterator.hasNext() && game == null) {
      Game i = iterator.next();

      if (i.getName() == name) {
        game = i;
      }
    }

    return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

  public long getNextPlayerId() {
    return nextPlayerId++;
  }

  public long getNextTeamId() {
    return nextTeamId++;
  }
}
