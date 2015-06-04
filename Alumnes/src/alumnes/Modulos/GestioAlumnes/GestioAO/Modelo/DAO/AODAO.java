package alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.DAO;

import alumnes.Modulos.GestioAlumnes.Clase.Alumnes;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.AlumnesOnline;

public class AODAO {

    // Demana Dades d'Alumnes Online
    public static Alumnes pedirdatos() {
        Alumnes alumnes = null;

        alumnes = new AlumnesOnline(funcionesDAOAlt.datos(1), funcionesDAOAlt.datos(2), funcionesDAOAlt.datos(3),
                funcionesDAOAlt.datos(4), funcionesDAOAlt.datos(5), funcionesDAOAlt.num(1), funcionesDAOAlt.pedirfecha(1),
                funcionesDAOAlt.numdouble(1), funcionesDAOAlt.datos(6), funcionesDAOAlt.datos(7), null, null, null, null,
                funcionesDAOAlt.num(2), funcionesDAOAlt.num(3), 0); 
        

        return alumnes;
    }

    // Demana Dades d'Alumnes OnlineMod
    public static Alumnes pedirdatos2() {
        Alumnes alumnes = null;

        alumnes = new AlumnesOnline(funcionesDAOMod.datos(1), funcionesDAOMod.datos(2), funcionesDAOMod.datos(3),
                funcionesDAOMod.datos(4), funcionesDAOMod.datos(5), funcionesDAOMod.num(1), funcionesDAOMod.pedirfecha(1),
                funcionesDAOMod.numdouble(1), funcionesDAOMod.datos(6), funcionesDAOMod.datos(7), null, null, null, null,
                funcionesDAOMod.num(2), funcionesDAOMod.num(3), 0);

        return alumnes;
    }

    public static Alumnes pidedni() {
        Alumnes o = null;
        String dni;

        dni = funcionesDAOAlt.datos(3);

        o = new AlumnesOnline(dni);

        return o;
    }

    public static Alumnes pidednivaciopers(String dnimatch) {
        Alumnes o = null;
        String dni;

        dni = dnimatch;

        o = new AlumnesOnline(dni);

        return o;
    }

}
