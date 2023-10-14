package Jproject; import java.util.*;import java.io.*;

class Hotel{
    protected String type;
    protected String name;

    public Hotel(String type, String name){
        this.type = type;
        this.name = name;
    }
}

class Room extends Hotel{
    private double rate;

    public Room(String type, String name, double rate){
        super(type, name);
        this.rate = rate;

    }
}

class Meal extends Hotel{
    private double rate;

    public Meal(String type, String name, double rate){
        super(type, name);
        this.rate = rate;

    }
}

class booking{
    private int ID;
    private String name;
    private int nights;

    private int type[];

}

class customers extends booking{

}

public class main{
    public static void main(String[] args){


        
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
