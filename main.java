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

    //for the type of rooms, it will be an array of integers
    private int type[];

    public Booking(int ID, String name, int nights, int type[]){
        this.ID = ID;
        this.name = name;
        this.nights = nights;
        this.type = type;
    }
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
    
    public void readLineHotel(String H)  {
        String type, name;
        double rate;
        boolean validinput = true;
        
           try{
               
           
            
           } catch (Exception e) {
               System.out.println();
               System.out.println(e);
               System.out.println(H);
               //System.exit(0);
           }

    public void readLineBooking(String B)  {
        String name;
        String yn;
        boolean validinput = true;
        
           try{
           
            
           } catch (Exception e) {
               System.out.println();
               System.out.println(e);
               System.out.println(B);
               //System.exit(0);
           }
            
    }
