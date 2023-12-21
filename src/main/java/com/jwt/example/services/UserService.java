package com.jwt.example.services;

import com.jwt.example.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store = new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(), "Sandesh Bhujbal", "bhujbalsandesh52@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "harshal patel", "harsh@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "Akshay paawan", "aksh@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "sanket Tamhane", "sanket10@gmail.com"));
    }
   public List<User> getUsers() {
       return this.store;
   }

}
