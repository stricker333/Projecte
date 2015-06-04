package alumnes.Libreria;

public class Validate {

	// REGEX Nombres propios, apellidos, ciudades etc...
	public static boolean regexNom(String name) {
		return name.matches("[a-zA-z]+([ ][a-zA-Z]+)*");
	}

	// REGEX Cognoms
	public static boolean regexCognoms(String cognom) {
		return cognom.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
	}

	// REGEX DNI
	public static boolean regexDNI(String DNI) {
		boolean val = true;
		try {
			String dni2 = "", caracteres = "TRWAGMYFPDXBNJZSQVHLCKET";
			int dni = 0, modulo = 0;
			for (int i = 0; i < 8; i++)
				dni2 += DNI.charAt(i);
			char letra = DNI.charAt(8);
			dni = Integer.parseInt(dni2);
			modulo = dni % 23;
			char let = caracteres.charAt(modulo);
			if (let == letra)
				val = true;
			else
				val = false;
		} catch (Exception e) {
			return false;
		}
		return val;
	}

	// REGEX Email
	public static boolean regexEmail(String email) {
		return email.matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	// REGEX CP
	public static boolean regexCP(String cp) {
		return cp.matches("^(5[0-2]|[0-4][0-9])[0-9]{3}$");
	}

	// REGEX Direccio
	public static boolean regexDireccio(String direccio) {
		return direccio.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");

	}

	// REGEX Telefon
	public static boolean regexTelefono(String telefon) {
		return telefon
				.matches("0{0,2}([\\+]?[\\d]{1,3} ?)?([\\(]([\\d]{2,3})[)] ?)?[0-9][0-9 \\-]{6,}( ?([xX]|([eE]xt[\\.]?)) ?([\\d]{1,5}))?");
	}

	// REGEX Fecha xx/mm/yyyy
	public static boolean regexFecha(String fecha) {
		return fecha.matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
	}

	// REGEX Usuari Nombre de usuario
	public static boolean regexUsuari(String usuari) {
		return usuari.matches("[a-zA-z]+([ ][a-zA-Z]+)*");
	}

	// REGEX Pass (Min 1 mayus,minus y car especial, 8 car min)
	public static boolean regexPass(String pass) {
		return pass.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
	}

	// REGEX URL
	public static boolean regexURL(String url) {
		return url.matches("\\b(https?|ftp|file)://[-A-Z0-9+&@#/%?=~_|!:,.;]*[-A-Z0-9+&@#/%=~_|]");
	}

	// REGEX CIF
	public static boolean regexCIF(String cif) {
		return cif.matches("^[a-zA-Z]{1}[0-9]{8}$");
	}
	
	// REGEX Curso (1-6)
	public static boolean regexCurso (String curso) {
		return curso.matches("[1-4]");
	}
	
	// REGEX Hora (00-23)
	public static boolean regexHora (String hora) {
		return hora.matches("^(0[0-9]|1\\d|2[0-3])$");
	}
	
	//REGEX 23max
	public static boolean regex23max (String max) {
		return max.matches("^(0[1-9]|1\\d|2[0-3])$");
	}
	
        //REGEX Beca
	public static boolean regexBeca (String max) {
		return max.matches("[0-9]{4}");
	}
}