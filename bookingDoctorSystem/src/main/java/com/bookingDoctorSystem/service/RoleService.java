package com.bookingDoctorSystem.service;

import com.bookingDoctorSystem.entity.Role;

public interface RoleService {
	    Role getDefaultRole();

	    Role getRoleByAuthority(String authority);
}
