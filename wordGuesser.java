package project;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
import javax.swing.text.DefaultStyledDocument.ElementSpec;

import java.io.*;

public class project
{     
    public static void main (String args[])
    {
        //dictionary
        Dictionary reader = new Dictionary();
        String [] contents = reader.load("words.txt");

        //instances
        Scanner sc = new Scanner(System.in);

        System.out.println("\n Player Name: \n");
        //enter player name
        String input = sc.nextLine();

        //turns first letter in name to capital
        String playername  = input.substring(0,1).toUpperCase() + input.substring(1);

        System.out.println();

        //cat introduces you to the game
        System.out.println("            _______________________________________________________");
        System.out.println("           |                                                       | "); 
        System.out.println("           | Hello "+playername+","); 
        System.out.println("           | Welcome to  Word Jumble!                              | ");
        System.out.println("           | How many words can you guess with these letters...    | ");
        System.out.println("           |  _____________________________________________________|");
        System.out.println("           |/ ");
        System.out.println("  ^----^ ");
        System.out.println("(= O w O =)");
        System.out.println("[(_______)] ");
        System.out.println("  |_| |_|  ");

        System.out.println();
       
        System.out.println("Type 'ok' to  continue or 'no' to quit (^_^) ");
        String ok = sc.nextLine();
         
        if(ok.equalsIgnoreCase("ok"))
        {
           System.out.println();
           System.out.println("**********************************************");
           System.out.println();

           //game
           String consonants = "BCDFGHJKLMNPQRSTVWXYZ";
           String vowels = "AEIOU";

           /* Math.random will give any random number between  0 and 5 ,
             and +10  makes sure minimum length of string to 10,
             the random rumber will them be between 10  and 15 */

           int len = (int)(Math.random()*5)+10;
           char[] text = new char[len];
           

           for(int i = 0; i < len; i++)
           {
               if(i %2 == 0)
               {
                   text[i] = consonants.charAt((int)Math.floor(Math.random()*consonants.length()));
               }
               else
               {
                   text [i] = vowels.charAt((int)Math.floor(Math.random()*vowels.length()));
               }
           }

           System.out.println("*** | Here is your jumbled word, you have 10 attempts! | ***");
           System.out.println();

           for(int j = 0; j  < text.length; j++)
           {
             System.out.print(text[j]);
           }
           System.out.println();
           System.out.println();
           System.out.println("Guess here (T^T):");
           System.out.println();


           //user guess 10 words
           String [] guess = new String [10];
           int points = 0;

           //filling array ,stores guesses
           for( int k = 0 ; k < 10; k++)
           {
               System.out.print("* ");
               guess [k] =sc.nextLine().toUpperCase();

           }

           sc.close();


           //check
           char [] letter = new char [len];
           String temp = " ";
           int leng = 2; //store temp length
           int count = 0;

           //this loop checks each word
           for(int a = 0; a < 10; a++)
            {
                temp = guess [a];
                leng = temp.length();

                //fills the letter array with the jumbled array
                for(int b = 0; b < len; b++)
                {
                   letter [b] = text [b];
                }
                
                //checks each letter in user input 
                for(int c = 0; c < leng; c++)
                {
                    //checking each letter in the jumbled array
                   for(int d = 0; d <len ; d++)
                   {

                       if(temp.charAt(c) == letter [d])
                       {
                           letter[d] = ' ';
                           count++;
                           break;
                       }
                   }
                }
                

                if(count == leng)
                {
                    //check dictionary if user input exists
	               for(int z = 0;   z < contents.length; z++)
                   {
                      if(guess[a].equals(contents[z].toUpperCase()))
                      {
                          points++;
                          break;
                      }
                   }
                }
                else
                {  
                    System.out.println();
                    System.out.println("- Oops! "+temp+" is not in the jumbled word ( ' ^ ' ) -");
                }

                count = 0;
               
            }
            
        //ending part of game
          System.out.println();
          System.out.println("***************************************");  
          System.out.println();
          System.out.println("You guessed "+points+" words correctly!");
          System.out.println();
           
          //prizes  depending on how much points you earned
          if(points==0)
          {
            System.out.println("Congratulations! You get... ");
            System.out.println("............");
            System.out.println("............");
            System.out.println("nothing...");
            System.out.println();
            System.out.println("  ^----^ ");
            System.out.println("(= X _ X =)");
            System.out.println("[(_______)] ");
            System.out.println("  |_| |_|  ");
            System.out.println();

          }
          else if(points > 1 && points <= 4)
          {
            System.out.println("Congratulations! You get a rabbit :");
            System.out.println();
            System.out.println(" (\\  /)  ");
            System.out.println(" (0 x 0)  ");
            System.out.println(" (____)o ");
            System.out.println();
          }
          else if(points >= 5 && points < 7)
          {
            System.out.println("Congratulations! You get a pig :");
            System.out.println();
            System.out.println("   ^----^ ");
            System.out.println(" ( ' oo ' ) ");
            System.out.println("  ( u  u )");
            System.out.println("   |_| |_|       ");

            System.out.println();
          }
          else{
            System.out.println("ﾟ: *ﾟ:* | Congratulations! You got the ultimate prize | *:ﾟ*:ﾟ");
            System.out.println();
            System.out.println("    0-----0  ");
            System.out.println("  (*￣(ｴ)￣*)");
            System.out.println("  [(________)]");
            System.out.println("   |__| |__|  ");
            System.out.println();
            System.out.println("a bear!");
            System.out.println();

          }
         
          
        }
        else //if user does not want to play
        {
            //cat says bye to player 
            System.out.println();
            System.out.println("       __________________________________ ");
            System.out.println("      |                                  | ");
             System.out.println("      |   Ok bye bye! "+playername);
             System.out.println("      |  ________________________________|");
             System.out.println("      |/ ");
             System.out.println();
             System.out.println("  ^----^ ");
             System.out.println("(= T _ T =)");
             System.out.println("[(_______)] ");
             System.out.println("  |_| |_|  ");
             System.out.println();
        }

    }
}



//Dictionary class
class Dictionary {

    public String[] load(String file) {
        File aFile = new File(file);
        StringBuffer contents = new StringBuffer();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(aFile));
            String line = null;
            int i = 0;
            while ((line = input.readLine()) != null) {
                contents.append(line);
                i++;
                contents.append(System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Can't find the file - are you sure the file is in this location: " + file);
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Input output exception while processing file");
            ex.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                System.out.println("Input output exception while processing file");
                ex.printStackTrace();
            }
        }
        String[] array = contents.toString().split("\n");
        for (String s : array) {
            s.trim();
        }
        return array;
    }

    public void save(String file, String[] array) throws FileNotFoundException, IOException {

        File aFile = new File(file);
        Writer output = null;
        try {
            output = new BufferedWriter(new FileWriter(aFile));
            for (int i = 0; i < array.length; i++) {
                output.write(array[i]);
                output.write(System.getProperty("line.separator"));
            }
        } finally {
            if (output != null)
                output.close();
        }
    }
}
