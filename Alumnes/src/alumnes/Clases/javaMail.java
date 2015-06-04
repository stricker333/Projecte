/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes.Clases;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Stricker333
 */
public class javaMail {

    //1erdaw2015@gmail.com
    //villadaw
    private String user, pass, destino, subject, mensaje, us, pa, token;
    private Properties props;

    public javaMail(String vuser, String vpass, String vdestino, String vsubject, String vmensaje, String vus, String vpa, String vtoken) {
        user = vuser;
        pass = vpass;
        destino = vdestino;
        subject = vsubject;
        mensaje = vmensaje;
        us = vus;
        pa = vpa;
        token = vtoken;
        props = new Properties();
    }

    public String send() {
        String error;
        try {
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            //el puerto que vamos a usar
            props.setProperty("mail.smtp.port", "587");
            //el usuario
            props.setProperty("mail.smtp.user", user);
            //le indicamos que es necesario autentificarse
            props.setProperty("mail.smtp.auth", "true");

            //creamos un objeto session donde le setearemos los parametros
            Session session = Session.getDefaultInstance(props);
            //crearemos el mensaje
            MimeMessage message = new MimeMessage(session);

            //le seteamos el remitente
            message.setFrom(new InternetAddress(user));

            //Obtenemos los destinatarios
            String destinos[] = destino.split(",");
            Address[] receptores = new Address[destinos.length];
            int j = 0;
            while (j < destinos.length) {
                receptores[j] = new InternetAddress(destinos[j]);
                j++;
            }
            message.addRecipients(Message.RecipientType.TO, receptores);

            //el asunto
            message.setSubject(subject);

            //le seteamos el cuerpo del mensaje + envio de adjuntos
            MimeBodyPart mimebodypart1 = new MimeBodyPart();
            mimebodypart1.setContent("<html><font color='GREEN'>" + mensaje + new java.util.Date() + "<br> </font> <br> "
                    + "<font color='BLUE'>" + "Usuario: " + us + "<br> " + "Password: " + pa + "<br><br>" + token + "</font> </html>", "text/html");

            Multipart multipart = new MimeMultipart("related");
            multipart.addBodyPart(mimebodypart1);
            message.setContent(multipart);

            //creamos la conexion y enviamos el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(user, pass);
            t.sendMessage(message, message.getAllRecipients());
            //t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            error = "";
        } catch (Exception e) {
            error = e.toString();
        }
        return error;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }
    
      public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Mail{" + "user=" + user + ", pass=" + pass + ", destino=" + destino + ", subject=" + subject + ", mensaje=" + mensaje + ", props=" + props + "us=" + us + ", pa=" + pa + '}';
    }

}
