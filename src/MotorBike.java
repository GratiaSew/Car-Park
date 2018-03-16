/**
 * Created by Gratia Gamage on 10/22/2017.
 */
public class MotorBike extends Vehicle {
    private String engine_size;
    private int Slot_no;

    public int getSlot_no() {
        return Slot_no;
    }

    public String getEngine_size() {
        return engine_size;
    }
    public MotorBike(){

    }


    public MotorBike(String vehicle_Id, String brand, String type, int day, int month, int year, int hour, String engine_size,int slot_no) {

        super(vehicle_Id, brand, type, day, month, year, hour);
        this.engine_size = engine_size;
        this.Slot_no=slot_no;
    }

    @Override
    public void addVehicle() {
        //date time details

        System.out.println("Enter the day :");
        int day=12 ;//sc.nextInt();
        System.out.println("Enter the month :");
        int month=01;//sc.nextInt();
        System.out.println("Enter the year :");
        int year=2017;//sc.nextInt();
        System.out.println("Enter the hour :");
        int hour=11;//sc.nextInt();

        //vehicle details

        System.out.println("Enter Vehicle ID :");
        String v_ID = "3333";//sc.next();
        System.out.println("Enter Vehicle brand :");
        String brand ="Honda"; //sc.next();
        System.out.println("Enter Vehicle Type :");
        String type = "bike";//sc.next();
        System.out.println("Enter Engine Size :");
        String engine_size ="250cc"; //sc.next();

        for (int i = 0; i < WestMinsterCarParkManager.TOTAL_SLOTS; i++) {
            if (WestMinsterCarParkManager.ParkedVehicle[i]==null) {
                System.out.println("" + (i+1));
            }
        }
        int in = sc.nextInt();
        Vehicle b = new MotorBike(v_ID,brand,type,day,month,year,hour,engine_size,in);

        WestMinsterCarParkManager.ParkedVehicle[(in-1)]=b;
        // WestMinsterCarParkManager.arr_tmp[WestMinsterCarParkManager.ParkingVehicleCount]=b;
        //WestMinsterCarParkManager.ParkingVehicleCount++;

    }
}
