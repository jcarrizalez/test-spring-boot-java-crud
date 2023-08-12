package com.springboot.crud.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud.models.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
