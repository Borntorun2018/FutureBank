package com.eBusiness.util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralUtil {
	
     public static void deleteRole (List<Role> allRoles, Role userRole) {
    	 allRoles.removeIf( i -> {
		    	return i.getName().equals(userRole.getName());
		 });
     }
    
	public static void main(String[] args){
		 List<Role> userRoles=	 Arrays.asList(new  Role("Role1"), new  Role("Role4"));
		 //List<Role> allRoles=	 Arrays.asList(new  Role("Role1"), new  Role("Role2"),new  Role("Role3"), new  Role("Role4"));
		 
		 List<Role> allRoles = new ArrayList<Role>();
		 allRoles.add(new Role("Role3")); 
		 allRoles.add(new Role("Role2"));
		 allRoles.add(new Role("Role1"));
		 allRoles.add(new Role("Role4"));
				 
		 userRoles.forEach(userRole->deleteRole(allRoles,userRole));
		 allRoles.forEach(role->System.out.println(role.getName()));
	}
}
class Role{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role(String name){
		this.name= name;
	}
}