package com.diaprev.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diaprev.patient.domain.Patient;
import com.diaprev.patient.service.PatientService;

import javax.validation.Valid;

@Controller
public class PatientController {

	@Autowired
    private PatientService patientService;

    @RequestMapping("/patient/list")
    public String home(Model model)
    {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patient/list";
    }

    @GetMapping("/patient/add")
    public String addPatient(Patient patient) {
        return "patient/add";
    }

    @PostMapping("/patient/validate")
    public String validate(@Valid Patient patient, BindingResult result, Model model) {
        if (!result.hasErrors()) {
        	patientService.savePatient(patient);
            model.addAttribute("patients", patientService.getAllPatients());
            return "redirect:/patient/list";
        }
        return "patient/add";
    }

    @GetMapping("/patient/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	Patient patient = patientService.getPatient(id);
        model.addAttribute("patient", patient);
        return "patient/update";
    }

    @PostMapping("/patient/update/{id}")
    public String updatePatient(@PathVariable("id") Integer id, @Valid Patient patient,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "patient/update";
        }
        patient.setId(id);
        patientService.savePatient(patient);
        model.addAttribute("patients", patientService.getAllPatients());
        return "redirect:/patient/list";
    }

    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") Integer id, Model model) {
    	patientService.deletePatient(id);
        model.addAttribute("patients", patientService.getAllPatients());
        return "redirect:/patient/list";
    }
    
    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView mav = new ModelAndView();
        String errorMessage= "You are not authorized for the requested data.";
        mav.addObject("errorMsg", errorMessage);
        mav.setViewName("403");
        return mav;
    }
}
