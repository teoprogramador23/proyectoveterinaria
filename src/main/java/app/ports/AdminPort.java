package app.ports;

import app.domain.models.Admin;

public interface AdminPort {
    void registerAdmin(Admin admin);
    void approveMedicationRequest(Long requestId);
    void promotePartnerToVIP(Long partnerId);
}
