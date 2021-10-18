package com.hknyildz.SpringBootRestApi.purchasingSpecialist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurshacingSpecialistService {

    private final PurshacingSpecialistRepository psrepository;

    @Autowired
    public PurshacingSpecialistService(PurshacingSpecialistRepository psrepository) {
        this.psrepository = psrepository;
    }

    public PurchasingSpecialist addPs(PurchasingSpecialist ps) {
        Optional<PurchasingSpecialist> optional = psrepository.findByEmail(ps.getEmail());
        if (optional.isEmpty()) {
            return psrepository.save(ps);
        }
        else{
            throw new IllegalStateException("this email is already exists");
        }

    }

    public void deletePs(Long id) {
        Optional<PurchasingSpecialist> psOptional = psrepository.findById(id);
        if (psOptional.isEmpty()) {
            throw new IllegalStateException("There is no ps with id: " + id);
        }
        psrepository.deleteById(id);
    }

    public List<PurchasingSpecialist> getAllPs() {
        return psrepository.findAll();
    }


}


