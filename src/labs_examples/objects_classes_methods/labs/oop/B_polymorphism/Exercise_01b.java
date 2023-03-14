package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class Exercise_01b {
		//This is a program that generates different types of color palettes and makes adjustments to colors. It can later be upgraded with a GUI framework.

	public static void main(String[] args) {
		

		RGBcolor red = new RGBcolor(235, 38, 38);
		red.lighten();
		RGBcolor yellow = new RGBcolor(244, 234, 15);
		red.mixTwo(yellow.r, yellow.g, yellow.b);
		
		Hue h = new Hue(100);
		h.mixTwo(30, 270, 0);
		h.mixTwo(30, 90, 0);
		
		h.createPalette(36, 220);
		h.createPalette(50, 330, 196);
		h.createPalette(112);
		
		h.lighten();
	}
}
interface Color{
	public void lighten();
	public void mixTwo(int a,int b,int c);
}
class RGBcolor implements Color{
	//This class can take any color and lighten it or mix it with any other color.
	int r;
	int g;
	int b;
	RGBcolor(int r, int g, int b){
		this.r = r;
		this.g = g;
		this.b = b;
	}
	@Override
	public void lighten() {
		int r2 = (255-r)/5;
		int g2 = (255-g)/5;
		int b2 = (255-b)/5;
		r+=r2;
		g+=g2;
		b+=b2;
		System.out.println(r+" "+g+" "+b);
	}
	
	@Override
	public void mixTwo(int x,int y,int z) {
		int r2 = (r+x)/2;
		int g2 = (g+y)/2;
		int b2 = (b+z)/2;
		System.out.println(r2+" "+g2+" "+b2);
	}
}
class Hue implements Color{
	//This class only controls hue. There is no adjustment to saturation or brightness.
	int hue;
	Hue(int hue){
		this.hue=hue;
	}
	@Override
	public void lighten() {
		//lighten by moving along the 360 degree color wheel. The closer to yellow, the lighter the color.
		int y=65;
		int l=0;
		if(hue>=y+20 && hue<=180) {
			l=hue-20;
		}
		if(hue<=y-20) {
			l=hue+20;
		}
		if(hue>180 && hue<=340) {
			l=hue+20;
		}
		if(y-hue<=20 && y>hue) {
			l=65;
		}
		System.out.println(l);
	
		
	}
	@Override
	public void mixTwo(int a, int b, int c) {
		//mix by finding the middle point on the color wheel between two hues
		int d=0;
		int e=0;
		if(b-a<=180) {
			e=b-a;
		}
		if(b-a>180) {
			d=(360-b)+a;
			e=(d/2)+b;
		}
		System.out.println(e);
	}
	public void createPalette(int a) {
		if(a>360) {
			System.out.println("Enter a valid hue.");
		}
		else {
			System.out.println("Your monochromatic palette: "+a);
		}
		
	}
public void createPalette(int a, int b) {
	if(a>360) {
		System.out.println("Enter a valid hue.");
	}
	else {
	System.out.println("Your limited palette: "+a+" and "+b);
	}
}
public void createPalette(int a, int b, int c) {
	if(a>360) {
		System.out.println("Enter a valid hue.");
	}
	else {
	System.out.println("Your complex palette: "+a+", "+b+", and "+c);
		}
	}
}




