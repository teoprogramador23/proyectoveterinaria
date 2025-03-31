package app.adapters.medicalorder;

import app.domain.models.MedicalOrder;
import app.ports.MedicalOrderPort;
import java.util.List;

public class MedicalOrderAdapter implements MedicalOrderPort {
    private MedicalOrderRepository medicalOrderRepository;

    @Override
    public void saveMedicalOrder(MedicalOrder medicalOrder) {
        MedicalOrderEntity entity = new MedicalOrderEntity(medicalOrder);
        medicalOrderRepository.save(entity);
        medicalOrder.setMedicalOrderId(entity.getMedicalOrderId());
    }

    @Override
    public List<MedicalOrder> getAllMedicalOrders() {
        return medicalOrderRepository.findAll().stream()
                .map(MedicalOrderEntity::toModel)
                .toList();
    }
}

