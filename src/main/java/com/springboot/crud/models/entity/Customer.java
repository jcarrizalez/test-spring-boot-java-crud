package com.springboot.crud.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String last_name;
	@NotEmpty
	@Pattern(regexp="[0-9]{10}")
	private String phone;
	@NotEmpty
	@Email
	private String email;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", last_name=" + last_name + ", phone=" + phone
				+ ", email=" + email + ", city=" + city + "]";
	}
}
