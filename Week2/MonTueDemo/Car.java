public class Car extends Vehicle implements Steerable {


    private static double carTax = 0.20;

    public static double getCarTax() {
        return Car.carTax;
    }

    public Car(String model, String colour) {
        this(model, colour, 0);
        System.out.println("The model is: " + model);
    }

    public Car(String model, String colour, int speed) {
        super(model, colour, speed);
    }

    public Car() {
        this("Fiat", "rose", 0);
    }


    public void accelerate(int speed, int limit) {
        if (this.speed + speed < limit) {
            this.speed += speed;
        }
    }


    public Car compareTwoCars(Car another) {
        if (this.speed < another.speed) {
            return this;
        } else return another;
    }

    public static void manageCar(Car car) {
        car.speed += 10;
    }


    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", speed=" + speed +
                '}';
    }

    @Override
    public String indicate(String direction) {
        return "Blink blink to the " + direction;
    }

    @Override
    public void steerLeft(int degree) {
        System.out.println("I'm going left by" + degree);
    }

    @Override
    public void steerRight(int degree) {
        System.out.println("I'm going right by" + degree);
    }
}
