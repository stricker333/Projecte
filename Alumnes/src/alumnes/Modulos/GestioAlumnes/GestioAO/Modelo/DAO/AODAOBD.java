/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.DAO;

import alumnes.Clases.Fecha;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.AlumnesOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.vAlumneOnline;
import com.mysql.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class AODAOBD {

    public int nuevoAlumnoDAO(Connection con, AlumnesOnline al) {
        PreparedStatement stmt = null;
        int resultado = 0;
        try {

            stmt = con.prepareStatement("INSERT INTO alumnesql.alumneonline"
                    + "(nom, cognom, DNI, especialitat, direccio, curs,"
                    + "edat, datanaix, beca, user, pass, Email, tipo, estado, avatar,"
                    + "hora_conexion, hora_desconexion, horas_conectado) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, al.getNom());//Nom
            stmt.setString(2, al.getCognom());//Cognom
            stmt.setString(3, al.getDNI());//DNI
            stmt.setString(4, al.getEspecialitat());//especialitat
            stmt.setString(5, al.getDireccio());//direccio
            stmt.setInt(6, al.getCurs());//curs
            stmt.setInt(7, al.getEdat());//edat
            stmt.setString(8, al.getDatanaix().getDate());//datanaix
            stmt.setDouble(9, al.getBeca());//beca
            stmt.setString(10, al.getUser());//user
            stmt.setString(11, al.getPass());//pass
            stmt.setString(12, al.getEmail());//Email
            stmt.setString(13, al.getTipo());//tipo
            stmt.setString(14, al.getEstado());//estado
            stmt.setString(15, al.getAvatar());//avatar
            stmt.setInt(16, al.getHora_conexion());//hora_conexion
            stmt.setInt(17, al.getHora_desconexion());//hora_desconexion
            stmt.setInt(18, al.getHoras_conectado());//horas_conectado 

            resultado = stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return resultado;
    }

    //Listamos todos los alumnos y los metemos en su array
    public void listAllAlumnesDAO(Connection con) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
       vAlumneOnline.ao.clear();
        try {
            stmt = con.prepareStatement("SELECT * FROM alumnesql.alumneonline");
            rs = stmt.executeQuery();
            AlumnesOnline _cliente = null;
            while (rs.next()) {

                _cliente = new AlumnesOnline();
                
                _cliente.setNom(rs.getString("nom"));//Nom
                _cliente.setCognom(rs.getString("cognom"));//Cognom
                _cliente.setDNI(rs.getString("DNI"));//DNI
                _cliente.setEspecialitat(rs.getString("especialitat"));//especialitat
                _cliente.setDireccio(rs.getString("direccio"));//direccio
                _cliente.setCurs(rs.getInt("curs"));//curs
                _cliente.setEdat(rs.getInt("edat"));//edat
                _cliente.setDatanaix(new Fecha(rs.getString("datanaix"), "1"));//datanaix
                _cliente.setBeca(rs.getInt("beca"));//beca
                _cliente.setUser(rs.getString("user"));//user
                _cliente.setPass(rs.getString("pass"));//pass
                _cliente.setEmail(rs.getString("Email"));//Email
                _cliente.setTipo(rs.getString("tipo"));//tipo
                _cliente.setEstado(rs.getString("estado"));//estado
                _cliente.setAvatar(rs.getString("avatar"));//avatar
                _cliente.setHora_conexion(rs.getInt("hora_conexion"));//hora_conexion
                _cliente.setHora_desconexion(rs.getInt("hora_desconexion"));//hora_desconexion
                _cliente.setHoras_conectado(rs.getInt("horas_conectado"));//horas_conectado 
                _cliente.setFaltas(rs.getInt("faltas"));//faltas

                vAlumneOnline.ao.add(_cliente);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los usuarios!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }

    }

    
    //Borramos un cliente
    public AlumnesOnline borrarAlumnoDAO(Connection con, AlumnesOnline cli) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM alumnesql.alumneonline WHERE DNI=?");
          
            stmt.setString(1, cli.getDNI());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger!");
                }
            }
        }
        return cli;
    }

    //Buscamos por dni un cliente
    public AlumnesOnline buscarPorDniDAO(Connection con, AlumnesOnline cli) {
        AlumnesOnline _cliente = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            
            stmt = con.prepareStatement("SELECT * FROM alumnesql.alumneonline WHERE DNI=?");
            stmt.setString(1, cli.getDNI());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                _cliente = new AlumnesOnline(null, null, null, null, null, 0, null, 0, null, null, null, null, null, null, 0, 0, 0);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al buscar el usuario por DNI");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
        }
        return _cliente;
    }

    private void obtenClienteFila(ResultSet rs, AlumnesOnline al) {
        try {

                al.setNom(rs.getString("nom"));//Nom
                al.setCognom(rs.getString("cognom"));//Cognom
                al.setDNI(rs.getString("DNI"));//DNI
                al.setEspecialitat(rs.getString("especialitat"));//especialitat
                al.setDireccio(rs.getString("direccio"));//direccio
                al.setCurs(rs.getInt("curs"));//curs
                al.setEdat(rs.getInt("edat"));//edat
                al.setDatanaix(new Fecha(rs.getString("datanaix"), "1"));//datanaix
                al.setBeca(rs.getInt("beca"));//beca
                al.setUser(rs.getString("user"));//user
                al.setPass(rs.getString("pass"));//pass
                al.setEmail(rs.getString("Email"));//Email
                al.setTipo(rs.getString("tipo"));//tipo
                al.setEstado(rs.getString("estado"));//estado
                al.setAvatar(rs.getString("avatar"));//avatar
                al.setHora_conexion(rs.getInt("hora_conexion"));//hora_conexion
                al.setHora_conexion(rs.getInt("hora_desconexion"));//hora_desconexion
                al.setHoras_conectado(rs.getInt("horas_conectado "));//horas_conectado 
                al.setFaltas(rs.getInt("faltas"));//Faltas

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el Logger");
        }
    }
    
    
    public int modificarFaltaDAO(Connection con, String dni, int cantidad) {
        int resultado = 0;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE alumnesql.alumneonline SET faltas=? "
                    + " WHERE DNI=?");

            stmt.setInt(1, cantidad);
            stmt.setString(2, dni);

            resultado = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return resultado;
    }
    
        public void EdadMedia(Connection con) {

        CallableStatement cstmt = null;
        String cadena = "";
        try {
            cstmt = (CallableStatement) con.prepareCall("{call procedure1(?)}");
            cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);
            cstmt.execute();
            cadena = cadena + "Edad media: " + (int)cstmt.getDouble(1) + " años";
            JOptionPane.showMessageDialog(null, cadena, "Edad media", 1);
        } catch (SQLException ex) {
            //Logger.getLogger(alumnoPresencialDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }

    }
    

}
