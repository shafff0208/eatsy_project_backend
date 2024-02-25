package com.example.eatsy_project_backend.repository;

import com.example.eatsy_project_backend.model.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DeliveryPartnerRepo extends JpaRepository<DeliveryPartner, Integer> {

    Optional<DeliveryPartner> findByPartnerNo(String partnerNo);

    Optional<String> deleteByPartnerNo(String partnerNo);

}
