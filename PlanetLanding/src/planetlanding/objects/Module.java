package planetlanding.objects;

public class Module extends SpaceObject{
    private int height;
    private int speed;
    private int weight;

    //Module constructor
    public Module(String name, int height, int speed, int weight) {
        super(name);
        this.height = height;
        this.speed = speed;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + "     ||      speed: " + speed + " m/s     ||      height: " + height + " m     ||      weight: " + weight + " kg";
    }

    public int getHeight() {
        return height;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }
}
