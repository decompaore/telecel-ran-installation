package org.decompaore.pylone;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(path="pylones")
@CrossOrigin(origins = "http://localhost:4200")
public interface PyloneRepository extends JpaRepository<Pylone, Long>{
	
	@RolesAllowed("TECHNICIEN")
	public List<Pylone> findAll();
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/sitepylone")
	public Pylone findBySiteNomContainsIgnoreCase(@Param("nom") String nom);

}
