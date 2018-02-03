package com.arief.mvc.controllers;

import com.arief.mvc.daos.service.DoctorService;
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
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/doctor")
public class DoctorController {


    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private DoctorService doctorService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.setValidator(new DoctorValidator());
    }


    @RequestMapping(value = "/form-doctor",method = RequestMethod.GET)
    public String formDoctorGET(Model m){
        m.addAttribute("doctor",new Doctor());
        m.addAttribute("doctorList",doctorService.getAll());
        m.addAttribute("hospitalList",hospitalService.getAll());
        return "doctor/form-doctor";
    }

    @RequestMapping(value = "/form-doctor",method = RequestMethod.POST)
    public String formDoctorPOST(@RequestParam  Map<String,String> requestParam, ModelMap mm){
        Doctor d =  new Doctor();
        d.setDoctorId(requestParam.get("doctor_id"));
        d.setDoctorName(requestParam.get("doctor_name"));
        d.setHospitalList(new ArrayList<Hospital>());

        Hospital getOne = hospitalService.getOne(requestParam.get("doctor_hospital"));

        d.getHospitalList().add(getOne);

        doctorService.save(d);


        mm.put("result","save data success");
        mm.put("obj",d);
        return "result/success";
    }


    @RequestMapping("/delete/{doctor_id}")
    public String deleteDoctor(@PathVariable("doctor_id")String doctorId){
        Doctor getOne = doctorService.getOne(doctorId);
        doctorService.delete(getOne);
        return "redirect:/doctor/form-doctor";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addDoctorToNewHospital(@RequestParam Map<String,String> map , ModelMap mm){
        Hospital getOne = hospitalService.getOne(map.get("_hospital_id"));
        boolean isAdded = doctorService.addNewHospitalToDoctor(map.get("_doctor_id"), getOne);

        if(isAdded){
            mm.addAttribute("result","update data success");
        }else{
            mm.addAttribute("result","update data fail , data exists");
        }

        return "result/success";
    }
}
