import java.util.*;

public class Rndm{

	static int tries = 3;
	static int score = 0;
	
	static boolean random = true;
	static int number;
	
	public static void main(String[] args){
		Scanner reader = new Scanner (System.in);
		core(reader);
	}
	
	public static void core(Scanner in)
	{
	    
        int ran = randomInt(random); //gets a random or existing number | (boolean random)
        
        //System.out.print("[debug] number is: "+ ran + "\n");
	    System.out.print("\nScore:" + score + "\nChance(s):" + tries + "\nEnter Number: ");
	    
	    int guess = in.nextInt();

	    if(guess == ran) //if the answer is correct
	    {
	        score++; //add score
	        random = true; //new number
			core(in); //calls this function
		} else {
		    
		    int check = ((guess > ran) ? 0 : 1); //returns 0 if it's lower or 1 if it's higher
		    
			if(tries <= 1) //hack, fix being able to guess when there's 0 chance
			{
			    System.out.println("--[ Game over! ]--\nTry Again [1/0]? ");
			    if(in.nextInt() == 1)
			    {
			        // calls core again and resets everything
			        tries = 3;
			        score = 0;
			        random = true;
			        core(in);
			    } else {
			        System.out.println("Final Score: " + score); //returns final score
			    }
			} else {
			    switch(check)
			    {
			        case 1: System.out.println("> TIP: Higher <"); break;
			        case 0: System.out.println("> TIP: Lower <"); break;
			    }
			    tries--; //lessen try count
			    random = false; //not random
			    core(in); //calls this function
			}
		}
	}
	
	public static int randomInt(boolean random)
	{
	    if (random)
	    {
            int a = new Random().nextInt(10); //returns new random number
                if(a == number)
                {
                    randomInt(true); //re-run if it is the same as the last one
                }
            return number = a; //returns and save the new number (buggy)
	    } else {
	        return number; //returns same number
	    }
	}
}
