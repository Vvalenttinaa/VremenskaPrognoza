package com.example.vremenskaprognoza.Zaposleni;

import java.net.*;
import java.util.*;

public final class UserSession {

    private static UserSession instance;

    private String userName;
    private Set<String> privileges;
    private static Integer id;

    private UserSession(Integer id){
        this.id=id;
    }

    private UserSession(String userName, Set<String> privileges) {
        this.userName = userName;
        this.privileges = privileges;
    }

    public static UserSession getInstace(Integer id) {
        if(instance == null) {
            instance = new UserSession(id);
        }
        return instance;
    }

    public static UserSession getInstace(String userName, Set<String> privileges) {
        if(instance == null) {
            instance = new UserSession(userName, privileges);
        }
        return instance;
    }

    public static Integer getId(){
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Set<String> getPrivileges() {
        return privileges;
    }

    public void cleanUserSession() {
        userName = "";// or null
        privileges = new HashSet<>();// or null
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}
