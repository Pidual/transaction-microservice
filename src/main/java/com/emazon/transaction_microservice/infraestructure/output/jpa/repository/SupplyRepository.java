package com.emazon.transaction_microservice.infraestructure.output.jpa.repository;


import com.emazon.transaction_microservice.infraestructure.output.jpa.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {

    SupplyEntity findById(String name);


}
