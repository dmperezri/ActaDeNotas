import java.io.IOException;
import java.util.Scanner;

public class ActaDeNotas {

    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarPrograma();
    }

    static void iniciarPrograma() {
        System.out.println("\tBienvenido a ACTA de Notas\n");
        ingresarDatosGenerales();
    }

    public static void limpiarpantalla() {
        // Limpia la pantalla
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al limpiar la pantalla: " + ex.getMessage());
        }
    }

    static void ingresarDatosGenerales() {
        // Captura de datos generales del curso
        System.out.print("\tIngrese el nombre del Curso: ");
        String curso = lector.nextLine().toUpperCase();
        limpiarpantalla();

        System.out.print("\tIngrese el periodo lectivo: ");
        String periodo = lector.nextLine().toUpperCase();
        limpiarpantalla();

        System.out.print("\tIngrese la Carrera: ");
        String carrera = lector.nextLine().toUpperCase();
        limpiarpantalla();

        System.out.print("\tIngrese la Modalidad: ");
        String modalidad = lector.nextLine().toUpperCase();
        limpiarpantalla();

        int codigoCurso = obtenerEnteroPositivo("\tIngrese el c\u00F3digo de Curso: ");
        lector.nextLine(); // Limpiar el buffer de entrada
        limpiarpantalla();

        System.out.print("\tIngrese el Grupo: ");
        String grupo = lector.nextLine().toUpperCase();
        limpiarpantalla();

        System.out.print("\tIngrese el c\u00F3digo de Asignatura: ");
        String codigoAsignatura = lector.nextLine();
        limpiarpantalla();

       
        int programaAsignatura = obtenerEnteroPositivo("\tIngrese el c\u00F3digo de programa de asignatura: ");
        int cantidadEstudiantes = obtenerEnteroEnRango("\tIngrese la cantidad de Estudiantes: ", 1, 40);
        lector.nextLine(); // Limpiar el buffer de entrada

        // Mostrar información general del curso
        System.out.println();
        System.out.println("\t---------------------------------------------------------"
                + "\n\t|               Informaci\u00F3n General                     |"
                + "\n\t---------------------------------------------------------");
        System.out.printf("\t| %-20s | %-30s |\n", "Curso", curso);
        System.out.printf("\t| %-20s | %-30s |\n", "Periodo Lectivo", periodo);
        System.out.printf("\t| %-20s | %-30s |\n", "Carrera", carrera);
        System.out.printf("\t| %-20s | %-30s |\n", "Modalidad", modalidad);
        System.out.printf("\t| %-20s | %-30d |\n", "C\u00F3digo de Curso", codigoCurso);
        System.out.printf("\t| %-20s | %-30s |\n", "Grupo", grupo);
        System.out.printf("\t| %-20s | %-30s |\n", "C\u00F3digo de Asignatura", codigoAsignatura);
        System.out.printf("\t| %-20s | %-30d |\n", "C\u00F3digo de Programa", programaAsignatura);
        System.out.println("\t---------------------------------------------------------");

        System.out.println();
        ingresarDatosEstudiantes(cantidadEstudiantes);
    }

    // Método para obtener un entero positivo con validación
    static int obtenerEnteroPositivo(String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = lector.nextInt();
                if (numero >= 0) {
                    break;
                } else {
                    System.out.println("No se permite n\u00FAmero negativo.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un n\u00FAmero v\u00E1lido.");
                lector.nextLine(); // Limpiar el buffer de entrada
            }
        }
        return numero;
    }

    // Método para obtener un entero en un rango específico con validación
    static int obtenerEnteroEnRango(String mensaje, int minimo, int maximo) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = lector.nextInt();
                if (numero >= minimo && numero <= maximo) {
                    break;
                } else {
                    System.out.println("N\u00FAmero fuera de rango. Debe estar entre " + minimo + " y " + maximo + ".");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un n\u00FAmero v\u00E1lido.");
                lector.nextLine(); // Limpiar el buffer de entrada
            }
        }
        return numero;
    }

    // Método para ingresar y procesar datos de estudiantes
    static void ingresarDatosEstudiantes(int cantidadEstudiantes) {
        System.out.println("\n\t------------------------------------------------------------------------------------------------------");
        System.out.println("\t|                                    Registro de Notas Estudiantes                                    |");
        System.out.println("\t------------------------------------------------------------------------------------------------------");
        System.out.printf("\t| %-4s | %-30s | %-8s | %-8s | %-8s | %-10s | %-7s |\n", "No.", "Nombre", "Parcial 1",
                "Parcial 2", "Sistem\u00E1ticos", "Nota Final", "Estado");

        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("\n\t------------------------------------------------------------------------------------------------------");
            System.out.printf("\t| %-4d ", (i + 1));

            System.out.print("\t| Ingrese el Apellidos y Nombres del Estudiante: ");
            String nombres = lector.nextLine().toUpperCase();
            limpiarpantalla();

            double primerParcial = obtenerNota("\tIngrese la Nota del Primer Parcial (0-35): ", 0, 35);
            limpiarpantalla();
            double segundoParcial = obtenerNota("\tIngrese la Nota del Segundo Parcial (0-35): ", 0, 35);
            limpiarpantalla();
            double sistematicos = obtenerNota("\tIngrese la Nota de Sistem\u00E1ticos (0-30): ", 0, 30);
            limpiarpantalla();

            double notaFinal = primerParcial + segundoParcial + sistematicos;

            if (notaFinal < 60) {
                double convocatoria = obtenerNota("\tIngrese la Nota de la Primera Convocatoria (0-70): ", 0, 70);
                notaFinal = sistematicos + convocatoria;
                if (notaFinal < 60) {
                    double segundaConvocatoria = obtenerNota("\tngrese la Nota de la Segunda Convocatoria (0-100): ", 0,
                            100);
                    notaFinal = segundaConvocatoria;
                }
            }

            lector.nextLine(); // Limpiar el buffer de entrada

            String estado = notaFinal >= 60 ? "Aprobado" : "Reprobado";

            System.out.printf("\t| %-30s | %-8.2f | %-8.2f | %-8.2f | %-10.2f | %-7s |\n", nombres, primerParcial,
                    segundoParcial, sistematicos, notaFinal, estado);
            
        }

        System.out.println("\n\t------------------------------------------------------------------------------------------------------");
  
        System.out.print("\n¿Desea usar la aplicaci\u00F3n nuevamente? (si/no): ");
        String reiniciar = lector.nextLine();
        if (reiniciar.equalsIgnoreCase("si")) {
            iniciarPrograma();
        } else {
            System.out.println("\t¡Gracias por usar nuestra aplicaci\u00F3n!");
        }
    }

    static double obtenerNota(String mensaje, int min, int max) {
        double nota;
        while (true) {
            try {
                System.out.print(mensaje);
                nota = lector.nextDouble();
                if (nota >= min && nota <= max) {
                    break;
                } else {
                    System.out.println("\tNota inv\u00E1lida. Debe estar entre " + min + " y " + max + ".");
                }
            } catch (Exception e) {
                System.out.println("\tPor favor, ingrese un n\u00FAmero v\u00E1lido.");
                lector.nextLine();
            }
        }
        lector.nextLine();
        return nota;
    }
}
