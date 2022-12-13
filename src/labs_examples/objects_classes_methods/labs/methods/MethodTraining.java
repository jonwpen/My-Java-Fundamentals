package labs_examples.objects_classes_methods.labs.methods;

import java.util.ArrayList;
import java.util.Scanner;

public class MethodTraining {

	private static Scanner sc;

	public static void main(String[] args) {
		
		int c = 31;
		int d = 2;
		int e = 10;
		int h = 21;
		int arr[] = {53,34,33,21,12,49,812,4};
		
		Scanner sc = new Scanner(System.in);
		//1)-------------------------------------------------------------
		int f = overLoaded(c,d);
		int g = overLoaded(c,d,e);
		System.out.println(f+" "+g+" "+(f+g));
		System.out.println();
		//2)-------------------------------------------------------------
		passByVal(c);
		System.out.println("c is still: "+c);
		Racer racer = new Racer("Ken Miles", "GT40", 1);
		System.out.println(racer.toString()); 
		racer.changeWinner(racer);
		System.out.println(racer.toString()); //The original object's attributes have changed
		System.out.println();
		//3)-------------------------------------------------------------
		int mof = maxOfFour(c,d,e,h);
		System.out.println(mof);
		System.out.println();
		
		//4)-------------------------------------------------------------
		System.out.println("Type a word");
		String str = sc.nextLine();
		System.out.println(consonants(str));
		System.out.println();
		//5)-------------------------------------------------------------
		System.out.println(primeCheck(e));
		System.out.println();
		
		
		//6)-------------------------------------------------------------
		int[] arrTest = {37, 91, 98, 72, 24, 1, 3, 95};
		int[] aT = minMax(arrTest);
		for(int i: aT) {
			System.out.println(i);}
		System.out.println();
		//7)-------------------------------------------------------------
		ArrayList<Integer> l = divisorList(30,2,3);
		for(int i=1;i<=l.size()-1;i++) {
			System.out.println(l.get(i));
		}
		System.out.println();
		//8)-------------------------------------------------------------
		int[] rA = reverseArray(arr);
		for(int i: rA) {
			System.out.println(i);
		}
		
		sc.close();

	}
//1) Demonstrate method overloading in this class
	public static int overLoaded(int a, int b) {
		return a*b;
	}
	public static int overLoaded(int a, int b, int c) {
		return a*b*c;
	}
//2) Demonstrate the difference between "pass by value" and "pass by reference"
	public static void passByVal(int a) {
		a = a*a;
		System.out.println(a);
	}
//3) Create a method that will return the largest of 4 numbers (all of which are passed in as arguments)
	public static int maxOfFour(int a, int b, int c, int d) {
		int max = 0;
		int[] arr = {a,b,c,d};
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}

//4) Write a method to count all consonants (the opposite of vowels) in a String
	public static int consonants(String s) {
		
		int cons = 0;
		char[] b = s.toCharArray();
		char[] v = {'a','e','i','o','u'};
		
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<v.length;j++) {
				if(b[i]==v[j]) {
					cons+=1;
				}
			}
		}
		cons=s.length()-cons;
		return cons;
	}
//5) Write a method that will determine whether or not a number is prime
	public static String primeCheck(int a) {
		int[] arr = {2,3,4,5,6,7,8,9};
		String p = "not prime";
		for(int i=0;i<arr.length;i++) {
			if(a%arr[i]!=0) {
				p="prime";
			}
			break;
		}
		return p;
	}
//6) Write a method that will return a small array containing the highest and lowest numbers in a given numeric array,
//which is passed in as an argument
	public static int[] minMax(int[] a) {
		int max = 0;
		int min = 0;
		
		for(int i=0;i<a.length;i++) {
			if(a[i]>max) {
				max = a[i];
			}
		}
		min = max;
		for(int i=0;i<a.length;i++) {
			if(a[i]<min) {
				min = a[i];
			}
		}
		int[] arr = {min, max};
		return arr;
	}
	//7) Write a method that takes 3 arguments (int maxNum, int divisor1, int divisor2) and returns an Integer Arraylist.
    //In this method create an Integer ArrayList and populate it with each number between zero and maxNum that is
    // divisible by both divisor1 and divisor2. Then return this ArrayList. After calling this method, print out the
    // length of the returned list
	public static ArrayList<Integer> divisorList(int maxNum, int divisor1, int divisor2){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<=maxNum;i++) {
			if(i%divisor1==0 && i%divisor2==0) {
				list.add(i);
			}
		}
		return list;
	}
   //8) Write a method that will reverse an array in place use only one extra temp variable. For this exercise you cannot
   // instantiate a second array. You must reverse the array in place using only one extra temp variable. Hint: this
   //variable is used to temporarily store individual values in the array
	public static int[] reverseArray(int[] a) {
		int temp = 0;
		for(int i=0;i<a.length/2;i++) {
			temp = a[i];
			a[i]=a[a.length-i-1];
			a[a.length-i-1]=temp;
		}
		return a;
	}
	
	
}
class Racer{
	
	public String car;
	public int rank;
	public String name;
	
	public Racer(String name, String car, int rank){
		 this.car = car;
		 this.rank = rank;
		 this.name = name;
		 
		
	}

	@Override
	public String toString() {
		return "Racer [car=" + car + ", rank=" + rank + ", name=" + name + "]";
	}
	public void changeWinner(Racer racer) {
		racer.name="Enzo Ferrari";
		racer.car="Ferrari 330";
		racer.rank=1;
	}
	
}






