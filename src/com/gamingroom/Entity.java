package com.gamingroom;

public class Entity {
  private long id;
  private String name;

  // Hide default constructor to prevent empty instances
  protected Entity() {}
  
  public Entity(long id, String name) {
    this();
    this.id = id;
    this.name = name;
  }

	/**
	 * @return the id
	 */
  public long getId() {
    return id;
  }

  /**
	 * @return the name
   */
  public String getName() {
    return name;
  }

  public String toString() {
    return "Entity [id=" + id + ", name=" + name + "]";
  }
}