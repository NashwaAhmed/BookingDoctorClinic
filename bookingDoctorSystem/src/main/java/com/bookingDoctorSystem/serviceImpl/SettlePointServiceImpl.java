package com.bookingDoctorSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingDoctorSystem.entity.SettlePoint;
import com.bookingDoctorSystem.model.viewModel.SettlePointViewModel;
import com.bookingDoctorSystem.repository.SettlePointRepository;
import com.bookingDoctorSystem.service.SettlePointService;

@Service
public class SettlePointServiceImpl implements SettlePointService {
	
    private SettlePointRepository settlePointRepository;

    private ModelMapper modelMapper;

    @Autowired
    public SettlePointServiceImpl(SettlePointRepository settlePointRepository, ModelMapper modelMapper) {
        this.settlePointRepository = settlePointRepository;
        this.modelMapper = modelMapper;
    }

	@Override
	public List<SettlePointViewModel> getAll() {
		     List<SettlePoint> settlePoints = this.settlePointRepository.findAllByOrderByName();
	        List<SettlePointViewModel> settlePointViewModels = new ArrayList<>();
	        for (SettlePoint settlePoint : settlePoints) {
	            SettlePointViewModel settlePointViewModel = this.modelMapper.map(settlePoint, SettlePointViewModel.class);
	            settlePointViewModels.add(settlePointViewModel);
	        }

	        return settlePointViewModels;
	}

	@Override
	public SettlePoint getById(long id) {
        return this.settlePointRepository.findOne(id);
	}

}
