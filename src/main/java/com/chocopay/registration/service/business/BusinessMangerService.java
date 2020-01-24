package com.chocopay.registration.service.business;

import com.chocopay.registration.base.entity.Business;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Service
public class BusinessMangerService {

    private final BusinessManager businessManager;

    @Autowired
    public BusinessMangerService(BusinessManager businessManager) {
        this.businessManager = businessManager;
    }

    public Business saveBusiness(Business business) {
        if (business == null) {
            return null;
        }
        if (!CollectionUtils.isEmpty(business.getUsers()) &&
                business.getUsers().size() >= 1) {
            return businessManager.save(business);
        }
        return null;
    }

    public Business getBusiness(Long businessId) {
        return businessManager.getBusiness(businessId);
    }

    public Boolean removeBusiness(Long businessId) {
        businessManager.removeBusiness(businessId);
        return true;
    }

    public List<Business> getAllBusiness() {
        return businessManager.getAllBusiness();
    }
}
