package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all logical operators below. These include:
 *
 * AND, short-circuit AND, OR, short-circuit OR, XOR, NOT
 *
 */
class LogicalOperators {

    public static void main(String[] args) {

        // example of "OR"
        boolean a = true;
        boolean b = false;
        if (a | b){
            System.out.println("a or b is true");
        }

        // write your code below
        int a2 = 10;
        int b2 = 11;

        if(a2 == 10 && b2 != 10) {
        	System.out.println("a equals 10 but b does not");
        }
        if(a2 > b2 ^ b2 > a2) {
        	System.out.println("either a is greater than b or be is greater than a, but not both");
        }
        if(!(a2 > b2)) {
        	System.out.println("a is not greater than b");
        }
        if(a2 > b2 || a2 > 3) {
        	System.out.println("either a is greater than b or a is greater than 3");
        }
        if(a2 > b2 | a2 > 3) {
        	System.out.println("either a is greater than b or a is greater than 3");
        }
        if (a2 < 21 & b2 < 21){
            System.out.println("both a & b are less than 20");
          }
    }

}

