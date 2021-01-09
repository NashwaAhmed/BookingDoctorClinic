package com.bookingDoctorSystem.service;

import java.util.List;

import com.bookingDoctorSystem.entity.SettlePoint;
import com.bookingDoctorSystem.model.viewModel.SettlePointViewModel;

public interface SettlePointService
{
	 List<SettlePointViewModel> getAll();

	 SettlePoint getById(long id);
}
