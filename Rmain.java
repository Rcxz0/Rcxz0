import java.io.*;

/**
 *
 * @author Eng.reham
 */
public class Rmain {
    public static void main(String[] args)throws Exception{

    ObjectInputStream o=new ObjectInputStream(new FileInputStream("Student.txt"));
    Student a=(Student)o.readObject();
    Student b=(Student)o.readObject();
        System.out.print(a.getname()+ a.getID()+ b.getname());
    o.close();
}
}