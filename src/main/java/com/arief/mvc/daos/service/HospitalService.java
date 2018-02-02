package com.arief.mvc.daos.service;

import com.arief.mvc.daos.HospitalDAO;
import com.arief.mvc.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class HospitalService implements GenericeService<Hospital,String>{


    @Autowired
    private HospitalDAO hospitalDAO;
    @Autowired
    private TransactionTemplate template;

    public void save(final Hospital hospital) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                hospitalDAO.save(hospital);
            }
        });
    }

    public List<Hospital> getAll() {
        return template
                .execute(new TransactionCallback<List<Hospital>>() {
                    public List<Hospital> doInTransaction(TransactionStatus transactionStatus) {
                        return hospitalDAO.getAll();
                    }
                });
    }

    public Hospital getOne(final String s) {
        return template.execute(new TransactionCallback<Hospital>() {
            public Hospital doInTransaction(TransactionStatus transactionStatus) {
                return hospitalDAO.getOne(s);
            }
        });
    }

    public void delete(Hospital hospital) {
        // not implemented yet ...
    }
}
