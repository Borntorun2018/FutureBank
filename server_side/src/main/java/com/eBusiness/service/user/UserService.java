package com.eBusiness.service.user;


import java.util.List;

import com.eBusiness.persist.entity.user.User;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
