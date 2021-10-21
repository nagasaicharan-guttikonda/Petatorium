package com.petatorium.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petatorium.model.Pets;
import com.petatorium.repository.PetsRepository;

@Service
public class PetsService {
	@Autowired
 PetsRepository pr;
 
	public Pets insertPets(Pets p)
	{
		return pr.save(p);
	}
	public Pets updatePets(Pets p, int Id)
	{
		Pets pet = pr.getById(Id);
		if(p.isVaccinated() != false) pet.setVaccinated(p.isVaccinated());
		if(p.getPetName() != null) pet.setPetName(p.getPetName());
		if(p.getPetBreed() != null) pet.setPetBreed(p.getPetBreed());
		return pr.save(pet);
	}
	public Pets getPet(int Id)
	{
		return pr.findById(Id).get();
	}
	public boolean deletePet(int Id)
	{
		boolean deleted = false;
		if(pr.findById(Id).get() != null)
		{
		      pr.deleteById(Id);
		      deleted = true;
		}
		return deleted;
	}
	
	public List<Pets> getPets()
	{
	    return pr.findAll();
	}
}
