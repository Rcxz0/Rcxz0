import java.io.*;
/**
 *
 * @author Eng.reham
 */
public class ReadBinaryTest {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        DataInputStream d= new DataInputStream(new FileInputStream("Chapter11.txt"));
        
        char r= d.readChar();
        String e= d.readUTF();
        System.out.println(r+e);
        d.close();
        
        
        
        
    }
}
