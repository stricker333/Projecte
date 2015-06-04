package alumnes.Clases;

import java.util.ArrayList;

import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.DAO.*;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.BLL.AOBLL;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.BLL.AOBLLBD;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.*;

public class Config {

	private char moneda;
	private String decimales;
	private String formFecha = "1";
	private String formato;
        private int tabla;

	public Config() {

		moneda = '€';
		decimales = "2";
		formFecha = "1";
		formato = "2";
                tabla = 0;

		//vAlumnePresencial.ap = new ArrayList<AlumnePresencial>();
		//vAlumneSemiPresencial.as = new ArrayList<AlumneSemiPresencial>();
		vAlumneOnline.ao = new ArrayList<AlumnesOnline>();
                
                //AOBLLBD b = new AOBLLBD();
                //b.listAllClientesBLL();

		//Carga Dades de Fichers
                //AOBLL.AbrirSilencioso();
                //APBLL.AbrirSilencioso();
		//ASBLL.AbrirSilencioso();

                //Carga Dummies si el ArrayList esta buit
                
                //if (vAlumneOnline.ao.size() == 0){
                //AODummies.cargar_Online();
                //APDummies.cargar_AlumnesPresencials();
		//ASDummies.cargar_AlumnesSemiPresencials();
                //}
                
	}

	public char getMoneda() {
		return moneda;
	}

	public String getDecimales() {
		return decimales;
	}

	public String getFormFecha() {
		return formFecha;
	}

	public void setMoneda(char moneda) {
		this.moneda = moneda;
	}

	public void setDecimales(String decimales) {
		this.decimales = decimales;
	}

	public void setFormFecha(String formFecha) {
		this.formFecha = formFecha;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
        
        public int getTabla() {
		return tabla;
	}

	public void setTabla(int tabla) {
		this.tabla = tabla;
	}

	public String toString() {
		return "Moneda: " + moneda + ", Decimales: " + decimales + ", Formato de fecha: " + formFecha
				+ ", Formato de ficheros: " + formato + ", Formato de tablas: " + tabla;
	}

}
