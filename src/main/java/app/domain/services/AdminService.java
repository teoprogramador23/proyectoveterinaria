package app.domain.services;

import app.domain.models.InvoiceHeader;
import app.domain.models.Veterinarian;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.InvoiceHeaderPort;
import app.ports.VeterinarianPort;
import app.ports.PersonPort;
import app.ports.UserPort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdminService {
    
   private PersonPort personPort;
   private UserPort userPort;
   private VeterinarianPort veterinarianPort;
   private InvoiceHeaderPort invoiceHeaderPort;

   public void registerVeterinarian(Veterinarian veterinarian) throws Exception {
      if (personPort.existsPerson(veterinarian.getDocument())) {
         throw new Exception("A person with this document already exists");
      }
      if (userPort.existsUserName(veterinarian.getUserName())) {
         throw new Exception("This username is already registered");
      }
      veterinarian.setRole("veterinarian");
      veterinarian.setSalary(50000);
      veterinarian.setSpecialty("General");
      personPort.savePerson(veterinarian);
      userPort.saveUser(veterinarian);
      veterinarianPort.saveVeterinarian(veterinarian);
   }

   public List<InvoiceHeader> getInvoices(Person person) throws Exception {
      if (person == null) {
         return invoiceHeaderPort.getAllInvoices();
      }
      person = personPort.findByDocument(person.getDocument());
      if (person == null) {
         throw new Exception("No person found with this document");
      }
      User user = userPort.findByPersonId(person);
      if (user == null) {
         throw new Exception("No associated user found");
      }
      if (user.getRole().equals("veterinarian")) {
         Veterinarian veterinarian = veterinarianPort.findByUserId(user.getUserId());
         if (veterinarian == null) {
            throw new Exception("Error validating veterinarian");
         }
         return invoiceHeaderPort.getInvoicesByVeterinarian(veterinarian);
      }
      return invoiceHeaderPort.getInvoicesByPerson(person);
   }

   public void promoteToSpecialist() throws Exception {
      int countSpecialists = veterinarianPort.countSpecialists();
      if (countSpecialists >= 5) {
         throw new Exception("No available slots for specialist promotion");
      }
      List<Veterinarian> veterinarians = veterinarianPort.getByStatusPending();
      if (veterinarians.isEmpty()) {
         throw new Exception("No veterinarians requesting specialist promotion");
      }
      for (Veterinarian veterinarian : veterinarians) {
         double total = invoiceHeaderPort.getTotalEarnings(veterinarian);
         veterinarian.setTotalEarnings(total);
      }
      List<Veterinarian> sortedVeterinarians = veterinarians.stream()
         .sorted(Comparator.comparing(Veterinarian::getTotalEarnings))
         .collect(Collectors.toList());

      for (Veterinarian veterinarian : sortedVeterinarians) {
         int newCountSpecialists = veterinarianPort.countSpecialists();
         if (newCountSpecialists >= 5) {
            veterinarianPort.updateStatusToGeneral();
            throw new Exception("No more slots available for specialists");
         }
         veterinarianPort.updateStatus(veterinarian);
      }
   }
}

