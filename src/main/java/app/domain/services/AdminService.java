package app.domain.services;

import app.domain.models.Admin;
import app.ports.AdminPort;
import app.ports.UserPort;

public class AdminService {
    private final AdminPort adminPort;
    private final UserPort userPort;

    public AdminService(AdminPort adminPort, UserPort userPort) {
        this.adminPort = adminPort;
        this.userPort = userPort;
    }

    public void registerAdmin(Admin admin) throws Exception {
        if (userPort.existUserName(admin.getUserName())) {
            throw new Exception("Username already exists.");
        }
        adminPort.registerAdmin(admin);
    }

    public void approveMedicationRequest(Long requestId) {
        adminPort.approveMedicationRequest(requestId);
    }

    public void promotePartnerToVIP(Long partnerId) {
        adminPort.promotePartnerToVIP(partnerId);
    }
}
