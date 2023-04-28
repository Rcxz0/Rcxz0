
import java.io.*;

/**
 *
 * @author Eng.reham
 */
public class WriteBinaryTest {
    public static void main(String[] args) throws FileNotFoundException{
        
       FileOutputStream f=new FileOutputStream("Chapter11.txt");
       DataOutputStream d= new DataOutputStream(f);
        try{
           d.writeChar('r');
           d.writeUTF("This is our DataBase:");
           d.flush();
           d.close();
        }
        catch(Exception e){
            System.out.print("there is an Exception" + e.getMessage());
        }
        
        
    }
   
}
