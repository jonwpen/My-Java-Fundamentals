package labs_examples.input_output.labs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 *      Following the video examples and source code found in the src/labs_examples/input_output/examples/csv_parser
 *      package, create a new application that will parse a custom CSV file that you created and map each line of the
 *      csv to a custom POJO that you create.
 *
 *      Then add that object to an arraylist. After you have mapped each row of the csv to objects
 *      and added each object to an arraylist, print out each object using the objects custom toString() method.
 *
 *      Then, write the arraylist of objects back out to a new .csv file. Ensure that the resulting csv file is valid.
 *
 */
public class Exercise_04{
	public static void main(String[] args) {
//Create .csv file
		try(FileWriter fw = 
				new FileWriter("labs_examples/input_output/labs/amazon_associates.csv")) 
			{
			fw.write("area manager,gargo,3.5,back half day,Gabby Zargo\n"
					+ "problem solver,jopennin,2.5,flex,John Pennington\n"
					+ "inventory problem solver,igguintj,2.9,front half day, Jane Guimte");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String csvPath = "labs_examples/input_output/labs/amazon_associates.csv";
		ArrayList<AmazonAssociate> aa = new ArrayList<AmazonAssociate>();
		try(BufferedReader br = new BufferedReader(new FileReader(csvPath)))
		{
			String line;
//Read file and copy it to a String array that is split along commas
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
//For each line read, values will be mapped to a new object and added to an ArrayList
				aa.add(mapValues(values));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(AmazonAssociate a : aa) {
			System.out.println(a.toString());
		}
//Write the ArrayList to a new .csv file that is an exact match with the original .csv file.
		try 
			(FileWriter fw = new FileWriter("labs_examples/input_output/labs/copied_from_arraylist.csv"))
			{
			String s;
			System.out.println();
			for(int i = 0;i<aa.size();i++) {
				fw.write(aa.get(i).getPosition()+","+aa.get(i).getID()+","+String.valueOf(aa.get(i).getTenure())+","+aa.get(i).getShift()+","+aa.get(i).getName()+"\n");
				System.out.println(aa.get(i).getPosition()+","+aa.get(i).getID()+","+String.valueOf(aa.get(i).getTenure())+","+aa.get(i).getShift()+","+aa.get(i).getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static AmazonAssociate mapValues(String[] values) {
		AmazonAssociate amAs = new AmazonAssociate();
		amAs.setPosition(values[0]);
		amAs.setID(values[1]);
		amAs.setTenure(Double.parseDouble(values[2]));
		amAs.setShift(values[3]);
		amAs.setName(values[4]);
		return amAs;
	}
}


class AmazonAssociate{
	private String position;
	private String ID;
	private double tenure;
	private String shift;
	private String name;
	
	public AmazonAssociate() {
	}
	public AmazonAssociate(String position,String ID,double tenure,String shift,String name) {
		this.position=position;
		this.ID=ID;
		this.tenure=tenure;
		this.shift=shift;
		this.name=name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public double getTenure() {
		return tenure;
	}
	public void setTenure(double tenure) {
		this.tenure = tenure;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "amazon_associate [position=" + position + ", ID=" + ID + ", tenure=" + tenure + ", shift=" + shift
				+ ", name=" + name + "]";
	}
}