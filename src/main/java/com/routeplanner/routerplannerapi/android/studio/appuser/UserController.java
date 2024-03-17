package com.routeplanner.routerplannerapi.android.studio.appuser;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
    public class UserController {
        private final UserService userService;

        @PostMapping("/registration")
        public ResponseEntity<String> register(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
            return userService.register(authHeader);
        }

        @PostMapping("/login")
        public void register(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        return userService.register(authHeader);
        }

//        @GetMapping(path = "confirm")
//        public String confirm(@RequestParam("token") String token) {
//            return userRegistrationService.confirmToken(token);
//        }

    }

