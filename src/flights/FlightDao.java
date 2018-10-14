package flights;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import hibernate.hibernateDao;


public class FlightDao// throws FileNotFoundException 
{
	
	public static List<Flight> getAllFlights() throws Exception //throws FileNotFoundException
	{
		List<Flight> listofflights = null ;
		
		hibernateDao hb = new hibernateDao();
		
		listofflights = hb.getFlights();
		

		
		return listofflights;
		
		
	}
	
	public Flight getFlight(int id) {
		
		Flight flight = null;
		
		hibernateDao hb = new hibernateDao();
		
		flight = hb.getFlight(id);
		
		return flight; 
	}
	
	public String createFlight(InputStream is) throws JsonParseException, JsonMappingException, IOException {
		
		//Flight flight = readFlight(is);
		
		hibernateDao hb = new hibernateDao();
		
		return hb.createFlight(is);
		
	}
	public void deleteFlight(int id) {
		
		hibernateDao hb = new hibernateDao();
		
		hb.deleteFlight(id);
		
	}
	
}
