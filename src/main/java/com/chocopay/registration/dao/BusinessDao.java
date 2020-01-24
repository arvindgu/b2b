package com.chocopay.registration.dao;

import com.chocopay.registration.base.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessDao extends JpaRepository<Business, Long> {
}
