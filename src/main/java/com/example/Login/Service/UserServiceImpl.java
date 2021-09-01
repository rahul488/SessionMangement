package com.example.Login.Service;

import com.example.Login.Entity.User;
import com.example.Login.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =userRepo.findByEmail(username);

        if(user == null)
            throw new UsernameNotFoundException("User not found...");

        return new UserPrinciple(user);
    }

}
