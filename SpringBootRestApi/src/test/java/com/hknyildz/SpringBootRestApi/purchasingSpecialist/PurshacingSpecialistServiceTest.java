package com.hknyildz.SpringBootRestApi.purchasingSpecialist;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PurshacingSpecialistServiceTest {

//    private PurshacingSpecialistService psService;
//    private PurshacingSpecialistRepository psRepository;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        psRepository = Mockito.mock(PurshacingSpecialistRepository.class);
//
//        psService = new PurshacingSpecialistService(psRepository);
//
//    }
//
//    @Test
//    public void whenCreatePsWithExistingEmail_İtShouldThrowException(){
//        //Data preparation
//        PurchasingSpecialist ps = new PurchasingSpecialist(999L,"name","surname","email");
//        PurchasingSpecialist ps1 = new PurchasingSpecialist(1000L,"name1","surname1","email");
//        //Behavioral logic due to test scenario
//        Mockito.when(psRepository.findByEmail("email")).thenReturn(Optional.of(ps1));
//
//        //Expecting results
//        assertThrows(IllegalStateException.class,()->psService.addPs(ps1));
//        Mockito.verifyNoInteractions(psRepository);
//    }


}