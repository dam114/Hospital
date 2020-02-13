import java.util.ArrayList;
import java.util.Iterator;

public class Medico extends Persona {

	private String especialidad;
	private ArrayList<Paciente> pacientesAtendidos;

	public Medico(String DNI, String nombre, String apellido, String especialidad) {
		super(DNI, nombre, apellido);
		this.especialidad = especialidad;
		pacientesAtendidos = new ArrayList<Paciente>();
	}

	public Medico() {
		super();
		this.especialidad = "";
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Medico con " + super.toString() + ", especialidad:" + especialidad;
	}

	public void atenderPaciente(Paciente p) {
		pacientesAtendidos.add(p);
	}
	
	public void listarPacientes() {
		Iterator<Paciente> it = pacientesAtendidos.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
