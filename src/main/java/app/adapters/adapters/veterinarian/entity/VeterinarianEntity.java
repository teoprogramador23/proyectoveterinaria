package app.adapters.veterinarian.entity;

import app.domain.models.Veterinarian;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "veterinarian")
@Setter
@Getter
@NoArgsConstructor
public class VeterinarianEntity {
   public VeterinarianEntity(Veterinarian veterinarian) {
      this.veterinarianId = veterinarian.getVeterinarianId();
      this.salary = veterinarian.getSalary();
      this.specialty = veterinarian.getSpecialty();
      this.dateHired = veterinarian.getDateHired();
      this.totalEarnings = veterinarian.getTotalEarnings();
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private long veterinarianId;
   
   @Column(name = "salary")
   private double salary;
   
   @Column(name = "specialty")
   private String specialty;
   
   @Column(name = "date_hired")
   private Timestamp dateHired;
   
   @Column(name = "total_earnings")
   private double totalEarnings;
}
