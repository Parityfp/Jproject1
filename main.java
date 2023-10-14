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

    public void Process(){

    }
}

class customers extends booking{

}

public class main{
    public static void main(String[] args){
        //open hotel
        String path = "src/main/Java/JProject/";
        String file = "hotel.txt";
        FileReader H = new FileReader(path, file);
        
    }
}

class FileReader { 
    private ArrayList<Room> H = new ArrayList<Room> ();
    private ArrayList<booking> B = new ArrayList<booking> ();
    private Meal M = new Meal("","",0);
    private String path, filename;
    private Scanner keyboardScan;
    
    public FileReader(String P, String Fn){
        path = P;
        filename = Fn;
        keyboardScan = new Scanner(System.in);
    }
    
    public void readLineHotel(String L)  {
        String type, name;
        double rate;
        boolean validinput = true;
    
        
           try{
               String[] a = L.split(",");
                type = a[0].trim();
                name = a[1].trim();
                rate = Integer.parseInt(a[2].trim());
            /*
            try{

            switch (yn){
                case "yes" : break;
                case "no"  : break;
                default : throw new InvalidInputException(); 
            }
                    
          
            }catch(InvalidInputException e){
                    System.out.println();
                    System.out.println(e + ":  For Input: " + "\"" +a[3].trim() + "\"" );
                    System.out.println(H);
                    validinput = false ;
            }
            */
            if(validinput)
            {
                if(type=="R"){
                Room HO = new Room(type, name, rate);
                H.add(HO);
                } else M = new Meal(type, name, rate);
            }
           
            
           } catch (Exception e) {
               System.out.println();
               System.out.println(e);
               System.out.println(L);
               //System.exit(0);
           }
           
    }

    public void readLineBooking(String L)  {
        String name;
        int ID, nights;
        int [] t = new int[5];
        boolean validinput = true;
        
           try{
           
            String[] a = L.split(",");
            ID = Integer.parseInt(a[0].trim());
            name = a[1].trim();
            nights = Integer.parseInt(a[2].trim());
            
            for(int i=0; i<5; i++) {
                t[i] = Integer.parseInt(a[i+3].trim());
                try{
                /*
                if (s[i]<=0) throw new InvalidInputException(); 
                }
                catch (InvalidInputException e) {
                    //a[i+1].trim();
                    System.out.println();
                    System.out.println(e + ":  For Input: " + "\"" +a[i+3].trim() + "\"" );
                    System.out.println(B);
                    validinput = false ;
                }
                */
            }
        /*
            try{
            switch (yn){
                case "yes" : break;
                case "no"  : break;
                default : throw new InvalidInputException(); 
            }
                    
          
            }catch(InvalidInputException e){
                    System.out.println();
                    System.out.println(e + ":  For Input: " + "\"" +a[3].trim() + "\"" );
                    System.out.println(L);
                    validinput = false ;
            }
            */
            if(validinput)
            {
            booking BO = new booking(ID, name, nights, t);
            B.add(BO);
            }
            
           } catch (Exception e) {
               System.out.println();
               System.out.println(e);
               System.out.println(L);
               //System.exit(0);
           }
            
        }


    }
}           
    
