package com.minejava.springmysqlexample.security.jwt;

import com.minejava.springmysqlexample.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("$(minejava.app.jwtSecret)")
    private String jwtSecret;

    @Value("$(minejava.app.jwtExpirationMs)")
    private String jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        Instant expiration = issuedAt.plus(3, ChronoUnit.MINUTES);
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
         return Jwts.builder()
                 .setSubject((userPrincipal.getUsername()))
                 .setIssuedAt(Date.from(issuedAt))
                 .setExpiration(Date.from(expiration))
                 //.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
                 .compact();
    }
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        }
        catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        }
        catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        }
        catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        }
        catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        }
        catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty!: {}", e.getMessage());
        }
        return false;
    }
}
