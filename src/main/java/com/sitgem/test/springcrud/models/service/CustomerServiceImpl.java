package com.sitgem.test.springcrud.models.service;

import java.util.List;

import com.sitgem.test.springcrud.models.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitgem.test.springcrud.models.repository.CustomerRepository;

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
