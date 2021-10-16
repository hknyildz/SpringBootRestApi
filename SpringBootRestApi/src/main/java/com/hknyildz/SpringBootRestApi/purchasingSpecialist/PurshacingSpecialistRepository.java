package com.hknyildz.SpringBootRestApi.purchasingSpecialist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurshacingSpecialistRepository extends JpaRepository<PurchasingSpecialist,Long> {

    Optional<PurchasingSpecialist> findByEmail(String email);
}
