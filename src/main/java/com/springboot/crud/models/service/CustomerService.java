package com.springboot.crud.models.service;

import java.util.List;

import com.springboot.crud.models.entity.Customer;

public interface CustomerService
{
	public List<Customer> findAll();
	public Customer findById(Long id);
	public void save(Customer customer);
	public void delete(Long id);
}
