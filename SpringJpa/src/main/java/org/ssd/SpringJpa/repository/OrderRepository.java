package org.ssd.SpringJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssd.SpringJpa.entity.OrderEntity;

public interface OrderRepository  extends JpaRepository<OrderEntity, Long>{

	
	
	
}
