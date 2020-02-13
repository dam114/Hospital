import java.util.ArrayList;
import java.util.Iterator;

public class ListaPacientes {

	private ArrayList<Paciente> pacientes;

	public ListaPacientes() {
		pacientes = new ArrayList<Paciente>();
	}

	public void addPaciente(Paciente p) {
		pacientes.add(p);
	}

	public void print() {
		Iterator<Paciente> it = pacientes.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	public int tamaño() {
		return pacientes.size();
	}

	public void borrarPorDNI(String DNI) {
		for (int i = 0; i < pacientes.size(); i++) {
			Paciente c = pacientes.get(i);
			String DNIc = c.getDNI();
			if (DNIc.equals(DNI)) {
				pacientes.remove(i);
			}
		}
	}

	public Paciente existePaciente(String DNI) {
		Paciente c = null;
		for (int i = 0; i < pacientes.size(); i++) {
			Paciente d = pacientes.get(i);
			String DNIc = d.getDNI();
			if (DNIc.equals(DNI)) {
				c = d;
				break;
			}
		}
		return c;
	}

	public Paciente siguientePaciente() {
		return pacientes.get(0);
	}

	public ArrayList<Paciente> listaPacientes() {
		return this.pacientes;
	}

}
