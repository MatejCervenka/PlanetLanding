/*
package planetlanding.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowResChoice {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Choose preferred resolution:  ");
    JButton buttonHighRes = new JButton("HIGH");
    JButton buttonLowRes = new JButton("LOW");
    private boolean isHighRes = false;
    private boolean isLowRes = false;

    public WindowResChoice() {
        panel.setSize(300, 100);
        buttonHighRes.setBounds(0, 0, 10, 10);
        buttonLowRes.setBounds(0, 300, 300, 100);

        buttonHighRes.addActionListener(e -> {
            setHighRes(true);
            System.out.println(isHighRes);
        });

        buttonLowRes.addActionListener(e -> {
            setLowRes(true);
            System.out.println(isLowRes);
        });

        panel.add(label);
        panel.add(buttonLowRes);
        panel.add(buttonHighRes);
        frame.add(panel);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void setHighRes(boolean highRes) {
        isHighRes = highRes;
    }

    public void setLowRes(boolean lowRes) {
        isLowRes = lowRes;
    }

    public boolean isHighRes() {
        return isHighRes;
    }

    public boolean isLowRes() {
        return isLowRes;
    }
}
*/
