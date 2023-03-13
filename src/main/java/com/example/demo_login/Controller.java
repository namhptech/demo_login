package com.example.demo_login;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/bifiin")
public class Controller {
    @GetMapping("/sign-in-google")
    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        System.out.println(toPerson(oAuth2AuthenticationToken.getPrincipal().getAttributes()).getEmail());
        System.out.println(toPerson(oAuth2AuthenticationToken.getPrincipal().getAttributes()).getName());
        System.out.println(toPerson(oAuth2AuthenticationToken.getPrincipal().getAttributes()).getPicture());
        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }
    public Root toPerson(Map<String, Object> map) {
        if(map == null) {
            return null;
        }
        Root root = new Root();
       root.setEmail((String) map.get("email"));
       root.setName((String) map.get("name"));
       root.setPicture((String) map.get("picture"));
        return root;
    }
}
