package planetlanding.objects;

public class SpaceObject {

    protected String name;

    //Parent class SpaceObject constructor
    public SpaceObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
