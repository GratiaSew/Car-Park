import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gratia Gamage on 10/22/2017.
 */
class WestMinsterCarParkManager implements CarParkManager{
    public static Scanner sc= new Scanner(System.in);
    //total slots in the park is given as 20
    public static final int TOTAL_SLOTS =20;
    public static int ParkingSlotCount =1;
    //the vehicle array of size 20
    public static Vehicle [] ParkedVehicle = new Vehicle[TOTAL_SLOTS];
    //object array of all the vehicles exits
    public static ArrayList<Vehicle> LeftVehicles = new ArrayList<>();

    @Override
    //Add Vehicle
    public void ParkVehicle() {
        try{
            for(int i=0;i<=TOTAL_SLOTS;i++) {

                //if both the 2 slots next to each other are free we can park any vehicle
                if (ParkedVehicle[i] == null && ParkedVehicle[i + 1] == null) {
                    System.out.println("Choose What type of a Vehicle it is ...");
                    System.out.println("Press \"c\" for car \"v\" for van \"b\" motorbike ");
                    char in = sc.next().charAt(0);
                    if (in == 'c' | in == 'C') {
                        Vehicle c = new Car();//to add a car to the park
                        c.addVehicle();
                        ParkingSlotCount++;
                        break;
                    } else if (in == 'v' | in == 'V') {
                        Vehicle v = new Van();//to add a van to the park
                        v.addVehicle();
                        ParkingSlotCount = ParkingSlotCount + 2;//because van needs two parking slots
                        break;
                    } else if (in == 'b' | in == 'B') {
                        Vehicle b = new MotorBike();//to add a motorBike to the park
                        b.addVehicle();
                        ParkingSlotCount++;
                        break;
                    }
                }

                //if the 2 slots next to each are not free can't park a van,can park car or motorbike
                else if (ParkedVehicle[i] == null && ParkedVehicle[i +1] != null && ParkedVehicle[i +2] ==null) {

                    System.out.println("Choose What type of a Vehicle it is ...");
                    System.out.println("Press \"c\" for car \"v\" for van \"b\" motorbike ");
                    char in = sc.next().charAt(0);
                    if (in  == 'c' | in == 'C') {
                        Vehicle k = new Car();
                        k.addVehicle();
                        break;
                    }
                    else if (in == 'v' | in == 'V') {
                        Vehicle x = new Van();
                        x.addVehicle();
                        break;
                    } else if (in == 'b' | in == 'B') {
                        Vehicle b = new MotorBike();
                        b.addVehicle();
                        break;

                    }
                }

                //
                else if ((ParkedVehicle[i] == null && ParkedVehicle[i + 1] != null && ParkedVehicle[i -1] != null) ||
                        (ParkedVehicle[i] == null && ParkedVehicle[i + 1] != null && ParkedVehicle[i -1] == null)) {
                    System.out.println("6");
                    System.out.println("Only car and bike");
                    System.out.println("Choose What type of a Vehicle it is ...");
                    System.out.println("Press \"c\" for car  \"b\" motorbike ");
                    char in = sc.next().charAt(0);
                    if (in == 'c' | in == 'C') {
                        Vehicle c = new Car();
                        //Car cr = (Car) cr;
                        c.addVehicle();
                        ParkingSlotCount++;
                        break;
                    } else if (in == 'b' | in == 'B') {
                        Vehicle b = new MotorBike();
                        b.addVehicle();
                        ParkingSlotCount++;
                        break;
                    }
                }

                //
                else if (ParkedVehicle[i] == null) {
                    System.out.println("7");
                    System.out.println("Choose What type of a Vehicle it is ...");
                    System.out.println("Press \"c\" for car \"v\" for van \"b\" motorbike ");
                    char in = sc.next().charAt(0);
                    if (in  == 'c' | in == 'C') {
                        Vehicle c = new Car();
                        c.addVehicle();
                        ParkingSlotCount++;
                        break;
                    } else if (in == 'v' | in == 'V') {
                        Vehicle v = new Van();
                        v.addVehicle();
                        ParkingSlotCount = ParkingSlotCount + 2;
                        break;
                    } else if (in == 'b' | in == 'B') {
                        Vehicle b = new MotorBike();
                        b.addVehicle();
                        break;

                    }
                }
                else {

                }


            }
        }catch (Exception e){

        }

    }

    @Override
    //Delete Vehicle
    //Parking charge
    public void deleteVehicle() {
        System.out.println("Type the Vehicle ID to Remove the vehicle from the park");
        String in=sc.next();
        WestMinsterCarParkManager d = new WestMinsterCarParkManager();

        try {

            for (int i = 0; i < TOTAL_SLOTS; i++) {

                if(ParkedVehicle[i] !=null){
                    if (ParkedVehicle[i].getVehicle_Id().equals(in)) {

                        if (ParkedVehicle[i].getType().equals("car")) {
                            Car c = (Car) ParkedVehicle[i];
                            System.out.println("Enter Leaving time :");
                            int hour = sc.nextInt();
                            //String vehicle_Id, String brand, String type, int day, int month, int year, int hour,int no_of_doors,String color,int slot_no,int outtime
                            // Vehicle cd = new Car(c.getVehicle_Id(),c.getBrand(),c.getType(),c.getDay(),c.getMonth(),c.getYear(),c.getHour(),c.getNo_of_doors(),c.getColor(),c.getSlot_no(),hour);

                            LeftVehicles.add(c);

                            //Inserting the leaving time and calculating the cost
                            System.out.println("Bill is " + d.bill(hour, c));
                            ParkedVehicle[i] = null;//deleting the object

                        }
                        if (ParkedVehicle[i].getType().equals("bike")) {
                            MotorBike b = (MotorBike) ParkedVehicle[i];

                            //Inserting the leaving time
                            System.out.println("Enter Leaving time :");
                            int hour = sc.nextInt();

                            //String vehicle_Id, String brand, String type, int day, int month, int year, int hour, String engine_size,int slot_no,int outtime
                            //Vehicle db = new MotorBike(b.getVehicle_Id(),b.getBrand(),b.getType(),b.getDay(),b.getMonth(),b.getYear(),b.getHour(),b.getEngine_size(),b.getSlot_no(),hour);
                            LeftVehicles.add(b);


                            // d.bill(hour,b);
                            System.out.println("Bill is " + d.bill(hour, b));
                            ParkedVehicle[i] = null;//deleting the object
                        }
                        if (ParkedVehicle[i].getType().equals("van")) {
                            Van v = (Van) ParkedVehicle[i];
                            //Inserting the leaving time and calculating the cost
                            System.out.println("Enter Leaving time :");
                            int hour = sc.nextInt();

                            //String vehicle_Id, String brand, String type, int day, int month, int year, int hour, String cargo_Volume,int slot_no,int outtime
                            //Vehicle nv = new Van(v.getVehicle_Id(),v.getBrand(),v.getType(),v.getDay(),v.getMonth(),v.getYear(),v.getHour(),v.getCargo_Volume(),v.getSlot_no(),hour);
                            LeftVehicles.add(v);


                            System.out.println("Bill is " + d.bill(hour, v));
                            ParkedVehicle[i] = null;//deleting the object
                            int x = (i + 1);
                            ParkedVehicle[x] = null;//deleting the object
                        }
                    }else {
                        System.out.println("Id is not available");
                    }

                }
            }
        }catch (Exception e){

        }
    }

    @Override
    //Print List
    public void displayParkedVehicles() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Parked Vehicles");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Vehicle[] arr_tmp = new Vehicle[TOTAL_SLOTS];
        int count=0;
        for(int x=0;x<TOTAL_SLOTS;x++){
            if(ParkedVehicle[x] !=null){
                arr_tmp[count]=ParkedVehicle[x];
                count++;
            }
        }

        WestMinsterCarParkManager w= new WestMinsterCarParkManager();
        w.sort(arr_tmp);

        try {

            for (int i = 0; i < TOTAL_SLOTS; i++) {

                if (arr_tmp[i].getType().equals("car")) {
                    Car c = (Car) arr_tmp[i];
                    System.out.println("Vehicle Type :" + c.getType());
                    System.out.println("vehicle ID :" + c.getVehicle_Id());
                    System.out.println(c.dateTime.getDateandTime());
                    System.out.println("Vehicle Brand :" + c.getBrand());
                    System.out.println("Vehicle Color :" + c.getColor());
                    System.out.println("No of doors :" + c.getNo_of_doors());
                    System.out.println("slot Number/s :" + (c.getSlot_no() ));

                }
                if (arr_tmp[i].getType().equals("van")) {
                    Van v = (Van) arr_tmp[i];
                    Van v_nextSlot = (Van) arr_tmp[i + 1];
                    System.out.println("Vehicle Type :" + v.getType());
                    System.out.println("vehicle ID :" + v.getVehicle_Id());
                    System.out.println(v.dateTime.getDateandTime());
                    System.out.println("Vehicle Brand :" + v.getBrand());
                    System.out.println("Vehicle Cargo Volume :" + v.getCargo_Volume());
                    System.out.println("slot Number/s :" + (v.getSlot_no() ) + " and " + (v_nextSlot.getSlot_no() + 1));
                    i++;


                }
                if (arr_tmp[i].getType().equals("bike")) {
                    MotorBike b = (MotorBike) arr_tmp[i];
                    System.out.println("Vehicle Type :" + b.getType());
                    System.out.println("vehicle ID :" + b.getVehicle_Id());
                    System.out.println(b.dateTime.getDateandTime());
                    System.out.println("Vehicle Brand :" + b.getBrand());
                    System.out.println("Vehicle Cargo Volume :" + b.getEngine_size());
                    System.out.println("slot Number/s :" + (b.getSlot_no() ));

                }
                if (ParkedVehicle[i] == null) {
                    //System.out.println("Van has been parked in slot no :" + x + 1 + " and " + x);
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            }
        } catch(Exception e){

        }



    }

    @Override
    public void menu(String input) {
        WestMinsterCarParkManager v = new WestMinsterCarParkManager();
        switch (input){
            case "a":
            case "A":
                v.ParkVehicle();
                break;
            case "p":
            case "P":
                v.displayParkedVehicles();
                break;
            case "d":
            case "D":
                v.deleteVehicle();
                break;
            case "t":
            case "T":
                v.percentage_of_Vehicles();
                break;
            case "l":
            case "L":
                v.is_parked_for_longest_time();
                break;
            case "f":
            case "F":
                v.last_Vehicle_parked();
                break;
            case "s":
            case "S":
                v.display_Specific_Day_Vehicles();
                break;

        }

    }

    @Override
    //Print statistic
    public void percentage_of_Vehicles() {

        ArrayList<Vehicle> tot_vehicles = new ArrayList<>();

        int c=0;//about car
        int b=0;//about motorbike
        int v=0;//about van

        for(int x=0;x<TOTAL_SLOTS;x++){
            if(ParkedVehicle[x] !=null){
                tot_vehicles.add(ParkedVehicle[x]);

            }
        }
        for(Vehicle k :tot_vehicles){
            if(k.getType().equals("car")){
                c++;
            }
            if(k.getType().equals("bike")){
                b++;
            }
            if(k.getType().equals("van")){
                v++;
            }
        }

        double v_new =v/2;//because of the above increment as van use 2 slots it get multiplied 4 times.
        // To make it right

        double tot=c+b+v_new;//took double as percentage wise it's easy to show
        System.out.println("Percentage of Vehicles : ");
        System.out.println("Cars  : "+(c/tot)*100 +" % ");
        System.out.println("Bikes  : "+(b/tot)*100 +" % ");
        System.out.println("Vans  : "+(v_new/tot)*100 +" % ");

    }

    @Override
    public void is_parked_for_longest_time() {
        System.out.println("Vehicle that is parked for a long time  ");
        System.out.println("Enter the current time ");
        int t= sc.nextInt();
        Vehicle[] arr_tmp = new Vehicle[TOTAL_SLOTS];
        int count=0;
        for(int x=0;x<TOTAL_SLOTS;x++){
            if(ParkedVehicle[x] !=null){
                arr_tmp[count]=ParkedVehicle[x];
                count++;
            }
        }
        sort_For_outTime(arr_tmp,t);
        System.out.println("Vehicle that has been parked for a long time is  "+"" +
                "Vehicle ID :"+arr_tmp[0].getVehicle_Id()+" Type : "+arr_tmp[0].getType()+" Entry time :"+arr_tmp[0].dateTime.getHour());

    }

    @Override
    public void last_Vehicle_parked() {
        Vehicle[] arr_tmp = new Vehicle[TOTAL_SLOTS];
        int count=0;
        for(int x=0;x<TOTAL_SLOTS;x++){
            if(ParkedVehicle[x] !=null){
                arr_tmp[count]=ParkedVehicle[x];
                count++;
            }
        }
        sort(arr_tmp);
        try {
            System.out.println("Last Vehicle that was parked is " +
                    "Vehicle ID :" + arr_tmp[0].getVehicle_Id() + " Type : " + arr_tmp[0].getType() + " Entry time :" + arr_tmp[0].dateTime.getHour());
        }catch (Exception e){
            System.out.println("No any Vehicles");
        }
    }

    @Override
    //Print the list of vehicle entered in a specified day
    public void display_Specific_Day_Vehicles() {
        System.out.println("Enter the year :");
        int year = sc.nextInt();
        System.out.println("Enter the day :");
        int day = sc.nextInt();
        for(Vehicle v :LeftVehicles){
            if(v.dateTime.getDay()==day && v.dateTime.getYear()==year){


                if(v.getType().equals("car")){
                    Car n = (Car) v;
                    System.out.println("Vehicle Id :"+n.getVehicle_Id());
                    System.out.println("Vehicle type :"+n.getType());
                    System.out.println("Vehicle brand :"+n.getBrand());
                }
                else if(v.getType().equals("bike")){
                    MotorBike n = (MotorBike) v;
                    System.out.println("Vehicle Id :"+n.getVehicle_Id());
                    System.out.println("Vehicle type :"+n.getType());
                    System.out.println("Vehicle brand :"+n.getBrand());
                }
                else if(v.getType().equals("van")){
                    Van n = (Van) v;
                    System.out.println("Vehicle Id :"+n.getVehicle_Id());
                    System.out.println("Vehicle type :"+n.getType());
                    System.out.println("Vehicle brand :"+n.getBrand());
                }
                System.out.println("");
                System.out.println("-------------------------------------------------------");

            }
            else {
                System.out.println("No Vehicles has been parked on that day ");
            }

        }


    }


    public void sort_For_outTime(Vehicle arr[],int currentTime) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j - 1]!=null && arr[j]!=null) {
                    if (currentTime-arr[j - 1].dateTime.getHour() < currentTime-arr[j].dateTime.getHour()) {
                        //swap
                        Vehicle tmp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }
    }

    public void sort(Vehicle arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j - 1]!=null && arr[j]!=null) {
                    if (arr[j - 1].dateTime.getHour() <  arr[j].dateTime.getHour()) {
                        //swap
                        Vehicle tmp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }
    }

    public String bill(int hour,Vehicle v){
        if(hour-v.dateTime.getHour()<=3){
            int h = hour-v.dateTime.getHour();
            int tot=h*3;
            return tot +" euros";
        }
        if((hour-v.dateTime.getHour())>3){
            int h=(hour-v.dateTime.getHour())-3;
            int tot=9+(h*1);
            return tot +" euros";
        }
        return null;
    }

    public static void main(String[] args) {
        WestMinsterCarParkManager n = new WestMinsterCarParkManager();

        do {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MENU~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Choose an Option");
            System.out.println("Add Vehicle - a/A");
            System.out.println("Display the List of Parked Vehicles - p/P");
            System.out.println("Delete Vehicle From the Park - d/D ");
            System.out.println("To view the percentage of Vehicles that are currently parked  - t/T ");
            System.out.println("To view Vehicle which is parked for a longest time - l/L");
            System.out.println("To view the last vehicle that is parked  - f/F");
            System.out.println("To view the Vehicles that are parked in a specific day according to users demand - s/S");
            System.out.println("");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            String in = sc.next();
            n.menu(in);
        }while (sc.hasNextLine());
    }

}

