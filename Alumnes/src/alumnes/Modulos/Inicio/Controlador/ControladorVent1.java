/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes.Modulos.Inicio.Controlador;

import alumnes.Libreria.Upload;
import alumnes.Main;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.BLL.AOBLL;
import alumnes.Modulos.Inicio.Vista.Vent1;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.BLL.AOBLLBD;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.AlumnesOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Vista.AfegirAlumneOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Vista.ModificarAlumneOnline;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.Clases.OnlineSimpleTableModel;
import alumnes.Modulos.GestioAlumnes.GestioAO.Modelo.pager.pagina;
import alumnes.Modulos.Login.Controlador.ControladorLogin;
import alumnes.Modulos.GestioProfessors.Modelo.BLL.POBLLBD;
import alumnes.Modulos.GestioProfessors.Modelo.Clases.vProfesorOnline;
import alumnes.Modulos.Login.Vista.VentanaLogin;
import alumnes.Libreria.theme;
import alumnes.Modulos.GestioAlumnes.GestioAO.Controlador.ControladorAO;
import alumnes.Modulos.GestioProfessors.Controlador.Controlador_Professor;
import alumnes.Modulos.GestioProfessors.Vista.MyPerfil;
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
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Stricker333
 */
public class ControladorVent1 implements ActionListener, KeyListener, MouseListener {

    public static Vent1 ventCrud = new Vent1();
    public static ArrayList<AlumnesOnline> ListPedidos = new ArrayList<AlumnesOnline>();
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new OnlineSimpleTableModel());

    int selec, inicio, selection1;

    public ControladorVent1(JFrame principal) {
        this.ventCrud = (Vent1) principal;
    }

    public enum Accion {

        _CREAR,
        _MODIFICAR,
        _ELIMINAR,
        _BTN_ANTERIOR,
        _BTN_SIGUIENTE,
        _BTN_ULTIMO,
        _BTN_PRIMERO,
        _COMBOX,
        _BUSCAR,
        _BUSCAR1,
        _TEMA1,
        _TEMA2,
        _TEMA3,
        _TEMA4,
        _JSON,
        _TXT,
        _XML,
        _MAS,
        _MENOS,
        _EDADMEDIA,
        _CONAVATAR,
        _CONUSER,
        _CONLOGOUT,
        _MASFALTA,
        _MENOSFALTA,
    }

    public void iniciar() {

        //((BasicInternalFrameUI)this.frmLogin.getUI()).setNorthPane(null);
        this.ventCrud.setLocationRelativeTo(null);
        this.ventCrud.setTitle("Principal");
        this.ventCrud.setVisible(true);
        this.ventCrud.setResizable(false);
        this.ventCrud.setSize(1230, 530);

        Image image = Toolkit.getDefaultToolkit().getImage("src/alumnes/Img/fondoPerso1.jpg");
        this.ventCrud.setIconImage(image);
        /////////////////////////////////////////////////////////////////////////////////////////////

        // Pintem el avatar
        this.ventCrud.conAvatar.setIcon(Upload.Pintar());

        /////////////////////////////////////////////////////////////////////////////////////////////
        String user = vProfesorOnline.ap1.getUser();
        this.ventCrud.conUser.setText(user);
        this.ventCrud.conUser.setForeground(Color.green);

        /////////////////////////////////////////////////////////////////////////////////////////////
        if (vProfesorOnline.ap1.getTipo().equals("Actiu")) {

            this.ventCrud.jPanel1.setVisible(false);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////
        this.ventCrud.tablaOnline.setModel(new OnlineSimpleTableModel());
        ((OnlineSimpleTableModel) this.ventCrud.tablaOnline.getModel()).cargar();
        this.ventCrud.tablaOnline.setFillsViewportHeight(true);
        this.ventCrud.tablaOnline.setRowSorter(sorter);

        pagina.inicializa();
        pagina.initLinkBox();

        if (this.ventCrud.tablaOnline.getRowCount() == 0) {
            this.ventCrud.botEliminar.setEnabled(false);
            this.ventCrud.botModificar.setEnabled(false);

        } else {
            this.ventCrud.botEliminar.setEnabled(true);
            this.ventCrud.botModificar.setEnabled(true);
        }

        this.ventCrud.botAfegir.setActionCommand("_CREAR");
        this.ventCrud.botAfegir.setName("_CREAR");
        this.ventCrud.botAfegir.addActionListener(this);

        this.ventCrud.botModificar.setActionCommand("_MODIFICAR");
        this.ventCrud.botModificar.setName("_MODIFICAR");
        this.ventCrud.botModificar.addActionListener(this);

        this.ventCrud.botEliminar.setActionCommand("_ELIMINAR");
        this.ventCrud.botEliminar.setName("_ELIMINAR");
        this.ventCrud.botEliminar.addActionListener(this);

        this.ventCrud.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
        this.ventCrud.ANTERIOR.setName("_BTN_ANTERIOR");
        this.ventCrud.ANTERIOR.addActionListener(this);

        this.ventCrud.SIGUIENTE.setActionCommand("_BTN_SIGUIENTE");
        this.ventCrud.SIGUIENTE.setName("_BTN_SIGUIENTE");
        this.ventCrud.SIGUIENTE.addActionListener(this);

        this.ventCrud.ultimo.setActionCommand("_BTN_ULTIMO");
        this.ventCrud.ultimo.setName("_BTN_ULTIMO");
        this.ventCrud.ultimo.addActionListener(this);

        this.ventCrud.primero.setActionCommand("_BTN_PRIMERO");
        this.ventCrud.primero.setName("_BTN_PRIMERO");
        this.ventCrud.primero.addActionListener(this);

        this.ventCrud.jComboBox1.setActionCommand("_COMBOX");
        this.ventCrud.jComboBox1.setName("_COMBOX");
        this.ventCrud.jComboBox1.addActionListener(this);

        this.ventCrud.buscar.setName("_BUSCAR");
        this.ventCrud.buscar.addKeyListener(this);

        this.ventCrud.buscar1.setName("_BUSCAR1");
        this.ventCrud.buscar1.addKeyListener(this);

        this.ventCrud.TEMA1.setActionCommand("_TEMA1");
        this.ventCrud.TEMA1.setName("_TEMA1");
        this.ventCrud.TEMA1.addActionListener(this);

        this.ventCrud.TEMA2.setActionCommand("_TEMA2");
        this.ventCrud.TEMA2.setName("_TEMA2");
        this.ventCrud.TEMA2.addActionListener(this);

        this.ventCrud.TEMA3.setActionCommand("_TEMA3");
        this.ventCrud.TEMA3.setName("_TEMA3");
        this.ventCrud.TEMA3.addActionListener(this);

        this.ventCrud.TEMA4.setActionCommand("_TEMA4");
        this.ventCrud.TEMA4.setName("_TEMA4");
        this.ventCrud.TEMA4.addActionListener(this);

        this.ventCrud.jsonNormal.setName("_JSON");
        this.ventCrud.jsonNormal.addMouseListener(this);

        this.ventCrud.txtNormal.setName("_TXT");
        this.ventCrud.txtNormal.addMouseListener(this);

        this.ventCrud.xmlNormal.setName("_XML");
        this.ventCrud.xmlNormal.addMouseListener(this);

        this.ventCrud.mas.setName("_MAS");
        this.ventCrud.mas.addMouseListener(this);

        this.ventCrud.menos.setName("_MENOS");
        this.ventCrud.menos.addMouseListener(this);

        this.ventCrud.edadMedia.setName("_EDADMEDIA");
        this.ventCrud.edadMedia.addMouseListener(this);

        this.ventCrud.conAvatar.setName("_CONAVATAR");
        this.ventCrud.conAvatar.addMouseListener(this);

        this.ventCrud.conUser.setName("_CONUSER");
        this.ventCrud.conUser.addMouseListener(this);

        this.ventCrud.conLogout.setName("_CONLOGOUT");
        this.ventCrud.conLogout.addMouseListener(this);

        this.ventCrud.fFalta.setActionCommand("_MASFALTA");
        this.ventCrud.fFalta.setName("_MASFALTA");
        this.ventCrud.fFalta.addActionListener(this);

        this.ventCrud.lFalta.setActionCommand("_MENOSFALTA");
        this.ventCrud.lFalta.setName("_MENOSFALTA");
        this.ventCrud.lFalta.addActionListener(this);

        this.ventCrud.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent te) {

        switch (Accion.valueOf(te.getActionCommand())) {

            case _CREAR:

                this.ventCrud.dispose();

                new ControladorAO(new AfegirAlumneOnline(), 0).iniciar(-3, this.ventCrud.tablaOnline, 0);
                break;

            case _MODIFICAR:

                if (((OnlineSimpleTableModel) this.ventCrud.tablaOnline.getModel()).getRowCount() != 0) {
                    selec = this.ventCrud.tablaOnline.getSelectedRow();
                    inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                    selection1 = inicio + selec;

                    if (selec == -1) {
                        JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
                    } else {
                        this.ventCrud.dispose();

                        
                        new ControladorAO(new ModificarAlumneOnline(), 1).iniciar(selection1, this.ventCrud.tablaOnline, 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);
                }

                break;
            case _ELIMINAR:

                if (((OnlineSimpleTableModel) this.ventCrud.tablaOnline.getModel()).getRowCount() != 0) {
                    selec = this.ventCrud.tablaOnline.getSelectedRow();
                    inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                    selection1 = inicio + selec;

                    if (selec == -1) {
                        JOptionPane.showMessageDialog(null, "Selecciona un alumne", "Error!", 2);
                    } else {
                        AOBLL.eliminar(selection1);

                    }
                }
                break;

            case _BTN_ANTERIOR:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                break;

            case _BTN_SIGUIENTE:
                pagina.currentPageIndex += 1;
                pagina.initLinkBox();
                break;

            case _BTN_ULTIMO:
                pagina.currentPageIndex = pagina.maxPageIndex;
                pagina.initLinkBox();
                break;

            case _BTN_PRIMERO:
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;

            case _COMBOX:
                pagina.itemsPerPage = Integer.parseInt(Vent1.jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;

            case _TEMA1:

                theme.themePpal("0");
                this.ventCrud.dispose();
                new ControladorVent1(new Vent1()).iniciar();
                break;

            case _TEMA2:

                theme.themePpal("1");
                this.ventCrud.dispose();
                new ControladorVent1(new Vent1()).iniciar();
                break;

            case _TEMA3:

                theme.themePpal("2");
                this.ventCrud.dispose();
                new ControladorVent1(new Vent1()).iniciar();
                break;

            case _TEMA4:

                theme.themePpal("3");
                this.ventCrud.dispose();
                new ControladorVent1(new Vent1()).iniciar();
                break;

            case _MASFALTA:

                if (((OnlineSimpleTableModel) this.ventCrud.tablaOnline.getModel()).getRowCount() != 0) {
                    selec = this.ventCrud.tablaOnline.getSelectedRow();

                    inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                    selection1 = inicio + selec;

                    if (selec == -1) {
                        JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
                    } else {

                        AOBLL.gestionFaltas(selection1, +1);

                        this.ventCrud.dispose();
                        new ControladorVent1(new Vent1()).iniciar();

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);
                }

                break;

            case _MENOSFALTA:

                if (((OnlineSimpleTableModel) this.ventCrud.tablaOnline.getModel()).getRowCount() != 0) {
                    selec = this.ventCrud.tablaOnline.getSelectedRow();
                    inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                    selection1 = inicio + selec;

                    if (selec == -1) {
                        JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
                    } else {

                        AOBLL.gestionFaltas(selection1, -1);

                        this.ventCrud.dispose();
                        new ControladorVent1(new Vent1()).iniciar();

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);
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

            case _BUSCAR:
                pagina.currentPageIndex = 1;
                ((OnlineSimpleTableModel) this.ventCrud.tablaOnline.getModel()).filtrarNom();

                break;

            case _BUSCAR1:
                pagina.currentPageIndex = 1;
                ((OnlineSimpleTableModel) this.ventCrud.tablaOnline.getModel()).filtrarDNI();

                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent ce) {
        int op = 0, num = 0;
        switch (Accion.valueOf(ce.getComponent().getName())) {

            case _JSON:
                JOptionPane.showMessageDialog(null, "JSON");
                AOBLL.Guardar(op = 1);
                break;

            case _TXT:
                JOptionPane.showMessageDialog(null, "TXT");
                AOBLL.Guardar(op = 2);
                break;

            case _XML:
                JOptionPane.showMessageDialog(null, "XML");
                AOBLL.Guardar(op = 3);
                break;

            case _MAS:

                num = Main.config.getTabla() + 1;

                if (num <= 6) {

                    Main.config.setTabla(num);
                    this.ventCrud.menos.setVisible(true);

                    this.ventCrud.tablaOnline.setModel(new OnlineSimpleTableModel());

                } else {
                    this.ventCrud.mas.setOpaque(true);
                }

                break;

            case _MENOS:

                num = Main.config.getTabla() - 1;

                if (num >= 0) {

                    Main.config.setTabla(num);
                    this.ventCrud.mas.setVisible(true);

                    this.ventCrud.tablaOnline.setModel(new OnlineSimpleTableModel());

                } else {
                    this.ventCrud.menos.setOpaque(true);
                }

                break;

            case _EDADMEDIA:

                AOBLLBD _usuario = new AOBLLBD();
                _usuario.EdadMediaBLL();

                break;

            case _CONAVATAR:

                String user = vProfesorOnline.ap1.getUser();

                Upload.pintar_guardar_imag(this.ventCrud.conAvatar, 60, 60);
                String ruta = Upload.PATH_auto;

                POBLLBD ava = new POBLLBD();

                ava.cambiarAvatarBLL(user, ruta);

                break;

            case _CONLOGOUT:

                vProfesorOnline.ap1.setUser(null);
                vProfesorOnline.ap1.setPass(null);
                vProfesorOnline.ap1.setEmail(null);
                vProfesorOnline.ap1.setTipo(null);
                vProfesorOnline.ap1.setEstado(null);
                vProfesorOnline.ap1.setAvatar(null);

                this.ventCrud.dispose();

                new ControladorLogin(new VentanaLogin(), 0).iniciar(0);

                break;

            case _CONUSER:

                if (!vProfesorOnline.ap1.getTipo().equals("Admin")) {
                    this.ventCrud.dispose();
                    new Controlador_Professor(new MyPerfil()).iniciar();
                }
                break;

        }
    }

    @Override
    public void mouseEntered(MouseEvent ene) {
        switch (Accion.valueOf(ene.getComponent().getName())) {

            case _JSON:
                this.ventCrud.jsonNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/json_fileEntered.png")));
                break;

            case _TXT:
                this.ventCrud.txtNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/txt_fileEntered.png")));
                break;

            case _XML:
                this.ventCrud.xmlNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/xml_fileEntered.png")));
                break;

            case _MAS:
                this.ventCrud.mas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/magnifyingglass5.png")));
                break;

            case _MENOS:
                this.ventCrud.menos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/magnifyingglass6.png")));
                break;

        }
    }

    @Override
    public void mouseExited(MouseEvent exe) {

        switch (Accion.valueOf(exe.getComponent().getName())) {

            case _JSON:
                this.ventCrud.jsonNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/json_file.png")));
                break;

            case _TXT:
                this.ventCrud.txtNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/txt_file.png")));
                break;

            case _XML:
                this.ventCrud.xmlNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/xml_file.png")));
                break;

            case _MAS:
                this.ventCrud.mas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/magnifying-glass22.png")));
                break;

            case _MENOS:
                this.ventCrud.menos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnes/Img/zoom-out2.png")));
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

}
