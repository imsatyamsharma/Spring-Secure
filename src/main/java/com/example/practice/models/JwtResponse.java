package com.example.practice.models;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private String id;
    private String jwttoken;
    private String username;
    private List<String> roles;

    public String getJwttoken() {
        return jwttoken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setJwttoken(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public JwtResponse(String accessToken, String id, String username, List<String> roles) {
        this.jwttoken = accessToken;
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return this.jwttoken;
    }
}