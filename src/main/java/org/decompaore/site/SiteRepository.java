package org.decompaore.site;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RestResource;
//import org.springframework.stereotype.Repository;

//@RepositoryRestResource
@RepositoryRestResource(path="sites")
@CrossOrigin(origins = "http://localhost:4200")
public interface SiteRepository extends JpaRepository<Site, Long>{
	
	//@RolesAllowed("USER")
	public List<Site> findAll();
	
	@RolesAllowed("USER")
	@RestResource(path="/bynom")
	public Site findByNomContainsIgnoreCase(@Param("nom") String nom);
	
	@RolesAllowed("USER")
	@RestResource(path="/bytypo")
	public List<Site> findByTypologieContainsIgnoreCase(@Param("typo") String typologie);
	
	@RolesAllowed("USER")
	@RestResource(path="/bytech")
	public List<Site> findByTechnologieContainsIgnoreCase(@Param("tech") String technologie);
	
	@RolesAllowed("USER")
	@RestResource(path="/byzem")
	public List<Site> findByZemContainsIgnoreCase(@Param("zem") String zem);
	
	@RolesAllowed("USER")
	@RestResource(path="/byterrain")
	public List<Site> findByPyloneTerrainContainsIgnoreCase(@Param("terrain") String terrain);
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/byradioconfig")
	public List<Site> findByRadioConfigContainsIgnoreCase(@Param("config") String config);
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/byradiobase")
	public List<Site> findByRadioBaseContainsIgnoreCase(@Param("base") String base);
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/byenergietype")
	public List<Site> findByEnergieTypeContainsIgnoreCase(@Param("type") String type);
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/bytranstype")
	public List<Site> findByTransTypeContainsIgnoreCase(@Param("type") String type);
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/bytranscap")
	public List<Site> findByTransCapaciteContainsIgnoreCase(@Param("cap") String capacite);
	
	@RolesAllowed("TECHNICIEN")
	@RestResource(path="/bytransconstructeur")
	public List<Site> findByTransConstructeurContainsIgnoreCase(@Param("constructeur")  String constructeur);

	public Site save(Long id);
	

}
