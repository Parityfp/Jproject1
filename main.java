package Jproject; import java.util.*;import java.io.*;

class Hotel{
    protected String type;
    protected String name;
}

class Room extends Hotel{
    private double rate;

    public Room(){

    }
}

class Meal extends Hotel{
    private double rate;

    public Meal(){
        
    }
}

class booking(
    private int ID;
    private String name;
    private int nights;

    private int type[];
)

class customers extends booking{

}

public class main{
    public static void main(String[] args){
            String path = "src/main/Java/JProject/";
            String file = "bookings.txt";
            FileReader N = new FileReader(path, file);
        
    }
}

class FileReader {
    
    private String path, filename;
    private Scanner keyboardScan;
    
    public FileReader(String P, String Fn){
        path = P;
        filename = Fn;
        keyboardScan = new Scanner(System.in);
    }
    
    public void readLine(String L)  {
        String name;
        String yn;
        boolean validinput = true;
        
           try{
           
            
           } catch (Exception e) {
               System.out.println();
               System.out.println(e);
               System.out.println(L);
               //System.exit(0);
           }
            
    }
