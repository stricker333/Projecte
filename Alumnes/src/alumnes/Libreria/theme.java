package alumnes.Libreria;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class theme {

    public static void themePpal(String string) {
        try {

            if (string == "0") {// Nimbus

                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            }

            if (string == "1") {// Metal

                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

            }
            if (string == "2") {// GTK - WINDOWS

                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

            }

            if (string == "3") {// Obtener lista look&feel disponibles en el SO

                UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudo cargarse la apariencia deseada", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
