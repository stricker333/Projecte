package alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases;

import java.io.Serializable;

import alumnes.Main;
import alumnes.Modulos.GestioAlumnes.Clase.Alumnes;
import alumnes.Libreria.format;
import alumnes.Clases.Fecha;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("AlumneOnline")
public class AlumnesOnline extends Alumnes implements Serializable {

    @XStreamAlias("hora_conexion")
    private int hora_conexion;
    @XStreamAlias("hora_desconexion")
    private int hora_desconexion;
    @XStreamAlias("horas_conectado")
    private int horas_conectado;
    @XStreamAlias("nota")
    private float nota;
    @XStreamAlias("faltas")
    private int faltas;

    public AlumnesOnline(String nom, String cognom, String DNI, String especialitat, String direccio, int curs,
            Fecha datanaix, double beca, String user, String pass, String Email, String tipo,
            String estado, String avatar, int hora_conexion, int hora_desconexion, int faltas) {

        super(nom, cognom, DNI, especialitat, direccio, curs, datanaix, beca, user, pass, Email, tipo, estado, avatar);
        this.hora_conexion = hora_conexion;
        this.hora_desconexion = hora_desconexion;
        this.setHoras_conectado(hora_desconexion - hora_conexion);
        this.setNota(this.calcularNota(horas_conectado));
        this.faltas = faltas;

    }

    public AlumnesOnline(){}
    
    public AlumnesOnline(String DNI) {
        super(DNI);
    }

    public int getHora_conexion() {
        return hora_conexion;
    }

    public void setHora_conexion(int hora_conexion) {
        this.hora_conexion = hora_conexion;
    }

    public int getHora_desconexion() {
        return hora_desconexion;
    }

    public void setHora_desconexion(int hora_desconexion) {
        this.hora_desconexion = hora_desconexion;
    }

    // Horas conectado
    public int getHoras_conectado() {
        return horas_conectado;
    }

    public void setHoras_conectado(int horas_conectado) {
        this.horas_conectado = horas_conectado;
    }

    public int calcularHoras_conectado() {

        this.setHoras_conectado(hora_desconexion - hora_conexion);

        return this.getHoras_conectado();
    }

    // Nota
    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float calcularNota(int horas_conectado) {
        if ((horas_conectado <= 1) || (horas_conectado <= -1)) {
            this.setNota(3);
        } else if (((horas_conectado > 1) && (horas_conectado <= 3))
                || ((horas_conectado > -1) && (horas_conectado <= -3))) {
            this.setNota(5);
        } else if (((horas_conectado > 3) && (horas_conectado <= 5))
                || ((horas_conectado > -3) && (horas_conectado <= -5))) {
            this.setNota(7);
        } else if ((horas_conectado > 5) || (horas_conectado > -5)) {
            this.setNota(10);
        }

        return this.getNota();
    }
    
        public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
    
    public String toString() {
        String cad = null;

        if (Main.config.getDecimales() == "1") {
            cad = format.format1Decimal(getBeca());

        } else if (Main.config.getDecimales() == "2") {
            cad = format.format2Decimal(getBeca());

        } else if (Main.config.getDecimales() == "3") {
            cad = format.format3Decimal(getBeca());

        }
        
        String dades = "Nom=" + getNom() + "\n" + "Cognom=" + getCognom() + "\n" + "Edat= " + getEdat() + "\n"
                + "Especialitat = " + getEspecialitat() + "\n" + "Curs=" + getCurs() + "\n" + "Data naixement = "
                + getDatanaix().aStringFecha() + "\n" + "Direccio=" + getDireccio() + "\n" + "DNI = " + getDNI() + "\n"
                + "Hora de conexion = " + getHora_conexion() + "\n" + "Hora de desconexion = " + getHora_desconexion()
                + "\n" + "User = " + getUser() + "\n" + "Pass = " + getPass() + "\n" + "Nota = " + getNota() + "\n"
                + "Beca= " + cad + Main.config.getMoneda() +  "\n" + "Falta = " + getFaltas() ;

        StringBuffer cadena = new StringBuffer();
        cadena.append(dades);
        return cadena.toString();
    }

}
