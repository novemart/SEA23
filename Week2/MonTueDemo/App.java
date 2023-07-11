import java.sql.SQLOutput;

public class App {


    public static void main(String[] args) {
        int myNum = 7;
        int myNum2 = myNum;
        myNum = 9;


        Car myCar = new Car("BMW", "white", 10);
        myCar.accelerate(15);

        Car myCar2 = new Car();
        System.out.println(myCar2.getModel());
        System.out.println(myCar);

        Car myCar3 = myCar2;
        myCar3.setColour("blue");

        System.out.println(myCar2.getColour());

//        System.out.println(Car.getCarTax());
//
//        Car[] myCars = new Car[3];
//        myCars[0] = myCar;
//        myCars[1] = myCar2;
//        myCars[2] = myCar3;
//        //myCars[3] = new Car();
//
//        for (int i = 0; i < myCars.length; i++) {
//            System.out.println(myCars[i].getModel());
//        }
//
//        Car[] otherCars = {myCar, myCar2, myCar3};
//
//        otherCars[1] = myCar3;
//
//
//        for (Car c : otherCars) {
//            System.out.println(c.getModel());
//        }
//        String firstName = "Martina";
//        String firstName2 = "maRtina";
//        System.out.println(firstName.charAt(0));
//
//        if (firstName.equals(firstName2)) {
//            System.out.println("They are the same");
//        } else {
//            System.out.println("They are not the same");
//        }
//
//        System.out.println(firstName.compareTo(firstName2));
//
//        System.out.println(myCar);


        Vehicle m = new Motorbike("Kawasaki", "green", 100, 1500);
        m.accelerate(10);
        System.out.println(m.showSpeed());

        Motorbike m2 = (Motorbike) m;


        myCar.accelerate(10);

        System.out.println(myCar.showSpeed());

        //m = new Car("Mercedes", "black", 10);

        doAcccelerate(m);
        System.out.println("The motorbike speed is: " + m.showSpeed());

        Train t = new Train("Thameslink", "white", 0);
        Vehicle[] vehicles = {myCar, myCar2, m, t};
        for (Vehicle v : vehicles) {
            v.accelerate(10);
            System.out.println(v.indicate("left"));
            System.out.println(v.showSpeed());
            if (v instanceof Motorbike) {
                Motorbike moto = (Motorbike) v;
            }
        }

        Steerable[] steerables = {myCar, (Motorbike) m, new Horse()};
        for (Steerable thing : steerables) {
            thing.steerLeft(15);
        }
    }

    public static void doAcccelerate(Vehicle v) {
        v.accelerate(10);
    }


}
