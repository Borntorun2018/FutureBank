package com.eBusiness.persist.entity.user;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

import com.eBusiness.util.StringUtil;

import javax.persistence.criteria.Predicate;

public class UserSpecificationBuilder {

	
	public Specification<User> find(User user){
		return (root, query, cb) -> {
			
	          List<Predicate> predicates = new ArrayList<>();
	          
	          if (!StringUtil.isEmpty(user.getSurname())) {
	              predicates.add(cb.equal(cb.upper(root.get("surname")), user.getSurname().toUpperCase()));
	          }
	          
	          if (!StringUtil.isEmpty(user.getForenames())) {
	              predicates.add(cb.equal(cb.upper(root.get("forenames")), user.getForenames().toUpperCase()));
	          }
	          
	          if (!StringUtil.isEmpty(user.getEmail())) {
	              predicates.add(cb.equal(cb.upper(root.get("email")), user.getEmail().toUpperCase()));
	          }
	          
	          if (!StringUtil.isEmpty(user.getHomeTelephoneNo())) {
	              predicates.add(cb.equal(root.get("homeTelephoneNo"), user.getHomeTelephoneNo()));
	          }
	          
	          if (!StringUtil.isEmpty(user.getMobileTelephoneNo())) {
	              predicates.add(cb.equal(root.get("mobileTelephoneNo"), user.getMobileTelephoneNo()));
	          }
	          
	          if (user.getTerminationDate() !=null) {
	              predicates.add(cb.lessThanOrEqualTo(root.get("terminationDate"), user.getTerminationDate()));
	          }
	          	          	          
	          Predicate[] p = predicates.toArray(new Predicate[predicates.size()]);
	          return p.length == 0 ? null : p.length == 1 ? p[0] : cb.and(p);
	      };
	}
}
