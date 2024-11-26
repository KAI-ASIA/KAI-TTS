package sb.locnv.w8.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sb.locnv.w8.entity.CustomUserDetails;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtTokenService {

    private String secretKey = "";

    public JwtTokenService(){
        try{
            KeyGenerator key = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey1 = key.generateKey();
            secretKey = Base64.getEncoder().encodeToString(secretKey1.getEncoded());
            System.out.println(secretKey);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public String generateToken(String username){
        String token = Jwts
                .builder()
                .claims()
                .add(new HashMap<>())
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .and()
                .signWith(createKey())
                .compact();
        return token;
    }

    private Key createKey(){
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().verifyWith((SecretKey) createKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername());
    }

}
