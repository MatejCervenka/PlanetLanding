package planetlanding.ui;

import planetlanding.game.Progress;
import planetlanding.objects.Module;
import planetlanding.objects.Planet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowHighRes extends JPanel implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton buttonThrustUp;
    private JButton buttonThrustDown;
    private JLabel planetTitle;
    private JLabel planetValue;
    private JLabel labelSpeed;
    private JLabel labelHeight;
    private JLabel labelLeverage;
    private JLabel labelFuel;
    private JLabel labelSpeedValue;
    private JLabel labelHeightValue;
    private JLabel labelAccelerationValue;
    private JLabel labelFuelValue;
    private JLabel labelTime;
    private JLabel labelTimeValue;
    private JLabel thrustValue;
    private JLabel thrustValueTitle;
    private JLabel labelComputer;
    private JLabel listComputer;
    private JLabel impactVelocityTitle;
    private JLabel listSpeed;
    private JLabel labelOriginValues;
    private JLabel originSpeedValue;
    private JLabel originHeightValue;
    private JLabel originFuelValue;
    private JLabel originMaxThrustValue;
    private JLabel originWeightValue;
    private JLabel originGravityValue;
    private JLabel originSpeedValueTitle;
    private JLabel originHeightValueTitle;
    private JLabel originMaxThrustValueTitle;
    private JLabel originFuelValueTitle;
    private JLabel originWeightValueTitle;
    private JLabel originGravityValueTitle;

    private JPanel moduleJPanel = new JPanel();
    private JPanel planetJPanel = new JPanel();
    private JPanel selectionLabelPanel = new JPanel();
    private JLabel selectionLabel = new JLabel("Select preferred MODULE a PLANET");

    private static JButton continueButton = new JButton("CONTINUE");
    private DefaultListModel<Module> modules = new DefaultListModel<>();
    private JList<Module> moduleJList = new JList<>(modules);
    private final JLabel moduleSelectionLabel = new JLabel("Modules:   ");
    private JLabel moduleLabel = new JLabel();
    private JButton buttonOwnModule = new JButton("Create Module");
    private JTextField ownModuleName = new JTextField("Enter Module Name");
    private String ownName;
    private JTextField ownModuleHeight = new JTextField("Enter Module Height");
    private String ownHeight;
    private JTextField ownModuleSpeed = new JTextField("Enter Module Speed");
    private String ownSpeed;
    private JTextField ownModuleWeight = new JTextField("Enter Module Weight");
    private String ownWeight;
    private JButton buttonSelectModule = new JButton("Select Module");
    private String selectedModule = " ";

    private DefaultListModel<Planet> planets = new DefaultListModel<>();
    private JList<Planet> planetJList = new JList<>(planets);
    private final JLabel planetSelectionLabel = new JLabel("Planets/Moons:   ");
    private JLabel planetLabel = new JLabel();
    private JButton buttonOwnPlanet = new JButton("Create planet");
    private JTextField ownPlanetName = new JTextField("Enter Planet Name");
    private String ownPlntName;
    private JTextField ownPlanetGravity = new JTextField("Enter Planet Gravity");
    private String ownGravity;
    private JButton buttonSelectPlanet = new JButton("Select Planet");
    private String selectedPlanet = " ";

    private Module module;
    private Planet planet;
    private static boolean isModuleSelected = false;
    private static boolean isPlanetSelected = false;

    private Progress progress;

    //Selection label text
    public void selectionLabel() {
        selectionLabelPanel.setBackground(Color.DARK_GRAY);
        selectionLabelPanel.setBounds(0, 720, 1500, 350);

        selectionLabel.setForeground(Color.WHITE);
        selectionLabel.setFont(new Font("Calibre", Font.BOLD, 40));

        selectionLabelPanel.add(selectionLabel);
    }

    //Method for module selection
    public void selectModule() {
        moduleJPanel.setBackground(Color.DARK_GRAY);
        moduleJPanel.setBounds(0, 0, 1500, 350);

        moduleSelectionLabel.setFont(new Font("Calibre", Font.BOLD,30));
        moduleSelectionLabel.setForeground(Color.WHITE);

        moduleLabel.setFont(new Font("Calibre", Font.BOLD, 25));
        moduleLabel.setForeground(Color.WHITE);

        moduleJList.setBackground(Color.BLACK);
        moduleJList.setForeground(Color.WHITE);

        modules.addElement(new Module("EAGLE", 2000, 11, 7200));
        modules.addElement(new Module("VOYAGER", 2100, 9, 7800));
        modules.addElement(new Module("LUNA", 1900, 7, 7400));
        modules.addElement(new Module("DESTINY", 2054, 6, 7600));
        modules.addElement(new Module("UNITY", 1950, 10, 7000));
        modules.addElement(new Module("COLUMBUS", 1800, 8, 8000));
        modules.addElement(new Module("ZARJA", 2000, 11, 19323));
        modules.addElement(new Module("ZVEZDA", 2100, 9, 19050));
        modules.addElement(new Module("NAUKA", 1900, 7, 20300));
        modules.addElement(new Module("DESTINY", 2054, 6, 14515));
        modules.addElement(new Module("UNITY", 1950, 10, 12717));
        modules.addElement(new Module("COLUMBUS", 1800, 8, 19300));
        modules.addElement(new Module("HARMONY", 2050, 5, 14288));
        modules.addElement(new Module("KIBÓ", 2010, 4, 8484));

        //Button for selecting module
        buttonSelectModule.addActionListener(e -> {
            if (moduleJList.getSelectedIndex() != -1) {
                module = modules.get(moduleJList.getSelectedIndex());
                selectedModule = "Selected module: " + moduleJList.getSelectedValue();
                moduleLabel.setText(selectedModule);
                WindowHighRes.setModuleSelected(true);
            }
        });
        moduleJPanel.add(moduleSelectionLabel);
        moduleJPanel.add(moduleJList);
        moduleJPanel.add(buttonSelectModule);
        moduleJPanel.add(moduleLabel);

        setFrame(frame);
    }

    //Method for selecting planet
    public void select(Progress progress) {
        selectionLabel();
        selectModule();

        planetJPanel.setBackground(Color.DARK_GRAY);
        planetJPanel.setBounds(0, 350, 1500, 420);

        planetSelectionLabel.setFont(new Font("Calibre", Font.BOLD,30));
        planetSelectionLabel.setForeground(Color.WHITE);

        planetLabel.setFont(new Font("Calibre", Font.BOLD, 20));
        planetLabel.setForeground(Color.WHITE);

        planetJList.setBackground(Color.BLACK);
        planetJList.setForeground(Color.WHITE);

        continueButton.setVisible(false);
        continueButton.setBounds(750, 400, 150, 60);

        //Planets
        planets.addElement(new Planet("MERCURY", 3.7));
        planets.addElement(new Planet("VENUS", 8.87));
        planets.addElement(new Planet("EARTH", 9.8));
        planets.addElement(new Planet("MOON", 1.62));
        planets.addElement(new Planet("MARS", 3.721));
        planets.addElement(new Planet("EUROPA", 1.315));
        planets.addElement(new Planet("GANYMEDES", 1.428 ));
        planets.addElement(new Planet("CALLISTO", 1.235));
        planets.addElement(new Planet("SATURN", 10.44));
        planets.addElement(new Planet("URANUS", 8.87));
        planets.addElement(new Planet("PLUTO", 0.62));
        planets.addElement(new Planet("NEPTUNE", 11.15));

        //Button for selecting planet
        buttonSelectPlanet.addActionListener(e -> {
            if (planetJList.getSelectedIndex() != -1) {
                planet = planets.get(planetJList.getSelectedIndex());
                selectedPlanet = "Selected planet: " + planetJList.getSelectedValue();
                planetLabel.setText(selectedPlanet);
                WindowHighRes.setPlanetSelected(true);
                frame.repaint();
            }
        });

        planetJPanel.add(planetSelectionLabel);
        planetJPanel.add(planetJList);
        planetJPanel.add(buttonSelectPlanet);
        planetJPanel.add(planetLabel);
        planetJPanel.add(continueButton);

        //Button ending selection part
        continueButton.addActionListener(e -> {
            frame.remove(continueButton);
            frame.remove(planetJPanel);
            frame.remove(moduleJPanel);
            frame.remove(selectionLabelPanel);
            frame.repaint();
            window(progress);
            Thread thread = new Thread(progress);
            thread.start();
        });

        frame.add(selectionLabelPanel);
        frame.add(moduleJPanel);
        frame.add(planetJPanel);
    }

    //Show window methods
    public void window(Progress progress) {
        frame.setContentPane(new ImagePanel());
        this.progress = progress;

        //Thrust-changing buttons
        buttonThrustUp = new JButton();
        buttonThrustUp.setText("+ 10");
        buttonThrustUp.setForeground(Color.WHITE);
        buttonThrustUp.setBounds(1115, 860, 100, 60);
        buttonThrustUp.addActionListener(this);
        buttonThrustUp.setOpaque(false);
        buttonThrustUp.setContentAreaFilled(false);
        buttonThrustUp.setBorderPainted(false);

        buttonThrustDown = new JButton();
        buttonThrustDown.setText("- 10");
        buttonThrustDown.setForeground(Color.WHITE);
        buttonThrustDown.setBounds(1255, 860, 100, 60);
        buttonThrustDown.addActionListener(this);
        buttonThrustDown.setOpaque(false);
        buttonThrustDown.setContentAreaFilled(false);
        buttonThrustDown.setBorderPainted(false);

        //Time labels
        labelTime = new JLabel();
        labelTime.setText("TIME");
        labelTime.setFont(new Font("Calibri", Font.PLAIN, 20));
        labelTime.setForeground(Color.WHITE);
        labelTime.setBounds(732, 592, 200, 500);

        labelTimeValue = new JLabel();
        labelTimeValue.setText(" ");
        labelTimeValue.setFont(new Font("Calibri", Font.BOLD, 20));
        labelTimeValue.setForeground(Color.WHITE);
        labelTimeValue.setBounds(732, 618, 200, 500);

        //Thrust labels
        thrustValue = new JLabel();
        thrustValue.setText(" ");
        thrustValue.setForeground(Color.WHITE);
        thrustValue.setFont(new Font("Calibri", Font.BOLD, 20));
        thrustValue.setBounds(1215, 580, 200, 500);

        thrustValueTitle = new JLabel();
        thrustValueTitle.setText("ENGINE THRUST");
        thrustValueTitle.setForeground(Color.WHITE);
        thrustValueTitle.setFont(new Font("Calibri", Font.PLAIN, 20));
        thrustValueTitle.setBounds(965, 615, 200, 500);

        //Planet labels
        planetTitle = new JLabel();
        planetTitle.setText("LANDING ON: ");
        planetTitle.setForeground(Color.WHITE);
        planetTitle.setFont(new Font("Calibri", Font.BOLD, 20));
        planetTitle.setBounds(1170, -7, 200, 500);

        planetValue = new JLabel();
        planetValue.setText(" ");
        planetValue.setForeground(Color.WHITE);
        planetValue.setFont(new Font("Calibri", Font.BOLD, 20));
        planetValue.setBounds(1170, 22, 200, 500);

        //Changing quantities titles
        labelSpeed = new JLabel();
        labelSpeed.setText("SPEED");
        labelSpeed.setForeground(Color.WHITE);
        labelSpeed.setBounds(400, 420, 500, 500);

        labelHeight = new JLabel();
        labelHeight.setText("HEIGHT");
        labelHeight.setForeground(Color.WHITE);
        labelHeight.setBounds(600, 420, 500, 500);

        labelLeverage = new JLabel();
        labelLeverage.setText("ACCELERATION");
        labelLeverage.setForeground(Color.WHITE);
        labelLeverage.setBounds(800, 420, 500, 500);

        labelFuel = new JLabel();
        labelFuel.setText("FUEL");
        labelFuel.setForeground(Color.WHITE);
        labelFuel.setBounds(1000, 420, 500, 500);

        //Changing quantities values
        labelSpeedValue = new JLabel();
        labelSpeedValue.setText(" ");
        labelSpeedValue.setForeground(Color.WHITE);
        labelSpeedValue.setFont(new Font("Calibri", Font.BOLD, 20));
        labelSpeedValue.setBounds(400, 450, 500, 500);

        labelHeightValue = new JLabel();
        labelHeightValue.setText(" ");
        labelHeightValue.setForeground(Color.WHITE);
        labelHeightValue.setFont(new Font("Calibri", Font.BOLD, 20));
        labelHeightValue.setBounds(600, 450, 500, 500);

        labelAccelerationValue = new JLabel();
        labelAccelerationValue.setText(" ");
        labelAccelerationValue.setForeground(Color.WHITE);
        labelAccelerationValue.setFont(new Font("Calibri", Font.BOLD, 20));
        labelAccelerationValue.setBounds(800, 450, 500, 500);

        labelFuelValue = new JLabel();
        labelFuelValue.setText(" ");
        labelFuelValue.setForeground(Color.WHITE);
        labelFuelValue.setFont(new Font("Calibri", Font.BOLD, 20));
        labelFuelValue.setBounds(1000, 450, 500, 500);

        //Conclusion labels
        labelComputer = new JLabel();
        labelComputer.setText("COMPUTER: ");
        labelComputer.setForeground(Color.WHITE);
        labelComputer.setFont(new Font("Calibri", Font.PLAIN, 20));
        labelComputer.setBounds(100, 630, 200, 500);

        listComputer = new JLabel();
        listComputer.setText(" ");
        listComputer.setForeground(Color.WHITE);
        listComputer.setFont(new Font("Calibri", Font.BOLD, 18));
        listComputer.setBounds(100, 660, 500, 500);

        impactVelocityTitle = new JLabel();
        impactVelocityTitle.setText("You landed at speed: ");
        impactVelocityTitle.setForeground(Color.WHITE);
        impactVelocityTitle.setFont(new Font("Calibri", Font.PLAIN, 20));
        impactVelocityTitle.setBounds(100, 580, 200, 500);

        listSpeed = new JLabel();
        listSpeed.setText(" ");
        listSpeed.setForeground(Color.WHITE);
        listSpeed.setFont(new Font("Calibri", Font.BOLD, 20));
        listSpeed.setBounds(300, 580, 200, 500);

        //Original values labels
        labelOriginValues = new JLabel();
        labelOriginValues.setText("ORIGINAL VALUES: ");
        labelOriginValues.setForeground(Color.WHITE);
        labelOriginValues.setFont(new Font("Calibri", Font.PLAIN, 20));
        labelOriginValues.setBounds(50, -210, 200, 500);

        originSpeedValueTitle = new JLabel();
        originSpeedValueTitle.setText("SPEED");
        originSpeedValueTitle.setForeground(Color.WHITE);
        originSpeedValueTitle.setBounds(300, -225, 200, 500);

        originHeightValueTitle = new JLabel();
        originHeightValueTitle.setText("HEIGHT");
        originHeightValueTitle.setForeground(Color.WHITE);
        originHeightValueTitle.setBounds(500, -225, 200, 500);

        originMaxThrustValueTitle = new JLabel();
        originMaxThrustValueTitle.setText("MAXTHRUST");
        originMaxThrustValueTitle.setForeground(Color.WHITE);
        originMaxThrustValueTitle.setBounds(700, -225, 200, 500);

        originFuelValueTitle = new JLabel();
        originFuelValueTitle.setText("FUEL");
        originFuelValueTitle.setForeground(Color.WHITE);
        originFuelValueTitle.setBounds(900, -225, 200, 500);

        originWeightValueTitle = new JLabel();
        originWeightValueTitle.setText("WEIGHT");
        originWeightValueTitle.setForeground(Color.WHITE);
        originWeightValueTitle.setBounds(1100, -225, 200, 500);

        originGravityValueTitle = new JLabel();
        originGravityValueTitle.setText("GRAVITY");
        originGravityValueTitle.setForeground(Color.WHITE);
        originGravityValueTitle.setBounds(1300, -225, 200, 500);

        originSpeedValue = new JLabel();
        originSpeedValue.setText(" ");
        originSpeedValue.setForeground(Color.WHITE);
        originSpeedValue.setFont(new Font("Calibri", Font.BOLD, 20));
        originSpeedValue.setBounds(300, -200, 200, 500);

        originHeightValue = new JLabel();
        originHeightValue.setText(" ");
        originHeightValue.setForeground(Color.WHITE);
        originHeightValue.setFont(new Font("Calibri", Font.BOLD, 20));
        originHeightValue.setBounds(500, -200, 200, 500);

        originMaxThrustValue = new JLabel();
        originMaxThrustValue.setText(" ");
        originMaxThrustValue.setForeground(Color.WHITE);
        originMaxThrustValue.setFont(new Font("Calibri", Font.BOLD, 20));
        originMaxThrustValue.setBounds(700, -200, 200, 500);

        originFuelValue = new JLabel();
        originFuelValue.setText(" ");
        originFuelValue.setForeground(Color.WHITE);
        originFuelValue.setFont(new Font("Calibri", Font.BOLD, 20));
        originFuelValue.setBounds(900, -200, 200, 500);

        originWeightValue = new JLabel();
        originWeightValue.setText(" ");
        originWeightValue.setForeground(Color.WHITE);
        originWeightValue.setFont(new Font("Calibri", Font.BOLD, 20));
        originWeightValue.setBounds(1100, -200, 200, 500);

        originGravityValue = new JLabel();
        originGravityValue.setText(" ");
        originGravityValue.setForeground(Color.WHITE);
        originGravityValue.setFont(new Font("Calibri", Font.BOLD, 20));
        originGravityValue.setBounds(1300, -200, 200, 500);

        //Countdown
        Countdown countdown = new Countdown(frame, progress);
        countdown.setBounds(600, 350, 300, 150);

        Thread thread = new Thread(countdown);
        thread.start();

        //Frame
        setFrame(frame);

        //Countdown
        frame.add(countdown);

        //Conclusion labels
        frame.add(labelComputer);
        frame.add(listComputer);
        frame.add(impactVelocityTitle);
        frame.add(listSpeed);

        //Original values labels
        frame.add(labelOriginValues);
        frame.add(originSpeedValue);
        frame.add(originHeightValue);
        frame.add(originFuelValue);
        frame.add(originMaxThrustValue);
        frame.add(originWeightValue);
        frame.add(originGravityValue);
        frame.add(originSpeedValueTitle);
        frame.add(originHeightValueTitle);
        frame.add(originMaxThrustValueTitle);
        frame.add(originFuelValueTitle);
        frame.add(originWeightValueTitle);
        frame.add(originGravityValueTitle);

        //Time labels
        frame.add(labelTime);
        frame.add(labelTimeValue);

        //Planet labels
        frame.add(planetTitle);
        frame.add(planetValue);

        //Changing quantities titles
        frame.add(labelSpeed);
        frame.add(labelHeight);
        frame.add(labelLeverage);
        frame.add(labelFuel);

        //Changing quantities values
        frame.add(labelSpeedValue);
        frame.add(labelHeightValue);
        frame.add(labelAccelerationValue);
        frame.add(labelFuelValue);

        //Thrust labels
        frame.add(thrustValue);
        frame.add(thrustValueTitle);

        //Thrust-changing buttons
        frame.add(buttonThrustUp);
        frame.add(buttonThrustDown);
    }

    //Thrust down and up buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonThrustDown) {
            progress.addEngineThrust(-10);
        } else {
            progress.addEngineThrust(10);
        }
    }

    //Is module selected?
    public static void setModuleSelected(boolean moduleSelected) {
        isModuleSelected = moduleSelected;
        if (isPlanetSelected) {
            continueButton.setVisible(true);
        }
    }

    //Is planet selected
    public static void setPlanetSelected(boolean planetSelected) {
        isPlanetSelected = planetSelected;
        if (isModuleSelected) {
            continueButton.setVisible(true);
        }
    }

    //Frame properties
    public void setFrame(JFrame frame) {
        frame.setTitle("Module");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(1500, 1000);
        frame.toFront();
        frame.requestFocus();
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        this.frame = frame;
    }

    public Module getModule() {
        return module;
    }

    public Planet getPlanet() {
        return planet;
    }

    public JLabel getLabelSpeedValue() {
        return labelSpeedValue;
    }

    public JLabel getLabelHeightValue() {
        return labelHeightValue;
    }

    public JLabel getLabelAccelerationValue() {
        return labelAccelerationValue;
    }

    public JLabel getLabelFuelValue() {
        return labelFuelValue;
    }

    public JLabel getThrustValue() {
        return thrustValue;
    }

    public JLabel getPlanetValue() {
        return planetValue;
    }

    public JLabel getLabelTimeValue() {
        return labelTimeValue;
    }

    public JLabel getListComputer() {
        return listComputer;
    }

    public JLabel getListSpeed() {
        return listSpeed;
    }

    public JLabel getOriginSpeedValue() {
        return originSpeedValue;
    }

    public JLabel getOriginHeightValue() {
        return originHeightValue;
    }

    public JLabel getOriginFuelValue() {
        return originFuelValue;
    }

    public JLabel getOriginMaxThrustValue() {
        return originMaxThrustValue;
    }

    public JLabel getOriginWeightValue() {
        return originWeightValue;
    }

    public JLabel getOriginGravityValue() {
        return originGravityValue;
    }
}

