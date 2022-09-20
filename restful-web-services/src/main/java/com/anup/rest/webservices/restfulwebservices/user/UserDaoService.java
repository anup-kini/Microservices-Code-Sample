package com.anup.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	 private static List<User> users = new ArrayList<User>();
	 private static Integer usersCount = 0;
	 static {
		 users.add(new User(++usersCount,"Adam",LocalDate.now().minusYears(30)));
		 users.add(new User(++usersCount,"Eve",LocalDate.now().minusYears(25)));
		 users.add(new User(++usersCount,"Jim",LocalDate.now().minusYears(20)));
	 }
	 
	 public List<User> findAll(){
		 return users;
	 }
	 
	 public User findOne(Integer id) {
		 
		  return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
	 }
	 
	 public User save(User user) {
		 user.setId(++usersCount);
		 users.add(user);
		 return user;
	 }
	 
	 public User deleteById(Integer id) {
		 
		  User user = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		  users.removeIf(u -> u.getId().equals(id));
		  
		  return user;
		  
	 }
}
