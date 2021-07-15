import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		
		 Scanner in = new Scanner(System.in);	
		  int lives=8;
		  int i;	   
		  char choice;
		  char guess;
		  int length;	  
		  int wins=0;
		  int games=0;
		  
		  while(true){ 
			  
			  MainMenu();
		      choice=in.next().charAt(0);
		      choice = Character.toUpperCase(choice);
		      
			  switch(choice){
			   	case 'N':
			   		
			   		Random rand = new Random();
			   		int arithmos=rand.nextInt(31);
			   		String word = Dictionary.getWord(arithmos);
			   		length=word.length();
			   		
			   		char[] chars=new char[length];
			   		chars = word.toCharArray();
			   		
			   		char[] dash=new char[length];
			   		for(i=0;i<length;i++) {
			   			dash[i] = '-';
			   		}
			   		
			   		lives=8;
			   		int correct=0;
			   		int wrong=0;		   			   			
		   			
			   		while ( Arrays.equals(dash, chars)== false && lives>0 ){
			   			boolean found=false;
			   			Print(dash,length,lives);
			   			guess=in.next().charAt(0);
			   			
			   			if((guess >= 'A' && guess <= 'Z' ) || ( guess>='a' && guess<='z')) {
			   				for(i=0;i<length;i++) {
			   					if(chars[i] == Character.toUpperCase(guess)) {
			   						dash[i] = Character.toUpperCase(guess);  //replaces - with guessed letter in caps             
			   							found = true; 
			   					}
			                 
			   				}
			   				if(found == true){
			   					System.out.println("The guess is CORRECT! ");
			   					correct++;
			   				}else if (found == false){
			   					System.out.println("There are no "+guess+"'s in the word. ");
			   					wrong++;
			   					lives=lives-1;
			   				}
			   				if(lives>0 && lives<=8 && Arrays.equals(dash, chars) == true ) {
			   					System.out.println("Congratulations! You guess the word: "+word+" !");
			   					System.out.println("You make "+correct+" correct guess/es and "+wrong+" wrong guess/es!");
			   					wins++;
			   					lives=0;
			   					break;
			   				}else if(lives==0) {
			   					System.out.println("You failed to guess the word "+word+" !");
			   				}
			   			}else {
			   				System.out.println("Enter a valid character!");		   			
			   		    }		   		  
			   		}		   		
			   		games++;
			  	    break;
			  	    
			   	case 'S':
			   		
			   		if(games!=0) {
			   			System.out.println("You have played so far "+games+" games. "
			   					+ "You won "+wins+" times and lost "+(games-wins)+" times");
			   		}else {
			   			System.out.println("You have not play yet!");
			   		}
			   		break;
			   		
			   	case 'E':
			   		System.out.println("End of Program !"); 
			   		System.exit(0);
			   		in.close();
			   		break;
			  }		  
			  
		 }
		  
	}
		
	  public static void MainMenu() {
		
		System.out.println("Main Menu :");
		System.out.println("   -  Start a new Game (N/n) ");
		System.out.println("   -  Statistics (S/s) ");
		System.out.println("   -  Exit (E/e) ");
		System.out.println("Please enter your choice :");
	  }
	  public static void Print(char dash[],int length,int lives) {
		
		System.out.print("The random word is now :");	
		for(int i=0;i<length;i++) {
			  System.out.print(dash[i]);
		}
		System.out.print("\nYou have "+lives+" guess/es left.");
		System.out.print("\nYour guess :");
	  }

	}
	

