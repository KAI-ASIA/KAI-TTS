package sb.locnv.w8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sb.locnv.w8.entity.CustomUserDetails;
import sb.locnv.w8.entity.Users;
import sb.locnv.w8.repository.UserRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException("username not found :" + username);
        }
        return new CustomUserDetails(users);
    }
}
