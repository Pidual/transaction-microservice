package com.emazon.transaction_microservice.infrastructure.output.jpa.repository;


import com.emazon.transaction_microservice.infrastructure.output.jpa.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {

    SupplyEntity findById(String name);


}
