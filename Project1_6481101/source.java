//Pranai Tisayatikom 6481101 , Chanakan Boonchoo 6580128

package Project1_6481101; import java.util.*;import java.io.*;

 class Hotel {
    protected String type;
    protected String name;

    public Hotel(String type, String name){
        this.type = type;
        this.name = name;
    }
   // public int compareTo(Hotel other){return 0;}
    }

class Room extends Meal implements Comparable<Room> {
        private double rateVAT;
   

    public Room(String type, String name, double rate){
        super(type, name,rate);
        rateVAT = (rate+(rate * 0.1))+((rate+(rate * 0.1))*0.07);

    }
    
   @Override
    public int compareTo(Room other) {
     Room n = (Room) other;
     if(this.ttsales<other.ttsales) return 1;
     else if (this.ttsales>other.ttsales) return -1;
     else return 0;
    }
    public void printRoom() { System.out.printf("%-15s    rate = %,8.2f      rate++ = %,8.2f\n",name, rate, rateVAT);}
    //public String getRname () {return name;}
    //public double getRate() {return rate;}
    public double getRateVAT() {return rateVAT;}
    @Override
    public void countsales(int i,int j) { ttsales= ttsales+(i*j); ttearning = ttsales*rateVAT ;}
   // public int getttsales() {return ttsales;}
    //public double getttearning() {return ttearning;}
    
}

class Meal extends Hotel{
    double rate, ttearning;
    int ttsales=0;

    public Meal(String type, String name, double rate){
        super(type, name);
        this.rate = rate;

    }
    public void printMeal() { System.out.printf("%-15s    rate = %,8.2f      rate++ = %,8.2f\n\n",name, rate, rate);}
    public String getname() {return name;}
    public double getRate() {return rate;}
    public void countsales(int i,int j) { ttsales= ttsales+(i*j); ttearning = ttsales*rate ;}
    public int getttsales() {return ttsales;}
    public double getttearning() {return ttearning;}
}

class booking {
    private int ID;
    private String name;
    private int nights;
    
    
    //for the type of rooms, it will be an array of integers
    private int type[];

    public booking(int ID, String name, int nights, int type[]){
        this.ID = ID;
        this.name = name;
        this.nights = nights;
        this.type = type;
        
        
    }
    
    public int getBID() {return ID;}
    public String getBname() { return name;}
    public int getBnights() {return nights;}
    public int gettype(int[] type, int i) {return type[i];}
    public int[] getarraytype() {return type;}

    
}

 class customers extends booking {
    private int cashback;
    public customers(int ID, String name, int nights, int type [], int cashback){
        super(ID,name,nights,type);
        this.cashback=cashback;
        
    }
    
    public int getcashback() {return cashback;}
    public void setcashback(int i){cashback = i;}
    
    
    
}


public class source{
    public static void main(String[] args){
        //open hotel
        String path = "src/main/Java/Project1_6481101/";
        String file = "hotels.txt";
        FileReader H = new FileReader(path, file);
        H.openHotelLoop();
        H.openBookingLoop();
        H.Process();
        H.summary();
    }
}

class FileReader { 
    //private ArrayList<Room> H = new ArrayList<Room> ();
    private Room[] H = new Room[4];
    private ArrayList<booking> B = new ArrayList<> ();
    private customers[] C = new customers[100];
    //private ArrayList<customers> C = new ArrayList<> ();
    private Meal M = new Meal("","",0);
    private String path, filename;
    private Scanner keyboardScan;
    
    public FileReader(String P, String Fn){
        path = P;
        filename = Fn;
        keyboardScan = new Scanner(System.in);
    }
    
    public void readLineHotel(String L, int i)  {
        String type, name;
        double rate;
        
    
      
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
           
                 switch (type){
                    case "R": H[i] =  new Room(type, name, rate);
                                
                                 break;
                    case "M": M = new Meal(type, name, rate); break;
                    default : break;
               
               }
                      
            
           
            
           
    }

    public void readLineBooking(String L,int j)  {
        String name;
        int ID, nights;
        int [] t = new int[5];
       
        
           
           try{
            String[] a = L.split(",");
            ID = Integer.parseInt(a[0].trim());
            if(ID <= 0) throw new InvalidInputException(ID);
            name = a[1].trim();
            nights = Integer.parseInt(a[2].trim());
            if(nights < 0 ) throw new InvalidInputException(nights);
            for(int i=0; i<5; i++) {
                t[i] = Integer.parseInt(a[i+3].trim());
                if(t[i]<0) throw new InvalidInputException(t[i]);
                
            }
            
           
            
           
            {
            booking BO = new booking(ID, name, nights, t);
            B.add(BO);
            for(int i=0 ; i<4;i++) H[i].countsales(nights, t[i]);
            M.countsales(nights, t[4]);
            //C[j] = new customers(ID, name, nights, t , 0);
            //customers CO = new customers(ID, name, nights, t, 0);
            //C.add(CO);
            
            }
            }
           catch (InvalidInputException e){
               
               //System.out.println();
               //System.out.println();
               System.out.println("["+L+"] --> Skip this booking");
           
                }
           catch (Exception e) { 
               
               System.out.println();
               System.out.println(e);
               System.out.println("["+L+"] --> Skip this booking");
               
                }
           
            
        }
    public void openHotelLoop() {
        int i = 0;
        boolean fileopened = false;
        while (!fileopened){
        try( Scanner fileScan = new Scanner(new File(path+filename));)
        {
            fileopened = true; 
            System.out.println("Read hotel data from "+path+filename+"\n");
            while (fileScan.hasNext()) {
             
                readLineHotel(fileScan.nextLine(),i);
                i++;
                
            }
            for ( i = 0; i<4 ; i++) H[i].printRoom();
            M.printMeal();
            
            fileScan.close();
        } catch (FileNotFoundException e){
            System.out.println();
            System.out.println(e);
            System.out.println("New file name for hotel data = ");
            filename = keyboardScan.next();
            //System.exit(0);
        }
        }
        }
    
        public void openBookingLoop() {
            
        boolean fileopened = false;
        int i = 0;
        filename = "booking.txt";
        //filename = "bookings_errors.txt";
        while (!fileopened){
        try( Scanner fileScan = new Scanner(new File(path+filename));)
        {
            fileopened = true; 
            System.out.println("Read booking data from "+path+filename+"\n");
            while (fileScan.hasNext()) {
             
                readLineBooking(fileScan.nextLine(),i);
               i++;
                
            }
           
            fileScan.close();
        } catch (FileNotFoundException e){
            System.out.println();
            System.out.println(e);
            System.out.println("New file name for booking data = ");
            filename = keyboardScan.next();
            //System.exit(0);
        }
        }
        }
        
        public void Process(){
            int j = 0;
        System.out.println("=== Booking Processing ===");
        for(int i=0; i<100; i++) C[i] = new customers(i,"a",i,null,0);
        for (booking n: B) 
            
           {//print first line //need to redo formating 
            System.out.printf("Booking %3d, %10s, %3d nights   >> %-15s (%3d) %-15s (%3d) %-15s (%3d) %-15s (%3d) %-15s (%3d) \n"
               , n.getBID(),n.getBname(),n.getBnights(),H[0].getname(),n.gettype(n.getarraytype(),0)
               ,H[1].getname(),n.gettype(n.getarraytype(),1),H[2].getname(),n.gettype(n.getarraytype(), 2)
               ,H[3].getname(),n.gettype(n.getarraytype(), 3),M.getname(),n.gettype(n.getarraytype(), 4));
                double ttroomprice = 0;
            for (int i=0; i<4 ;i++){
                ttroomprice = ttroomprice + (n.getBnights()*n.gettype(n.getarraytype(), i)*H[i].getRateVAT());
               
            }
            double ttmealprice = (n.gettype(n.getarraytype(),4)*M.getRate())*n.getBnights();
            
            int cashback = (int)(ttroomprice*0.05);
            
            
            for(int i =0; i<100; i++){
            if(n.getBname().compareTo(C[i].getBname())==0) {
              
                System.out.printf("Available cashback = %-,5d            >> total room price++    = %,12.2f        With service charge and VAT \n", C[i].getcashback(), ttroomprice );
                if(C[i].getcashback()>((ttroomprice+ttmealprice)/2)) {
                    cashback= cashback + C[i].getcashback()-((int)(ttroomprice+ttmealprice)/2);
                    C[i].setcashback((int)(ttroomprice+ttmealprice)/2);
                }
                System.out.printf("%38s>> total meal price      = %,12.2f \n","",ttmealprice);
                System.out.printf("%38s>> total bill            = %,12.2f        redeem = %,5d\n","",ttroomprice+ttmealprice,C[i].getcashback());
                System.out.printf("%38s>> Final bill            = %,12.2f        cashback for next booking = %,5d\n\n","", ttroomprice+ttmealprice-C[i].getcashback(), cashback );
                C[i].setcashback(cashback);
                
              
                break ;
            }
            //else if (Integer.parseInt(C[i].getBname().trim())==i) break; 
            else if(C[i].getBname().compareTo("a")==0)
            {
                System.out.printf("Available cashback = %-,5d            >> total room price++    = %,12.2f        With service charge and VAT \n", 0, ttroomprice );
                System.out.printf("%38s>> total meal price      = %,12.2f \n","",ttmealprice);
                System.out.printf("%38s>> total bill            = %,12.2f        redeem = %,5d\n","",ttroomprice+ttmealprice,0);
                System.out.printf("%38s>> Final bill            = %,12.2f        cashback for next booking = %,5d\n\n","", ttroomprice+ttmealprice, cashback);
                C[j] = new customers(n.getBID(), n.getBname(), n.getBnights(), n.getarraytype() , cashback); j++;    
                break;}
       
             }
           
            
           
            
            
            
            
           }
        //for (int i = 0; i<20; i++)
            //System.out.println(C[i].getBname());
      
        
        
        }
        
       public void summary(){
           
           System.out.println("=== Room Summary ===");
            Arrays.sort(H);
           for(int i=0 ; i<4;i++)
       {
            System.out.printf("%-20s total sales      = %,6d rooms %,15.2f Baht\n", H[i].getname(),H[i].getttsales(),H[i].getttearning());
       }
           System.out.println("");
           System.out.println("=== Meal Summary ===");
           System.out.printf("%-20s total sales      = %,6d heads %,15.2f Baht\n", M.getname(),M.getttsales(),M.getttearning());
            
       }
       
       
       
       
       
       
    }


class InvalidInputException extends Exception
{			
    public InvalidInputException(int i) {System.err.println("\nError, Invalid input for input \""+i+"\"");}
};

    
