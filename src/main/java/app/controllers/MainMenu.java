import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("---- Menú Principal ----");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Solicitar medicamentos con certificado del veterinario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();  

            switch (option) {
                case 1:
                    logIn(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    requestMedications(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 4);
    }

    private static void logIn(Scanner scanner) {
        System.out.println("Iniciar sesión");
        System.out.print("Ingrese su correo: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();
        
        System.out.println("Bienvenido, " + email);
    }

    private static void register(Scanner scanner) {
        System.out.println("Registrarse");
        System.out.print("Ingrese su nombre completo: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese su correo: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();
        
        System.out.println("Usuario registrado con éxito.");
    }

    private static void requestMedications(Scanner scanner) {
        System.out.println("Solicitar medicamentos");
        System.out.print("Ingrese la receta del veterinario: ");
        String prescription = scanner.nextLine();
        System.out.println("Medicamento solicitado con éxito.");
    }
}
