package planetlanding.ui;

import planetlanding.game.Progress;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class Countdown extends JPanel implements Runnable {

    JLabel label = new JLabel("");
    Timer timer;
    JButton button = new JButton("CLICK TO START ");
    int count = 4;
    private final JFrame frame;
    private final Progress progress;

    public Countdown(JFrame frame,Progress progress) {
        this.frame = frame;
        this.progress = progress;
    }

    //Countdown progress
    @Override
    public void run() {
        setOpaque(false);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Calibre", Font.BOLD, 80));
        button.setBorder(BorderFactory.createBevelBorder(0));
        button.setFont(new Font("Calibre", Font.BOLD,  30));
        add(label);
        add(button);

        timer = new Timer(1000, e -> {
            button.setVisible(false);
            count--;
            if (count > 0) {
                label.setText(Integer.toString(count));
            } else {
                if (count == 0) {
                    label.setText("LAND!");
                    progress.setStart(true);
                }
                if (count == -2) {
                    remove(label);
                    repaint();
                    frame.remove(this);
                    frame.repaint();
                    ((Timer) (e.getSource())).stop();
                }
            }
        });
        timer.setInitialDelay(0);
        button.addActionListener(e -> timer.start());
    }
}

