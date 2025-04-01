package app.menu;

import app.domain.models.User;
import app.domain.services.AuthService;
import app.domain.services.MedicationService;
import app.domain.services.AdminService;
import java.util.Scanner;

public class Menu {
    private final AuthService authService;
    private final MedicationService medicationService;
    private final AdminService adminService;
    private final Scanner scanner;

    public Menu(AuthService authService, MedicationService medicationService, AdminService adminService) {
        this.authService = authService;
        this.medicationService = medicationService;
        this.adminService = adminService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("\n--- SISTEMA DE VETERINARIA ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> iniciarSesion();
                case 3 -> {
                    System.out.println("Saliendo del sistema...");
                    return;
                }
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    private void registrar() {
        System.out.print("Ingrese un nombre de usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese una contraseña: ");
        String contraseña = scanner.nextLine();
        System.out.print("Ingrese su rol (admin, veterinario, dueño, socio): ");
        String rol = scanner.nextLine();

        try {
            authService.registerUser(usuario, contraseña, rol);
            System.out.println("¡Usuario registrado con éxito!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void iniciarSesion() {
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        User user = authService.authenticate(usuario, contraseña);
        if (user != null) {
            System.out.println("¡Bienvenido, " + user.getUserName() + "!");
            mostrarMenuPorRol(user);
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private void mostrarMenuPorRol(User usuario) {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            switch (usuario.getRole()) {
                case "admin" -> menuAdmin();
                case "veterinarian" -> menuVeterinario();
                case "owner" -> menuDueño();
                case "partner" -> menuSocio();
                default -> System.out.println("Rol no reconocido.");
            }
        }
    }

    private void menuAdmin() {
        System.out.println("1. Gestionar usuarios");
        System.out.println("2. Aprobar solicitudes de medicamentos");
        System.out.println("3. Promover socios VIP");
        System.out.println("4. Cerrar sesión");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> adminService.manageUsers();
            case 2 -> adminService.approveMedicationRequests();
            case 3 -> adminService.promoteVipPartners();
            case 4 -> iniciar();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void menuVeterinario() {
        System.out.println("1. Ver expedientes médicos");
        System.out.println("2. Aprobar solicitudes de medicamentos");
        System.out.println("3. Cerrar sesión");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> System.out.println("Mostrando expedientes médicos...");
            case 2 -> medicationService.approveRequest();
            case 3 -> iniciar();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void menuDueño() {
        System.out.println("1. Solicitar medicamentos");
        System.out.println("2. Ver historial de mi mascota");
        System.out.println("3. Cerrar sesión");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> medicationService.requestMedication();
            case 2 -> System.out.println("Mostrando historial de la mascota...");
            case 3 -> iniciar();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void menuSocio() {
        System.out.println("1. Ver facturas");
        System.out.println("2. Cerrar sesión");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> System.out.println("Mostrando facturas...");
            case 2 -> iniciar();
            default -> System.out.println("Opción no válida.");
        }
    }
}
