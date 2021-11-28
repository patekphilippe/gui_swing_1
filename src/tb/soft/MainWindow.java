package tb.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

/**
 * klasa główna zawierająca metodę statyczną main
 */
public class MainWindow extends JFrame {

    /**
     * pole w klasie, aby zachować stan między wywołaniami
     */
    private final JFileChooser fileChooser = new JFileChooser(".");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
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
        buildFrame();
    }

    /**
     * buduje okienko z elementów
     */
    protected void buildFrame() {

        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program ma się zakończyć po zamknięciu tego okna

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mnitOpen = new JMenuItem("Open");
        mnitOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doFileOpen();
            }
        });
        mnitOpen.setMnemonic(KeyEvent.VK_O);//można też po prostu 'O'
        mnFile.add(mnitOpen);

        JMenuItem mnitSave = new JMenuItem("Save");
        mnitSave.addActionListener(e -> {
            doFileSave();
        });
        mnitSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        mnFile.add(mnitSave);

        JToolBar toolBar = new JToolBar();
        getContentPane().add(toolBar, BorderLayout.NORTH);

        JButton btnOpenFileButton = new JButton("Open");
        btnOpenFileButton.setMnemonic(KeyEvent.VK_O);
        btnOpenFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doFileOpen();
            }
        });
        toolBar.add(btnOpenFileButton);

        JButton btnSaveFileButton = new JButton("Save");
        btnSaveFileButton.addActionListener(e -> {
            doFileSave();
        });
        toolBar.add(btnSaveFileButton);

    }

    private void doFileOpen() {
        int result = fileChooser.showOpenDialog(null);//okno pojawi się na środku ekranu
        if(result==JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(fileChooser,
                    String.format("Wybrano plik: %s",fileChooser.getSelectedFile()),
                    "Wybór",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void doFileSave() {
        fileChooser.showSaveDialog(this);//okno pojawi się na naszym oknie
    }
}