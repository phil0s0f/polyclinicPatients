package com.polyclinicpatients.polyclinicPatients.rep;

import com.polyclinicpatients.polyclinicPatients.models.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisitRepository extends CrudRepository<Visit, Long> {
    //TODO: придется переделать модели Doctor, Patient
    //List<Visit> findByPatient_Id_patient(Long id);
    List<Visit> findByPatient_Idp(Long id);
    List<Visit> findByDoctor_Idd(Long id);
}
