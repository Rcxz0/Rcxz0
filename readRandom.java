import java.io.*;

/**
 *
 * @author Eng.reham
 */
public class readRandom {
    public static void main(String[] args)throws Exception{
        
        RandomAccessFile f= new RandomAccessFile("chap.txt","r");
        f.seek(3);
        System.out.println(f.readChar());
        f.seek(2);
        System.out.println(f.readChar());
        f.seek(1);
        System.out.println(f.readChar());
        
    }
}
