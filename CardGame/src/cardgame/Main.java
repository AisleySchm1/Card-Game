package cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	static ArrayList<Card> player1Hand = new ArrayList<Card>();
    static ArrayList<Card> player2Hand = new ArrayList<Card>();
    static ArrayList<Card> player3Hand = new ArrayList<Card>();
    static int player1Counter = 1;
    static int player1ChipCounter = 3;
    static int player2Counter = 1;
    static int player2ChipCounter = 3;
    static int player3Counter = 1;
    static int player3ChipCounter = 3;

  public static void main(String[] args)
  {
    Deck.fillDeck();
    Deck.shuffle();
    boolean isPlaying = true;
     while(isPlaying)
    {
     dealCards(); 
    playGame();
    endGame1();
    showChips();
    endGame2();
    redeal();
    }
  }
    

    public static void dealCards()
    {
      System.out.println("Hi! Lets play SCAT!\nEach player starts with 3 chips and every time you lose you have to get rid of a chip. The last player to still have chips wins!\n\nYour cards are:");
      System.out.println();
    
      

      
      for (int i = 0; i < 3; i++)
        {
          player1Hand.add(Deck.deck.get(0));
          Deck.deck.remove(0);
           System.out.println(player1Hand.get(i).getRank() + " of " + player1Hand.get(i).getSuit());

          player2Hand.add(Deck.deck.get(0));
          Deck.deck.remove(0);

          player3Hand.add(Deck.deck.get(0));
          Deck.deck.remove(0);
        }
      
      
      Scanner userStringInput=new Scanner(System.in);
       System.out.println();
      System.out.println("Press enter to see if you win!");
      String win = userStringInput.nextLine();
      }

    public static void playGame()
      {

          {
          if (player1Hand.get(0).getSuit() == player1Hand.get(1).getSuit() && player1Hand.get(1).getSuit() == player1Hand.get(2).getSuit() && player1Hand.get(0).getSuit() == player1Hand.get(2).getSuit())
            {
            player1Counter ++;
            player1Counter ++;
            }
      else if (player1Hand.get(0).getSuit() == player1Hand.get(1).getSuit())
          {
          player1Counter ++;
          }
        else if (player1Hand.get(1).getSuit() == player1Hand.get(2).getSuit())
          {
          player1Counter ++;
          }
          else if (player1Hand.get(0).getSuit() == player1Hand.get(2).getSuit())
            {
            player1Counter ++;
            }
           
          else if (player2Hand.get(0).getSuit() == player2Hand.get(2).getSuit())
            {
              player2Counter ++;
            }
           else if (player2Hand.get(1).getSuit() == player2Hand.get(2).getSuit())
            {
            player2Counter ++;
            }
             else if (player2Hand.get(0).getSuit() == player2Hand.get(1).getSuit())
               {
               player2Counter ++;
               }
            else if (player3Hand.get(0).getSuit() == player3Hand.get(2).getSuit())
            {
              player3Counter ++;
            }
            else if (player3Hand.get(1).getSuit() == player3Hand.get(2).getSuit())
              {
              player3Counter ++;
              }
            else if (player3Hand.get(0).getSuit() == player3Hand.get(1).getSuit())
              {
              player3Counter ++;
              }
            
               System.out.println("You have "+player1Counter+" cards of the same suit. \n\nPlayer two has "+player2Counter+" cards of the same suit.\n\nPlayer three has "+player3Counter+" cards of the same suit. \n");

          }
      }


         public static void endGame1()
           {
            
          if  (player1Counter == player2Counter && player1Counter == player3Counter && player2Counter == player3Counter)
          {
          System.out.println("Everyone loses a chip!");
            player1ChipCounter --;
            player2ChipCounter --;
            player3ChipCounter --;
     }
        else if (player1Counter == player2Counter && player1Counter > player3Counter && player2Counter > player3Counter)   
        {
          System.out.println("You and Player two win! Player three loses a chip!");
          player3ChipCounter --;
        }
          else if (player2Counter == player3Counter && player2Counter > player1Counter && player3Counter > player1Counter)
          {
            System.out.println("Player two and Player three win! You lose a chip!");
            player1ChipCounter --;
          }
            else if (player1Counter == player3Counter && player1Counter > player2Counter && player3Counter > player2Counter)
            {
              System.out.println("You and Player three win! Player two loses a chip!");
              player2ChipCounter --;
            }
        else if (player1Counter > player2Counter && player1Counter > player3Counter)
        {
          System.out.println("Player two and Player three lose a chip!");
          player2ChipCounter --;
          player3ChipCounter --;
        }
        else if (player2Counter > player1Counter && player2Counter > player3Counter)
        {
          System.out.println("Player two Wins! You and Player three lose a chip!");
          player3ChipCounter --;
          player1ChipCounter --;
        }
        else if (player3Counter > player1Counter && player3Counter > player2Counter)
        {
          System.out.println("Player three Wins! You and Player two lose a chip!");
          player1ChipCounter --;
          player2ChipCounter --;
        }
             player1Counter = 1;
             player2Counter = 1;
             player3Counter = 1;
      }

    public static void showChips()
    {
      System.out.println();
      System.out.println("You have "+player1ChipCounter+" chips, Player two has "+player2ChipCounter+" chips, and Player three has "+player3ChipCounter+" chips.");
      System.out.println();
    }

    

    public static void endGame2()
    {
      if (player1ChipCounter == 0 && player2ChipCounter == 0)
      {
        System.out.println("Player three wins!");
        System.exit(0);
      }
      else if (player1ChipCounter == 0 && player3ChipCounter == 0)
      {
        System.out.println("Player two wins!");
        System.exit(0);
      }
      else if (player2ChipCounter == 0 && player3ChipCounter == 0)
      {
        System.out.println("You win!");
        System.exit(0);
      }
      
  }

    public static void redeal()
    {
      player1Hand.clear();
      player2Hand.clear();
      player3Hand.clear();

      
     // if (player1ChipCounter > 0)
     // {  
     //   for (int i = 0; i < 3; i++)
     //     {
     //   player1Hand.add(Deck.deck.get(0));
     //   Deck.deck.remove(0);
     //    System.out.println(player1Hand.get(i).getRank() + " of " + player1Hand.get(i).getSuit());
     //     }
     // }

     //  if (player2ChipCounter > 0)
     //  {
     //    for (int i = 0; i < 3; i++)
     //      {
     //    player2Hand.add(Deck.deck.get(0));
     //    Deck.deck.remove(0);
     //      }
     //  }

     //  if (player3ChipCounter > 0)
     //  {
     //    for (int i = 0; i < 3; i++)
     //      {
     //    player3Hand.add(Deck.deck.get(0));
     //    Deck.deck.remove(0);
     //      }
     //  }
      
    }
}
