import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Clicker implements ActionListener {
    int count = 0;
    JLabel clicks;
    JLabel time;
    JPanel panel;
    JButton button;
    JFrame frame;

    public Clicker() {
        frame = new JFrame();

        Color cyan = Color.decode("#00A3A3");
        Color darkGrey = Color.decode("#66635c");

        button = new JButton("click here!");
        button.addActionListener(this);
        button.setBounds(17, 10, 180, 40);
        button.setBackground(cyan);
        button.setFont(new Font("Comic Sans", Font.BOLD, 24));
        button.setBorder(BorderFactory.createBevelBorder(0));
        button.setFocusable(false);
        button.setBorderPainted(false);

        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\KULDEEP\\Pictures\\Screenshots\\Fkey.png");
        Border border = BorderFactory.createLineBorder(cyan, 1);

        clicks = new JLabel("START CLICKING");
        clicks.setForeground (Color.white);
        clicks.setForeground(cyan);
        clicks.setBounds(50, 60, 150, 20);

        time = new JLabel("time", JLabel.CENTER);
        time.setForeground(cyan);
        time.setBounds(50, 100, 110, 20);
        time.setBorder(border);
        time.setPreferredSize(new Dimension(30, 10));

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(3, 1));
        panel.setBackground(darkGrey);
        panel.setBounds(1, 1, 220, 150);

        frame.add(button);
        frame.add(clicks);
        frame.add(time);
        frame.add(panel);
        frame.setBackground(darkGrey);
        frame.setIconImage(icon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(230, 160); //use frame.pack(); to automatically set the size
        frame.setTitle("click");
        frame.setLayout(null);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clicks.setText("number of clicks: " + ++count);
        if (count == 1) {
            t.start();
        }

        String tim = time.getText();

       if (tim.equals("time left: 0")) {
         time.setBounds(50, 80, 125, 35);
         time.setText("your CPM is: " + count);
       }

       if (tim.equals("time left: 0")) {
           button.setEnabled(false);
       }

       if (e.getSource() == button) {
           System.out.print("clik");
       }

    }

    Thread t = new Thread(() -> {
        for (int i = 60; i> -1; i--) {
            time.setText("time left: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
}
