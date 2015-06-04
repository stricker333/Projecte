package alumnes.Modulos.GestioAlumnes.Clase;

import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import alumnes.Clases.Fecha;

@XStreamAlias("Alumnes")
public abstract class Alumnes implements Comparable<Alumnes>, Serializable {

    @XStreamAlias("nom")
    private String nom;
    @XStreamAlias("cognom")
    private String cognom;
    @XStreamAlias("DNI")
    private String DNI;
    @XStreamAlias("especialitat")
    private String especialitat;
    @XStreamAlias("direccio")
    private String direccio;
    @XStreamAlias("curs")
    private int curs;
    @XStreamAlias("edat")
    private int edat;
    @XStreamAlias("datanaix")
    private Fecha datanaix;
    @XStreamAlias("beca")
    private double beca;

    @XStreamAlias("user")
    private String user;
    @XStreamAlias("pass")
    private String pass;
    @XStreamAlias("Email")
    private String Email;
    @XStreamAlias("tipo")
    private String tipo;
    @XStreamAlias("estado")
    private String estado;
    @XStreamAlias("avatar")
    private String avatar;

    public Alumnes(String nom, String cognom, String DNI, String especialitat, String direccio, int curs,
            Fecha datanaix, double beca, String user, String pass, String Email, String tipo,
            String estado, String avatar) {

        this.nom = nom;
        this.cognom = cognom;
        this.DNI = DNI;
        this.especialitat = especialitat;
        this.direccio = direccio;
        this.curs = curs;
        this.setEdat(this.calculaEdat(datanaix));
        this.datanaix = datanaix;
        this.beca = beca;

        this.user = user;
        this.pass = pass;
        this.Email = Email;
        this.tipo = tipo;
        this.estado = estado;
        this.avatar = avatar;

    }

    public Alumnes() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public double getBeca() {
        return beca;
    }

    public void setBeca(double beca) {
        this.beca = beca;
    }

    public Alumnes(String DNI) {
        this.DNI = DNI;
    }

    public String getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(String especialitat) {
        this.especialitat = especialitat;
    }

    public int getCurs() {
        return curs;
    }

    public void setCurs(int curs) {
        this.curs = curs;
    }

    public Fecha getDatanaix() {
        return datanaix;
    }

    public void setDatanaix(Fecha datanaix) {
        this.datanaix = datanaix;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int calculaEdat(Fecha datanaix) {
        this.setEdat(datanaix.restaFechas());
        return this.getEdat();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String Estado) {
        this.estado = Estado;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String Avatar) {
        this.avatar = Avatar;
    }

    public int compareTo(Alumnes a) {//per ordenar els alumnes
        if (this.getDNI().compareTo(a.getDNI()) > 0) {
            return 1;
        }
        if (this.getDNI().compareTo(a.getDNI()) < 0) {
            return -1;
        }
        return 0;
    }

    public boolean equals(Object c) {
        return getDNI().equals(((Alumnes) c).getDNI());
    }

    public abstract String toString();
}
