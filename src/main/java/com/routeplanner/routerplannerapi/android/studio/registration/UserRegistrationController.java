package com.routeplanner.routerplannerapi.android.studio.registration;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;


@RestController
    @RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
    public class UserRegistrationController {
        private final UserRegistrationService userRegistrationService;

        @PostMapping
        public void register(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
            userRegistrationService.register(authHeader);
        }

//        @GetMapping(path = "confirm")
//        public String confirm(@RequestParam("token") String token) {
//            return userRegistrationService.confirmToken(token);
//        }

    }

