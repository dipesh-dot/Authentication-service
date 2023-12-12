package com.authenticationservice.service;




import com.authenticationservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


     User create(User user);
     User getById(Long id);
     List<User> getAll();

}
