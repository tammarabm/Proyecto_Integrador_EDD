
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
 
public class Helper {
	
 
    //region Static Objects
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    //endregion
    
    
    
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
                if (numero >= 0 && numero < 99) {
                    return numero;
                } else {
                    System.out.println("Error!!! No es una edad valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar el DNI sin puntos y/o comas.");
            }
        }
    }
    
    public static int validarDiagnosticoPreliminar(Scanner entrada, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                	if ((1 == numero) && (numero == 2)) {
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
    
    public static int validarDia(Scanner entrada, String mensaje) {
    	int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (1 <= numero && numero <= 31) {
                    return numero;
                } else {
                    System.out.println("Error!!! Ingrese un dia valido. Ejemplo: 27");
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
                    System.out.println("Error!!! Ingrese un mes valido. Ejemplo: 10");
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
                if ((1000 <= numero) && (numero <= 2024)) {
                    return numero;
                } else {
                    System.out.println("Error!!! Ingrese un año valido. Ejemplo: 2004");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un año.");
            }
        }
    }
	
    public static String validarEspecialidad(Scanner entrada, String mensaje) {
    	String tramite;
    	while (true) {
			System.out.println(mensaje);
			tramite =  (entrada.nextLine().toLowerCase());
			if (tramite.equals("cirujano")) {
				return tramite;
			} else if (tramite.equals("clínica general")) {
				return tramite;
			} else {
				System.out.println("Error!!! La especialidad tiene que ser 'cirujano' o 'clinica general' ");
			}   			
    	}
    }	
    
    public static int validarOpcion(Scanner entrada, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                	if ((1 <= numero) && (numero <= 8)) {
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
 
    //region Character Helpers
    public static Character getCharacter(Scanner scanner, String inputMessage, String errorMessage) {
        Character characterValue;
        while (true) {
            System.out.print(inputMessage);
            try {
                characterValue = scanner.nextLine().charAt(0);
                return characterValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }
    public static Character getCharacter(Scanner scanner, String inputMessage) {
        return getCharacter(scanner, inputMessage, "Ingrese un caracter válido");
    }
    public static Character getCharacter(String inputMessage, String errorMessage) {
        return getCharacter(Helper.scanner, inputMessage, errorMessage);
    }
    public static Character getCharacter(String inputMessage) {
        return getCharacter(Helper.scanner, inputMessage, "Ingrese un caracter válido");
    }
    //endregion
 
 
    //region Integer Helpers
    public static Integer getInteger(Scanner scanner, String inputMessage, String errorMessage) {
        Integer integerValue = 0;
        while (true) {
            try {
                System.out.print(inputMessage);
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            }
            catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }
    public static Integer getInteger(Scanner scanner, String inputMessage) {
        return getInteger(scanner, inputMessage, "Ingrese un número válido");
    }
    public static Integer getInteger(String inputMessage, String errorMessage) {
        return getInteger(Helper.scanner, inputMessage, errorMessage);
    }
    public static Integer getInteger(String inputMessage) {
        return getInteger(Helper.scanner, inputMessage, "Ingrese un número válido");
    }
    //endregion
 
 
    //region Double Helpers
    public static Double getDouble(Scanner scanner, String inputMessage, String errorMessage) {
        Double doubleValue = 0.0;
        while (true) {
            try {
                System.out.print(inputMessage);
                doubleValue = Double.parseDouble(scanner.nextLine());
                return doubleValue;
            }
            catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }
    public static Double getDouble(Scanner scanner, String inputMessage) {
        return getDouble(scanner, inputMessage, "Ingrese un número válido");
    }
    public static Double getDouble(String inputMessage, String errorMessage) {
        return getDouble(Helper.scanner, inputMessage, errorMessage);
    }
    public static Double getDouble(String inputMessage) {
        return getDouble(Helper.scanner, inputMessage, "Ingrese un número válido");
    }
    //endregion
 
 
    //region Float Helpers
    public static Float getFloat(Scanner scanner, String inputMessage, String errorMessage) {
        Float floatValue = 0f;
        while (true) {
            try {
                System.out.print(inputMessage);
                floatValue = Float.parseFloat(scanner.nextLine());
                return floatValue;
            }
            catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }
    public static Float getFloat(Scanner scanner, String inputMessage) {
        return getFloat(scanner, inputMessage, "Ingrese un número válido");
    }
    public static Float getFloat(String inputMessage, String errorMessage) {
        return getFloat(Helper.scanner, inputMessage, errorMessage);
    }
    public static Float getFloat(String inputMessage) {
        return getFloat(Helper.scanner, inputMessage, "Ingrese un número válido");
    }
    //endregion
 
 
 
    //region Array Helpers
 
    static void printOneDimensionArray(String textBefore, Object[] array, String textAfter) {
        System.out.print(textBefore);
        System.out.print("[" + array[0]);
        for (int i = 1; i < array.length; ++i) {
            System.out.print("," + array[i]);
        }
        System.out.print("]");
        System.out.print(textAfter);
    }
 
 
    static void printTwoDimensionArray(String textBefore, Object[][] array, String textAfter) {
        System.out.print(textBefore);
 
        System.out.print("[[" + array[0][0]);
        for (int j = 1; j < array[0].length; ++j) {
            System.out.print("," + array[0][j]);
        }
        System.out.print("]");
 
        for (int i = 1; i < array.length; ++i) {
            System.out.print(",[" + array[i][0]);
            for (int j = 1; j < array[i].length; ++j) {
                System.out.print("," + array[i][j]);
            }
            System.out.print("]");
        }
        System.out.print("]");
        System.out.print(textAfter);
    }
    //endregion
 
 
 
    //region Enum Helpers
 
    // from http://stackoverflow.com/questions/13783295/getting-all-names-in-an-enum-as-a-string
    public static String[] getEnumNames(Class<? extends Enum<?>> e) {
        return Arrays.toString(e.getEnumConstants()).replaceAll("^.|.$", "").split(", ");
    }
 
    //endregion
 
}
