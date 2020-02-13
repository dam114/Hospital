
public class Paciente extends Persona {

	private String NSS;
	private String telefono;
	private String dolencia;

	public Paciente(String DNI, String nombre, String apellido, String NSS, String telefono, String dolencia) {
		super(DNI, nombre, apellido);
		this.NSS = NSS;
		this.telefono = telefono;
		this.dolencia = dolencia;

	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String nSS) {
		NSS = nSS;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDolencia() {
		return dolencia;
	}

	public void setDolencia(String dolencia) {
		this.dolencia = dolencia;
	}

	@Override
	public String toString() {
		return "Paciente con "+super.toString()+", NSS:" + NSS + ", telefono:" + telefono + ", dolencia:" + dolencia;
	}
	
	

}
