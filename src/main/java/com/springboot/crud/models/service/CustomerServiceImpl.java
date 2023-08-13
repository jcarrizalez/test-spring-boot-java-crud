package com.springboot.crud.models.service;

import java.util.List;

import com.springboot.crud.models.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.models.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public Customer findById(Long id)  {
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id){
		customerRepository.deleteById(id);
	}

}
