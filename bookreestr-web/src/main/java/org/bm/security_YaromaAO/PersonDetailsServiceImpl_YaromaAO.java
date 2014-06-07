package org.bm.security_YaromaAO;

import java.util.ArrayList;
import java.util.Collection;

import org.bm.model1.Person;
import org.bm.ui.bean_YaromaAO.PersonBean_YaromaAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsServiceImpl_YaromaAO implements UserDetailsService {
	@Autowired
	PersonBean_YaromaAO pb;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Person p = pb.get(username);
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		if (p.getIsAdmin())
			auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	
		return new PersonDetails_YaromaAO(username, p.getPassword(), p.getSalt(), auths);
	}	
}