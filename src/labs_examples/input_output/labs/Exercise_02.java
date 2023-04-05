package labs_examples.input_output.labs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Input/Output Exercise 2: File encryption
 *
 *      -Using the BufferedReader, read a file character by character and write an encrypted version to a new file.
 *      -For example, change every 'a' to '-' and every 'e' to '~' .
 *      -Make sure you close the connections to both files.
 *
 *      Then, read back the encrypted file using the BufferedReader and
 *      print out the unencrypted version. Does it match the original file?
 *
 */

public class Exercise_02{
	public static void main(String[] args) {
		
		String filepath = "labs_examples/input_output/labs/Exercise_2_textfile.txt";
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		FileReader fr2 = null;
		BufferedReader br2 = null;
		
		try {
			fr = new FileReader(filepath);
			br = new BufferedReader(fr);
			fw = new FileWriter("labs_examples/input_output/labs/Exercise_2_textfile_copy.txt");
			bw = new BufferedWriter(fw, 2);
			
			int str;
            do {
                str = br.read(); 
                if(str != -1)
                    if ((char) str == 'e')
                        str = '!';
                    if ((char) str == 'a')
                        str = '=';
                    if ((char) str == 's')
                        str = '+';
                    if ((char) str == 'h')
                        str = '/';
                    if ((char) str == 'i')
                        str = '%';
                    bw.write((char)str); 
                    System.out.print((char)str);
            } while(str != -1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fr != null) {
				try {
					//fr.close();
					br.close();
					//fw.close();
					bw.close();
				} catch (IOException e) {
					System.out.println("Error in closing input");
				}
			}
		}
		System.out.println();
		//Decrypt and read the encrypted file.
		try {
			fr2 = new FileReader("labs_examples/input_output/labs/Exercise_2_textfile_copy.txt");
			br2 = new BufferedReader(fr2);
			int str2;
			while((str2=br2.read()) != -1) {
                if ((char) str2 == '!')
                    str2 = 'e';
                if ((char) str2 == '=')
                    str2 = 'a';
                if ((char) str2 == '+')
                    str2 = 's';
                if ((char) str2 == '/')
                    str2 = 'h';
                if ((char) str2 == '%')
                    str2 = 'i';
				System.out.print((char)str2);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			if(fr2 != null) {
				try {
					br2.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
}
