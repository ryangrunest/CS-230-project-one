package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a game
 * 
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * 
 * @author coce@snhu.edu
 *
 */

public class Game extends Entity {
  private List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
    super(id, name);
	}

  public Team addTeam(String name) {
    // local empty team instance
    Team team = null;

    // init iterator
    Iterator<Team> iterator = teams.iterator();

    // use iterator to look for existing team with same name
    // if found, set local var to team value
    while (iterator.hasNext() && team == null) {
      Team i = iterator.next();

      if (i.getName() == name) {
        team = i;
      }
    }

    // if no team was found, create new team and add to teams list
    if (team == null) {
      team = new Team(1, name); // TODO: pass in unique id
      teams.add(team);
    }

    // return the new or existing team
    return team;
  }

	@Override
	public String toString() {
		
		return "Game [id=" + this.getId() + ", name=" + this.getName() + "]";
	}
}
