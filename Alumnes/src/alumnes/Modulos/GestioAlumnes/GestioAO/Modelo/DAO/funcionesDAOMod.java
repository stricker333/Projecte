package alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.DAO;


import javax.swing.JOptionPane;
import alumnes.Clases.Fecha;
import alumnes.Libreria.core;
import static alumnes.Modulos.GestioAlumnes.GestioAO.Vista.ModificarAlumneOnline.*;
public class funcionesDAOMod {

	public static String datos(int i) {
		String string = null;

		if (i == 1)
			string = core.coreNom(nom.getText());
		else if (i == 2)
			string = core.coreCognom(cognom.getText());
		else if (i == 3)
			string = core.coreDNI(DNI.getText());
		else if (i == 4)
			string = core.coreNom(especialitat.getText());
		else if (i == 5)
			string = core.coreDireccio(direccio.getText());
		else if (i == 6)
			string = core.coreUsuari(user.getText());
		else if (i == 7)
			string = core.corePass(pass.getText());
		else
			JOptionPane.showMessageDialog(null, "Error en la introduccion de datos");

		return string;
	}

	public static int num(int i) {
		int num = 0;

		if (i == 1)
			num = core.coreCurso(curs.getText());
		else if (i == 2)
			num = core.coreHora(conexio.getText());
		else if (i == 3)
			num = core.coreHora(desconexio.getText());
		//else if (i == 4)
		//	num = core.coreClasePC("Introdueix el teu num de clase" + "\n", "Introduccion de datos");
		//else if (i == 5)
		//	num = core.coreClasePC("Introdueix el teu num de pc" + "\n", "Introduccion de datos");
		else
			JOptionPane.showMessageDialog(null, "Error en la introduccion de datos");

		return num;
	}

	public static double numdouble(int i) {
		double numdouble = 0;

		if (i == 1)
			numdouble = core.coreBeca(beca.getText());
		else
			JOptionPane.showMessageDialog(null, "Error en la introduccion de datos");

		return numdouble;

	}

	public static Fecha pedirfecha(int i) {
		int edad = 0, aux = 0, num = 0;
		Fecha fecha = null;
		boolean inter = false;

		if (i == 1) {
			
                    
				fecha = core.coreFecha(Fecha.paseDateToString(naixement.getDate()));
				edad = fecha.restaFechas();
                                
                                if (edad > 50 || edad < 10){
                                    naixementNo.setVisible(true);
                                }else {
                                    naixementNo.setVisible(false);
                                }


		} else {
			JOptionPane.showMessageDialog(null, "Error en la introduccion de datos");
		}

		return fecha;
	}
        
        
        
}
