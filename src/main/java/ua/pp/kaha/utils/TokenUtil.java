package ua.pp.kaha.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.Date;

/**
 * Created by kaha on 16.02.2017.
 */
public class TokenUtil {
    public static String getJWTString(String email, Date expires, Key key) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        if (email == null) {
            throw new NullPointerException("null email is illegal");
        }
        if (expires == null) {
            throw new NullPointerException("null expires is illegal");
        }
        if (key == null) {
            throw new NullPointerException("null key is illegal");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        String jwtString = Jwts
                .builder()
                .setIssuer("Jersey-Security-Basic")
                .setSubject(email)
                .setExpiration(expires)
                .setIssuedAt(new Date())
                .signWith(signatureAlgorithm, key)
                .compact();
        return jwtString;
    }

    public static boolean isValid(String token, Key key) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(token.trim());

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getName(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return claimsJws.getBody().getSubject();
        }
        return null;
    }

}
