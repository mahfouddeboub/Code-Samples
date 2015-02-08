package technicalTest.shazam.word_count;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Shazam technical test by Mahfoud Deboub
 *
 */

//A class that will count the number of words in a file and print the count to the console
public class App 
{
    public static void main( String[] args )
    {
    	int line_counter = 0;
		int word_counter = 0;
		// If nothing is entered in command Prompt.	
		if(args.length == 0)
			System.out.println("No file was entered");
		// if the filename entered consist of more than 2 words.
		else if(args.length > 2)
		     System.out.println("file name is wrong");
		else{
			// if the filename consist of only one word.
			if(args.length == 1){
				File newFile = new File(args[0]);
				if(!newFile.isFile()){
					System.out.println("file does't exisit");
				}
				else{
					try{
						FileReader fr = new FileReader(newFile);
						   BufferedReader br = new BufferedReader(fr);
						   String s;
						   while((s = br.readLine())!= null){	
							   String []ss = s.split(" ");
							   for(String m :ss){
								 if(m.length()>0)
									 word_counter++;   
						         }  
						   }
						   System.out.println(" This file contains: "+word_counter+" words");
						   br.close();
					}catch(FileNotFoundException e){
						System.out.println("e");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			// if file name entered consist of "-l" followed by a one word.
			else
				if(args[0].equals("-l")){
				   File newFile = new File(args[0]+ " "+args[1]);
				   if(!newFile.isFile()){
					  System.out.println("file does't exisit");
				  }
				  else{
					try{
						FileReader fr = new FileReader(newFile);
						   BufferedReader br = new BufferedReader(fr);
						   String s;
						   while((s = br.readLine())!= null){
						        line_counter++;
						        String []ss = s.split(" ");
								   for(String m :ss){
									 if(m.length()>0)
										 word_counter++;   
							         }  
						   }
						   System.out.println(" This file contains: "+line_counter+" lines");
						   System.out.println(" This file contains: "+word_counter+" words");
						   br.close();
					}catch(FileNotFoundException e){
						System.out.println("e");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
    }
}
