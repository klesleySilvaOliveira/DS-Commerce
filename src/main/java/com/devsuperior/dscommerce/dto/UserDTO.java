package com.devsuperior.dscommerce.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dscommerce.entities.User;

public class UserDTO {

	private Long id;
	private String email;
	private String name;
	private String phone;
	private LocalDate birthDate;
	private List<String> roles = new ArrayList<>();
	
	public UserDTO(User user) {
		id = user.getId();
		email = user.getEmail();
		name = user.getName();
		phone = user.getPhone();
		birthDate = user.getBirthDate();		
		user.getRoles().stream().map(x -> this.roles.add(x.getAuthority())).toList();
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public List<String> getRoles() {
		return roles;
	}
	
}
