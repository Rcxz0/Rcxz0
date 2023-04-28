
public class StackTrace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Calling myMethod...");
        try {
            myMethod();
        } catch (Exception e) {
            System.err.println("Stack Trace: ");
            //e.printStackTrace();
        }
        System.out.println("Method main is done.");
    }

    private static void myMethod() {
        System.out.println("Calling produceError...");
        produceError();
        System.out.println("myMethod is done.");
    }

    private static void produceError() {
        String str = "abc";
        System.out.println(str.charAt(3));
        System.out.println("produceError is done.");
    }
}
