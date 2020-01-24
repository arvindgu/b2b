package com.chocopay.registration;

import com.chocopay.registration.base.entity.Business;
import com.chocopay.registration.base.entity.User;
import com.chocopay.registration.helper.CommonUtils;
import com.chocopay.registration.service.business.BusinessMangerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@Slf4j
class RegistrationApplicationTests {

    @Autowired
    private BusinessMangerService businessMangerService;

    @Test
    void contextLoads() {
    }

    @Test
    void businessTest() {
        Business business = businessMangerService.saveBusiness(getNewBusiness());
        log.info(business.toString());

        log.info(CommonUtils.objToString(business));

        Business getBusiness = businessMangerService.getBusiness(business.getId());
        log.info(CommonUtils.objToString(getBusiness));

        Business business2 = businessMangerService.saveBusiness(getNewBusiness());
        log.info(business2.toString());

        log.info(CommonUtils.objToString(business2));

        Business getBusiness2 = businessMangerService.getBusiness(business2.getId());
        log.info(CommonUtils.objToString(getBusiness2));

    }

    private Business getNewBusiness() {
        Business business = new Business();
        business.setAddress("Address1");
        business.setCompanyName("Company Name 1");
        business.setEmail("email.com");
        business.setGstin("GSTIN");
        business.setLandLine("3434343434");
        business.setMobile("3434343434");
        List<User> users = new ArrayList<>();
        users.add(getNewUser());
        users.add(getNewUser());
        business.setUsers(users);
        return business;
    }

    private User getNewUser() {
        User user = new User();
        user.setUserName(UUID.randomUUID().toString());
        user.setEmail("Email");
        user.setMobile("3443344334");
        user.setPassword("password");
        return user;
    }

}
