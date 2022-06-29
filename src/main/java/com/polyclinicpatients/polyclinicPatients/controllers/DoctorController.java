package com.polyclinicpatients.polyclinicPatients.controllers;

import com.polyclinicpatients.polyclinicPatients.models.Doctor;
import com.polyclinicpatients.polyclinicPatients.models.Visit;
import com.polyclinicpatients.polyclinicPatients.rep.DoctorRepository;
import com.polyclinicpatients.polyclinicPatients.rep.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private VisitRepository visitRepository;
    @GetMapping("/doctor")
    public String doctorMain(Model model) {
        Iterable<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors", doctors);
        return "doctor-main";
    }
    @GetMapping("/doctor/add")
    public String doctorAdd(Model model) {
        return "doctor-add";
    }
    @PostMapping("/doctor/add")
    public String doctorPostAdd(@RequestParam String fio,@RequestParam String spec, Model model){
        Doctor doctor = new Doctor(fio, spec);
        doctorRepository.save(doctor);
        return "redirect:/doctor";
    }
    @GetMapping("/doctor/{id}")
    public String doctorDetails(@PathVariable(value = "id") long id, Model model) {
        if (!doctorRepository.existsById(id)) {
            return "redirect:/doctor";
        }
        Optional<Doctor> doctor = doctorRepository.findById(id);
        ArrayList<Doctor> res = new ArrayList<>();
        doctor.ifPresent(res::add);
        model.addAttribute("doctor", res);
        List<Visit> visit = visitRepository.findByDoctor_Idd(id);
        model.addAttribute("visit", visit);
        return "doctor-details";
    }
    @GetMapping("/doctor/{id}/edit")
    public String doctorEdit(@PathVariable(value = "id") long id, Model model) {
        if (!doctorRepository.existsById(id)) {
            return "redirect:/doctor";
        }
        Optional<Doctor> doctor = doctorRepository.findById(id);
        ArrayList<Doctor> res = new ArrayList<>();
        doctor.ifPresent(res::add);
        model.addAttribute("doctor", res);
        return "doctor-edit";
    }
    @PostMapping("/doctor/{id}/edit")
    public String doctorPostUpdate(@PathVariable(value = "id") long id,@RequestParam String fio,@RequestParam String spec, Model model){
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setFio(fio);
        doctor.setSpec(spec);
        doctorRepository.save(doctor);
        return "redirect:/doctor";
    }
    @PostMapping("/doctor/{id}/remove")
    public String doctorPostDelete(@PathVariable(value = "id") long id, Model model){
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctorRepository.delete(doctor);
        return "redirect:/doctor";
    }
}
