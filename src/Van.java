/**
 * Created by Gratia Gamage on 10/22/2017.
 */
public class Van extends Vehicle {
    private String cargo_Volume;
    private int Slot_no;
    private String vanSecondslot;
    public Van(){

    }
    public Van(String van,int Slot_no){
        vanSecondslot=van;
        this.Slot_no=Slot_no;
    }


    public Van( String vehicle_Id, String brand, String type, int day, int month, int year, int hour, String cargo_Volume,int slot_no) {
        super( vehicle_Id, brand, type, day, month, year, hour);
        this.cargo_Volume = cargo_Volume;
        this.Slot_no=slot_no;
    }

    public String getCargo_Volume() {
        return cargo_Volume;
    }

    public int getSlot_no() {
        return Slot_no;
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
        int hour=10;//sc.nextInt();

        //vehicle details

        System.out.println("Enter Vehicle ID :");
        String v_ID = "2222";//sc.next();
        System.out.println("Enter Vehicle brand :");
        String brand ="Nissan"; //sc.next();
        System.out.println("Enter Vehicle Type :");
        String type = "van";//sc.next();
        System.out.println("Enter the Cargo Volume :");
        String cargo_Vol ="7"; //sc.next();

        for (int i = 0; i < WestMinsterCarParkManager.TOTAL_SLOTS; i++) {
            if (WestMinsterCarParkManager.ParkedVehicle[i]==null) {
                System.out.println("" + (i+1));
            }
        }
        int in = sc.nextInt();
        Vehicle v = new Van(v_ID,brand,type,day,month,year,hour,cargo_Vol,in);

        WestMinsterCarParkManager.ParkedVehicle[(in-1)]=v;
        //WestMinsterCarParkManager.ParkingVehicleCount++;
        //Vehicle nv= new Van("Two Slots allocated",in+1);
        WestMinsterCarParkManager.ParkedVehicle[in]=v;
        //WestMinsterCarParkManager.arr_tmp[WestMinsterCarParkManager.ParkingVehicleCount]=v;
        //WestMinsterCarParkManager.arr_tmp[(WestMinsterCarParkManager.ParkingVehicleCount)+1]=nv;
        // WestMinsterCarParkManager.ParkingVehicleCount=WestMinsterCarParkManager.ParkingVehicleCount+2;
    }
}
