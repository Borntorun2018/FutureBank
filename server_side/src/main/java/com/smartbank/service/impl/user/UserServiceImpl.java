package com.smartbank.service.impl.user;

import com.smartbank.dao.UserDao;
import com.smartbank.persist.entity.user.User;
import com.smartbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		//System.out.println("*********Inside loadUserByUsername*************");
		//user.getRoles().forEach(role->System.out.println(role.getName()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}
	private List<SimpleGrantedAuthority> getAuthority(User user) {
		ArrayList<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		user.getRoles().forEach(role->roles.add(new SimpleGrantedAuthority(role.getName())));
		return roles;
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		return userDao.findOne(id);
	}

	@Override
    public User save(User user) {
        return userDao.save(user);
    }
}
