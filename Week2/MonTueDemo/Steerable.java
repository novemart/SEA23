public interface Steerable {
    public abstract void steerLeft(int degree);

    void steerRight(int degree);

    default void makeNoise() {
        System.out.println("Vroum vroum");
    }
}
