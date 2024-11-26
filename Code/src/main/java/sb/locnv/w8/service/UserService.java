package sb.locnv.w8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import sb.locnv.w8.entity.Users;

@Service
public class UserService {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(Users users){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPwd()));
        if(authentication.isAuthenticated()){
            return jwtTokenService.generateToken(users.getUsername());
        }else{
            return "Error generate token";
        }
    }

}
