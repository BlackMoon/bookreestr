package org.bm.security;

import java.util.ArrayList;
import java.util.Collection;

import org.bm.model.Person;
import org.bm.ui.bean.PersonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsServiceImpl implements UserDetailsService {
	@Autowired
	PersonBean pb;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Person p = pb.get(username);
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		if (p.getIsAdmin())
			auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	
		return new PersonDetails(username, p.getPassword(), p.getSalt(), auths);
	}	
}