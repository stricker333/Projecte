package alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.DAO;

import alumnes.Modulos.GestioAlumnes.GestioAO.Vista.AfegirAlumneOnline;
import javax.swing.JOptionPane;

import alumnes.Clases.Fecha;
import alumnes.Libreria.core;
import static alumnes.Modulos.GestioAlumnes.GestioAO.Vista.AfegirAlumneOnline.*;
public class funcionesDAOAlt {

    /*
    String nom, String cognom, String DNI, String especialitat, String direccio, int curs,
            Fecha datanaix, double beca, String user, String pass, String Email, String tipo,
            String Estado, String Avatar, int hora_conexion, int hora_desconexion
    */
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


/*
		} else if (i == 2) {

			do {
				fecha = core.coreFecha("Donam la fecha de Examen" + "\n", "Introduccion de datos");
				aux = fecha.comparaFechaSistema();

				if (aux == 0) {
					JOptionPane.showMessageDialog(null, "La fecha de examen deu ser posterior a hui");
					inter = true;
				} else {
					num = fecha.restaFechas();
					if (num < -20) {
						JOptionPane.showMessageDialog(null, "Falten " + num * -1 + " anys, busca una data mes proxima");

					} else {
						inter = false;
					}
				}

			} while (inter == true);
*/
		} else {
			JOptionPane.showMessageDialog(null, "Error en la introduccion de datos");
		}

		return fecha;
	}
        
        
        
}
