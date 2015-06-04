package alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.BLL;

import alumnes.Clases.Fecha;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import alumnes.Libreria.*;
import alumnes.Main;
import alumnes.Modulos.GestioAlumnes.Clase.Alumnes;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.AlumnesOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.vAlumneOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.DAO.AODAO;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.OnlineSimpleTableModel;
import alumnes.Modulos.GestioAlumnes.GestioAO.Vista.AfegirAlumneOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Vista.ModificarAlumneOnline;
import static alumnes.Modulos.GestioAlumnes.GestioAO.Vista.ModificarAlumneOnline.*;
import static alumnes.Modulos.Inicio.Vista.Vent1.botEliminar;
import static alumnes.Modulos.Inicio.Vista.Vent1.botModificar;
import static alumnes.Modulos.Inicio.Vista.Vent1.tablaOnline;
import alumnes.Libreria.Validate;
import alumnes.Libreria.core;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AOBLL {

    // Crear un AlumneOnline
    public static void crear(int i) {

        JTable jTableConModelo = null;
        AlumnesOnline ao1 = null;

        if (i == 0) {

            // Demana les dades dels AlumnesOnline
            ao1 = (AlumnesOnline) AODAO.pedirdatos();
            // Guarda les dades en el ArrayList
            vAlumneOnline.ao.add(ao1);
  

            //Guardar el ArrayList en BBDD
            AOBLLBD b = new AOBLLBD();

            int resultado = b.nuevoAlumnoBLL(ao1);

            if (resultado == -1) {
                JOptionPane.showMessageDialog(null, "No se ha podido realizar");
            } else {
                b.listAllAlumnosBLL();

            }

        } else { //Per cambiar Alumnes sense tocar DNI

            // Demana les dades dels AlumnesOnline
            ao1 = (AlumnesOnline) AODAO.pedirdatos2();
            // Guarda les dades en el ArrayList
            vAlumneOnline.ao.add(ao1);

            //Guardar el ArrayList en BBDD
            AOBLLBD b = new AOBLLBD();

            int resultado = b.nuevoAlumnoBLL(ao1);

            if (resultado == -1) {
                JOptionPane.showMessageDialog(null, "No se ha podido realizar");
            } else {
                b.listAllAlumnosBLL();
            }
        }
    }

    //Borrar un AlumneOnline
    public static void eliminar(int sel) {
        String DNI;
        AlumnesOnline a = null;
        int opc;

        int n = ((OnlineSimpleTableModel) tablaOnline.getModel()).getRowCount();

        DNI = (String) tablaOnline.getModel().getValueAt(sel, 2);

        opc = JOptionPane.showConfirmDialog(null, "Desitjes donar de baixa el alumne amb DNI: " + DNI,
                "Info", JOptionPane.WARNING_MESSAGE);

        if (opc == 0) {
            ((OnlineSimpleTableModel) tablaOnline.getModel()).removeRow(sel);

            //Elimina la posicio selec del ArrayList
            a = vAlumneOnline.ao.get(sel);
            vAlumneOnline.ao.remove(a);
            //Guardar el ArrayList en Fixer
            //AOBLL.GuardadoSilencioso();

            //Guardar el ArrayList en BBDD
            AOBLLBD b = new AOBLLBD();

            b.borrarAlumnoBLL(a);

            if (((OnlineSimpleTableModel) tablaOnline.getModel()).getRowCount() == 0) {
                botEliminar.setEnabled(false);
                botModificar.setEnabled(false);
            }
            if (((OnlineSimpleTableModel) tablaOnline.getModel()).getRowCount() != 0) {
                botEliminar.setEnabled(true);
                botModificar.setEnabled(true);
            }
        }
        //}
    }

    public static void gestionFaltas(int selection, int cant) {

        AlumnesOnline p;
        p = vAlumneOnline.ao.get(selection);

        if (p.getFaltas() + cant >= 0) {
            AOBLLBD as = new AOBLLBD();
            as.cambiarFaltaBLL(p.getDNI(), p.getFaltas() + cant);
        } else {
            JOptionPane.showMessageDialog(null, "Min 0 faltes");
        }

    }

    public static DefaultComboBoxModel PlenaComboBox() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < (vAlumneOnline.ao.size()); i++) {
            modelo.addElement(vAlumneOnline.ao.get(i).getDNI());
        }
        return modelo;
    }

    // Busca un Alumne
    public static int buscar(Alumnes a) {// Buscar
        int aux = -1;

        // Buclea fins que encontra un dni que concuadre amb el comparator de la
        // mare i el retorna com aux, si el encontra retornara la posicio, sino
        // retornara -1
        for (int i = 0; i <= (vAlumneOnline.ao.size() - 1); i++) {
            if ((vAlumneOnline.ao.get(i)).equals(a)) {
                aux = i;
            }
        }
        return aux;
    }

    // Busca un AlumneOnline
    public static int buscarOnline(AlumnesOnline ao) {
        int aux = -1;

        // Buclea fins que encontra un dni que concuadre amb el comparator de la
        // mare i el retorna com aux, si el encontra retornara la posicio, sino
        // retornara -1
        for (int i = 0; i <= (vAlumneOnline.ao.size() - 1); i++) {
            if ((vAlumneOnline.ao.get(i)).equals(ao)) {
                aux = i;
            }
        }
        return aux;
    }

    public static void LimpiarFormato(int op) {

        if (op == 0) {

            AfegirAlumneOnline.nom.setText("");
            AfegirAlumneOnline.cognom.setText("");
            AfegirAlumneOnline.DNI.setText("");
            AfegirAlumneOnline.beca.setText("");
            AfegirAlumneOnline.conexio.setText("");
            AfegirAlumneOnline.desconexio.setText("");
            AfegirAlumneOnline.curs.setText("");
            AfegirAlumneOnline.direccio.setText("");
            AfegirAlumneOnline.especialitat.setText("");
            AfegirAlumneOnline.naixement.setDate(null);
            AfegirAlumneOnline.user.setText("");
            AfegirAlumneOnline.pass.setText("");
        } else if (op == 1) {

            ModificarAlumneOnline.nom.setText("");
            ModificarAlumneOnline.cognom.setText("");
            ModificarAlumneOnline.DNI.setText("");
            ModificarAlumneOnline.beca.setText("");
            ModificarAlumneOnline.conexio.setText("");
            ModificarAlumneOnline.desconexio.setText("");
            ModificarAlumneOnline.curs.setText("");
            ModificarAlumneOnline.direccio.setText("");
            ModificarAlumneOnline.especialitat.setText("");
            ModificarAlumneOnline.naixement.setDate(null);
            ModificarAlumneOnline.user.setText("");
            ModificarAlumneOnline.pass.setText("");
        }
    }

    public static void IconsDisabled(int op) {

        if (op == 0) {
            AfegirAlumneOnline.nomNo.setVisible(false);
            AfegirAlumneOnline.cognomNo.setVisible(false);
            AfegirAlumneOnline.DNINo.setVisible(false);
            AfegirAlumneOnline.becaNo.setVisible(false);
            AfegirAlumneOnline.conexioNo.setVisible(false);
            AfegirAlumneOnline.desconexioNo.setVisible(false);
            AfegirAlumneOnline.direccioNo.setVisible(false);
            AfegirAlumneOnline.especialitatNo.setVisible(false);
            AfegirAlumneOnline.naixementNo.setVisible(false);
            AfegirAlumneOnline.userNo.setVisible(false);
            AfegirAlumneOnline.passNo.setVisible(false);
            AfegirAlumneOnline.cursNo.setVisible(false);
        } else if (op == 1) {

            ModificarAlumneOnline.nomNo.setVisible(false);
            ModificarAlumneOnline.cognomNo.setVisible(false);
            ModificarAlumneOnline.DNINo.setVisible(false);
            ModificarAlumneOnline.becaNo.setVisible(false);
            ModificarAlumneOnline.conexioNo.setVisible(false);
            ModificarAlumneOnline.desconexioNo.setVisible(false);
            ModificarAlumneOnline.direccioNo.setVisible(false);
            ModificarAlumneOnline.especialitatNo.setVisible(false);
            ModificarAlumneOnline.naixementNo.setVisible(false);
            ModificarAlumneOnline.userNo.setVisible(false);
            ModificarAlumneOnline.passNo.setVisible(false);
            ModificarAlumneOnline.cursNo.setVisible(false);
        }
    }

    public static void PlenaJTextFields(int selec, AlumnesOnline p) {

        nom.setText(p.getNom());
        cognom.setText(p.getCognom());
        DNI.setText(p.getDNI());
        beca.setText(Integer.toString((int) (p.getBeca())));
        if (Integer.toString(p.getHora_conexion()).length() == 1) {
            conexio.setText(0 + Integer.toString(p.getHora_conexion()));
        } else {
            conexio.setText(Integer.toString(p.getHora_conexion()));
        }
        if (Integer.toString(p.getHora_desconexion()).length() == 1) {
            desconexio.setText(0 + Integer.toString(p.getHora_desconexion()));
        } else {
            desconexio.setText(Integer.toString(p.getHora_desconexion()));
        }
        direccio.setText(p.getDireccio());
        especialitat.setText(p.getEspecialitat());
        naixement.setDate(Fecha.pideFechaDate(p.getDatanaix()));
        user.setText(p.getUser());
        pass.setText(p.getPass());
        curs.setText(Integer.toString(p.getCurs()));

    }

    public static void comprobarDatos(Object tipo, Object dato, int num) {
        boolean correcte = false;
        JTextField text = null;
        JTextField next = null;
        JLabel icon = null;

        //Pass
        if (tipo == AfegirAlumneOnline.pass) {
            correcte = Validate.regexPass(AfegirAlumneOnline.pass.getText());
            text = AfegirAlumneOnline.pass;
            icon = AfegirAlumneOnline.passNo;
            next = AfegirAlumneOnline.beca;

            //User
        } else if (tipo == AfegirAlumneOnline.user) {
            correcte = Validate.regexUsuari(AfegirAlumneOnline.user.getText());
            text = AfegirAlumneOnline.user;
            icon = AfegirAlumneOnline.userNo;
            next = AfegirAlumneOnline.pass;

            //Desconexio
        } else if (tipo == AfegirAlumneOnline.desconexio) {
            correcte = Validate.regexHora(AfegirAlumneOnline.desconexio.getText());
            text = AfegirAlumneOnline.desconexio;
            icon = AfegirAlumneOnline.desconexioNo;
            next = AfegirAlumneOnline.user;

            //Beca
        } else if (tipo == AfegirAlumneOnline.beca) {
            correcte = Validate.regexBeca(AfegirAlumneOnline.beca.getText());
            text = AfegirAlumneOnline.beca;
            icon = AfegirAlumneOnline.becaNo;
            //next = guardar;

            //Conexio
        } else if (tipo == AfegirAlumneOnline.conexio) {
            correcte = Validate.regexHora(AfegirAlumneOnline.conexio.getText());
            text = AfegirAlumneOnline.conexio;
            icon = AfegirAlumneOnline.conexioNo;
            next = AfegirAlumneOnline.desconexio;

            //Direccio
        } else if (tipo == AfegirAlumneOnline.direccio) {
            correcte = Validate.regexDireccio(AfegirAlumneOnline.direccio.getText());
            text = AfegirAlumneOnline.direccio;
            icon = AfegirAlumneOnline.direccioNo;
            next = AfegirAlumneOnline.curs;

            //DNI
        } else if (tipo == AfegirAlumneOnline.DNI) {
            correcte = Validate.regexDNI(AfegirAlumneOnline.DNI.getText());
            text = AfegirAlumneOnline.DNI;
            icon = AfegirAlumneOnline.DNINo;
            next = AfegirAlumneOnline.especialitat;

            //Curs
        } else if (tipo == AfegirAlumneOnline.curs) {
            correcte = Validate.regexCurso(AfegirAlumneOnline.curs.getText());
            text = AfegirAlumneOnline.curs;
            icon = AfegirAlumneOnline.cursNo;
            //next = naixement;

            //Especialitat
        } else if (tipo == AfegirAlumneOnline.especialitat) {
            correcte = Validate.regexNom(AfegirAlumneOnline.especialitat.getText());
            text = AfegirAlumneOnline.especialitat;
            icon = AfegirAlumneOnline.especialitatNo;
            next = AfegirAlumneOnline.direccio;

            //Nom
        } else if (tipo == AfegirAlumneOnline.nom) {
            correcte = Validate.regexNom(AfegirAlumneOnline.nom.getText());

            text = AfegirAlumneOnline.nom;
            icon = AfegirAlumneOnline.nomNo;
            next = AfegirAlumneOnline.cognom;
            //Cognom
        } else if (tipo == AfegirAlumneOnline.cognom) {
            correcte = Validate.regexCognoms(AfegirAlumneOnline.cognom.getText());
            text = AfegirAlumneOnline.cognom;
            icon = AfegirAlumneOnline.cognomNo;
            next = AfegirAlumneOnline.DNI;
            //Naixement
        } else if (tipo == AfegirAlumneOnline.naixement.getDate()) {
            correcte = Validate.regexFecha(AfegirAlumneOnline.naixement.getDateFormatString());
            
        }

        if (tipo != AfegirAlumneOnline.naixement) {
            if (text.getText().length() == 0 || correcte == false) {
                text.setForeground(Color.RED);
                icon.setVisible(true);
            } else {
                text.setForeground(Color.GREEN);
                icon.setVisible(false);

                if (num == 1) {
                    next.requestFocus();
                }
            }
        } else {
            Fecha fecha = null;
            int edad;

            fecha = core.coreFecha(Fecha.paseDateToString(AfegirAlumneOnline.naixement.getDate()));
            edad = fecha.restaFechas();

            if (AfegirAlumneOnline.naixement.getDateFormatString().length() == 0 || correcte == false || edad < 10 || edad > 60) {
                AfegirAlumneOnline.naixement.setForeground(Color.RED);
                AfegirAlumneOnline.naixementNo.setVisible(true);
                AfegirAlumneOnline.guardar.setEnabled(correcte);
            } else {
                AfegirAlumneOnline.naixement.setForeground(Color.GREEN);
                AfegirAlumneOnline.naixementNo.setVisible(false);
                AfegirAlumneOnline.conexio.requestFocus();
                AfegirAlumneOnline.guardar.setEnabled(correcte);

            }
        }
    }

    public static void comprobarDatos2(Object tipo, Object dato, int num) {
        boolean correcte = false;
        JTextField text = null;
        JTextField next = null;
        JLabel icon = null;

        //Pass
        if (tipo == ModificarAlumneOnline.pass) {
            correcte = Validate.regexPass(ModificarAlumneOnline.pass.getText());
            text = ModificarAlumneOnline.pass;
            icon = ModificarAlumneOnline.passNo;
            next = ModificarAlumneOnline.beca;

            //User
        } else if (tipo == ModificarAlumneOnline.user) {
            correcte = Validate.regexUsuari(ModificarAlumneOnline.user.getText());
            text = ModificarAlumneOnline.user;
            icon = ModificarAlumneOnline.userNo;
            next = ModificarAlumneOnline.pass;

            //Desconexio
        } else if (tipo == ModificarAlumneOnline.desconexio) {
            correcte = Validate.regexHora(ModificarAlumneOnline.desconexio.getText());
            text = ModificarAlumneOnline.desconexio;
            icon = ModificarAlumneOnline.desconexioNo;
            next = ModificarAlumneOnline.user;

            //Beca
        } else if (tipo == ModificarAlumneOnline.beca) {
            correcte = Validate.regexBeca(ModificarAlumneOnline.beca.getText());
            text = ModificarAlumneOnline.beca;
            icon = ModificarAlumneOnline.becaNo;
            //next = guardar;

            //Conexio
        } else if (tipo == ModificarAlumneOnline.conexio) {
            correcte = Validate.regexHora(ModificarAlumneOnline.conexio.getText());
            text = ModificarAlumneOnline.conexio;
            icon = ModificarAlumneOnline.conexioNo;
            next = ModificarAlumneOnline.desconexio;

            //Direccio
        } else if (tipo == ModificarAlumneOnline.direccio) {
            correcte = Validate.regexDireccio(ModificarAlumneOnline.direccio.getText());
            text = ModificarAlumneOnline.direccio;
            icon = ModificarAlumneOnline.direccioNo;
            next = ModificarAlumneOnline.curs;

            //DNI
        } else if (tipo == ModificarAlumneOnline.DNI) {
            correcte = Validate.regexDNI(ModificarAlumneOnline.DNI.getText());
            text = ModificarAlumneOnline.DNI;
            icon = ModificarAlumneOnline.DNINo;
            next = ModificarAlumneOnline.especialitat;

            //Curs
        } else if (tipo == ModificarAlumneOnline.curs) {
            correcte = Validate.regexCurso(ModificarAlumneOnline.curs.getText());
            text = ModificarAlumneOnline.curs;
            icon = ModificarAlumneOnline.cursNo;
            //next = naixement;

            //Especialitat
        } else if (tipo == ModificarAlumneOnline.especialitat) {
            correcte = Validate.regexNom(ModificarAlumneOnline.especialitat.getText());
            text = ModificarAlumneOnline.especialitat;
            icon = ModificarAlumneOnline.especialitatNo;
            next = ModificarAlumneOnline.direccio;

            //Nom
        } else if (tipo == ModificarAlumneOnline.nom) {
            correcte = Validate.regexNom(ModificarAlumneOnline.nom.getText());

            text = ModificarAlumneOnline.nom;
            icon = ModificarAlumneOnline.nomNo;
            next = ModificarAlumneOnline.cognom;
            //Cognom
        } else if (tipo == ModificarAlumneOnline.cognom) {
            correcte = Validate.regexCognoms(ModificarAlumneOnline.cognom.getText());
            text = ModificarAlumneOnline.cognom;
            icon = ModificarAlumneOnline.cognomNo;
            next = ModificarAlumneOnline.DNI;
            //Naixement
        } else if (tipo == ModificarAlumneOnline.naixement) {
            correcte = Validate.regexFecha(ModificarAlumneOnline.naixement.getDateFormatString());

        }

        if (tipo != ModificarAlumneOnline.naixement) {
            if (text.getText().length() == 0 || correcte == false) {
                text.setForeground(Color.RED);
                icon.setVisible(true);
            } else {
                text.setForeground(Color.GREEN);
                icon.setVisible(false);

                if (num == 1) {
                    next.requestFocus();
                }
            }
        } else {
            Fecha fecha = null;
            int edad;

            fecha = core.coreFecha(Fecha.paseDateToString(ModificarAlumneOnline.naixement.getDate()));
            edad = fecha.restaFechas();

            if (ModificarAlumneOnline.naixement.getDateFormatString().length() == 0 || correcte == false || edad < 10 || edad > 60) {
                ModificarAlumneOnline.naixement.setForeground(Color.RED);
                ModificarAlumneOnline.naixementNo.setVisible(true);
            } else {
                ModificarAlumneOnline.naixement.setForeground(Color.GREEN);
                ModificarAlumneOnline.naixementNo.setVisible(false);
                ModificarAlumneOnline.conexio.requestFocus();
            }
        }
    }

    public static void Guardar(int op) {
        if (vAlumneOnline.ao.size() != 0) {

            if (op == 1) {
                json.generaJsonAO();
            } else if (op == 2) {
                txt.generaTxtAO();
            } else if (op == 3) {
                xml.generaXmlAO();
            }
        } else {
            JOptionPane.showMessageDialog(null, "ArrayList vacio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
