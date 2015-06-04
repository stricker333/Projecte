/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes;

import alumnes.Clases.Config;
import alumnes.Modulos.Login.Controlador.ControladorLogin;
import alumnes.Modulos.Login.Vista.VentanaLogin;
import alumnes.Libreria.theme;

/**
 *
 * @author carlos
 */
public class Main {

    public static Config config = null;

    public static void main(String[] args) {
        // TODO code application logic here

        config = new Config();
        theme.themePpal("1");

        new ControladorLogin(new VentanaLogin(), 0).iniciar(0);

    }
}
