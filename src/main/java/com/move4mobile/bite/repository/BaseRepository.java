package com.move4mobile.bite.repository;

import com.move4mobile.bite.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Wilco Wolters on 04/07/2016.
 */
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
