package com.hknyildz.SpringBootRestApi.bill;

import com.hknyildz.SpringBootRestApi.dto.BillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bill")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getBills() {
        return new ResponseEntity<>(billService.getBills(), HttpStatus.OK);
    }

    @RequestMapping(value = "/accepted", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> getAllAcceptedBills() {
        return new ResponseEntity<>(billService.getAllAcceptedBills(), HttpStatus.OK);
    }

    @RequestMapping(value = "/accepted/{owner_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> getAcceptedBills(@PathVariable Long owner_id) {
        return new ResponseEntity<>(billService.getAcceptedBills(owner_id), HttpStatus.OK);
    }

    @RequestMapping(value = "/declined", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> getAllDeclinedBills() {
        return new ResponseEntity<>(billService.getAllDeclinedBills(), HttpStatus.OK);
    }

    @RequestMapping(value = "/declined/{owner_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> getDeclinedBills(@PathVariable Long owner_id) {
        return new ResponseEntity<>(billService.getDeclinedBills(owner_id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String, String> registerBill(@RequestBody BillDto bill) {
        return billService.addNewBill(bill);
    }

    @DeleteMapping(path = "{billId}")
    public void deleteBill(@PathVariable("billId") Long id) {
        billService.deleteBill(id);
    }

}

