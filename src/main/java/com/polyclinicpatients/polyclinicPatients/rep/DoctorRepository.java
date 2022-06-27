package com.polyclinicpatients.polyclinicPatients.rep;

import com.polyclinicpatients.polyclinicPatients.models.Doctor;
import org.springframework.data.repository.CrudRepository;

import javax.print.Doc;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
