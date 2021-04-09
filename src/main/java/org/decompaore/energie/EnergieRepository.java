package org.decompaore.energie;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(path="energies")
@CrossOrigin(origins = "http://localhost:4200")
public interface EnergieRepository extends JpaRepository<Energie, Long>{
	
	@RolesAllowed("TECHNICIEN")
	public List<Energie> findAll();
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/siteenergie")
	public Energie findBySiteNomContainsIgnoreCase(@Param("nom") String nom);

}
