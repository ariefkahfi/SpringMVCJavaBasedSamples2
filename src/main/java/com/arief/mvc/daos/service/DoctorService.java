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

    public boolean addNewHospitalToDoctor(final String doctorId , final Hospital newHospital){
        return template.execute(new TransactionCallback<Boolean>() {
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                Doctor getOne = dao.getOne(doctorId);

                boolean isExists = false;

                for(Hospital h : getOne.getHospitalList()){
                    if(h.getHospitalId().equals(newHospital.getHospitalId())){
                        isExists = true;
                        break;
                    }
                }

                if(isExists){
                    System.out.println("data exists....");

                    return  false;
                }else{
                    getOne.getHospitalList().add(newHospital);
                    System.out.println("data added successfully");
                    return  true;
                }
            }
        });
    }

    public void delete(final Doctor doctor) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                Doctor getOne = dao.getOne(doctor.getDoctorId());
                getOne.getHospitalList().clear();
                dao.delete(getOne);
            }
        });
    }
}
