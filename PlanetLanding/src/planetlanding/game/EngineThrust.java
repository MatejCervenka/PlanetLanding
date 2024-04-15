package planetlanding.game;

public class EngineThrust {

    public double engineThrust = 0;

    public double getEngineThrust() {
        return engineThrust;
    }

    //Engine thrust setting
    public void setEngineThrust(double engineThrust) {
        if (engineThrust > 100) {
            engineThrust = 100;
        }
        if (engineThrust < 0) {
            engineThrust = 0;
        }
        this.engineThrust = engineThrust;
    }
}
