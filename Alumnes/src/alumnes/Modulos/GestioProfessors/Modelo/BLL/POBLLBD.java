/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes.Modulos.GestioProfessors.Modelo.BLL;

import alumnes.Clases.ConexionBD;
import alumnes.Modulos.GestioProfessors.Modelo.Clases.Profesors;
import alumnes.Modulos.GestioProfessors.Modelo.DAO.PODAOBD;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class POBLLBD {

    public boolean loginProfesorBLL(String user, String pass) {

        Connection _con;
        boolean _resul;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        PODAOBD _loginDAO = new PODAOBD();

        _resul = _loginDAO.loginProfesorDAO(_con, user, pass);

        _conexion_DB.CerrarConexion(_con);

        return _resul;

    }

    public boolean recoverProfesorBLL(String user, String token, String pass) {

        Connection _con;
        boolean _resul;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        PODAOBD _loginDAO = new PODAOBD();

        _resul = _loginDAO.recoverProfesorDAO(_con, user, token, pass);

        if (_resul == true) {
            _loginDAO.modificarPassDAO(_con, user, pass);
        }

        _conexion_DB.CerrarConexion(_con);

        return _resul;

    }

    public int nuevoProfesorBLL(Profesors _prof) {
        int resultado = 0;
        Connection _con = null;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        PODAOBD _profDAO = new PODAOBD();

        resultado = _profDAO.nuevoProfesorDAO(_con, _prof);

        _conexion_DB.CerrarConexion(_con);
        return resultado;
    }

    //* buscar en la BD un cliente por su User
    public Profesors buscarPorUserBLL(String user) {
        Connection _con = null;

        Profesors _clienteObtenido = null;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        PODAOBD _clienteDAO = new PODAOBD();

        _clienteObtenido = _clienteDAO.buscarPorUserDAO(_con, user);

        _conexion_DB.CerrarConexion(_con);

        return _clienteObtenido;
    }

    public int cambiarAvatarBLL(String user, String ruta) {
        int resultado = 0;
        Connection _con = null;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        PODAOBD _clienteDAO = new PODAOBD();

        resultado = _clienteDAO.modificarAvatarDAO(_con, user, ruta);

        _conexion_DB.CerrarConexion(_con);

        return resultado;
    }

    public int cambiarTipoBLL(String user, String tipo) {
        int resultado = 0;
        Connection _con = null;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        PODAOBD _clienteDAO = new PODAOBD();

        resultado = _clienteDAO.modificarTipoDAO(_con, user, tipo);

        _conexion_DB.CerrarConexion(_con);

        return resultado;
    }

}
