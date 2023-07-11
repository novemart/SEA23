public class Horse implements Steerable {

    @Override
    public void steerLeft(int degree) {
        System.out.println("neigh neigh left");
    }

    @Override
    public void steerRight(int degree) {
        System.out.println("neigh neigh right");
    }

    @Override
    public void makeNoise() {
        System.out.println("Neigh neigh");
    }
}
