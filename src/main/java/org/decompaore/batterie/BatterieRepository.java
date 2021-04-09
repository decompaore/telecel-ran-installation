package org.decompaore.batterie;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path="batteries")
@CrossOrigin(origins = "http://localhost:4200")
public interface BatterieRepository extends JpaRepository<Batterie, Long>{
	@RolesAllowed("TECHNICIEN")
	public List<Batterie> findAll();
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/sitebatterie")
	public Batterie findBySiteNomContainsIgnoreCase(@Param("nom") String nom);

	//public Batterie save(Long id);

}
