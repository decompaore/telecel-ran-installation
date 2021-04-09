package org.decompaore.batterie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class BatterieService {
	
	@Autowired
	BatterieRepository batterieRepository;
	
	public Batterie getSiteBatterie( String nom) {
		return batterieRepository.findBySiteNomContainsIgnoreCase(nom);
		
	}
	
	public Batterie addBatterie(Batterie batterie) {
		Batterie savedBatterie = batterieRepository.save(batterie);
		return savedBatterie;
	}
	
	public Batterie updateBatterie(Batterie batterie) {
		Batterie savedBatterie = batterieRepository.save(batterie);
		return savedBatterie;
	}

}
