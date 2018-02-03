package com.arief.mvc.controllers;

import com.arief.mvc.daos.service.HospitalService;
import com.arief.mvc.entity.Doctor;
import com.arief.mvc.entity.Hospital;
import com.arief.mvc.validator.HospitalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping("/hospital")
public class HospitalController {


    @Autowired
    private HospitalService hospitalService;


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(new HospitalValidator());
    }

    @RequestMapping(value = "/form-hospital",method = RequestMethod.GET)
    public String hospitalFormGET(Model m){
        m.addAttribute("hospital",new Hospital());
        return "hospital/form-hospital";
    }

    @RequestMapping(value = "/form-hospital",method = RequestMethod.POST)
    public String hospitalFormPOST(@Validated @ModelAttribute("hospital")Hospital h , BindingResult bindingResult, ModelMap mm){
        h.setDoctorList(new ArrayList<Doctor>());
        if(bindingResult.hasErrors())
            return  "hospital/form-hospital";

        hospitalService.save(h);

        mm.addAttribute("result","save data hospital success");
        mm.addAttribute("obj",h);
        return "result/success";
    }
}
