import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements KeyListener {

    JTextField field = new JTextField(30);
    JLabel keyLabel = new JLabel("TwitterBot");
    JTextArea instruct = new JTextArea("Please press ESC to exit TwitterBot");
    private boolean exitKey = false;
    DataCollector subs = new DataCollector();

    public boolean getExitKey() {
        return this.exitKey;
    }

    public void start() {
        field.addKeyListener(this);
        setSize(400,400);
        setVisible(true);
        setLocationRelativeTo(null);

        BorderLayout borlayout = new BorderLayout();
        setLayout(borlayout);
        add(keyLabel, BorderLayout.NORTH);
        add(field, BorderLayout.PAGE_END);
        add(instruct, BorderLayout.CENTER);

        subs.start();

    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //not being used
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE) {
            System.out.println("TwitterBot disabled. You may now close the GUI.");
            this.exitKey = true;
            subs.interrupt();
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //not being used
    }

}
