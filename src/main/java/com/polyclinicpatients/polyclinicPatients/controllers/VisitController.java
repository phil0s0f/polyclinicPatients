package com.polyclinicpatients.polyclinicPatients.controllers;

import com.polyclinicpatients.polyclinicPatients.rep.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VisitController {
    @Autowired
    private VisitRepository visitRepository;
    //TODO: доработать контроллер Visit
}
