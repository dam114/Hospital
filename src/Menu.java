import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		//Serán tablas de la base de datos:
		ListaMedicos medicos = new ListaMedicos();
		ListaPacientes pacientes = new ListaPacientes();
		ListaPacientes pacientesSinAtender = new ListaPacientes();
		ListaPacientes pacientesAtendidos = new ListaPacientes();
		ListaHospitales hospitales = new ListaHospitales();
		
		Hospital hospital;

		Scanner teclado = new Scanner(System.in);
		int opMenu, menu, numHospital;
		String opMod1, opMod2, numMenu, password;

		System.out.println("BIENVENIDO A 'EMPRESA HOSPITALES'. \n" + "EN ESTE MOMENTO DISPONEMOS DE "
				+ hospitales.tamaño() + " HOSPITALES DONDE PODER ATENDERLE \n");

		do {
			hospitales.printHospitales();
			System.out.println("8- Nuevo Hospital");
			System.out.println("9- Borrar Hospital");
			System.out.println("ELIJA EL HOSPITAL QUE QUIERE GESTIONAR");
			System.out.println("INSERTE UN NÚMERO:");
			menu = Integer.parseInt(teclado.nextLine());

			switch (menu) {

			case 8:
				Especialidades especialidad = new Especialidades();
				System.out.println("Inserte el nombre del hospital: ");
				String nombre = teclado.nextLine();
				System.out.println("Inserte una contraseña: ");
				String contraseña = teclado.nextLine();

				do {
					System.out.println("Inserte especialidad: ");
					String nuevaEspecialidad = teclado.nextLine();
					especialidad.addEspecialidad(nuevaEspecialidad);
					System.out.println("Desea añadir mas especialidades s/n:");
					numMenu = teclado.nextLine();
				} while (numMenu.equals("s") || numMenu.equals("S"));

				hospital = new Hospital(nombre, contraseña, especialidad);
				hospitales.addHospital(hospital);
				break;
			case 9:
				System.out.println("Inserte el numero de hospital: ");
				hospitales.printHospitales();
				numHospital = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduzca la contraseña: ");
				password = teclado.nextLine();
				hospitales.borrarHospital(numHospital, password);
				break;

			default:

				System.out.println("Introduzca la contraseña: ");
				password = teclado.nextLine();
				if (hospitales.comprobarContraseña(menu, password)) {

					hospital = hospitales.obtenerHospital(menu);

					do {

						System.out.println("1. Dar de alta un paciente");
						System.out.println("2. Dar de alta un medico");
						System.out.println("3. Modificar paciente");
						System.out.println("4. Modificar medico");
						System.out.println("5. Listar pacientes...");
						System.out.println("6. Listar medicos");
						System.out.println("7. Dar de baja un medico");
						System.out.println("8. Atender paciente");
						System.out.println("9. Especialidades de nuestro hospital [Info]");
						System.out.println("10. Nueva especialidad");
						System.out.println("11. Salir");

						System.out.println("Elija una opción \n");

						try {
							opMenu = Integer.parseInt(teclado.nextLine());

							switch (opMenu) {

							case 1:
								// Comprobar formatos de numeros:
								System.out.println("Introduzca el nombre del paciente: ");
								String nombre_P = teclado.nextLine();
								System.out.println("Introduzca el apellido: ");
								String apellido_P = teclado.nextLine();
								System.out.println("Introduzca el DNI: ");
								String DNI_P = teclado.nextLine();
								System.out.println("Introduzca el Numero de la Seguridad Social: ");
								String NSS = teclado.nextLine();
								System.out.println("Introduzca el Telefono de contacto: ");
								String telefono = teclado.nextLine();
								System.out.println("Introduzca la dolencia del paciente: ");
								String dolencia = teclado.nextLine();

								Paciente p = new Paciente(DNI_P, nombre_P, apellido_P, NSS, telefono, dolencia);
								pacientes.addPaciente(p);
								System.out.println("El paciente se ha añadido correctamente. \n");

								break;

							case 2:

								System.out.println("Introduzca el nombre del médico: ");
								String nombre_M = teclado.nextLine();
								System.out.println("Introduzca el apellido: ");
								String apellido_M = teclado.nextLine();
								System.out.println("Introduzca el DNI: ");
								String DNI_M = teclado.nextLine();
								System.out.println("Introduzca la especialidad: ");
								String espec = teclado.nextLine();

								Medico m = new Medico(DNI_M, nombre_M, apellido_M, espec);

								if (hospital.getEspecialidades().existeEspecialidad(espec)) {
									medicos.addMedico(m);
									System.out.println("El medico se ha añadido correctamente. \n");
								} else
									System.out.println("Este hospital no dispone de esa especialidad. \n");

								break;

							case 3:

								System.out.println("Indicar el DNI del paciente que desea modificar: ");
								String DNI_mod = teclado.nextLine();

								Paciente p_mod = pacientes.existePaciente(DNI_mod);

								if (p_mod != null) {

									System.out.println(p_mod.toString());

									do {

										System.out.println("1. Modificar Nombre");
										System.out.println("2. Modificar Apellido");
										System.out.println("3. Modificar DNI");
										System.out.println("4. Modificar NSS");
										System.out.println("5. Modificar telefono");
										System.out.println("6. Modificar dolencia");
										System.out.println("7. Exit");
										System.out.println("Indica lo que desea modificar: ");

										int op_modificar_P = Integer.parseInt(teclado.nextLine());

										switch (op_modificar_P) {
										case 1:
											System.out.println("Introduzca el nuevo nombre: ");
											nombre_P = teclado.nextLine();
											p_mod.setNombre(nombre_P);
											break;
										case 2:
											System.out.println("Introduzca el nuevo apellido: ");
											apellido_P = teclado.nextLine();
											p_mod.setApellido(apellido_P);
											break;
										case 3:
											System.out.println("Introduzca el nuevo DNI: ");
											DNI_P = teclado.nextLine();
											p_mod.setDNI(DNI_P);
											break;
										case 4:
											System.out.println("Introduzca el nuevo Número de la Seguridad Social: ");
											NSS = teclado.nextLine();
											p_mod.setNSS(NSS);
											break;
										case 5:
											System.out.println("Introduzca el nuevo telefono: ");
											telefono = teclado.nextLine();
											p_mod.setTelefono(telefono);
											break;
										case 6:
											System.out.println("Introduzca la nueva dolencia: ");
											dolencia = teclado.nextLine();
											p_mod.setDolencia(dolencia);
											break;
										default:
											break;
										}

										System.out.println("Desea modificar mas datos s/n: ");
										opMod1 = teclado.nextLine();

									} while (opMod1.equals("s") || opMod1.equals("S"));

								} else {
									System.out.println("No existe ningún paciente con ese DNI. \n");
								}

								break;

							case 4:

								System.out.println("Indicar el DNI del medico que desea modificar: ");
								DNI_mod = teclado.nextLine();

								Medico m_mod = medicos.existeMedico(DNI_mod);

								if (m_mod != null) {

									System.out.println(m_mod.toString());

									do {

										System.out.println("1. Modificar Nombre");
										System.out.println("2. Modificar Apellido");
										System.out.println("3. Modificar DNI");
										System.out.println("4. Modificar especialidad");
										System.out.println("5. Exit");
										System.out.println("Indica lo que desea modificar: ");

										int op_modificar_P = Integer.parseInt(teclado.nextLine());

										switch (op_modificar_P) {
										case 1:
											System.out.println("Introduzca el nuevo nombre: ");
											nombre_P = teclado.nextLine();
											m_mod.setNombre(nombre_P);
											break;
										case 2:
											System.out.println("Introduzca el nuevo apellido: ");
											apellido_P = teclado.nextLine();
											m_mod.setApellido(apellido_P);
											break;
										case 3:
											System.out.println("Introduzca el nuevo DNI: ");
											DNI_P = teclado.nextLine();
											m_mod.setDNI(DNI_P);
											break;
										case 4:
											System.out.println("Introduzca la nueva especialidad: ");
											espec = teclado.nextLine();
											if (hospital.getEspecialidades().existeEspecialidad(espec)) {
												m_mod.setEspecialidad(espec);
											} else
												System.out.println(
														"No se puede modificar la especialidad, este hospital no dispone de ella.");

											break;
										default:
											break;
										}

										System.out.println("Desea modificar mas datos s/n: ");
										opMod2 = teclado.nextLine();

									} while (opMod2.equals("s") || opMod2.equals("S"));
								} else {
									System.out.println("No existe ningún medico con ese DNI. \n");
								}

								break;

							case 5:
								System.out.println("5.1 Listar todos los pacientes atendidos");
								System.out.println("5.2 Listar pacientes atendidos por un médico");
								System.out.println("5.3 Listar pacientes en espera");
								System.out.println("5.4 Listar pacientes que no han podido ser atendidos");
								System.out.println("Elija una opción: ");
								int opListar = Integer.parseInt(teclado.nextLine());

								switch (opListar) {

								case 1:
									pacientesAtendidos.print();
									break;
								case 2:
									System.out.println("Introducir el DNI del medico: ");
									String DNI_listar = teclado.nextLine();
									Medico m_listar = medicos.existeMedico(DNI_listar);
									if (m_listar != null) {
										m_listar.listarPacientes();
									} else
										System.out.println("No existe ningun medico con ese DNI");

									break;
								case 3:
									pacientes.print();
									break;
								case 4:
									pacientesSinAtender.print();
									break;
								}

								System.out.println("\n");
								break;

							case 6:
								medicos.print();
								System.out.println("\n");
								break;

							case 7:
								System.out.println("Introduce el DNI del medico que desea borrar: ");
								DNI_M = teclado.nextLine();
								if (medicos.existeMedico(DNI_M) != null) {
									medicos.borrarPorDNI(DNI_M);
									System.out.println("El medico se ha borrado correctamente. \n");
								} else
									System.out.println("No existe ningún médico con ese DNI. \n");

								break;

							case 8:
								System.out.println("Siguiente paciente: ");
								Paciente atender = pacientes.siguientePaciente();
								System.out.println(atender.toString());

								if (hospital.getEspecialidades().existeEspecialidad(atender.getDolencia())) {
									ArrayList<Medico> mEspecialistas = medicos
											.listaEspecialistas(atender.getDolencia());
									System.out.println("El paciente será atendido por el medico: ");
									int aleatorio = (int) (Math.random() * mEspecialistas.size() + 0);
									mEspecialistas.get(aleatorio).atenderPaciente(atender);
									pacientes.borrarPorDNI(atender.getDNI());
								} else {
									System.out.println("El paciente no puede ser atendido actualmente. \n");
									pacientesSinAtender.addPaciente((atender));
									pacientes.borrarPorDNI(atender.getDNI());
								}
								System.out.println("\n");
								break;

							case 9:
								System.out.println("Las especialidades del hospital son: \n");
								ArrayList<String> especialidades = hospital.getEspecialidades().especialidades();
								for (int i = 0; i < especialidades.size(); i++) {
									String esp = especialidades.get(i);
									ArrayList<Medico> mEsp = medicos.listaEspecialistas(esp);
									if (mEsp.size() != 0) {
										System.out.println(esp + " cubierta por los medicos: \n");
										medicos.printEspecialistas(mEsp);
									}
								}
								ArrayList<Paciente> nocubiertas = pacientesSinAtender.listaPacientes();
								if (nocubiertas.size() != 0) {
									System.out.println("Las especialidades no cubiertas son: \n");
									for (int i = 0; i < nocubiertas.size(); i++) {
										System.out.println(nocubiertas.get(i).getDolencia());
									}
								}
								break;

							case 10:
								System.out.println("Introduce la nueva especialidad: ");
								String es_nueva = teclado.nextLine();
								hospital.addEspecialidad(es_nueva);
								break;

							}
						} catch (Exception e) {
							System.out.println("Comando introducido no valido. \n");
							opMenu = 0;
						}

					} while (opMenu != 11);
				}

				break;

			}

		} while (menu <= hospitales.tamaño() || menu == 8 || menu == 9);

		teclado.close();
	}
}
