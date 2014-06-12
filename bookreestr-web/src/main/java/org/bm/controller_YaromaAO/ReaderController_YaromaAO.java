/**
 * 
 */
package org.bm.controller_YaromaAO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.bm.service.book.BookYaromaAO;
import org.bm.service.person.PersonYaromaAO;
import org.bm.service.reader.ReaderServiceBean_YaromaAO;
import org.bm.service.reader.ReaderServiceBean_YaromaAOServiceLocator;
import org.bm.service.reader.ReaderYaromaAO;
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
@RequestMapping(value = {"/reader"})
public class ReaderController_YaromaAO extends BaseController_YaromaAO<ReaderYaromaAO> {
	
	private static final String ADDRESS = "http://localhost:8080/ReaderServiceBean_YaromaAOService/ReaderServiceBean_YaromaAO?wsdl";
	
	ReaderServiceBean_YaromaAO rb;	
	
	@PostConstruct
    public void init() {		
		try {
			rb = new ReaderServiceBean_YaromaAOServiceLocator().getReader(new java.net.URL(ADDRESS));
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
    }
	
	@RequestMapping("/delete")
	public @ResponseBody Map<String, ?> deleteUser(@RequestParam int id){
		int result = 1;
		String msg = null;
		
		try
		{	
			rb.deleteReader(id);
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
			ReaderYaromaAO p =  rb.getReader(id);			
			
			map.put("reader", p);
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
			items = new ArrayList<ReaderYaromaAO>();
			for (ReaderYaromaAO r: rb.getAllReaders())
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
	
	@RequestMapping("/getreaders")
    public @ResponseBody List<Map<String, Object>> getReaders(@RequestParam(value = "id", defaultValue = "0") int id) {
		
		List<Map<String, Object>> l = new ArrayList<Map<String, Object>>();
		try
		{	
			if (id == 0)
			{
				for (ReaderYaromaAO r: rb.getAllReaders())
				{
					Map<String, Object> m = new HashMap<String, Object>();
					Map<String, Integer> a = new HashMap<String, Integer>();
									
					a.put("id", r.getId());
					m.put("attr", a);
					m.put("data", r.toString());
					m.put("state", "closed");
					
					l.add(m);				
				}
			}
		}
		catch(Exception e)
		{				
		}				
		return l;		
    }	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, ?> updateReader(@RequestBody ReaderYaromaAO r){
		int result = 1;
		String msg = null;		
		
		int id = 0;
		try
		{							
			if (r.getId() == 0)
				id = rb.addReader(r);
			else
				rb.updateReader(r);
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
