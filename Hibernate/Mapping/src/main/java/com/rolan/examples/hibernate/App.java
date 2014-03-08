package com.rolan.examples.hibernate;

import com.rolan.examples.hibernate.entities.ContractEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ContractRepository repository = context.getBean(ContractRepository.class);
        repository.save(new ContractEntity());

        ContractEntity contract = repository.findOne(1L);
        System.out.println(contract.getId());
    }
}
