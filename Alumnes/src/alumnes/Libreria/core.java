package alumnes.Libreria;

import javax.swing.JOptionPane;
import alumnes.Clases.Fecha;

public class core {

    // core Nom
    public static String coreNom(String nom) {
        boolean valido = false;

        do {
            valido = Validate.regexNom(nom);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "El teu nom no es valid");
            }
        } while (valido == false);
        return nom;
    }

    // core Cognom
    public static String coreCognom(String cognom) {
        boolean valido = false;

        do {

            valido = Validate.regexCognoms(cognom);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "El teu cognom no es valid");
            }
        } while (valido == false);
        return cognom;
    }

    // core DNI
    public static String coreDNI(String DNI) {
        boolean valido = false;

        do {
            valido = Validate.regexDNI(DNI);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "El teu DNI no es valid");
            }
        } while (valido == false);
        return DNI;
    }

    // core CIF
    public static String coreCIF(String CIF) {
        boolean valido = false;

        do {
            valido = Validate.regexCIF(CIF);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "El teu CIF no es valid");
            }
        } while (valido == false);
        return CIF;
    }

    // core Email
    public static String coreEmail(String Email) {
        boolean valido = false;

        do {
            valido = Validate.regexEmail(Email);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "El teu Email no es valid");
            }
        } while (valido == false);
        return Email;
    }

    // core CP
    public static String coreCP(String CP) {
        boolean valido = false;

        do {
            valido = Validate.regexCP(CP);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "El teu Codi Postal no es valid");
            }
        } while (valido == false);
        return CP;
    }

    // core Direccio
    public static String coreDireccio(String Direccio) {
        boolean valido = false;

        do {
            valido = Validate.regexDireccio(Direccio);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "La teua Direccio no es valida");
            }
        } while (valido == false);
        return Direccio;
    }

    // core Telefon
    public static String coreTelefon(String Telefon) {
        boolean valido = false;

        do {
            valido = Validate.regexTelefono(Telefon);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "El teu Telefon no es valid");
            }
        } while (valido == false);
        return Telefon;
    }

    // core Fecha
    public static Fecha coreFecha(String Fech) {
        boolean valido1 = false;
        boolean valido2 = false;
        Fecha fecha = null;

        do {
            do {

                valido1 = Validate.regexFecha(Fech);
                if (valido1 == false) {
                    JOptionPane.showMessageDialog(null, "La Fecha debe tener este formato: (dd/mm/yyyy)");
                }
            } while (valido1 == false);

            fecha = new Fecha(Fech);

            valido2 = fecha.validafecha();

            if (valido2 == false) {
                JOptionPane.showMessageDialog(null, "La Fecha Introducida no es valida.");
            }
        } while (valido2 == false);

        return fecha;
    }

    // core Fecha
    public static Fecha coreFecha2(String Fech) {
        boolean valido1 = false;
        boolean valido2 = false;
        Fecha fecha = null;

        fecha = new Fecha(Fech);

        valido2 = fecha.validafecha();

        return fecha;
    }

    // core Usuari
    public static String coreUsuari(String Usuari) {
        boolean valido = false;

        do {
            valido = Validate.regexUsuari(Usuari);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "El teu nom de Usuari no es valid");
            }
        } while (valido == false);
        return Usuari;
    }

    // core Password
    public static String corePass(String Pass) {
        boolean valido = false;

        do {
            valido = Validate.regexPass(Pass);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "El teu Password no es valid");
            }
        } while (valido == false);
        return Pass;
    }

    // core URL
    public static String coreURL(String URL) {
        boolean valido = false;

        do {
            valido = Validate.regexURL(URL);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "La teua URL no es valida");
            }
        } while (valido == false);
        return URL;
    }

    // core Curso
    public static int coreCurso(String scurso) {
        int curso = 0;
        boolean valido = false;

        do {
            valido = Validate.regexCurso(scurso);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "El teu Curs  deu estar entre 1 y 4");
            }
        } while (valido == false);
        curso = Integer.parseInt(scurso);
        return curso;
    }

    // core Horas de 00 a 23
    public static int coreHora(String shora) {
        int hora = 0;
        boolean valido = false;

        do {
            valido = Validate.regexHora(shora);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "Hores acceptades de 00 a 23");
            }
        } while (valido == false);
        hora = Integer.parseInt(shora);
        return hora;
    }

    // core ClasePC de 01 a 23
    public static int coreClasePC(String sclasepc) {
        int clasepc = 0;
        boolean valido = false;

        do {
            valido = Validate.regex23max(sclasepc);
            if (valido == false) {
                JOptionPane.showMessageDialog(null, "Maxim de 23");
            }
        } while (valido == false);
        clasepc = Integer.parseInt(sclasepc);
        return clasepc;
    }

    public static double coreBeca(String sbeca) {
        double beca = 0;
        boolean valido = false;

        do {
            valido = true;
            if ((beca > 6000) | (beca < 0)) {
                JOptionPane.showMessageDialog(null, "Max 6.000, Min 0");
                valido = false;
            }
            beca = Integer.parseInt(sbeca);
        } while (valido == false);

        return beca;
    }

}
