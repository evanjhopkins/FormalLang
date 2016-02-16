/**
 * file: driverDFA.java
 * author: Evan Hopkins
 * course: CMPT 440
 * assignment: Lab 2
 * due date: February 15, 2016
 * version: 1
 * 
 * This file contains a driver used to test the ManWolf class
 */

import java.util.Scanner;

/**
 * driverDFA
 * 
 * This is a driver that utilizes the ManWolf class to
 * evaluate soltutions to the man-wolf-cabbage-goat game
 */
public class driverDFA {
  public static void main(String args[]) {
    //initializations
    boolean solutionIsValid = false;
    ManWolf mwInstance = new ManWolf();
    //getting users proposed solution through cmd line argument
    String raw_input = args[0];

    //analyze the solution and capture its result
    solutionIsValid = mwInstance.analyze(raw_input);

    //Display approprite message to user based on analysis of their solution
    if(solutionIsValid) {
      System.out.println("That is a solution.");
    }else{
      System.out.println("That is not a solution.");
    }
  }
}
