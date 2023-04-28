import java.util.*;
import java.io.*;


/**
 *
 * @author Eng.reham
 */
public class openfile {
    
    public static void main(String[] args)throws FileNotFoundException {
        
        displayfile("Myfile.txt");
        System.out.println("bye");
        
        
        
    }
    
    public static void displayfile(String name) throws FileNotFoundException {
        try{
        File f=new File(name);
        Scanner filename=new Scanner(f);
        while (filename.hasNext()){
            System.out.println(filename.nextLine());
        }
        
    }
    catch(Exception e){
        System.out.println("Exception in "+e.getMessage());
    }
    }   
}
 
