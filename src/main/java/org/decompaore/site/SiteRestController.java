package org.decompaore.site;


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
public class SiteRestController {
	
	@Autowired
	private SiteService siteService;
	
	//Ajouter un nouveau site
	@RolesAllowed("ADMIN")
	@PostMapping("/addSite")
	public ResponseEntity<Site> createNewSite(@RequestBody Site site){
		Site existingSite = siteService.getSiteByNom(site.getNom());
		if(existingSite != null) {
			return new ResponseEntity<Site>(HttpStatus.CONFLICT);
		}
		else
			siteService.addSite(site);
		return new ResponseEntity<Site>(HttpStatus.ACCEPTED);
					}
	
	//Modifier ou mise à d'un site
	@RolesAllowed("ADMIN")
	@PutMapping("/updateSite")
	public ResponseEntity<Site> updateSite(@RequestBody Long id){
		 
		 if(id != null) {
			 siteService.updateSite(id);
			 return new ResponseEntity<Site>(HttpStatus.ACCEPTED); 
		 }
		 else
		 return new ResponseEntity<Site>(HttpStatus.NOT_MODIFIED) ;
	}
	
	/**
	 * //Obtenir l'ensemble des sites
	@GetMapping("/sites")
	public List<Site> getSites(){
		return siteService.getAllSite();
				}
	
	@GetMapping("/bynom")
	public Site getSiteBynom(String nom) {
		return siteService.getSiteByNom(nom);
		
	}
	
	@GetMapping("/bytypo")
	public List<Site> getSiteByTypo(String typologie){
		return siteService.getSiteByTypo(typologie);
				}
	
	@GetMapping("/bytech")
	public List<Site> getSiteByTech(String technologie){
		return siteService.getSiteByTech(technologie);
	}
	
	@GetMapping("/byzem")
	public List<Site> getSiteByZem(String zem){
		return siteService.getSiteByZem(zem);
	}
	
	@GetMapping("/bytypeenergie")
	public List<Site> getSiteByTypeEnergie(String type){
		return siteService.getSiteByEnergieType(type);
	}
	
	@GetMapping("/byradioconfig")
	public List<Site> getSiteByRadioConfig(String config){
		return siteService.getSiteByConfigRadio(config);
	}
	
	@GetMapping("/byradiobase")
	public List<Site> getSiteByRadioBase(String base){
		return siteService.getSiteByBaseRadio(base);
				}
	@GetMapping("/byterrain")
	public List<Site> getSiteByPyloneTerrain(String terrain){
		return siteService.getSiteByPyloneTerrain(terrain);
	}
	
	@GetMapping("/bytranstype")
	public List<Site> getSiteByTypeTrans(String type){
		return siteService.getSiteByTransType(type);
	}
	
	@GetMapping("/bytranscap")
	public List<Site> getSiteByTransCap(String capacite){
		return siteService.getSiteByTransCap(capacite);
	}
	
	 * */
	
	

}
