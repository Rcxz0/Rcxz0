
public class Excep {

    public static void main(String[] args) {
        try {
            int x = 5 / 0;
        }
    
    catch (Exception e) {
     System.out.println("Exception in  " + e.getMessage()); 
    }
    
        System.out.println ("Bye");
    }

}
