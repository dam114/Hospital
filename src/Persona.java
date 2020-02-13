/**
 * 
 * @author Cristina Sanchez Duro
 * @version 0.1
 *
 */
public class Persona {

	/**
	 * DNI de la persona (identificador unico)
	 */
	private String DNI;
	/**
	 * Nombre de la persona
	 */
	private String nombre;
	/**
	 * Apellido de la persona
	 */
	private String apellido;

	
	/**
	 * Constructor con todos los parámetros de una persona
	 * @param DNI DNI de la persona que queremos construir
	 * @param name Nombre de la persona que queremos construir
	 * @param lastname Apellido de la persona que queremos construir
	 */
	public Persona(String DNI, String name, String lastname) {
		this.DNI = DNI;
		this.nombre = name;
		this.apellido = lastname;
	}

	/**
	 * Constructor de persona con los parámetros vacios
	 */
	public Persona() {
		this.DNI = "";
		this.nombre = "";
		this.apellido = "";
	}

	/**
	 * @return devuelve el DNI de la persona
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * @param DNI DNI del cual se va a cambiar el valor 
	 */
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	/**
	 * @return El nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Nombre del que se va a cambiar el valor
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return El apellido de la persona
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido Apellido del que se va a cambiar el valor
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	/**
	 * @return Devuelve una cadena con todos los atributos de la persona
	 */
	@Override
	public String toString() {
		return "DNI:" + DNI + ", Nombre:" + nombre + ", Apellido:" + apellido;
	}

}
