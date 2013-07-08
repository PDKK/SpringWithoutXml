package org.knoxkennedy.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers()
    {
        return this.userRepository.getAllUsers();
    }
    
    public Integer createUser(User user)
    {
        return this.userRepository.createUser(user);
    }
}