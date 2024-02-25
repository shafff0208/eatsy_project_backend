package com.example.eatsy_project_backend.controller;

import com.example.eatsy_project_backend.model.DeliveryPartner;
import com.example.eatsy_project_backend.service.DeliveryPartnerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/DeliveryPartners")

public class DeliveryPartnerController {


    @Autowired
    DeliveryPartnerServiceInterface partnerservice;


    @GetMapping("/allDeliveryPartners")
    public List<DeliveryPartner> findAllPartners() {
        return partnerservice.getAllPartners();


    }

    @GetMapping("/getDeliveryPartnerById/{id}")
    public DeliveryPartner findPartnerById(@PathVariable(value = "id") int partnerid) {
        return partnerservice.getPartnerByPartnerId(partnerid);


    }

    @PostMapping("/addDeliveryPartner")
    public DeliveryPartner findPartnerByPartnerNo(@RequestBody DeliveryPartner partner) {
        return partnerservice.addPartner(partner);

    }

    @PutMapping("/updateDeliveryPartner")
    public DeliveryPartner updatePartner(@RequestBody DeliveryPartner partner) {
        return partnerservice.updatePartner(partner);
    }


    @DeleteMapping("/deleteDeliveryPartnerById/{id}")
    public void deletePartner(@PathVariable int id) {
        partnerservice.deletePartnerById(id);

    }

}
