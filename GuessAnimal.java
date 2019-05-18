/*
Name: Taiyi Pan
Lab assignment: Lab 5B
Text editor: Atom
Java version: 1.8.0_162
OS: Windows 10
*/
import java.util.Scanner;
/** This class uses binary decision tree to implement an expert system
    to guess what animal the user is thinking of */
public class GuessAnimal
{
  private static class BTNode //this class is used as a basic node in decision tree
  {
    String text;
    BTNode yes;
    BTNode no;
  }
  public static void main(String[] args) //main method
  {
    //variables
    String A, Q;
    char yesNo, again = 'y';
    Scanner scan = new Scanner(System.in);
    //intro
    System.out.println("\nHi! My name is Cassandra. :)");
    System.out.println("I am your expert system, powered by the awesomeness of decision trees.");
    System.out.println("Let's play a game of guessing animals!");
    //set up root node
    BTNode root = new BTNode();
    root.text = "elephant";
    root.yes = null;
    root.no = null;
    do //main do while loop - each cycle is one round of guessing game
    {
      System.out.println("\nPlease think of an animal.");
      System.out.println("Are you ready?");
      System.out.print("[Y or N]: "); //pause game for player to brainstorm
      try
      { yesNo = scan.nextLine().trim().toLowerCase().charAt(0); }
      catch (StringIndexOutOfBoundsException e)
      { yesNo = 'y';}
      if (yesNo == 'n')
        continue;
      BTNode p = root; //assign iterator to root
      while (true)
      {
        if (p.yes == null) //if at leaf node
        {
          System.out.println("My guess is " + p.text + ".");
          System.out.println("Did I guess correctly?");
          System.out.print("[Y or N]: ");
          try
          { yesNo = scan.nextLine().trim().toLowerCase().charAt(0); }
          catch (StringIndexOutOfBoundsException e)
          { yesNo = 'y';}
          if (yesNo == 'y')
          {
            System.out.println("Yay, I am so smart!");
            break;
          }
          System.out.println("Aww bummer!");
          System.out.println("What animal are you thinking of?");
          A = scan.nextLine().trim();
          //ask user for a yes/no question
          System.out.println("Please write a yes/no question that differentiates " + A + " from " + p.text + ".");
          Q = scan.nextLine().trim();
          System.out.println("For a " + A + ": " + Q);
          System.out.print("[Y or N]: "); //get answer for the yes/no question 
          try
          { yesNo = scan.nextLine().trim().toLowerCase().charAt(0); }
          catch (StringIndexOutOfBoundsException e)
          { yesNo = 'y';}
          BTNode Y = new BTNode();
          BTNode N = new BTNode();
          if (yesNo == 'y')
          {
            Y.text = A;
            N.text = p.text;
          } //end if
          else
          {
            N.text = A;
            Y.text = p.text;
          } //end else
          p.text = Q;
          Y.yes = null;
          N.yes = null;
          Y.no = null;
          N.no = null;
          p.yes = Y;
          p.no = N;
          break;
        } //end if
        else //if there are children node below
        {
          System.out.println(p.text); //ask question
          System.out.print("[Y or N]: ");
          try
          { yesNo = scan.nextLine().trim().toLowerCase().charAt(0); }
          catch (StringIndexOutOfBoundsException e)
          { yesNo = 'y';}
          if (yesNo == 'y')
            p = p.yes;
          else
            p = p.no;
        } //end else
      } //end inner while loop
      System.out.print("Play again? (y/n) "); //again?
      try
      { again = scan.nextLine().trim().toLowerCase().charAt(0); }
      catch (StringIndexOutOfBoundsException e)
      { again = 'n'; }
    } while (again == 'y'); //end main do while loop
    System.out.println("\nThank you for playing, auf wiedersehen! :D\n");
  } //end main method
} //end GuessAnimal class
//include output
