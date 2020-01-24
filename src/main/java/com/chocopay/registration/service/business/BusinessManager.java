package com.chocopay.registration.service.business;

import com.chocopay.registration.base.entity.Business;
import com.chocopay.registration.dao.BusinessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BusinessManager {

    private final BusinessDao businessDao;

    @Autowired
    public BusinessManager(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    @Transactional
    public Business save(Business business) {
        return businessDao.save(business);
    }

    @Transactional(readOnly = true)
    public Business getBusiness(Long businessId) {
        return businessDao.findById(businessId).orElse(null);
    }

    @Transactional
    public void removeBusiness(Long businessId) {
        businessDao.deleteById(businessId);
    }

    @Transactional(readOnly = true)
    public List<Business> getAllBusiness() {
        return businessDao.findAll();
    }
}
