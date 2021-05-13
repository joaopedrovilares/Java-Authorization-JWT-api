package auth.api.controller;


import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import auth.api.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
@RequestMapping("/api")
public class handlerLogin {

@CrossOrigin
@RequestMapping(value="/login",method=RequestMethod.POST)
public ResponseEntity <?> login(
	@RequestBody User user,
	@RequestHeader(value="tokkenHeader",defaultValue="0") String tokkenHeader){


try {
		String JWT =  createJWT("id","issuer","subject",345345);
		User loggedUser = new User("id", user.getUsername(), JWT);
		loggedUser.setJwt(JWT);
		loggedUser.setUsername(user.getUsername());
		
		return new ResponseEntity<User>(loggedUser,HttpStatus.OK);


	
}catch(Exception e){
	System.out.println("Exception");
	return new ResponseEntity<String>("Error on Login Server",HttpStatus.BAD_REQUEST);
}
}

public static String createJWT(String id, String issuer, String subject, long ttlMillis) {
	  
    //The JWT signature algorithm we will be using to sign the token
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    //We will sign our JWT with our ApiKey secret
    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("secret");
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    //Let's set the JWT Claims
    JwtBuilder builder = Jwts.builder().setId(id)
            .setIssuedAt(now)
            .setSubject(subject)
            .setIssuer(issuer)
            .signWith(signatureAlgorithm, signingKey);
  
    //if it has been specified, let's add the expiration
    if (ttlMillis > 0) {
        long expMillis = nowMillis + ttlMillis;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);
    }  
    //Builds the JWT and serializes it to a compact, URL-safe string
    return builder.compact();
}


}