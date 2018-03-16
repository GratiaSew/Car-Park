/**
 * Created by Gratia Gamage on 10/22/2017.
 */
public class DateTime {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int outhour;

    public int getHour() {
        return hour;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getDateandTime() {
        return day + "\\" + month + "\\" + year + "," + "Time " + hour;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public int getOuthour() {

        return outhour;
    }

    public void setOutTime(int hour) {

        this.outhour = hour;
    }
}
