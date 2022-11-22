package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all relational operators below. These include:
 *
 * less than, less than or equal to, greater than, greater than or equal to, and equal to
 *
 */
class Exercise_04 {

    public static void main(String[] args) {

        // example of "less than"
        int a = 1;
        int b = 2;
        if (a < b){
            System.out.println("a is less than b");
        }

        // write your code below

        int h = 13;
        int i = 39;
        if (h==i) {
        	System.out.println("h is equal to i");
        }
        if(h != i) {
        	System.out.println("h is not equal to i");
        }
        if(h <= i) {
        	System.out.println("h is less than or equal to i");
        }
        if(h > i) {
        	System.out.println("h is greater than i");
        }
        if(h < i) {
        	System.out.println("h is greater than i");
        }
        if(h >= i) {
        	System.out.println("h is greater than or equal to i");
        }
    }

}

