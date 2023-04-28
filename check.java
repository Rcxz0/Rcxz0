import java.util.*;

/**
 *
 * @author Eng.reham
 */
public class check  {
    public static void main(String[] args)throws Exception{
        mymethod();
        System.out.println("Age checking is done");
    }
    public static void mymethod(){
        try{
            checkage();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void checkage() throws Exception{
        System.out.println("Please enter your age:");
        Scanner a=new Scanner(System.in);
        int Age=a.nextInt();
        
        if (Age<18){
            UnderAgeException e= new UnderAgeException();
            throw e;
            
        }
        
        
    }
}
