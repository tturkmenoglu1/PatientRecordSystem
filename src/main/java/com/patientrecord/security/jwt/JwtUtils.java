package com.patientrecord.security.jwt;

import com.patientrecord.exception.message.ErrorMessage;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("LCPatientRecord2023")
    private String jwtSecret;

    @Value("86400000")
    private long jwtExpirationMs;

    public String generateJwtToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).
                                                        setIssuedAt(new Date()).
                                                        setExpiration(new Date(new Date().getTime() + jwtExpirationMs)).
                                                        signWith(SignatureAlgorithm.HS512, jwtSecret).
                                                        compact();
    }

    public boolean validateJwtToken(String token) {
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException |
                SignatureException | IllegalArgumentException e ){
            logger.error(String.format(ErrorMessage.JWTTOKEN_ERROR_MESSAGE, e.getMessage()));
        }
        return false;
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
}
