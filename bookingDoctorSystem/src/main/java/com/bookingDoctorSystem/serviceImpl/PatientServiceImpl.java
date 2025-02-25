package com.bookingDoctorSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingDoctorSystem.entity.Doctor;
import com.bookingDoctorSystem.entity.Patient;
import com.bookingDoctorSystem.entity.User;
import com.bookingDoctorSystem.model.validationModel.EditPatientModel;
import com.bookingDoctorSystem.model.validationModel.PatientRegistrationModel;
import com.bookingDoctorSystem.model.validationModel.UserRegistrationModel;
import com.bookingDoctorSystem.model.viewModel.PatientBasicViewModel;
import com.bookingDoctorSystem.model.viewModel.PatientViewModel;
import com.bookingDoctorSystem.repository.PatientRepository;
import com.bookingDoctorSystem.service.DoctorService;
import com.bookingDoctorSystem.service.PatientService;
import com.bookingDoctorSystem.service.UserService;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    private ModelMapper modelMapper;

    private UserService userService;

    private DoctorService doctorService;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper,
                              UserService userService, DoctorService doctorService) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.doctorService = doctorService;
    }

	@Override
	public void create(PatientRegistrationModel registrationModel) {
		 UserRegistrationModel userRegistrationModel = this.modelMapper.map(registrationModel, UserRegistrationModel.class);
	        String DEFAULT_PATIENT_ROLE = "ROLE_PATIENT";
	        userRegistrationModel.setAdditionalRole(DEFAULT_PATIENT_ROLE);
	        User user = this.userService.register(userRegistrationModel);

	        Doctor doctor = this.doctorService.getById(registrationModel.getDoctor());
	        Patient patient = this.modelMapper.map(registrationModel, Patient.class);
	        patient.setUser(user);
	        patient.setDoctor(doctor);

	        this.patientRepository.saveAndFlush(patient);
		
	}

	@Override
	public void save(EditPatientModel editPatientModel) {
		Patient currentPatient = this.patientRepository.findOne(editPatientModel.getId());
        Patient patient = this.modelMapper.map(editPatientModel, Patient.class);

        patient.setUser(currentPatient.getUser());
        patient.setDoctor(currentPatient.getDoctor());

        this.patientRepository.saveAndFlush(patient);		
	}

	@Override
	public PatientViewModel getById(long id) {
		Patient patient = this.patientRepository.findOne(id);

        return this.modelMapper.map(patient, PatientViewModel.class);
	}

	@Override
	public Patient getByUserId(long userId) {
        return this.patientRepository.findOneByUserId(userId);	
	}

	@Override
	public EditPatientModel getEditModelByUserId(long userId) {
		Patient patient = this.patientRepository.findOneByUserId(userId);

        return this.modelMapper.map(patient, EditPatientModel.class);
	}

	@Override
	public PatientBasicViewModel getBasicById(long id) {
		Patient patient = this.patientRepository.getOne(id);

        return this.modelMapper.map(patient, PatientBasicViewModel.class);
	}

	@Override
	public List<PatientBasicViewModel> getPatientsByDoctorId(long doctorId) {
		List<Patient> patients = this.patientRepository.findAllByDoctorId(doctorId);
        List<PatientBasicViewModel> patientBasicViewModels = new ArrayList<>();
        for (Patient patient : patients) {
            PatientBasicViewModel patientBasicViewModel = this.modelMapper.map(patient, PatientBasicViewModel.class);
            patientBasicViewModels.add(patientBasicViewModel);
        }

        return patientBasicViewModels;
	}
}