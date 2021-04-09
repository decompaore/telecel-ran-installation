package org.decompaore.trans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telecel-site")
public class TransRestController {
	
	@Autowired
	private TransRepository transRepository;
	
	@GetMapping("/transes")
	public List<Trans> getAllTrans(){
		return transRepository.findAll();
				}
	
	@GetMapping("/siteTrans")
	public ResponseEntity<Trans> getTransBySite(@PathVariable(value="nom") String nom){
		
		Trans trans = transRepository.findBySiteNomContainsIgnoreCase(nom);
		
		return ResponseEntity.ok().body(trans);
	}
	@RolesAllowed("ADMIN")
	@PostMapping("/transes")
	public Trans CreateNewTrans(@Validated @RequestBody Trans trans) {
		return transRepository.save(trans);
	}
	@RolesAllowed("ADMIN")
	@PutMapping("/transes/{id}")
	public ResponseEntity<Trans> updateTrans(@PathVariable(value="id") Long id, @Validated @RequestBody Trans trans)
	throws ResourceNotFoundException{
		Trans tr = transRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pas de tarns ayant l'Id::"+ id));
		
		tr.setType(trans.getType());
		tr.setCapacite(trans.getCapacite());
		tr.setConstructeur(trans.getConstructeur());
		
		final Trans updateTrans = transRepository.save(trans);
	return ResponseEntity.ok(updateTrans);
	}
	
	@RolesAllowed("ADMIN")
	@DeleteMapping("/transes/{id}")
	 public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id)
	         throws ResourceNotFoundException {
	        Trans trans = transRepository.findById(id)
	       .orElseThrow(() -> new ResourceNotFoundException("Il existe pas de trans ayant l'id :: " + id));

	        transRepository.delete(trans);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("supprimée", Boolean.TRUE);
	        return response;
	    }

}
