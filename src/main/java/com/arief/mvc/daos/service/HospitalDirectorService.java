package com.arief.mvc.daos.service;

import com.arief.mvc.daos.HospitalDirectorDAO;
import com.arief.mvc.entity.HospitalDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;


@Service
public class HospitalDirectorService implements GenericeService<HospitalDirector,Integer>{


    @Autowired
    private TransactionTemplate template;
    @Autowired
    private HospitalDirectorDAO hospitalDirectorDAO;

    public void save(final HospitalDirector hospitalDirector) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                hospitalDirectorDAO.save(hospitalDirector);
            }
        });
    }

    public List<HospitalDirector> getAll() {
        return template.execute(new TransactionCallback<List<HospitalDirector>>() {
            public List<HospitalDirector> doInTransaction(TransactionStatus transactionStatus) {
                return hospitalDirectorDAO.getAll();
            }
        });
    }

    public HospitalDirector getOne(final Integer integer) {
        return template.execute(new TransactionCallback<HospitalDirector>() {
            public HospitalDirector doInTransaction(TransactionStatus transactionStatus) {
                return hospitalDirectorDAO.getOne(integer);
            }
        });
    }

    public void delete(final HospitalDirector hospitalDirector) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                hospitalDirectorDAO.delete(hospitalDirector);
            }
        });
    }
}
