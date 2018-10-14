package flights;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;


@Path("/FlightService")
public class FlightService {

	FlightDao flightDao = new FlightDao();
	
	@GET
	@Path("/flights")
	@Produces({MediaType.APPLICATION_JSON})
	
	public List<Flight>  getFlights() throws Exception{
		
		
		return flightDao.getAllFlights();
	}
	
	
	@GET
	@Path("/flights/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	
	public Flight getFlight(@PathParam("id") int id) {
		
		return flightDao.getFlight(id);
	}
	
	
	@POST
	@Path("/flights/")
	@Consumes({MediaType.APPLICATION_JSON})
	
	public String createFlight(InputStream is) throws JsonParseException, JsonMappingException, IOException {
		
		return flightDao.createFlight(is);
		
		
	}
	
	@DELETE
	@Path("/flights/{id}")
	
	public void deleteFlight(@PathParam("id") int id) {
		
		flightDao.deleteFlight(id);
		
	}
	
}
