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

import org.bm.service.person.PersonYaromaAO;
import org.bm.service.subject.SubjectServiceBean_YaromaAO;
import org.bm.service.subject.SubjectServiceBean_YaromaAOServiceLocator;
import org.bm.service.subject.SubjectYaromaAO;
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
@RequestMapping(value = {"/subject"})
public class SubjectController_YaromaAO extends BaseController_YaromaAO<SubjectYaromaAO> {
	
	private static final String ADDRESS = "http://localhost:8080/SubjectServiceBean_YaromaAOService/SubjectServiceBean_YaromaAO?wsdl";
	
	SubjectServiceBean_YaromaAO sb;	
	
	@PostConstruct
    public void init() {		
		try {
			sb = new SubjectServiceBean_YaromaAOServiceLocator().getSubject(new java.net.URL(ADDRESS));
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
			sb.deleteSubject(id);
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
			SubjectYaromaAO s =  sb.getSubject(id);			
			
			map.put("subject", s);
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
			items = new ArrayList<SubjectYaromaAO>();
			for (SubjectYaromaAO r: sb.getAllSubjects())
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
	
	@RequestMapping("/getsubjects")
    public @ResponseBody List<Map<String, Object>> getSubjects(@RequestParam(value = "id", defaultValue = "0") int id) {
		
		List<Map<String, Object>> l = new ArrayList<Map<String, Object>>();
		try
		{	
			if (id == 0)
			{
				for (SubjectYaromaAO s: sb.getAllSubjects())
				{
					Map<String, Object> m = new HashMap<String, Object>();
					Map<String, Integer> a = new HashMap<String, Integer>();
									
					a.put("id", s.getId());
					m.put("attr", a);
					m.put("data", s.getName());
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
	public @ResponseBody Map<String, ?> updatesubject(@RequestBody SubjectYaromaAO s){
		int result = 1;
		String msg = null;		
		
		int id = 0;
		try
		{							
			if (s.getId() == 0)
				id = sb.addSubject(s);
			else
				sb.updateSubject(s);
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
