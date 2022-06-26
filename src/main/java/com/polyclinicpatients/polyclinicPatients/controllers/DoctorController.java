package com.polyclinicpatients.polyclinicPatients.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {
    @GetMapping("/doctor")
    public String doctorMain(Model model) {
        return "doctor-main";
    }
}
