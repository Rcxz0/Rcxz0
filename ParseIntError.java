
public class ParseIntError {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      String str = "abcde";
       int number;

       try
       {
          number = Integer.parseInt(str);
       }
       catch (NumberFormatException e)
       { 
          System.out.println("Conversion error: " + e.getMessage());
       }
    }
    
}
