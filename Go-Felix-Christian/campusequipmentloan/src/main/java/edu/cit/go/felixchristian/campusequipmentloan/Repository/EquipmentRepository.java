package edu.cit.go.felixchristian.campusequipmentloan.Repository;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    public Equipment findByName(String name);
    public List<Equipment> findByAvailabilityTrue();
}
