package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
  // contains list of players on the team
  private static List<Player> players = new ArrayList<Player>();

	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
    super(id, name);
	}


  /*
   * Add player to the team
   * @return the created Player
   */
  public Player AddPlayer(String name) {
    Player newPlayer = null;

    // initialize the iterator
    Iterator<Player> iterator = players.iterator();

    // use the iterator to look for existing players on the team
    // with the same name. If found, set local player variable to player value
    while (iterator.hasNext() && newPlayer != null) {
      Player i = iterator.next();

      if (i.getName() == name) {
        newPlayer = i;
      }
    }

    // if no player was found, create a new player and add to team roster
    if (newPlayer == null) {
      newPlayer = new Player(1, name); // TODO: pass in unique id
      players.add(newPlayer);
    }

    return newPlayer;
  }

	@Override
	public String toString() {
		return "Team [id=" + this.getId() + ", name=" + this.getName() + "]";
	}
}
