package com.rolan.examples.hibernate;

import com.rolan.examples.hibernate.entities.ContractEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<ContractEntity, Long>{
}
