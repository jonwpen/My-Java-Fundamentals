package labs_examples.input_output.labs;
import java.io.BufferedInputStream; 
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Input/Output Exercise 1: File input/output
 *
 *      Using the BufferedInputStream, read a text file 5 bytes at a time and write each byte to a new file.
 *      Make sure you close the connections to both files.
 *
 *
 */
class Example {
    public static void main(String[] args) {
    	
    	FileInputStream inputStream = null;
    	BufferedInputStream bufferedInputStream = null;
    	FileOutputStream fw = null;
    	BufferedOutputStream bw = null;
    	
    	try {
			inputStream = new FileInputStream("labs_examples/input_output/labs/byte_data");
			bufferedInputStream = new BufferedInputStream(inputStream);
			//create a new file
			fw = new FileOutputStream("labs_examples/input_output/labs/byte_data_copy");
			//Define the buffer size in the output to match the input buffer size.
			bw = new BufferedOutputStream(fw, 5);
			
			byte[] data = new byte[5];
	    	int readBytes = 0;
	    	
	    	while((readBytes = bufferedInputStream.read(data)) != -1) {
	    		System.out.print(new String(data,0,readBytes)+" ");
	    		bw.write(data);
	    			
	    	}
		} catch (IOException exc) {
			exc.printStackTrace();
		}
    	finally {
    		try {
    			inputStream.close();
    			bufferedInputStream.close();
    			fw.close();
    			bw.close();
    		
    	}catch(IOException ex) {
    		ex.printStackTrace();
    	}
    	}
    }
}