package org.decompaore;

import org.decompaore.batterie.Batterie;
import org.decompaore.batterie.BatterieRepository;
import org.decompaore.energie.Energie;
import org.decompaore.energie.EnergieRepository;
import org.decompaore.generateur.Generateur;
import org.decompaore.generateur.GenerateurRepository;
import org.decompaore.pylone.Pylone;
import org.decompaore.pylone.PyloneRepository;
import org.decompaore.radio.Radio;
import org.decompaore.radio.RadioRepository;
import org.decompaore.site.Site;
import org.decompaore.site.SiteRepository;
import org.decompaore.trans.Trans;
import org.decompaore.trans.TransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class TelecelRanAppApplication implements CommandLineRunner{
	
	@Autowired
	private BatterieRepository batterieRepository;
	
	@Autowired
	private  EnergieRepository energieReopsitory;
	
	@Autowired
	private GenerateurRepository generateurRepository;
	
	@Autowired
	private PyloneRepository pyloneRepository;
	
	@Autowired
	private RadioRepository radioRepository;
	
	@Autowired
	private TransRepository transRepository;
	
	
	@Autowired
	private SiteRepository siteReposiory;
	
	@Autowired
	 private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(TelecelRanAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
				//Exposition des IDs dans l'API REST
				
						repositoryRestConfiguration.exposeIdsFor(Batterie.class, Energie.class, Generateur.class,
								Pylone.class, Radio.class, Site.class, Trans.class);
						
						Batterie b1=batterieRepository.save(new Batterie(null, "Solaire","SODEC",24,null));
						Batterie b2=batterieRepository.save(new Batterie(null, "Backup","SAB",4,null));
						Batterie b3=batterieRepository.save(new Batterie(null, "Backup","SOLSTAR",8,null));
						
						Energie e1=energieReopsitory.save(new Energie(null, "Solaire","Solaire",null, "48 pwc",null));
						Energie e2=energieReopsitory.save(new Energie(null, "Sonabel","Secteur","group", "50w",null));
						Energie e3=energieReopsitory.save(new Energie(null, "Solaire","Solaire","group", "48 pwc",null));
						Energie e4=energieReopsitory.save(new Energie(null, "group","Secteur","Batterie", "50 w",null));
						Energie e5=energieReopsitory.save(new Energie(null, "Sonabel","Secteur","Batterie", "50 w",null));
						Energie e6=energieReopsitory.save(new Energie(null, "Group","Group","Group", "45 kva",null));
						
						Pylone p1=pyloneRepository.save(new Pylone(null,"Auto-stable","Telecel","70 m",null));
						Pylone p2=pyloneRepository.save(new Pylone(null,"Aubane","Telecel","80 m",null));
						Pylone p3=pyloneRepository.save(new Pylone(null,"Auto-stable","Onatel","90 m",null));
						Pylone p4=pyloneRepository.save(new Pylone(null,"Auto-stable","Orange","110 m",null));
						Pylone p5=pyloneRepository.save(new Pylone(null,"RoofTop","Telecel","80 m",null));
						Pylone p6=pyloneRepository.save(new Pylone(null,"Auto-stable","Etat","80 m",null));
						
						Radio r1=radioRepository.save(new Radio(null,"RBS6000","S444",null));
						Radio r2=radioRepository.save(new Radio(null,"RBS2100","S222",null));
						Radio r3=radioRepository.save(new Radio(null,"RBS1100","S111",null));
						Radio r4=radioRepository.save(new Radio(null,"eNodeB","S888",null));
						Radio r5=radioRepository.save(new Radio(null,"NodeB","S121212",null));
						
						Trans t1=transRepository.save(new Trans(null, "FH","4E1","Eclipse",null));
						Trans t2=transRepository.save(new Trans(null, "FH","2 Gigabyte","Aviat-CTR",null));
						Trans t3=transRepository.save(new Trans(null, "FH","5 Gigabyte","Aviat-WTM",null));
						Trans t4=transRepository.save(new Trans(null, "FO","5 Gigabyte","Nokia",null));
						
						Site s1=siteReposiory.save(new Site(null, "Koubri_A","Backbone","UMTS/LTE","Ouaga Sud",10.524,2.369,b3,e6,null,p1,r5,t2));
						Site s2=siteReposiory.save(new Site(null, "Koubri_B","Terminal","GSM900/1800","Ouaga Sud",10.6258,2.760,b2,e5,null,p3,r2,t3));
						Site s3=siteReposiory.save(new Site(null, "Kombissiri_A","Backbone","UMTS/LTE","Ouaga Sud",7.254,2.915,b2,e3,null,p2,r5,t2));
						Site s4=siteReposiory.save(new Site(null, "Zitenga","Terminal","GSM900/1800","Ouaga Nord",13.24,6.305,b1,e1,null,p4,r1,t1));
						Site s5=siteReposiory.save(new Site(null, "Yako_A","Backbone","GSM900/1800","Nord",21.13201,3.1069,b3,e5,null,p2,r1,t4));
						Site s6=siteReposiory.save(new Site(null, "Koumbia","Backbone","GSM900/1800","Ouest",300.5004,0.369,b3,e5,null,p1,r2,t1));
						Site s7=siteReposiory.save(new Site(null, "Bagata","Terminal","GSM900/1800","Sud",50.524,21.369,b1,e3,null,p6,r2,t2));
						Site s8=siteReposiory.save(new Site(null, "Kassou","Backbone","GSM900/1800","Ouaga Sud",10.524,2.369,b3,e5,null,p1,r2,t3));
						Site s9=siteReposiory.save(new Site(null, "Zabre","Backbone","GSM900/1800","Entre-Sud",12.1258,0.369,b3,e2,null,p2,r2,t1));
						Site s10=siteReposiory.save(new Site(null, "Tiebele","Terminal","GSM900/1800","Ouaga Sud",17.1254,21.369,b1,e3,null,p6,r2,t2));
						Site s11=siteReposiory.save(new Site(null, "Tanghin_Dassouri","Backbone","UMTS/LTE","Ouaga Ouest",11.624,0.369,b2,e5,null,p1,r5,t3));
						Site s12=siteReposiory.save(new Site(null, "Kokologho","Backbone","UMTS/LTE","Ouaga Ouest",14.524,6.0269,b3,e5,null,p2,r5,t2));
						
						generateurRepository.save(new Generateur(null,"SDMO","20 kva","2000 litre",s1));
						generateurRepository.save(new Generateur(null,"SDMO","20 kva","2000 litre",s1));
						generateurRepository.save(new Generateur(null,"SDMO","18 kva","1000 litre",s10));
						generateurRepository.save(new Generateur(null,"CATERPILAR","20 kva","2000 litre",s3));
						
						
	}

}
