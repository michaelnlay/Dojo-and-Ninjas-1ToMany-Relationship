package com.ml.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ml.dojoninjas.models.Dojo;
import com.ml.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {

	 private final DojoRepository dojoRepo;
	 
	    //CONSTRUCTOR===============================================
	    
	    public DojoService(DojoRepository dojoRepo) {
			super();
			this.dojoRepo = dojoRepo;
		}
	    
	    //Find all the Dojos
	    public List<Dojo>allDojos(){
	    	return dojoRepo.findAll();
	    }
	    
	    //Create an Dojo
	    public Dojo createDojo(Dojo dojo) {
	    	return dojoRepo.save(dojo);
	    }
	 
	  //FIND ONE Dojo FROM REPO
	    public Dojo findDojo(Long id) {
	    	Optional<Dojo> optDojo = dojoRepo.findById(id);
	    	if(optDojo.isPresent()) {
	    		return optDojo.get();
	    		
	    	}else {
	    			return null;
	    		}
	    	}
	 
	 
	 
	  
}
