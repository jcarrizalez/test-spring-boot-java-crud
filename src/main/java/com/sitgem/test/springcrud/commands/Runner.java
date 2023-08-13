package com.sitgem.test.springcrud.commands;

import com.sitgem.test.springcrud.models.entity.City;
import com.sitgem.test.springcrud.models.entity.Customer;
import com.sitgem.test.springcrud.models.repository.CityRespository;
import com.sitgem.test.springcrud.models.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class Runner implements CommandLineRunner
{
    @Autowired
    private CityRespository cityRespository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception
    {
        if(this.cityRespository.count() ==  0){

            this.cityRespository.saveAll(List.of(
                    new City("Amazonas"),
                    new City("Anzoátegui"),
                    new City("Apure"),
                    new City("Aragua"),
                    new City("Barinas"),
                    new City("Bolívar"),
                    new City("Carabobo"),
                    new City("Cojedes"),
                    new City("Delta Amacuro"),
                    new City("Distrito Federal"),
                    new City("Falcón"),
                    new City("Guárico"),
                    new City("Lara"),
                    new City("Mérida"),
                    new City("Miranda"),
                    new City("Monagas"),
                    new City("Nueva Esparta"),
                    new City("Portuguesa"),
                    new City("Sucre"),
                    new City("Táchira"),
                    new City("Trujillo"),
                    new City("Vargas"),
                    new City("Yaracuy"),
                    new City("Zulia")
            ));
            System.out.println("Estados Creados");
        }
        if(this.customerRepository.count() ==  0){
           List<City> cities = (List<City>) this.cityRespository.findAll();

            Customer customer = new Customer();
            customer.setEmail("sitgem@gmail.com");
            customer.setName("Juan");
            customer.setLast_name("Carrizalez");
            customer.setPhone("1234567890");
            customer.setCity(cities.get(3));
            try{
                this.customerRepository.save(customer);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("Cliente Creado");
        }
    }
}
