package com.ml.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ml.dojoninjas.models.Ninja;


@Repository
//Repository take interface file that hold default methods for us to use in other classes
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
    // this method retrieves all the candy from the database
    List<Ninja> findAll();
    

}
