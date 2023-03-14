package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

/**
 * Run the class below and study the output. What prints and why?
 *
 * Your answer:
 * You have instantiated a new B object with a reference type of A.
 * B in this case will behave like an A.
 * B will override A's methods but it cannot use methods that are not defined in A.
 * This B of type A will use the instance variables of the reference type A unless the variable is used in a method.
 * In that case, the variable of B will be used when the method is overridden.
 *
 */
class A {
    int i = 10;
  
}

class B extends A{
    int i = 20;
   
}

public class Exercise_02 {

    public static void main(String[] args) {
        A a = new B();

        System.out.println(a.i);
        
    }
}