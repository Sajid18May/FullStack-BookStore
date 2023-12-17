package com.bookstore.amber.Security;

import com.bookstore.amber.Repo.CRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserinfoUserDetailService implements UserDetailsService {
    @Autowired
    CRepo cr;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return cr.findByEmail(username);
    }
}
