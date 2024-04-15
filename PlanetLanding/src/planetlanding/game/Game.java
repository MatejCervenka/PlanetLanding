package planetlanding.game;

import planetlanding.ui.WindowHighRes;
//import planetlanding.ui.WindowLowRes;
//import planetlanding.ui.WindowResChoice;

public class Game {

    static Progress progress;

    //Method for starting the game
    public static void start() throws InterruptedException {
        /*WindowResChoice windowResChoice = new WindowResChoice();
        if (windowResChoice.isHighRes() == true){
            WindowHighRes windowHighRes = new WindowHighRes();
            progress = new Progress(windowHighRes);
            windowHighRes.select(progress);
        } else if (windowResChoice.isLowRes() == true) {
            WindowLowRes windowLowRes = new WindowLowRes();
            progress = new Progress(windowLowRes);
            windowLowRes.select(progress);
        }*/

        WindowHighRes windowHighRes = new WindowHighRes();
        progress = new Progress(windowHighRes);
        windowHighRes.select(progress);
    }

}