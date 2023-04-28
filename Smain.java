import java.io.*;

/**
 *
 * @author Eng.reham
 */
public class Smain {
    public static void main(String[] args)throws Exception{
    Student s=new Student("Riham","2110278");
    Student r=new Student("Rama","2345278");
    
    
    ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("Student.txt"));
    o.writeObject(s);
    o.writeObject(r);
    
    o.close();
    }
}
