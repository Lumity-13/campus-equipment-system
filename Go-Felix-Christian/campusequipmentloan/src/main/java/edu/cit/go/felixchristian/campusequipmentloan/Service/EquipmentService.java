package edu.cit.go.felixchristian.campusequipmentloan.Service;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Equipment;
import edu.cit.go.felixchristian.campusequipmentloan.Model.Student;
import edu.cit.go.felixchristian.campusequipmentloan.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipRepo;

    @Autowired
    public EquipmentService(EquipmentRepository equipRepo) {
        this.equipRepo = equipRepo;
    }

    public Equipment postEquipment(Equipment equip) {
        return equipRepo.save(equip);
    }

    public List<Equipment> getAllEquipment() {
        return equipRepo.findAll();
    }

    public List<Equipment> getAvailableEquipment() {
        return equipRepo.findByAvailabilityTrue();
    }
}
