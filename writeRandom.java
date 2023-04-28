import java.io.*;

/**
 *
 * @author Eng.reham
 */
public class writeRandom {
    public static void main(String[] args)throws Exception{
        
        RandomAccessFile f= new RandomAccessFile("chap.txt","rw");
        f.writeChar('M');
        f.writeChar('e');
        f.writeChar('r');
        f.writeChar('h');
        f.writeChar('a');
        f.writeChar('b');
        f.writeChar('a');
        f.close();
        
        
    }
}
