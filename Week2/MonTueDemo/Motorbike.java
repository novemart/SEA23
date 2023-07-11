public class Motorbike extends Vehicle implements Steerable {

    private int capacity;

    public Motorbike(String model, String colour, int speed, int cap) {
        super(model, colour, speed);
        this.capacity = cap;
    }

    public void accelerate(int newSpeed) {
        super.accelerate(newSpeed);
        this.speed += 10;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "capacity=" + capacity + super.toString() +
                '}';
    }

    public void doWheelie() {
        System.out.println("Look at me! I'm on one wheel!");
    }

    public int showSpeed() {
        return this.speed;
    }

    @Override
    public String indicate(String direction) {
        return "Sticking my hand to " + direction;
    }

    @Override
    public void steerLeft(int degree) {
        System.out.println("I'm leaning left by" + degree);
    }

    @Override
    public void steerRight(int degree) {
        System.out.println("I'm leaning right by" + degree);
    }
}
