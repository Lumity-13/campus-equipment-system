package edu.cit.go.felixchristian.campusequipmentloan.Controller;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Equipment;
import edu.cit.go.felixchristian.campusequipmentloan.Service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipment")
public class EquipmentController {

    private final EquipmentService equipServ;

    @Autowired
    public EquipmentController(EquipmentService equipServ) {
        this.equipServ = equipServ;
    }

    @PostMapping
    public Equipment saveEquipment(@RequestBody Equipment equipment) {
        return equipServ.saveEquipment(equipment);
    }

    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipServ.getAllEquipment();
    }

    @GetMapping("/available")
    public List<Equipment> getAvailableEquipment() {
        return equipServ.getAvailableEquipment();
    }
}
