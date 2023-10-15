package Jproject1; import java.util.*;import java.io.*;

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
    private double rateVAT;

    public Room(String type, String name, double rate){
        super(type, name);
        this.rate = rate;
        rateVAT = (rate+(rate * 0.1))+((rate+(rate * 0.1))*0.07);

    }       
    
    public void printRoom() { System.out.printf("%-15s    rate = %,8.2f      rate++ = %,8.2f\n",name, rate, rateVAT);}
    //public String getRtype() {return type;}
    public String getRname () {return name;}
    public double getRate() {return rate;}
    public double getRateVAT() {return rateVAT;}
}

class Meal extends Hotel{
    private double rate;

    public Meal(String type, String name, double rate){
        super(type, name);
        this.rate = rate;

    }
    public void printMeal() { System.out.printf("%-15s    rate = %,8.2f      rate++ = %,8.2f\n\n",name, rate, rate);}
    public String getname() {return name;}
    public double getRate() {return rate;}
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
    public String getBname() {return name;}
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
    
    
    
}


public class source{
    public static void main(String[] args){
        //open hotel
        String path = "src/main/Java/Jproject1/";
        String file = "hotel.txt";
        FileReader H = new FileReader(path, file);
        H.openHotelLoop();
        H.openBookingLoop();
        H.Process();
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
                 switch (type){
                    case "R": H[i] =  new Room(type, name, rate);
                                
                                 break;
                    case "M": M = new Meal(type, name, rate); break;
                    default : break;
               
               }
                      
            }
           
            
           } catch (Exception e) {
               System.out.println();
               System.out.println(e);
               System.out.println(L);
               //System.exit(0);
           }
           
    }

    public void readLineBooking(String L,int j)  {
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
                /*
                try{
                
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
            C[j] = new customers(ID, name, nights, t , 0);
            
            //customers CO = new customers(ID, name, nights, t, 0);
            //C.add(CO);
            
            }
            
           } catch (Exception e) {
               System.out.println();
               System.out.println(e);
               System.out.println(L);
               //System.exit(0);
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
            System.out.println("New file name = ");
            filename = keyboardScan.next();
            //System.exit(0);
        }
        }
        }
    
        public void openBookingLoop() {
            
        boolean fileopened = false;
        int i = 0;
        filename = "bookings.txt";
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
            System.out.println("New file name = ");
            filename = keyboardScan.next();
            //System.exit(0);
        }
        }
        }
        
        public void Process(){
        System.out.println("=== Booking Processing ===");
        for (booking n: B) 
            
           {//print first line //need to redo formating 
            System.out.printf("Booking %3d, %10s, %3d nights   >> %15s (%3d) %15s (%3d) %15s (%3d) %15s (%3d) %15s (%3d) \n"
               , n.getBID(),n.getBname(),n.getBnights(),H[0].getRname(),n.gettype(n.getarraytype(),0)
               ,H[1].getRname(),n.gettype(n.getarraytype(),1),H[2].getRname(),n.gettype(n.getarraytype(), 2)
               ,H[3].getRname(),n.gettype(n.getarraytype(), 3),M.getname(),n.gettype(n.getarraytype(), 4));
            
            double ttroomprice = (((n.gettype(n.getarraytype(),0)*H[0].getRateVAT())+(n.gettype(n.getarraytype(),1)*H[1].getRateVAT())
                    +(n.gettype(n.getarraytype(),2)*H[2].getRateVAT())+(n.gettype(n.getarraytype(),3)*H[3].getRateVAT()))* n.getBnights());
            double ttmealprice = (n.gettype(n.getarraytype(),4)*M.getRate())*n.getBnights();
            System.out.printf("Available cashback = %,5d >> total room price++ = %,10.2f   With service charge and VAT \n", C[0].getcashback(), ttroomprice );
            System.out.printf(">> total meal price = %,10.2f \n",ttmealprice);
            System.out.printf(">> total bill = %,10.2f redeem = %,5d\n",ttroomprice+ttmealprice,C[0].getcashback());
            System.out.printf(">> Final bill = %,10.2f cashback for next booking = %,5d\n\n", ttroomprice+ttmealprice-C[0].getcashback(), (int)(ttroomprice*0.05));
            
            
            
            
           }
        }
    }




    
