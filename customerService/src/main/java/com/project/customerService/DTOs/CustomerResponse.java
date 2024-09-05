package com.project.customerService.DTOs;

import com.project.customerService.model.Address;

public record CustomerResponse(
	    String id,
	    String firstname,
	    String lastname,
	    String email,
	    Address address
	) {

	}
