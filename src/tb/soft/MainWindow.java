package tb.soft;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * klasa główna zawierająca metodę statyczną main
 */
public class MainWindow extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public MainWindow() throws HeadlessException {
        this("untitled");
    }

    public MainWindow(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(648, 478);

        JPanel contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        MyPanel panel = new MyPanel();
        panel.setBounds(10, 11, 569, 353);
        contentPane.add(panel);

        JSlider poziom = new JSlider();
        poziom.setPaintTicks(true);
        poziom.setMajorTickSpacing(10);
        poziom.setBounds(10, 375, 569, 25);
        poziom.setMinimum(0);
        poziom.setMaximum(panel.getWidth());
        contentPane.add(poziom);

        JSlider pion = new JSlider();
        pion.setPaintTicks(true);
        pion.setMajorTickSpacing(10);
        pion.setOrientation(SwingConstants.VERTICAL);
        pion.setBounds(600, 11, 25, 353);
        pion.setMinimum(0);
        pion.setMaximum(panel.getHeight());
        contentPane.add(pion);

        JButton pokBtn = new JButton("Ukryj");
        JButton dodBtn = new JButton("Dodaj");

        pokBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (panel.isRysuj()) {
                    panel.setRysuj(false);
                    pokBtn.setText("Pokaż");
                    pokBtn.setToolTipText("Pokaż rysowany element");
                } else {
                    panel.setRysuj(true);
                    pokBtn.setText("Ukryj");
                    pokBtn.setToolTipText("Ukryj rysowany element");
                }
                panel.repaint();
            }
        });
        pokBtn.setBounds(10, 417, 90, 23);
        pokBtn.setEnabled(false);
        contentPane.add(pokBtn);

        dodBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pokBtn.setEnabled(true);
                panel.addSprajt(new Pilka(poziom.getValue(), pion.getMaximum() - pion.getValue()));
                panel.repaint();
            }
        });
        dodBtn.setBounds(105, 417, 90, 23);
        contentPane.add(dodBtn);
    }
}
