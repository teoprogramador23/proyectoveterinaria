package app;

import app.domain.services.AuthService;
import app.domain.services.AdminService;
import app.domain.services.MedicationService;
import app.menu.Menu;
import app.adapters.user.UserAdapter;
import app.adapters.medication.MedicationAdapter;
import app.adapters.partner.PartnerAdapter;
import app.adapters.medication.repository.MedicationRequestRepository;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService(new UserAdapter());
        MedicationService medicationService = new MedicationService(new MedicationAdapter(new MedicationRequestRepository()));
        AdminService adminService = new AdminService(new UserAdapter(), new PartnerAdapter());

        Menu menu = new Menu(authService, medicationService, adminService);
        menu.iniciar();
    }
}
