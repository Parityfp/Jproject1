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
        ArrayList<Booking> AllBookings = new ArrayList<>();
        ArrayList<Hotel> products = new ArrayList<>();
        Scanner scanner;


    }
}