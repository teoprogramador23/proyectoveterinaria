package app.domain.services;

import app.domain.models.MedicationRequest;
import app.ports.MedicationPort;
import java.util.List;

public class MedicationService {
    private final MedicationPort medicationPort;

    public MedicationService(MedicationPort medicationPort) {
        this.medicationPort = medicationPort;
    }

    public void requestMedication(long userId, String medicationName) {
        MedicationRequest request = new MedicationRequest(userId, medicationName, "PENDIENTE");
        medicationPort.saveRequest(request);
        System.out.println("Solicitud enviada para " + medicationName + ".");
    }

    public void approveRequest(long requestId) {
        MedicationRequest request = medicationPort.findById(requestId);
        if (request != null && request.getStatus().equals("PENDIENTE")) {
            request.setStatus("APROBADO");
            medicationPort.updateRequest(request);
            System.out.println("Solicitud aprobada.");
        } else {
            System.out.println("No se puede aprobar esta solicitud.");
        }
    }

    public List<MedicationRequest> getPendingRequests() {
        return medicationPort.findPendingRequests();
    }
}
