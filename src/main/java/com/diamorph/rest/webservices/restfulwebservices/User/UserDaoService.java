package com.diamorph.rest.webservices.restfulwebservices.User;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {
    // JPA/Hibernate > Database
    // UserDaoService > Static List

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(String id) {
        Optional<User> foundUser = users.stream()
                .filter(user -> user.getId() == Integer.parseInt(id))
                .findFirst();
        return foundUser.orElse(null);
    }

    public User save(User user) {
        users.add(user);
        user.setId((int) users.stream().count());
        return user;
    }

    public void deleteById(String id) {
        users.removeIf(user -> user.getId() == Integer.parseInt(id));
    }

}
