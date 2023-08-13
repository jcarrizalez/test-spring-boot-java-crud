package com.sitgem.test.springcrud.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sitgem.test.springcrud.models.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
