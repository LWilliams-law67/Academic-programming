/**
* This class represents a Player and contains the data and methods
* to implement a Player object in a game
*
* @author Luke Williams
* @version 1.0
*
* COP3320   Project 4
* file name   Player.java
*/
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

/**
 * The Class Player.
 */
public class Player {
  
  /** The name. */
  private String name;
  
  /** The gamertag. */
  private String gamertag;
  
  /** The score. */
  private int score;
  
  /** The out file. */
  private FileOutputStream outFile;
  
  /** The out FS. */
  private PrintWriter outFS;

  /**
   * Open file.
   *
   * @param playerFile the player file
   */
  private void openFile(File playerFile) {
	  try {
    	outFile = new FileOutputStream(playerFile, false);
        outFS = new PrintWriter(outFile);
      } catch (IOException e) {
        System.out.println("Caught Exception: " + e.getMessage());
      } 
  }
  
  /**
   * Read player file.
   *
   * @param scnrFS the scnr FS
   */
  private void readPlayerFile(Scanner scnrFS) {
	  scnrFS.useDelimiter(",|\r\n");
	  this.name = scnrFS.next();
	  this.gamertag = scnrFS.next();
	  this.score = scnrFS.nextInt();
	  scnrFS.close();
  }

  /**
   * Close file.
   */
  public void closeFile() {
    outFS.close();
  }

  /**
   * Instantiates a new player.
   *
   * @param playerFile the player file
   * @param name the name
   * @param gamertag the gamertag
   */
  public Player(File playerFile, String name, String gamertag) {
    setName(name);
    setGamertag(gamertag);
    openFile(playerFile);
  }
  
  /**
   * Instantiates a new player.
   *
   * @param playerFile the player file
   * @param scnrFS the scnr FS
   */
  public Player(File playerFile, Scanner scnrFS) {
	  readPlayerFile(scnrFS);
	  openFile(playerFile);
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the gamertag.
   *
   * @param gamertag the new gamertag
   */
  public void setGamertag(String gamertag) {
    this.gamertag = gamertag;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the gamertag.
   *
   * @return the gamertag
   */
  public String getGamertag() {
    return gamertag;
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public int getScore() {
    return score;
  }

  /**
   * Adds the score.
   *
   * @param score the score
   */
  public void addScore(int score) {
    this.score += score;
  }

  /**
   * Save player file.
   */
  public void savePlayerFile() {
	  outFS.printf("%s,%s,%d", getName(), getGamertag(), getScore());
  }

}
