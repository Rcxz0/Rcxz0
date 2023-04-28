
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eng.reham
 */
public class Student implements Serializable{
    private String ID;
    private String name;
    public Student(String name,String ID) {
    this.name=name;
    this.ID=ID;
    
}
  public void setName(String n){
      name=n;
  }
   public void setID(String i){
       ID=i;
   } 
    
  public String getname(){
      return name;
  } 
  public String getID(){
      return ID;
  }
   
}
