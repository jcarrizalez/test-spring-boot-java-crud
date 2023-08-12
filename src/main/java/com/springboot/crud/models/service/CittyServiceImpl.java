package com.springboot.crud.models.service;

import java.util.List;

import com.springboot.crud.models.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.models.repository.CityRespository;

@Service
public class CittyServiceImpl implements CityService {

	@Autowired
	private CityRespository cityRepository;
	
	@Override
	public List<City> findAll() {
		
		return (List<City>) cityRepository.findAll();
	}

}
