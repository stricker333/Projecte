/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes.Modulos.GestioProfessors.Controlador;

import alumnes.Modulos.GestioProfessors.Modelo.BLL.POBLLBD;
import alumnes.Modulos.GestioProfessors.Modelo.Clases.vProfesorOnline;
import alumnes.Modulos.GestioProfessors.Vista.MyPerfil;
import alumnes.Modulos.Inicio.Controlador.ControladorVent1;
import alumnes.Modulos.Inicio.Vista.Vent1;
import alumnes.Modulos.Login.Controlador.ControladorLogin;
import alumnes.Modulos.Login.Vista.VentanaLogin;
import alumnes.Modulos.Login.Vista.VentanaRecordar;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author stricker333
 */
public class Controlador_Professor implements ActionListener, KeyListener, MouseListener {

    public static MyPerfil ventPerfil = new MyPerfil();

    public Controlador_Professor(JFrame perfil) {
        this.ventPerfil = (MyPerfil) perfil;
    }

    public enum Accion {

        _TIPO,
        _SALIR,
        _APLICAR
    }

    public void iniciar() {

        //((BasicInternalFrameUI)this.frmLogin.getUI()).setNorthPane(null);
        this.ventPerfil.setLocationRelativeTo(null);
        this.ventPerfil.setTitle("Perfil");
        this.ventPerfil.setVisible(true);
        this.ventPerfil.setResizable(false);
        this.ventPerfil.setSize(450, 400);

        Image image = Toolkit.getDefaultToolkit().getImage("src/alumnes/Img/fondoPerso1.jpg");
        this.ventPerfil.setIconImage(image);
        /////////////////////////////////////////////////////////////////////////////////////////////

        if (vProfesorOnline.ap1.getTipo().equals("Actiu")) {
            this.ventPerfil.Tipo.addItem("Actiu");
            this.ventPerfil.Tipo.addItem("Inactiu");

            this.ventPerfil.lbUser.setText(vProfesorOnline.ap1.getUser());
            this.ventPerfil.lbUser.setForeground(Color.green);

            this.ventPerfil.lbEmail.setText(vProfesorOnline.ap1.getEmail());
            this.ventPerfil.lbEmail.setForeground(Color.green);
        } else {
            this.ventPerfil.Tipo.addItem("Inactiu");
            this.ventPerfil.Tipo.addItem("Actiu");

            this.ventPerfil.lbUser.setText(vProfesorOnline.ap1.getUser());
            this.ventPerfil.lbUser.setForeground(Color.red);

            this.ventPerfil.lbEmail.setText(vProfesorOnline.ap1.getEmail());
            this.ventPerfil.lbEmail.setForeground(Color.red);
        }

        this.ventPerfil.btnSalir.setActionCommand("_SALIR");
        this.ventPerfil.btnSalir.setName("_SALIR");
        this.ventPerfil.btnSalir.addActionListener(this);

        this.ventPerfil.btnAplicar.setActionCommand("_APLICAR");
        this.ventPerfil.btnAplicar.setName("_APLICAR");
        this.ventPerfil.btnAplicar.addActionListener(this);

        this.ventPerfil.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent el) {

        switch (Controlador_Professor.Accion.valueOf(el.getActionCommand())) {

            case _SALIR:

                if (vProfesorOnline.ap1.getTipo().equals("Inactiu")) {
                    vProfesorOnline.ap1.setUser(null);
                    vProfesorOnline.ap1.setPass(null);
                    vProfesorOnline.ap1.setEmail(null);
                    vProfesorOnline.ap1.setTipo(null);
                    vProfesorOnline.ap1.setEstado(null);
                    vProfesorOnline.ap1.setAvatar(null);

                    this.ventPerfil.dispose();
                    new ControladorLogin(new VentanaLogin(), 0).iniciar(0);
                } else if (vProfesorOnline.ap1.getTipo().equals("Actiu")) {
                    this.ventPerfil.dispose();
                    new ControladorVent1(new Vent1()).iniciar();
                }
                break;

            case _APLICAR:

                String tipo;
                int resultado;

                tipo = this.ventPerfil.Tipo.getSelectedItem().toString();

                if (vProfesorOnline.ap1.getTipo().equals("Inactiu")) {
                    if (tipo.equals("Actiu")) {

                        POBLLBD n = new POBLLBD();
                        resultado = n.cambiarTipoBLL(vProfesorOnline.ap1.getUser(), tipo);

                        if (resultado != -1) {
                            this.ventPerfil.dispose();
                            new ControladorLogin(new VentanaLogin(), 0).iniciar(0);
                        }
                    }
                } else if (vProfesorOnline.ap1.getTipo().equals("Actiu")) {
                    if (tipo.equals("Inactiu")) {

                        POBLLBD n = new POBLLBD();
                        resultado = n.cambiarTipoBLL(vProfesorOnline.ap1.getUser(), tipo);

                        if (resultado != -1) {
                            this.ventPerfil.dispose();
                            new ControladorLogin(new VentanaLogin(), 0).iniciar(0);
                        }
                    } else {
                        this.ventPerfil.dispose();
                        new ControladorLogin(new VentanaRecordar(), 1).iniciar(1);
                    }
                }

                break;

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
