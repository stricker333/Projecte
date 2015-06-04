package alumnes.Clases;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import alumnes.Main;

//Declaracion.
@XStreamAlias("Fecha")
public class Fecha implements Serializable {

    @XStreamAlias("day")
    private int day;
    @XStreamAlias("month")
    private int month;
    @XStreamAlias("year")
    private int year;
    @XStreamAlias("date")
    private String date;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor.
    public Fecha(int day, int month, int year, String date) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.date = date;
    }

    // Getters y Setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Li pase una fecha Calendar
    public Fecha(Calendar fecha) {
        this.day = fecha.get(Calendar.DATE);
        this.month = fecha.get(Calendar.MONTH) + 1;
        this.year = fecha.get(Calendar.YEAR);
    }

    public Fecha(String introducefecha) {
        String[] SplitArray = null;
        String fechaform = null;

        if (Main.config.getFormFecha() == "1") {
            SplitArray = introducefecha.split("/");

            this.day = Integer.parseInt(SplitArray[0]);
            this.month = Integer.parseInt(SplitArray[1]);
            this.year = Integer.parseInt(SplitArray[2]);
        } else if (Main.config.getFormFecha() == "2") {
            SplitArray = introducefecha.split("/");

            this.month = Integer.parseInt(SplitArray[0]);
            this.day = Integer.parseInt(SplitArray[1]);
            this.year = Integer.parseInt(SplitArray[2]);
        } else if (Main.config.getFormFecha() == "3") {
            SplitArray = introducefecha.split("/");

            this.year = Integer.parseInt(SplitArray[0]);
            this.month = Integer.parseInt(SplitArray[1]);
            this.day = Integer.parseInt(SplitArray[2]);
        }

        fechaform = day + "/" + month + "/" + year;
        this.date = fechaform;
    }

    public Fecha(String introducefecha, String i) {

        String[] SplitArray = null;

        SplitArray = introducefecha.split("/");

        this.day = Integer.parseInt(SplitArray[0]);
        this.month = Integer.parseInt(SplitArray[1]);
        this.year = Integer.parseInt(SplitArray[2]);

        this.date = introducefecha;

    }

    // Valida el dia del mes, mes, anio, utiliza StringToCalendar.
    public boolean validafecha() {
        boolean resultado = true;
        GregorianCalendar fecha = new GregorianCalendar();
        int diaMes[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((this.month > 1) || (this.month < 12)) {

            fecha.set(this.day, this.month, this.year);

            if (fecha.isLeapYear(this.year)) {
                diaMes[2] = 29;
            }

            if ((this.day <= 0) || (this.day > diaMes[this.month])) {
                resultado = false;
            }
        } else {
            resultado = false;
        }
        return resultado;
    }

    // Pasa una Fecha Calendar a String
    public String aStringFecha() {
        String fecha = null;

        if (Main.config.getFormFecha() == "1") {
            fecha = this.day + "/" + this.month + "/" + this.year;
        } else if (Main.config.getFormFecha() == "2") {
            fecha = this.month + "/" + this.day + "/" + this.year;
        } else if (Main.config.getFormFecha() == "3") {
            fecha = this.year + "/" + this.month + "/" + this.day;
        }

        return fecha;
    }

        
     // Transforma una fecha Fecha a Date.
   
    public static Date pideFechaDate(Fecha fecha) {// evito utilizar mÃ©todos
        // obsoletos (deprecated) de Date
        Date fec;

        Calendar cal = Calendar.getInstance();
        cal.set(fecha.getYear(), fecha.getMonth(), fecha.getDay());

        fec = cal.getTime();

        return fec;
    }
    
    //Pasar de Date a String
    public static String paseDateToString(Date date) {
        String fe = "";

        try {
            SimpleDateFormat formFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
            fe = formFecha.format(date);
        } catch (Exception e) {
            return fe;
        }

        return fe;
    }

    public String parseString(Date f) {
        String fecha = "";
        try {
            SimpleDateFormat formFecha = new SimpleDateFormat("dd/MM/yyyy");
            fecha = formFecha.format(f);
        } catch (Exception e) {
            return fecha;
        }
        return fecha;
    }

    // metodo per a pasar de calendar a string
    public String calen2String(Calendar fecha) {

        int dia, mes, anyo;
        String fechaS = null, fechaS2 = "XX/XX/XX";

        try {
            dia = fecha.get(Calendar.DATE);
            mes = ((fecha.get(Calendar.MONTH)) + 1);
            anyo = fecha.get(Calendar.YEAR);
            fechaS = dia + "/" + mes + "/" + anyo;
        } catch (Exception e) {
            return fechaS2;
        }

        return fechaS;

    }

    // Pasa un String a Fecha Calendar
    public Calendar deStringToCalendar(String fecha) {
        Date fechaDate = new Date();
        Calendar fechaCalendar = new GregorianCalendar();
        try {
            fechaDate = formato.parse(fecha);
            fechaCalendar.setTime(fechaDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fechaCalendar;
    }

    //Parecido al anterior
    // metodo per a pasar de string a calendar
    public Calendar string2Calen() {

        Calendar fecha = Calendar.getInstance();
        Date fecha2 = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fecha2 = sdf.parse(this.date);
            fecha.setTime(fecha2);

        } catch (Exception e) {
            return fecha;

        }

        return fecha;
    }

    // Compara la fecha amb la del sistema
    public int comparaFechaSistema() {

        int var = 0;
        Calendar fecha1 = this.string2Calen();
        Calendar fecha2 = Calendar.getInstance();

        if (fecha1.before(fecha2)) {
            var = 0;
        } else if (fecha1.after(fecha2)) {
            var = 1;
        } else {
            var = 2;
        }

        return var;

    }

    // Compara 2 fechas
    public int comparaFechas(Fecha fecha2) {

        Calendar cal1 = this.deStringToCalendar(date);
        Calendar cal2 = this.deStringToCalendar(fecha2.aStringFecha());

        if (cal1.before(cal2)) {
            return 1;
        } else if (cal1.after(cal2)) {
            return 2;
        } else {
            return 3;
        }
    }

    // Restafechas/Sistema *Donada una fecha, retorna amb anys la diferencia.
    public int restaFechas() {
        int years = 0;
        Calendar actual = Calendar.getInstance();
        int day = actual.get(Calendar.DATE);
        int month = actual.get(Calendar.MONTH) + 1;
        int year = actual.get(Calendar.YEAR);
        years = year - this.year;

        if (month < this.month) {
            years = years - 1;
        } else if (month == this.month) {
            if (day < this.day) {
                years = years - 1;
            }
        }
        return years;
    }

}
