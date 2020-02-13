import java.util.ArrayList;
import java.util.Iterator;

public class ListaMedicos {

	private ArrayList<Medico> medicos;
	private ArrayList<Medico> espec;

	public ListaMedicos() {
		medicos = new ArrayList<Medico>();
	}

	public void addMedico(Medico n) {
		if (n.getEspecialidad() != null) {
			medicos.add(n);
		}
	}

	public void print() {
		Iterator<Medico> it = medicos.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	public int tamaño() {
		return medicos.size();
	}

	public void borrarPorDNI(String DNI) {
		for (int i = 0; i < medicos.size(); i++) {
			Medico c = medicos.get(i);
			String DNIc = c.getDNI();
			if (DNIc.equals(DNI)) {
				medicos.remove(i);
			}
		}
	}

	public Medico existeMedico(String DNI) {
		Medico c = null;
		for (int i = 0; i < medicos.size(); i++) {
			Medico d = medicos.get(i);
			String DNIc = d.getDNI();
			if (DNIc.equals(DNI)) {
				c = d;
				break;
			}
		}
		return c;
	}

	public Medico medicoEspecialista(String especialidad) {
		Medico c = null;
		for (int i = 0; i < medicos.size(); i++) {
			Medico d = medicos.get(i);
			String especialidadM = d.getEspecialidad();
			if (especialidadM.equals(especialidad)) {
				c = d;
				break;
			}
		}
		return c;
	}

	public void printPacientes() {
		Iterator<Medico> it = medicos.iterator();
		while (it.hasNext()) {
			it.next().listarPacientes();
		}
	}

	public ArrayList<Medico> listaEspecialistas(String esp) {
		this.espec = new ArrayList<Medico>();
		Iterator<Medico> it = medicos.iterator();
		while (it.hasNext()) {
			Medico mc = it.next();
			if (mc.getEspecialidad().equals(esp)) {
				espec.add(mc);
			}
		}
		return espec;
	}

	public void printEspecialistas(ArrayList<Medico> especialistas) {
		Iterator<Medico> it = especialistas.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
