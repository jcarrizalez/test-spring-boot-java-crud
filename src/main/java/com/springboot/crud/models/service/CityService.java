package com.springboot.crud.models.service;

import java.util.List;

import com.springboot.crud.models.entity.City;

public interface CityService {
	List<City> findAll();
}
