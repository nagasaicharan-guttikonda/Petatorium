package com.petatorium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petatorium.model.Pets;
import com.petatorium.service.PetsService;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class PetsController {
	@Autowired
      PetsService ps;
    
	@PostMapping("/savePet")
	public Pets savePet(@RequestBody Pets p)
	{
		return ps.insertPets(p);
	}
	
	@PutMapping("/updatePet")
	public Pets updatePet(@RequestBody Pets p, int Id)
	{
		return ps.updatePets(p, Id);
	}
	
	@DeleteMapping("/deletePet")
	public boolean deletePet(@PathVariable int Id)
	{
		return ps.deletePet(Id);
	}
	
	@GetMapping("/getPet")
	public Pets getPetById(@PathVariable int id)
	{
		return ps.getPet(id);
	}
	
	@GetMapping("/getPets")
	public List<Pets> getPets()
	{
		return ps.getPets();
	}
}
