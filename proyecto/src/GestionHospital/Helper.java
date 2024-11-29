package GestionHospital;

import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class Helper {
	public static int validarEntero(Scanner entrada, String mensaje) {
        int numero;
        String valorIngresado;
        while (true) {
            try {
                System.out.println(mensaje);
                valorIngresado = entrada.nextLine();
                numero = Integer.parseInt(valorIngresado);
                break;
            } catch (Exception e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
        return numero;
    }
    
    // Método para validar un número entero no negativo
    public static int validarEnteroNoNegativo(Scanner entrada, String mensaje) {
    	int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                	return numero; 
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
	}
    
    // Método para validar un número double no negativo
    public static double validarDoubleNoNegativo(Scanner entrada, String mensaje) {
        double numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Double.parseDouble(entrada.nextLine().trim());
                if (numero >= 0) {
                    return numero;
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número de tipo double.");
            }
        }
    }
    
    public static int validarCodigo(Scanner entrada, String mensaje, Integer[] codigos) {
    	int numero;
        while (true) {
        	boolean codigoRepetido = false;
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                	for (Integer codigo : codigos) {
                		if (codigo == null) {
                			break;
                		}
                		else if (codigo == numero) {
                			codigoRepetido = true;
                			System.out.println("El codigo ya esta en uso.");
                		}
                	}
                	if (codigoRepetido == false) {
                		return numero;                		
                	}
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
	}
    
    public static Medicamento ingresarCodigo(Scanner entrada, String mensaje, SimpleLinkedList<Medicamento> medicamentosDisponibles) {
    	int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                	for (Medicamento medicamento : medicamentosDisponibles) {
                		if (medicamento.getCodigo() == numero) {
                			return medicamento;
                		}
                	}
                	System.out.println("El codigo no existe");
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
	}
    
    public static int validarStock(Scanner entrada, String mensaje) {
    	int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                	if (numero == 0) {
                		System.out.println("El stock no puede ser cero");
                	}
                	else {
                		return numero;
                	}
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
	}
    
    public static int validarDni(Scanner entrada, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 10000000 && numero < 100000000) {
                    return numero;
                } else {
                    System.out.println("Error!!! No es un DNI.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar el DNI sin puntos y/o comas.");
            }
        }
    }
    
    public static int validarEdad(Scanner entrada, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0 && numero <= 100) {
                    return numero;
                } else {
                    System.out.println("Error!!! No es una edad valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar el DNI sin puntos y/o comas.");
            }
        }
    }
    
    public static int validarDiagnosticoPreliminar() {
    	Random random = new Random();
    	return 1 + random.nextInt(2);
    }
    
    public static int validarStockMedicamento(Scanner entrada, String mensaje, Medicamento medicacionAdministrada) {
    	int numero;
    	System.out.println("Stock disponible: " + medicacionAdministrada.getStockDisponible());
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                	if (numero == 0) {
                		System.out.println("Se debe asignar una cantidad mayor a 0");
                	}
                	else {
                		if (0 <= (medicacionAdministrada.getStockDisponible() - numero)) {
                			return numero;
                		}
                		else {
                			System.out.println("El stock disponible no puede quedar en negativo");
                		}
                	}
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
	}    
    
    @SuppressWarnings("deprecation")
    public static Date ingresarFecha(Scanner scanner) {
    	int anio = Helper.validarAño(scanner, "Año: ");
		int mes = Helper.validarMes(scanner, "Mes: "); 
		int dia = Helper.validarDia(scanner, "Dia: ");
		Date fecha = new Date(anio, mes, dia);
		return fecha;
    }
    
    public static int validarDia(Scanner entrada, String mensaje) {
    	int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (1 <= numero && numero <= 31) {
                    return numero;
                } else {
                    System.out.println("Error!!! Ingrese un dia valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un dia.");
            }
        }
    }
    
    public static int validarMes(Scanner entrada, String mensaje) {
    	int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (1 <= numero && numero <= 12) {
                    return numero;
                } else {
                    System.out.println("Error!!! Ingrese un mes valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un mes.");
            }
        }
    }
    
    public static int validarAño(Scanner entrada, String mensaje) {
    	int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if ((1000 <= numero) && (numero <= 2030)) {
                    return numero;
                } else {
                    System.out.println("Error!!! Ingrese un año valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un año.");
            }
        }
    }
    
    public static int validarAñoActual(Scanner entrada, String mensaje) {
    	int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if ((2024 <= numero) && (numero <= 2030)) {
                    return numero;
                } else {
                    System.out.println("Error!!! Ingrese un año igual o mayor al actual.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un año.");
            }
        }
    }
	
    public static String validarEspecialidad(Scanner entrada, String mensaje) {
    	while (true) {
			System.out.println(mensaje);
			System.out.println("1. Cirujano ");
			System.out.println("2. Clinica General ");
			int opcion=validarOpcionEspecialidad(entrada, "Opción: " );
			if (opcion==1) {
				return "Cirujano";
			} else if (opcion==2) {
				return "Clinica General";
			} else {
				System.out.println("Error!!! La especialidad tiene que ser 'cirujano' o 'clinica general' ");
			}   			
    	}
    }	
    
    public static int validarOpcionEspecialidad(Scanner entrada, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                	if ((1 <= numero) && (numero <= 2)) {
                		return numero;
                	}else {
                		System.out.println("Error!!! Opcion invalida.");
                	}
                    
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
    }
    public static int validarOpcionMenu(Scanner entrada, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                	if ((1 <= numero) && (numero <= 7)) {
                		return numero;
                	}else {
                		System.out.println("Error!!! Opcion invalida.");
                	}
                    
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
    }
    
    public static int validarOpcionConsulta(Scanner entrada, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                	if ((1 <= numero) && (numero <= 9)) {
                		return numero;
                	}else {
                		System.out.println("Error!!! Opcion invalida.");
                	}
                    
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
    }
}
