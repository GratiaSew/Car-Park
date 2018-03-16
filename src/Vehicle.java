import java.util.Scanner;

/**
 * Created by Gratia Gamage on 10/22/2017.
 */
public abstract class Vehicle {
    static Scanner sc= new Scanner(System.in);

    private String vehicle_Id;
    private String brand;
    private String type;
    DateTime dateTime  = new DateTime();
    private int day;
    private int month;
    private int year;
    private int hour;

    public Vehicle(){

    }

    public Vehicle( String vehicle_Id, String brand, String type, int day, int month, int year, int hour) {

        this.vehicle_Id = vehicle_Id;
        this.brand = brand;
        this.type = type;
        dateTime.setDay(day);
        dateTime.setMonth(month);
        dateTime.setYear(year);
        dateTime.setHour(hour);
        /*this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;*/
    }
    public Vehicle( String vehicle_Id, String brand, String type, int day, int month, int year, int hour,int outhour) {

        this.vehicle_Id = vehicle_Id;
        this.brand = brand;
        this.type = type;
        dateTime.setDay(day);
        dateTime.setMonth(month);
        dateTime.setYear(year);
        dateTime.setHour(hour);
        dateTime.setOutTime(outhour);
        /*this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;*/
    }

    public abstract void addVehicle();


    public String getVehicle_Id() {
        return vehicle_Id;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }
}
