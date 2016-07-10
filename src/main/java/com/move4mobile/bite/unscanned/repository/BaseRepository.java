package com.move4mobile.bite.unscanned.repository;

import com.move4mobile.bite.application.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Wilco Wolters on 04/07/2016.
 */
//This interface is in the unscanned package, because for some reason Spring will try to generate a bean named
//  baseRepository, even though this repository is not annotated at all.
//  The creation fails, because BaseEntity is an interface, thus unmanaged. Turning BaseEntity into an abstract class
//  does not work either, as it will have to be managed, which is impossible without a key.
public interface BaseRepository<T extends BaseEntity<Key>, Key extends Serializable> extends JpaRepository<T, Key> {
}
