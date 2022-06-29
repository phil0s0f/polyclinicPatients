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
import java.util.List;
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
    public String visitPostAdd(@RequestParam String date_visit, @RequestParam String time_visit, Patient patient, Doctor doctor, Model model){
        Visit visit = new Visit(date_visit,time_visit, patient, doctor);
        visitRepository.save(visit);
        //TODO: доработать контроллер Visit, не работает добавление записи
        return "redirect:/patient";
    }
    @GetMapping("/visit")
    public String patientMain(Model model) {
        Iterable<Visit> visits = visitRepository.findAll();
        model.addAttribute("visits", visits);
        return "visit-main";
    }
    @GetMapping("/visit/patient/{id}")
    public String patientDetails(@PathVariable(value = "id") long id, Model model) {
        //TODO: возможно это должно быть в контроллере Visit, и показывать данные поциента и насколько он к кому записан
        if (!patientRepository.existsById(id)) {
            return "redirect:/patient";
        }
        List<Visit> visit = visitRepository.findByPatient_Idp(id);
        model.addAttribute("visit", visit);
        return "visit-patient";
    }
    @PostMapping("/visit/{id}/remove")
    public String patientPostDelete(@PathVariable(value = "id") long id, Model model){
        Visit visit = visitRepository.findById(id).orElseThrow();
        visitRepository.delete(visit);
        return "redirect:/visit";
    }
}
