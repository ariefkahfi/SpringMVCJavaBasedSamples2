package com.arief.mvc.controllers;

import com.arief.mvc.daos.service.HospitalService;
import com.arief.mvc.entity.Hospital;
import com.arief.mvc.entity.HospitalDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/hospital-director")
public class HospitalDirectorController {


    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/form-hospital-director",method = RequestMethod.GET)
    public String formViewGET(Model m){
        m.addAttribute("hospitalList",hospitalService.getAll());
        return "hospital-director/form-hospital-director";
    }

    @RequestMapping(value = "/form-hospital-director",method = RequestMethod.POST)
    public String formViewPOST(Map<String ,String > requestParam, ModelMap mm){

        Hospital getOne = hospitalService.getOne(requestParam.get("director_hospital"));

        HospitalDirector hd = new HospitalDirector();
        hd.setDirectorName(requestParam.get("director_name"));
        hd.setHospital(getOne);

        mm.put("result","save data hospital's director success");
        mm.put("obj",hd);
        return "result/success";
    }
}
