package tb.soft;

import javax.swing.*;
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
                    MainWindow window = new MainWindow();
//            window.show(); //deprecated -> setVisible
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public MainWindow() throws HeadlessException {
        this("undefined");
    }

    public MainWindow(String title) throws HeadlessException {
        super(title);

        setBounds(100, 100, 450, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program ma się zakończyć po zamknięciu tego okna

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnDo = new JMenu("Do");
        menuBar.add(mnDo);

        JMenuItem mnitDo = new JMenuItem("Work");
        mnitDo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doWork();
            }
        });
        mnDo.add(mnitDo);

    }

    /**
     * metoda nie robi nic, ale za to długo
     */
    private void doWork() {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < Integer.MAX_VALUE; j++)
                for (int k = 0; k < Integer.MAX_VALUE; k++)
                    ;
    }
}
