package com.jiwhiz.example.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiwhiz.example.domain.UserProfile;

@Controller
public class UserRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
    
    @RequestMapping(method = RequestMethod.GET, value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<UserProfile> getCurrentUserProfile() {
        LOGGER.debug("==>UserRestController.getCurrentUserProfie()");
        UserProfile profile = new UserProfile("Yuan", "yuan@jiwhiz.com");
        return new ResponseEntity<UserProfile>(profile, HttpStatus.OK);
    }

}
