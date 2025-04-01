package app.ports;

import app.domain.models.MedicationRequest;
import java.util.List;

public interface MedicationPort {
    void saveRequest(MedicationRequest request);
    MedicationRequest findById(long requestId);
    void updateRequest(MedicationRequest request);
    List<MedicationRequest> findPendingRequests();
}
