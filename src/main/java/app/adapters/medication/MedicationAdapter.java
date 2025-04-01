package app.adapters.medication;

import app.adapters.medication.entity.MedicationRequestEntity;
import app.adapters.medication.repository.MedicationRequestRepository;
import app.domain.models.MedicationRequest;
import app.ports.MedicationPort;
import java.util.List;
import java.util.stream.Collectors;

public class MedicationAdapter implements MedicationPort {
    private final MedicationRequestRepository repository;

    public MedicationAdapter(MedicationRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveRequest(MedicationRequest request) {
        MedicationRequestEntity entity = new MedicationRequestEntity(request);
        repository.save(entity);
    }

    @Override
    public MedicationRequest findById(long requestId) {
        MedicationRequestEntity entity = repository.findById(requestId).orElse(null);
        return entity != null ? entity.toModel() : null;
    }

    @Override
    public void updateRequest(MedicationRequest request) {
        MedicationRequestEntity entity = new MedicationRequestEntity(request);
        repository.save(entity);
    }

    @Override
    public List<MedicationRequest> findPendingRequests() {
        return repository.findByStatus("PENDIENTE").stream()
                .map(MedicationRequestEntity::toModel)
                .collect(Collectors.toList());
    }
}
