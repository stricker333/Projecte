package alumnes.Libreria;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.vAlumneOnline;

public class txt {

    //GENERA TXT ALUMNES
    public static void generaTxtAO() {
        String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH + ".txt";
                f = new File(PATH);

                FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream o = new ObjectOutputStream(fo);
                o.writeObject(vAlumneOnline.ao);
                o.close();
                JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
