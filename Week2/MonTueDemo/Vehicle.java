import java.util.Objects;

public abstract class Vehicle extends Object {
    protected String model;

    protected String colour;

    protected int speed;

    private String numberPlate;

    public Vehicle(String model, String colour, int speed) {
        this.model = model;
        this.colour = colour;
        this.speed = speed;
    }

    public void accelerate(int speed) {
        this.speed += speed;
    }

    public void setColour(String colour) {
        if (colour.length() > 3) {
            this.colour = colour;
        }
    }

    public String getColour() {
        return colour;
    }

    public String getModel() {
        return this.model;
    }

    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", speed=" + speed +
                '}';
    }

    public int showSpeed() {
        return this.speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return speed == vehicle.speed && Objects.equals(model, vehicle.model) && Objects.equals(colour, vehicle.colour) && Objects.equals(numberPlate, vehicle.numberPlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, colour, speed, numberPlate);
    }

    public abstract String indicate(String direction);

}
