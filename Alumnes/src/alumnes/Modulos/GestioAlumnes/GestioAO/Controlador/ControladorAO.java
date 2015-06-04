/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes.Modulos.GestioAlumnes.GestioAO.Controlador;

import alumnes.Clases.Fecha;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.BLL.AOBLL;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.BLL.AOBLLBD;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.AlumnesOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.OnlineSimpleTableModel;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.vAlumneOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Vista.AfegirAlumneOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Vista.ModificarAlumneOnline;
import alumnes.Modulos.Inicio.Controlador.ControladorVent1;
import alumnes.Modulos.Inicio.Vista.Vent1;
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
import javax.swing.JTable;

/**
 *
 * @author Stricker333
 */
public class ControladorAO implements ActionListener, KeyListener, MouseListener {

    public static ModificarAlumneOnline Modificar = new ModificarAlumneOnline();
    public static AfegirAlumneOnline Alta = new AfegirAlumneOnline();

    AlumnesOnline p = null;
    int ventActiva = 0, selec = 0;
    JTable tablaOnline = null;

    public enum Accion {

        //Acciones de la Ventana Afegir
        _NOM,
        _COGNOM,
        _DNI,
        _ESPECIALITAT,
        _DIRECCIO,
        _CURS,
        _FECHANAC,
        _CONEXIO,
        _DESCONEXIO,
        _USER,
        _PASS,
        _BECA,
        _BTNGUARDAR,
        _BTNTORNAR,
        _LNOM,
        _LCOGNOM,
        _LDNI,
        _LESPECIALITAT,
        _LDIRECCIO,
        _LCURS,
        _LFECHANAC,
        _LCONEXIO,
        _LDESCONEXIO,
        _LUSER,
        _LPASS,
        _LBECA,
        //Acciones de la Ventana Modificar

    }

    public ControladorAO(JFrame logeo, int i) {
        if (i == 0) {
            this.Alta = (AfegirAlumneOnline) logeo;
        }

        if (i == 1) {
            this.Modificar = (ModificarAlumneOnline) logeo;
        }

    }

    public void iniciar(int selec, JTable tablaOnline, int i) {

        ventActiva = i;

        if (i == 0) {
            this.tablaOnline = tablaOnline;

            this.Alta.setLocationRelativeTo(null);
            this.Alta.setTitle("Afegir");
            this.Alta.setVisible(true);
            this.Alta.setSize(700, 450);
            this.Alta.setResizable(false);

            //Deshabilita els iconos
            AOBLL.IconsDisabled(0);

            this.Alta.guardar.setActionCommand("_BTNGUARDAR");
            this.Alta.guardar.setName("_BTNGUARDAR");
            this.Alta.guardar.addActionListener(this);

            this.Alta.tornar.setActionCommand("_BTNTORNAR");
            this.Alta.tornar.setName("_BTNTORNAR");
            this.Alta.tornar.addActionListener(this);

            this.Alta.nom.setActionCommand("_NOM");
            this.Alta.nom.setName("_NOM");
            this.Alta.nom.addActionListener(this);
            this.Alta.nom.addKeyListener(this);
            this.Alta.nom.addMouseListener(this);

            this.Alta.cognom.setActionCommand("_COGNOM");
            this.Alta.cognom.setName("_COGNOM");
            this.Alta.cognom.addActionListener(this);
            this.Alta.cognom.addKeyListener(this);
            this.Alta.cognom.addMouseListener(this);

            this.Alta.DNI.setActionCommand("_DNI");
            this.Alta.DNI.setName("_DNI");
            this.Alta.DNI.addActionListener(this);
            this.Alta.DNI.addKeyListener(this);
            this.Alta.DNI.addMouseListener(this);

            this.Alta.especialitat.setActionCommand("_ESPECIALITAT");
            this.Alta.especialitat.setName("_ESPECIALITAT");
            this.Alta.especialitat.addActionListener(this);
            this.Alta.especialitat.addKeyListener(this);
            this.Alta.especialitat.addMouseListener(this);

            this.Alta.direccio.setActionCommand("_DIRECCIO");
            this.Alta.direccio.setName("_DIRECCIO");
            this.Alta.direccio.addActionListener(this);
            this.Alta.direccio.addKeyListener(this);
            this.Alta.direccio.addMouseListener(this);

            this.Alta.curs.setActionCommand("_CURS");
            this.Alta.curs.setName("_CURS");
            this.Alta.curs.addActionListener(this);
            this.Alta.curs.addKeyListener(this);
            this.Alta.curs.addMouseListener(this);

            this.Alta.naixement.setName("_FECHANAC");
            this.Alta.naixement.addKeyListener(this);
            this.Alta.naixement.addMouseListener(this);

            this.Alta.conexio.setActionCommand("_CONEXIO");
            this.Alta.conexio.setName("_CONEXIO");
            this.Alta.conexio.addActionListener(this);
            this.Alta.conexio.addKeyListener(this);
            this.Alta.conexio.addMouseListener(this);

            this.Alta.desconexio.setActionCommand("_DESCONEXIO");
            this.Alta.desconexio.setName("_DESCONEXIO");
            this.Alta.desconexio.addActionListener(this);
            this.Alta.desconexio.addKeyListener(this);
            this.Alta.desconexio.addMouseListener(this);

            this.Alta.user.setActionCommand("_USER");
            this.Alta.user.setName("_USER");
            this.Alta.user.addActionListener(this);
            this.Alta.user.addKeyListener(this);
            this.Alta.user.addMouseListener(this);

            this.Alta.pass.setActionCommand("_PASS");
            this.Alta.pass.setName("_PASS");
            this.Alta.pass.addActionListener(this);
            this.Alta.pass.addKeyListener(this);
            this.Alta.pass.addMouseListener(this);

            this.Alta.beca.setActionCommand("_BECA");
            this.Alta.beca.setName("_BECA");
            this.Alta.beca.addActionListener(this);
            this.Alta.beca.addKeyListener(this);
            this.Alta.beca.addMouseListener(this);

            this.Alta.jLabel1.setName("_LNOM");
            this.Alta.jLabel1.addMouseListener(this);

            this.Alta.jLabel2.setName("_LCOGNOM");
            this.Alta.jLabel2.addMouseListener(this);

            this.Alta.jLabel3.setName("_LDNI");
            this.Alta.jLabel3.addMouseListener(this);

            this.Alta.jLabel4.setName("_LESPECIALITAT");
            this.Alta.jLabel4.addMouseListener(this);

            this.Alta.jLabel5.setName("_LDIRECCIO");
            this.Alta.jLabel5.addMouseListener(this);

            this.Alta.jLabel6.setName("_LCURS");
            this.Alta.jLabel6.addMouseListener(this);

            this.Alta.jLabel7.setName("_LFECHANAC");
            this.Alta.jLabel7.addMouseListener(this);

            this.Alta.jLabel8.setName("_LCONEXIO");
            this.Alta.jLabel8.addMouseListener(this);

            this.Alta.jLabel9.setName("_LDESCONEXIO");
            this.Alta.jLabel9.addMouseListener(this);

            this.Alta.jLabel10.setName("_LUSER");
            this.Alta.jLabel10.addMouseListener(this);

            this.Alta.jLabel11.setName("_LPASS");
            this.Alta.jLabel11.addMouseListener(this);

            this.Alta.jLabel12.setName("_LBECA");
            this.Alta.jLabel12.addMouseListener(this);

            this.Alta.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        }

        if (i == 1) {

            this.selec = selec;
            this.tablaOnline = tablaOnline;

            this.Modificar.setLocationRelativeTo(null);
            this.Modificar.setTitle("Modificar");
            this.Modificar.setVisible(true);
            this.Modificar.setSize(700, 450);
            this.Modificar.setResizable(false);

            //Deshabilita els iconos
            AOBLL.IconsDisabled(1);

            //Replega i Plena els JTextFields amb les dades (selec)
            p = vAlumneOnline.ao.get(selec);
            AOBLL.PlenaJTextFields(selec, p);

            //Elimina (selec) de la taula i Array
            vAlumneOnline.ao.remove(p);

            this.Modificar.guardar.setActionCommand("_BTNGUARDAR");
            this.Modificar.guardar.setName("_BTNGUARDAR");
            this.Modificar.guardar.addActionListener(this);

            this.Modificar.tornar.setActionCommand("_BTNTORNAR");
            this.Modificar.tornar.setName("_BTNTORNAR");
            this.Modificar.tornar.addActionListener(this);

            this.Modificar.nom.setActionCommand("_NOM");
            this.Modificar.nom.setName("_NOM");
            this.Modificar.nom.addActionListener(this);
            this.Modificar.nom.addKeyListener(this);

            this.Modificar.cognom.setActionCommand("_COGNOM");
            this.Modificar.cognom.setName("_COGNOM");
            this.Modificar.cognom.addActionListener(this);
            this.Modificar.cognom.addKeyListener(this);

            this.Modificar.DNI.setActionCommand("_DNI");
            this.Modificar.DNI.setName("_DNI");
            this.Modificar.DNI.addActionListener(this);
            this.Modificar.DNI.addKeyListener(this);

            this.Modificar.especialitat.setActionCommand("_ESPECIALITAT");
            this.Modificar.especialitat.setName("_ESPECIALITAT");
            this.Modificar.especialitat.addActionListener(this);
            this.Modificar.especialitat.addKeyListener(this);

            this.Modificar.direccio.setActionCommand("_DIRECCIO");
            this.Modificar.direccio.setName("_DIRECCIO");
            this.Modificar.direccio.addActionListener(this);
            this.Modificar.direccio.addKeyListener(this);

            this.Modificar.curs.setActionCommand("_CURS");
            this.Modificar.curs.setName("_CURS");
            this.Modificar.curs.addActionListener(this);
            this.Modificar.curs.addKeyListener(this);

            this.Modificar.naixement.setName("_FECHANAC");
            this.Modificar.naixement.addKeyListener(this);

            this.Modificar.conexio.setActionCommand("_CONEXIO");
            this.Modificar.conexio.setName("_CONEXIO");
            this.Modificar.conexio.addActionListener(this);
            this.Modificar.conexio.addKeyListener(this);

            this.Modificar.desconexio.setActionCommand("_DESCONEXIO");
            this.Modificar.desconexio.setName("_DESCONEXIO");
            this.Modificar.desconexio.addActionListener(this);
            this.Modificar.desconexio.addKeyListener(this);

            this.Modificar.user.setActionCommand("_USER");
            this.Modificar.user.setName("_USER");
            this.Modificar.user.addActionListener(this);
            this.Modificar.user.addKeyListener(this);

            this.Modificar.pass.setActionCommand("_PASS");
            this.Modificar.pass.setName("_PASS");
            this.Modificar.pass.addActionListener(this);
            this.Modificar.pass.addKeyListener(this);

            this.Modificar.beca.setActionCommand("_BECA");
            this.Modificar.beca.setName("_BECA");
            this.Modificar.beca.addActionListener(this);
            this.Modificar.beca.addKeyListener(this);

            this.Modificar.jLabel1.setName("_LNOM");
            this.Modificar.jLabel1.addMouseListener(this);

            this.Modificar.jLabel2.setName("_LCOGNOM");
            this.Modificar.jLabel2.addMouseListener(this);

            this.Modificar.jLabel3.setName("_LDNI");
            this.Modificar.jLabel3.addMouseListener(this);

            this.Modificar.jLabel4.setName("_LESPECIALITAT");
            this.Modificar.jLabel4.addMouseListener(this);

            this.Modificar.jLabel5.setName("_LDIRECCIO");
            this.Modificar.jLabel5.addMouseListener(this);

            this.Modificar.jLabel6.setName("_LCURS");
            this.Modificar.jLabel6.addMouseListener(this);

            this.Modificar.jLabel7.setName("_LFECHANAC");
            this.Modificar.jLabel7.addMouseListener(this);

            this.Modificar.jLabel8.setName("_LCONEXIO");
            this.Modificar.jLabel8.addMouseListener(this);

            this.Modificar.jLabel9.setName("_LDESCONEXIO");
            this.Modificar.jLabel9.addMouseListener(this);

            this.Modificar.jLabel10.setName("_LUSER");
            this.Modificar.jLabel10.addMouseListener(this);

            this.Modificar.jLabel11.setName("_LPASS");
            this.Modificar.jLabel11.addMouseListener(this);

            this.Modificar.jLabel12.setName("_LBECA");
            this.Modificar.jLabel12.addMouseListener(this);

            this.Modificar.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (Accion.valueOf(e.getActionCommand())) {

            //Afegir
            case _BTNGUARDAR:

                if (ventActiva == 0) {

                    //Consultamos si ha llenado los datos


                    if (this.Alta.nomNo.isVisible() || this.Alta.cognomNo.isVisible() || this.Alta.DNINo.isVisible() || this.Alta.becaNo.isVisible()
                            || this.Alta.conexioNo.isVisible() || this.Alta.desconexioNo.isVisible() || this.Alta.cursNo.isVisible() || this.Alta.direccioNo.isVisible()
                            || this.Alta.especialitatNo.isVisible() || this.Alta.naixementNo.isVisible() || this.Alta.userNo.isVisible() || this.Alta.passNo.isVisible()
                            || this.Alta.nom.getText().length() == 0 || this.Alta.cognom.getText().length() == 0 || this.Alta.DNI.getText().length() == 0 || this.Alta.beca.getText().length() == 0
                            || this.Alta.conexio.getText().length() == 0 || this.Alta.desconexio.getText().length() == 0 || this.Alta.curs.getText().length() == 0 || this.Alta.direccio.getText().length() == 0
                            || this.Alta.especialitat.getText().length() == 0 || this.Alta.naixement.getDateFormatString().length() == 0 || this.Alta.user.getText().length() == 0 || this.Alta.pass.getText().length() == 0) {

                        this.Alta.naixement.setDate(null);
                        this.Alta.resultado.setText("Error al guardar...");
                    } else {

                     
                        
                        p = new AlumnesOnline(this.Alta.DNI.getText());

                        
                        if (((OnlineSimpleTableModel) tablaOnline.getModel()).buscaAlumneOnline(p) != -1) {
                           
                           
                            this.Alta.resultado.setText("Ya existe una persona con el mismo DNI");

                         
                            //Limpiamos formulario
                            this.Alta.DNI.setText("");

                        } else {
                            this.Alta.resultado.setText("Guardado correctamente...");

                            
                            AOBLL.crear(0);

                            this.Alta.dispose();
                            new ControladorVent1(new Vent1()).iniciar();

                            //Limpiamos formulario
                        /*
                        
                             this.Alta.nom.setText("");
                             this.Alta.cognom.setText("");
                             this.Alta.DNI.setText("");
                             this.Alta.beca.setText("");
                             this.Alta.conexio.setText("");
                             this.Alta.desconexio.setText("");
                             this.Alta.curs.setText("");
                             this.Alta.direccio.setText("");
                             this.Alta.especialitat.setText("");
                             this.Alta.naixement.setDate(null);
                             this.Alta.user.setText("");
                             this.Alta.pass.setText("");
                             */
                        }

                    }
                } else if (ventActiva == 1) {

                    //Consultamos si ha llenado los datos
                    if (this.Modificar.nomNo.isVisible() || this.Modificar.cognomNo.isVisible() || this.Modificar.DNINo.isVisible() || this.Modificar.becaNo.isVisible()
                            || this.Modificar.conexioNo.isVisible() || this.Modificar.desconexioNo.isVisible() || this.Modificar.cursNo.isVisible() || this.Modificar.direccioNo.isVisible()
                            || this.Modificar.especialitatNo.isVisible() || this.Modificar.naixementNo.isVisible() || this.Modificar.userNo.isVisible() || this.Modificar.passNo.isVisible()
                            || this.Modificar.nom.getText().length() == 0 || this.Modificar.cognom.getText().length() == 0 || this.Modificar.DNI.getText().length() == 0 || this.Modificar.beca.getText().length() == 0
                            || this.Modificar.conexio.getText().length() == 0 || this.Modificar.desconexio.getText().length() == 0 || this.Modificar.curs.getText().length() == 0 || this.Modificar.direccio.getText().length() == 0
                            || this.Modificar.especialitat.getText().length() == 0 || this.Modificar.naixement.getDateFormatString().length() == 0 || this.Modificar.user.getText().length() == 0 || this.Modificar.pass.getText().length() == 0) {

                        this.Modificar.naixement.setDate(null);
                        this.Modificar.resultado.setText("Error al guardar...");
                    } else {

                        AOBLLBD as = new AOBLLBD();
                        as.borrarAlumnoBLL(p);

                        AOBLL.crear(1);

                        //Limpiamos formulario
                        AOBLL.LimpiarFormato(1);

                        this.Modificar.dispose();
                        new ControladorVent1(new Vent1()).iniciar();
                    }
                }
                break;

            case _BTNTORNAR:

                if (ventActiva == 0) {
                    this.Alta.dispose();

                } else if (ventActiva == 1) {
                    this.Modificar.dispose();
                }
                new ControladorVent1(new Vent1()).iniciar();

                break;

            case _NOM:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.nom, this.Alta.nom.getText(), 1);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.nom, this.Modificar.nom.getText(), 1);
                }
                break;
            case _COGNOM:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.cognom, this.Alta.cognom.getText(), 1);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.cognom, this.Modificar.cognom.getText(), 1);
                }
                break;
            case _DNI:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.DNI, this.Alta.DNI.getText(), 1);
                } else if (ventActiva == 1) {
                    // El DNI no cambia.
                }
                break;
            case _ESPECIALITAT:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.especialitat, this.Alta.especialitat.getText(), 1);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.especialitat, this.Modificar.especialitat.getText(), 1);
                }
                break;
            case _DIRECCIO:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.direccio, this.Alta.direccio.getText(), 1);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.direccio, this.Modificar.direccio.getText(), 1);
                }
                break;
            case _CURS:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.curs, this.Alta.curs.getText(), 1);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.curs, this.Modificar.curs.getText(), 1);
                }
                break;
            case _CONEXIO:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.conexio, this.Alta.conexio.getText(), 1);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.conexio, this.Modificar.conexio.getText(), 1);
                }
                break;
            case _DESCONEXIO:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.desconexio, this.Alta.desconexio.getText(), 1);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.desconexio, this.Modificar.desconexio.getText(), 1);
                }
                break;
            case _USER:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.user, this.Alta.user.getText(), 1);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.user, this.Modificar.user.getText(), 1);
                }
                break;
            case _PASS:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.pass, this.Alta.pass.getText(), 1);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.pass, this.Modificar.pass.getText(), 1);
                }
                break;
            case _BECA:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.beca, this.Alta.beca.getText(), 1);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.beca, this.Modificar.beca.getText(), 1);
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
    public void keyReleased(KeyEvent ke) {

        switch (Accion.valueOf(ke.getComponent().getName())) {

            case _NOM:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.nom, this.Alta.nom.getText(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.nom, this.Modificar.nom.getText(), 0);
                }
                break;
            case _COGNOM:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.cognom, this.Alta.cognom.getText(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.cognom, this.Modificar.cognom.getText(), 0);
                }
                break;
            case _DNI:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.DNI, this.Alta.DNI.getText(), 0);
                } else if (ventActiva == 1) {
                    //No es cambia el DNI
                }
                break;
            case _ESPECIALITAT:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.especialitat, this.Alta.especialitat.getText(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.especialitat, this.Modificar.especialitat.getText(), 0);
                }
                break;
            case _DIRECCIO:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.direccio, this.Alta.direccio.getText(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.direccio, this.Modificar.direccio.getText(), 0);
                }
                break;
            case _CURS:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.curs, this.Alta.curs.getText(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.curs, this.Modificar.curs.getText(), 0);
                }
                break;
            case _FECHANAC:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.naixement, this.Alta.naixement.getDate(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.naixement, this.Modificar.naixement.getDate(), 0);
                }
                break;
            case _CONEXIO:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.conexio, this.Alta.conexio.getText(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.conexio, this.Modificar.conexio.getText(), 0);
                }
                break;
            case _DESCONEXIO:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.desconexio, this.Alta.desconexio.getText(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.desconexio, this.Modificar.desconexio.getText(), 0);
                }
                break;
            case _USER:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.user, this.Alta.user.getText(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.user, this.Modificar.user.getText(), 0);
                }
                break;
            case _PASS:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.pass, this.Alta.pass.getText(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.pass, this.Modificar.pass.getText(), 0);
                }
                break;
            case _BECA:
                if (ventActiva == 0) {
                    AOBLL.comprobarDatos(this.Alta.beca, this.Alta.beca.getText(), 0);
                } else if (ventActiva == 1) {
                    AOBLL.comprobarDatos2(this.Modificar.beca, this.Modificar.beca.getText(), 0);
                }
                break;
        }

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
    public void mouseEntered(MouseEvent exe) {

        switch (Accion.valueOf(exe.getComponent().getName())) {

            case _LNOM:
                this.Alta.resultado.setText("Sols Nom valid");
                this.Modificar.resultado.setText("Sols Nom valid");
                break;
            case _LCOGNOM:
                this.Alta.resultado.setText("Sols Cognom valid");
                this.Modificar.resultado.setText("Sols Cognom valid");
                break;
            case _LDNI:
                this.Alta.resultado.setText("Sols DNI valid");
                this.Modificar.resultado.setText("Sols DNI valid");
                break;
            case _LESPECIALITAT:
                this.Alta.resultado.setText("Especialitat valida");
                this.Modificar.resultado.setText("Especialitat valida");
                break;
            case _LDIRECCIO:
                this.Alta.resultado.setText("Direccio valida");
                this.Modificar.resultado.setText("Direccio valida");
                break;
            case _LCURS:
                this.Alta.resultado.setText("Valors valids 0-4");
                this.Modificar.resultado.setText("Valors valids 0-4");
                break;
            case _LFECHANAC:
                this.Alta.resultado.setText("Min 10, Max 60");
                this.Modificar.resultado.setText("Min 10, Max 60");
                break;
            case _LCONEXIO:
                this.Alta.resultado.setText("Valors valids 00-23");
                this.Modificar.resultado.setText("Valors valids 00-23");
                break;
            case _LDESCONEXIO:
                this.Alta.resultado.setText("Valors valids 00-23");
                this.Modificar.resultado.setText("Valors valids 00-23");
                break;
            case _LUSER:
                this.Alta.resultado.setText("Sols Mayus i Minus");
                this.Modificar.resultado.setText("Sols Mayus i Minus");
                break;
            case _LPASS:
                this.Alta.resultado.setText("Min 8 caracters, 1 Mayus, 1 Num");
                this.Modificar.resultado.setText("Min 8 caracters, 1 Mayus, 1 Num");
                break;
            case _LBECA:
                this.Alta.resultado.setText("Valors entre 1000-9999");
                this.Modificar.resultado.setText("Valors entre 1000-9999");
                break;
        }

    }

    @Override
    public void mouseExited(MouseEvent ece) {

        switch (Accion.valueOf(ece.getComponent().getName())) {

            case _LNOM:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LCOGNOM:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LDNI:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LESPECIALITAT:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LDIRECCIO:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LCURS:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LFECHANAC:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LCONEXIO:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LDESCONEXIO:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LUSER:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LPASS:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
            case _LBECA:
                this.Alta.resultado.setText("");
                this.Modificar.resultado.setText("");
                break;
        }

    }

}
