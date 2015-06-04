/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes.Modulos.GestioProfessors.Modelo.DAO;

import alumnes.Libreria.Encriptar;
import alumnes.Modulos.GestioProfessors.Modelo.Clases.Profesors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PODAOBD {

    public boolean loginProfesorDAO(Connection con, String user, String pass) {

        String encriptado;
        boolean resultado = false;
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String passPhrase = "Xenobosfeelthesame";

        encriptado = Encriptar.encriptarTokenMD5(pass);

        try {
            stmt = con.prepareStatement("SELECT * FROM alumnesql.profesoronline WHERE user=? AND pass=?");

            stmt.setString(1, user);
            stmt.setString(2, encriptado);
            rs = stmt.executeQuery();

            while (rs.next()) {

                user = rs.getString("user");
                pass = rs.getString("pass");

                resultado = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger");
                }
            }
        }
        return resultado;
    }

    public boolean recoverProfesorDAO(Connection con, String user, String token, String pass) {

        boolean resultado = false;
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM alumnesql.profesoronline WHERE user=? AND token=?");

            stmt.setString(1, user);
            stmt.setString(2, token);
            rs = stmt.executeQuery();

            while (rs.next()) {

                user = rs.getString("user");
                token = rs.getString("token");

                resultado = true;

            }

            JOptionPane.showMessageDialog(null, user + " " + token);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error recover1");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error recover2");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error recover3");
                }
            }
        }
        return resultado;
    }

    public int nuevoProfesorDAO(Connection con, Profesors pro) {
        String encriptado;
        PreparedStatement stmt = null;
        int resultado = 0;

        String passPhrase = "Xenobosfeelthesame";

        encriptado = Encriptar.encriptarTokenMD5(pro.getPass());

        try {
            stmt = con.prepareStatement("INSERT INTO alumnesql.profesoronline"
                    + "(user, pass, Email, tipo, estado, avatar, token) "
                    + "VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, pro.getUser());
            stmt.setString(2, encriptado);
            stmt.setString(3, pro.getEmail());
            stmt.setString(4, pro.getTipo());
            stmt.setString(5, pro.getEstado());
            stmt.setString(6, pro.getAvatar());
            stmt.setString(7, pro.getToken());

            resultado = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "El usuario ha sido dado de alta correctamente!");
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

    public Profesors buscarPorUserDAO(Connection con, String user) {
        Profesors _prof = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM alumnesql.profesoronline WHERE user=?");
            stmt.setString(1, user);
            rs = stmt.executeQuery();
            while (rs.next()) {
                _prof = new Profesors(null, null, null, null, null, null, null);
                obtenClienteFila(rs, _prof);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al buscar el usuario por User");
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
        return _prof;
    }

    private void obtenClienteFila(ResultSet rs, Profesors cli) {
        try {

            cli.setUser(rs.getString("user"));
            cli.setPass(rs.getString("pass"));
            cli.setEmail(rs.getString("Email"));
            cli.setTipo(rs.getString("tipo"));
            cli.setEstado(rs.getString("estado"));
            cli.setAvatar(rs.getString("avatar"));
            cli.setToken(rs.getString("token"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el Logger");
        }
    }

    public int modificarAvatarDAO(Connection con, String user, String ruta) {
        int resultado = 0;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE alumnesql.profesoronline SET avatar=? "
                    + " WHERE user=?");

            stmt.setString(1, ruta);

            stmt.setString(2, user);

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

      public int modificarTipoDAO(Connection con, String user, String tipo) {
        int resultado = 0;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE alumnesql.profesoronline SET tipo=? "
                    + " WHERE user=?");

            stmt.setString(1, tipo);

            stmt.setString(2, user);

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
    
    public int modificarPassDAO(Connection con, String user, String pass) {
        int resultado = 0;
        PreparedStatement stmt = null;
        String encriptado;

        String passPhrase = "Xenobosfeelthesame";

        encriptado = Encriptar.encriptarTokenMD5(pass);

        try {
            stmt = con.prepareStatement("UPDATE alumnesql.profesoronline SET pass=? "
                    + " WHERE user=?");

            stmt.setString(1, encriptado);

            stmt.setString(2, user);

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

}
