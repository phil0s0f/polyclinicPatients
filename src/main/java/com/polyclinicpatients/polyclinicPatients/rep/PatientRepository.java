package com.polyclinicpatients.polyclinicPatients.rep;

import com.polyclinicpatients.polyclinicPatients.models.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
