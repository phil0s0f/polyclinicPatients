package com.polyclinicpatients.polyclinicPatients.controllers;

import com.polyclinicpatients.polyclinicPatients.models.Doctor;
import com.polyclinicpatients.polyclinicPatients.models.Patient;
import com.polyclinicpatients.polyclinicPatients.models.Visit;
import com.polyclinicpatients.polyclinicPatients.rep.DoctorRepository;
import com.polyclinicpatients.polyclinicPatients.rep.PatientRepository;
import com.polyclinicpatients.polyclinicPatients.rep.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class VisitController {
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/visit/add")
    public String visitAdd(Model model) {
        Iterable<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors", doctors);
        Iterable<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "visit-add";
    }
    @PostMapping("/visit/add")
    public String visitPostAdd(@RequestBody String date_visit, Patient patient, Doctor doctor, Model model){
        Visit visit = new Visit(date_visit, patient, doctor);
        visitRepository.save(visit);
        //TODO: доработать контроллер Visit, не работает добавление записи
        return "redirect:/patient";
    }
}
