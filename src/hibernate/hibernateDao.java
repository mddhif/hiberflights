package hibernate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.TypedQuery;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import flights.Flight;
//import net.projectmonkey.object.mapper.ObjectMapper;

public class hibernateDao {

public static Session init() {

SessionFactory sf = null;
		
		Session ss = null;
		 
		
			Configuration config = new Configuration();
			
			config.configure("hibernate.cfg.xml");
			config.addClass(Flight.class);
			
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			
			sf = config.buildSessionFactory(sr);
			
			ss = sf.openSession();
			
			return ss;

}

		
	
	
	
	public List<Flight> getFlights() throws Exception {
		List<Flight> listofflights = null; 
		
		
		
	Session	ss   =  init();
			
			ss.beginTransaction();
		
		
		
		
		TypedQuery<Flight> qr =  ss.createQuery("from Flight");
		
		
		System.out.println("after typedquery");
		listofflights = qr.getResultList(); 
		System.out.println("after queryresult");
		return listofflights;
		
	//}
		//catch(Exception e) {
			//if(ss.beginTransaction().isActive()) {ss.beginTransaction().rollback();}
			
	//	}
		
		//return listofflights;
	}
	
	public Flight getFlight(int id) {
		
		Flight flight = null;
        
		Session ss = init();
		
		ss.beginTransaction();
		
		TypedQuery<Flight> qr = ss.createQuery("from Flight where id = :id");
		
		qr.setParameter("id", id);
		
		flight = qr.getSingleResult();
		
		return flight;
		
		
	}
	
	
	public String createFlight(InputStream is) throws JsonParseException, JsonMappingException, IOException {
		
		Flight flight = readFlight(is);
		
		Session ss = init();
			
			ss.beginTransaction();
			
		ss.save(flight);
		
		ss.getTransaction().commit();
		
		return "success";
	}

	
	public Flight readFlight(InputStream is) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
	
		
		Flight flight = mapper.readValue(is, Flight.class);
		
		return flight ;
		
	}
	
	public void deleteFlight(int id) {
		
		Session ss = init();
		
		ss.beginTransaction();
		
		Flight flight = ss.load(Flight.class, id);
		
		ss.delete(flight);
		
		ss.getTransaction().commit();
		
		
	}
}
