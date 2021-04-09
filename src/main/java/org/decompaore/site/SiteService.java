package org.decompaore.site;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class SiteService {
	
	@Autowired
	private SiteRepository siteRepository;
	
	public Site getSiteByNom(String nom) {
		return siteRepository.findByNomContainsIgnoreCase(nom);
	}
	
	public Optional<Site> getSiteById(Long id) {
		return siteRepository.findById(id);
	}
	
	public List<Site> getAllSite(){
		return siteRepository.findAll();
	}
	
	public List<Site> getSiteByTypo(String typologie){
		return siteRepository.findByTypologieContainsIgnoreCase(typologie);
	}
	
	public List<Site> getSiteByTech(String technologie){
		return siteRepository.findByTechnologieContainsIgnoreCase(technologie);
	}
	
	public List<Site> getSiteByZem(String zem){
		return siteRepository.findByZemContainsIgnoreCase(zem);
	}
	
	public List<Site> getSiteByConfigRadio(String config){
		return siteRepository.findByRadioConfigContainsIgnoreCase(config);
	}
	
	public List<Site> getSiteByBaseRadio(String base){
		return siteRepository.findByRadioBaseContainsIgnoreCase(base);
	}
	
	public List<Site> getSiteByEnergieType(String type){
		return siteRepository.findByEnergieTypeContainsIgnoreCase(type);
	}
	
	public List<Site> getSiteByPyloneTerrain(String terrain){
		return siteRepository.findByPyloneTerrainContainsIgnoreCase(terrain);
	}
	
	public List<Site> getSiteByTransType(String type){
		return siteRepository.findByTransTypeContainsIgnoreCase(type);
	}
	
	public List<Site> getSiteByTransCap(String capacite){
		return siteRepository.findByTransCapaciteContainsIgnoreCase(capacite);
	}
	
	public List<Site> getSiteByConstructeur(String constructeur){
		return siteRepository.findByTransConstructeurContainsIgnoreCase(constructeur);
	}
	
	public void deleteSite(Long id) {
		siteRepository.deleteById(id);
	}
	
	public Site addSite(Site site) {
		Site savedSite = siteRepository.save(site);
		return savedSite;
	}
	
	public Site updateSite(Long id) {
		Site savedSite = siteRepository.save(id);
		return savedSite;
	}

	
		
	}


