package com.polyclinicpatients.polyclinicPatients.controllers;

import com.polyclinicpatients.polyclinicPatients.models.Patient;
import com.polyclinicpatients.polyclinicPatients.rep.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PatientController {
    //TODO: добавить шаблоны для контроллера
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patient")
    public String patientMain(Model model) {
        Iterable<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "patient-main";
    }
    @GetMapping("/patient/add")
    public String patientAdd(Model model) {
        return "patient-add";
    }
    @PostMapping("/patient/add")
    //TODO: изменить RequestParam
    public String patientPostAdd(@RequestParam String tetle, @RequestParam String anounce, @RequestParam String full_text, Model model){
        Patient patient = new Patient(tetle, anounce, full_text);
        patientRepository.save(patient);
        return "redirect:/patient";
    }
    @GetMapping("/patient/{id}")
    public String patientDetails(@PathVariable(value = "id") long id, Model model) {
        if (!patientRepository.existsById(id)) {
            return "redirect:/patient";
        }
        Optional<Patient> patient = patientRepository.findById(id);
        ArrayList<Patient> res = new ArrayList<>();
        patient.ifPresent(res::add);
        model.addAttribute("patient", res);
        return "patient-details";
    }
    @GetMapping("/patient/{id}/edit")
    public String doctorEdit(@PathVariable(value = "id") long id, Model model) {
        if (!patientRepository.existsById(id)) {
            return "redirect:/doctor";
        }
        Optional<Patient> patient = patientRepository.findById(id);
        ArrayList<Patient> res = new ArrayList<>();
        patient.ifPresent(res::add);
        model.addAttribute("patient", res);
        return "patient-edit";
    }
    @PostMapping("/patient/{id}/edit")
    //TODO: изменить RequestParam
    public String doctorPostUpdate(@PathVariable(value = "id") long id,@RequestParam String tetle,@RequestParam String anounce, @RequestParam String full_text, Model model){
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient.setTetle(tetle);
        patient.setAnounce(anounce);
        patient.setFull_text(full_text);
        patientRepository.save(patient);
        return "redirect:/patient";
    }
    @PostMapping("/patient/{id}/remove")
    public String doctorPostDelete(@PathVariable(value = "id") long id, Model model){
        Patient patient = patientRepository.findById(id).orElseThrow();
        patientRepository.delete(patient);
        return "redirect:/patient";
    }
}
