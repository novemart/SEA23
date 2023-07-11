public class Train extends Vehicle {

    public Train(String model, String colour, int speed) {
        super(model, colour, speed);
    }

    @Override
    public String indicate(String direction) {
        return "Tchoo tchoo Move away!!!!";
    }
}
