package org.decompaore.batterie;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telecel-site")
public class BatterieRestController {
	
	@Autowired
	BatterieService batterieService;
	
	//Ajouter batterie
	@RolesAllowed("ADMIN")
	@PostMapping("/addBatterie")
	public ResponseEntity<Batterie> createNewBatterie(@RequestBody Batterie batterie) {
		Batterie existingBatterie = batterieService.addBatterie(batterie);
		if(existingBatterie != null)
			return new ResponseEntity<Batterie>(HttpStatus.CONFLICT);
		else
			batterieService.addBatterie(batterie);
		return new ResponseEntity<Batterie>(HttpStatus.ACCEPTED);
	}
	
	//Mettre à jour battérie
	@RolesAllowed("ADMIN")
	@PutMapping("updateBatterie")
	
	public ResponseEntity<Batterie> updateBatterie(@RequestBody Batterie batterie){
		batterieService.updateBatterie(batterie);
		return new ResponseEntity<Batterie>(HttpStatus.ACCEPTED);
	}

}
