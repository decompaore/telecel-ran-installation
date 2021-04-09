package org.decompaore.radio;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(path="radios")
@CrossOrigin(origins = "http://localhost:4200")
public interface RadioRepository extends JpaRepository<Radio, Long>{
	
	@RolesAllowed("TECHNICIEN")
	public List<Radio> findAll();
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/siteradio")
	public Radio findBySiteNomContainsIgnoreCase(@Param("nom") String nom);

}
