package com.sitgem.test.springcrud.models.repository;

import com.sitgem.test.springcrud.models.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRespository extends CrudRepository<City, Long> {

}
