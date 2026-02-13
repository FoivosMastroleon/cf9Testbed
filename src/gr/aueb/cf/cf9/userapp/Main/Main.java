package gr.aueb.cf.cf9.userapp.Main;

import gr.aueb.cf.cf9.userapp.gui.LoginWindow;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }
}
