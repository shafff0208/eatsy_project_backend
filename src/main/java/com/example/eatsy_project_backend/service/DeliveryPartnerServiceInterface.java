package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.model.DeliveryPartner;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DeliveryPartnerServiceInterface {

    public List<DeliveryPartner> getAllPartners();

    public DeliveryPartner getPartnerByPartnerId(int id);

    public DeliveryPartner addPartner(DeliveryPartner p);

    public DeliveryPartner updatePartner(DeliveryPartner p);

    public void deletePartnerById(int id);
}
