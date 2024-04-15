package planetlanding.objects;

public class Planet extends SpaceObject{

    private final double gravity;

    //Planet constructor
    public Planet(String name, double gravity) {
        super(name);
        this.gravity = gravity;
    }

    public String toString() {
        return name + "     ||     gravity: " + gravity + " m/s^2";
    }

    public double getGravity() {
        return gravity;
    }
}
