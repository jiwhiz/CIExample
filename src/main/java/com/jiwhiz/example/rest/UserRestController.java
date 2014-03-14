package com.jiwhiz.example.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiwhiz.example.domain.UserProfile;

@Controller
public class UserRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
    
    @RequestMapping(method = RequestMethod.GET, value = "/api/user", produces = "application/hal+json")
    public HttpEntity<Resource<UserProfile>> getCurrentUserProfile() {
        LOGGER.debug("==>UserRestController.getCurrentUserProfie()");
        UserProfile profile = new UserProfile("Yuan", "yuan@jiwhiz.com");
        Resource<UserProfile> resource = new Resource<UserProfile>(profile);
        resource.add(linkTo(methodOn(UserRestController.class).getCurrentUserProfile()).withSelfRel());
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

}
