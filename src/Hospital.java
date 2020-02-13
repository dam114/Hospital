
public class Hospital {

	private String nombre;
	private String contraseña;
	private Especialidades especialidades;

	public Hospital(String nombre, String contraseña, Especialidades especialidades) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.especialidades = especialidades;
	}

	public void addEspecialidad(String especialidad) {
		especialidades.addEspecialidad(especialidad);
	}

	public void borrarEspecialidad(String especialidad) {
		especialidades.borrarEspecialidad(especialidad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Especialidades getEspecialidades() {
		return especialidades;
	}

	public String printHospital() {
		return "Hospital " + nombre;
	}

	@Override
	public boolean equals(Object o) {
		boolean igual = false;
		if (o instanceof Hospital) {
			Hospital h = (Hospital) o;
			if (this.nombre.equals(h.getNombre()) && this.contraseña.equals(h.getContraseña())) {
				for (int i = 0; i < this.especialidades.tamaño(); i++) {
					igual = this.especialidades.especialidades().get(i)
							.equals(h.getEspecialidades().especialidades().get(i));
				}
			}
		}
		return igual;
	}

}
