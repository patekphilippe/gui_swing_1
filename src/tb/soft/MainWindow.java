package tb.soft;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * klasa główna zawierająca metodę statyczną main
 */
public class MainWindow extends JFrame implements ActionListener{

    JButton tclearButton;
    JButton clearButton;
    JButton loginButton;
    JButton tloginButton;

    JLabel userLabel;
    JLabel passwordLabel;

    JTextField userField;
    JPasswordField passwordField;

//    JPanel panel;
//    JToolBar toolbar;

    Color myRed;
    Color myGreen;
    Color myGray;

    userDataBase myDataBase;

    String currentUser;
    String currentPassword;

    public static void main(String[] args) throws IOException{
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow application = new MainWindow();
                try {
                    application.createAndShowGUI();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void setComponents() throws IOException{

        tclearButton = new JButton("Clear");
        clearButton=new JButton("Clear");

        tloginButton = new JButton("Login");
        loginButton=new JButton("Login");

        userLabel = new JLabel("Podaj nazwe użytkownika:");
        passwordLabel = new JLabel("Podaj hasło:");

        userField=new JTextField();
        passwordField=new JPasswordField();

//        panel = new JPanel();
//        toolbar = new JToolBar();

        myRed = new Color(255, 0, 0);
        myGreen = new Color(42, 141, 2);
        myGray = Color.LIGHT_GRAY;

        myDataBase = new userDataBase();
        myDataBase.window = this;
    }


    private void createAndShowGUI() throws IOException {


        setComponents();

        setLayout(new BorderLayout());

        Container c = new Container();
        c.setLayout(null);

        clearButton.setBounds(50,250,100,30);
        loginButton.setBounds(250, 250, 100, 30);
        userField.setBounds(50, 100, 300, 20);
        passwordField.setBounds(50, 150, 300, 20);
        userLabel.setBounds(50, 80, 200, 20);
        passwordLabel.setBounds(50, 130,200, 20);


        clearButton.addActionListener((e)->onClear(e));
        tclearButton.addActionListener((e)->onClear(e));
        loginButton.addActionListener((e)->onLogin(e));
        tloginButton.addActionListener((e)->onLogin(e));

        c.add(clearButton);
        c.add(loginButton);
        c.add(userField);
        c.add(passwordField);
        c.add(userLabel);
        c.add(passwordLabel);

        JToolBar toolbar = new JToolBar();
        toolbar.setRollover(true);
        toolbar.add(tclearButton);
        toolbar.addSeparator();
        toolbar.add(tloginButton);

        add(toolbar, BorderLayout.NORTH);
        add(c, BorderLayout.CENTER);
        setSize(500,500);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        myDataBase.addUsers();

    }

    public void onClear(ActionEvent e) {
        getContentPane().setBackground(myGray);
        userField.setText("");
        passwordField.setText("");
    }

    public void onLogin(ActionEvent e) {
        currentUser = userField.getText();
        currentPassword = new String(passwordField.getPassword());

        if(myDataBase.checkIfUserExists(currentUser,currentPassword)) {
            getContentPane().setBackground(myGreen);
        } else {
            getContentPane().setBackground(myRed);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == loginButton || ae.getSource() == tloginButton ) {
            currentUser = userField.getText();
            currentPassword = new String(passwordField.getPassword());

             if(myDataBase.checkIfUserExists(currentUser,currentPassword)) {
                 getContentPane().setBackground(myGreen);
             } else {
                 getContentPane().setBackground(myRed);
             }
        }
        if(ae.getSource() == clearButton || ae.getSource() == tclearButton ) {
            getContentPane().setBackground(myGray);
            userField.setText("");
            passwordField.setText("");
        }
    }
}


