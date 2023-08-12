package com.springboot.crud.models.repository;

import com.springboot.crud.models.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRespository extends CrudRepository<City, Long> {

}
