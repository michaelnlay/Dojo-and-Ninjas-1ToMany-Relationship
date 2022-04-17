package com.ml.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ml.dojoninjas.models.Ninja;
import com.ml.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	//this is like dependency injection so we can use our ninja repository

    private final NinjaRepository ninjaRepo;
    
    
    //CONSTRUCTOR===============================================
    
    public NinjaService(NinjaRepository ninjaRepo) {
    	super();
    	this.ninjaRepo = ninjaRepo;
    }
    

    //FIND ALL Ninja FROM REPO
    public List<Ninja>allNinjas(){
    	return ninjaRepo.findAll();
    }
    

	//CREATE A Ninja FROM REPO
    public Ninja createNinja(Ninja ninja) {
    	return ninjaRepo.save(ninja);
    }
    

    //FIND ONE Ninja FROM REPO
    public Ninja findNinja(Long id) {
    	Optional<Ninja> optNinja = ninjaRepo.findById(id);
    	if(optNinja.isPresent()) {
    		return optNinja.get();
    		
    	}else {
    			return null;
    		}
    	}
    
    
    //DELETE A Ninja FROM REPO
    public void deleteNinja(Long id) {
    	ninjaRepo.deleteById(id);
    	
    }
    
    
    //UPDATE A Ninja FROM REPO
    public Ninja updateNinja(Ninja ninja) {
    	return ninjaRepo.save(ninja);
    }
    
}