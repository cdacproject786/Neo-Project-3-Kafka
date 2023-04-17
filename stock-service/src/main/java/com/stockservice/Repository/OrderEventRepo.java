package com.stockservice.Repository;

import com.stockservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEventRepo extends JpaRepository<Order,Integer> {
}
