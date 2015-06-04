/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.BLL;

import alumnes.Clases.ConexionBD;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.AlumnesOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.DAO.AODAO;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.DAO.AODAOBD;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class AOBLLBD {

    public int nuevoAlumnoBLL(AlumnesOnline _alumno) {
        int resultado = 0;
        Connection _con = null;
        AlumnesOnline _nuevoUsuario = null;
        ConexionBD _conexion_DB = new ConexionBD();
        //Abrir Conexion
        _con = _conexion_DB.AbrirConexion();
        //Operaciones
        AODAOBD _alumnoDAO = new AODAOBD();
        resultado = _alumnoDAO.nuevoAlumnoDAO(_con, _alumno);
        //Cerrar Conexion
        _conexion_DB.CerrarConexion(_con);

        return resultado;
    }

    // * obtener un arraylist con todos los clientes disponibles
    public void listAllAlumnosBLL() {
        Connection _con = null;
        ConexionBD _conexion_DB = new ConexionBD();
        //Abrir Conexion
        _con = _conexion_DB.AbrirConexion();

        //Operaciones
        AODAOBD _alumnoDAO = new AODAOBD();
        try {

            _alumnoDAO.listAllAlumnesDAO(_con);//Recuperamos los usuarios  

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger2!");
        }
        //Cerrar Conexion
        _conexion_DB.CerrarConexion(_con);
    }

    // eliminar un cliente de la BD
    public void borrarAlumnoBLL(AlumnesOnline alumno) {
        Connection _con;
        //AlumneOnline _clienteborrado = null;
        ConexionBD _conexion_DB = new ConexionBD();
        //Abrir Conexion
        _con = _conexion_DB.AbrirConexion();
        //Operaciones
        AODAOBD _alumnoDAO = new AODAOBD();
        //_clienteborrado = 
        _alumnoDAO.borrarAlumnoDAO(_con, alumno);
        //Cerrar Conexion
        _conexion_DB.CerrarConexion(_con);
    }

    //* buscar en la BD un cliente por su DNI
    public AlumnesOnline buscarPorDniBLL(AlumnesOnline alumno) {
        Connection _con = null;
        AlumnesOnline _clienteObtenido = null;
        ConexionBD _conexion_DB = new ConexionBD();
        //Abrir Conexion
        _con = _conexion_DB.AbrirConexion();
        //Operaciones
        AODAOBD _alumnoDAO = new AODAOBD();
        _clienteObtenido = _alumnoDAO.buscarPorDniDAO(_con, alumno);
        //Cerrar Conexion
        _conexion_DB.CerrarConexion(_con);
        return _clienteObtenido;
    }

    public void EdadMediaBLL() {

        Connection _con = null;

        ConexionBD _conexion_DB = new ConexionBD();
        //Abrir Conexion
        _con = _conexion_DB.AbrirConexion();
        //Operaciones
        AODAOBD _alumno = new AODAOBD();
        _alumno.EdadMedia(_con);
        //Cerrar Conexion
        _conexion_DB.CerrarConexion(_con);
    }

     public int cambiarFaltaBLL(String dni, int cantidad) {
        int resultado = 0;
        Connection _con = null;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        AODAOBD _clienteDAO = new AODAOBD();

        resultado = _clienteDAO.modificarFaltaDAO(_con, dni, cantidad);

        _conexion_DB.CerrarConexion(_con);

        return resultado;
    }
    
    
    
}
