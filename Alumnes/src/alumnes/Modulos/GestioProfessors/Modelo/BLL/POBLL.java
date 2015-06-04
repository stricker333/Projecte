package alumnes.Modulos.GestioProfessors.Modelo.BLL;

import alumnes.Libreria.Encriptar;
import alumnes.Clases.javaMail;
import alumnes.Modulos.GestioProfessors.Modelo.Clases.Profesors;
import alumnes.Modulos.Login.Vista.VentanaRegistro;
import alumnes.Libreria.Validate;
import alumnes.Modulos.Login.Vista.VentanaRecordar;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

public class POBLL {

    public static void comprobarDatos(Object tipo, Object dato) {
        boolean correcte = false;
        JTextField text = null;
        Object next = null;
        JLabel icon = null;

        //NewUser
        if (tipo == VentanaRegistro.NewUser) {
            correcte = Validate.regexUsuari(VentanaRegistro.NewUser.getText());
            text = VentanaRegistro.NewUser;
            icon = VentanaRegistro.InvalidUserLabel;

            //NewPass1
        } else if (tipo == VentanaRegistro.NewPass1) {
            correcte = Validate.regexPass(VentanaRegistro.NewPass1.getText());
            text = VentanaRegistro.NewPass1;
            icon = VentanaRegistro.InvalidPass1Label;

            if (VentanaRegistro.NewPass1.getText().equals(VentanaRegistro.NewPass2.getText())
                    && VentanaRegistro.NewPass1.getText() == ""
                    && VentanaRegistro.NewPass2.getText() == "") {

                VentanaRegistro.iguales.setVisible(true);
            } else {
                VentanaRegistro.iguales.setVisible(false);
            }

            //NewPass2
        } else if (tipo == VentanaRegistro.NewPass2) {
            correcte = Validate.regexPass(VentanaRegistro.NewPass2.getText());
            text = VentanaRegistro.NewPass2;
            icon = VentanaRegistro.InvalidPass2Label;

            if (VentanaRegistro.NewPass2.getText().equals(VentanaRegistro.NewPass1.getText())
                    && VentanaRegistro.NewPass1.getText() != ""
                    && VentanaRegistro.NewPass2.getText() != "") {

                VentanaRegistro.iguales.setVisible(true);
            } else {
                VentanaRegistro.iguales.setVisible(false);
            }

            //NewEmail
        } else if (tipo == VentanaRegistro.NewEmail) {
            correcte = Validate.regexEmail(VentanaRegistro.NewEmail.getText());
            text = VentanaRegistro.NewEmail;
            icon = VentanaRegistro.InvalidMailLabel;

        }

        if (text.getText().length() == 0 || correcte == false) {
            text.setForeground(Color.RED);

            String ruta = "src/alumnes/Img/no.png";
            ImageIcon icono = new ImageIcon(ruta);
            Image img = icono.getImage();
            Image newimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            icon.setIcon(newIcon);

        } else {
            text.setForeground(Color.GREEN);

            String ruta = "src/alumnes/Img/ok.png";
            ImageIcon icono = new ImageIcon(ruta);
            Image img = icono.getImage();
            Image newimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            icon.setIcon(newIcon);

        }

    }

    public static boolean resultadoComprobar() {
        boolean comp1, comp2, comp3, comp4, resultado;

        comp1 = Validate.regexUsuari(VentanaRegistro.NewUser.getText());
        comp2 = Validate.regexPass(VentanaRegistro.NewPass1.getText());
        comp3 = Validate.regexPass(VentanaRegistro.NewPass2.getText());
        comp4 = Validate.regexEmail(VentanaRegistro.NewEmail.getText());

        if (comp1 == true && comp2 == true && comp3 == true && comp4 == true) {
            resultado = true;
        } else {
            resultado = false;
        }

        return resultado;
    }

    public static boolean resultadoComprobarPass() {
        boolean comp1, resultado;

        comp1 = Validate.regexPass(VentanaRecordar.newPass.getText());

        if (comp1 == true) {
            resultado = true;
        } else {
            resultado = false;
        }

        return resultado;
    }

    
    
    
    public static void RegistrarProfesor() {

        Profesors _pro = new Profesors();

        String user = VentanaRegistro.NewUser.getText();
        String pass = VentanaRegistro.NewPass1.getText();
        String email = VentanaRegistro.NewEmail.getText();

        String token = Encriptar.getCadenaAleatoria(64);

        _pro.setUser(user);
        _pro.setPass(pass);
        _pro.setEmail(email);
        _pro.setTipo("Actiu");
        _pro.setEstado("Off");
        _pro.setAvatar("src/alumnes/Img/avatar.png");
        _pro.setToken(token);

        POBLLBD b = new POBLLBD();

        int resultado = b.nuevoProfesorBLL(_pro);

        if (resultado == 0) {
            JOptionPane.showMessageDialog(null, "Ese nombre de usuario ya existe");

        } else {
            JOptionPane.showMessageDialog(null, "Usuario registrado");

            JOptionPane.showMessageDialog(null, "1erdaw2015@gmail.com" + " " + "villadaw" + " " + email + " " + "GDAO2015 (Gestión de Alumnos) "
                    + " " + "Gracias por registrarte el " + " " + user + " " + pass + " " + token);

           

            javaMail mail = new javaMail("1erdaw2015@gmail.com", "villadaw", email, "GDAO2015 (Gestión de Alumnos) ",
                    "Gracias por registrarte el ", user, pass, token);

            //enviamos el mensaje
            String error = mail.send();
            if (error.equals("")) {
                JOptionPane.showMessageDialog(null, "Envio Correcto", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error de envio:\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

}
