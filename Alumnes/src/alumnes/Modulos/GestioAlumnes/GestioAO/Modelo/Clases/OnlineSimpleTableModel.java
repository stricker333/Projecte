package alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases;

import alumnes.Modulos.Inicio.Vista.Vent1;
import alumnes.Clases.Fecha;
import alumnes.Main;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.BLL.AOBLL;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.BLL.AOBLLBD;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.*;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.pager.pagina;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class OnlineSimpleTableModel extends AbstractTableModel {

    public static ArrayList<AlumnesOnline> ao = new ArrayList<AlumnesOnline>();
    public static ArrayList<AlumnesOnline> aoAux = new ArrayList<AlumnesOnline>();

    public static String[] titul(int op) {
        String[] cant = null;

        if (op == 0) {
            String[] columnas = {"nom", "cognom", "DNI", "especialitat"};
            cant = columnas;
        } else if (op == 1) {
            String[] columnas = {"nom", "cognom", "DNI", "especialitat", "direccio"};
            cant = columnas;
        } else if (op == 2) {
            String[] columnas = {"nom", "cognom", "DNI", "especialitat", "direccio", "curs"};
            cant = columnas;
        } else if (op == 3) {
            String[] columnas = {"nom", "cognom", "DNI", "especialitat", "direccio", "curs", "edat", "datanaix"};
            cant = columnas;
        } else if (op == 4) {
            String[] columnas = {"nom", "cognom", "DNI", "especialitat", "direccio", "curs", "edat", "datanaix", "beca", "user", "pass"};
            cant = columnas;
        } else if (op == 5) {
            String[] columnas = {"nom", "cognom", "DNI", "especialitat", "direccio", "curs", "edat", "datanaix", "beca", "user", "pass", "hora_conexion", "hora_desconexion", "Conectat"};
            cant = columnas;
        } else if (op == 6) {
            String[] columnas = {"nom", "cognom", "DNI", "especialitat", "direccio", "curs", "edat", "datanaix", "beca", "user", "pass", "hora_conexion", "hora_desconexion", "Conectat", "Faltes"};
            cant = columnas;
        }

        return cant;

    }

    String[] columnas = titul(Main.config.getTabla());

    //String[] columnas = prova();
    //Devuelve el nombre de la columna
    @Override
    public String getColumnName(int col) {
        return columnas[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return ao.size();
    }

    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Anade una fila al modelo
    public void addRow(AlumnesOnline p) {
        ao.add(p);
        fireTableDataChanged();
    }

    //Borra una fila dle modelo
    public void removeRow(int fila) {
        ao.remove(fila);
        fireTableDataChanged();
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        Object dev = null;
        AlumnesOnline fila = (AlumnesOnline) ao.get(row);

        switch (col) {
            case 0:
                dev = fila.getNom();
                break;
            case 1:
                dev = fila.getCognom();
                break;
            case 2:
                dev = fila.getDNI();
                break;
            case 3:
                dev = fila.getEspecialitat();
                break;
            case 4:
                dev = fila.getDireccio();
                break;
            case 5:
                dev = fila.getCurs();
                break;
            case 6:
                dev = fila.getEdat();
                break;
            case 7:
                dev = fila.getDatanaix().aStringFecha();
                break;
            case 8:
                dev = fila.getBeca();
                break;
            case 9:
                dev = fila.getUser();
                break;
            case 10:
                dev = fila.getPass();
                break;
            case 11:
                dev = fila.getHora_conexion();
                break;
            case 12:
                dev = fila.getHora_desconexion();
                break;
            case 13:
                dev = fila.getHoras_conectado();
                break;
            case 14:
                dev = fila.getFaltas();
                break;
        }
        return dev;
    }

    //Actualiza un objeto de una fila y columna
    public void setValueAt(Object value, int row, int col) {

        AlumnesOnline fila = (AlumnesOnline) ao.get(row);

        switch (col) {
            case 0:
                fila.setNom(value.toString());
                break;
            case 1:
                fila.setCognom(value.toString());
                break;
            case 2:
                fila.setDNI(value.toString());
                break;
            case 3:
                fila.setEspecialitat(value.toString());
                break;
            case 4:
                fila.setDireccio(value.toString());
                break;
            case 5:
                fila.setCurs((int) value);
                break;
            case 6:
                fila.setEdat((int) (value));
                break;
            case 7:
                fila.setDatanaix((Fecha) (value));
                break;
            case 8:
                fila.setBeca((double) value);
                break;
            case 9:
                fila.setUser(value.toString());
                break;
            case 10:
                fila.setPass(value.toString());
                break;
            case 11:
                fila.setHora_conexion((int) value);
                break;
            case 12:
                fila.setHora_desconexion((int) value);
                break;
            case 13:
                fila.setHoras_conectado((int) value);
                break;
            case 14:
                fila.setFaltas((int) value);
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void filtrarNom() {
        ao.clear();

        int cont = 0;
        String nom = Vent1.buscar.getText();

        for (int i = 0; i < vAlumneOnline.ao.size(); i++) {
            if (aoAux.get(i).getNom().startsWith(nom)) {
                addRow(vAlumneOnline.ao.get(i));
                cont++;

            }
        }

        pagina.initLinkBox();
    }

    public void filtrarDNI() {
        ao.clear();

        int cont = 0;
        String DNI = Vent1.buscar1.getText();

        for (int i = 0; i < vAlumneOnline.ao.size(); i++) {
            if (aoAux.get(i).getDNI().startsWith(DNI)) {
                addRow(vAlumneOnline.ao.get(i));
                cont++;
            }
        }

        pagina.initLinkBox();
    }

    public void cargar() {
        ao.clear();
        aoAux.clear();

        AOBLLBD _pedidos = new AOBLLBD();
        _pedidos.listAllAlumnosBLL();

        for (int i = 0; i < vAlumneOnline.ao.size(); i++) {
            aoAux.add(vAlumneOnline.ao.get(i));
            addRow(aoAux.get(i));
        }

    }

    public AlumnesOnline buscar(String p) {
        ao.clear();
        cargar();

        String res;
        for (int i = 0; i < ao.size(); i++) {
            res = ao.get(i).toString();
            if (res.contains(p)) {
                return ao.get(i);
            }
        }
        return null;
    }

    public int buscaAlumneOnline(AlumnesOnline p) {
        ao.clear();
        cargar();

        for (int i = 0; i < ao.size(); i++) {
            if (ao.get(i).equals(p)) {
                return i;
            }
        }
        return -1;
    }

}
