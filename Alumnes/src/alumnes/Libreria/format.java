package alumnes.Libreria;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class format {


	public static String format1Decimal(double number){
		DecimalFormat format1 = new DecimalFormat(".#");
		return format1.format(number);
	}
	
	public static String format2Decimal(double number) {
		DecimalFormat format1 = new DecimalFormat(".##");
		return format1.format(number);
	}

	public static String format3Decimal(double number) {
		DecimalFormat format1 = new DecimalFormat(".###");
		return format1.format(number);
	}

	public static String formatSaldo(double number) {
		DecimalFormat format1 = new DecimalFormat("###.###,###");
		return format1.format(number);
	}

	public static String formatDollar(double moneda){
		NumberFormat format1=NumberFormat.getCurrencyInstance(Locale.US);//Dolar
		return format1.format(moneda);
	}
	
	public static String formatLibra(double moneda){
		NumberFormat format1=NumberFormat.getCurrencyInstance( Locale.UK );//Libras
		return format1.format(moneda);
	}
	
	public static String formatEuro(double moneda){
		NumberFormat format1=NumberFormat.getCurrencyInstance( Locale.FRANCE );//Euro
		return format1.format(moneda);
	}
	
	public static String porcentajeInt(int i){
		String s = "";
			s = Integer.toString(i) + "%";
		return s;
	}
		
}
