
public class Finally_Clause {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("1. try");

            Integer.parseInt("This will not parse!");

            System.out.println("This will not print!");

        } catch (NumberFormatException e) {
            System.out.println("2. catch");

        } finally {
            System.out.println("3. finally");
        }

        System.out.println("4. done");
    }

}
