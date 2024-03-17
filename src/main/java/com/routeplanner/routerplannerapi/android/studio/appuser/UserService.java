package com.routeplanner.routerplannerapi.android.studio.appuser;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<String> register(String authorization) {
        if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            AppUser user = userRepository.save(new AppUser(UUID.randomUUID(), "email", values[0], values[1], LocalDateTime.now()));
            return new ResponseEntity<String>(user.id.toString(), HttpStatus.OK);


        } else return new ResponseEntity<String>("registration failed, username and password required", HttpStatus.UNAUTHORIZED);
    }


}
