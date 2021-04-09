package org.decompaore.trans;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface TransRepository extends JpaRepository<Trans, Long>{
	
	@RolesAllowed("TECHNICIEN")
	public List<Trans> findAll();
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/sitetrans")
	public Trans findBySiteNomContainsIgnoreCase(@Param("nom") String nom);

}
