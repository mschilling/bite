package com.move4mobile.bite.application.repository;

import com.move4mobile.bite.application.model.Order;
import com.move4mobile.bite.unscanned.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Wilco Wolters on 04/07/2016.
 */
@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {

}
