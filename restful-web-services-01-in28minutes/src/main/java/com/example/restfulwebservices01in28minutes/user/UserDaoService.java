package com.example.restfulwebservices01in28minutes.user;

import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Duke", new Date()));
        users.add(new User(2, "May", new Date()));
        users.add(new User(3, "Xuka", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User user: users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }
}
