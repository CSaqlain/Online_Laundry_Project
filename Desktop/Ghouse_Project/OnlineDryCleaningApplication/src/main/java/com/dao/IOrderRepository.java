package com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Order;



@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

}

