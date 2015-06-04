package alumnes.Libreria;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.vAlumneOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.AlumnesOnline;

public class json {

    //GENERA JSON AO
    public static void generaJsonAO() {
        String PATH;
        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("AlumneOnline", AlumnesOnline.class);

            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                PATH = PATH + ".json";

                Gson gson1 = new Gson();
                String json = gson1.toJson(vAlumneOnline.ao);
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(json.toString());
                fileXml.close();

                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
