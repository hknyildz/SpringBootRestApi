package com.hknyildz.SpringBootRestApi.purchasingSpecialist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ps")
public class PurchasingSpecialistController {

    private final PurshacingSpecialistService purshacingSpecialistService;

    @Autowired
    public PurchasingSpecialistController(PurshacingSpecialistService purshacingSpecialistService) {
        this.purshacingSpecialistService = purshacingSpecialistService;
    }

    @GetMapping
    public List<PurchasingSpecialist> getAllPs() {
        return purshacingSpecialistService.getAllPs();
    }

    @PostMapping
    public ResponseEntity<PurchasingSpecialist> getNewPs(@RequestBody PurchasingSpecialist purchasingSpecialist) {
        return new ResponseEntity<>(purshacingSpecialistService.addPs(purchasingSpecialist), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public void deletePs(@PathVariable("id") Long id) {
        purshacingSpecialistService.deletePs(id);
    }

}
