package com.arief.mvc.daos.service;

import com.arief.mvc.daos.DoctorDAO;
import com.arief.mvc.entity.Doctor;
import com.arief.mvc.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class DoctorService implements GenericeService<Doctor,String> {

    @Autowired
    private TransactionTemplate template;
    @Autowired
    private DoctorDAO dao;


    public void save(final Doctor doctor) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                dao.save(doctor);
            }
        });
    }

//    public void save(final Doctor doctor , final Hospital hospital){
//        template.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                List<Hospital> hospitalList = doctor.getHospitalList();
//
//                boolean isExists = false;
//
//                for(Hospital h : hospitalList){
//                    if(h.getHospitalId().equals(hospital.getHospitalId())){
//                        isExists = true;
//                        break;
//                    }
//                }
//
//                if(isExists){
//                    System.out.println("data exists");
//                }else{
//                    doctor.getHospitalList().add(hospital);
//                    System.out.println("successfully save");
//                }
//            }
//        });
//    }

    public List<Doctor> getAll() {
        return template.execute(new TransactionCallback<List<Doctor>>() {
            public List<Doctor> doInTransaction(TransactionStatus transactionStatus) {
                return dao.getAll();
            }
        });
    }

    public Doctor getOne(final String s) {
        return template.execute(new TransactionCallback<Doctor>() {
            public Doctor doInTransaction(TransactionStatus transactionStatus) {
                return dao.getOne(s);
            }
        });
    }

    public void delete(Doctor doctor) {

    }
}
