package app.domain.services;

import app.domain.models.Partner;
import app.domain.models.User;
import app.ports.PartnerPort;
import app.ports.UserPort;
import java.util.List;

public class AdminService {
    private final UserPort userPort;
    private final PartnerPort partnerPort;

    public AdminService(UserPort userPort, PartnerPort partnerPort) {
        this.userPort = userPort;
        this.partnerPort = partnerPort;
    }

    public void manageUsers() {
        List<User> users = userPort.getAllUsers();
        System.out.println("Lista de usuarios:");
        for (User user : users) {
            System.out.println(user.getUserName() + " - " + user.getRole());
        }
    }

    public void approveMedicationRequests(MedicationService medicationService) {
        List<MedicationRequest> pendingRequests = medicationService.getPendingRequests();
        if (pendingRequests.isEmpty()) {
            System.out.println("No hay solicitudes pendientes.");
            return;
        }
        for (MedicationRequest request : pendingRequests) {
            medicationService.approveRequest(request.getRequestId());
        }
    }

    public void promoteVipPartners() {
        List<Partner> pendingPartners = partnerPort.getByStatusPending();
        for (Partner partner : pendingPartners) {
            partner.setStatus("VIP");
            partnerPort.updateStatus(partner);
            System.out.println("Socio promovido a VIP: " + partner.getUserId());
        }
    }
}
