/**
 * 
 */
package org.bm.controller_YaromaAO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.bm.service.person.PersonServiceBean_YaromaAO;
import org.bm.service.person.PersonServiceBean_YaromaAOServiceLocator;
import org.bm.service.person.PersonYaromaAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Black Moon
 *
 */
@Controller
@RequestMapping(value = {"/person"})
public class PersonController_YaromaAO extends BaseController_YaromaAO<PersonYaromaAO> {	
	
	private static final String ADDRESS = "http://localhost:8080/PersonServiceBean_YaromaAOService/PersonServiceBean_YaromaAO?wsdl";
	
	PersonServiceBean_YaromaAO pb;
	
	@PostConstruct
    public void init() {
		try {
			pb = new PersonServiceBean_YaromaAOServiceLocator().getPerson(new java.net.URL(ADDRESS));
			
		} 
		catch (Exception e) {			
			e.printStackTrace();
		}
    }
	
	// for UserDetailsService
	public PersonYaromaAO get(String username) throws RemoteException {
		return pb.getByLogin(username);
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Map<String, ?> deleteUser(@RequestParam int id){
		int result = 1;
		String msg = null;
		
		try
		{	
			pb.deletePerson(id);
		}
		catch (Exception e)
		{
			msg = e.getMessage();
			result = 0;
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("success", result);
		
		if (msg != null && !msg.isEmpty())
			map.put("message", msg);
		
		return map;
	}
	
	@RequestMapping("/get")
	public @ResponseBody Map<String, Object> get(@RequestParam int id) {
		
		int success = 1;
		String msg = null;	
		
		Map<String, Object> map = new HashMap<String, Object>();
		try
		{
			PersonYaromaAO p =  pb.getPerson(id);
			p.setPassword(null);
			p.setSalt(null);
			
			map.put("user", p);
		}
		catch (Exception e)
		{
			msg = e.getMessage();
			success = 0;
		}
		
		map.put("success", success);
		
		if (msg != null && !msg.isEmpty())
			map.put("message", msg);
		
		return map;
	}
	
	@Override
	@RequestMapping("/getall")
	public @ResponseBody Map<String, Object> getAll() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		items = new ArrayList<PersonYaromaAO>();		
		try {
			for (PersonYaromaAO p: pb.getAllPersons())
			{
				items.add(p);
			}
			
			map.put("page", 1);
			map.put("total", items.size());		
			map.put("records", items.size());
			map.put("rows", items);
		} 
		catch (RemoteException e) {			
			e.printStackTrace();
		}
		
		return map; 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, ?> updateUser(@RequestBody PersonYaromaAO p){
		int result = 1;
		String msg = null;		
		
		int id = 0;
		try
		{							
			if (p.getId() == 0)
				id = pb.addPerson(p);
			else
				pb.updatePerson(p);
		}
		catch (Exception e)
		{
			msg = e.getMessage();
			//result = 0;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", result);		
		
		if (id != 0)
			map.put("id", id);
		
		if (msg != null && !msg.isEmpty())
			map.put("message", msg);
		
		return map;
	}
}
