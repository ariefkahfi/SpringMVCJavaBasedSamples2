package com.arief.mvc.controllers;

import com.arief.mvc.daos.service.HospitalService;
import com.arief.mvc.entity.Doctor;
import com.arief.mvc.entity.Hospital;
import com.arief.mvc.validator.DoctorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping("/doctor")
public class DoctorController {


    @Autowired
    private HospitalService hospitalService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.setValidator(new DoctorValidator());
    }


    @RequestMapping(value = "/form-doctor",method = RequestMethod.GET)
    public String formDoctorGET(Model m){
        m.addAttribute("doctor",new Doctor());
        m.addAttribute("hospitalList",hospitalService.getAll());
        return "doctor/form-doctor";
    }

    @RequestMapping(value = "/form-doctor",method = RequestMethod.POST)
    public String formDoctorPOST(@Validated @ModelAttribute("doctor") Doctor d , BindingResult bindingResult, ModelMap mm){
        d.setHospitalList(new ArrayList<Hospital>());
        if(bindingResult.hasErrors()){
            return "doctor/form-doctor";
        }else{
            mm.put("result","save data success");
            mm.put("obj",d);
            return "result/success";
        }
    }
}
