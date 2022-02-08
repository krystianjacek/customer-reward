package com.jacek.customerreward.webapp.backend.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jacek.customerreward.webapp.backend.dao.entity.CustomerEntity;
import com.jacek.customerreward.webapp.backend.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
