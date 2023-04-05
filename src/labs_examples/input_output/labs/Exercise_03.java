package labs_examples.input_output.labs;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import javax.imageio.ImageIO;

/**
 * Input/Output Exercise 3: variety
 *
 *    1) Demonstrate the usage of at least two additional Byte Streams
 *    2) Demonstrate the usage of at least two additional Character Streams
 *    3) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams 
 *    4) Demonstrate the use of the DataInputStream and DataOutputStream
 *
 */

public class Exercise_03{
	public static void main(String[] args) {
		
//Demonstrating ByteArrayInputStream
//Demonstrate using a buffer on the Byte Stream
		byte[] by = {106,97,118,97,13,10,105,115,13,10,102,117,110,33};
		//InputStream byArIs = new ByteArrayInputStream(by);
		BufferedInputStream bufr = 
				new BufferedInputStream(new ByteArrayInputStream(by));
		
		int x = 0;
		try {
			while((x = bufr.read()) != -1) {
				//Converting ASCII to text
				char c = (char)x;
				System.out.print(Character.toUpperCase(c));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//byArIs.close();
				bufr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

			
//Demonstrating using ByteArrayOutputStream to convert an image to a Byte Array	
		File image = new File("labs_examples/input_output/labs/sample image.png");
		try {
			//Read an image
			BufferedImage bImage = ImageIO.read(image);
			//Create an OutputStream
			ByteArrayOutputStream byArOs = new ByteArrayOutputStream();
			//Write the image to the OutputStream
			ImageIO.write(bImage, "png", byArOs);
			//Convert the data to a ByteArray
			byte[] imageData = byArOs.toByteArray();
			
			System.out.println("\n");
			//Print a portion of the image data to test
			for(int i = 0;i<50;i++) {
				System.out.print(imageData[i]+" ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//Demonstrate the LineNumberReader Character Stream
		LineNumberReader lnr = null;
		try {
			lnr = 
					new LineNumberReader(new FileReader("labs_examples/input_output/labs/byte_data"));
			
			int y = 0;
			int z = 0;
			System.out.println("\n");
			while((y = lnr.read()) != -1) {
				System.out.print((char)y);
				z = lnr.getLineNumber();
			}
			System.out.print("\nNumber of lines in the file: "+(z+1));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				lnr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
//Demonstrate using the CharArrayReader Character Stream
//Demonstrate using a buffer on the character stream
		File file = new File("labs_examples/input_output/labs/NierConcertScript.txt");
		//Create a char array with a size of the file length
		char[] chArr = new char[(int) file.length()];	
		FileReader fiRead = null;
		CharArrayReader chArrRead = null;
		BufferedReader br = null;
		
		try {
			fiRead = new FileReader(file);
			//Use FileReader to convert a file to a char array. This can improve program performance
			//if a large file needs to be read into memory.
			fiRead.read(chArr);
			chArrRead = new CharArrayReader(chArr);
			br = new BufferedReader(chArrRead);
			String a;
			System.out.println("\n");
			while((a = br.readLine()) != null) {
				System.out.println(a);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fiRead.close();
				chArrRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//Demonstrate using DataInputStream and DataOutputStream
		int a = 100;
		int b = 200;
		int c = 300;
		int d = 0;
		
		String dataFile = "labs_examples/input_output/labs/data_file.dat";
		//Try with resources
		try(DataOutputStream daOut = 
				new DataOutputStream(new FileOutputStream(dataFile)))
			{
				daOut.writeInt(a);
				daOut.writeInt(b);
				daOut.writeInt(c);
				daOut.writeInt(a+b+c);
			}
			catch (IOException e) {
				e.printStackTrace();
				}
		try(DataInputStream daIn = 
				new DataInputStream(new FileInputStream(dataFile)))
			{
				a = daIn.readInt();
				System.out.println(a);
				b = daIn.readInt();
				System.out.println(b);
				c = daIn.readInt();
				System.out.println(c);
				d = daIn.readInt();
				System.out.println("sum: "+d);
				
			}
			catch (IOException e) {
				e.printStackTrace();
			}
	}
}