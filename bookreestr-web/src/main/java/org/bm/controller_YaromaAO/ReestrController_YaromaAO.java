/**
 * 
 */
package org.bm.controller_YaromaAO;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.rpc.ServiceException;

import org.bm.service.book.BookYaromaAO;
import org.bm.service.person.PersonServiceBean_YaromaAO;
import org.bm.service.person.PersonServiceBean_YaromaAOServiceLocator;
import org.bm.service.person.PersonYaromaAO;
import org.bm.service.reestr.ReestrServiceBean_YaromaAO;
import org.bm.service.reestr.ReestrServiceBean_YaromaAOServiceLocator;
import org.bm.service.reestr.ReestrYaromaAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Black Moon
 *
 */
@Controller
@RequestMapping(value = {"/", "/reestr"})
public class ReestrController_YaromaAO extends BaseController_YaromaAO<ReestrYaromaAO> {
	
	private static final String ADDRESS = "http://localhost:8080/ReestrServiceBean_YaromaAOService/ReestrServiceBean_YaromaAO?wsdl";
	
	ReestrServiceBean_YaromaAO rb;
	
	@PostConstruct
    public void init() {		
		try {
			rb = new ReestrServiceBean_YaromaAOServiceLocator().getReestr(new java.net.URL(ADDRESS));
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
    }	
	
	@RequestMapping(value = {"", "/index"})
    public String index() {
		return "reestr";
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Map<String, ?> deleteUser(@RequestParam int id){
		int result = 1;
		String msg = null;
		
		try
		{	
			rb.deleteReestr(id);
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
			ReestrYaromaAO r =  rb.getReestr(id);			
			
			map.put("reestr", r);
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
	
	@RequestMapping("/getall")
    public @ResponseBody Map<String, Object> getAll() 
    {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try
		{
			items = new ArrayList<ReestrYaromaAO>();
			for (ReestrYaromaAO r: rb.getAllReestrs())
			{
				items.add(r);
			}			
		} 
		catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
		map.put("page", 1);
		map.put("total", items.size());		
		map.put("records", items.size());
		map.put("rows", items);
		
		return map;
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, ?> updatesubject(@RequestBody ReestrYaromaAO r){
		int result = 1;
		String msg = null;		
		
		int id = 0;
		try
		{							
			if (r.getId() == 0)
				id = rb.addReestr(r);
			else
				rb.updateReestr(r);
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
