import java.util.HashMap;

public class ListaHospitales {

	HashMap<Integer, Hospital> hospitales;
	HashMap<Integer, String> passwords;
	private int ID = 0;

	public ListaHospitales() {
		hospitales = new HashMap<Integer, Hospital>();
		passwords = new HashMap<Integer, String>();
	}

	public HashMap<Integer, Hospital> getHospitales() {
		return hospitales;
	}

	public void addHospital(Hospital h) {

		if (hospitales.containsValue(h)) {
			System.out.println("El hospital ya existe \n");
		} else {
			ID++;
			hospitales.put(ID, h);
			passwords.put(ID, h.getContraseña());
		}
	}

	public int tamaño() {
		return hospitales.size();
	}

	public void printHospitales() {
		for (int i = 1; i <= hospitales.size(); i++) {
			System.out.println(i + "- " + hospitales.get(i).printHospital());
		}
	}

	public boolean comprobarContraseña(int ID, String contraseña) {
		boolean aux = false;
		if (passwords.get(ID).equals(contraseña)) {
			System.out.println("Contraseña correcta \n");
			aux = true;
		} else
			System.out.println("Contraseña incorrecta \n");

		return aux;
	}

	public void borrarHospital(int ID, String contraseña) {
		String aux = passwords.get(ID);
		if (aux.equals(contraseña)) {
			hospitales.remove(ID);
			passwords.remove(ID);
			System.out.println("El hospital se ha borrado correctamente \n");
			for (int i = ID; i <= hospitales.size(); i++) {
				if (hospitales.containsKey(ID + 1)) {
					hospitales.put(ID, hospitales.get(ID + 1));
					passwords.put(ID, hospitales.get(ID + 1).getContraseña());
					hospitales.remove(ID + 1);
					passwords.remove(ID + 1);
				}
			}
		} else
			System.out.println("Contraseña erronea \n");
	}

	public Hospital obtenerHospital(int ID) {
		return hospitales.get(ID);
	}

}
