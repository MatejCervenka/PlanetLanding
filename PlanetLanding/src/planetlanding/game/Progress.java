package planetlanding.game;

import planetlanding.ui.WindowHighRes;
//import planetlanding.ui.WindowLowRes;

public class Progress implements Runnable {

    private boolean start = false;

    EngineThrust engineThrust = new EngineThrust();
    WindowHighRes windowHighRes;
    //WindowLowRes windowLowRes;

    //Progress constructors
    public Progress(WindowHighRes windowHighRes) {
        this.windowHighRes = windowHighRes;
    }
    /*public Progress(WindowLowRes windowLowRes) {
        this.windowLowRes = windowLowRes;
    }*/

    //Engine Thrust constructor
    public void addEngineThrust(double thrust) {
        engineThrust.setEngineThrust(engineThrust.getEngineThrust() + thrust);
    }

    //Boolean start setter
    public void setStart(boolean start) {
        this.start = start;
    }

    //Progress of game
    @Override
    public void run() {
        double accelerate = 0;
        double height = 0;
        double speed = 0;
        double time = 0;
        double perSecond = 2;
        double maxThrust;
        double fuel;

        maxThrust = 20 * windowHighRes.getPlanet().getGravity();
        fuel = 6 * maxThrust * (windowHighRes.getModule().getHeight() / 500f);
        int roundMaxThrust = (int) (Math.round(maxThrust * 100) / 100);
        int roundOriginFuel = (int) (Math.round(fuel * 100) / 100);

        windowHighRes.getOriginHeightValue().setText(windowHighRes.getModule().getHeight() + "  m");
        windowHighRes.getOriginSpeedValue().setText(windowHighRes.getModule().getSpeed() + "  m/s");
        windowHighRes.getOriginWeightValue().setText(windowHighRes.getModule().getWeight() + "  kg");
        windowHighRes.getOriginMaxThrustValue().setText(roundMaxThrust + "  kN");
        windowHighRes.getOriginFuelValue().setText(roundOriginFuel + "  kg");
        windowHighRes.getOriginGravityValue().setText(windowHighRes.getPlanet().getGravity() + "  m/s^2");
        windowHighRes.getPlanetValue().setText(windowHighRes.getPlanet().getName());
        windowHighRes.getLabelAccelerationValue().setText(accelerate + "  m/s^2");
        windowHighRes.getLabelHeightValue().setText(height + "  m");
        windowHighRes.getLabelSpeedValue().setText(speed + "  m/s");
        windowHighRes.getLabelFuelValue().setText(roundOriginFuel + "  kg");
        windowHighRes.getThrustValue().setText(engineThrust.getEngineThrust() + "  %");
        windowHighRes.getLabelTimeValue().setText(time + "  s");

        //Progress calculations
        while (true) {
            System.out.println();
            if (start) {
                accelerate = windowHighRes.getPlanet().getGravity() - 10 * (engineThrust.getEngineThrust() * maxThrust / windowHighRes.getModule().getWeight());
                height = windowHighRes.getModule().getHeight() - (windowHighRes.getModule().getSpeed() / perSecond) - (accelerate / 2) * (perSecond * perSecond);
                speed = windowHighRes.getModule().getSpeed() + accelerate / perSecond;
                fuel = fuel - ((engineThrust.getEngineThrust() * maxThrust / 240)) / perSecond;
                time = time + 1 / perSecond;

                windowHighRes.getLabelAccelerationValue().setText(accelerate + "  m/s^2");
                windowHighRes.getLabelHeightValue().setText(height + "  m");
                windowHighRes.getLabelSpeedValue().setText(speed + "  m/s");
                windowHighRes.getLabelFuelValue().setText(fuel + "  kg");
                windowHighRes.getThrustValue().setText(engineThrust.getEngineThrust() + "  %");
                windowHighRes.getLabelTimeValue().setText(time + "  s");

                do {
                    accelerate = windowHighRes.getPlanet().getGravity() - 10 * (engineThrust.getEngineThrust() * maxThrust / windowHighRes.getModule().getWeight());
                    height = height - (speed / perSecond) - (accelerate / 2) * (perSecond * perSecond);
                    speed = speed + (accelerate / perSecond);
                    fuel = fuel - (engineThrust.getEngineThrust() * maxThrust / 240) / perSecond;
                    time = time + 1 / perSecond;

                    double roundAccelerate = Math.round(accelerate * 1000.0) / 1000.0;
                    double roundHeight = Math.round(height * 100.0) / 100.0;
                    double roundSpeed = Math.round(speed * 1000.0) / 1000.0;
                    double roundFuel = Math.round(fuel * 100.0) / 100.0;

                    if (fuel <= 0) {
                        fuel = 0;
                        engineThrust.setEngineThrust(0);
                    }

                    windowHighRes.getLabelAccelerationValue().setText(roundAccelerate + "  m/s^2");
                    windowHighRes.getLabelHeightValue().setText(roundHeight + "  m");
                    windowHighRes.getLabelSpeedValue().setText(roundSpeed + "  m/s");
                    windowHighRes.getLabelFuelValue().setText(roundFuel + "  kg");
                    windowHighRes.getThrustValue().setText(engineThrust.getEngineThrust() + "  %");
                    windowHighRes.getLabelTimeValue().setText(time + "  s");

                    try {
                        Thread.sleep(750);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (height <= 0) {
                        height = 0;
                        windowHighRes.getLabelHeightValue().setText(height + "  m");
                        windowHighRes.getListSpeed().setText(roundSpeed + "  m/s");
                    }

                } while (height > 0);

                //Final rating of landing
                String rating = null;
                if (speed <= 0.6) {
                    rating = "You landed perfectly, CONGRATULATIONS!";

                } else if (speed <= 1.5) {
                    rating = "Decent landing, but you have still a lot to learn.";

                } else if (speed <= 5) {
                    rating = "You're only slightly injured, but you're not taking off.";

                } else if (speed <= 10) {
                    rating = "You survived, but the module is badly damaged.";

                } else if (speed <= 20) {
                    rating = "You died and the module is destroyed.";

                } else if (speed > 20) {
                    rating = "The module is in a thousand pieces, including you.";

                }
                windowHighRes.getListComputer().setText(rating);
                break;
            }

        }
    }
}
