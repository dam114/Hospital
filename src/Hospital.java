
public class Hospital {

	private String nombre;
	private String contrase�a;
	private Especialidades especialidades;

	public Hospital(String nombre, String contrase�a, Especialidades especialidades) {
		this.nombre = nombre;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
			if (this.nombre.equals(h.getNombre()) && this.contrase�a.equals(h.getContrase�a())) {
				for (int i = 0; i < this.especialidades.tama�o(); i++) {
					igual = this.especialidades.especialidades().get(i)
							.equals(h.getEspecialidades().especialidades().get(i));
				}
			}
		}
		return igual;
	}

}
