import java.util.ArrayList;
import java.util.Iterator;

public class Especialidades {

	public ArrayList<String> especialidad;

	public Especialidades() {
		especialidad = new ArrayList<String>();

//		especialidad.add("dermatología");
//		especialidad.add("cardiología");
//		especialidad.add("neumología");
//		especialidad.add("pediatría");
//		especialidad.add("traumatología");
	}

	public void addEspecialidad(String espec) {
		especialidad.add(espec);
	}

	public int tamaño() {
		return especialidad.size();
	}

	public void print() {
		Iterator<String> it = especialidad.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public boolean existeEspecialidad(String espec) {
		boolean e = false;
		Iterator<String> it = especialidad.iterator();
		while (it.hasNext()) {
			if (it.next().equals(espec)) {
				e = true;
			}
		}
		return e;
	}

	public ArrayList<String> especialidades() {
		return this.especialidad;
	}

	public void borrarEspecialidad(String esp) {
		especialidad.remove(esp);
	}

}
