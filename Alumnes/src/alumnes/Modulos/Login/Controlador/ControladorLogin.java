/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes.Modulos.Login.Controlador;

import alumnes.Libreria.Upload;
import alumnes.Modulos.Inicio.Controlador.ControladorVent1;
import alumnes.Modulos.Inicio.Vista.Vent1;
import alumnes.Modulos.GestioProfessors.Modelo.Clases.Profesors;
import alumnes.Modulos.GestioProfessors.Controlador.Controlador_Professor;
import alumnes.Modulos.GestioProfessors.Modelo.BLL.POBLL;
import alumnes.Modulos.GestioProfessors.Modelo.BLL.POBLLBD;
import alumnes.Modulos.GestioProfessors.Modelo.Clases.vProfesorOnline;
import alumnes.Modulos.GestioProfessors.Vista.MyPerfil;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Stricker333
 */
import alumnes.Modulos.Login.Vista.VentanaLogin;
import alumnes.Modulos.Login.Vista.VentanaRecordar;
import alumnes.Modulos.Login.Vista.VentanaRegistro;
import java.awt.Color;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class ControladorLogin implements ActionListener, KeyListener, MouseListener {

    public static VentanaLogin login = new VentanaLogin();
    public static VentanaRegistro registro = new VentanaRegistro();
    public static VentanaRecordar recordar = new VentanaRecordar();
    public static String conectado = "no";

    /*
     public ControladorLogin(JFrame Login) {
     this.login = (VentanaLogin) Login;
     }
     */
    public enum Accion {

        //Acciones de la VentanaLogin
        _USER,
        _PASS,
        _LOGEARSE,
        _REGISTRARSE,
        _RECORDAR,
        //Acciones de la VentanaRegistro
        _NEWUSER,
        _NEWPASS1,
        _NEWPASS2,
        _NEWEMAIL,
        _NEWREGISTRAR,
        //Acciones de la VentanaRecordar
        _ANTUSER,
        _ANTPASS,
        _ANTRECUPERAR

    }

    public ControladorLogin(JFrame logeo, int i) {
        if (i == 0) {
            this.login = (VentanaLogin) logeo;
        }

        if (i == 1) {
            this.registro = (VentanaRegistro) logeo;
        }

        if (i == 2) {
            this.recordar = (VentanaRecordar) logeo;
        }

    }

    public void iniciar(int i) {

        //VentanaLogin
        if (i == 0) {
            this.login.setLocationRelativeTo(null);
            this.login.setTitle("Login Inicio");
            this.login.setVisible(true);
            this.login.setSize(800, 540);
            this.login.setResizable(false);

            this.login.error.setVisible(false);

            this.login.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.login.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            this.login.registro.setName("_REGISTRARSE");
            this.login.registro.addMouseListener(this);

            this.login.user.setName("_USER");
            this.login.user.addMouseListener(this);
            this.login.user.addKeyListener(this);

            this.login.pass.setName("_PASS");
            this.login.pass.addKeyListener(this);
            this.login.pass.addMouseListener(this);

            this.login.logearse.setActionCommand("_LOGEARSE");
            this.login.logearse.setName("_LOGEARSE");
            this.login.logearse.addMouseListener(this);
            this.login.logearse.addActionListener(this);

            this.login.recordar.setActionCommand("_RECORDAR");
            this.login.recordar.setName("_RECORDAR");
            this.login.recordar.addActionListener(this);

        }

        //VentanaRegistro
        if (i == 1) {

            this.registro.iguales.setVisible(false);

            this.registro.setLocationRelativeTo(null);
            this.registro.setTitle("Registrar Profesor");
            this.registro.setVisible(true);
            this.registro.setResizable(false);

            this.registro.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

            this.registro.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    login.enable();
                    registro.dispose();
                }
            });

            this.registro.NewUser.setName("_NEWUSER");
            this.registro.NewUser.setActionCommand("_NEWUSER");
            this.registro.NewUser.addMouseListener(this);
            this.registro.NewUser.addKeyListener(this);
            this.registro.NewUser.addActionListener(this);

            this.registro.NewPass1.setName("_NEWPASS1");
            this.registro.NewPass1.setActionCommand("_NEWPASS1");
            this.registro.NewPass1.addMouseListener(this);
            this.registro.NewPass1.addKeyListener(this);
            this.registro.NewPass1.addActionListener(this);

            this.registro.NewPass2.setName("_NEWPASS2");
            this.registro.NewPass2.setActionCommand("_NEWPASS2");
            this.registro.NewPass2.addMouseListener(this);
            this.registro.NewPass2.addKeyListener(this);
            this.registro.NewPass2.addActionListener(this);

            this.registro.NewEmail.setName("_NEWEMAIL");
            this.registro.NewEmail.setActionCommand("_NEWEMAIL");
            this.registro.NewEmail.addMouseListener(this);
            this.registro.NewEmail.addKeyListener(this);
            this.registro.NewEmail.addActionListener(this);

            this.registro.NewRegistrar.setName("_NEWREGISTRAR");
            this.registro.NewRegistrar.setActionCommand("_NEWREGISTRAR");
            this.registro.NewRegistrar.addActionListener(this);

        }

        //VentanaRecordar
        if (i == 2) {

            this.recordar.setLocationRelativeTo(null);
            this.recordar.setTitle("Recordar Password");
            this.recordar.setVisible(true);
            this.recordar.setResizable(false);

            this.recordar.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.recordar.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    login.enable();
                    recordar.dispose();
                }
            });

            this.recordar.user.setName("_ANTUSER");
            this.recordar.user.setActionCommand("_ANTUSER");
            this.recordar.user.addMouseListener(this);
            this.recordar.user.addKeyListener(this);
            this.recordar.user.addActionListener(this);

            this.recordar.token.setName("_ANTPASS");
            this.recordar.token.setActionCommand("_ANTPASS");
            this.recordar.token.addMouseListener(this);
            this.recordar.token.addKeyListener(this);
            this.recordar.token.addActionListener(this);

            this.recordar.Recuperar.setName("_ANTRECUPERAR");
            this.recordar.Recuperar.setActionCommand("_ANTRECUPERAR");
            this.recordar.Recuperar.addActionListener(this);

        }

    }

    @Override
    public void actionPerformed(ActionEvent ae
    ) {

        switch (Accion.valueOf(ae.getActionCommand())) {

            //Ventana Login
            case _LOGEARSE:

                String user = this.login.user.getText();
                String pass = this.login.pass.getText();
                boolean login;

                POBLLBD _login = new POBLLBD();
                login = _login.loginProfesorBLL(user, pass);

                vProfesorOnline.ap1 = _login.buscarPorUserBLL(user);

                if (login == true) {

                    if (vProfesorOnline.ap1.getTipo().equals("Actiu")) {

                        this.login.dispose();
                        new ControladorVent1(new Vent1()).iniciar();

                    } else if (vProfesorOnline.ap1.getTipo().equals("Inactiu")) {

                        this.login.dispose();
                        new Controlador_Professor(new MyPerfil()).iniciar();

                    } else if (vProfesorOnline.ap1.getTipo().equals("Admin")) {

                        this.login.dispose();
                        new ControladorVent1(new Vent1()).iniciar();

                    }

                } else {

                    this.login.error.setVisible(true);
                    this.login.error.setText("Datos Incorrectos");
                    this.login.error.setForeground(Color.red);
                    this.login.pass.setText("");
                    this.login.user.setText("");
                    this.login.user.requestFocus();
                    return;

                }
                break;

            case _RECORDAR:
                this.login.disable();
                new ControladorLogin(new VentanaRecordar(), 2).iniciar(2);
                break;

            // Ventana Registro
            case _NEWUSER:
                POBLL.comprobarDatos(this.registro.NewUser, this.registro.NewUser.getText());
                break;
            case _NEWPASS1:
                POBLL.comprobarDatos(this.registro.NewPass1, this.registro.NewPass1.getText());
                break;
            case _NEWPASS2:
                POBLL.comprobarDatos(this.registro.NewPass2, this.registro.NewPass2.getText());
                break;
            case _NEWEMAIL:
                POBLL.comprobarDatos(this.registro.NewEmail, this.registro.NewEmail.getText());
                break;

            case _NEWREGISTRAR:

                if (this.registro.NewUser.getText().length() == 0 || this.registro.NewPass1.getText().length() == 0
                        || this.registro.NewPass2.getText().length() == 0 || this.registro.NewEmail.getText().length() == 0) {

                    JOptionPane.showMessageDialog(null, "Porfavor rellena todos los campos");
                } else if (POBLL.resultadoComprobar() == false) {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos");
                } else {
                    POBLL.RegistrarProfesor();
                    this.login.enable();
                    this.registro.dispose();
                }
                break;

            // Ventana Recuperar
            case _ANTRECUPERAR:

                boolean recordar;

                if (this.recordar.user.getText().length() == 0 || this.recordar.newPass.getText().length() == 0
                        || this.recordar.token.getText().length() == 0) {

                    JOptionPane.showMessageDialog(null, "Porfavor rellena todos los campos");
                } else if (POBLL.resultadoComprobarPass() == false) {
                    JOptionPane.showMessageDialog(null, "La contraseña debe tener minimo 8 caracteres(1 Mayus y 1 Num)");
                } else {

                    POBLLBD _recordar = new POBLLBD();
                    recordar = _recordar.recoverProfesorBLL(this.recordar.user.getText(), this.recordar.token.getText(), this.recordar.newPass.getText());

                    if (recordar == true) {

                        this.login.enable();
                        this.recordar.dispose();
                    }

                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke
    ) {

        switch (Accion.valueOf(ke.getComponent().getName())) {

            case _NEWUSER:
                POBLL.comprobarDatos(this.registro.NewUser, this.registro.NewUser.getText());
                break;
            case _NEWPASS1:
                POBLL.comprobarDatos(this.registro.NewPass1, this.registro.NewPass1.getText());
                break;

            case _NEWPASS2:
                POBLL.comprobarDatos(this.registro.NewPass2, this.registro.NewPass2.getText());
                break;
            case _NEWEMAIL:
                POBLL.comprobarDatos(this.registro.NewEmail, this.registro.NewEmail.getText());
                break;

        }

    }

    @Override
    public void keyTyped(KeyEvent e
    ) {

    }

    @Override
    public void keyPressed(KeyEvent e
    ) {
    }

    @Override
    public void mouseClicked(MouseEvent es
    ) {
        switch (Accion.valueOf(es.getComponent().getName())) {

            case _REGISTRARSE:

                this.login.disable();
                new ControladorLogin(new VentanaRegistro(), 1).iniciar(1);
                break;

        }
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent exe
    ) {
        switch (Accion.valueOf(exe.getComponent().getName())) {

            case _REGISTRARSE:
                this.login.registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/play2.png")));
                break;

        }
    }

    @Override
    public void mouseExited(MouseEvent ece
    ) {
        switch (Accion.valueOf(ece.getComponent().getName())) {

            case _REGISTRARSE:
                this.login.registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/play1.png")));
                break;
        }
    }

}
