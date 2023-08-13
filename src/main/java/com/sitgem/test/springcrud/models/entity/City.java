package com.sitgem.test.springcrud.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;

	public City(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
}
