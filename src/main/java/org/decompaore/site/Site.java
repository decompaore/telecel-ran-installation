package org.decompaore.site;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.decompaore.batterie.Batterie;
import org.decompaore.energie.Energie;
import org.decompaore.generateur.Generateur;
import org.decompaore.pylone.Pylone;
import org.decompaore.radio.Radio;
import org.decompaore.trans.Trans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Site {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String typologie;
	private String technologie;
	private String zem;
	private double latitude;
	private double longitude;
	
	@OneToOne
	private Batterie batterie;
	
	@OneToOne
	private Energie energie;
	
	@OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
	private List<Generateur> generateur;
	
	@OneToOne
	private Pylone pylone;
	
	@OneToOne
	private Radio radio;
	
	@OneToOne
	private Trans trans;
	
	

}