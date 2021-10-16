package com.hknyildz.SpringBootRestApi.bill;

import com.hknyildz.SpringBootRestApi.dto.BillDto;
import com.hknyildz.SpringBootRestApi.purchasingSpecialist.PurchasingSpecialist;
import com.hknyildz.SpringBootRestApi.purchasingSpecialist.PurshacingSpecialistRepository;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.text.DecimalFormat;
import java.util.*;


@Service
public class BillService {

    private static final String CURRENCY = "TR";
    private static final Long billValue = 0000L;
    private final BillRepository billRepository;
    RestTemplate restTemplate = new RestTemplate();
    @Value("${app.limit}")
    private Long limit;
    private String billValueString;

    @Autowired
    private PurshacingSpecialistRepository psRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public String decimal(long l) {
        final DecimalFormat decimalFormat = new DecimalFormat("0000");
        String fourDigitNumber = decimalFormat.format(l);
        return fourDigitNumber;
    }

    public List<Bill> getBills() {
        return billRepository.findAll();
    }

    public List<Bill> getAcceptedBills(Long id) {
        return billRepository.getAcceptedBills(id);
    }

    public List<Bill> getAllAcceptedBills() {
        return billRepository.getAllAcceptedBills();
    }

    public List<Bill> getDeclinedBills(Long id) {
        return billRepository.getDeclinedBills(id);
    }

    public List<Bill> getAllDeclinedBills() {
        return billRepository.getAllDeclinedBills();
    }

    public HashMap<String, String> addNewBill(BillDto billDto) {
        Optional<PurchasingSpecialist> psOptional = psRepository.findByEmail(billDto.getEmail());
        Bill bill = new Bill(billDto, psOptional.get());


        Long ownerId = bill.getOwner().getId();
        @Nullable
        List<String> billNo = billRepository.getBillNo(ownerId);
        List<Long> newbillnos = new ArrayList<>();
        System.out.println(billNo);
        Boolean isListNull = true;
        if (billNo.size() > 0) {
            for (int i = 0; i < billNo.size(); i++) {
                if (billNo.get(i) != null) {
                    isListNull = false;
                    String j = billNo.get(i).replace(CURRENCY, "");
                    Long longBillNo = Long.parseLong(j);
                    newbillnos.add(longBillNo);
                }
            }

            if (!isListNull) {
                String fourdigits = decimal(Collections.max(newbillnos) + 1);
                billValueString = CURRENCY + fourdigits;
            }
        } else {
            billValueString = CURRENCY + decimal(billValue + 1);
        }

        @Nullable
        Integer control = billRepository.countAmountById(ownerId);
        if (control != null) {
            if (control + bill.getAmount() > limit) {

                bill.setBillNo(billValueString);
                bill.setAccepted(false);
                billRepository.save(bill);
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "LIMIT IS NOT ENOUGH, Bill is not accepted");

            } else {
                bill.setBillNo(billValueString);
                bill.setAccepted(true);
                billRepository.save(bill);
                HashMap<String, String> map = new HashMap<>();
                map.put("name", bill.getOwner().getFirstName());
                map.put("surname", bill.getOwner().getLastName());
                map.put("amount", bill.getAmount().toString());
                map.put("billNo", bill.getBillNo());
                map.put("productName", bill.getProductName());
                map.put("isAccepted", String.valueOf(bill.getAccepted()));
                map.put("status", "201");
                return map;
            }
        } else {
            if (bill.getAmount() > limit) {
                bill.setBillNo(billValueString);
                bill.setAccepted(false);
                billRepository.save(bill);
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "LIMIT IS NOT ENOUGH, Bill is not accepted");


            } else {
                bill.setBillNo(billValueString);
                bill.setAccepted(true);
                billRepository.save(bill);
                HashMap<String, String> map = new HashMap<>();
                map.put("name", bill.getOwner().getFirstName());
                map.put("surname", bill.getOwner().getLastName());
                map.put("amount", bill.getAmount().toString());
                map.put("billNo", bill.getBillNo());
                map.put("productName", bill.getProductName());
                map.put("isAccepted", String.valueOf(bill.getAccepted()));
                map.put("status", "201");
                return map;
            }
        }
    }

    public void deleteBill(Long billId) {
        Optional<Bill> billOptional = billRepository.findById(billId);
        if (billOptional.isEmpty()) {
            throw new IllegalStateException("There is no bill with id: " + billId);
        }
        billRepository.deleteById(billId);
    }


}

