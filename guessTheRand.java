import java.util.*;

public class Rndm{

	static int tries = 3;
	static int score = 0;

	static int random;
	
	public static void main(String[] args)
	{
		randomInt(); //generates the first random number
		core(new Scanner (System.in));
	}
	
	public static void core(Scanner in)
	{
	    
		//System.out.print("[debug] number is: "+ random + "\n");
		System.out.print("\nScore:" + score + "\nChance(s):" + tries + "\nEnter Number: ");
	    
	    	int guess = in.nextInt();

	    	if(guess == random) //if the answer is correct
	    	{
			score++; //add score
			randomInt(); //new random number
			core(in); //calls this function
		} else {
		    	int check = ((random > guess) ? 1 : 0); //
			if(tries <= 1) //fix being able to guess when there's 0 chance
			{
			    System.out.println("--[ Game over! ]--\nTry Again [1/0]? ");
			    if(in.nextInt() == 1)
			    {
			        // calls core again and resets everything
			        tries = 3;
			        score = 0;
			        randomInt();
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
			    tries--; //decrease try count
			    core(in); //calls this function
			}
		}
	}
	
	public static void randomInt()
	{
        	int a = new Random().nextInt(10); //returns new random number
        
		if(a == random)
		{
		   randomInt(); //re-run if it is the same as the last one
		}
        
        	random = a; //save the new random number
	}
}
