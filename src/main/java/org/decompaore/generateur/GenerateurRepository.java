package org.decompaore.generateur;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(path="generateurs")
@CrossOrigin(origins = "http://localhost:4200")
public interface GenerateurRepository extends JpaRepository<Generateur, Long>{
	
	@RolesAllowed("TECHNICIEN")
	public List<Generateur> findAll();
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/sitegenerateur")
	public List<Generateur> findBySiteNom(@Param("nom") String nom);
	
	
}
