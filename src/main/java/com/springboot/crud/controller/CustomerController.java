package com.springboot.crud.controller;

import java.util.List;

import javax.validation.Valid;

import com.springboot.crud.models.entity.City;
import com.springboot.crud.models.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.crud.models.service.CityService;
import com.springboot.crud.models.service.CustomerService;

@Controller
@RequestMapping("/views/clientes")
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	@Autowired
	private CityService cityService;

	@GetMapping("")
	public String index(Model model) {
		List<Customer> customers = customerService.findAll();

		model.addAttribute("title", "Lista de cliente");
		model.addAttribute("customers", customers);

		return "/views/clientes/listar";
	}

	@GetMapping("/create")
	public String create(Model model) {

		Customer customer = new Customer();
		List<City> cities = cityService.findAll();

		model.addAttribute("title", "Formulario: Nuevo cliente");
		model.addAttribute("customer", customer);
		model.addAttribute("cities", cities);

		return "/views/clientes/frmCrear";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Customer customer, BindingResult result,
					   Model model, RedirectAttributes attribute) {
		List<City> cities = cityService.findAll();

		if (result.hasErrors()) {
			model.addAttribute("title", "Formulario: Nuevo cliente");
			model.addAttribute("customer", customer);
			model.addAttribute("cities", cities);
			System.out.println("Existieron errores en el formulario");
			return "/views/clientes/frmCrear";
		}

		customerService.save(customer);
		System.out.println("Cliente guardado con exito!");
		attribute.addFlashAttribute("success", "Cliente guardado con exito!");
		return "redirect:/views/clientes/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes attribute) {
			
		Customer customer = null;
		
		if (id > 0) {
			customer = customerService.findById(id);
			
			if (customer == null) {
				System.out.println("Error: El ID del cliente no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del cliente no existe!");
				return "redirect:/views/clientes/";
			}
		}else {
			System.out.println("Error: Error con el ID del cliente");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del cliente");
			return "redirect:/views/clientes/";
		}
		
		List<City> cities = cityService.findAll();

		model.addAttribute("title", "Formulario: Editar cliente");
		model.addAttribute("customer", customer);
		model.addAttribute("cities", cities);

		return "/views/clientes/frmCrear";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attribute) {

		Customer customer = null;
		
		if (id > 0) {
			customer = customerService.findById(id);
			
			if (customer == null) {
				System.out.println("Error: El ID del cliente no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del cliente no existe!");
				return "redirect:/views/clientes/";
			}
		}else {
			System.out.println("Error: Error con el ID del cliente");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del cliente!");
			return "redirect:/views/clientes/";
		}

		customerService.delete(id);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "redirect:/views/clientes/";
	}

}
