package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.model.DeliveryPartner;
import com.example.eatsy_project_backend.repository.DeliveryPartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class DeliveryPartnerServiceImp implements DeliveryPartnerServiceInterface {

    @Autowired
    DeliveryPartnerRepo partnerRepo;

    public List<DeliveryPartner> getAllPartners() {
        List<DeliveryPartner> result = new ArrayList<>();
        Iterable<DeliveryPartner> it = partnerRepo.findAll();
        it.forEach(result::add);
        return result;

    }

    public DeliveryPartner getPartnerByPartnerId(int id) {
        return partnerRepo.findById(id).get();
    }

    public DeliveryPartner addPartner(DeliveryPartner p) {
        return partnerRepo.save(p);

    }

    public DeliveryPartner updatePartner(DeliveryPartner p) {

        DeliveryPartner existingDeliveryPartner = partnerRepo.findByPartnerNo(p.getPartnerNo()).orElse(null);
        existingDeliveryPartner.setPartnerName(p.getPartnerName());
        existingDeliveryPartner.setVehicleNo(p.getVehicleNo());

        return partnerRepo.save(existingDeliveryPartner);
    }


    public void deletePartnerById(int id) {
        partnerRepo.deleteById(id);
    }


}












