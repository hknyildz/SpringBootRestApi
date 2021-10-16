package com.hknyildz.SpringBootRestApi.bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {


    Optional<Bill> findById(Long id);

    @Query(value = "SELECT SUM(amount) FROM Bill b WHERE b.accepted=true AND owner_id = :owner_id", nativeQuery = true)
    Integer countAmountById(@Param("owner_id") Long owner_id);

    @Query(value = "SELECT bill_no FROM Bill b WHERE owner_id = :owner_id", nativeQuery = true)
    List<String> getBillNo(@Param("owner_id") Long owner_id);

    @Query(value = "SELECT * FROM Bill b WHERE b.accepted=true AND owner_id = :owner_id", nativeQuery = true)
    List<Bill> getAcceptedBills(@Param("owner_id") Long owner_id);

    @Query(value = "SELECT * FROM Bill b WHERE b.accepted=false AND owner_id = :owner_id", nativeQuery = true)
    List<Bill> getDeclinedBills(@Param("owner_id") Long owner_id);

    @Query(value = "SELECT * FROM Bill b WHERE b.accepted=true ", nativeQuery = true)
    List<Bill> getAllAcceptedBills();

    @Query(value = "SELECT * FROM Bill b WHERE b.accepted=false ", nativeQuery = true)
    List<Bill> getAllDeclinedBills();


}
